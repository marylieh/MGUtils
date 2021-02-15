package de.asmax.butils.listener;

import de.asmax.butils.utils.GameStateManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;

public class AchievmentListener implements Listener {

    @EventHandler
    public void handleAchievment(PlayerAdvancementDoneEvent event) {
        if(GameStateManager.timerIsPaused == false) {
            if(GameStateManager.timerIsRunning == true) {
                if(GameStateManager.noAdchievment == true) {

                    for(Player all : Bukkit.getOnlinePlayers()) {
                        all.damage(0.5);
                    }

                }
            }
        }
    }
}
