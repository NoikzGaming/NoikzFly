package me.noikzgaming.companyshops.commands;

import me.noikzgaming.companyshops.Main;
import me.noikzgaming.companyshops.inventories.CompanyMainMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CompanyCreateCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;

        // company create
        if(cmd.getName().equalsIgnoreCase("company")) {
            CompanyMainMenu gui = new CompanyMainMenu();
            player.openInventory(gui.getInventory());
        }
        if (args.length >= 1) {
            if(args[0].equalsIgnoreCase("create")) {
                player.closeInventory();
                sender.sendMessage("Test123");
                return true;
            }
        }

        return true;
    }
}
