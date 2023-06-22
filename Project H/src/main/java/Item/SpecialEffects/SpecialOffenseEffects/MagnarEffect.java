package Item.SpecialEffects.SpecialOffenseEffects;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.meta.ItemMeta;

import static Item.SpecialEffects.MeleeCheckers.ItemChecker.itemLoreChecker;
import static Item.SpecialEffects.MeleeCheckers.PlayerMeleePlayerChecker.playerMeleePlayerChecker;

public class MagnarEffect implements Listener {

    @EventHandler
    public void onMagnarHit (EntityDamageByEntityEvent e)   {
        Player attacker;
        Player defender;
        ItemMeta item;

        // check if player attacked a player
        if (playerMeleePlayerChecker(e.getEntity(), e.getDamager(), e.getCause()))  {
            attacker = (Player) e.getDamager();
            defender = (Player) e.getEntity();
            item = attacker.getInventory().getItemInMainHand().getItemMeta();
            // check if the attacker is using the Magnar
            if (itemLoreChecker(item, "§5§oThey that die by famine"))   {
                int foodLevel = defender.getFoodLevel();
                // randomly fire with a 70% chance
                if (Math.random() < 0.7 && foodLevel > 5)    {
                    foodLevel -= 1;
                    defender.setFoodLevel(foodLevel);
                }
            }
        }
    }

}
