package Item.CreateAndStorage.Spells;

import Item.Systems.SpellSouls;
import com.rosa.serverplugin.Main;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.Objects;

import static Item.SpecialEffects.MeleeCheckers.ItemChecker.itemLoreChecker;

public class FireballSpell implements Listener {

    @EventHandler
    public void onFireball (PlayerInteractEvent e)  {

        Player player = e.getPlayer();
        ItemStack itemInMainHand = player.getInventory().getItemInMainHand();
        ItemStack itemInOffHand = player.getInventory().getItemInOffHand();
        World world = player.getWorld();

        // check if the player right-clicked and not left-click
        if (e.getAction() != Action.RIGHT_CLICK_AIR && e.getAction() != Action.RIGHT_CLICK_BLOCK)   { return;}

        // check if both hands don't have Fireball
        if (!(itemInMainHand.getType() == Material.ENCHANTED_BOOK || itemInOffHand.getType() == Material.ENCHANTED_BOOK))  { return;}

        if ((itemLoreChecker(itemInMainHand.getItemMeta(), "§5§oSent the master wizard into") ||
            itemLoreChecker(itemInOffHand.getItemMeta(), "§5§oSent the master wizard into")))   {
            // if the player has no spell soul
            if (!(SpellSouls.getSoulStatus(player)))    { return;}

            world.playSound(player.getLocation(), Sound.ENTITY_BLAZE_SHOOT, 1.0f, 1.0f);
            SpellSouls.useSoul(player);
            SpellSouls.rechargeSoul(player);
            Fireball fireball = player.launchProjectile(Fireball.class, player.getLocation().getDirection().multiply(1.5));
            PersistentDataContainer fireballData = fireball.getPersistentDataContainer();
            fireballData.set(new NamespacedKey(Main.getPlugin(Main.class), "Fireball"), PersistentDataType.STRING, "Fireball Spell");
            fireball.setYield(4.0f);
        }
    }

    @EventHandler
    public void onFireballSpellHit (EntityDamageByEntityEvent e)    {
        EntityType type = e.getDamager().getType();

        System.out.println("fire");

        // check if the damager is a fireball
        if (!(type.equals(EntityType.FIREBALL)))   {
            System.out.println("return");
            return;
        }
        Entity entity = e.getDamager();
        PersistentDataContainer entityData = entity.getPersistentDataContainer();
        System.out.println("1");
        double damage;

        // check if the fireball is custom
        if (!(entityData.has(new NamespacedKey(Main.getPlugin(Main.class), "Fireball"), PersistentDataType.STRING)))    {
            System.out.println("return");
            return;
        }
        System.out.println("2");

        // check if the fireball is the fireball from FireballSpell
        if (!(Objects.equals(entityData.get(new NamespacedKey(Main.getPlugin(Main.class), "Fireball"), PersistentDataType.STRING), "Fireball Spell")))  {
            System.out.println("return");
            return;
        }

        System.out.println("3");
        damage = e.getDamage();
        damage *= 0.6;
        e.setDamage(damage);

    }

}
