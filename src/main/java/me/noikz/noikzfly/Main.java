package me.noikz.noikzfly;

import me.noikz.noikzfly.commands.FlyCommand;
import me.noikz.noikzfly.commands.FlySpeedCommand;
import me.noikz.noikzfly.commands.TabCompleters.TabCompleterFlySpeed;
//import me.noikz.noikzfly.events.PlayerJoin;
import me.noikz.noikzfly.updatechecker.UpdateCheckSource;
import me.noikz.noikzfly.commands.NoikzFlyCommand;
import me.noikz.noikzfly.commands.TabCompleters.TabCompleterNoikzFly;
import me.noikz.noikzfly.updatechecker.UpdateChecker;
import me.noikz.noikzfly.updatechecker.UserAgentBuilder;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Main extends JavaPlugin{

    public static Main plugin;
    public static FileConfiguration config;
    public File cfile;
    private static final Boolean isSpigotVersion = true;
    private static final String SPIGOT_RESOURCE_ID = "98316";
    @Override
    public void onEnable() {
        int pluginId = 20734;
        Metrics metrics = new Metrics(this, pluginId);

        //UpdateChecker https://github.com/mfnalex/Spigot-UpdateChecker
        if (isSpigotVersion) {
            new UpdateChecker(this, UpdateCheckSource.SPIGET, SPIGOT_RESOURCE_ID)
                    .setDownloadLink("https://www.spigotmc.org/resources/noikzfly.98316/")
                    .setNotifyOpsOnJoin(true)
                    .setNotifyByPermissionOnJoin("noikzfly.updatechecker")
                    .setUserAgent(new UserAgentBuilder().addPluginNameAndVersion())
                    .checkEveryXHours(24)
                    .checkNow();
        }
        plugin = this;
        cfile = new File(getDataFolder(), "config.yml");
        config = getConfig();
        config.options().copyDefaults(true);
        saveConfig();
        //getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("noikzfly").setExecutor(new NoikzFlyCommand());
        getCommand("noikzfly").setTabCompleter(new TabCompleterNoikzFly());
        getCommand("flyspeed").setExecutor(new FlySpeedCommand());
        getCommand("flyspeed").setTabCompleter(new TabCompleterFlySpeed());
        this.saveDefaultConfig();
        this.getConfig().addDefault("prefix", "&6&lNoikzFly &7> ");
        this.getConfig().addDefault("fly-on-message", "Fly Mode activated");
        this.getConfig().addDefault("fly-off-message", "Fly Mode deactivated");
        //DataFile.setup();
        //DataFile.get().options().copyDefaults(true);
        //DataFile.save();
    }
}
