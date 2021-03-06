package me.otisps.oplifesteal;

import me.otisps.oplifesteal.commands.WithdrawCommand;
import me.otisps.oplifesteal.crafting.Recipes;
import me.otisps.oplifesteal.data.FileManager;
import me.otisps.oplifesteal.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Oplifesteal extends JavaPlugin {

    private static Oplifesteal instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        getLogger().info("Plugin has been enabled.");

        Bukkit.getServer().getPluginManager().registerEvents(new DeathListeners(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new MurderListeners(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new JoinListener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerInteractListener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new BlockListener(), this);

        FileManager fileManager = new FileManager();
        saveDefaultConfig();
        fileManager.createDataFile();

        getCommand("withdraw").setExecutor(new WithdrawCommand());

        Recipes recipe = new Recipes();
        recipe.addHeart();
        recipe.addBeacon();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        this.getLogger().info("Plugin has been disabled");
    }



    public static Oplifesteal getInstance() {
        return instance;
    }


}
