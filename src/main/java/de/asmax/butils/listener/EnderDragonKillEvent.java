package de.asmax.butils.listener;

import de.asmax.butils.utils.GameStateManager;
import de.asmax.butils.utils.Timer;
import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class EnderDragonKillEvent implements Listener {

    @EventHandler
    public void handleEnderdragonKill(EntityDeathEvent event) {
        if(GameStateManager.killEnderdragon) {
            if(GameStateManager.timerIsRunning) {
                if(!GameStateManager.timerIsPaused) {
                    if(event.getEntityType() == EntityType.ENDER_DRAGON) {
                        Bukkit.broadcastMessage(" ");
                        Bukkit.broadcastMessage("§8[§6Enderdragon§8] §7Der §6§lEnderdrache §7ist gestorben.");
                        Bukkit.broadcastMessage("§8[§6Enderdragon§8] §aDie Challenge ist hiermit absolviert.");
                        Bukkit.broadcastMessage("§8[§6Enderdragon§8] §7Zeit benötigt: §9§l" + Timer.shortInteger(Timer.getTime()));
                        Bukkit.broadcastMessage(" ");

                        Timer.getRunnable().cancel();
                        GameStateManager.timerIsRunning = false;
                    }
                }
            }
        }
    }
}
