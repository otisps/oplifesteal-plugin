package me.otisps.oplifesteal.commands;

import me.otisps.oplifesteal.hearts.HeartManager;
import me.otisps.oplifesteal.items.LifestealGenerator;
import me.otisps.oplifesteal.utils.ChatUtils;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;

public class WithdrawCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length > 0 ) return true;
        if(sender instanceof Player){
            Player player = ((Player) sender);
            if(player.getGameMode().equals(GameMode.SURVIVAL)){
                if(player.getHealthScale() <= 2){
                    player.sendMessage(ChatUtils.hexFormat("You don't have any hearts to withdraw!"));
                    return true;
                }
                HeartManager lifesteal = new HeartManager();
                try {
                    lifesteal.stealHeart(player);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                LifestealGenerator lifestealGenerator = new LifestealGenerator();
                ItemStack customHeart = lifestealGenerator.getLifeHeart();
                player.getInventory().addItem(customHeart);
            }
        }
        return true;
    }
}
