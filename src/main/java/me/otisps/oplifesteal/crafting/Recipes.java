package me.otisps.oplifesteal.crafting;

import me.otisps.oplifesteal.Oplifesteal;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;

public class Recipes {

    public void addHeart(){
        NamespacedKey heartKey = new NamespacedKey(Oplifesteal.getInstance(), "player_heart");
        ItemStack customHeart = new ItemStack(Material.MOOSHROOM_SPAWN_EGG);
        ItemMeta heartMeta = customHeart.getItemMeta();
        heartMeta.setDisplayName("Heart");
        customHeart.setItemMeta(heartMeta);
        ShapedRecipe recipe = new ShapedRecipe(heartKey ,customHeart);
        recipe.shape("DTD", "TNT", "DTD");
        recipe.setIngredient('D', Material.DIAMOND_BLOCK);
        recipe.setIngredient('N', Material.NETHERITE_INGOT);
        recipe.setIngredient('T', Material.TOTEM_OF_UNDYING);
        Bukkit.addRecipe(recipe);
    }

    public void addBeacon(){
        NamespacedKey heartKey = new NamespacedKey(Oplifesteal.getInstance(), "player_beacon");
        ItemStack customHeart = new ItemStack(Material.BEACON);
        ItemMeta heartMeta = customHeart.getItemMeta();
        heartMeta.setLore(Collections.singletonList("Rename me before placing!"));
        heartMeta.setDisplayName("Revive Beacon");
        customHeart.setItemMeta(heartMeta);
        ShapedRecipe recipe = new ShapedRecipe(heartKey ,customHeart);
        recipe.shape("DND", "TBT", "DTD");
        recipe.setIngredient('D', Material.DIAMOND_BLOCK);
        recipe.setIngredient('N', Material.NETHERITE_INGOT);
        recipe.setIngredient('T', Material.TOTEM_OF_UNDYING);
        recipe.setIngredient('B', Material.BEACON);
        Bukkit.addRecipe(recipe);
    }

}
