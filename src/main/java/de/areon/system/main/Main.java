package de.areon.system.main;

import com.google.common.collect.Lists;
import de.areon.system.config.ConfigManager;
import de.areon.system.listener.ChatListener;
import de.areon.system.listener.JoinListener;
import de.areon.system.listener.UpdateListener;
import de.areon.system.nms.BetterNMS;
import de.areon.system.nms.NMS;
import de.areon.system.utils.UserObject;
import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class Main extends JavaPlugin {

    private static Main instance;

    private static LuckPerms luckPermsApi;

    private static ConfigManager configManager;

    public static Main getInstance() {
        return instance;
    }

    public static LuckPerms getLuckPermsApi() {
        return luckPermsApi;
    }

    public static ConfigManager getConfigManager() {
        return configManager;
    }

    public static List<UserObject> getUserObjects() {
        return userObjects;
    }

    private static List<UserObject> userObjects = Lists.newArrayList();

    private static NMS nms;

    public static NMS getNms() {
        return nms;
    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }



}
