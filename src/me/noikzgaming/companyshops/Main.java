package me.noikzgaming.companyshops;

import me.noikzgaming.companyshops.commands.Commands;
import me.noikzgaming.companyshops.events.ClickEvents;
import me.noikzgaming.companyshops.events.InventoryEvents;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable(){
        getCommand("company").setExecutor(new Commands());
        getServer().getPluginManager().registerEvents(new InventoryEvents(), this);
        getServer().getPluginManager().registerEvents(new ClickEvents(), this);
        getLogger().info("Company has been enabled!");
    }
    @Override
    public void onDisable() {
        getLogger().info("Company has been disabled!");
    }
}
