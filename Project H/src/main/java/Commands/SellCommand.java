package Commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class SellCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        // check if player
        if (!(sender instanceof Player))   {  return false; }
        Player player = (Player) sender;

        // hand check air
        if (player.getInventory().getItemInMainHand().getType() == Material.AIR)   {
            player.sendMessage(ChatColor.RED + "Hold item in main hand to sell");
            return false;
        }

        // (1) get item in main hand
        // (2) get inventory
        ItemStack itemInMainHand = player.getInventory().getItemInMainHand();
        ItemStack[] inventory = player.getInventory().getContents();

        // item counter
        int count = 0;

        // traverse inventory for item in main hand
        // if found, get the amount to count
        for (ItemStack item : inventory)   {
            if (item == null)   {
                continue;
            }
            if (item.getType() == itemInMainHand.getType())   {
                count += item.getAmount();
                player.getInventory().removeItem(itemInMainHand);
            }
        }

        player.updateInventory();

        player.sendMessage(ChatColor.GREEN + "You have sold " + count + " " + itemInMainHand.getItemMeta().getDisplayName());

        // int profit = count * getCost(item)
        // addPlayerBalance(profit)

        return false;
    }
}
