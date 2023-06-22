package Item.Systems;

import com.rosa.serverplugin.Main;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;
import java.util.Objects;

public class CustomOffenseEffects implements Listener {

    // HashMap stores PotionEffectType
    private HashMap<String, PotionEffectType> meleeEffects = new HashMap<>();

    // constructor sets up meleeEffects HashMap
    public CustomOffenseEffects ()    {
        meleeEffects.put("Blindness", PotionEffectType.BLINDNESS);
        meleeEffects.put("Slowness", PotionEffectType.SLOW);
    }

    @EventHandler
    public void onCustomOffenseHit(EntityDamageByEntityEvent e) {

        Player attackingPlayer;
        Player defendingPlayer;
        Material attackingMaterial;
        String itemMaterialName;

        // check if the damager and person being damaged are player entities
        if (e.getDamager() instanceof Player && e.getEntity() instanceof Player)    {
            attackingPlayer = (Player) e.getDamager();
            defendingPlayer = (Player) e.getEntity();

            attackingMaterial = attackingPlayer.getInventory().getItem(EquipmentSlot.HAND).getType();
            itemMaterialName = attackingMaterial.name().toLowerCase();


            if (itemMaterialName.contains("helmet") || itemMaterialName.contains("chestplate") || itemMaterialName.contains("leggings") || itemMaterialName.contains("boots")) {
                return;
            }

            // get itemPDC
            if(attackingPlayer.getInventory().getItemInMainHand().getItemMeta() == null)  {
                return;
            }
            PersistentDataContainer attackingPlayerItemData = attackingPlayer.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer();

            // check if item is a custom melee item or not
            if (attackingPlayerItemData.get(new NamespacedKey(Main.getPlugin(Main.class), "e1"), PersistentDataType.STRING) != null)  {

                // checks if the item has effect in PDC if mot N/A then apply effect to enemy
                if (!Objects.equals(attackingPlayerItemData.get(new NamespacedKey(Main.getPlugin(Main.class), "e1"), PersistentDataType.STRING), "N/A")) {
                    String key = attackingPlayerItemData.get(new NamespacedKey(Main.getPlugin(Main.class), "e1"), PersistentDataType.STRING);
                    PotionEffectType effectType= meleeEffects.get(key);
                    int effectDuration = attackingPlayerItemData.get(new NamespacedKey(Main.getPlugin(Main.class), "d1"), PersistentDataType.INTEGER);
                    int effectAmplifier = attackingPlayerItemData.get(new NamespacedKey(Main.getPlugin(Main.class), "a1"), PersistentDataType.INTEGER);

                    PotionEffect potionEffect = new PotionEffect(effectType, effectDuration, effectAmplifier,
                                                         false, false, true);
                    defendingPlayer.addPotionEffect(potionEffect);
                }
                if (!Objects.equals(attackingPlayerItemData.get(new NamespacedKey(Main.getPlugin(Main.class), "e2"), PersistentDataType.STRING), "N/A")) {
                    String key = attackingPlayerItemData.get(new NamespacedKey(Main.getPlugin(Main.class), "e2"), PersistentDataType.STRING);
                    PotionEffectType effectType= meleeEffects.get(key);
                    int effectDuration = attackingPlayerItemData.get(new NamespacedKey(Main.getPlugin(Main.class), "d2"), PersistentDataType.INTEGER);
                    int effectAmplifier = attackingPlayerItemData.get(new NamespacedKey(Main.getPlugin(Main.class), "a2"), PersistentDataType.INTEGER);

                    PotionEffect potionEffect = new PotionEffect(effectType, effectDuration, effectAmplifier,
                            false, false, true);
                    defendingPlayer.addPotionEffect(potionEffect);
                }
                if (!Objects.equals(attackingPlayerItemData.get(new NamespacedKey(Main.getPlugin(Main.class), "e3"), PersistentDataType.STRING), "N/A")) {
                    String key = attackingPlayerItemData.get(new NamespacedKey(Main.getPlugin(Main.class), "e3"), PersistentDataType.STRING);
                    PotionEffectType effectType= meleeEffects.get(key);
                    int effectDuration = attackingPlayerItemData.get(new NamespacedKey(Main.getPlugin(Main.class), "d3"), PersistentDataType.INTEGER);
                    int effectAmplifier = attackingPlayerItemData.get(new NamespacedKey(Main.getPlugin(Main.class), "a3"), PersistentDataType.INTEGER);

                    PotionEffect potionEffect = new PotionEffect(effectType, effectDuration, effectAmplifier,
                            false, false, true);
                    defendingPlayer.addPotionEffect(potionEffect);
                }
            }
        }

    }
}
