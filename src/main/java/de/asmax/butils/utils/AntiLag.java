package de.asmax.butils.utils;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;

public class AntiLag {

    public static void antiLag() {
        if(GameStateManager.antiLag) {
            double TPS = Lag.getTPS();
            if(TPS < 18.00) {
                for(Player all : Bukkit.getOnlinePlayers()) {
                    all.kickPlayer("§cDas AntiLag System hat einen Schwerwiegenden Einbruch in der Server Leistung festgestellt. Der Server wird nun vom AntiLag System bereinigt. Bitte habe einen Moment Geduld.");
                }
                System.out.println("§c§lLAG!");
                for (World w : Bukkit.getWorlds()) {
                    for (Entity e : w.getEntities()) {
                        if (e instanceof Item) {
                            e.remove();
                            System.out.println("§f§lLAG REMOVED!");
                        }
                    }
                }

            }
        }
    }

    public static void instantLag() {
        if(GameStateManager.antiLag) {
            for (World w : Bukkit.getWorlds()) {
                for (Entity e : w.getEntities()) {
                    if (e instanceof Item) {
                        e.remove();
                        System.out.println("§f§lLAG REMOVED! by InstantLag");
                    }
                }
            }
        }
    }
}
