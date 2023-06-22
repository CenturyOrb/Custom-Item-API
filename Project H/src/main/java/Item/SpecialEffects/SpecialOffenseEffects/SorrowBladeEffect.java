package Item.SpecialEffects.SpecialOffenseEffects;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.meta.ItemMeta;

import static Item.SpecialEffects.MeleeCheckers.ItemChecker.itemLoreChecker;
import static Item.SpecialEffects.MeleeCheckers.PlayerMeleePlayerChecker.playerMeleePlayerChecker;

public class SorrowBladeEffect implements Listener {

    @EventHandler
    public void onSorrowBladeHit (EntityDamageByEntityEvent e)  {
        Player attacker;
        Player defender;
        ItemMeta item;

        // check if player attacked a player
        if(playerMeleePlayerChecker(e.getEntity(), e.getDamager(), e.getCause()))   {
            attacker = (Player) e.getDamager();
            defender = (Player) e.getEntity();
            item = attacker.getInventory().getItemInMainHand().getItemMeta();
            // check if the attacker was using Sorrow Blade
            if (itemLoreChecker(item, "§5§oDown goes your health")) {
                // get cooldown of gap/egaps/god foods
                int defenderGoldenAppleCooldown = defender.getCooldown(Material.GOLDEN_APPLE);
                int defenderEnchantedGoldenAppleCooldown = defender.getCooldown(Material.ENCHANTED_GOLDEN_APPLE);
                // check if their cooldown is less than 5 seconds
                if (defenderGoldenAppleCooldown <= 100 || defenderEnchantedGoldenAppleCooldown <= 100)  {
                    // add defender egap/gap cooldown to 5 seconds
                    defenderGoldenAppleCooldown += 100;
                    defenderEnchantedGoldenAppleCooldown += 100;

                    // applying the cooldown toe the defender
                    defender.setCooldown(Material.GOLDEN_APPLE, defenderGoldenAppleCooldown);
                    defender.setCooldown(Material.ENCHANTED_GOLDEN_APPLE, defenderEnchantedGoldenAppleCooldown);
                }
            }
        }
    }

    @EventHandler
    public void onDefenderEatGap (PlayerItemConsumeEvent e)   {
        Player player;
        int gapCooldown;
        int egapCooldown;
        World world;

        player = e.getPlayer();
        gapCooldown = player.getCooldown(Material.GOLDEN_APPLE);
        egapCooldown = player.getCooldown(Material.ENCHANTED_GOLDEN_APPLE);
        world = player.getWorld();

        if ((gapCooldown > 0 || egapCooldown > 0) &&
                (player.getInventory().getItemInOffHand().getType().equals(Material.GOLDEN_APPLE) ||
                        player.getInventory().getItemInMainHand().getType().equals(Material.ENCHANTED_GOLDEN_APPLE) ||
                        player.getInventory().getItemInMainHand().getType().equals(Material.GOLDEN_APPLE) ||
                        player.getInventory().getItemInOffHand().getType().equals(Material.ENCHANTED_GOLDEN_APPLE)))    {
            e.setCancelled(true);

            Particle.DustTransition dustTransition = new Particle.DustTransition(Color.fromRGB(247, 12, 26), Color.fromRGB(255, 170, 0), 1.0f);
            world.spawnParticle(Particle.DUST_COLOR_TRANSITION, player.getLocation(), 10, 0.5, 0.5, 0.5, dustTransition);
            world.spawnParticle(Particle.DUST_COLOR_TRANSITION, player.getEyeLocation(), 10, 0.5, 0.5, 0.5, dustTransition);

            world.playSound(player.getLocation(), Sound.ITEM_TRIDENT_RIPTIDE_2, 1.0f, 3.0f);
        }
    }
}
