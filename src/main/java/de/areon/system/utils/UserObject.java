package de.areon.system.utils;


import java.text.DecimalFormat;
import java.text.NumberFormat;

public class UserObject {
    private String group;

    private String tabPrefix;

    private String chatPrefix;

    private Integer id;

    public UserObject(String group, String tabPrefix, String chatPrefix, int id) {
        this.group = group;
        this.tabPrefix = tabPrefix;
        this.chatPrefix = chatPrefix;
        this.id = Integer.valueOf(id);
    }

    public UserObject(String toConvert) {
        String[] strings = toConvert.split(";");
        this.group = strings[0];
        this.tabPrefix = strings[1];
        this.chatPrefix = strings[2];
    }

    public String getGroup() {
        return this.group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getTabPrefix() {
        if (this.tabPrefix.length() > 16)
            return this.tabPrefix.replace('&', '§').substring(0, 15);
        return this.tabPrefix.replace('&', '§');
    }

    public void setTabPrefix(String tabPrefix) {
        this.tabPrefix = tabPrefix;
    }

    public String getChatPrefix() {
        return this.chatPrefix.replace('&', '§');
    }

    public void setChatPrefix(String chatPrefix) {
        this.chatPrefix = chatPrefix;
    }

    public String getId() {
        NumberFormat numberFormat = new DecimalFormat("0000");
        return numberFormat.format(this.id);
    }

    public UserObject setId(Integer id) {
        this.id = id;
        return this;
    }
}
