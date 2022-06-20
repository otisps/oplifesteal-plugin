package me.otisps.oplifesteal.listeners;

import me.otisps.oplifesteal.Oplifesteal;
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
        FileConfiguration data = Oplifesteal.getInstance().getDataFileConfig();
        if (data.contains("hearts." + player.getUniqueId().toString())) {
            player.setHealthScale(data.getInt("hearts." + player.getUniqueId().toString() ));
            return;
        }
        HeartManager lifeSteal = new HeartManager();
        try {
            lifeSteal.saveMaxHearts(player.getUniqueId(), 20);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
