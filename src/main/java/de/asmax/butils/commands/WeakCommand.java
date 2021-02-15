package de.asmax.butils.commands;

import de.asmax.butils.main.Main;
import de.asmax.butils.utils.GameStateManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WeakCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(Main.getError() + "Dieser Befehl kann nur von einem Spieler ausgeführt werden.");
            return true;
        }
        Player player = (Player)sender;
        if(player.hasPermission("butils.weak")) {
            if(GameStateManager.weakServer) {
                GameStateManager.weakServer = false;
                player.sendMessage(Main.getPrefix() + "Der Modus für schwache Server ist nun §cdeaktiviert");
            } else {
                GameStateManager.weakServer = true;
                player.sendMessage(Main.getPrefix() + "Der Modus für schwache Server ist nun §aaktiviert");
            }
        }
        return false;
    }
}
