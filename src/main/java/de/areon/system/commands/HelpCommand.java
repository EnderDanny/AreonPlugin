package de.areon.system.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player)sender;
        if(sender instanceof Player)
            if (p.hasPermission("areon.admin")) {
                p.sendMessage("§f----§9Areon Hilfseite§f----");
                p.sendMessage("§c/tool §f-> §7Öffne das Tool Menü");
                p.sendMessage("§c/gm §f-> §7Ändert die Gamemodes");
                p.sendMessage("§c/neustart §f-> §7Startet denn Server neu");
                p.sendMessage("§c/rang §f-> §7Ändert den Rang eines Spielers");
                p.sendMessage("§f----§9Areon Hilfseite§f----");
            } else {
                p.sendMessage("§f----§9Areon Hilfseite§f----");
                p.sendMessage("§cNope");
                p.sendMessage("§f----§9Areon Hilfseite§f----");
            }
        return false;
    }
}
