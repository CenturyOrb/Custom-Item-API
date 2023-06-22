package Item.SpecialEffects.SpecialOffenseEffects;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.meta.ItemMeta;

import static Item.SpecialEffects.MeleeCheckers.ItemChecker.itemLoreChecker;

public class RapierEffect implements Listener {

    @EventHandler
    public void onRapierHit (EntityDamageByEntityEvent e)   {
        // check if the attack is a player
        if (!(e.getDamager() instanceof Player))    { return;}
        if (!(e.getEntity() instanceof LivingEntity))   { return;}
        Player attacker = (Player) e.getDamager();
        LivingEntity defender = (LivingEntity) e.getEntity();
        ItemMeta item = attacker.getInventory().getItemInMainHand().getItemMeta();

        // check item in their mainhand
        if (!(itemLoreChecker(item, "§5§oSword that can penetrate")))   { return;}

        e.setDamage(0);

        // check attack cooldown of the sword
        float attackCooldown = attacker.getAttackCooldown();

        // if they did a 98% attack indicator hit,
        // deal pure 1.25 hearts of damage ignoring armor
        if (attackCooldown >= 0.98)   {
            double health = defender.getHealth();
            //Bukkit.broadcastMessage("fire");
            double damage = 2.0;
            //Bukkit.broadcastMessage("1");
            health -= damage;
            //Bukkit.broadcastMessage("2");
            defender.setHealth(health);
            //Bukkit.broadcastMessage("done");
        }
    }

}
