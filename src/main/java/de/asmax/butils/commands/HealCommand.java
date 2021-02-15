package de.asmax.butils.commands;

import de.asmax.butils.main.Main;
import de.asmax.butils.utils.GameStateManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(Main.getError() + "Nur spieler können diesen Befehl verwenden.");
            return true;
        }
        Player player = (Player)sender;

        if(player.hasPermission("butils.heal")) {
            if(args.length == 0) {
                player.setHealth(GameStateManager.maxHealth);
                player.sendMessage(Main.getPrefix() + "§7Du wurdest §9geheilt§7.");
            } else if(args.length == 1) {

                String name = args[0];
                Player target = Bukkit.getPlayer(name);
                target.setHealth(GameStateManager.maxHealth);
                player.sendMessage(Main.getPrefix() + "§7Der Spieler §9§l" + target.getName() + " §r§7wurde §9geheilt§7.");
            } else {
                player.sendMessage(Main.getError() + "Bitte verwende eine der folgenden Optionen: §c/heal [Spieler]");
            }
        }
        return false;
    }
}
