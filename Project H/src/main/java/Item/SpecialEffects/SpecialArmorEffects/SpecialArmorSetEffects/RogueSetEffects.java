package Item.SpecialEffects.SpecialArmorEffects.SpecialArmorSetEffects;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class RogueSetEffects implements Listener {

    private Cache<UUID, Long> leapCooldown = CacheBuilder.newBuilder().expireAfterWrite(7, TimeUnit.SECONDS).build();

    @EventHandler
    public void rogueTeleport (PlayerInteractEvent e)   {
        Player player = e.getPlayer();

        // check if the player is sneaking and right click
        if (!(e.getAction().equals(Action.RIGHT_CLICK_AIR)))    { return;}
        if (!(player.isSneaking()))   { return;}

        // get the armor that the killer was wearing
        ItemStack[] armor = player.getEquipment().getArmorContents();
        ArrayList<ItemMeta> armorMeta = new ArrayList<>();
        for (int i = 0; i < 4; i++)   {
            if (armor[i] == null)   { continue;}
            armorMeta.add(armor[i].getItemMeta());
        }

        // check if the itemMta has correct Rogue lore
        int rogueArmorCount = 0;
        for (int i = 0; i < armorMeta.size(); i++)    {
            if (!(armorMeta.get(i).hasLore()))    { continue;}
            if (armorMeta.get(i).getLore().contains("§d(3) Rogue's Fury"))   {
                rogueArmorCount++;
            }
        }

        // if attacker has 2-4 set of rogue
        if (rogueArmorCount > 1)   {

            if (!leapCooldown.asMap().containsKey(player.getUniqueId()))    {
                leapCooldown.put(player.getUniqueId(), System.currentTimeMillis() + 7000);
                World world = player.getWorld();
                world.playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_FLAP, 1.0f, 1.3f);
                player.setVelocity(player.getLocation().getDirection().multiply(2.5));
            }else {
                long timeLeft = leapCooldown.asMap().get(player.getUniqueId()) - System.currentTimeMillis();
            }

        }

    }

    @EventHandler
    public void onRogueSetKill (PlayerDeathEvent e)   {
        Player defender = e.getPlayer();

        // check if another player killed the defender
        if (defender.getKiller() == null) { return;}
        Player attacker = defender.getKiller();

        // get the armor that the killer was wearing
        ItemStack[] killerArmor = attacker.getEquipment().getArmorContents();
        ArrayList<ItemMeta> killerArmorMeta = new ArrayList<>();
        for (int i = 0; i < 4; i++)   {
            if (killerArmor[i] == null)   { continue;}
            killerArmorMeta.add(killerArmor[i].getItemMeta());
        }

        // check if the itemMta has correct Rogue lore
        int rogueArmorCount = 0;
        for (int i = 0; i < killerArmorMeta.size(); i++)    {
            if (!(killerArmorMeta.get(i).hasLore()))    { continue;}
            if (killerArmorMeta.get(i).getLore().contains("§d(3) Rogue's Fury"))   {
                rogueArmorCount++;
            }
        }

        World world;
        // if attacker has 3-4 set of rogue
        if (rogueArmorCount > 2)   {
            world = attacker.getWorld();
            world.spawnParticle(Particle.LAVA, attacker.getLocation().add(0.5, 0.5, 0.5), 0, 0.5, 0.5, 0.5);
            world.playSound(defender.getLocation(), Sound.ENTITY_WITHER_BREAK_BLOCK, 1.0f, 1.0f);

            attacker.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 300, 0, false, false, true));
            attacker.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 300, 1, false, false, true));
        }
    }

}
