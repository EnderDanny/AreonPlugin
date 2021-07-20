package de.areon.system.commands;

import de.areon.system.data.Data2;
import de.areon.system.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RStartCommand implements CommandExecutor {
    
    @Override
    public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
        Player p = (Player) sender;
        if(p.hasPermission("system.admin")){
            Bukkit.broadcastMessage(String.valueOf(Data2.Prefix) + "§4Der Server startet in 1 Minute neu");
            Bukkit.getScheduler().runTaskLater(Main.system, new Runnable() {

                @Override
                public void run() {
                    Bukkit.broadcastMessage(String.valueOf(Data2.Prefix) + "§4Der Server startet in 30 Sekunden neu");
                    Bukkit.getScheduler().runTaskLater(Main.system, new Runnable() {

                        @Override
                        public void run() {
                            Bukkit.broadcastMessage(String.valueOf(Data2.Prefix) + "§4Der Server startet in 15 Sekunden neu");
                            Bukkit.getScheduler().runTaskLater(Main.system, new Runnable() {

                                @Override
                                public void run() {
                                    Bukkit.broadcastMessage(String.valueOf(Data2.Prefix) + "§4Der Server startet in 10 Sekunden neu");
                                    Bukkit.getScheduler().runTaskLater(Main.system, new Runnable() {

                                        @Override
                                        public void run() {
                                            Bukkit.broadcastMessage(String.valueOf(Data2.Prefix) + "§4Der Server startet in 5 Sekunden neu");
                                            Bukkit.getScheduler().runTaskLater(Main.system, new Runnable() {

                                                @Override
                                                public void run() {
                                                    Bukkit.broadcastMessage(String.valueOf(Data2.Prefix) + "§4Der Server startet in 3 Sekunden neu");
                                                    Bukkit.getScheduler().runTaskLater(Main.system, new Runnable() {

                                                        @Override
                                                        public void run() {
                                                            Bukkit.broadcastMessage(String.valueOf(Data2.Prefix) + "§4Der Server startet in 1 Sekunden neu");
                                                            Bukkit.getScheduler().runTaskLater(Main.system, new Runnable() {

                                                                @Override
                                                                public void run() {
                                                                    Bukkit.broadcastMessage(String.valueOf(Data2.Prefix) + "§4Der Server startet JETZT neu");
                                                                    Bukkit.shutdown();
                                                                }
                                                            }, 20);
                                                        }
                                                    }, 2*20);
                                                }
                                            }, 2*20);
                                        }
                                    }, 5*20);
                                }
                            }, 5*20);
                        }
                    }, 15*20);
                }
            }, 30*20);
        } else {
            p.sendMessage(String.valueOf(Data2.Prefix) + "Nope");
        }
        return false;
    }
}
