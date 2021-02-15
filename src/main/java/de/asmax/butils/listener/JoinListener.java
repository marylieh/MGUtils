package de.asmax.butils.listener;

import de.asmax.butils.gamechanger.TrafficLights;
import de.asmax.butils.utils.GameStateManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static de.asmax.butils.gamechanger.TrafficLights.yellow;

public class JoinListener implements Listener {

    @EventHandler
    public void handleJoin(PlayerJoinEvent event) {
        Player player = (Player)event.getPlayer();

        GameStateManager.onlinePlayers.add(player.getName());

        if(GameStateManager.timerIsPaused == false) {
            if(GameStateManager.timerIsRunning == false) {
                player.sendMessage("§8[§6Timer§8] §9INFORMATION§8: §7Der Timer läuft nicht. Verwende §9/timer resume");
                event.setJoinMessage("§a>> §7" + player.getName());
            }
        } else {
            player.sendMessage("§8[§6Timer§8] §9INFORMATION§8: §7Der Timer läuft nicht. Verwende §9/timer resume");
            event.setJoinMessage("§a>> §7" + player.getName());
        }

        if(GameStateManager.hiddenPlayers.contains(player.getUniqueId().toString())) {
            Bukkit.getOnlinePlayers().forEach(all -> {
                all.hidePlayer(player);
            });
            player.sendMessage("§8[§6Hide§8] §7§oDu hast den Server §9unsichtbar §7betreten.");
        }

        if(GameStateManager.trafficLights) {
            if(GameStateManager.green) {
                Bukkit.getOnlinePlayers().forEach(all -> {
                    TrafficLights.green.addPlayer(all);
                    TrafficLights.green.setVisible(true);
                    yellow.removePlayer(all);
                    yellow.setVisible(false);
                    TrafficLights.red.removePlayer(all);
                    TrafficLights.red.setVisible(false);
                });
            } else if(GameStateManager.yellow) {
                Bukkit.getOnlinePlayers().forEach(all -> {
                    TrafficLights.green.removePlayer(all);
                    TrafficLights.green.setVisible(false);
                    yellow.addPlayer(all);
                    yellow.setVisible(true);
                    TrafficLights.red.removePlayer(all);
                    TrafficLights.red.setVisible(false);
                });
            } else {
                Bukkit.getOnlinePlayers().forEach(all -> {
                    TrafficLights.green.removePlayer(all);
                    TrafficLights.green.setVisible(false);
                    yellow.removePlayer(all);
                    yellow.setVisible(false);
                    TrafficLights.red.addPlayer(all);
                    TrafficLights.red.setVisible(true);
                });
            }
        }
        event.setJoinMessage("§a>> §7" + player.getName());
    }
}
