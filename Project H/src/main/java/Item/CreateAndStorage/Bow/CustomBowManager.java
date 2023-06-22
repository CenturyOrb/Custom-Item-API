package Item.CreateAndStorage.Bow;

import Item.CreateAndStorage.EnchantmentPlus;
import Item.CreateAndStorage.Offense.CustomOffense;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;

public class CustomBowManager {

    private HashMap<String, ItemStack> customBowItems = new HashMap<>();

    public CustomBowManager ()   { createItems();}

    private void createItems()  {

        /*--[ Parthian ]------------------------------------------------------------------------------------------*/

        ArrayList<EnchantmentPlus> ParthianEnchantments = new ArrayList<>();
        EnchantmentPlus ParthianEnchantment1 = new EnchantmentPlus(Enchantment.ARROW_DAMAGE, 5, true);
        EnchantmentPlus ParthianEnchantment2 = new EnchantmentPlus(Enchantment.ARROW_INFINITE, 1, true);
        EnchantmentPlus ParthianEnchantment3 = new EnchantmentPlus(Enchantment.ARROW_FIRE, 3, true);
        EnchantmentPlus ParthianEnchantment4 = new EnchantmentPlus(Enchantment.DURABILITY, 5, true);
            ParthianEnchantments.add(ParthianEnchantment1);
            ParthianEnchantments.add(ParthianEnchantment2);
            ParthianEnchantments.add(ParthianEnchantment3);
            ParthianEnchantments.add(ParthianEnchantment4);

        ArrayList<String> ParthianLore = new ArrayList<String>();
            ParthianLore.add(ChatColor.translateAlternateColorCodes('&',"&7Power V"));
            ParthianLore.add(ChatColor.translateAlternateColorCodes('&',"&7Infinity"));
            ParthianLore.add(ChatColor.translateAlternateColorCodes('&',"&7Flame II"));
            ParthianLore.add(ChatColor.translateAlternateColorCodes('&',"&7Unbreaking V"));
            ParthianLore.add(ChatColor.translateAlternateColorCodes('&', "&5&oBow stolen from the"));
            ParthianLore.add(ChatColor.translateAlternateColorCodes('&', "&5&ogod of fire"));
            ParthianLore.add(ChatColor.translateAlternateColorCodes('&', " "));
            ParthianLore.add(ChatColor.translateAlternateColorCodes('&', "&a- Cripples The Enemy"));
            ParthianLore.add(ChatColor.translateAlternateColorCodes('&', " "));
            ParthianLore.add(ChatColor.translateAlternateColorCodes('&', "&7Player Kills: 0"));

        CustomOffense Parthian = new CustomOffense(ChatColor.translateAlternateColorCodes('&', "&cParthian"),
                ParthianEnchantments,
                ParthianLore,
                Material.BOW,
                "Weakness", "Slowness", "N/A",
                100, 100, 0,
                0, 0, 0);
        customBowItems.put("Parthian", Parthian.getCustomItem());

    }

    public ItemStack getCustomBowItem (String key)   {
        return this.customBowItems.get(key);
    }

}
