package me.otisps.oplifesteal.listeners;

import me.otisps.oplifesteal.hearts.HeartManager;
import me.otisps.oplifesteal.utils.ChatUtils;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.io.IOException;

public class BlockListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockPlaceEvent event){
        if(!event.getBlock().getType().equals(Material.BEACON)) return;
        event.getItemInHand().getItemMeta().getLore().contains(ChatUtils.hexFormat("Rename me before placing!"));
        event.setCancelled(true);
        String name = event.getItemInHand().getItemMeta().getDisplayName();
        for (Player p: Bukkit.getOnlinePlayers()) {
            if(p.getDisplayName().equalsIgnoreCase(name)){
                if(p.getGameMode().equals(GameMode.SPECTATOR)){
                    p.setHealth(20);
                    HeartManager heartManager = new HeartManager();
                    try {
                        heartManager.revive(p);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    Location location = event.getBlock().getLocation();
                    location.setY(location.getBlockY() + 2);
                    p.teleport(location);
                    PotionEffect levitate = new PotionEffect(PotionEffectType.LEVITATION, 5, 4);
                    p.addPotionEffect(levitate);
                    location.getWorld().playSound(location, Sound.ENTITY_GENERIC_EXPLODE, 200, 1 );
                    p.sendMessage(ChatUtils.hexFormat("You were revived!"));
                    event.getPlayer().sendMessage(ChatUtils.hexFormat("Player was revived!"));
                    event.getPlayer().getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                }
            }
        }
    }
}
