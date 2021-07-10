package de.areon.system.commands;


import de.areon.system.data.Data2;
import de.areon.system.main.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.ArrayList;

public class IdCommand implements CommandExecutor {


    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player)sender;
            if (p.getItemInHand().getType() == Material.AIR) {
                p.sendMessage(String.valueOf(Data2.Prefix) + " §c§lDu hast kein Item in der Hand");
            } else {
                p.sendMessage(String.valueOf(Data2.Prefix) + " §7Gehaltenes Item§7: §9§l" +
                        Main.idsUtils.getItemInHand(p) + " §7ID des Items§7: §9§l" + Main.idsUtils.getItemIDInHand(p));
            }
        }
        return false;
    }
}
