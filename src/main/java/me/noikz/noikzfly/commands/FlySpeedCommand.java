package me.noikz.noikzfly.commands;

import me.noikz.noikzfly.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class FlySpeedCommand implements CommandExecutor {

    private static ChatColor ErrorMessage = ChatColor.DARK_RED;
    private static ChatColor Successful = ChatColor.GREEN;

    private static FileConfiguration config = Main.plugin.getConfig();

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("prefix") + ErrorMessage + "Only players can execute this command!"));
            return true;
        }
        if (cmd.getName().equalsIgnoreCase("flyspeed")) {
            if (!sender.hasPermission("noikzfly.flyspeed")) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("prefix") + ErrorMessage + "You don`t have permission to execute this command!"));
                return true;
            } else {
                Player player = (Player) sender;
                if (args.length < 1) {
                    player.setFlySpeed(0.1F);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("prefix") + Successful + "Reset flight speed"));
                } else {
                    try {
                        Integer speedValue = Integer.parseInt(args[0]);
                        if (speedValue > 10 || speedValue < 1) {
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("prefix") + ErrorMessage + "The number you entered isn't a valid number, enter a number between 1 and 10 (default is 1)"));
                            return true;
                        }
                        player.setFlySpeed((float) (speedValue * 0.1));
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("prefix") + Successful + "Set flight speed to " + speedValue));
                    } catch(NumberFormatException e) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("prefix") + ErrorMessage + "The value you entered isn't a number"));
                        return true;
                    }
                }
            }
        }
        return true;
    }

}
