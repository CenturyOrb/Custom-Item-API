package Item.Systems;

import com.rosa.serverplugin.Main;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class CustomArmorDurability implements Listener {

    @EventHandler
    public void customArmorDura(PlayerItemDamageEvent e)    {

        // get the itemMeta of the item that was used in this event
        ItemStack armor = e.getItem();
        org.bukkit.inventory.meta.Damageable armorMeta = (Damageable) armor.getItemMeta();

        // get that items overall PDC data
        PersistentDataContainer armorData = armorMeta.getPersistentDataContainer();

        // checks if that item is a custom armor item if it has the dura key in PDC
        if (armorData.has(new NamespacedKey(Main.getPlugin(Main.class), "dura"), PersistentDataType.DOUBLE))  {

            // gets the integer that represents the dura value from the armor's PDC and their double value
            double armorDura = armorData.get(new NamespacedKey(Main.getPlugin(),"dura"), PersistentDataType.DOUBLE);

            // gets the integer that represents the custom max dura from the armor's PDC and their double value
            double armorMaxDura = armorData.get(new NamespacedKey(Main.getPlugin(), "maxDura"), PersistentDataType.DOUBLE);

            // get the vanilla item max durability and their double value
            double maxItemDurability = armor.getType().getMaxDurability();

            if (armorDura <= 0) {
                return;
            }

            // cancels the damage that the custom armor took
            e.setCancelled(true);

            // subtract 1 from that integer and store it back into armorData
            armorDura = armorDura - 1;
            armorData.set(new NamespacedKey(Main.getPlugin(), "dura"), PersistentDataType.DOUBLE, armorDura);

            short finalRealDura = (short) (maxItemDurability - armorDura/armorMaxDura * maxItemDurability);
            armorMeta.setDamage(finalRealDura);

            armor.setItemMeta(armorMeta);

        }
    }

}
