package me.otisps.oplifesteal.hearts;

import me.otisps.oplifesteal.Oplifesteal;
import org.bukkit.GameMode;
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
            setMaxHearts(player, getMaxHearts(player) - 2);
        }

    /**
     * Add heart to player
     * @param player target
     */
    public void addHeart(Player player) throws IOException {
            setMaxHearts(player, getMaxHearts(player) + 2);
        }
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
        dataFileConfig.set("hearts." + uuid.toString(), upperBound);
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


    public void addToSpectate(Player player) throws IOException {
        setMaxHearts(player, 0);
        player.spigot().respawn();
        player.setGameMode(GameMode.SPECTATOR);
        player.sendMessage("You had all your hearts stolen!");
    }

    public void revive(Player player) throws IOException {
        player.setHealth(20);
        player.setGameMode(GameMode.SURVIVAL);
        setMaxHearts(player, 20);
    }
}
