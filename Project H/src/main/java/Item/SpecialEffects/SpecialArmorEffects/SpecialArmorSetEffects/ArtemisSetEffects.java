package Item.SpecialEffects.SpecialArmorEffects.SpecialArmorSetEffects;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.rosa.serverplugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class ArtemisSetEffects implements Listener {

    private Cache<UUID, Long> activeCamoCooldown = CacheBuilder.newBuilder().expireAfterWrite(15, TimeUnit.SECONDS).build();

    private double damage;
    private Player shooter;

    @EventHandler
    public void onArtemisHit (ProjectileHitEvent e)   {
        if (!(e.getEntity() instanceof Arrow))  { return;}
        Arrow arrow = (Arrow) e.getEntity();
        PersistentDataContainer arrowData = arrow.getPersistentDataContainer();

        Bukkit.broadcastMessage(damage + "");

        if (arrowData.has(new NamespacedKey(Main.getPlugin(Main.class), "ArtemisLifeSteal"), PersistentDataType.STRING))    {
            Bukkit.broadcastMessage("1");

            double shooterCurrentHealth = shooter.getHealth();
            shooterCurrentHealth += damage;
            shooter.setHealth(shooterCurrentHealth);
            Bukkit.broadcastMessage("done");
        }
    }

    @EventHandler
    public void onArtemisShoot (EntityShootBowEvent e)  {

        // check if the bow user isn't a player
        if (!(e.getEntity() instanceof Player))   { return;}
        shooter = (Player) e.getEntity();

        // check if the player is shooting an arrow
        if (!(e.getProjectile() instanceof Arrow))   { return;}

        // check the player armor contents
        ItemStack[] shooterArmor = shooter.getEquipment().getArmorContents();
        ArrayList<ItemMeta> armorMeta = new ArrayList<>();
        for (int i = 0; i < 4; i++)   {
            if (shooterArmor[i] == null)   { continue;}
            armorMeta.add(shooterArmor[i].getItemMeta());
        }

        // check if the itemMeta has the corect artemis lore
        int artemisArmorCount = 0;
        for (int i = 0; i < armorMeta.size(); i++)  {
            if (!(armorMeta.get(i).hasLore()))   { continue;}
            if (armorMeta.get(i).getLore().contains("§d(3) Active Camo"))  {
                artemisArmorCount++;
            }
        }

        if (artemisArmorCount > 1)  {
            PersistentDataContainer arrowData = e.getProjectile().getPersistentDataContainer();
            arrowData.set(new NamespacedKey(Main.getPlugin(Main.class), "ArtemisLifeSteal"), PersistentDataType.STRING, "true");
        }
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e){
        damage = e.getFinalDamage();
    }

    @EventHandler
    public void onArtemisAbility (PlayerInteractEvent e)    {
        Player player = e.getPlayer();

        // check if the player is sneaking and right clicks
        if (!(e.getAction().equals(Action.RIGHT_CLICK_AIR)))    { return;}
        if (!(player.isSneaking()))   { return;}

        // get the armor that the user is wearing
        ItemStack[] armor = player.getEquipment().getArmorContents();
        ArrayList<ItemMeta> armorMeta = new ArrayList<>();
        for (int i = 0; i < 4; i++)   {
            if (armor[i] == null)   { continue;}
            armorMeta.add(armor[i].getItemMeta());
        }

        // check if the armor components has the correct lore
        int artemisArmorCount = 0;
        for (int i = 0; i < armorMeta.size(); i++)  {
            if (!(armorMeta.get(i).hasLore()))  { continue;}
            if (armorMeta.get(i).getLore().contains("§d(3) Active Camo"))   {
                artemisArmorCount++;
            }
        }

        if (artemisArmorCount > 2)  {
            // add code here for invis ability

            if (!activeCamoCooldown.asMap().containsKey(player.getUniqueId()))  {
                activeCamoCooldown.asMap().put(player.getUniqueId(), System.currentTimeMillis() + 15000);

                // get currently wearing armor
                ItemStack helmet = player.getEquipment().getHelmet();
                ItemStack chestplate = player.getEquipment().getChestplate();
                ItemStack leggings = player.getEquipment().getLeggings();
                ItemStack boots = player.getEquipment().getBoots();

                // remove armor from slots
                player.getEquipment().setHelmet(null);
                player.getEquipment().setChestplate(null);
                player.getEquipment().setLeggings(null);
                player.getEquipment().setBoots(null);

                // add resistance, invis and speed
                PotionEffect artemisInvis = new PotionEffect(PotionEffectType.INVISIBILITY, 100, 0, false, false, false);
                PotionEffect artemisSpeed = new PotionEffect(PotionEffectType.SPEED, 140, 2, false, false, false);
                PotionEffect artemisRes = new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 4, false, false, false);
                player.addPotionEffect(artemisInvis, true);
                player.addPotionEffect(artemisRes, true);
                player.addPotionEffect(artemisSpeed, true);

                // add blindness to nearby players in a 6 x 6 x 6 cube
                ArrayList<Player> nearbyPlayers = new ArrayList<>();
                for (Entity entity : player.getNearbyEntities(6, 6, 6)) {
                    if (entity instanceof  Player)   {
                        nearbyPlayers.add((Player) entity);
                    }
                }

                for (Player p : nearbyPlayers)  {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100, 0, false, false, true));
                }

                BukkitTask activeCamo = new BukkitRunnable() {
                    public void run() {
                        player.removePotionEffect(artemisInvis.getType());
                        player.removePotionEffect(artemisRes.getType());
                        player.removePotionEffect(artemisSpeed.getType());

                        player.getInventory().setHelmet(helmet);
                        player.getInventory().setChestplate(chestplate);
                        player.getInventory().setLeggings(leggings);
                        player.getInventory().setBoots(boots);
                    }
                }.runTaskLater(Main.getPlugin(), 100);
            }else {
                long timeLeft = activeCamoCooldown.asMap().get(player.getUniqueId()) - System.currentTimeMillis();
            }

        }
    }
}
