package de.areon.system.nms;

import java.lang.reflect.Field;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class NMSBase {
    public Class<?> getNMSClass(String name) {
        try {
            String fullname = "net.minecraft.server." + Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3] + "." + name;
            return Class.forName(fullname);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NMS.class.getName()).log(Level.SEVERE, (String)null, ex);
            return null;
        }
    }

    public Class<?> getCraftBukkitClass(String name) {
        String fullname = "org.bukkit.craftbukkit." + Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3] + "." + name;
        try {
            return Class.forName(fullname);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NMS.class.getName()).log(Level.SEVERE, (String)null, ex);
            return null;
        }
    }

    public void setValue(Object obj, String name, Object value) {
        try {
            Field field = obj.getClass().getDeclaredField(name);
            field.setAccessible(true);
            field.set(obj, value);
        } catch (NoSuchFieldException|SecurityException|IllegalArgumentException|IllegalAccessException ex) {
            Logger.getLogger(NMS.class.getName()).log(Level.SEVERE, (String)null, ex);
        }
    }

    public Object getValue(Object obj, String name) {
        try {
            Field field = obj.getClass().getDeclaredField(name);
            field.setAccessible(true);
            return field.get(obj);
        } catch (NoSuchFieldException|SecurityException|IllegalArgumentException|IllegalAccessException ex) {
            Logger.getLogger(NMS.class.getName()).log(Level.SEVERE, (String)null, ex);
            return null;
        }
    }

    public Field getField(Object obj, String name) {
        try {
            Field field = obj.getClass().getDeclaredField(name);
            field.setAccessible(true);
            return field;
        } catch (NoSuchFieldException|SecurityException ex) {
            Logger.getLogger(NMS.class.getName()).log(Level.SEVERE, (String)null, ex);
            return null;
        }
    }

    public void sendPacket(Object packet, Player player) {
        try {
            Object handle = player.getClass().getMethod("getHandle", new Class[0]).invoke(player, new Object[0]);
            Object playerConnetction = handle.getClass().getField("playerConnection").get(handle);
            playerConnetction.getClass().getMethod("sendPacket", new Class[] { getNMSClass("Packet") }).invoke(playerConnetction, new Object[] { packet });
        } catch (NoSuchMethodException|SecurityException|IllegalAccessException|IllegalArgumentException|java.lang.reflect.InvocationTargetException|NoSuchFieldException ex) {
            Logger.getLogger(NMS.class.getName()).log(Level.SEVERE, (String)null, ex);
        }
    }

    public void sendPacket(Object packet, List<Player> players) {
        players.forEach(player -> sendPacket(packet, player));
    }

    public void sendPacket(Object packet) {
        Bukkit.getOnlinePlayers().forEach(player -> sendPacket(packet, player));
    }

    public Object getCraftPlayer(Player player) {
        Class<?> craftPlayerClazz = getCraftBukkitClass("entity.CraftPlayer");
        return craftPlayerClazz.cast(player);
    }
}
