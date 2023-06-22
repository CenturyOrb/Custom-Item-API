package Item.Systems;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class PlayerKillCountSystem implements Listener {

    // stack and meta will be used for onPlayerDeath
    private ItemStack bowStack;
    private ItemMeta bowMeta;

    // this event is used to get the bow stack + meta
    @EventHandler
    public void sendArrow (EntityShootBowEvent e)    {
        if (!(e.getProjectile() instanceof Arrow))  { return;}
        if (e.getEntity() instanceof Player)    {
            bowStack = e.getBow();
            bowMeta = bowStack.getItemMeta();
        }
    }

    // actually event that updates Player kill counter on items
    @EventHandler
    public void onPlayerDeath (PlayerDeathEvent e)  {
        Player defender = e.getPlayer();
        int killCount = 0;
        String newLine;

        EntityDamageEvent.DamageCause cause = defender.getLastDamageCause().getCause();

        switch (cause) {
            // if damage cause is projectile, get the bow from the other event
            // and check if the bow has a kill counter, if so, ++ the kill counter
            case PROJECTILE:
                // check if bow doesn't have lore = vanilla bow
                if (!(bowMeta.hasLore()))   { return;}
                List<String> bowLore = bowMeta.getLore();
                for (int i = 0; i < bowLore.size(); i++)   {
                    if (bowLore.get(i).contains("§7Player Kills:"))  {
                        String[] splitLine = bowLore.get(i).split(": ");
                        killCount = Integer.parseInt(splitLine[1]);

                        killCount++;

                        newLine = splitLine[0] + ": " + killCount;

                        bowLore.set(i, newLine);
                        bowMeta.setLore(bowLore);

                        bowStack.setItemMeta(bowMeta);
                    }
                }
                break;
            // if damage cause is a normal attack, get the main hand item
            // check if item has a kill counter, if so, ++ the kill counter
            case ENTITY_ATTACK:
                if (defender.getKiller() == null)  { return;};
                Player meleeKiller = defender.getKiller();
                ItemStack meleeStack = meleeKiller.getInventory().getItemInMainHand();
                ItemMeta meleeMeta = meleeStack.getItemMeta();

                if (!(meleeMeta.hasLore()))   { return;}
                List<String> meleeLore = meleeMeta.getLore();
                for (int i = 0; i < meleeLore.size(); i++)  {
                    if (meleeLore.get(i).contains("§7Player Kills:"))   {
                        String[] meleeSplitLine = meleeLore.get(i).split(": ");
                        killCount = Integer.parseInt(meleeSplitLine[1]);

                        killCount++;

                        newLine = meleeSplitLine[0] + ": " + killCount;

                        meleeLore.set(i, newLine);
                        meleeMeta.setLore(meleeLore);
                        meleeStack.setItemMeta(meleeMeta);
                    }
                }
                break;
            // if damage cause is a sweep attack, get the main hand item
            // check if item has a kill counter, if so, ++ the kill counter
            case ENTITY_SWEEP_ATTACK:
                if (defender.getKiller() == null)  { return;};
                Player sweepKiller = defender.getKiller();
                ItemStack sweepStack = sweepKiller.getInventory().getItemInMainHand();
                ItemMeta sweepMeta = sweepStack.getItemMeta();

                if (!(sweepMeta.hasLore()))   { return;}
                List<String> sweepLore = sweepMeta.getLore();
                for (int i = 0; i < sweepLore.size(); i++)  {
                    if (sweepLore.get(i).contains("Player Kills:"))   {
                        String[] sweepSplitLine = sweepLore.get(i).split(": ");
                        killCount = Integer.parseInt(sweepSplitLine[1]);

                        killCount++;

                        newLine = sweepSplitLine[0] + ": " + killCount;

                        sweepLore.set(i, newLine);
                        sweepMeta.setLore(sweepLore);
                        sweepStack.setItemMeta(sweepMeta);
                    }
                }
                break;
            // any other sort of death from other types of damage this
            // event will do nothing
            default:

                break;
        }

    }

}
