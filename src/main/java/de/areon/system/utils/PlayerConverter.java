package de.areon.system.utils;

import java.util.Set;
import java.util.stream.Collectors;

import de.areon.system.main.Main;
import net.luckperms.api.model.user.User;
import net.luckperms.api.node.NodeType;
import net.luckperms.api.node.types.InheritanceNode;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;

public class PlayerConverter {
    public static String getGroup(Player player) {
        return getUserObject(player).getGroup();
    }

    public static String getChatPrefix(Player player) {
        return getUserObject(player).getChatPrefix();
    }

    private static UserObject getUserObject(Player player) {
        for (UserObject userObject : Main.getUserObjects()) {
            if (isPlayerInGroup(player, userObject.getGroup()))
                return userObject;
        }
        return Main.getUserObjects().get(Main.getUserObjects().size() - 1);
    }

    public static void setTabPrefix(Player player) {
        Thread thread = new Thread(() -> {
            for (Player target : Bukkit.getOnlinePlayers()) {
                Scoreboard sb = player.getScoreboard();
                UserObject userObject = getUserObject(target);
                String team = userObject.getId();
                if (sb.getTeam(team) == null)
                    sb.registerNewTeam(team);
                sb.getTeam(team).setPrefix(userObject.getTabPrefix());
                sb.getTeam(team).addPlayer((OfflinePlayer) target);
            }
            for (Player target : Bukkit.getOnlinePlayers()) {
                if (target == player)
                    continue;
                Scoreboard sb = target.getScoreboard();
                UserObject userObject = getUserObject(player);
                String team = userObject.getId();
                if (sb.getTeam(team) == null)
                    sb.registerNewTeam(team);
                sb.getTeam(team).setPrefix(userObject.getTabPrefix());
                sb.getTeam(team).addPlayer((OfflinePlayer) player);
            }
            Thread.currentThread().stop();
        });
        thread.start();
    }

    public static boolean isPlayerInGroup(Player player, String group) {
        User user = Main.getLuckPermsApi().getUserManager().getUser(player.getUniqueId());
        assert user != null;
        Set<String> groups = (Set<String>) user.getNodes().stream().filter(NodeType.INHERITANCE::matches).map(NodeType.INHERITANCE::cast).map(InheritanceNode::getGroupName).collect(Collectors.toSet());
        return groups.contains(group);
    }
}