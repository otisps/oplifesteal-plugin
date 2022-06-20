package me.otisps.oplifesteal.listeners;

import me.otisps.oplifesteal.events.PlayerMurderEvent;
import me.otisps.oplifesteal.items.BookGenerator;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class MurderListeners implements Listener {

    @EventHandler
    public void onMurderGiveBook(PlayerMurderEvent event){
        Player killer = event.getKiller();
        BookGenerator bookFactory = new BookGenerator();
        killer.getInventory().addItem(bookFactory.getOPBook());
    }


}
