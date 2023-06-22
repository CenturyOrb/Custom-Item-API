package Item.Systems;

import com.rosa.serverplugin.Main;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;

public class CustomBowEffects implements Listener {

    // HashMap stores PotionEffectType
    private HashMap<String, PotionEffectType> bowEffects = new HashMap<>();

    // constructor sets up bowEffects HashMap
    public CustomBowEffects ()   {
        bowEffects.put("Slowness", PotionEffectType.SLOW);
        bowEffects.put("Weakness", PotionEffectType.WEAKNESS);
    }

    @EventHandler
    public void onCustomBowHit (ProjectileHitEvent e)   {
        Player defender;
        Entity arrow;
        PersistentDataContainer arrowData;

        if (!(e.getHitEntity() instanceof Player))  { return;}
        if (!(e.getEntity() instanceof Arrow))  { return;}

        defender = (Player) e.getHitEntity();
        arrow = e.getEntity();
        arrowData = arrow.getPersistentDataContainer();

        if (!(arrowData.has(new NamespacedKey(Main.getPlugin(Main.class), "e1"), PersistentDataType.STRING)))   { return;}

        // check if the arrow does N/A if not then apply effects
        if (arrowData.get(new NamespacedKey(Main.getPlugin(Main.class), "e1"), PersistentDataType.STRING) != "N/A")   {
            String key = arrowData.get(new NamespacedKey(Main.getPlugin(Main.class), "e1"), PersistentDataType.STRING);
            PotionEffectType effectType = bowEffects.get(key);
            int effectDuration = arrowData.get(new NamespacedKey(Main.getPlugin(Main.class), "d1"), PersistentDataType.INTEGER);
            int effectAmplifier = arrowData.get(new NamespacedKey(Main.getPlugin(Main.class), "a1"), PersistentDataType.INTEGER);

            PotionEffect potionEffect = new PotionEffect(effectType, effectDuration, effectAmplifier,
                            false, false, true);
            defender.addPotionEffect(potionEffect);
        }
        if (arrowData.get(new NamespacedKey(Main.getPlugin(Main.class), "e2"), PersistentDataType.STRING) != "N/A")   {
            String key = arrowData.get(new NamespacedKey(Main.getPlugin(Main.class), "e2"), PersistentDataType.STRING);
            PotionEffectType effectType = bowEffects.get(key);
            int effectDuration = arrowData.get(new NamespacedKey(Main.getPlugin(Main.class), "d2"), PersistentDataType.INTEGER);
            int effectAmplifier = arrowData.get(new NamespacedKey(Main.getPlugin(Main.class), "a2"), PersistentDataType.INTEGER);

            PotionEffect potionEffect = new PotionEffect(effectType, effectDuration, effectAmplifier,
                    false, false, true);
            defender.addPotionEffect(potionEffect);
        }
        if (arrowData.get(new NamespacedKey(Main.getPlugin(Main.class), "e3"), PersistentDataType.STRING) != "N/A")   {
            String key = arrowData.get(new NamespacedKey(Main.getPlugin(Main.class), "e3"), PersistentDataType.STRING);
            PotionEffectType effectType = bowEffects.get(key);
            int effectDuration = arrowData.get(new NamespacedKey(Main.getPlugin(Main.class), "d3"), PersistentDataType.INTEGER);
            int effectAmplifier = arrowData.get(new NamespacedKey(Main.getPlugin(Main.class), "a3"), PersistentDataType.INTEGER);

            PotionEffect potionEffect = new PotionEffect(effectType, effectDuration, effectAmplifier,
                    false, false, true);
            defender.addPotionEffect(potionEffect);
        }
    }

    @EventHandler
    public void onCustombowShoot   (EntityShootBowEvent e)  {
        Player player;
        ItemMeta item;
        PersistentDataContainer playerBowData;
        PersistentDataContainer arrowData;

        // check if the bow user isn't a player
        if (!(e.getEntity() instanceof Player))   { return;}

        player = (Player) e.getEntity();
        item = e.getBow().getItemMeta();

        // get bow PDC
        playerBowData = item.getPersistentDataContainer();

        // check if bow is a custom bow item or not
        if (playerBowData.get(new NamespacedKey(Main.getPlugin(Main.class), "e1"), PersistentDataType.STRING) != null)   {

            Entity arrow = e.getProjectile();
            arrowData = arrow.getPersistentDataContainer();

            String effectType1 = playerBowData.get(new NamespacedKey(Main.getPlugin(Main.class), "e1"), PersistentDataType.STRING);
            int effectDuration1 = playerBowData.get(new NamespacedKey(Main.getPlugin(Main.class), "d1"), PersistentDataType.INTEGER);
            int effectAmplifier1 = playerBowData.get(new NamespacedKey(Main.getPlugin(Main.class), "a1"), PersistentDataType.INTEGER);

            arrowData.set(new NamespacedKey(Main.getPlugin(Main.class), "e1"), PersistentDataType.STRING, effectType1);
            arrowData.set(new NamespacedKey(Main.getPlugin(Main.class), "d1"), PersistentDataType.INTEGER, effectDuration1);
            arrowData.set(new NamespacedKey(Main.getPlugin(Main.class), "a1"), PersistentDataType.INTEGER, effectAmplifier1);

            String effectType2 = playerBowData.get(new NamespacedKey(Main.getPlugin(Main.class), "e2"), PersistentDataType.STRING);
            int effectDuration2 = playerBowData.get(new NamespacedKey(Main.getPlugin(Main.class), "d2"), PersistentDataType.INTEGER);
            int effectAmplifier2 = playerBowData.get(new NamespacedKey(Main.getPlugin(Main.class), "a2"), PersistentDataType.INTEGER);

            arrowData.set(new NamespacedKey(Main.getPlugin(Main.class), "e2"), PersistentDataType.STRING, effectType2);
            arrowData.set(new NamespacedKey(Main.getPlugin(Main.class), "d2"), PersistentDataType.INTEGER, effectDuration2);
            arrowData.set(new NamespacedKey(Main.getPlugin(Main.class), "a2"), PersistentDataType.INTEGER, effectAmplifier2);

            String effectType3 = playerBowData.get(new NamespacedKey(Main.getPlugin(Main.class), "e3"), PersistentDataType.STRING);
            int effectDuration3 = playerBowData.get(new NamespacedKey(Main.getPlugin(Main.class), "d3"), PersistentDataType.INTEGER);
            int effectAmplifier3 = playerBowData.get(new NamespacedKey(Main.getPlugin(Main.class), "a3"), PersistentDataType.INTEGER);

            arrowData.set(new NamespacedKey(Main.getPlugin(Main.class), "e3"), PersistentDataType.STRING, effectType3);
            arrowData.set(new NamespacedKey(Main.getPlugin(Main.class), "d3"), PersistentDataType.INTEGER, effectDuration3);
            arrowData.set(new NamespacedKey(Main.getPlugin(Main.class), "a3"), PersistentDataType.INTEGER, effectAmplifier3);
        }

    }

}
