package de.areon.system.listener;

import java.util.UUID;

import de.areon.system.main.Main;
import de.areon.system.utils.PlayerConverter;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.event.EventBus;
import net.luckperms.api.event.user.UserDataRecalculateEvent;
import net.luckperms.api.event.user.track.UserPromoteEvent;
import net.luckperms.api.model.user.User;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class UpdateListener {
    private Main main;

    public UpdateListener(Main main, LuckPerms api) {
        this.main = main;
        EventBus eventBus = api.getEventBus();
        eventBus.subscribe(UserPromoteEvent.class, e -> onUpdateEvent(e.getUser()));
        eventBus.subscribe(UserDataRecalculateEvent.class, e -> onUpdateEvent(e.getUser()));
    }

    private void onUpdateEvent(User user) {
        UUID uuid = user.getUniqueId();
        Player player = Bukkit.getPlayer(uuid);
        try {
            if (player != null)
                PlayerConverter.setTabPrefix(player);
        } catch (Exception exception) {}
    }
}
