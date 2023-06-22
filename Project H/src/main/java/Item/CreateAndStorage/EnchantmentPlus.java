package Item.CreateAndStorage;

import org.bukkit.enchantments.Enchantment;

public class EnchantmentPlus {

    // instance variables for enchantment args
    private final Enchantment enchantment;
    private final int enchantmentLevel;
    private final boolean ignoreLevelRestriction;

    // constructor for enchantment, level and level restriction
    public EnchantmentPlus (Enchantment enchantment, int enchantmentLevel, boolean ignoreLevelRestriction)    {
        this.enchantment = enchantment;
        this.enchantmentLevel = enchantmentLevel;
        this.ignoreLevelRestriction = ignoreLevelRestriction;
    }

    // getter methods
    public Enchantment getEnchantment ()    {
        return this.enchantment;
    }
    public int getEnchantmentLevel ()    {
        return this.enchantmentLevel;
    }

    public boolean getIgnoreLevelRestriction ()    {return this.ignoreLevelRestriction;}
}
