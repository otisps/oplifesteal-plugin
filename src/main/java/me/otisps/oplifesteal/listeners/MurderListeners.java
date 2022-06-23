package me.otisps.oplifesteal.listeners;

import me.otisps.oplifesteal.events.PlayerKillEvent;
import me.otisps.oplifesteal.hearts.HeartManager;
import me.otisps.oplifesteal.items.BookGenerator;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.io.IOException;

public class MurderListeners implements Listener {

    @EventHandler
    public void onMurderGiveBook(PlayerKillEvent event){
        Player killer = event.getKiller();
        BookGenerator bookFactory = new BookGenerator();
        killer.getInventory().addItem(bookFactory.getOPBook());
    }

    @EventHandler
    public void onMurderLifeSteal(PlayerKillEvent event){
        HeartManager lifeSteal = new HeartManager();
        Player victim = event.getVictim();
        Player killer = event.getKiller();
        if (lifeSteal.getMaxHearts(victim) <= 2){
            lifeSteal.addToSpectate(victim);
            killer.sendMessage("Victim doesn't have any hearts left to steal!");
            return;
        }
        try {
            lifeSteal.stealHeart(victim);
            lifeSteal.addHeart(killer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        victim.sendMessage("You had a heart stolen from " + killer.getDisplayName());
        killer.sendMessage("You stole a heart from " + victim.getDisplayName());
    }
}
