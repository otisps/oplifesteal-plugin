package me.otisps.oplifesteal.listeners;

import me.otisps.oplifesteal.events.PlayerKillEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathListeners implements Listener {

    @EventHandler
    public void onDeathEvent(PlayerDeathEvent event){
        Player victim = event.getEntity();
        Player killer = victim.getKiller();
        killer.sendMessage("success");
        if(killer == (null)) return;
        Bukkit.getServer().getPluginManager().callEvent(new PlayerKillEvent(victim, killer));
    }
}
