package me.otisps.oplifesteal.commands;

import me.otisps.oplifesteal.hearts.HeartManager;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.IOException;
import java.util.HashMap;

public class WithdrawCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length > 0 ) return true;

        if(sender instanceof Player){
            Player player = ((Player) sender);
            if(player.getGameMode().equals(GameMode.SURVIVAL)){
                if(player.getInventory().getItemInMainHand() != null) {
                    player.sendMessage("Make sure you aren't holding anything!");
                    return true;
                }
                HeartManager lifesteal = new HeartManager();
                try {
                    lifesteal.stealHeart(player);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                ItemStack customHeart = new ItemStack(Material.MOOSHROOM_SPAWN_EGG);
                ItemMeta heartMeta = customHeart.getItemMeta();
                heartMeta.setDisplayName("Heart");
                customHeart.setItemMeta(heartMeta);
                player.getInventory().setItemInMainHand(customHeart);
            }
        }
        return true;
    }
}
