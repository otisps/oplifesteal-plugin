package me.otisps.oplifesteal.listeners;

import me.otisps.oplifesteal.events.PlayerKillEvent;
import me.otisps.oplifesteal.hearts.HeartManager;
import me.otisps.oplifesteal.items.BookGenerator;
import me.otisps.oplifesteal.utils.ChatUtils;
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
        victim.getInventory().clear();
        Player killer = event.getKiller();
        if (lifeSteal.getMaxHearts(victim) <= 2){
            try {
                lifeSteal.addToSpectate(victim);
                victim.sendMessage(ChatUtils.hexFormat("You had all your hearts stolen and must now spectate!"));
                lifeSteal.addHeart(killer);
                killer.sendMessage(ChatUtils.hexFormat("You stole a heart from " + victim.getDisplayName()));
                return;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            lifeSteal.stealHeart(victim);
            if(lifeSteal.getMaxHearts(killer) >= 40){
                killer.sendMessage("You can't gain any more hearts, you're at the max!");
                return;
            }
            lifeSteal.addHeart(killer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        victim.sendMessage(ChatUtils.hexFormat("You had a heart stolen from " + killer.getDisplayName()));
        killer.sendMessage(ChatUtils.hexFormat("You stole a heart from " + victim.getDisplayName()));
    }
}
