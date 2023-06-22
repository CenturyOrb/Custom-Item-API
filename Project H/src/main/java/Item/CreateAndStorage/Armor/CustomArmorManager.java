package Item.CreateAndStorage.Armor;

import Item.CreateAndStorage.EnchantmentPlus;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class CustomArmorManager {

    private final AttributeModifier diamondHelmetArmorModifier =   new AttributeModifier(UUID.randomUUID(), "generic.armor", 3.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
    private final AttributeModifier diamondHelmetArmorToughnessModifier =   new AttributeModifier(UUID.randomUUID(), "generic.armor.toughness", 2.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);

    private final AttributeModifier diamondChestplateArmorModifier =   new AttributeModifier(UUID.randomUUID(), "generic.armor", 8.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
    private final AttributeModifier diamondChestplateArmorToughnessModifier =   new AttributeModifier(UUID.randomUUID(), "generic.armor.toughness", 2.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);

    private AttributeModifier diamondLeggingsArmorModifier =   new AttributeModifier(UUID.randomUUID(), "generic.armor", 6.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
    private AttributeModifier diamondLeggingsArmorToughnessModifier =   new AttributeModifier(UUID.randomUUID(), "generic.armor.toughness", 2.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);

    private final AttributeModifier diamondBootsArmorModifier =   new AttributeModifier(UUID.randomUUID(), "generic.armor", 3.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
    private final AttributeModifier diamondBootsArmorToughnessModifier =   new AttributeModifier(UUID.randomUUID(), "generic.armor.toughness", 2.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);


    private final AttributeModifier ironHelmetArmorModifier =   new AttributeModifier(UUID.randomUUID(), "generic.armor", 2.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
    private final AttributeModifier ironHelmetArmorToughnessModifier =   new AttributeModifier(UUID.randomUUID(), "generic.armor.toughness", 0.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);

    private final AttributeModifier ironChestplateArmorModifier =   new AttributeModifier(UUID.randomUUID(), "generic.armor", 6.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
    private final AttributeModifier ironChestplateArmorToughnessModifier =   new AttributeModifier(UUID.randomUUID(), "generic.armor.toughness", 0.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);

    private final AttributeModifier ironLeggingsArmorModifier =   new AttributeModifier(UUID.randomUUID(), "generic.armor", 5.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
    private final AttributeModifier ironLeggingsArmorToughnessModifier =   new AttributeModifier(UUID.randomUUID(), "generic.armor.toughness", 0.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);

    private final AttributeModifier ironBootsArmorModifier =   new AttributeModifier(UUID.randomUUID(), "generic.armor", 2.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
    private final AttributeModifier ironBootsArmorToughnessModifier =   new AttributeModifier(UUID.randomUUID(), "generic.armor.toughness", 0.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);


    private final AttributeModifier leatherHelmetArmorModifier =   new AttributeModifier(UUID.randomUUID(), "generic.armor", 1.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
    private final AttributeModifier leatherHelmetArmorToughnessModifier =   new AttributeModifier(UUID.randomUUID(), "generic.armor.toughness", 0.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);

    private final AttributeModifier leatherChestplateArmorModifier =   new AttributeModifier(UUID.randomUUID(), "generic.armor", 3.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
    private final AttributeModifier leatherChestplateArmorToughnessModifier =   new AttributeModifier(UUID.randomUUID(), "generic.armor.toughness", 0.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);

    private final AttributeModifier leatherLeggingsArmorModifier =   new AttributeModifier(UUID.randomUUID(), "generic.armor", 2.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
    private final AttributeModifier leatherLeggingsArmorToughnessModifier =   new AttributeModifier(UUID.randomUUID(), "generic.armor.toughness", 0.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);

    private final AttributeModifier leatherBootsArmorModifier =   new AttributeModifier(UUID.randomUUID(), "generic.armor", 1.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
    private final AttributeModifier leatherBootsArmorToughnessModifier =   new AttributeModifier(UUID.randomUUID(), "generic.armor.toughness", 0.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);


    private final AttributeModifier chainmailHelmetArmorModifier =   new AttributeModifier(UUID.randomUUID(), "generic.armor", 2.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
    private final AttributeModifier chainmailHelmetArmorToughnessModifier =   new AttributeModifier(UUID.randomUUID(), "generic.armor.toughness", 0.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);

    private final AttributeModifier chainmailChestplateArmorModifier =   new AttributeModifier(UUID.randomUUID(), "generic.armor", 5.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
    private final AttributeModifier chainmailChestplateArmorToughnessModifier =   new AttributeModifier(UUID.randomUUID(), "generic.armor.toughness", 0.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);

    private final AttributeModifier chainmailLeggingsArmorModifier =   new AttributeModifier(UUID.randomUUID(), "generic.armor", 4.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
    private final AttributeModifier chainmailLeggingsArmorToughnessModifier =   new AttributeModifier(UUID.randomUUID(), "generic.armor.toughness", 0.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);

    private final AttributeModifier chainmailBootsArmorModifier =   new AttributeModifier(UUID.randomUUID(), "generic.armor", 1.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
    private final AttributeModifier chainmailBootsArmorToughnessModifier =   new AttributeModifier(UUID.randomUUID(), "generic.armor.toughness", 0.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);


    private final AttributeModifier netheriteChestplateArmorModifier =   new AttributeModifier(UUID.randomUUID(), "generic.armor", 8.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
    private final AttributeModifier netheriteChestplateArmorToughnessModifier =   new AttributeModifier(UUID.randomUUID(), "generic.armor.toughness", 3.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
    private final AttributeModifier netheriteChestplateKnockbackResistance =   new AttributeModifier(UUID.randomUUID(), "generic.knockback_resistance", 0.2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);

    private HashMap<String, ItemStack> customArmorItems = new HashMap<>();

    public CustomArmorManager ()    {
        createItems();
    }

    private void createItems()   {

        /*--[ Corinthian ]------------------------------------------------------------------------------------------*/

        ArrayList<EnchantmentPlus> CorinthianEnchantments = new ArrayList<>();
        EnchantmentPlus CorinthianEnchantment1 = new EnchantmentPlus(Enchantment.PROTECTION_ENVIRONMENTAL, 8, true);
        CorinthianEnchantments.add(CorinthianEnchantment1);

        ArrayList<String> CorinthianLore = new ArrayList<String>();
        CorinthianLore.add(ChatColor.translateAlternateColorCodes('&',"&7Protection VIII"));
        CorinthianLore.add(ChatColor.translateAlternateColorCodes('&',"&7Unbreaking VI"));
        CorinthianLore.add(ChatColor.translateAlternateColorCodes('&',"&5&oStolen by the great defender"));
        CorinthianLore.add(ChatColor.translateAlternateColorCodes('&',"&5&oa millennium ago"));
        CorinthianLore.add("");
        CorinthianLore.add(ChatColor.translateAlternateColorCodes('&', "&a- Increase Health Pool 20%"));
        CorinthianLore.add(ChatColor.translateAlternateColorCodes('&', "&a- Immune to Blindness"));
        CorinthianLore.add("");
        CorinthianLore.add(ChatColor.translateAlternateColorCodes('&', "&7When on Head:"));
        CorinthianLore.add(ChatColor.translateAlternateColorCodes('&', "&9+3 Armor"));
        CorinthianLore.add(ChatColor.translateAlternateColorCodes('&', "&9+2 Armor Toughness"));

        AttributeModifier CorinthianModifier = new AttributeModifier(UUID.randomUUID(),"Corinthian Health", 4.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);

        CustomArmor Corinthian = new CustomArmor(ChatColor.translateAlternateColorCodes('&', "&cCorinthian"),
                CorinthianEnchantments,
                CorinthianLore,
                Material.DIAMOND_HELMET,
                "N/A", "N/A", "N/A",
                0, 0, 0,
                690, 690,
                CorinthianModifier, diamondHelmetArmorModifier, diamondHelmetArmorToughnessModifier);
        customArmorItems.put("Corinthian", Corinthian.getCustomItem());

        /*--[ Aphaia ]------------------------------------------------------------------------------------------*/

        ArrayList<EnchantmentPlus> AphaiaEnchantments = new ArrayList<>();
        EnchantmentPlus AphaiaEnchantment1 = new EnchantmentPlus(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
        EnchantmentPlus AphaiaEnchantment2 = new EnchantmentPlus(Enchantment.PROTECTION_EXPLOSIONS, 5, true);
        EnchantmentPlus AphaiaEnchantment3 = new EnchantmentPlus(Enchantment.PROTECTION_PROJECTILE, 5, true);
        EnchantmentPlus AphaiaEnchantment4 = new EnchantmentPlus(Enchantment.PROTECTION_FIRE, 5, true);
        AphaiaEnchantments.add(AphaiaEnchantment1);
        AphaiaEnchantments.add(AphaiaEnchantment2);
        AphaiaEnchantments.add(AphaiaEnchantment3);
        AphaiaEnchantments.add(AphaiaEnchantment4);

        ArrayList<String> AphaiaLore = new ArrayList<String>();
        AphaiaLore.add(ChatColor.translateAlternateColorCodes('&',"&7Protection V"));
        AphaiaLore.add(ChatColor.translateAlternateColorCodes('&',"&7Blast Protection V"));
        AphaiaLore.add(ChatColor.translateAlternateColorCodes('&',"&7Projectile Protection V"));
        AphaiaLore.add(ChatColor.translateAlternateColorCodes('&',"&7Fire Protection V"));
        AphaiaLore.add(ChatColor.translateAlternateColorCodes('&',"&7Unbreaking V"));
        AphaiaLore.add(ChatColor.translateAlternateColorCodes('&',"&5&oBattle cries shall be"));
        AphaiaLore.add(ChatColor.translateAlternateColorCodes('&',"&5&oheard from hell"));
        AphaiaLore.add("");
        AphaiaLore.add(ChatColor.translateAlternateColorCodes('&', "&a- Increases Strength"));
        AphaiaLore.add("");
        AphaiaLore.add(ChatColor.translateAlternateColorCodes('&', "&7When on Body:"));
        AphaiaLore.add(ChatColor.translateAlternateColorCodes('&', "&9+8 Armor"));
        AphaiaLore.add(ChatColor.translateAlternateColorCodes('&', "&9+2 Armor Toughness"));

        AttributeModifier AphaiaModifier = new AttributeModifier(UUID.randomUUID(), "Aphaia Health", 0.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);


        CustomArmor Aphaia = new CustomArmor(ChatColor.translateAlternateColorCodes('&', "&cAphaia"),
                AphaiaEnchantments,
                AphaiaLore,
                Material.DIAMOND_CHESTPLATE,
                "Strength", "N/A", "N/A",
                0, 0, 0,
                690, 690,
                AphaiaModifier, diamondChestplateArmorModifier, diamondChestplateArmorToughnessModifier);
        customArmorItems.put("Aphaia", Aphaia.getCustomItem());

        /*--[ Thorax ]------------------------------------------------------------------------------------------*/

        ArrayList<EnchantmentPlus> ThoraxEnchantments = new ArrayList<>();
        EnchantmentPlus ThoraxEnchantment1 = new EnchantmentPlus(Enchantment.PROTECTION_ENVIRONMENTAL, 10, true);
        EnchantmentPlus ThoraxEnchantment2 = new EnchantmentPlus(Enchantment.PROTECTION_EXPLOSIONS, 6, true);
        ThoraxEnchantments.add(ThoraxEnchantment1);
        ThoraxEnchantments.add(ThoraxEnchantment2);

        ArrayList<String> ThoraxLore = new ArrayList<String>();
        ThoraxLore.add(ChatColor.translateAlternateColorCodes('&',"&7Protection X"));
        ThoraxLore.add(ChatColor.translateAlternateColorCodes('&',"&7Fire Protection VI"));
        ThoraxLore.add(ChatColor.translateAlternateColorCodes('&',"&7Unbreaking IX"));
        ThoraxLore.add(ChatColor.translateAlternateColorCodes('&',"&5&oFrom the remains of a"));
        ThoraxLore.add(ChatColor.translateAlternateColorCodes('&',"&5&ogiant bunny"));
        ThoraxLore.add("");
        ThoraxLore.add(ChatColor.translateAlternateColorCodes('&', "&a- Increase Health Pool 20%"));
        ThoraxLore.add(ChatColor.translateAlternateColorCodes('&', "&a- Increases Jump Height 100%"));
        ThoraxLore.add("");
        ThoraxLore.add(ChatColor.translateAlternateColorCodes('&', "&7When on Legs:"));
        ThoraxLore.add(ChatColor.translateAlternateColorCodes('&', "&9+6 Armor"));
        ThoraxLore.add(ChatColor.translateAlternateColorCodes('&', "&9+2 Armor Toughness"));

        AttributeModifier ThoraxModifier = new AttributeModifier(UUID.randomUUID(),"Thorax Health", 4.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);

        CustomArmor Thorax = new CustomArmor(ChatColor.translateAlternateColorCodes('&', "&cThorax"),
                ThoraxEnchantments,
                ThoraxLore,
                Material.DIAMOND_LEGGINGS,
                "Jump", "N/A", "N/A",
                1, 0, 0,
                690, 690,
                ThoraxModifier, diamondLeggingsArmorModifier, diamondLeggingsArmorToughnessModifier);
        customArmorItems.put("Thorax", Thorax.getCustomItem());

        /*--[ Halcyon Chargers ]------------------------------------------------------------------------------------------*/

        ArrayList<EnchantmentPlus> HalcyonChargersEnchantments = new ArrayList<>();
        EnchantmentPlus HalcyonChargersEnchantment1 = new EnchantmentPlus(Enchantment.PROTECTION_ENVIRONMENTAL, 10, true);
        EnchantmentPlus HalcyonChargersEnchantment2 = new EnchantmentPlus(Enchantment.PROTECTION_FALL, 8, true);
        HalcyonChargersEnchantments.add(HalcyonChargersEnchantment1);
        HalcyonChargersEnchantments.add(HalcyonChargersEnchantment2);

        ArrayList<String> HalcyonChargersLore = new ArrayList<String>();
        HalcyonChargersLore.add(ChatColor.translateAlternateColorCodes('&',"&7Protection X"));
        HalcyonChargersLore.add(ChatColor.translateAlternateColorCodes('&',"&7Feather Falling VIII"));
        HalcyonChargersLore.add(ChatColor.translateAlternateColorCodes('&',"&7Unbreaking IX"));
        HalcyonChargersLore.add(ChatColor.translateAlternateColorCodes('&',"&5&oTravellers of Halcyon"));
        HalcyonChargersLore.add(ChatColor.translateAlternateColorCodes('&',"&5&oswear by these boots"));
        HalcyonChargersLore.add("");
        HalcyonChargersLore.add(ChatColor.translateAlternateColorCodes('&', "&a- Increase Health Pool 10%"));
        HalcyonChargersLore.add(ChatColor.translateAlternateColorCodes('&', "&a- Increases Movement Speed 40%"));
        HalcyonChargersLore.add("");
        HalcyonChargersLore.add(ChatColor.translateAlternateColorCodes('&', "&7When on Feet:"));
        HalcyonChargersLore.add(ChatColor.translateAlternateColorCodes('&', "&9+3 Armor"));
        HalcyonChargersLore.add(ChatColor.translateAlternateColorCodes('&', "&9+2 Armor Toughness"));

        AttributeModifier HalcyonChargersModifier = new AttributeModifier(UUID.randomUUID(), "Halcyon Chargers Health", 2.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);

        CustomArmor  HalcyonChargers = new CustomArmor(ChatColor.translateAlternateColorCodes('&', "&cHalcyon Chargers"),
                HalcyonChargersEnchantments,
                HalcyonChargersLore,
                Material.DIAMOND_BOOTS,
                "Speed", "N/A", "N/A",
                1, 0, 0,
                690, 690,
                HalcyonChargersModifier, diamondBootsArmorModifier, diamondBootsArmorToughnessModifier);
        customArmorItems.put("Halcyon Chargers",  HalcyonChargers.getCustomItem());

        /*--[ Illrian ]------------------------------------------------------------------------------------------*/

        ArrayList<EnchantmentPlus> IllrianEnchantments = new ArrayList<>();
        EnchantmentPlus IllrianEnchantment1 = new EnchantmentPlus(Enchantment.PROTECTION_ENVIRONMENTAL, 6, true);
        EnchantmentPlus IllrianEnchantment2 = new EnchantmentPlus(Enchantment.PROTECTION_PROJECTILE, 3, true);
        IllrianEnchantments.add(IllrianEnchantment1);
        IllrianEnchantments.add(IllrianEnchantment2);

        ArrayList<String> IllrianLore = new ArrayList<String>();
        IllrianLore.add(ChatColor.translateAlternateColorCodes('&',"&7Protection VI"));
        IllrianLore.add(ChatColor.translateAlternateColorCodes('&',"&7Projectile Protection III"));
        IllrianLore.add(ChatColor.translateAlternateColorCodes('&',"&7Unbreaking V"));
        IllrianLore.add(ChatColor.translateAlternateColorCodes('&',"&5&oWar does not determine who"));
        IllrianLore.add(ChatColor.translateAlternateColorCodes('&',"&5&ois right, only who is left"));
        IllrianLore.add("");
        IllrianLore.add(ChatColor.translateAlternateColorCodes('&', "&a- Increase Health Pool 20%"));
        IllrianLore.add("");
        IllrianLore.add(ChatColor.translateAlternateColorCodes('&', "&aSet Bonus:"));
        IllrianLore.add(ChatColor.translateAlternateColorCodes('&', "&a(3) Immune to Slowness"));
        IllrianLore.add(ChatColor.translateAlternateColorCodes('&', "&d(4) Hestia's Blessing"));
        IllrianLore.add("");
        IllrianLore.add(ChatColor.translateAlternateColorCodes('&', "&7When on Head:"));
        IllrianLore.add(ChatColor.translateAlternateColorCodes('&', "&9+2 Armor"));

        AttributeModifier IllrianModifier = new AttributeModifier(UUID.randomUUID(), "Illrian Health", 4.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);

        CustomArmor  Illrian = new CustomArmor(ChatColor.translateAlternateColorCodes('&', "&cIllrian"),
                IllrianEnchantments,
                IllrianLore,
                Material.IRON_HELMET,
                "N/A", "N/A", "N/A",
                0, 0, 0,
                690, 690,
                IllrianModifier, ironHelmetArmorModifier, ironHelmetArmorToughnessModifier);
        customArmorItems.put("Illrian",  Illrian.getCustomItem());

        /*--[ Guardian Plates ]------------------------------------------------------------------------------------------*/

        ArrayList<EnchantmentPlus> GuardianPlatesEnchantments = new ArrayList<>();
        EnchantmentPlus GuardianPlatesEnchantment1 = new EnchantmentPlus(Enchantment.PROTECTION_ENVIRONMENTAL, 7, true);
        EnchantmentPlus GuardianPlatesEnchantment2 = new EnchantmentPlus(Enchantment.PROTECTION_EXPLOSIONS, 5, true);
        EnchantmentPlus GuardianPlatesEnchantment3 = new EnchantmentPlus(Enchantment.PROTECTION_FIRE, 1, true);
        GuardianPlatesEnchantments.add(GuardianPlatesEnchantment1);
        GuardianPlatesEnchantments.add(GuardianPlatesEnchantment2);
        GuardianPlatesEnchantments.add(GuardianPlatesEnchantment3);

        ArrayList<String> GuardianPlatesLore = new ArrayList<String>();
        GuardianPlatesLore.add(ChatColor.translateAlternateColorCodes('&',"&7Protection VII"));
        GuardianPlatesLore.add(ChatColor.translateAlternateColorCodes('&',"&7Blast Protection V"));
        GuardianPlatesLore.add(ChatColor.translateAlternateColorCodes('&',"&7Fire Protection I"));
        GuardianPlatesLore.add(ChatColor.translateAlternateColorCodes('&',"&7Unbreaking V"));
        GuardianPlatesLore.add(ChatColor.translateAlternateColorCodes('&',"&5&oI've always felt like I had"));
        GuardianPlatesLore.add(ChatColor.translateAlternateColorCodes('&',"&5&oa guardian angel"));
        GuardianPlatesLore.add("");
        GuardianPlatesLore.add(ChatColor.translateAlternateColorCodes('&', "&a- Increase Health Pool 20%"));
        GuardianPlatesLore.add("");
        GuardianPlatesLore.add(ChatColor.translateAlternateColorCodes('&', "&aSet Bonus:"));
        GuardianPlatesLore.add(ChatColor.translateAlternateColorCodes('&', "&a(3) Immune to Slowness"));
        GuardianPlatesLore.add(ChatColor.translateAlternateColorCodes('&', "&d(4) Hestia's Blessing"));
        GuardianPlatesLore.add("");
        GuardianPlatesLore.add(ChatColor.translateAlternateColorCodes('&', "&7When on Body:"));
        GuardianPlatesLore.add(ChatColor.translateAlternateColorCodes('&', "&9+6 Armor"));

        AttributeModifier GuardianPlatesModifier = new AttributeModifier(UUID.randomUUID(), "Guardian Plates Health", 4.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);

        CustomArmor  GuardianPlates = new CustomArmor(ChatColor.translateAlternateColorCodes('&', "&cGuardian Plates"),
                GuardianPlatesEnchantments,
                GuardianPlatesLore,
                Material.IRON_CHESTPLATE,
                "N/A", "N/A", "N/A",
                0, 0, 0,
                690, 690,
                GuardianPlatesModifier, ironChestplateArmorModifier, ironChestplateArmorToughnessModifier);
        customArmorItems.put("Guardian Plates",  GuardianPlates.getCustomItem());

        /*--[ Chausses ]------------------------------------------------------------------------------------------*/

        ArrayList<EnchantmentPlus> ChaussesEnchantments = new ArrayList<>();
        EnchantmentPlus ChaussesEnchantment1 = new EnchantmentPlus(Enchantment.PROTECTION_ENVIRONMENTAL, 7, true);
        EnchantmentPlus ChaussesEnchantment2 = new EnchantmentPlus(Enchantment.PROTECTION_EXPLOSIONS, 5, true);
        ChaussesEnchantments.add(ChaussesEnchantment1);
        ChaussesEnchantments.add(ChaussesEnchantment2);

        ArrayList<String> ChaussesLore = new ArrayList<String>();
        ChaussesLore.add(ChatColor.translateAlternateColorCodes('&',"&7Protection VII"));
        ChaussesLore.add(ChatColor.translateAlternateColorCodes('&',"&7Fire Protection V"));
        ChaussesLore.add(ChatColor.translateAlternateColorCodes('&',"&7Unbreaking IV"));
        ChaussesLore.add(ChatColor.translateAlternateColorCodes('&',"&5&oWyvern scales of ancient"));
        ChaussesLore.add(ChatColor.translateAlternateColorCodes('&',"&5&otimes"));
        ChaussesLore.add("");
        ChaussesLore.add(ChatColor.translateAlternateColorCodes('&', "&a- Increase Health Pool 10%"));
        ChaussesLore.add("");
        ChaussesLore.add(ChatColor.translateAlternateColorCodes('&', "&aSet Bonus:"));
        ChaussesLore.add(ChatColor.translateAlternateColorCodes('&', "&a(3) Immune to Slowness"));
        ChaussesLore.add(ChatColor.translateAlternateColorCodes('&', "&d(4) Hestia's Blessing"));
        ChaussesLore.add("");
        ChaussesLore.add(ChatColor.translateAlternateColorCodes('&', "&7When on Legs:"));
        ChaussesLore.add(ChatColor.translateAlternateColorCodes('&', "&9+5 Armor"));

        AttributeModifier ChaussesModifier = new AttributeModifier(UUID.randomUUID(), "Chausses Health", 2.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);

        CustomArmor  Chausses = new CustomArmor(ChatColor.translateAlternateColorCodes('&', "&cChausses"),
                ChaussesEnchantments,
                ChaussesLore,
                Material.IRON_LEGGINGS,
                "N/A", "N/A", "N/A",
                0, 0, 0,
                690, 690,
                ChaussesModifier, ironLeggingsArmorModifier, ironLeggingsArmorToughnessModifier);
        customArmorItems.put("Chausses",  Chausses.getCustomItem());

        /*--[ War Treads ]------------------------------------------------------------------------------------------*/

        ArrayList<EnchantmentPlus> WarTreadsEnchantments = new ArrayList<>();
        EnchantmentPlus WarTreadsEnchantment1 = new EnchantmentPlus(Enchantment.PROTECTION_ENVIRONMENTAL, 6, true);
        EnchantmentPlus WarTreadsEnchantment2 = new EnchantmentPlus(Enchantment.PROTECTION_FALL, 6, true);
        WarTreadsEnchantments.add(WarTreadsEnchantment1);
        WarTreadsEnchantments.add(WarTreadsEnchantment2);

        ArrayList<String> WarTreadsLore = new ArrayList<String>();
        WarTreadsLore.add(ChatColor.translateAlternateColorCodes('&',"&7Protection VI"));
        WarTreadsLore.add(ChatColor.translateAlternateColorCodes('&',"&7Feather Falling VIII"));
        WarTreadsLore.add(ChatColor.translateAlternateColorCodes('&',"&7Unbreaking VI"));
        WarTreadsLore.add(ChatColor.translateAlternateColorCodes('&',"&5&oFleeing from battle is for"));
        WarTreadsLore.add(ChatColor.translateAlternateColorCodes('&',"&5&othe cowardly"));
        WarTreadsLore.add("");
        WarTreadsLore.add(ChatColor.translateAlternateColorCodes('&', "&a- Increase Health Pool 20%"));
        WarTreadsLore.add("");
        WarTreadsLore.add(ChatColor.translateAlternateColorCodes('&', "&aSet Bonus:"));
        WarTreadsLore.add(ChatColor.translateAlternateColorCodes('&', "&a(3) Immune to Slowness"));
        WarTreadsLore.add(ChatColor.translateAlternateColorCodes('&', "&d(4) Hestia's Blessing"));
        WarTreadsLore.add("");
        WarTreadsLore.add(ChatColor.translateAlternateColorCodes('&', "&7When on Feet:"));
        WarTreadsLore.add(ChatColor.translateAlternateColorCodes('&', "&9+2 Armor"));

        AttributeModifier WarTreadsModifier = new AttributeModifier(UUID.randomUUID(), "War Treads Health", 4.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);

        CustomArmor WarTreads = new CustomArmor(ChatColor.translateAlternateColorCodes('&', "&cWar Treads"),
                WarTreadsEnchantments,
                WarTreadsLore,
                Material.IRON_BOOTS,
                "N/A", "N/A", "N/A",
                0, 0, 0,
                690, 690,
                WarTreadsModifier, ironBootsArmorModifier, ironBootsArmorToughnessModifier);
        customArmorItems.put("War Treads",  WarTreads.getCustomItem());

        /*--[ Rogue Hood ]------------------------------------------------------------------------------------------*/

        ArrayList<EnchantmentPlus> RogueHoodEnchantments = new ArrayList<>();
        EnchantmentPlus RogueHoodEnchantment1 = new EnchantmentPlus(Enchantment.PROTECTION_ENVIRONMENTAL, 9, true);
        EnchantmentPlus RogueHoodEnchantment2 = new EnchantmentPlus(Enchantment.PROTECTION_FALL, 4, true);
        EnchantmentPlus RogueHoodEnchantment3 = new EnchantmentPlus(Enchantment.PROTECTION_EXPLOSIONS, 3, true);
        RogueHoodEnchantments.add(RogueHoodEnchantment1);
        RogueHoodEnchantments.add(RogueHoodEnchantment2);
        RogueHoodEnchantments.add(RogueHoodEnchantment3);

        ArrayList<String> RogueHoodLore = new ArrayList<>();
        RogueHoodLore.add(ChatColor.translateAlternateColorCodes('&',"&7Protection IX"));
        RogueHoodLore.add(ChatColor.translateAlternateColorCodes('&',"&7Fire Protection IV"));
        RogueHoodLore.add(ChatColor.translateAlternateColorCodes('&',"&7Blast Protection III"));
        RogueHoodLore.add(ChatColor.translateAlternateColorCodes('&',"&7Unbreaking VIII"));
        RogueHoodLore.add(ChatColor.translateAlternateColorCodes('&',"&5&oSymbol of our Brotherhood"));
        RogueHoodLore.add("");
        RogueHoodLore.add(ChatColor.translateAlternateColorCodes('&',"&a- Increase Health Pool 10%"));
        RogueHoodLore.add("");
        RogueHoodLore.add(ChatColor.translateAlternateColorCodes('&',"&aSet Bonus:"));
        RogueHoodLore.add(ChatColor.translateAlternateColorCodes('&',"&a(2) Leap"));
        RogueHoodLore.add(ChatColor.translateAlternateColorCodes('&',"&d(3) Rogue's Fury"));
        RogueHoodLore.add("");
        RogueHoodLore.add(ChatColor.translateAlternateColorCodes('&', "&7When on Head:"));
        RogueHoodLore.add(ChatColor.translateAlternateColorCodes('&', "&9+1 Armor"));

        AttributeModifier RogueHoodModifier = new AttributeModifier(UUID.randomUUID(), "Rogue Hood Health", 2.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);

        CustomArmor RogueHood = new CustomArmor(ChatColor.translateAlternateColorCodes('&', "&cRogue Hood"),
                RogueHoodEnchantments,
                RogueHoodLore,
                Material.LEATHER_HELMET,
                "N/A", "N/A", "N/A",
                0, 0, 0,
                380, 380,
                RogueHoodModifier, leatherHelmetArmorModifier, leatherHelmetArmorToughnessModifier,
                Color.FUCHSIA);
        customArmorItems.put("Rogue Hood",  RogueHood.getCustomItem());

        /*--[ Rogue Mantle ]------------------------------------------------------------------------------------------*/

        ArrayList<EnchantmentPlus> RogueMantleEnchantments = new ArrayList<>();
        EnchantmentPlus RogueMantleEnchantment1 = new EnchantmentPlus(Enchantment.PROTECTION_ENVIRONMENTAL, 8, true);
        EnchantmentPlus RogueMantleEnchantment2 = new EnchantmentPlus(Enchantment.PROTECTION_FIRE, 8, true);
        EnchantmentPlus RogueMantleEnchantment3 = new EnchantmentPlus(Enchantment.PROTECTION_EXPLOSIONS, 3, true);
        RogueMantleEnchantments.add(RogueMantleEnchantment1);
        RogueMantleEnchantments.add(RogueMantleEnchantment2);
        RogueMantleEnchantments.add(RogueMantleEnchantment3);

        ArrayList<String> RogueMantleLore = new ArrayList<>();
        RogueMantleLore.add(ChatColor.translateAlternateColorCodes('&',"&7Protection VIII"));
        RogueMantleLore.add(ChatColor.translateAlternateColorCodes('&',"&7Fire Protection VIII"));
        RogueMantleLore.add(ChatColor.translateAlternateColorCodes('&',"&7Blast Protection III"));
        RogueMantleLore.add(ChatColor.translateAlternateColorCodes('&',"&7Unbreaking VIII"));
        RogueMantleLore.add(ChatColor.translateAlternateColorCodes('&',"&5&oAn tattered cape of old"));
        RogueMantleLore.add("");
        RogueMantleLore.add(ChatColor.translateAlternateColorCodes('&',"&a- Increase Health Pool 10%"));
        RogueMantleLore.add("");
        RogueMantleLore.add(ChatColor.translateAlternateColorCodes('&',"&aSet Bonus:"));
        RogueMantleLore.add(ChatColor.translateAlternateColorCodes('&',"&a(2) Leap"));
        RogueMantleLore.add(ChatColor.translateAlternateColorCodes('&',"&d(3) Rogue's Fury"));
        RogueMantleLore.add("");
        RogueMantleLore.add(ChatColor.translateAlternateColorCodes('&', "&7When on Body:"));
        RogueMantleLore.add(ChatColor.translateAlternateColorCodes('&', "&9+3 Armor"));

        AttributeModifier RogueMantleModifier = new AttributeModifier(UUID.randomUUID(), "Rogue Mantle Health", 2.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);

        CustomArmor RogueMantle = new CustomArmor(ChatColor.translateAlternateColorCodes('&', "&cRogue Mantle"),
                RogueMantleEnchantments,
                RogueMantleLore,
                Material.LEATHER_CHESTPLATE,
                "N/A", "N/A", "N/A",
                0, 0, 0,
                430, 430,
                RogueMantleModifier, leatherChestplateArmorModifier, leatherChestplateArmorToughnessModifier,
                Color.FUCHSIA);
        customArmorItems.put("Rogue Mantle",  RogueMantle.getCustomItem());

        /*--[ Rogue Trousers ]------------------------------------------------------------------------------------------*/

        ArrayList<EnchantmentPlus> RogueTrousersEnchantments = new ArrayList<>();
        EnchantmentPlus RogueTrousersEnchantment1 = new EnchantmentPlus(Enchantment.PROTECTION_ENVIRONMENTAL, 7, true);
        EnchantmentPlus RogueTrousersEnchantment2 = new EnchantmentPlus(Enchantment.SWIFT_SNEAK, 3, true);
        RogueTrousersEnchantments.add(RogueTrousersEnchantment1);
        RogueTrousersEnchantments.add(RogueTrousersEnchantment2);

        ArrayList<String> RogueTrousersLore = new ArrayList<>();
        RogueTrousersLore.add(ChatColor.translateAlternateColorCodes('&',"&7Protection VII"));
        RogueTrousersLore.add(ChatColor.translateAlternateColorCodes('&',"&7Swift Sneak III"));
        RogueTrousersLore.add(ChatColor.translateAlternateColorCodes('&',"&7Unbreaking IX"));
        RogueTrousersLore.add(ChatColor.translateAlternateColorCodes('&',"&5&oStained while running away"));
        RogueTrousersLore.add(ChatColor.translateAlternateColorCodes('&',"&5&ofrom a boar"));
        RogueTrousersLore.add("");
        RogueTrousersLore.add(ChatColor.translateAlternateColorCodes('&',"&a- Increase Health Pool 10%"));
        RogueTrousersLore.add("");
        RogueTrousersLore.add(ChatColor.translateAlternateColorCodes('&',"&aSet Bonus:"));
        RogueTrousersLore.add(ChatColor.translateAlternateColorCodes('&',"&a(2) Leap"));
        RogueTrousersLore.add(ChatColor.translateAlternateColorCodes('&',"&d(3) Rogue's Fury"));
        RogueTrousersLore.add("");
        RogueTrousersLore.add(ChatColor.translateAlternateColorCodes('&', "&7When on Legs:"));
        RogueTrousersLore.add(ChatColor.translateAlternateColorCodes('&', "&9+4 Armor"));

        AttributeModifier RogueTrousersModifier = new AttributeModifier(UUID.randomUUID(), "Rogue Trousers Health", 2.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);

        CustomArmor RogueTrousers = new CustomArmor(ChatColor.translateAlternateColorCodes('&', "&cRogue Trousers"),
                RogueTrousersEnchantments,
                RogueTrousersLore,
                Material.CHAINMAIL_LEGGINGS,
                "N/A", "N/A", "N/A",
                0, 0, 0,
                430, 430,
                RogueTrousersModifier, chainmailLeggingsArmorModifier, chainmailLeggingsArmorToughnessModifier);
        customArmorItems.put("Rogue Trousers",  RogueTrousers.getCustomItem());

        /*--[ Rogue Boots ]------------------------------------------------------------------------------------------*/

        ArrayList<EnchantmentPlus> RogueBootsEnchantments = new ArrayList<>();
        EnchantmentPlus RogueBootsEnchantment1 = new EnchantmentPlus(Enchantment.PROTECTION_ENVIRONMENTAL, 7, true);
        EnchantmentPlus RogueBootsEnchantment2 = new EnchantmentPlus(Enchantment.PROTECTION_ENVIRONMENTAL, 6, true);
        RogueBootsEnchantments.add(RogueBootsEnchantment1);
        RogueBootsEnchantments.add(RogueBootsEnchantment2);

        ArrayList<String> RogueBootsLore = new ArrayList<>();
        RogueBootsLore.add(ChatColor.translateAlternateColorCodes('&',"&7Protection VII"));
        RogueBootsLore.add(ChatColor.translateAlternateColorCodes('&',"&7Feather Falling VI"));
        RogueBootsLore.add(ChatColor.translateAlternateColorCodes('&',"&7Unbreaking VIII"));
        RogueBootsLore.add(ChatColor.translateAlternateColorCodes('&',"&5&oThe Swifty Fifty"));
        RogueBootsLore.add("");
        RogueBootsLore.add(ChatColor.translateAlternateColorCodes('&',"&a- Increases Movement Speed 20%"));
        RogueBootsLore.add("");
        RogueBootsLore.add(ChatColor.translateAlternateColorCodes('&',"&aSet Bonus:"));
        RogueBootsLore.add(ChatColor.translateAlternateColorCodes('&',"&a(2) Leap"));
        RogueBootsLore.add(ChatColor.translateAlternateColorCodes('&',"&d(3) Rogue's Fury"));
        RogueBootsLore.add("");
        RogueBootsLore.add(ChatColor.translateAlternateColorCodes('&', "&7When on Feet:"));
        RogueBootsLore.add(ChatColor.translateAlternateColorCodes('&', "&9+1 Armor"));

        AttributeModifier RogueBootsModifier = new AttributeModifier(UUID.randomUUID(), "Rogue Boots Health", 4.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);

        Color RogueBootsColor = Color.fromRGB(89, 136, 181);

        CustomArmor RogueBoots = new CustomArmor(ChatColor.translateAlternateColorCodes('&', "&cRogue Boots"),
                RogueBootsEnchantments,
                RogueBootsLore,
                Material.LEATHER_BOOTS,
                "Speed", "N/A", "N/A",
                1, 0, 0,
                400, 400,
                RogueBootsModifier, leatherBootsArmorModifier, leatherBootsArmorToughnessModifier,
                RogueBootsColor);
        customArmorItems.put("Rogue Boots",  RogueBoots.getCustomItem());

        /*--[ Hekaerge ]------------------------------------------------------------------------------------------*/

        ArrayList<EnchantmentPlus> HekaergeEnchantments = new ArrayList<>();
        EnchantmentPlus HekaergeEnchantment1 = new EnchantmentPlus(Enchantment.PROTECTION_ENVIRONMENTAL, 8, true);
        EnchantmentPlus HekaergeEnchantment2 = new EnchantmentPlus(Enchantment.PROTECTION_FIRE, 5, true);
        HekaergeEnchantments.add(HekaergeEnchantment1);
        HekaergeEnchantments.add(HekaergeEnchantment2);

        ArrayList<String> HekaergeLore = new ArrayList<String>();
        HekaergeLore.add(ChatColor.translateAlternateColorCodes('&',"&7Protection VIII"));
        HekaergeLore.add(ChatColor.translateAlternateColorCodes('&',"&7Fire Protection V"));
        HekaergeLore.add(ChatColor.translateAlternateColorCodes('&',"&7Unbreaking VII"));
        HekaergeLore.add(ChatColor.translateAlternateColorCodes('&',"&5&oThe key to hunting is"));
        HekaergeLore.add(ChatColor.translateAlternateColorCodes('&',"&5&oproper distancing"));
        HekaergeLore.add("");
        HekaergeLore.add(ChatColor.translateAlternateColorCodes('&', "&a- Increase Health Pool 20%"));
        HekaergeLore.add("");
        HekaergeLore.add(ChatColor.translateAlternateColorCodes('&',"&aSet Bonus:"));
        HekaergeLore.add(ChatColor.translateAlternateColorCodes('&',"&a(2) Steals Life"));
        HekaergeLore.add(ChatColor.translateAlternateColorCodes('&',"&d(3) Active Camo"));
        HekaergeLore.add("");
        HekaergeLore.add(ChatColor.translateAlternateColorCodes('&', "&7When on Head:"));
        HekaergeLore.add(ChatColor.translateAlternateColorCodes('&', "&9+2 Armor"));

        AttributeModifier HekaergeModifier = new AttributeModifier(UUID.randomUUID(), "Hekaerge Health", 4.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot. HEAD);

        CustomArmor Hekaerge = new CustomArmor(ChatColor.translateAlternateColorCodes('&', "&cHekaerge"),
                HekaergeEnchantments,
                HekaergeLore,
                Material.CHAINMAIL_HELMET,
                "N/A", "N/A", "N/A",
                0, 0, 0,
                605, 605,
                HekaergeModifier, chainmailHelmetArmorModifier, chainmailHelmetArmorToughnessModifier);
        customArmorItems.put("Hekaerge", Hekaerge.getCustomItem());

        /*--[ Oupis Cloak ]------------------------------------------------------------------------------------------*/

        ArrayList<EnchantmentPlus> OupisCloakEnchantments = new ArrayList<>();
        EnchantmentPlus OupisCloakEnchantment1 = new EnchantmentPlus(Enchantment.PROTECTION_ENVIRONMENTAL, 7, true);
        EnchantmentPlus OupisCloakEnchantment2 = new EnchantmentPlus(Enchantment.PROTECTION_PROJECTILE, 5, true);
        OupisCloakEnchantments.add(OupisCloakEnchantment1);
        OupisCloakEnchantments.add(OupisCloakEnchantment2);

        ArrayList<String> OupisCloakLore = new ArrayList<String>();
        OupisCloakLore.add(ChatColor.translateAlternateColorCodes('&',"&7Protection VII"));
        OupisCloakLore.add(ChatColor.translateAlternateColorCodes('&',"&7Blast Protection V"));
        OupisCloakLore.add(ChatColor.translateAlternateColorCodes('&',"&7Unbreaking VIII"));
        OupisCloakLore.add(ChatColor.translateAlternateColorCodes('&',"&5&oBeing one with your"));
        OupisCloakLore.add(ChatColor.translateAlternateColorCodes('&',"&5&osurroundings"));
        OupisCloakLore.add("");
        OupisCloakLore.add(ChatColor.translateAlternateColorCodes('&', "&a- Increase Health Pool 10%"));
        OupisCloakLore.add("");
        OupisCloakLore.add(ChatColor.translateAlternateColorCodes('&',"&aSet Bonus:"));
        OupisCloakLore.add(ChatColor.translateAlternateColorCodes('&',"&a(2) Steals Life"));
        OupisCloakLore.add(ChatColor.translateAlternateColorCodes('&',"&d(3) Active Camo"));
        OupisCloakLore.add("");
        OupisCloakLore.add(ChatColor.translateAlternateColorCodes('&', "&7When on Body:"));
        OupisCloakLore.add(ChatColor.translateAlternateColorCodes('&', "&9+3 Armor"));

        AttributeModifier OupisCloakModifier = new AttributeModifier(UUID.randomUUID(), "Oupis Cloak Health", 2.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);

        Color OupisCloakColor = Color.fromRGB(197, 199, 196);

        CustomArmor OupisCloak = new CustomArmor(ChatColor.translateAlternateColorCodes('&', "&cOupis Cloak"),
                OupisCloakEnchantments,
                OupisCloakLore,
                Material.LEATHER_CHESTPLATE,
                "N/A", "N/A", "N/A",
                0, 0, 0,
                405, 405,
                OupisCloakModifier, leatherChestplateArmorModifier, leatherChestplateArmorToughnessModifier,
                OupisCloakColor);
        customArmorItems.put("Oupis Cloak", OupisCloak.getCustomItem());

        /*--[ Loxo ]------------------------------------------------------------------------------------------*/

        ArrayList<EnchantmentPlus> LoxoEnchantments = new ArrayList<>();
        EnchantmentPlus LoxoEnchantment1 = new EnchantmentPlus(Enchantment.PROTECTION_ENVIRONMENTAL, 7, true);
        EnchantmentPlus LoxoEnchantment2 = new EnchantmentPlus(Enchantment.SWIFT_SNEAK, 2, true);
        LoxoEnchantments.add(LoxoEnchantment1);
        LoxoEnchantments.add(LoxoEnchantment2);

        ArrayList<String> LoxoLore = new ArrayList<String>();
        LoxoLore.add(ChatColor.translateAlternateColorCodes('&',"&7Protection IX"));
        LoxoLore.add(ChatColor.translateAlternateColorCodes('&',"&7Projectile Protection II"));
        LoxoLore.add(ChatColor.translateAlternateColorCodes('&',"&7Swift Sneak II"));
        LoxoLore.add(ChatColor.translateAlternateColorCodes('&',"&7Unbreaking VIII"));
        LoxoLore.add(ChatColor.translateAlternateColorCodes('&',"&5&oBeing one with your"));
        LoxoLore.add(ChatColor.translateAlternateColorCodes('&',"&5&osurroundings"));
        LoxoLore.add("");
        LoxoLore.add(ChatColor.translateAlternateColorCodes('&', "&a- Increase Health Pool 10%"));
        LoxoLore.add("");
        LoxoLore.add(ChatColor.translateAlternateColorCodes('&',"&aSet Bonus:"));
        LoxoLore.add(ChatColor.translateAlternateColorCodes('&',"&a(2) Steals Life"));
        LoxoLore.add(ChatColor.translateAlternateColorCodes('&',"&d(3) Active Camo"));
        LoxoLore.add("");
        LoxoLore.add(ChatColor.translateAlternateColorCodes('&', "&7When on Legs:"));
        LoxoLore.add(ChatColor.translateAlternateColorCodes('&', "&9+4 Armor"));

        AttributeModifier LoxoModifier = new AttributeModifier(UUID.randomUUID(), "Loxo Health", 2.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);

        CustomArmor Loxo = new CustomArmor(ChatColor.translateAlternateColorCodes('&', "&cLoxo"),
                LoxoEnchantments,
                LoxoLore,
                Material.CHAINMAIL_LEGGINGS,
                "N/A", "N/A", "N/A",
                0, 0, 0,
                700, 700,
                LoxoModifier, chainmailLeggingsArmorModifier, chainmailLeggingsArmorToughnessModifier);
        customArmorItems.put("Loxo", Loxo.getCustomItem());

        /*--[ Delos ]------------------------------------------------------------------------------------------*/

        ArrayList<EnchantmentPlus> DelosEnchantments = new ArrayList<>();
        EnchantmentPlus DelosEnchantment1 = new EnchantmentPlus(Enchantment.PROTECTION_ENVIRONMENTAL, 7, true);
        EnchantmentPlus DelosEnchantment2 = new EnchantmentPlus(Enchantment.PROTECTION_FALL, 5, true);
        DelosEnchantments.add(DelosEnchantment1);
        DelosEnchantments.add(DelosEnchantment2);

        ArrayList<String> DelosLore = new ArrayList<String>();
        DelosLore.add(ChatColor.translateAlternateColorCodes('&',"&7Protection VII"));
        DelosLore.add(ChatColor.translateAlternateColorCodes('&',"&7Feather Falling V"));
        DelosLore.add(ChatColor.translateAlternateColorCodes('&',"&7Unbreaking VI"));
        DelosLore.add(ChatColor.translateAlternateColorCodes('&',"&5&oKnow the path like it's"));
        DelosLore.add(ChatColor.translateAlternateColorCodes('&',"&5&othe back of your hand"));
        DelosLore.add("");
        DelosLore.add(ChatColor.translateAlternateColorCodes('&', "&a- Increase Health Pool 10%"));
        DelosLore.add("");
        DelosLore.add(ChatColor.translateAlternateColorCodes('&',"&aSet Bonus:"));
        DelosLore.add(ChatColor.translateAlternateColorCodes('&',"&a(2) Steals Life"));
        DelosLore.add(ChatColor.translateAlternateColorCodes('&',"&d(3) Active Camo"));
        DelosLore.add("");
        DelosLore.add(ChatColor.translateAlternateColorCodes('&', "&7When on Feet:"));
        DelosLore.add(ChatColor.translateAlternateColorCodes('&', "&9+1 Armor"));

        AttributeModifier DelosModifier = new AttributeModifier(UUID.randomUUID(), "Delos Health", 2.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);

        Color DelosColor = Color.fromRGB(197, 199, 196);

        CustomArmor Delos = new CustomArmor(ChatColor.translateAlternateColorCodes('&', "&cDelos"),
                DelosEnchantments,
                DelosLore,
                Material.LEATHER_BOOTS,
                "Speed", "N/A", "N/A",
                0, 0, 0,
                700, 700,
                DelosModifier, leatherBootsArmorModifier, leatherBootsArmorToughnessModifier,
                DelosColor);
        customArmorItems.put("Delos", Delos.getCustomItem());

        /*--[ Rooks Decree ]------------------------------------------------------------------------------------------*/

        ArrayList<EnchantmentPlus> RooksDecreeEnchantments = new ArrayList<>();
        EnchantmentPlus RooksDecreeEnchantment1 = new EnchantmentPlus(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
        EnchantmentPlus RooksDecreeEnchantment2 = new EnchantmentPlus(Enchantment.MENDING, 1, true);
        EnchantmentPlus RooksDecreeEnchantment3 = new EnchantmentPlus(Enchantment.DURABILITY, 3, true);
        RooksDecreeEnchantments.add(RooksDecreeEnchantment1);
        RooksDecreeEnchantments.add(RooksDecreeEnchantment2);
        RooksDecreeEnchantments.add(RooksDecreeEnchantment3);

        ArrayList<String> RooksDecreeLore = new ArrayList<String>();
        RooksDecreeLore.add(ChatColor.translateAlternateColorCodes('&',"&7Protection V"));
        RooksDecreeLore.add(ChatColor.translateAlternateColorCodes('&',"&7Unbreaking III"));
        RooksDecreeLore.add(ChatColor.translateAlternateColorCodes('&',"&7Mending"));
        RooksDecreeLore.add(ChatColor.translateAlternateColorCodes('&',"&5&oThe art of defense shall"));
        RooksDecreeLore.add(ChatColor.translateAlternateColorCodes('&',"&5&onot be forgotten"));
        RooksDecreeLore.add("");
        RooksDecreeLore.add(ChatColor.translateAlternateColorCodes('&', "&a- Increase Health Pool 20%"));
        RooksDecreeLore.add(ChatColor.translateAlternateColorCodes('&', "&a- Damage Reduction"));
        RooksDecreeLore.add("");
        RooksDecreeLore.add(ChatColor.translateAlternateColorCodes('&', "&7When on Body:"));
        RooksDecreeLore.add(ChatColor.translateAlternateColorCodes('&', "&9+4 Armor"));
        RooksDecreeLore.add(ChatColor.translateAlternateColorCodes('&', "&9+3 Armor Toughness"));
        RooksDecreeLore.add(ChatColor.translateAlternateColorCodes('&', "&9+1 Knockback Resistance"));

        AttributeModifier RooksDecreeModifier = new AttributeModifier(UUID.randomUUID(), "Rooks Decree Health", 4.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);

        CustomArmor RooksDecree = new CustomArmor(ChatColor.translateAlternateColorCodes('&', "&cRooks Decree"),
                RooksDecreeEnchantments,
                RooksDecreeLore,
                Material.NETHERITE_CHESTPLATE,
                "Resistance", "N/A", "N/A",
                0, 0, 0,
                300, 300,
                RooksDecreeModifier, netheriteChestplateArmorModifier, netheriteChestplateArmorToughnessModifier, netheriteChestplateKnockbackResistance);
        customArmorItems.put("Rooks Decree", RooksDecree.getCustomItem());
    }

    public ItemStack getCustomArmorItem (String key)    {
        return this.customArmorItems.get(key);
    }
}
