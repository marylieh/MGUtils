package de.asmax.butils.listener;

import de.asmax.butils.utils.GameStateManager;
import de.asmax.butils.utils.Timer;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerExpChangeEvent;

public class OnXP implements Listener {

    @EventHandler
    public void onXP(PlayerExpChangeEvent event) {
        if(GameStateManager.timerIsPaused == false) {
            if(GameStateManager.timerIsRunning == true) {
                Player player = (Player)event.getPlayer();
                if(GameStateManager.noXP == true) {
                    Bukkit.broadcastMessage(" ");
                    Bukkit.broadcastMessage("§8[§6No XP§8] §7Der Spieler §6§l" + player.getName() + " §r§7hat XP aufgesammelt.");
                    Bukkit.broadcastMessage("§8[§6No XP§8] §cDie Challenge ist hiermit beendet.");
                    Bukkit.broadcastMessage("§8[§6No XP§8] §7Zeit verschwendet: §9§l" + Timer.shortInteger(Timer.getTime()));
                    Bukkit.broadcastMessage(" ");

                    GameStateManager.timerIsRunning = false;
                    Timer.getRunnable().cancel();

                    for(Player all : Bukkit.getOnlinePlayers()) {
                        all.setGameMode(GameMode.SPECTATOR);
                    }
                }
            }
        }
    }
}
