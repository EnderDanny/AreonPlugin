package de.areon.system.commands;


import de.areon.system.main.Main;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class IdCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player)sender;
            if (player.getItemInHand().getType() == Material.AIR) {
                player.sendMessage(Main.Areon + " §c§lDu hast kein Item in der Hand");
            } else {
                player.sendMessage(Main.Areon + " §7Gehaltenes Item§7: §9§l" +
                        Main.idsUtils.getItemInHand(player) + " §7ID des Items§7: §9§l" + Main.idsUtils.getItemIDInHand(player));
            }
        }
        return false;
    }
}
