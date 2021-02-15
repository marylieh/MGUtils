package de.asmax.butils.utils;

import de.asmax.butils.main.Main;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class TimerPaused {

    private static BukkitRunnable runnable;

    public static void pauseTimer() {
        runnable = new BukkitRunnable() {
            @Override
            public void run() {
                if(GameStateManager.timerIsPaused == false) {
                    if(GameStateManager.timerIsRunning == true) {

                    } else {
                        Bukkit.getOnlinePlayers().forEach(player -> {
                            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§6§oDer Timer ist pausiert."));
                        });
                    }
                } else {
                    Bukkit.getOnlinePlayers().forEach(player -> {
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§6§oDer Timer ist pausiert."));
                    });
                }
            }
        };
        runnable.runTaskTimer(Main.getInstance(), 0, 20);
    }

}
