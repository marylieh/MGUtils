package de.asmax.butils.listener;

import de.asmax.butils.utils.GameStateManager;
import de.asmax.butils.utils.Timer;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeath implements Listener {

    @EventHandler
    public void handlePlayerDeath(PlayerDeathEvent event) {
        if(GameStateManager.timerIsPaused == false) {
            if(GameStateManager.timerIsRunning == true) {

                GameStateManager.timerIsRunning = false;
                Timer.getRunnable().cancel();

                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage("§8[§6Tod§8] §7Der Spieler §6§l" + event.getEntity().getName() + " §r§7ist gestorben.");
                Bukkit.broadcastMessage("§8[§6Tod§8] §cDie Challenge ist hiermit beendet.");
                Bukkit.broadcastMessage("§8[§6Tod§8] §7Zeit verschwendet: §9§l" + Timer.shortInteger(Timer.getTime()));
                Bukkit.broadcastMessage(" ");

                for(Player all : Bukkit.getOnlinePlayers()) {
                    all.setGameMode(GameMode.SPECTATOR);
                }
            }
        }
    }
}
