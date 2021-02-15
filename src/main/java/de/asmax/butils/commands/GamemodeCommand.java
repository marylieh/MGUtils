package de.asmax.butils.commands;

import de.asmax.butils.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(Main.getError() + "Nur spieler können diesen Befehl verwenden.");
            return true;
        }
        Player player = (Player)sender;

        if(player.hasPermission("butils.gamemode")) {

            if(args.length == 1) {

                if(args[0].equalsIgnoreCase("0")) {
                    player.sendMessage("§8[§6GameMode§8] §7Dein §9Spielmodus §7wurde zu §9Survival §7geändert.");
                    player.setGameMode(GameMode.SURVIVAL);
                    return true;
                } else if(args[0].equalsIgnoreCase("1")) {
                    player.sendMessage("§8[§6GameMode§8] §7Dein §9Spielmodus §7wurde zu §9Creative §7geändert.");
                    player.setGameMode(GameMode.CREATIVE);
                    return true;
                } else if(args[0].equalsIgnoreCase("2")) {
                    player.sendMessage("§8[§6GameMode§8] §7Dein §9Spielmodus §7wurde zu §9Adventure §7geändert.");
                    player.setGameMode(GameMode.ADVENTURE);
                    return true;
                } else if(args[0].equalsIgnoreCase("3")) {
                    player.sendMessage("§8[§6GameMode§8] §7Dein §9Spielmodus §7wurde zu §9Spectator §7geändert.");
                    player.setGameMode(GameMode.SPECTATOR);
                    return true;
                } else {
                    player.sendMessage(Main.getError() + "Bitte verwende eine der folgenden Optionen: /gm <0 | 1 | 2 | 3>");
                    return true;
                }

            } else {

                String name = args[1];
                Player target = Bukkit.getPlayer(name);

                if(args[0].equalsIgnoreCase("0")) {
                    target.sendMessage("§8[§6GameMode§8] §7Dein §9Spielmodus §7wurde zu §9Survival §7geändert.");
                    player.sendMessage("§8[§6GameMode§8] §7Der §9Spielmodus §7von §9" + target.getName() +  " §7wurde zu §9Survival §7geändert.");
                    target.setGameMode(GameMode.SURVIVAL);
                    return true;
                } else if(args[0].equalsIgnoreCase("1")) {
                    target.sendMessage("§8[§6GameMode§8] §7Dein §9Spielmodus §7wurde zu §9Creative §7geändert.");
                    player.sendMessage("§8[§6GameMode§8] §7Der §9Spielmodus §7von §9" + target.getName() +  " §7wurde zu §9Creative §7geändert.");
                    target.setGameMode(GameMode.CREATIVE);
                    return true;
                } else if(args[0].equalsIgnoreCase("2")) {
                    target.sendMessage("§8[§6GameMode§8] §7Dein §9Spielmodus §7wurde zu §9Adventure §7geändert.");
                    player.sendMessage("§8[§6GameMode§8] §7Der §9Spielmodus §7von §9" + target.getName() +  " §7wurde zu §9Adventure §7geändert.");
                    target.setGameMode(GameMode.ADVENTURE);
                    return true;
                } else if(args[0].equalsIgnoreCase("3")) {
                    target.sendMessage("§8[§6GameMode§8] §7Dein §9Spielmodus §7wurde zu §9Spectator §7geändert.");
                    player.sendMessage("§8[§6GameMode§8] §7Der §9Spielmodus §7von §9" + target.getName() +  " §7wurde zu §9Spectator §7geändert.");
                    target.setGameMode(GameMode.SPECTATOR);
                    return true;
                } else {
                    player.sendMessage(Main.getError() + "Bitte verwende eine der folgenden Optionen: /gm <0 | 1 | 2 | 3>");
                    return true;
                }

            }

        } else {
            return true;
        }
    }
}
