package Item.Systems;

import com.rosa.serverplugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;
import java.util.Objects;

public class CustomArmorEffects {

    // HashMap stores PotionEffectType
    private HashMap<String, PotionEffectType> armorEffects = new HashMap<>();

    public CustomArmorEffects ()    {

        armorEffects.put("Regeneration", PotionEffectType.REGENERATION);
        armorEffects.put("Strength", PotionEffectType.INCREASE_DAMAGE);
        armorEffects.put("Jump", PotionEffectType.JUMP);
        armorEffects.put("Speed", PotionEffectType.SPEED);
        armorEffects.put("Resistance", PotionEffectType.DAMAGE_RESISTANCE);

        Bukkit.getScheduler().runTaskTimer(Main.getPlugin(Main.class), () -> {
            for(Player player : Bukkit.getOnlinePlayers())  {
                ItemStack[] armorContents = player.getInventory().getArmorContents();
                for (ItemStack armor : armorContents)    {

                    // check if its air
                    if (armor != null)   {
                        PersistentDataContainer armorData = armor.getItemMeta().getPersistentDataContainer();

                        // check if the piece of armor is custom (custom items have e1 key)
                        if  (armorData.has(new NamespacedKey(Main.getPlugin(Main.class), "e1"), PersistentDataType.STRING))  {
                            // store the string value of effects
                            String eff1 = armorData.get(new NamespacedKey(Main.getPlugin(Main.class), "e1"), PersistentDataType.STRING);
                            String eff2 = armorData.get(new NamespacedKey(Main.getPlugin(Main.class), "e2"), PersistentDataType.STRING);
                            String eff3 = armorData.get(new NamespacedKey(Main.getPlugin(Main.class), "e3"), PersistentDataType.STRING);

                            // store effect amplifiers
                            int amp1 = armorData.get(new NamespacedKey(Main.getPlugin(Main.class), "a1"), PersistentDataType.INTEGER);
                            int amp2 = armorData.get(new NamespacedKey(Main.getPlugin(Main.class), "a2"), PersistentDataType.INTEGER);
                            int amp3 = armorData.get(new NamespacedKey(Main.getPlugin(Main.class), "a3"), PersistentDataType.INTEGER);

                            // check if
                            if (!Objects.equals(eff1, "N/A"))   {
                                String key = armorData.get(new NamespacedKey(Main.getPlugin(Main.class),"e1"), PersistentDataType.STRING);
                                PotionEffectType effectType1 = armorEffects.get(key);
                                int effectAmplifier1 = armorData.get(new NamespacedKey(Main.getPlugin(Main.class),"a1"), PersistentDataType.INTEGER);

                                PotionEffect potionEffect = new PotionEffect(effectType1, 140, amp1,
                                        false, false, true);
                                player.addPotionEffect(potionEffect);
                            }

                            if (!Objects.equals(eff2, "N/A"))   {
                                String key = armorData.get(new NamespacedKey(Main.getPlugin(Main.class),"e2"), PersistentDataType.STRING);
                                PotionEffectType effectType2 = armorEffects.get(key);
                                int effectAmplifier2 = armorData.get(new NamespacedKey(Main.getPlugin(Main.class),"a2"), PersistentDataType.INTEGER);

                                PotionEffect potionEffect = new PotionEffect(effectType2, 140, amp2,
                                        false, false, true);
                                player.addPotionEffect(potionEffect);
                            }

                            if (!Objects.equals(eff3, "N/A"))   {
                                String key = armorData.get(new NamespacedKey(Main.getPlugin(Main.class),"e3"), PersistentDataType.STRING);
                                PotionEffectType effectType3 = armorEffects.get(key);
                                int effectAmplifier1 = armorData.get(new NamespacedKey(Main.getPlugin(Main.class),"a3"), PersistentDataType.INTEGER);

                                PotionEffect potionEffect = new PotionEffect(effectType3, 140, amp3,
                                        false, false, true);
                                player.addPotionEffect(potionEffect);
                            }
                        }

                        // store the string value of effects
                        String eff1 = armorData.get(new NamespacedKey(Main.getPlugin(Main.class), "e1"), PersistentDataType.STRING);
                        String eff2 = armorData.get(new NamespacedKey(Main.getPlugin(Main.class), "e2"), PersistentDataType.STRING);
                        String eff3 = armorData.get(new NamespacedKey(Main.getPlugin(Main.class), "e3"), PersistentDataType.STRING);

                        // store effect amplifiers
                        int amp1 = armorData.get(new NamespacedKey(Main.getPlugin(Main.class), "a1"), PersistentDataType.INTEGER);
                        int amp2 = armorData.get(new NamespacedKey(Main.getPlugin(Main.class), "a2"), PersistentDataType.INTEGER);
                        int amp3 = armorData.get(new NamespacedKey(Main.getPlugin(Main.class), "a3"), PersistentDataType.INTEGER);

                        // check if
                        if (!Objects.equals(eff1, "N/A"))   {
                            String key = armorData.get(new NamespacedKey(Main.getPlugin(Main.class),"e1"), PersistentDataType.STRING);
                            PotionEffectType effectType1 = armorEffects.get(key);
                            int effectAmplifier1 = armorData.get(new NamespacedKey(Main.getPlugin(Main.class),"a1"), PersistentDataType.INTEGER);

                            PotionEffect potionEffect = new PotionEffect(effectType1, 140, amp1,
                                    false, false, true);
                            player.addPotionEffect(potionEffect);
                        }

                        if (!Objects.equals(eff2, "N/A"))   {
                            String key = armorData.get(new NamespacedKey(Main.getPlugin(Main.class),"e2"), PersistentDataType.STRING);
                            PotionEffectType effectType2 = armorEffects.get(key);
                            int effectAmplifier2 = armorData.get(new NamespacedKey(Main.getPlugin(Main.class),"a2"), PersistentDataType.INTEGER);

                            PotionEffect potionEffect = new PotionEffect(effectType2, 140, amp2,
                                    false, false, true);
                            player.addPotionEffect(potionEffect);
                        }

                        if (!Objects.equals(eff3, "N/A"))   {
                            String key = armorData.get(new NamespacedKey(Main.getPlugin(Main.class),"e3"), PersistentDataType.STRING);
                            PotionEffectType effectType3 = armorEffects.get(key);
                            int effectAmplifier1 = armorData.get(new NamespacedKey(Main.getPlugin(Main.class),"a3"), PersistentDataType.INTEGER);

                            PotionEffect potionEffect = new PotionEffect(effectType3, 140, amp3,
                                    false, false, true);
                            player.addPotionEffect(potionEffect);
                        }
                    }

                }
            }
        }, 60, 100);

    }

}
