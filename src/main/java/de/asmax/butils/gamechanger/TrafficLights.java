package de.asmax.butils.gamechanger;

import de.asmax.butils.main.Main;
import de.asmax.butils.utils.GameStateManager;
import de.asmax.butils.utils.Timer;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class TrafficLights implements Listener {

    public static BossBar green = Bukkit.createBossBar("§8[ §2■■■■■ §8] §8[ §7■■■■■§8 ] §8[ §7■■■■■ §8]", BarColor.GREEN, BarStyle.SOLID);
    public static BossBar yellow = Bukkit.createBossBar("§8[ §7■■■■■ §8] §8[ §e■■■■■§8 ] §8[ §7■■■■■ §8]", BarColor.YELLOW, BarStyle.SOLID);
    public static BossBar red = Bukkit.createBossBar("§8[ §7■■■■■ §8] §8[ §7■■■■■§8 ] §8[ §c■■■■■ §8]", BarColor.RED, BarStyle.SOLID);

    public static void handleTrafficLight() {

                if(GameStateManager.trafficLights) {

                    if(GameStateManager.green) {
                        handleGreen();
                    }
                }
    }

    private static void handleGreen() {
        GameStateManager.red = false;
        GameStateManager.yellow = false;
        GameStateManager.green = true;
        Bukkit.getOnlinePlayers().forEach(all -> {
            green.addPlayer(all);
            green.setVisible(true);
            yellow.removePlayer(all);
            yellow.setVisible(false);
            red.removePlayer(all);
            red.setVisible(false);
        });

        Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
            @Override
            public void run() {

                handleYellow();

            }
        }, 1200);

    }

    private static void handleYellow() {
        GameStateManager.red = false;
        GameStateManager.yellow = true;
        GameStateManager.green = false;
        Bukkit.getOnlinePlayers().forEach(all -> {
            green.removePlayer(all);
            green.setVisible(false);
            yellow.addPlayer(all);
            yellow.setVisible(true);
            red.removePlayer(all);
            red.setVisible(false);
        });

        Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
            @Override
            public void run() {

                handleRed();

            }
        }, 300);

    }

    private static void handleRed() {

        GameStateManager.red = true;
        GameStateManager.yellow = false;
        GameStateManager.green = false;
        Bukkit.getOnlinePlayers().forEach(all -> {
            green.removePlayer(all);
            green.setVisible(false);
            yellow.removePlayer(all);
            yellow.setVisible(false);
            red.addPlayer(all);
            red.setVisible(true);
        });

        Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
            @Override
            public void run() {

                handleGreen();

            }
        }, 240);

    }

    @EventHandler
    public void onWalk(PlayerMoveEvent event) {
        Player player = (Player) event.getPlayer();

        if(GameStateManager.red) {

            if(event.getTo().getX() == event.getFrom().getX() && event.getTo().getY() == event.getFrom().getY() && event.getTo().getZ() == event.getFrom().getZ()) {
                return;
            } else {
                Bukkit.broadcastMessage("");
                Bukkit.broadcastMessage("§8[§6TrafficLights§8] §7Der Spieler §6§l" + player.getName() + " §r§7hat sich bei §cRot §7bewegt.");
                Bukkit.broadcastMessage("§8[§6TrafficLights§8] §cDie Challenge ist hiermit beendet.");
                Bukkit.broadcastMessage("§8[§6TrafficLights§8] §7Zeit verschwendet: §9§l" + Timer.shortInteger(Timer.getTime()));
                Bukkit.broadcastMessage("");
                GameStateManager.red = false;
                GameStateManager.timerIsRunning = false;
                Timer.getRunnable().cancel();
                Bukkit.getOnlinePlayers().forEach(all -> {
                    all.setGameMode(GameMode.SPECTATOR);
                });
            }

        } else {
            return;
        }
    }
}
