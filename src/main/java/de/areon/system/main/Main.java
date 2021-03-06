package de.areon.system.main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.google.common.collect.Lists;
import de.areon.system.commands.*;
import de.areon.system.config.ConfigManager;
import de.areon.system.data.Data;
import de.areon.system.listener.*;
import de.areon.system.nms.BetterNMS;
import de.areon.system.nms.NMS;
import de.areon.system.utils.IdsUtils;
import de.areon.system.utils.PlayerUtils;
import de.areon.system.utils.UserObject;
import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class Main extends JavaPlugin implements CommandExecutor {

    ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();

    String command = "restart";

    int i = 600;

    public static Main instance;

    public static String Prefix;

    public static String Tab;

    public static Main system;

    private static Main plugin;

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

    public static String Areon = "??8??? ??9??lAREON ??8??? ??7";

    public static IdsUtils idsUtils;



    @Override
    public void onEnable() {
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask((Plugin)this, new Runnable() {
            public void run() {
                DateFormat dateformat = new SimpleDateFormat("HH:mm");
                Date date = new Date();
                String first = Main.this.getConfig().getString("first");
                if (dateformat.format(date).equals(first))
                    Bukkit.dispatchCommand((CommandSender)Main.this.console, Main.this.command);
            }
        },0L, 1200L);

        instance = this;
        plugin = this;
        idsUtils = new IdsUtils();
        configManager = (new ConfigManager(this)).copyDefaults();
        loadNMS();
        system = this;
        loadLuckPerms();
        loadListener(Bukkit.getPluginManager());
        saveDefaultConfig();
        loadCommands();
        loadConfig();
        loadUserObjects();
        log("??aPlugin geladen.");
        log("??9Verison: ??bv" + getDescription().getVersion());

        getServer().getPluginManager().registerEvents(new ToolCommand(), this);
        getServer().getPluginManager().registerEvents(new sendTabListener(), this);
        getServer().getPluginManager().registerEvents(new ConnectionListener(), this);

        getCommand("tools").setExecutor(new ToolCommand());
        getCommand("gm").setExecutor(new GamemodeCommand());
        getCommand("gamemode").setExecutor(new GamemodeCommand());
        getCommand("help").setExecutor(new HelpCommand());
        getCommand("speed").setExecutor(new SpeedCommand());
        getCommand("id").setExecutor(new IdCommand());
        getCommand("restart").setExecutor(new RStartCommand());




    }

    public void onDisable() {}

    public static Main getPlugin() {
        return plugin;
    }

    public void loadConfig() {
        FileConfiguration cfg = getConfig();
        cfg.options().copyDefaults(true);
        saveConfig();

        getConfig().options().copyDefaults(true);
        saveConfig();
        if (getConfig().getString("Prefix.Prefix") != null)
            Prefix = getConfig().getString("Prefix.Prefix").replaceAll("&", "??");

        getConfig().options().copyDefaults(true);
        saveConfig();
        if (getConfig().getString("Tab.Tab") != null)
            Tab = getConfig().getString("Tab.Tab").replaceAll("&", "??");
    }

    private void loadListener(PluginManager pluginManager) {
        pluginManager.registerEvents((Listener)new JoinListener(), (Plugin)this);
        if (configManager.getBoolean("useChatFormat").booleanValue() && configManager.exist("useChatFormat"))
            pluginManager.registerEvents((Listener)new ChatListener(), (Plugin)this);
    }

    private void loadCommands() {
    }

    String Pr = getConfig().getString("Config.Prefix-Rm");

    private void loadLuckPerms() {
        Plugin luckPerms = Bukkit.getPluginManager().getPlugin("LuckPerms");
        if (luckPerms != null && luckPerms.isEnabled()) {
            RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
            if (provider != null)
                luckPermsApi = (LuckPerms)provider.getProvider();
            if (configManager.getBoolean("autoUpdate").booleanValue() && configManager.exist("autoUpdate"))
                new UpdateListener(this, luckPermsApi);
            return;
        }
        log("konnte nicht gefunden werden...");
        log("Plugin wird nun deaktiviert.");
        Bukkit.getPluginManager().disablePlugin((Plugin)this);
    }

    private void loadNMS() {
        String version = getServer().getClass().getPackage().getName().replace(".", "-").split("-")[3];
        log("Der Server lauf der Version ??e "+ version + "??7.");
        nms = (NMS)new BetterNMS();
    }

    private void loadUserObjects() {
        List<String> list = getConfigManager().getStringList("prefixes");
        AtomicInteger count = new AtomicInteger(1);
        list.forEach(string -> getUserObjects().add((new UserObject(string)).setId(Integer.valueOf(count.getAndIncrement()))));
    }

    public static void log(String message) {
        Bukkit.getConsoleSender().sendMessage(Data.getPrefix() + message);
    }




}
