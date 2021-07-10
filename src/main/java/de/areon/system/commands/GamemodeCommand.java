package de.areon.system.commands;


import de.areon.system.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player)sender;
        if (sender instanceof Player) {
            if (!p.hasPermission("areon.gm")) {
                p.sendMessage(Main.Areon + "§c§lDu Haste keine Rechte");
            } else {
                if (args.length == 0) {
                    p.sendMessage(Main.Areon + "§7Bitte benutze§8: §a/gm [0|1|2|3] <Spieler>§7.");
                } else if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("0")) {
                        p.setGameMode(GameMode.SURVIVAL);
                        p.sendMessage(Main.Areon + "§7Du bist nun im §a" + p.getGameMode() + "-MODUS §7.");
                    } else if (args[0].equalsIgnoreCase("1")) {
                        p.setGameMode(GameMode.CREATIVE);
                        p.sendMessage(Main.Areon + "§7Du bist nun im §a" + p.getGameMode() + "-MODUS §7.");
                    } else if (args[0].equalsIgnoreCase("2")) {
                        p.setGameMode(GameMode.ADVENTURE);
                        p.sendMessage(Main.Areon + "§7Du bist nun im §a" + p.getGameMode() + "-MODUS §7.");
                    } else if (args[0].equalsIgnoreCase("3")) {
                        p.setGameMode(GameMode.SPECTATOR);
                        p.sendMessage(Main.Areon + "§7Du bist nun im §a" + p.getGameMode() + "-MODUS §7.");
                    } else if (args[0].equalsIgnoreCase("Spectator")) {
                        p.setGameMode(GameMode.SPECTATOR);
                        p.sendMessage(Main.Areon + "§7Du bist nun im §a" + p.getGameMode() + "-MODUS §7.");
                    } else if (args[0].equalsIgnoreCase("Survival")) {
                        p.setGameMode(GameMode.SURVIVAL);
                        p.sendMessage(Main.Areon + "§7Du bist nun im §a" + p.getGameMode() + "-MODUS §7.");
                    } else if (args[0].equalsIgnoreCase("Creative")) {
                        p.setGameMode(GameMode.CREATIVE);
                        p.sendMessage(Main.Areon + "§7Du bist nun im §a" + p.getGameMode() + "-MODUS §7.");
                    } else {
                        p.sendMessage(Main.Areon + "§7Bitte benutze§8: §a/gm [0|1|2|3] <Spieler>§7.");
                    }
                } else if (args.length == 2) {
                    Player t = Bukkit.getPlayer(args[1]);
                    try {
                        if (args[0].equalsIgnoreCase("0")) {
                            t.setGameMode(GameMode.SURVIVAL);
                            t.sendMessage(Main.Areon + "§7Du bist nun im §a" + p.getGameMode() + "-MODUS §7.");
                            p.sendMessage(Main.Areon + "§7Der Spieler §a" + t.getName() + "§7 ist nun im §a" + t.getGameMode() + "-MODUS§7.");
                        } else if (args[0].equalsIgnoreCase("1")) {
                            t.setGameMode(GameMode.CREATIVE);
                            t.sendMessage(Main.Areon + "§7Du bist nun im §a" + p.getGameMode() + "-MODUS §7.");
                            p.sendMessage(Main.Areon + "§7Der Spieler §a" + t.getName() + "§7 ist nun im §a" + t.getGameMode() + "-MODUS§7.");
                        } else if (args[0].equalsIgnoreCase("2")) {
                            t.setGameMode(GameMode.ADVENTURE);
                            t.sendMessage(Main.Areon + "§7Du bist nun im §a" + t.getGameMode() + "-MODUS §7.");
                            p.sendMessage(Main.Areon + "§7Der Spieler §a" + t.getName() + " §7 ist nun im §a" + t.getGameMode() + "-MODUS§7.");
                        } else if (args[0].equalsIgnoreCase("3")) {
                            t.setGameMode(GameMode.SPECTATOR);
                            t.sendMessage(Main.Areon + "§7Du bist nun im §a" + p.getGameMode() + "-MODUS §7.");
                            p.sendMessage(Main.Areon + "§7Der Spieler §a" + t.getName() + "§7 ist nun im §a" + t.getGameMode() + "-MODUS§7.");
                        } else if (args[0].equalsIgnoreCase("Spectator")) {
                            t.setGameMode(GameMode.SPECTATOR);
                            t.sendMessage(Main.Areon + "§7Du bist nun im §a" + p.getGameMode() + "-MODUS §7.");
                            p.sendMessage(Main.Areon + "§7Der Spieler §a" + t.getName() + "§7 ist nun im §a" + t.getGameMode() + "-MODUS§7.");
                        } else if (args[0].equalsIgnoreCase("Creative")) {
                            t.setGameMode(GameMode.CREATIVE);
                            t.sendMessage(Main.Areon + "§7Du bist nun im §a" + p.getGameMode() + "-MODUS §7.");
                            p.sendMessage(Main.Areon + "§7Der Spieler §a" + t.getName() + "§7 ist nun im §a" + t.getGameMode() + "-MODUS§7.");
                        } else if (args[0].equalsIgnoreCase("Survival")) {
                            t.setGameMode(GameMode.SURVIVAL);
                            t.sendMessage(Main.Areon + "§7Du bist nun im §a" + p.getGameMode() + "-MODUS §7.");
                            p.sendMessage(Main.Areon + "§7Der Spieler §a" + t.getName() + "§7 ist nun im §a" + t.getGameMode() + "-MODUS§7.");
                        } else {
                            t.sendMessage(Main.Areon + "§7Bitte benutze§8: §a/gm [0|1|2|3] <Spieler>§7.");
                        }
                    } catch (Exception e) {
                        p.sendMessage(Main.Areon + "§7Der Spieler §e" + args[1] + " §7ist nicht §conline §7oder §cexistiert §7nicht.");
                    }
                } else {
                    p.sendMessage(Main.Areon + "§7Bitte benutze§8: §a/gm [0|1|2|3] <Spieler>§7.");
                }
            }
        } else {
            sender.sendMessage("§cDu musst ein Spieler sein.");
        }
        return false;
    }
}