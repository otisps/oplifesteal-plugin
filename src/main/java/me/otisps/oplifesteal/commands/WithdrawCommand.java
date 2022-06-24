package me.otisps.oplifesteal.commands;

import me.otisps.oplifesteal.hearts.HeartManager;
import me.otisps.oplifesteal.items.LifestealGenerator;
import me.otisps.oplifesteal.utils.ChatUtils;
import org.bukkit.GameMode;
import org.bukkit.Material;
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
                if(!player.getInventory().getItemInMainHand().getType().equals(Material.AIR)) {
                    player.sendMessage(ChatUtils.hexFormat("Make sure you aren't holding anything!"));
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
                player.getInventory().setItemInMainHand(customHeart);
            }
        }
        return true;
    }
}
