package Item.SpecialEffects.SpecialOffenseEffects;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.meta.ItemMeta;

import static Item.SpecialEffects.MeleeCheckers.ItemChecker.itemLoreChecker;
import static Item.SpecialEffects.MeleeCheckers.PlayerMeleePlayerChecker.playerMeleePlayerChecker;

public class TetheriusEffect implements Listener {

    @EventHandler
    public void onTetheriusHit (EntityDamageByEntityEvent e)  {
        Player attacker;
        Player defender;
        ItemMeta item;

        // check if player attacked a player
        if (playerMeleePlayerChecker(e.getEntity(), e.getDamager(), e.getCause()))    {
            attacker = (Player) e.getDamager();
            defender = (Player) e.getEntity();
            item = attacker.getInventory().getItemInMainHand().getItemMeta();
            // checks if the attacker was using the Tetherius
            if (itemLoreChecker(item, "§5§oTrembling as the chains")) {
                // check defending player ender pearl cooldown
                int defenderEnderPearlCooldown = defender.getCooldown(Material.ENDER_PEARL);

                // if their cooldown is less than 18 seconds
                if (defenderEnderPearlCooldown <= 360)  {

                    // add ender pearl cooldown to defending player
                    defenderEnderPearlCooldown += 80;
                    defender.setCooldown(Material.ENDER_PEARL, defenderEnderPearlCooldown);
                }
            }
        }

    }

}
