package me.noikz.noikzfly.commands.TabCompleters;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class TabCompleterFlySpeed implements TabCompleter {

    List<String> arguments = new ArrayList<String>();

    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        if (arguments.isEmpty()) {
            arguments.add("1"); arguments.add("2");
            arguments.add("3"); arguments.add("4");
            arguments.add("5"); arguments.add("6");
            arguments.add("7"); arguments.add("8");
            arguments.add("9"); arguments.add("10");
            arguments.add("3"); arguments.add("4");
            arguments.add("5"); arguments.add("6");
            arguments.add("7"); arguments.add("8");
            arguments.add("9"); arguments.add("10");
        }

        List<String> result = new ArrayList<String>();
        if (args.length == 1) {
            for (String a : arguments) {
                if (a.toLowerCase().startsWith(args[0].toLowerCase()))
                    result.add(a);
            }
            return result;
        }

        return null;
    }
}
