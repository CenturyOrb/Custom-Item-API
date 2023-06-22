package Item.SpecialEffects.MeleeCheckers;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;

public class PlayerMeleePlayerChecker {

   public static boolean playerMeleePlayerChecker (Entity defender, Entity attacker, EntityDamageEvent.DamageCause damageCause)  {
      boolean playerAttackedPlayer = true;

      // check if the deffending entity is not living
      if (!(defender instanceof Player))  {
         playerAttackedPlayer = false;
      }

      // check if attacker isn't a player
      if (!(attacker instanceof Player))  {
         playerAttackedPlayer = false;
      }

      // check if cause is thorns
      if (damageCause == EntityDamageEvent.DamageCause.THORNS) {
         playerAttackedPlayer = false;
      }

      return playerAttackedPlayer;
   }

}
