package de.asmax.butils.listener;

import de.asmax.butils.utils.GameStateManager;
import de.asmax.butils.utils.Timer;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class ZeroItemStack implements Listener {

    @EventHandler
    public void handlePlace(BlockPlaceEvent event) {
        if(GameStateManager.zeroKiller) {
            if(event.getItemInHand().getAmount() > 1) {
                return;
            }
            Bukkit.getOnlinePlayers().forEach(all -> {
                all.setGameMode(GameMode.SPECTATOR);
            });

            Bukkit.broadcastMessage(" ");
            Bukkit.broadcastMessage("§8[§6ZeroKiller§8] §7Der Spieler §6§l" + event.getPlayer().getName() + " §r§7hat den §9letzten Block §7von §9" + event.getItemInHand().getType() + "§7 platziert.");
            Bukkit.broadcastMessage("§8[§6ZeroKiller§8] §cDie Challenge ist hiermit beendet.");
            Bukkit.broadcastMessage("§8[§6ZeroKiller§8] §7Zeit verschwendet: §9§l" + Timer.shortInteger(Timer.getTime()));
            Bukkit.broadcastMessage(" ");

            GameStateManager.timerIsRunning = false;
            Timer.getRunnable().cancel();
        }
    }

}
