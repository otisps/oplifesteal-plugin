package me.otisps.oplifesteal.listeners;

import me.otisps.oplifesteal.hearts.HeartManager;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;

public class PlayerInteractListener implements Listener {

    @EventHandler
    public void playerRightClick(PlayerInteractEvent event) {
        if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK) || event.getAction().equals(Action.RIGHT_CLICK_AIR)){
            if(event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.MOOSHROOM_SPAWN_EGG)){
                event.getPlayer().getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                HeartManager heartManager = new HeartManager();
                try {
                    heartManager.addHeart(event.getPlayer());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
