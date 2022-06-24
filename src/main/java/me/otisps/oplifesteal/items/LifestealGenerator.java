package me.otisps.oplifesteal.items;

import me.otisps.oplifesteal.utils.ChatUtils;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;

public class LifestealGenerator {

    public ItemStack getLifeHeart(){
        ItemStack customHeart = new ItemStack(Material.MOOSHROOM_SPAWN_EGG);
        ItemMeta heartMeta = customHeart.getItemMeta();
        heartMeta.setDisplayName(ChatUtils.hexFormat("&rPlayer Heart"));
        customHeart.setItemMeta(heartMeta);
        return customHeart;
    }

    public ItemStack getReviveBeacon(){
        ItemStack customBeacon = new ItemStack(Material.BEACON);
        ItemMeta beaconMeta = customBeacon.getItemMeta();
        beaconMeta.setLore(Collections.singletonList(ChatUtils.hexFormat("&rRename me before placing!")));
        beaconMeta.setDisplayName(ChatUtils.hexFormat("&rRevive Beacon"));
        customBeacon.setItemMeta(beaconMeta);
        return customBeacon;
    }
}
