package de.asmax.butils.utils;

import de.asmax.butils.main.Main;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class Timer {

    public static int time;
    private static BukkitRunnable runnable;

    public static void resume() {
        time = 0;
        runnable = new BukkitRunnable() {
            @Override
            public void run() {

                Bukkit.getOnlinePlayers().forEach(player -> {
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§6§l" + shortInteger(time)));
                });
                time++;

            }
        };
        runnable.runTaskTimer(Main.getInstance(), 0, 20);
    }

    public static String shortInteger(int duration) {

        String string = "";

        int hours = 0;
        int minutes = 0;
        int seconds = 0;


        if(duration / 60 / 60 >= 1) {
            hours = duration / 60 / 60;
            duration = duration - ((duration / 60 / 60) * 60 * 60);
        }

        if(duration / 60 >= 1) {
            minutes = duration / 60;
            duration = duration - ((duration / 60) * 60);
        }

        if(duration >= 1) {
            seconds = duration;
        }

        if(hours <= 9) {
            string = string + "0" + hours + ":";
        } else {
            string = string + hours + ":";
        }

        if(minutes <= 9) {
            string = string + "0" + minutes + ":";
        } else {
            string = string + minutes + ":";
        }

        if(seconds <= 9) {
            string = string + "0" + seconds;
        } else {
            string = string + seconds;
        }

        return string;

    }

    public static BukkitRunnable getRunnable() {
        return runnable;
    }

    public static void setTime(int time) {
        Timer.time = time;
    }

    public static int getTime() {
        return time;
    }
}
