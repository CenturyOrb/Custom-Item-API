package Item.SpecialEffects.SpecialArmorEffects;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPotionEffectEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

import static Item.SpecialEffects.MeleeCheckers.ItemChecker.itemLoreChecker;

public class CorinthianEffect implements Listener {

    @EventHandler
    public void onCorinthianBlind (EntityPotionEffectEvent e)   {
        Player player;
        PotionEffectType potionEffect;
        ItemStack headArmor;

        if (!(e.getEntity() instanceof Player)) { return;}

        player = (Player) e.getEntity();
        headArmor = player.getInventory().getItem(EquipmentSlot.HEAD);

        if (itemLoreChecker(headArmor.getItemMeta(), "§5§oStolen by the great defender"))   {
            potionEffect = e.getNewEffect().getType();
            if (potionEffect.equals(PotionEffectType.BLINDNESS))    {
                e.setCancelled(true);
            }
        }

    }
}
