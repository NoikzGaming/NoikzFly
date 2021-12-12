package me.noikzgaming.noikzfly.commands;

import me.noikzgaming.noikzfly.Main;
import me.noikzgaming.noikzfly.commands.MainCommand.NoikzFlyCommand;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.ArrayList;

public class FlyCommand implements CommandExecutor {

    private static ChatColor ErrorMessage = ChatColor.DARK_RED;
    private static ChatColor FlyOffMessage = ChatColor.RED;
    private static ChatColor FlyOnMessage = ChatColor.GREEN;

    FileConfiguration config = Main.plugin.getConfig();

    private ArrayList<Player> list_of_flying_players = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', NoikzFlyCommand.config.getString("prefix") + ErrorMessage + NoikzFlyCommand.config.getString("only-players-can-execute")));
            return true;
        }

    Player player = (Player) sender;
        if(cmd.getName().equalsIgnoreCase("fly")) {
            if (!sender.hasPermission("noikzfly.fly")) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', NoikzFlyCommand.config.getString("prefix") + ErrorMessage + NoikzFlyCommand.config.getString("no-permission-message")));
                return true;
            }
        if (list_of_flying_players.contains(player)){
            list_of_flying_players.remove(player);
            player.setAllowFlight(false);
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', NoikzFlyCommand.config.getString("prefix") + FlyOffMessage + NoikzFlyCommand.config.getString("fly-off-message")));
        } else if (!list_of_flying_players.contains(player)) {
            list_of_flying_players.add(player);
            ((Player) sender).setAllowFlight(true);
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', NoikzFlyCommand.config.getString("prefix") + FlyOnMessage + NoikzFlyCommand.config.getString("fly-on-message")));
        }
     }
        return true;
   }
 }
