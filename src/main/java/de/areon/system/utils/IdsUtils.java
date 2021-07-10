package de.areon.system.utils;

import de.areon.system.main.Main;
import org.bukkit.entity.Player;

public class IdsUtils {

    public String getItemInHand(Player player) {
        String material = player.getItemInHand().getType().name();
        return material;
    }

    public String getItemIDInHand(Player player) {
        int ID = player.getItemInHand().getType().getId();
        String Data = player.getItemInHand().getData().toString();
        String SubID = Data.replace("LEGACY_" + Main.idsUtils.getItemInHand(player) + "(", "").replace(")", "");
        String cID = String.valueOf(String.valueOf(ID)) + ":" + SubID;
        return cID;
    }
}
