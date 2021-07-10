package de.areon.system.commands;

import de.areon.system.data.Data2;
import de.areon.system.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpeedCommand implements CommandExecutor {
  public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
    Player p = (Player)cs;
    if (cs instanceof Player) {
      if (!p.hasPermission("areon.speed")) {
        p.sendMessage(String.valueOf(Data2.Prefix) + "§c§lDu Hast keine Rechte!");
      }else {
        if (args.length == 0) {
          p.sendMessage(String.valueOf(Data2.Prefix) + "§7Benutze §9/speed [Speed] <Player>");
        } else if (args.length == 1) {
        	int speed;
            try {
              speed = Integer.parseInt(args[0]);
              } catch (NumberFormatException e) {
                  p.sendMessage(String.valueOf(Data2.Prefix) + "§7Benutze §a/speed [Speed] <Player>§7.");
                  return false;
              }
              if (speed < 1 || speed > 10) {
                  p.sendMessage(String.valueOf(Data2.Prefix) + "§7Benutze §a/speed [Speed] <Player>§7.");
                  return false;
              }
              if (p.isFlying()) {
                  p.setFlySpeed((float) speed / 10);
              } else {
                  p.setWalkSpeed((float) speed/ 10);
              }
              if(p.isFlying()) {
             	p.sendMessage(String.valueOf(Data2.Prefix) + "§eDein §6Flyspeed §7wurde auf §6" + speed + "§7 gesetzt.");
              } else {
              	p.sendMessage(String.valueOf(Data2.Prefix) + "§eDein §6Walkspeed §awurde auf §6" + speed + "§7 gesetzt.");
              }
        } else if (args.length == 2) {
          Player t = Bukkit.getPlayer(args[1]);
          int speed;
          if(t != null) {
          try {
            speed = Integer.parseInt(args[0]);
            } catch (Exception e) {
                p.sendMessage(String.valueOf(Data2.Prefix) + "§7Der Spieler §e" + args[1] + " §7ist nicht §conline §7oder §cexistiert $7nicht.");
                return false;
            }
            if (speed < 1 || speed > 10) {
                p.sendMessage(String.valueOf(Data2.Prefix) + "§7Benutze §a/speed [Speed] <Player>§7.");
                return false;
            }
            if (t.isFlying()) {
                t.setFlySpeed((float) speed / 10);
            } else {
                t.setWalkSpeed((float) speed/ 10);
            }
            if(t.isFlying()) {
            	t.sendMessage(String.valueOf(Data2.Prefix) + "§eDein §6Flyspeed §7wurde auf §6" + speed + "§7 gesetzt.");
            	p.sendMessage(String.valueOf(Data2.Prefix) + "§e" + t.getName() + "'s§6 Flyspeed §7wurde auf §6" + speed + "§7 gesetzt.");
            } else {
            	t.sendMessage(String.valueOf(Data2.Prefix) + "§eDein §6Walkspeed §7wurde auf §6" + speed + "§7 gesetzt.");
            	p.sendMessage(String.valueOf(Data2.Prefix) + "§e" + t.getName() + "'s§6 Flyspeed §7wurde auf §6" + speed + "§7 gesetzt.");
            }
          } else {
        	  p.sendMessage(String.valueOf(Data2.Prefix) + "§7Der Spieler ist §cnicht §7verfügbar.");
          }
        }
      }
    } else {
        cs.sendMessage("§cDu musst ein Spieler sein.");
        }
    return false;
    }
}