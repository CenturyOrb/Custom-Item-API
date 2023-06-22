package Commands;

import Item.CreateAndStorage.Armor.CustomArmorManager;
import Item.CreateAndStorage.Bow.CustomBowManager;
import Item.CreateAndStorage.Offense.CustomOffenseManager;
import Item.CreateAndStorage.Spells.Spells;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class CommandTest implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player)   {
            Player player = (Player) sender;
            CustomOffenseManager meleeManager = new CustomOffenseManager();
            CustomBowManager bowManager = new CustomBowManager();
            CustomArmorManager armorManager = new CustomArmorManager();
            Spells spellManager = new Spells();

            player.getInventory().addItem(meleeManager.getCustomOffenseItem("Elysium"));
            player.getInventory().addItem(meleeManager.getCustomOffenseItem("Stagnato"));
            player.getInventory().addItem(meleeManager.getCustomOffenseItem("Tetherius"));
            player.getInventory().addItem(meleeManager.getCustomOffenseItem("Sorrow Blade"));
            player.getInventory().addItem(meleeManager.getCustomOffenseItem("Magnar"));
            player.getInventory().addItem(meleeManager.getCustomOffenseItem("Shadow Step"));
            player.getInventory().addItem(meleeManager.getCustomOffenseItem("Trishula"));
            player.getInventory().addItem(meleeManager.getCustomOffenseItem("Ancilia"));
            player.getInventory().addItem(meleeManager.getCustomOffenseItem("Xiphos"));

            player.getInventory().addItem(armorManager.getCustomArmorItem("Corinthian"));
            player.getInventory().addItem(armorManager.getCustomArmorItem("Aphaia"));
            player.getInventory().addItem(armorManager.getCustomArmorItem("Thorax"));
            player.getInventory().addItem(armorManager.getCustomArmorItem("Halcyon Chargers"));
            player.getInventory().addItem(armorManager.getCustomArmorItem("Rooks Decree"));

            player.getInventory().addItem(armorManager.getCustomArmorItem("Illrian"));
            player.getInventory().addItem(armorManager.getCustomArmorItem("Guardian Plates"));
            player.getInventory().addItem(armorManager.getCustomArmorItem("Chausses"));
            player.getInventory().addItem(armorManager.getCustomArmorItem("War Treads"));

            player.getInventory().addItem(armorManager.getCustomArmorItem("Rogue Hood"));
            player.getInventory().addItem(armorManager.getCustomArmorItem("Rogue Mantle"));
            player.getInventory().addItem(armorManager.getCustomArmorItem("Rogue Trousers"));
            player.getInventory().addItem(armorManager.getCustomArmorItem("Rogue Boots"));

            player.getInventory().addItem(armorManager.getCustomArmorItem("Hekaerge"));
            player.getInventory().addItem(armorManager.getCustomArmorItem("Oupis Cloak"));
            player.getInventory().addItem(armorManager.getCustomArmorItem("Loxo"));
            player.getInventory().addItem(armorManager.getCustomArmorItem("Delos"));

            player.getInventory().addItem(bowManager.getCustomBowItem("Parthian"));

            player.getInventory().addItem(spellManager.getFireballSpellBook());

            ItemStack arrow = new ItemStack(Material.ARROW, 1);
            ItemStack food = new ItemStack(Material.COOKED_BEEF, 64);

            player.getInventory().addItem(arrow);
            player.getInventory().addItem(food);

        }

        return false;
    }
}
