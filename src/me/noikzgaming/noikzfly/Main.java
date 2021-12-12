package me.noikzgaming.noikzfly;

import me.noikzgaming.noikzfly.commands.FlyCommand;
import me.noikzgaming.noikzfly.commands.MainCommand.NoikzFlyCommand;
import me.noikzgaming.noikzfly.commands.TabCompleters.TabCompleterNoikzFly;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Main extends JavaPlugin{

    public static Main plugin;
    public File cfile;

    @Override
    public void onEnable(){
        plugin = this;
        cfile = new File(getDataFolder(), "config.yml");
        this.getConfig().options().copyDefaults(true);
        saveConfig();
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("noikzfly").setExecutor(new NoikzFlyCommand());
        getCommand("noikzfly").setTabCompleter(new TabCompleterNoikzFly());
        // getCommand("flyspeed").setExecutor(new Commands());
        // getCommand("flyspeed").setTabCompleter(new TabCompleterFlySpeed());
        this.saveDefaultConfig();
        this.getConfig().addDefault("no-permission-message", "You don`t have permission to execute this command!");
        this.getConfig().addDefault("no-subcommand-provided", "You need to provide a subcommand!");
        this.getConfig().addDefault("reload-message", "Config has been reloaded!");
        this.getConfig().addDefault("prefix", "&6&lNoikzFly &7> ");
        this.getConfig().addDefault("fly-off-message", "Fly Mode unactivated");
        this.getConfig().addDefault("fly-on-message", "Fly Mode activated");
        this.getConfig().addDefault("only-players-can-execute", "Only players can execute this command!");
    }
}
