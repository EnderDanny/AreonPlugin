package de.areon.system.listener;

import de.areon.system.main.Main;
import de.areon.system.utils.PlayerConverter;
import org.bukkit.entity.Player;
import java.util.regex.Pattern;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {
    @EventHandler
    public void onChat (AsyncPlayerChatEvent event) {
        String message = event.getMessage().replace("%", "%%");
        if (Main.getConfigManager().exist("chatFormat"))
            event.setFormat(Main.getConfigManager().getString("chatFormat").formatColors()
            .replace("%chatPrefix%", PlayerConverter.getChatPrefix(event.getPlayer()))
            .replace("%playerName%", event.getPlayer().getName())
            .replace("%message%", translateColorCodes(event.getPlayer(), message))
            .replace("%ping%", Main.getNms().getPing(event.getPlayer()) + "ms")
            .replace("%displayName%", event.getPlayer().getDisplayName())
            .replace("&group&", PlayerConverter.getGroup(event.getPlayer())));
    }

    private static final Pattern chatColorPattern = Pattern.compile("(?i)&([0-9A-FR])");

    private static final Pattern chatMagicPattern = Pattern.compile("(?i)&([K])");

    private static final Pattern chatBoldPattern = Pattern.compile("(?i)&([L])");

    private static final Pattern chatStrikethroughPattern = Pattern.compile("(?i)&([M])");

    private static final Pattern chatUnderlinePattern = Pattern.compile("(?i)&([N])");

    private static final Pattern chatItalicPattern = Pattern.compile("(?i)&([O])");




    public static String translateColorCodes(Player player, String message) {
        if (!Main.getConfigManager().getBoolean("useColorTranslate").booleanValue() && Main.getConfigManager().exist("useColorTranslate"))
            return message;
        String newstring = message;
        if (player.hasPermission("lucktab.chat.format.color"))
            newstring = chatColorPattern.matcher(newstring).replaceAll("§$1");
        if (player.hasPermission("lucktab.chat.format.magic"))
            newstring = chatMagicPattern.matcher(newstring).replaceAll("§$1");
        if (player.hasPermission("lucktab.chat.format.bold"))
            newstring = chatBoldPattern.matcher(newstring).replaceAll("§$1");
        if (player.hasPermission("lucktab.chat.format.strikethrough"))
            newstring = chatStrikethroughPattern.matcher(newstring).replaceAll("§$1");
        if (player.hasPermission("lucktab.chat.format.underline"))
            newstring = chatUnderlinePattern.matcher(newstring).replaceAll("§$1");
        if (player.hasPermission("lucktab.chat.format.italic"))
            newstring = chatItalicPattern.matcher(newstring).replaceAll("§$1");
        return newstring;
    }
}
