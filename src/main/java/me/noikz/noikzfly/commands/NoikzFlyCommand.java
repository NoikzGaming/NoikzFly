package me.noikz.noikzfly.commands;

import me.noikz.noikzfly.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class NoikzFlyCommand implements CommandExecutor {

    private static final ChatColor ErrorMessage = ChatColor.DARK_RED;
    private static final ChatColor ReloadedMessage = ChatColor.YELLOW;

    private Main plugin;
    private static FileConfiguration config = Main.plugin.getConfig();

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("noikzfly")) {
            if (!sender.hasPermission("noikzfly.use")) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("prefix") + ErrorMessage + "You don`t have permission to execute this command!"));
                return true;
            }
            if (args.length == 0) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("prefix") + ErrorMessage + "You need to provide a subcommand!"));
                return true;
            }
            if (args.length > 0) {
                if (args[0].equalsIgnoreCase("reload")) {
                    if (!sender.hasPermission("noikzfly.reload")) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("prefix") + ErrorMessage + "You don`t have permission to execute this command!"));
                        return true;
                    } else if (sender.hasPermission("noikzfly.reload")) {
                        config = YamlConfiguration.loadConfiguration(Main.plugin.cfile);
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("prefix") + ReloadedMessage + "Config reloaded"));
                    }
                }
            }
        }
        return true;
    }
}
