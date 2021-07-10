package de.areon.system.utils;

import net.minecraft.server.v1_12_R1.IChatBaseComponent;
import net.minecraft.server.v1_12_R1.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_12_R1.PacketPlayOutPlayerListHeaderFooter;
import net.minecraft.server.v1_12_R1.PlayerConnection;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.lang.reflect.Field;

public class TablistAPI {

    public static void Tab(Player p, String header, String footer) {
        if (header == null) header = "";
        if (footer == null) footer = "";
        PlayerConnection connection = ((CraftPlayer) p).getHandle().playerConnection;

        IChatBaseComponent Title = ChatSerializer.a("{\"text\": \"" + header + "\"}");
        IChatBaseComponent foot = ChatSerializer.a("{\"text\": \"" + footer + "\"}");

        PacketPlayOutPlayerListHeaderFooter headerPacket = new PacketPlayOutPlayerListHeaderFooter();

        try {
            Field field = headerPacket.getClass().getDeclaredField("b");
            field.setAccessible(true);
            field.set(headerPacket, foot);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.sendPacket(headerPacket);
        }
    }
}

