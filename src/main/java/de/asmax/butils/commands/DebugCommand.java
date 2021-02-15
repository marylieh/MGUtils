package de.asmax.butils.commands;

import de.asmax.butils.main.Main;
import de.asmax.butils.utils.GameStateManager;
import de.asmax.butils.utils.Timer;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DebugCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage("Nur spieler können diesen Befehl verwenden.");
            return true;
        }
        Player player = (Player)sender;

        if(player.hasPermission("butils.debug")) {

            if(args.length != 0) {

                if(args[0].equalsIgnoreCase("time")) {
                    player.sendMessage(Main.getDebug() + "Aktueller Wert der Variable [Timer.getTime] : " + Timer.getTime());
                    return true;
                } else if(args[0].equalsIgnoreCase("settime")) {
                    int time = Integer.parseInt(args[1].trim());
                    Timer.setTime(time);
                    player.sendMessage(Main.getDebug() + "Aktueller Wert der Variable [Timer.getTime] auf : " + time + " gesetzt");
                    return true;
                } else if(args[0].equalsIgnoreCase("storetime")) {
                    int time = Timer.getTime();
                    GameStateManager.storedTime = time;
                    player.sendMessage(Main.getDebug() + "Aktueller Wert der Variable [Timer.getTime] wurde in die Variable [storedTime] geschrieben");
                    return true;
                } else if(args[0].equalsIgnoreCase("storedtime")) {
                    player.sendMessage(Main.getDebug() + "Aktueller Wert der Variable [storedTime] : " + GameStateManager.storedTime);
                    return true;
                } else if(args[0].equalsIgnoreCase("green")) {
                    if(GameStateManager.trafficLights) {
                        GameStateManager.green = true;
                        GameStateManager.yellow = false;
                        GameStateManager.red = false;
                        player.sendMessage(Main.getDebug() + "(TrafficLights) als nächstes folgt nun §aGrün");
                        return true;
                    } else {
                        return true;
                    }
                } else if(args[0].equalsIgnoreCase("yellow")) {
                    if(GameStateManager.trafficLights) {
                        GameStateManager.green = false;
                        GameStateManager.yellow = true;
                        GameStateManager.red = false;
                        player.sendMessage(Main.getDebug() + "(TrafficLights) als nächstes folgt nun §eGelb");
                    } else {
                        return true;
                    }
                } else if(args[0].equalsIgnoreCase("red")) {
                    if(GameStateManager.trafficLights) {
                        GameStateManager.green = false;
                        GameStateManager.yellow = false;
                        GameStateManager.red = true;
                        player.sendMessage(Main.getDebug() + "(TrafficLights) als nächstes folgt nun §cRot §e§l[WARNUNG] §r§eBOSSBAR WIRD §4§nNICHT AKTUALISIERT!");
                        return true;
                    }
                } else if(args[0].equalsIgnoreCase("health")) {
                    double health = Integer.parseInt(args[1]);
                    GameStateManager.maxHealth = health;
                    Bukkit.getOnlinePlayers().forEach(all -> {
                        all.setMaxHealth(health);
                    });
                    player.sendMessage(Main.getDebug() + "Aktueller Wert der Variable [GameStateManager.maxHealth] wurde auf : " + health + " gesetzt.");
                    player.sendMessage(Main.getDebug() + "Aktueller Wert der Bukkit API Variable [Bukkit.Player.MaxHealth] wurde auf : " + health + " gesetzt.");
                } else if(args[0].equalsIgnoreCase("hide")) {
                    player.sendMessage(Main.getDebug() + "Aktuelle Werte der ArrayList [GameStateManager.hiddenPlayers] : " + GameStateManager.hiddenPlayers);
                } else if(args[0].equalsIgnoreCase("online")) {
                    player.sendMessage(Main.getDebug() + "Aktuelle Werte der ArrayList [GameStateManager.onlinePlayers] : " + GameStateManager.onlinePlayers);
                } else if(args[0].equalsIgnoreCase("weak")) {
                    player.sendMessage(Main.getDebug() + "Aktueller Wert der Variable [GameStateManager.weakServer] : " + GameStateManager.weakServer);
                }

            } else {
                player.sendMessage(Main.getDebug() + "Bitte verwende eine der folgenden Optionen: /debug <time | settime | storetime | storedtime | green | yellow | red | health | hide | online | weak>");
            }

        }
        return false;
    }
}
