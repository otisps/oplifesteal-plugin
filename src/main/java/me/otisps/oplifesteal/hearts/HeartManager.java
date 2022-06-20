package me.otisps.oplifesteal.hearts;

import org.bukkit.entity.Player;

import java.util.UUID;

public class HeartManager {

    /**
     * Gets the maximum amount of hearts from the data file of a particular player
     * @param player target
     * @return the maximum amount of hearts
     */
    public int getMaxHearts(Player player){
        // TODO: Check File
        return 20;
    }

    /**
     * permanently updates the maximum hearts a particular player can have.
     * @param player target
     */
    public void setMaxHearts(Player player){
        int heartsScale = getMaxHearts(player);
        player.setHealthScale(heartsScale);
        UUID playerId = player.getUniqueId();
        saveMaxHearts(playerId, heartsScale);
    }


    public boolean saveMaxHearts(UUID uuid, int scale){
        // TODO : Save In File
        return true;
    }
}
