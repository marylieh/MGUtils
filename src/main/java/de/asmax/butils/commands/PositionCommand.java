package de.asmax.butils.commands;

import de.asmax.butils.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class PositionCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(Main.getError() + "Nur spieler können diesen Befehl verwenden.");
            return true;
        }
        Player player = (Player)sender;

        if(player.hasPermission("butils.position")) {

            File file = new File("plugins/butils", "positionen.yml");
            FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

            if(args.length == 1) {
                if(args[0].equalsIgnoreCase("list")) {
                    player.sendMessage("§8[§6Position§8] §7Verfügbare §9Positionen: §b" + cfg.getConfigurationSection(".Positionen").getKeys(false));
                } else {

                    String id = args[0];

                    if(cfg.getString(".Positionen." + id) != null) {

                        String world = cfg.getString(".Positionen" + "." + id + ".World");

                        int x = cfg.getInt(".Positionen" + "." + id + ".X");
                        int y = cfg.getInt(".Positionen" + "." + id + ".Y");
                        int z = cfg.getInt(".Positionen" + "." + id + ".Z");

                        player.sendMessage("§8[§6Position§8] §9" + id + " §8[§6" + x + "§8, §6" + y + "§8, §6" + z + "§8, §6" + world + "§8]");
                        return true;
                    }

                    String world = player.getWorld().getName();

                    int x = player.getLocation().getBlockX();
                    int y = player.getLocation().getBlockY();
                    int z = player.getLocation().getBlockZ();

                    cfg.set(".Positionen" + "." + id + ".World", world);
                    cfg.set(".Positionen" + "." + id + ".X", x);
                    cfg.set(".Positionen" + "." + id + ".Y", y);
                    cfg.set(".Positionen" + "." + id + ".Z", z);

                    player.sendMessage("§8[§6Position§8] §a" + id + " §7von §a" + player.getName() + " §8[§6" + x + "§8, §6" + y + " §8,§6 " + z + " §8,§6 " + world + "§8]");

                    try {
                        cfg.save(file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            } else {
                player.sendMessage(Main.getError() + "Bitte verwende eine der folgenden Optionen: §c/position <list | position");
            }

        } else {
            player.sendMessage(Main.getError() + "Dazu hat du keine Rechte.");
        }
        return false;
    }
}
