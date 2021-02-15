package de.asmax.butils.commands;

import de.asmax.butils.main.Main;
import de.asmax.butils.utils.GameStateManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HideCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(Main.getError() + "Nur spieler können diesen Befehl verwenden.");
            return true;
        }
        Player player = (Player)sender;

        if(player.hasPermission("butils.hide")) {
            if(args.length == 0) {

                if(GameStateManager.hiddenPlayers.contains(player.getUniqueId().toString())) {
                    GameStateManager.hiddenPlayers.remove(player.getUniqueId().toString());
                    player.sendMessage("§8[§6Hide§8] §7§oDu bist nun nicht mehr §9unsichtbar§7.");
                    Bukkit.getOnlinePlayers().forEach(all -> {
                        all.showPlayer(player);
                    });
                } else {
                    GameStateManager.hiddenPlayers.add(player.getUniqueId().toString());
                    player.sendMessage("§8[§6Hide§8] §7§oDu bist nun §9unsichtbar§7.");
                    Bukkit.getOnlinePlayers().forEach(all -> {
                        all.hidePlayer(player);
                    });
                }

            } else {
                player.sendMessage(Main.getError() + "Bitte verwende eine der folgenden Optionen: §c/hide");
            }
        }
        return false;
    }
}
