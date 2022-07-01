package me.otisps.oplifesteal.listeners;

import me.otisps.oplifesteal.data.FileManager;
import me.otisps.oplifesteal.hearts.HeartManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.IOException;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoinEvent(PlayerJoinEvent event){
        Player player = event.getPlayer();
        player.setHealthScale(20);
        FileManager fileManager = new FileManager();
        HeartManager lifeSteal = new HeartManager();
        FileConfiguration data = fileManager.getDataFileConfig();
        if (data.contains("hearts." + player.getUniqueId().toString())) {
            try {
                lifeSteal.setMaxHearts(player, data.getDouble("hearts." + player.getUniqueId().toString()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return;
        }
        try {
            lifeSteal.saveMaxHearts(player.getUniqueId(), 20);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
