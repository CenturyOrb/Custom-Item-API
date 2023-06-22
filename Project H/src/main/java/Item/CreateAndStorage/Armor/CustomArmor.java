package Item.CreateAndStorage.Armor;

import Item.CreateAndStorage.EnchantmentPlus;
import com.rosa.serverplugin.Main;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;

public class CustomArmor {

    // instance variables for ItemMeta
    private ItemStack itemItemStack;
    private ItemMeta itemItemMeta;

    private LeatherArmorMeta leatherItemMeta;

    // constructor for name enchants and lore
    public CustomArmor (String itemName,
                        ArrayList<EnchantmentPlus> itemEnchantments,
                        ArrayList<String> itemLore,
                        Material itemMaterial,
                        String eff1, String eff2, String eff3,
                        int amp1, int amp2, int amp3,
                        int durability, int maxDurability,
                        AttributeModifier armorHealth, AttributeModifier armor, AttributeModifier armorToughness)   {

        itemItemStack = new ItemStack(itemMaterial);

        itemItemMeta = itemItemStack.getItemMeta();

        setItemPDC(eff1, eff2, eff3, amp1, amp2, amp3, durability, maxDurability);

        itemItemMeta.setDisplayName(itemName);
        itemItemMeta.setLore(itemLore);
        itemItemMeta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, armorHealth);
        itemItemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        itemItemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, armorToughness);

        for (EnchantmentPlus enchantment : itemEnchantments)    {
            itemItemMeta.addEnchant(enchantment.getEnchantment(),
                    enchantment.getEnchantmentLevel(),
                    enchantment.getIgnoreLevelRestriction());
        }
        itemItemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemItemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        itemItemStack.setItemMeta(itemItemMeta);
    }

    // constructor for name enchants and lore
    public CustomArmor (String itemName,
                        ArrayList<EnchantmentPlus> itemEnchantments,
                        ArrayList<String> itemLore,
                        Material itemMaterial,
                        String eff1, String eff2, String eff3,
                        int amp1, int amp2, int amp3,
                        int durability, int maxDurability,
                        AttributeModifier armorHealth, AttributeModifier armor, AttributeModifier armorToughness, AttributeModifier armorKnockbackResistance)   {

        itemItemStack = new ItemStack(itemMaterial);

        itemItemMeta = itemItemStack.getItemMeta();

        setItemPDC(eff1, eff2, eff3, amp1, amp2, amp3, durability, maxDurability);

        itemItemMeta.setDisplayName(itemName);
        itemItemMeta.setLore(itemLore);
        itemItemMeta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, armorHealth);
        itemItemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        itemItemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, armorToughness);
        itemItemMeta.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, armorKnockbackResistance);

        for (EnchantmentPlus enchantment : itemEnchantments)    {
            itemItemMeta.addEnchant(enchantment.getEnchantment(),
                    enchantment.getEnchantmentLevel(),
                    enchantment.getIgnoreLevelRestriction());
        }
        itemItemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemItemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        itemItemStack.setItemMeta(itemItemMeta);
    }

    // constructor for name enchants and lore (leather armor)
    public CustomArmor (String itemName,
                        ArrayList<EnchantmentPlus> itemEnchantments,
                        ArrayList<String> itemLore,
                        Material itemMaterial,
                        String eff1, String eff2, String eff3,
                        int amp1, int amp2, int amp3,
                        int durability, int maxDurability,
                        AttributeModifier armorHealth, AttributeModifier armor, AttributeModifier armorToughness,
                        Color leatherColor)   {

        itemItemStack = new ItemStack(itemMaterial);

        leatherItemMeta = (LeatherArmorMeta) itemItemStack.getItemMeta();

        setLeatherItemPDC(eff1, eff2, eff3, amp1, amp2, amp3, durability, maxDurability);

        leatherItemMeta.setDisplayName(itemName);
        leatherItemMeta.setLore(itemLore);
        leatherItemMeta.setColor(leatherColor);
        leatherItemMeta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, armorHealth);
        leatherItemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
        leatherItemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, armorToughness);

        for (EnchantmentPlus enchantment : itemEnchantments)    {
            leatherItemMeta.addEnchant(enchantment.getEnchantment(),
                    enchantment.getEnchantmentLevel(),
                    enchantment.getIgnoreLevelRestriction());
        }
        leatherItemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        leatherItemMeta.addItemFlags(ItemFlag.HIDE_DYE);
        leatherItemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        itemItemStack.setItemMeta(leatherItemMeta);
    }

    private void setLeatherItemPDC(String eff1, String eff2, String eff3,
                            int amp1, int amp2, int amp3,
                            double durability, double maxDurability)  {
        PersistentDataContainer itemData = leatherItemMeta.getPersistentDataContainer();

        itemData.set(new NamespacedKey(Main.getPlugin(Main.class), "e1"), PersistentDataType.STRING, eff1);
        itemData.set(new NamespacedKey(Main.getPlugin(Main.class), "e2"), PersistentDataType.STRING, eff2);
        itemData.set(new NamespacedKey(Main.getPlugin(Main.class), "e3"), PersistentDataType.STRING, eff3);
        itemData.set(new NamespacedKey(Main.getPlugin(Main.class), "a1"), PersistentDataType.INTEGER, amp1);
        itemData.set(new NamespacedKey(Main.getPlugin(Main.class), "a2"), PersistentDataType.INTEGER, amp2);
        itemData.set(new NamespacedKey(Main.getPlugin(Main.class), "a3"), PersistentDataType.INTEGER, amp3);
        itemData.set(new NamespacedKey(Main.getPlugin(Main.class), "dura"), PersistentDataType.DOUBLE, durability);
        itemData.set(new NamespacedKey(Main.getPlugin(Main.class), "maxDura"), PersistentDataType.DOUBLE, maxDurability);
    }

    private void setItemPDC(String eff1, String eff2, String eff3,
                            int amp1, int amp2, int amp3,
                            double durability, double maxDurability)  {
        PersistentDataContainer itemData = itemItemMeta.getPersistentDataContainer();

        itemData.set(new NamespacedKey(Main.getPlugin(Main.class), "e1"), PersistentDataType.STRING, eff1);
        itemData.set(new NamespacedKey(Main.getPlugin(Main.class), "e2"), PersistentDataType.STRING, eff2);
        itemData.set(new NamespacedKey(Main.getPlugin(Main.class), "e3"), PersistentDataType.STRING, eff3);
        itemData.set(new NamespacedKey(Main.getPlugin(Main.class), "a1"), PersistentDataType.INTEGER, amp1);
        itemData.set(new NamespacedKey(Main.getPlugin(Main.class), "a2"), PersistentDataType.INTEGER, amp2);
        itemData.set(new NamespacedKey(Main.getPlugin(Main.class), "a3"), PersistentDataType.INTEGER, amp3);
        itemData.set(new NamespacedKey(Main.getPlugin(Main.class), "dura"), PersistentDataType.DOUBLE, durability);
        itemData.set(new NamespacedKey(Main.getPlugin(Main.class), "maxDura"), PersistentDataType.DOUBLE, maxDurability);
    }

    public ItemStack getCustomItem ()   { return itemItemStack;}

}
