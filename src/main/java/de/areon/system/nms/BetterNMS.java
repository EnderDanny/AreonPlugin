package de.areon.system.nms;

import org.bukkit.entity.Player;

public class BetterNMS extends NMSBase implements NMS {
    public Integer getPing(Player player) {
        try {
            Object craftPlayer = getCraftPlayer(player);
            Object entityPlayer = craftPlayer.getClass().getMethod("getHandle", new Class[0]).invoke(craftPlayer, new Object[0]);
            return (Integer)getValue(entityPlayer, "ping");
        } catch (IllegalAccessException|NoSuchMethodException|java.lang.reflect.InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }
}

