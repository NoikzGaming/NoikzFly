package me.noikzgaming.noikzfly.commands.MainCommand;

import me.noikzgaming.noikzfly.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class NoikzFlyCommand implements CommandExecutor {

    private static final ChatColor ErrorMessage = ChatColor.DARK_RED;
    private static final ChatColor ReloadedMessage = ChatColor.YELLOW;

    public static FileConfiguration config = Main.plugin.getConfig();
    File cfile = Main.plugin.cfile;

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("noikzfly")) {
            if (!sender.hasPermission("noikzfly.use")) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("prefix") + ErrorMessage + config.getString("no-permission-message")));
                return true;
            }
            if (args.length == 0) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("prefix") + ErrorMessage + config.getString("no-subcommand-provided.message")));
                return true;
            }
            if (args.length > 0) {
                if (args[0].equalsIgnoreCase("reload")) {
                    if (!sender.hasPermission("noikzfly.reload")) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("prefix") + ErrorMessage + config.getString("no-permission-message")));
                        return true;
                    } else if (sender.hasPermission("noikzfly.reload")) {
                        config = YamlConfiguration.loadConfiguration(cfile);
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("prefix") + ReloadedMessage + config.getString("reload-message")));
                    }
                }
            }
        }
        return true;
    }
}
