package me.otisps.oplifesteal;

import me.otisps.oplifesteal.crafting.Recipes;
import me.otisps.oplifesteal.listeners.DeathListeners;
import me.otisps.oplifesteal.listeners.JoinListener;
import me.otisps.oplifesteal.listeners.MurderListeners;
import me.otisps.oplifesteal.listeners.PlayerInteractListener;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.Recipe;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public final class Oplifesteal extends JavaPlugin {

    private File dataFile;
    private FileConfiguration dataFileConfig;
    private static Oplifesteal instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.instance = this;
        this.getLogger().info("Plugin has been enabled.");
        Bukkit.getServer().getPluginManager().registerEvents(new DeathListeners(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new MurderListeners(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new JoinListener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerInteractListener(), this);

        this.saveDefaultConfig();
        createDataFile();

        Recipes recipe = new Recipes();
        recipe.addHeart();
        recipe.addBeacon();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        this.getLogger().info("Plugin has been disabled");
    }

    public FileConfiguration getDataFileConfig() {
        return dataFileConfig;
    }

    public static Oplifesteal getInstance() {
        return instance;
    }

    private void createDataFile() {
        dataFile = new File(getDataFolder(), "data.yml");
        if(!dataFile.exists()) {
            dataFile.getParentFile().mkdirs();
            saveResource("data.yml", false);
        }

        dataFileConfig = new YamlConfiguration();
        dataFileConfig = YamlConfiguration.loadConfiguration(dataFile);

    }
    public void saveDataFile(FileConfiguration dataFileConfig) throws IOException {
        dataFileConfig.save(dataFile);
    }
}
