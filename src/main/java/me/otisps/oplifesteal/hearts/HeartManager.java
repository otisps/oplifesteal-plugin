package me.otisps.oplifesteal.hearts;

import me.otisps.oplifesteal.data.FileManager;
import org.bukkit.GameMode;
import org.bukkit.attribute.Attribute;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.util.UUID;

public class HeartManager {

    /**
     * Steal Heart from player
     * @param player target
     */
        public void stealHeart(Player player) throws IOException {
            double hearts = getMaxHearts(player);
            setMaxHearts(player, (hearts - 2));
        }

    /**
     * Add heart to player
     * @param player target
     */
    public void addHeart(Player player) throws IOException {
        double hearts = getMaxHearts(player);
            setMaxHearts(player, (hearts + 2));
        }
    /**
     * Gets the maximum amount of hearts from the data file of a particular player
     * @param player target
     * @return the maximum amount of hearts
     */
    public double getMaxHearts(Player player){
        double maxHearts = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue();
        return maxHearts;
    }

    /**
     * Saves the number of hearts the client of a target player should show
     * @param uuid target player's uuid
     * @param upperBound maximum number of hearts
     * @return boolean - success or failure
     */
    public boolean saveMaxHearts(UUID uuid, double upperBound) throws IOException {
        FileManager fileManager = new FileManager();
        FileConfiguration dataFileConfig = fileManager.getDataFileConfig();
        dataFileConfig.set("hearts." + uuid.toString(), upperBound);
        fileManager.saveDataFile(dataFileConfig);
        return true;
    }

    /**
     * permanently updates the maximum hearts a particular player can have.
     * @param player target
     */
    public void setMaxHearts(Player player, double heartsScale) throws IOException {
        if(heartsScale > 2){
            player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(heartsScale);
        }
        UUID playerId = player.getUniqueId();
        saveMaxHearts(playerId, heartsScale);
    }


    public void addToSpectate(Player player) throws IOException {
        setMaxHearts(player, 0);
        player.spigot().respawn();
        player.setGameMode(GameMode.SPECTATOR);
    }

    public void revive(Player player) throws IOException {
        setMaxHearts(player, 20);
        player.setGameMode(GameMode.SURVIVAL);
    }
}
