package de.areon.system.config;

public class FormatableString {
    private String string;

    public FormatableString(String string) {
        this.string = string;
    }

    public String formatColors() {
        if (this.string != null)
            return this.string.replace('&', '§');
        return "Der String konnte nicht gefunden werden.";
    }

    public String getString() {
        if (this.string != null)
            return this.string;
        return "Der String konnte nicht gefunden werden.";
    }
}
