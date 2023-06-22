package Item.SpecialEffects.SpecialDefenseEffects;

import com.rosa.serverplugin.Main;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;

import static Item.SpecialEffects.MeleeCheckers.ItemChecker.itemLoreChecker;
import static Item.SpecialEffects.MeleeCheckers.PlayerMeleePlayerChecker.playerMeleePlayerChecker;


public class AnciliaEffect implements Listener {

    @EventHandler
    public void onAnciliaBlock (EntityDamageByEntityEvent e)    {
        Player attacker;
        Player defender;
        ItemMeta defenderShield;
        Material attackerItem;
        EquipmentSlot handHoldingUpAncilia;

        // check if both entities are players
        if (!(playerMeleePlayerChecker(e.getEntity(), e.getDamager(), e.getCause())))  { return;}

        attacker = (Player) e.getDamager();
        defender = (Player) e.getEntity();

        if (attacker.getCooldown(Material.DIAMOND_SWORD) > 0)   {
            e.setCancelled(true);
        }

        if (!(defender.isBlocking()))  { return;}
        if(!(e.getCause() == EntityDamageEvent.DamageCause.ENTITY_ATTACK))   { return;}

        attackerItem = attacker.getInventory().getItemInMainHand().getType();
        defenderShield = defender.getActiveItem().getItemMeta();

        if (itemLoreChecker(defenderShield, "§5§oSacred shield from the Temple") &&
                (attackerItem == Material.DIAMOND_SWORD ||
                        attackerItem == Material.IRON_SWORD ||
                        attackerItem == Material.NETHERITE_SWORD ||
                        attackerItem == Material.GOLDEN_SWORD ||
                        attackerItem == Material.STONE_SWORD ||
                        attackerItem == Material.WOODEN_SWORD)) {
            if (attacker.getCooldown(Material.DIAMOND_SWORD) == 0)  {
                attacker.setCooldown(Material.DIAMOND_SWORD, 50);
            }

            World world = e.getEntity().getWorld();
            world.playSound(defender.getLocation(), Sound.ENTITY_LIGHTNING_BOLT_IMPACT, 1.0f, 1.0f);
            defender.getWorld().spawnParticle(Particle.SONIC_BOOM, defender.getLocation().add(0, 1,0 ), 0);

            ArrayList<Integer> slots = new ArrayList<Integer>();
            ArrayList<ItemStack> shields = new ArrayList<ItemStack>();

            //if both slots are shields
            if (defender.getInventory().getItemInMainHand().getType().equals(Material.SHIELD) && defender.getInventory().getItemInOffHand().getType().equals(Material.SHIELD)) {
                slots.add(defender.getInventory().getHeldItemSlot());
                slots.add(40);

                shields.add(defender.getInventory().getItemInMainHand());
                shields.add(defender.getInventory().getItemInOffHand());
            } else {
                slots.add((defender.getInventory().getItemInMainHand().getType().equals(Material.SHIELD)) ? defender.getInventory().getHeldItemSlot() : 40);
                shields.add((defender.getInventory().getItemInMainHand().getType().equals(Material.SHIELD)) ? defender.getInventory().getItemInMainHand() : defender.getInventory().getItemInOffHand());
            }

            //remove the shields
            for (int slot = 0; slot < slots.size(); slot++) {
                defender.getInventory().setItem(slots.get(slot), new ItemStack(Material.AIR));
            }

            //wait a tick
            BukkitTask shieldTimer = new BukkitRunnable() {
                public void run() {
                    //add the shield back
                    if (!defender.isDead())   {
                        for (int i = 0; i < slots.size(); i++) {
                            defender.getInventory().setItem(slots.get(i), shields.get(i));
                        }}
                }
            }.runTaskLater(Main.getPlugin(), 2);
            attacker.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 60, 1, false, false, true));
            defender.setCooldown(Material.SHIELD, 200);
        }
    }
}
