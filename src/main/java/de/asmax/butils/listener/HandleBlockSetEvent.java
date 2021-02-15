package de.asmax.butils.listener;

import de.asmax.butils.utils.GameStateManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class HandleBlockSetEvent implements Listener {

    @EventHandler
    public void handleBlockSet(BlockPlaceEvent event) {
        if(GameStateManager.timerIsRunning) {
            if(GameStateManager.timerIsPaused) {
                event.setCancelled(true);
            }
        } else {
            event.setCancelled(true);
        }
    }
}
