package Item.SpecialEffects.SpecialOffenseEffects;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRiptideEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static Item.SpecialEffects.MeleeCheckers.ItemChecker.itemLoreChecker;

public class TrishulaEffect implements Listener {

    @EventHandler
    public void onTrishulaRiptide (PlayerRiptideEvent e)    {
        Player player;
        ItemMeta item;

        player = e.getPlayer();
        item = e.getItem().getItemMeta();

        if (itemLoreChecker(item, "§5§oMay it's wielder never"))    {
            player.addPotionEffect(new PotionEffect(PotionEffectType.CONDUIT_POWER, 150, 0, false,false, true));
            player.addPotionEffect(new PotionEffect(PotionEffectType.DOLPHINS_GRACE, 150, 0, false, false, true));
            player.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 150, 0, false, false, true));

            player.setCooldown(Material.TRIDENT, 200);
        }
    }
}
