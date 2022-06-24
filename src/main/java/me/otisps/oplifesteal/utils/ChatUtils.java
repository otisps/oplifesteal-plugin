package me.otisps.oplifesteal.utils;

import me.otisps.oplifesteal.Oplifesteal;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChatUtils {
    private final static Pattern hexPattern = Pattern.compile("#[a-fA-F0-9]{6}");

    public static String hexFormat(String message){ // Credit to CodedRed
        Matcher match = hexPattern.matcher(message);
        while (match.find()){
            String colour = message.substring(match.start(), match.end());
            message = message.replace(colour, ChatColor.valueOf(colour) + "");
            match = hexPattern.matcher(message);
        }
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}
