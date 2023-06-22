package Item.SpecialEffects.SpecialArmorEffects.SpecialArmorSetEffects;

import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPotionEffectEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

public class GuardianSetEffects implements Listener {

    @EventHandler
    public void onGuardianSlow (EntityPotionEffectEvent e)  {
        Player player;
        PotionEffectType potionEffect;
        ItemStack[] armor;
        ArrayList<ItemMeta> armorMeta = new ArrayList<>();
        int guardianArmorCount = 0;

        if (!(e.getEntity() instanceof Player))   { return;}
        player = (Player) e.getEntity();

        armor = player.getInventory().getArmorContents();
        for (int i = 0; i < 4; i++) {
            if (armor[i] == null)   { continue;}
            armorMeta.add(armor[i].getItemMeta());
        }

        for (int i = 0; i < armorMeta.size(); i++)    {
            if (!(armorMeta.get(i).hasLore()))    { continue;}
            if (armorMeta.get(i).getLore().contains("§d(4) Hestia's Blessing"))  {
                guardianArmorCount++;
            }
        }

        if (guardianArmorCount > 2) {
            potionEffect = e.getNewEffect().getType();
            if (potionEffect.equals(PotionEffectType.SLOW))    {
                e.setCancelled(true);
            }
        }

    }

    @EventHandler
    public void onGuardianSetKill (PlayerDeathEvent e)  {
        Player defender = e.getPlayer();
        Player attacker;
        ItemStack[] killerArmor;
        ArrayList<ItemMeta> killerArmorMeta = new ArrayList<ItemMeta>();
        int guardianArmorCount = 0;
        World world;

        // check if another player killed the defender
        if (defender.getKiller() == null)   { return;}
        attacker = defender.getKiller();

        // get the killer's armor
        killerArmor = attacker.getInventory().getArmorContents();
        for (int i = 0; i < 4; i++) {
            if (killerArmor[i] == null) { continue;}
            killerArmorMeta.add(killerArmor[i].getItemMeta());
        }

        // check if the itemMeta has correct Hestia lore
        for (int i = 0; i < killerArmorMeta.size(); i++)    {
            if (!(killerArmorMeta.get(i).hasLore()))    { continue;}
            if (killerArmorMeta.get(i).getLore().contains("§d(4) Hestia's Blessing"))  {
                guardianArmorCount++;
            }
        }

         if (guardianArmorCount == 4)   {
             world = attacker.getWorld();
             world.spawnParticle(Particle.LAVA, attacker.getLocation().add(0.5, 0.5, 0.5), 0, 0.5, 0.5, 0.5);
             world.playSound(defender.getLocation(), Sound.ENTITY_WITHER_BREAK_BLOCK, 1.0f, 1.0f);

             float sat = attacker.getSaturation();
             sat+= 8.0f;
             attacker.setSaturation(sat);
             attacker.setFoodLevel(20);
             attacker.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 200, 0, false, false, true));
         }
    }

}
