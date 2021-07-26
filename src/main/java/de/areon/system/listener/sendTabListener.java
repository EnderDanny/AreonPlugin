package de.areon.system.listener;

import com.connorlinfoot.titleapi.TitleAPI;
import de.areon.system.data.Data2;
import de.areon.system.utils.ItemActionbarManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.text.SimpleDateFormat;
import java.util.Date;

public class sendTabListener implements Listener {





    @EventHandler
    public static void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        SimpleDateFormat date = new SimpleDateFormat("dd.MM.yyyy HH.mm.ss");
        String zeit = date.format(new Date());

        TitleAPI.sendTabTitle(p, "\n §7------ " + String.valueOf(Data2.Tab) + "§7------\n",  "\n §7------ §b§lBauserver §7------\n");

        ItemActionbarManager.sendTitle1(p.getPlayer(), 10, 10, 100, String.valueOf(Data2.Tab), "§bWillkommen §7" + p.getName());
    }
}
