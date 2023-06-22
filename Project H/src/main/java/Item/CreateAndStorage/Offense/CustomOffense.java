package Item.CreateAndStorage.Offense;

import Item.CreateAndStorage.EnchantmentPlus;
import com.rosa.serverplugin.Main;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;

public class CustomOffense {

    // instance variables for ItemMeta
    private ItemStack itemItemStack;
    private String itemName;
    private ItemMeta itemItemMeta;
    private ArrayList<EnchantmentPlus> itemEnchantments;
    private ArrayList<String> itemLore;

    // constructor for name enchants and lore
    public CustomOffense  (String itemName,
                         ArrayList<EnchantmentPlus> itemEnchantments,
                         ArrayList<String> itemLore,
                         Material itemMaterial,
                         String eff1, String eff2, String eff3,
                         int dur1, int dur2, int dur3,
                         int amp1, int amp2, int amp3)  {
        this.itemName = itemName;
        this.itemEnchantments = itemEnchantments;
        this.itemLore = itemLore;

        itemItemStack = new ItemStack(itemMaterial);

        itemItemMeta = itemItemStack.getItemMeta();

        setItemPDC(eff1, eff2, eff3, dur1, dur2, dur3, amp1, amp2, amp3);

        itemItemMeta.setDisplayName(itemName);
        itemItemMeta.setLore(itemLore);

        for (EnchantmentPlus enchantment : itemEnchantments)    {
            itemItemMeta.addEnchant(enchantment.getEnchantment(),
                    enchantment.getEnchantmentLevel(),
                    enchantment.getIgnoreLevelRestriction());
        }
        itemItemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        itemItemStack.setItemMeta(itemItemMeta);
    }

    private void setItemPDC(String eff1, String eff2, String eff3,
                            int dur1, int dur2, int dur3,
                            int amp1, int amp2, int amp3)  {
        PersistentDataContainer itemData = itemItemMeta.getPersistentDataContainer();

        itemData.set(new NamespacedKey(Main.getPlugin(Main.class), "e1"), PersistentDataType.STRING, eff1);
        itemData.set(new NamespacedKey(Main.getPlugin(Main.class), "e2"), PersistentDataType.STRING, eff2);
        itemData.set(new NamespacedKey(Main.getPlugin(Main.class), "e3"), PersistentDataType.STRING, eff3);
        itemData.set(new NamespacedKey(Main.getPlugin(Main.class), "d1"), PersistentDataType.INTEGER, dur1);
        itemData.set(new NamespacedKey(Main.getPlugin(Main.class), "d2"), PersistentDataType.INTEGER, dur2);
        itemData.set(new NamespacedKey(Main.getPlugin(Main.class), "d3"), PersistentDataType.INTEGER, dur3);
        itemData.set(new NamespacedKey(Main.getPlugin(Main.class), "a1"), PersistentDataType.INTEGER, amp1);
        itemData.set(new NamespacedKey(Main.getPlugin(Main.class), "a2"), PersistentDataType.INTEGER, amp2);
        itemData.set(new NamespacedKey(Main.getPlugin(Main.class), "a3"), PersistentDataType.INTEGER, amp3);
    }

    // method that returns item
    public ItemStack getCustomItem ()   { return itemItemStack;}

    // setter getter methods
    public String getItemName ()    { return this.itemName;}

    public void setItemName (String itemName)   {
        this.itemName = itemName;
    }

    public ArrayList<EnchantmentPlus> getItemEnchantments ()    { return this.itemEnchantments;}

    public void setItemEnchantments (ArrayList<EnchantmentPlus> itemEnchantments)  {
        this.itemEnchantments = itemEnchantments;
    }

    public ArrayList<String> getItemLore ()    { return this.itemLore;}

    public void setItemLore (ArrayList<String> itemLore)   {
        this.itemLore = itemLore;
    }

}
