package me.otisps.oplifesteal;

import me.otisps.oplifesteal.listeners.DeathListeners;
import me.otisps.oplifesteal.listeners.MurderListeners;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Oplifesteal extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getLogger().info("Plugin has been enabled.");
        Bukkit.getServer().getPluginManager().registerEvents(new DeathListeners(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new MurderListeners(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        this.getLogger().info("Plugin has been disabled");
    }
}
