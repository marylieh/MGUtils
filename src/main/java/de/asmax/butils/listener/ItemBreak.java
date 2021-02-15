package de.asmax.butils.listener;

import de.asmax.butils.utils.GameStateManager;
import de.asmax.butils.utils.Timer;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemBreakEvent;

public class ItemBreak implements Listener {

    @EventHandler
    public void handleItemBreak(PlayerItemBreakEvent event) {
        if(!GameStateManager.timerIsPaused) {
            if(GameStateManager.timerIsRunning) {
                if(GameStateManager.zeroKiller) {

                    Bukkit.getOnlinePlayers().forEach(all -> {
                        all.setGameMode(GameMode.SPECTATOR);
                    });

                    String itemName = event.getBrokenItem().getType().toString();

                    Bukkit.broadcastMessage(" ");
                    Bukkit.broadcastMessage("§8[§6ZeroKiller§8] §7Der Spieler §6§l" + event.getPlayer().getName() + " §r§7hat das §9Item §9" + itemName + " §r§7zerstört.");
                    Bukkit.broadcastMessage("§8[§6ZeroKiller§8] §cDie Challenge ist hiermit beendet.");
                    Bukkit.broadcastMessage("§8[§6ZeroKiller§8] §7Zeit verschwendet: §9§l" + Timer.shortInteger(Timer.getTime()));
                    Bukkit.broadcastMessage(" ");

                    GameStateManager.timerIsRunning = false;
                    Timer.getRunnable().cancel();

                }
            }
        }
    }
}
