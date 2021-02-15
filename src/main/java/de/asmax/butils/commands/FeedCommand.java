package de.asmax.butils.commands;

import de.asmax.butils.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(Main.getError() + "Nur spieler können diesen Befehl verwenden.");
            return true;
        }
        Player player = (Player)sender;

        if(player.hasPermission("butils.feed")) {
            if(args.length == 0) {
                player.setFoodLevel(20);
                player.sendMessage(Main.getPrefix() + "§7Du wurdest §9gesättigt§7.");
            } else if(args.length == 1) {

                String name = args[0];
                Player target = Bukkit.getPlayer(name);
                target.setFoodLevel(20);
                player.sendMessage(Main.getPrefix() + "§7Der Spieler §9§l" + target.getName() + " §r§7wurde §9gesättigt§7.");
            } else {
                player.sendMessage(Main.getError() + "Bitte verwende eine der folgenden Optionen: §c/feed [Spieler]");
            }
        }
        return false;
    }
}
