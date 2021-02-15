package de.asmax.butils.listener;

import de.asmax.butils.utils.GameStateManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class BlockBreakEvent implements Listener {

    @EventHandler
    public void handleBlockBreak(org.bukkit.event.block.BlockBreakEvent event) {
        if(GameStateManager.timerIsRunning == true) {
            if(GameStateManager.timerIsPaused == true) {
                event.setCancelled(true);
            }
        } else {
            event.setCancelled(true);
        }
    }
}
