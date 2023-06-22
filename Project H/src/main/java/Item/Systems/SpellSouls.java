package Item.Systems;

import com.rosa.serverplugin.Main;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.Objects;

public class SpellSouls implements Listener {

    // listener to add soul to player if they don't have soul
    @EventHandler
    public void checkerPlayerSoulOnJoin (PlayerJoinEvent e)   {
        Player player = e.getPlayer();
        PersistentDataContainer playerData = player.getPersistentDataContainer();

        if (playerData.has(new NamespacedKey(Main.getPlugin(Main.class), "Soul"), PersistentDataType.STRING))    {
            if (Objects.equals(playerData.get(new NamespacedKey(Main.getPlugin(Main.class), "Soul"), PersistentDataType.STRING), "false"))    {
                rechargeSoul(player);
            }
            return;
        }
        playerData.set(new NamespacedKey(Main.getPlugin(Main.class), "Soul"), PersistentDataType.STRING, "true");
    }

    public static boolean getSoulStatus (Player player)   {
        PersistentDataContainer playerData = player.getPersistentDataContainer();

        if (Objects.equals(playerData.get(new NamespacedKey(Main.getPlugin(), "Soul"), PersistentDataType.STRING), "true"))   {
            return true;
        }else   {
            return false;
        }
    }

    public static void useSoul (Player player)    {
        PersistentDataContainer playerData = player.getPersistentDataContainer();

        if (Objects.equals(playerData.get(new NamespacedKey(Main.getPlugin(Main.class), "Soul"), PersistentDataType.STRING), "true"))  {
            playerData.set(new NamespacedKey(Main.getPlugin(Main.class), "Soul"), PersistentDataType.STRING, "false");
            rechargeSoul(player);
        }
    }

    public static void rechargeSoul (Player player)   {
        BukkitTask soulTimer = new BukkitRunnable() {
            public void run() {

                PersistentDataContainer playerData = player.getPersistentDataContainer();
                World world = player.getWorld();
                world.playSound(player.getLocation(), Sound.BLOCK_BEACON_POWER_SELECT, 1.0f, 2.0f);
                world.spawnParticle(Particle.END_ROD, player.getLocation(), 10, 0.1, 0.1, 0.1);
                world.spawnParticle(Particle.END_ROD, player.getEyeLocation(), 10, 0.1, 0.0, 0.1);
                playerData.set(new NamespacedKey(Main.getPlugin(), "Soul"), PersistentDataType.STRING, "true");

            }
        }.runTaskLater(Main.getPlugin(), 300);
    }

}
