package de.asmax.butils.commands;

import de.asmax.butils.main.Main;
import de.asmax.butils.utils.GameStateManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DeactivateAntiLagCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            return true;
        }
        Player player = (Player)sender;
        if(player.hasPermission("butils.debug.antilag")) {
            if(GameStateManager.antiLag) {
                GameStateManager.antiLag = false;
                player.sendMessage(Main.getDebug() + "§4§lACHTUNG: EINE KRITISCHE SYSTEM AKTION WURDE VORGENOMMEN. (AntiLag System deaktiviert [Der Entwickler empfiehlt diese Funktion eingeschaltet zu lassen.])");
            } else {
                GameStateManager.antiLag = true;
                player.sendMessage(Main.getDebug() + "§aDas AntiLag System ist nun aktiviert!");
            }
        }
        return false;
    }
}
