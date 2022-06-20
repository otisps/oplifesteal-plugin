package me.otisps.oplifesteal.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Only is called when a player is murdered
 */
public class PlayerMurderEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private Player victim;
    private Player killer;

    public Player getVictim() {
        return victim;
    }

    public Player getKiller() {
        return killer;
    }

    public PlayerMurderEvent(Player victim, Player killer){
        this.killer = killer;
        this.victim = victim;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
