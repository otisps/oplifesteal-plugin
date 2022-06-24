package me.otisps.oplifesteal.data;

import me.otisps.oplifesteal.Oplifesteal;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class FileManager {
    private File dataFile;
    private FileConfiguration dataFileConfig;

    public FileConfiguration getDataFileConfig() {
        createDataFile();
        return this.dataFileConfig;
    }

    public void createDataFile() {
        dataFile = new File(Oplifesteal.getInstance().getDataFolder(), "data.yml");
        if(!dataFile.exists()) {
            dataFile.getParentFile().mkdirs();
            Oplifesteal.getInstance().saveResource("data.yml", false);
        }

        this.dataFileConfig = new YamlConfiguration();
        this.dataFileConfig = YamlConfiguration.loadConfiguration(dataFile);

    }

    public void saveDataFile(FileConfiguration dataFileConfig) throws IOException {
        dataFileConfig.save(dataFile);
    }
}
