package me.otisps.oplifesteal.listeners;

import me.otisps.oplifesteal.hearts.HeartManager;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.io.IOException;

public class PlayerInteractListener implements Listener {

    @EventHandler
    public void playerRightClick(PlayerInteractEvent event) {
        if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK) || event.getAction().equals(Action.RIGHT_CLICK_AIR)){
            PlayerInventory inventory = event.getPlayer().getInventory();
            ItemStack itemInMainHand = inventory.getItemInMainHand();
            if(itemInMainHand.getType().equals(Material.BARRIER)){
                event.setCancelled(true);
                HeartManager heartManager = new HeartManager();
                if(heartManager.getMaxHearts(event.getPlayer()) >= 40) {
                    event.getPlayer().sendMessage("You are at the maximum amount of hearts!");
                    return;
                }
                int stackSize = itemInMainHand.getAmount();
                if(stackSize > 1){
                    itemInMainHand.setAmount(stackSize-1);
                } else {
                    inventory.setItemInMainHand(new ItemStack(Material.AIR));
                }
                try {
                    heartManager.addHeart(event.getPlayer());

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
