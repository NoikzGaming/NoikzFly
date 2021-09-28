package me.noikzgaming.companyshops.commands;

import me.noikzgaming.companyshops.Main;
import me.noikzgaming.companyshops.inventories.CompanyMainMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Endast spelare kan utföra detta kommando!");
            return true;
        }
        Player player = (Player) sender;

        // company
        if(cmd.getName().equalsIgnoreCase("company")) {
            CompanyMainMenu gui = new CompanyMainMenu();
            player.openInventory(gui.getInventory());
        }
        if (args.length >= 1) {
            if (args[0].equalsIgnoreCase("create")) {
                player.closeInventory();
                sender.sendMessage("§c§l(!) §cDu måste ange ett företags namn!");
                return true;
            }
        }

        return true;
    }
}
