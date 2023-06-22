package Item.SpecialEffects.SpecialOffenseEffects;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

public class ShadowStepEffect implements Listener {

    @EventHandler
    public void onShadowStep (PlayerFishEvent e)   {
        Player player;
        PlayerFishEvent.State fishingState;

        // get player that uses fishing rod
        player = e.getPlayer();

        // get the state of the fishing rod
        fishingState = e.getState();

        if (player.getInventory().getItemInMainHand().hasItemMeta())    {
            if (player.getInventory().getItemInMainHand().getItemMeta().getLore().contains("§5§oLost art of the shinobi")) {
                if (fishingState == PlayerFishEvent.State.IN_GROUND)   {
                    Location hookLocation = e.getHook().getLocation();
                    float playerYaw = player.getLocation().getYaw();
                    float playerPitch = player.getLocation().getPitch();
                    World world = player.getWorld();

                    hookLocation.setYaw(playerYaw);
                    hookLocation.setPitch(playerPitch);
                    player.teleport(hookLocation);

                    world.spawnParticle(Particle.DRAGON_BREATH, player.getLocation(), 10, 0.5, 0.5, 0.5);
                    world.spawnParticle(Particle.DRAGON_BREATH, player.getEyeLocation(), 10, 0.5, 0.5, 0.5);

                    world.spawnParticle(Particle.DRAGON_BREATH, player.getLocation(), 10, 0.5, 0.5, 0.5);
                    world.spawnParticle(Particle.DRAGON_BREATH, player.getEyeLocation(), 10, 0.5, 0.5, 0.5);

                    world.playSound(player.getLocation(), Sound.ENTITY_ILLUSIONER_MIRROR_MOVE, 1.0f, 1.0f);

                    player.setCooldown(Material.FISHING_ROD, 60);
                }
            }
        }

        if (player.getInventory().getItemInOffHand().hasItemMeta())   {
            if (player.getInventory().getItemInOffHand().getItemMeta().getLore().contains("§5§oLost art of the shinobi"))    {
                if (fishingState == PlayerFishEvent.State.IN_GROUND)   {
                    Location hookLocation = e.getHook().getLocation();
                    float playerYaw = player.getLocation().getYaw();
                    float playerPitch = player.getLocation().getPitch();
                    World world = player.getWorld();

                    hookLocation.setYaw(playerYaw);
                    hookLocation.setPitch(playerPitch);
                    player.teleport(hookLocation);

                    world.spawnParticle(Particle.DRAGON_BREATH, player.getLocation(), 10, 0.5, 0.5, 0.5);
                    world.spawnParticle(Particle.DRAGON_BREATH, player.getEyeLocation(), 10, 0.5, 0.5, 0.5);

                    world.spawnParticle(Particle.DRAGON_BREATH, player.getLocation(), 10, 0.5, 0.5, 0.5);
                    world.spawnParticle(Particle.DRAGON_BREATH, player.getEyeLocation(), 10, 0.5, 0.5, 0.5);

                    world.playSound(player.getLocation(), Sound.ENTITY_ILLUSIONER_MIRROR_MOVE, 1.0f, 1.0f);

                    player.setCooldown(Material.FISHING_ROD, 60);
                }
            }
        }

    }
}
