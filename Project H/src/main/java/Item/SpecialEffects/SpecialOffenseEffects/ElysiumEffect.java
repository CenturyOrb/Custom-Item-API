package Item.SpecialEffects.SpecialOffenseEffects;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ElysiumEffect implements Listener {

    @EventHandler
    public void onElysiumHit (EntityDamageByEntityEvent e)    {
        Player defender;
        Player attacker;

        // check if the entity is not a living entity
        if (!(e.getEntity() instanceof Player))   {
            return;
        }else   {
            defender = (Player) e.getEntity();
        }

        // check if damager isn't a Player
        if (!(e.getDamager() instanceof Player))   {
            return;
        }else   {
            attacker = (Player) e.getDamager();
        }

        // check if item in hand isn't air
        if (attacker.getInventory().getItemInMainHand().getItemMeta() == null)  { return;}

        // check if cause is thorns
        if (e.getCause().equals(EntityDamageEvent.DamageCause.THORNS))  { return;}

        // check if damager item isn't vanilla
        if (attacker.getInventory().getItemInMainHand().getItemMeta().getLore() != null)  {
            if (attacker.getInventory().getItemInMainHand().getItemMeta().getLore().contains("§5§oThe abode of the blessed"))   {
                if (Math.random() < 0.5)    {
                    defender.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 60, 0, false, false, true));
                }
                defender.setSprinting(false);
            }
        }

    }

}
