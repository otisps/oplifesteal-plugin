package me.otisps.oplifesteal.crafting;

import me.otisps.oplifesteal.Oplifesteal;
import me.otisps.oplifesteal.items.LifestealGenerator;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class Recipes {

    public void addHeart(){
        NamespacedKey heartKey = new NamespacedKey(Oplifesteal.getInstance(), "player_heart");
        LifestealGenerator lifestealGenerator = new LifestealGenerator();
        ItemStack customHeart = lifestealGenerator.getLifeHeart();
        ShapedRecipe recipe = new ShapedRecipe(heartKey ,customHeart);
        recipe.shape("DTD", "TNT", "DTD");
        recipe.setIngredient('D', Material.DIAMOND_BLOCK);
        recipe.setIngredient('N', Material.NETHERITE_INGOT);
        recipe.setIngredient('T', Material.TOTEM_OF_UNDYING);
        Bukkit.addRecipe(recipe);
    }

    public void addBeacon(){
        NamespacedKey beaconKey = new NamespacedKey(Oplifesteal.getInstance(), "player_beacon");
        LifestealGenerator lifestealGenerator = new LifestealGenerator();
        ItemStack reviveBeacon = lifestealGenerator.getReviveBeacon();
        ShapedRecipe recipe = new ShapedRecipe(beaconKey ,reviveBeacon);
        recipe.shape("DND", "TBT", "DTD");
        recipe.setIngredient('D', Material.DIAMOND_BLOCK);
        recipe.setIngredient('N', Material.NETHERITE_INGOT);
        recipe.setIngredient('T', Material.TOTEM_OF_UNDYING);
        recipe.setIngredient('B', Material.BEACON);
        Bukkit.addRecipe(recipe);
    }

}
