package me.otisps.oplifesteal.hearts;

import me.otisps.oplifesteal.Oplifesteal;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.util.UUID;

public class HeartManager {
    /**
     * Gets the maximum amount of hearts from the data file of a particular player
     * @param player target
     * @return the maximum amount of hearts
     */
    public int getMaxHearts(Player player){
        FileConfiguration dataFileConfig = Oplifesteal.getInstance().getDataFileConfig();
        int maxHearts = dataFileConfig.getInt("hearts." + player.getUniqueId().toString());
        return maxHearts;
    }

    /**
     * Saves the number of hearts the client of a target player should show
     * @param uuid target player's uuid
     * @param upperBound maximum number of hearts
     * @return boolean - success or failure
     */
    public boolean saveMaxHearts(UUID uuid, int upperBound) throws IOException {
        FileConfiguration dataFileConfig = Oplifesteal.getInstance().getDataFileConfig();
        dataFileConfig.set("hearts." + Bukkit.getPlayer(uuid).toString(), upperBound);
        Oplifesteal.getInstance().saveDataFile(dataFileConfig);
        return true;
    }

    /**
     * permanently updates the maximum hearts a particular player can have.
     * @param player target
     */
    public void setMaxHearts(Player player, int heartsScale) throws IOException {
        player.setHealthScale(heartsScale);
        UUID playerId = player.getUniqueId();
        saveMaxHearts(playerId, heartsScale);
    }



}
