package me.otisps.oplifesteal.items;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Random;

public class BookGenerator {

    /**
     * Generates a Random Enchant that is naturally not obtainable.
     * 40% of the time it is 2 enchants higher than possible...
     * @return Enchantment book with "illegal" enchant
     */
    public ItemStack getOPBook(){
        ItemStack enchantingBook = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta itemMeta = enchantingBook.getItemMeta();
        Enchantment[] allEnchants = Enchantment.values();
        Random rand = new Random();
        int randInt = rand.nextInt(allEnchants.length-1);
        Enchantment enchant = allEnchants[randInt];
        int enchantLevel = enchant.getMaxLevel() + 1;
        if((rand.nextInt(100) ) < 60) enchantLevel +=1;
        itemMeta.addEnchant(enchant, enchantLevel, true);
        enchantingBook.setItemMeta(itemMeta);
        return enchantingBook;
    }
}
