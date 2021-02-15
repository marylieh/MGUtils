package de.asmax.butils.commands;

import de.asmax.butils.gamechanger.TrafficLights;
import de.asmax.butils.main.Main;
import de.asmax.butils.utils.GameStateManager;
import de.asmax.butils.utils.Timer;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TimerCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player)sender;
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("resume")) {

                    for(Player all : Bukkit.getOnlinePlayers()) {
                        all.sendTitle("§7Timer §afortgesetzt", null, 7, 10, 7);
                        all.sendMessage("§8[§6Timer§8] §7§lDer Timer §a§lwurde fortgesetzt.");
                    }

                    if(GameStateManager.trafficLights) {
                        TrafficLights.handleTrafficLight();
                    }

                    if (GameStateManager.timerIsPaused) {

                        GameStateManager.timerIsPaused = false;
                        GameStateManager.timerIsRunning = true;

                        Timer.resume();
                        Timer.setTime(GameStateManager.storedTime);

                        player.sendMessage(Main.getPrefix() + "§fChallenge fortgesetzt.");

                    } else if (GameStateManager.timerIsRunning == false) {
                        GameStateManager.timerIsRunning = true;
                        player.sendMessage(Main.getPrefix() + "§fChallenge fortgesetzt.");
                        Timer.resume();
                    } else {
                        player.sendMessage(Main.getError() + "Der Timer läuft bereits.");
                    }
                } else if(args[0].equalsIgnoreCase("pause")) {

                    Bukkit.getOnlinePlayers().forEach(all -> {
                        all.sendTitle("§7Timer §cpausiert", null, 7, 10, 7);
                    });

                    if(GameStateManager.timerIsRunning == true) {
                        GameStateManager.storedTime = Timer.getTime();
                        GameStateManager.timerIsPaused = true;
                        GameStateManager.timerIsRunning = false;
                        Timer.getRunnable().cancel();

                        player.sendMessage(Main.getPrefix() + "§fDer Timer ist pausiert.");
                    } else {
                        player.sendMessage(Main.getError() + "Der Timer läuft nicht.");
                    }
                } else if(args[0].equalsIgnoreCase("reset")) {
                    GameStateManager.timerIsRunning = false;
                    GameStateManager.timerIsPaused = false;
                    Timer.setTime(0);
                    Timer.getRunnable().cancel();
                    player.sendMessage(Main.getPrefix() + "§fDer Timer wurde zurückgesetzt.");
                }
            } else {
                sender.sendMessage(Main.getError() + "Bitte verwende eine der folgenden Optionen: §c/timer <resume | pause | reset>");
            }
        }
        return false;
    }
}
