package de.areon.system.config;

import de.areon.system.main.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ConfigManager {

    private Main main;

    private FileConfiguration fileConfiguration;

    private File file;

    public ConfigManager(Main Areon) {
        this.main = Areon;
        this.fileConfiguration = Areon.getConfig();
        this.file = new File(Areon.getDataFolder().getPath(), "config.yml");
    }

    public ConfigManager copyDefaults() {
        this.fileConfiguration.options().copyDefaults(true);
        save();
        return this;
    }

    public void save() {
        try {
            this.fileConfiguration.save(this.file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FileConfiguration getFileConfiguration() {
        return this.fileConfiguration;
    }

    public FormatableString getString(String path) {
        return new FormatableString(this.fileConfiguration.getString(path));
    }

    public Integer getInt(String path) {
        return Integer.valueOf(this.fileConfiguration.getInt(path));
    }

    public Boolean getBoolean(String path) {
        return Boolean.valueOf(this.fileConfiguration.getBoolean(path));
    }

    public Double getDouble(String path) {
        return Double.valueOf(this.fileConfiguration.getDouble(path));
    }

    public List<String> getStringList(String path) {
        return this.fileConfiguration.getStringList(path);
    }

    public ItemStack getItemStack(String path) {
        return this.fileConfiguration.getItemStack(path);
    }

    public void setString(String path, String value) {
        this.fileConfiguration.set(path, value);
        save();
    }

    public void setInt(String path, Integer value) {
        this.fileConfiguration.set(path, value);
        save();
    }

    public void setBoolean(String path, Boolean value) {
        this.fileConfiguration.set(path, value);
        save();
    }

    public void setDouble(String path, Double value) {
        this.fileConfiguration.set(path, value);
        save();
    }

    public void setStringList(String path, List<String> value) {
        this.fileConfiguration.set(path, value);
        save();
    }

    public void setItemStack(String path, ItemStack value) {
        this.fileConfiguration.set(path, value);
        save();
    }

    public boolean exist(String path) {
        return this.fileConfiguration.isSet(path);
    }
}
