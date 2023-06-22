package Item.CreateAndStorage.Spells;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Spells {

    private ItemStack FireballSpellBook = new ItemStack(Material.ENCHANTED_BOOK);

    public Spells ()    {
        ItemMeta fireballMeta = FireballSpellBook.getItemMeta();

        fireballMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&lFireball"));

        ArrayList<String> FireballLore = new ArrayList<String>();
        FireballLore.add(ChatColor.translateAlternateColorCodes('&',"&5&oSent the master wizard into"));
        FireballLore.add(ChatColor.translateAlternateColorCodes('&',"&5&oinsanity"));
        FireballLore.add("");
        FireballLore.add(ChatColor.translateAlternateColorCodes('&', "&a- Consumes 1 Soul"));

        fireballMeta.setLore(FireballLore);

        FireballSpellBook.setItemMeta(fireballMeta);
    }

    public ItemStack getFireballSpellBook()   {
        return FireballSpellBook;
    }
}
