package me.noikz.noikzfly.commands;

//import me.noikz.noikzfly.DataFile;
import me.noikz.noikzfly.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class FlyCommand implements CommandExecutor {

    private static ChatColor ErrorMessage = ChatColor.DARK_RED;
    private static ChatColor FlyOffMessage = ChatColor.RED;
    private static ChatColor FlyOnMessage = ChatColor.GREEN;

    private static FileConfiguration config = Main.plugin.getConfig();

    private ArrayList<Player> list_of_flying_players = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("prefix") + ErrorMessage + "Only players can execute this command!"));
            return true;
        }

        Player player = (Player) sender;
        if(cmd.getName().equalsIgnoreCase("fly")) {
            if (!player.hasPermission("noikzfly.fly")) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("prefix") + ErrorMessage + "You don`t have permission to execute this command!"));
                return true;
            }
        if (list_of_flying_players.contains(player)){
            list_of_flying_players.remove(player);
            player.setAllowFlight(false);
            //DataFile.get().set(player.getUniqueId() + ".flyOn", false);
            //DataFile.save();
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("prefix") + FlyOffMessage + config.getString("fly-off-message")));
        } else {
            list_of_flying_players.add(player);
            player.setAllowFlight(true);
            //DataFile.get().set(player.getUniqueId() + ".flyOn", true);
            //DataFile.save();
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("prefix") + FlyOnMessage + config.getString("fly-on-message")));
        }
     }
        return true;
   }
 }
