package Item.CreateAndStorage.Offense;

import Item.CreateAndStorage.EnchantmentPlus;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class CustomOffenseManager {

    private HashMap<String, ItemStack> customOffenseItems = new HashMap<String, ItemStack>();

    public CustomOffenseManager ()   {
        createItems();
    }
    private void createItems() {

        /*--[ Elysium ]------------------------------------------------------------------------------------------*/

        ArrayList<EnchantmentPlus> ElysiumEnchantments = new ArrayList<>();
        EnchantmentPlus ElysiumEnchantment1 = new EnchantmentPlus(Enchantment.DAMAGE_ALL, 5, true);
        EnchantmentPlus ElysiumEnchantment2 = new EnchantmentPlus(Enchantment.DAMAGE_UNDEAD, 10, true);
        EnchantmentPlus ElysiumEnchantment3 = new EnchantmentPlus(Enchantment.DAMAGE_ARTHROPODS, 10, true);
        EnchantmentPlus ElysiumEnchantment4 = new EnchantmentPlus(Enchantment.DURABILITY, 8, true);
            ElysiumEnchantments.add(ElysiumEnchantment1);
            ElysiumEnchantments.add(ElysiumEnchantment2);
            ElysiumEnchantments.add(ElysiumEnchantment3);
            ElysiumEnchantments.add(ElysiumEnchantment4);

        ArrayList<String> ElysiumLore = new ArrayList<>();
            ElysiumLore.add(ChatColor.translateAlternateColorCodes('&', "&7Sharpness V"));
            ElysiumLore.add(ChatColor.translateAlternateColorCodes('&', "&7Smite X"));
            ElysiumLore.add(ChatColor.translateAlternateColorCodes('&', "&7Bane of Arthropods X"));
            ElysiumLore.add(ChatColor.translateAlternateColorCodes('&', "&7Unbreaking VIII"));
            ElysiumLore.add(ChatColor.translateAlternateColorCodes('&', "&5&oThe abode of the blessed"));
            ElysiumLore.add(ChatColor.translateAlternateColorCodes('&', "&5&oafter death"));
            ElysiumLore.add("");
            ElysiumLore.add(ChatColor.translateAlternateColorCodes('&', "&a- Disables Enemy Sprint"));
            ElysiumLore.add(ChatColor.translateAlternateColorCodes('&', "&a- Blinds The Enemy"));
            ElysiumLore.add("");
            ElysiumLore.add(ChatColor.translateAlternateColorCodes('&', "&7Player Kills: 0"));

        CustomOffense Elysium = new CustomOffense(ChatColor.translateAlternateColorCodes('&', "&cElysium"),
                ElysiumEnchantments,
                ElysiumLore,
                Material.IRON_HOE,
                "N/A", "N/A", "N/A",
                0, 0, 0,
                0, 0, 0);
        customOffenseItems.put("Elysium", Elysium.getCustomItem());

        /*--[ Stagnato ]------------------------------------------------------------------------------------------*/

        ArrayList<EnchantmentPlus> StagnatoEnchantments = new ArrayList<>();
        EnchantmentPlus StagnatoEnchantment1 = new EnchantmentPlus(Enchantment.DAMAGE_ALL, 10, true);
        EnchantmentPlus StagnatoEnchantment2 = new EnchantmentPlus(Enchantment.DAMAGE_UNDEAD, 2, true);
        EnchantmentPlus StagnatoEnchantment3 = new EnchantmentPlus(Enchantment.DURABILITY, 8, true);
        StagnatoEnchantments.add(StagnatoEnchantment1);
        StagnatoEnchantments.add(StagnatoEnchantment2);
        StagnatoEnchantments.add(StagnatoEnchantment3);

        ArrayList<String> StagnatoLore = new ArrayList<String>();
        StagnatoLore.add(ChatColor.translateAlternateColorCodes('&',"&7Sharpness X"));
        StagnatoLore.add(ChatColor.translateAlternateColorCodes('&',"&7Smite II"));
        StagnatoLore.add(ChatColor.translateAlternateColorCodes('&',"&7Unbreaking IV"));
        StagnatoLore.add(ChatColor.translateAlternateColorCodes('&',"&5&oFleeing from this sword"));
        StagnatoLore.add(ChatColor.translateAlternateColorCodes('&',"&5&ois futile"));
        StagnatoLore.add("");
        StagnatoLore.add(ChatColor.translateAlternateColorCodes('&', "&a- Slows The Enemy"));
        StagnatoLore.add("");
        StagnatoLore.add(ChatColor.translateAlternateColorCodes('&', "&7Player Kills: 0"));

        CustomOffense Stagnato = new CustomOffense(ChatColor.translateAlternateColorCodes('&', "&cStagnato"),
                StagnatoEnchantments,
                StagnatoLore,
                Material.STONE_SWORD,
                "Slowness", "N/A", "N/A",
                100, 0, 0,
                0, 0, 0);
        customOffenseItems.put("Stagnato", Stagnato.getCustomItem());

        /*--[ Tetherius ]---------------------------------------------------------------------------------------*/

        ArrayList<EnchantmentPlus> TetheriusEnchantments = new ArrayList<>();
        EnchantmentPlus TetheriusEnchantment1 = new EnchantmentPlus(Enchantment.DAMAGE_ALL, 17, true);
        TetheriusEnchantments.add(TetheriusEnchantment1);

        ArrayList<String> TetheriusLore = new ArrayList<String>();
        TetheriusLore.add(ChatColor.translateAlternateColorCodes('&',"&7Sharpness XVII"));
        TetheriusLore.add(ChatColor.translateAlternateColorCodes('&',"&5&oTrembling as the chains"));
        TetheriusLore.add(ChatColor.translateAlternateColorCodes('&',"&5&oseals your fate"));
        TetheriusLore.add("");
        TetheriusLore.add(ChatColor.translateAlternateColorCodes('&', "&a- Binds The Enemy"));

        CustomOffense Tetherius = new CustomOffense(ChatColor.translateAlternateColorCodes('&', "&c&lTetherius"),
                TetheriusEnchantments,
                TetheriusLore,
                Material.DIAMOND_SWORD,
                "N/A", "N/A", "N/A",
                0, 0, 0,
                0, 0, 0);
        customOffenseItems.put("Tetherius", Tetherius.getCustomItem());

        /*--[ Sorrow Blade ]-----------------------------------------------------------------------------------*/

        ArrayList<EnchantmentPlus> SorrowbladeEnchantments = new ArrayList<>();
        EnchantmentPlus SorrowbladeEnchantment1 = new EnchantmentPlus(Enchantment.DAMAGE_ALL, 13, true);
        SorrowbladeEnchantments.add(SorrowbladeEnchantment1);

        ArrayList<String> SorrowbladeLore = new ArrayList<String>();
        SorrowbladeLore.add(ChatColor.translateAlternateColorCodes('&',"&7Sharpness XIII"));
        SorrowbladeLore.add(ChatColor.translateAlternateColorCodes('&',"&5&oDown goes your health"));
        SorrowbladeLore.add(ChatColor.translateAlternateColorCodes('&',"&5&obar, oh no"));
        SorrowbladeLore.add("");
        SorrowbladeLore.add(ChatColor.translateAlternateColorCodes('&', "&a- Disables God Foods"));

        CustomOffense Sorrowblade = new CustomOffense(ChatColor.translateAlternateColorCodes('&', "&c&lSorrow Blade"),
                SorrowbladeEnchantments,
                SorrowbladeLore,
                Material.NETHERITE_AXE,
                "N/A", "N/A", "N/A",
                0, 0, 0,
                0, 0, 0);
        customOffenseItems.put("Sorrow Blade", Sorrowblade.getCustomItem());

        /*--[ Magnar ]-----------------------------------------------------------------------------------------*/

        ArrayList<EnchantmentPlus> MagnarEnchantments = new ArrayList<>();
        EnchantmentPlus MagnarEnchantment1 = new EnchantmentPlus(Enchantment.DAMAGE_ALL, 13, true);
        EnchantmentPlus MagnarEnchantment2 = new EnchantmentPlus(Enchantment.DURABILITY, 5, true);
        EnchantmentPlus MagnarEnchantment3 = new EnchantmentPlus(Enchantment.KNOCKBACK, 2, true);
        MagnarEnchantments.add(MagnarEnchantment1);
        MagnarEnchantments.add(MagnarEnchantment2);
        MagnarEnchantments.add(MagnarEnchantment3);

        ArrayList<String> MagnarLore = new ArrayList<String>();
        MagnarLore.add(ChatColor.translateAlternateColorCodes('&', "&7Sharpness XXI"));
        MagnarLore.add(ChatColor.translateAlternateColorCodes('&', "&7Unbreaking V"));
        MagnarLore.add(ChatColor.translateAlternateColorCodes('&', "&7Knockback II"));
        MagnarLore.add(ChatColor.translateAlternateColorCodes('&', "&5&oThey that die by famine"));
        MagnarLore.add(ChatColor.translateAlternateColorCodes('&', "&5&odie by inches"));
        MagnarLore.add(ChatColor.translateAlternateColorCodes('&', " "));
        MagnarLore.add(ChatColor.translateAlternateColorCodes('&', "&a- Starves The Enemy"));
        MagnarLore.add(ChatColor.translateAlternateColorCodes('&', " "));
        MagnarLore.add(ChatColor.translateAlternateColorCodes('&', "&7Player Kills: 0"));

        CustomOffense Magnar = new CustomOffense(ChatColor.translateAlternateColorCodes('&', "&cMagnar"),
                MagnarEnchantments,
                MagnarLore,
                Material.DIAMOND_AXE,
                "N/A", "N/A", "N/A",
                0, 0, 0,
                0, 0, 0);
        customOffenseItems.put("Magnar", Magnar.getCustomItem());

        /*--[ Shadow Step ]------------------------------------------------------------------------------------*/

        ArrayList<EnchantmentPlus> ShadowstepEnchantments = new ArrayList<>();
        EnchantmentPlus ShadowstepEnchantment1 = new EnchantmentPlus(Enchantment.KNOCKBACK, 2, true);
        EnchantmentPlus ShadowstepEnchantment2 = new EnchantmentPlus(Enchantment.DURABILITY, 1, true);
        ShadowstepEnchantments.add(ShadowstepEnchantment1);
        ShadowstepEnchantments.add(ShadowstepEnchantment2);

        ArrayList<String> ShadowstepLore = new ArrayList<String>();
        ShadowstepLore.add(ChatColor.translateAlternateColorCodes('&', "&7Knockback II"));
        ShadowstepLore.add(ChatColor.translateAlternateColorCodes('&', "&7Unbreaking I"));
        ShadowstepLore.add(ChatColor.translateAlternateColorCodes('&', "&5&oLost art of the shinobi"));

        CustomOffense Shadowstep = new CustomOffense(ChatColor.translateAlternateColorCodes('&', "&c&lShadow Step"),
                ShadowstepEnchantments,
                ShadowstepLore,
                Material.FISHING_ROD,
                "N/A", "N/A", "N/A",
                0, 0, 0,
                0, 0, 0);
        customOffenseItems.put("Shadow Step", Shadowstep.getCustomItem());

        /*--[ Trishula ]------------------------------------------------------------------------------------*/

        ArrayList<EnchantmentPlus> TrishulaEnchantments = new ArrayList<>();
        EnchantmentPlus TrishulaEnchantment1 = new EnchantmentPlus(Enchantment.DAMAGE_ALL, 12, true);
        EnchantmentPlus TrishulaEnchantment2 = new EnchantmentPlus(Enchantment.RIPTIDE, 3, true);
        TrishulaEnchantments.add(TrishulaEnchantment1);
        TrishulaEnchantments.add(TrishulaEnchantment2);

        ArrayList<String> TrishulaLore = new ArrayList<String>();
        TrishulaLore.add(ChatColor.translateAlternateColorCodes('&', "&7Sharpness XII"));
        TrishulaLore.add(ChatColor.translateAlternateColorCodes('&', "&7Riptide III"));
        TrishulaLore.add(ChatColor.translateAlternateColorCodes('&', "&5&oMay it's wielder never"));
        TrishulaLore.add(ChatColor.translateAlternateColorCodes('&', "&5&obe out of their depth"));
        TrishulaLore.add("");
        TrishulaLore.add(ChatColor.translateAlternateColorCodes('&', "&a- Water Adaptation"));

        CustomOffense Trishula = new CustomOffense(ChatColor.translateAlternateColorCodes('&', "&c&lTrishula"),
                TrishulaEnchantments,
                TrishulaLore,
                Material.TRIDENT,
                "N/A", "N/A", "N/A",
                0, 0, 0,
                0, 0, 0);
        customOffenseItems.put("Trishula", Trishula.getCustomItem());

        /*--[ Ancilia ]------------------------------------------------------------------------------------*/

        ArrayList<EnchantmentPlus> AnciliaEnchantments = new ArrayList<>();
        EnchantmentPlus AnciliaEnchantment1 = new EnchantmentPlus(Enchantment.DURABILITY, 10, true);
        AnciliaEnchantments.add(AnciliaEnchantment1);

        ArrayList<String> AnciliaLore = new ArrayList<String>();
        AnciliaLore.add(ChatColor.translateAlternateColorCodes('&',"&7Unbreaking X"));
        AnciliaLore.add(ChatColor.translateAlternateColorCodes('&',"&5&oSacred shield from the Temple"));
        AnciliaLore.add(ChatColor.translateAlternateColorCodes('&',"&5&oof Mars, the God of War"));
        AnciliaLore.add("");
        AnciliaLore.add(ChatColor.translateAlternateColorCodes('&', "&a- Sword Parry"));


        CustomOffense Ancilia = new CustomOffense(ChatColor.translateAlternateColorCodes('&', "&c&lAncilia"),
                AnciliaEnchantments,
                AnciliaLore,
                Material.SHIELD,
                "N/A", "N/A", "N/A",
                0, 0, 0,
                0, 0, 0);
        customOffenseItems.put("Ancilia", Ancilia.getCustomItem());

        /*--[ Xiphos ]---------------------------------------------------------------------------------------*/

        ArrayList<EnchantmentPlus> XiphosEnchantments = new ArrayList<>();
        EnchantmentPlus XiphosEnchantment1 = new EnchantmentPlus(Enchantment.DURABILITY, 10, true);
        XiphosEnchantments.add(XiphosEnchantment1);

        ArrayList<String> XiphosLore = new ArrayList<String>();
        XiphosLore.add(ChatColor.translateAlternateColorCodes('&',"&7Unbreaking X"));
        XiphosLore.add(ChatColor.translateAlternateColorCodes('&',"&5&oSword that can penetrate"));
        XiphosLore.add(ChatColor.translateAlternateColorCodes('&',"&5&olight"));
        XiphosLore.add("");
        XiphosLore.add(ChatColor.translateAlternateColorCodes('&', "&a- Armor Pierce"));
        XiphosLore.add("");
        XiphosLore.add(ChatColor.translateAlternateColorCodes('&', "&7Player Kills: 0"));

        CustomOffense Xiphos = new CustomOffense(ChatColor.translateAlternateColorCodes('&', "&cXiphos"),
                XiphosEnchantments,
                XiphosLore,
                Material.IRON_SWORD,
                "N/A", "N/A", "N/A",
                0, 0, 0,
                0, 0, 0);
        customOffenseItems.put("Xiphos", Xiphos.getCustomItem());

    }

    public ItemStack getCustomOffenseItem (String key)    {
        return this.customOffenseItems.get(key);
    }

}
