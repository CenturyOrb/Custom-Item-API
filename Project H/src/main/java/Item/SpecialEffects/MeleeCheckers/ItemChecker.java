package Item.SpecialEffects.MeleeCheckers;

import org.bukkit.inventory.meta.ItemMeta;

public class ItemChecker {

    public static boolean itemLoreChecker (ItemMeta item, String lore)   {
        boolean correctItem = true;
        // check if item in hand is air
        if (item == null)    { return false;}

        // check if item is vanilla
        if (item.getLore() != null) {
            if (!(item.getLore().contains(lore)))  {
                correctItem = false;
            }
        }else {
            correctItem = false;
        }

        return correctItem;
    }
}
