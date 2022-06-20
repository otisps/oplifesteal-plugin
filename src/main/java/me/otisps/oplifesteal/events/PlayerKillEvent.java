package me.otisps.oplifesteal.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Event which contains the victim and killer for a player kill event.
 */
public class PlayerKillEvent extends Event {

    private static final HandlerList handlers = new HandlerList();
    private Player victim;
    private Player killer;

    public Player getVictim() {
        return victim;
    }

    public Player getKiller() {
        return killer;
    }

    public PlayerKillEvent(Player victim, Player killer){
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
