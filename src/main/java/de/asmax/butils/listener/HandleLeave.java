package de.asmax.butils.listener;

import de.asmax.butils.utils.GameStateManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class HandleLeave implements Listener {

    @EventHandler
    public static void handleLeave(PlayerQuitEvent event) {
        event.setQuitMessage("§4<< §7" + event.getPlayer().getName());

        GameStateManager.onlinePlayers.remove(event.getPlayer().getName());

    }
}
