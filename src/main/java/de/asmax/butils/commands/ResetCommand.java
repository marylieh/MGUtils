package de.asmax.butils.commands;

import de.asmax.butils.main.Main;
import de.asmax.butils.utils.GameStateManager;
import de.asmax.butils.utils.Timer;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class ResetCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(Main.getError() + "Nur spieler können diesen Befehl verwenden.");
            return true;
        }
        Player player = (Player)sender;

        if(player.hasPermission("butils.reset")) {
            if(args[0].equalsIgnoreCase("confirm")) {

                GameStateManager.noXP = false;
                GameStateManager.onDamageClear = false;

                for(Player all : Bukkit.getOnlinePlayers()) {
                    all.getInventory().clear();
                    all.kickPlayer("§7Der Reset wurde von §9§l" + player.getName() + " §r§7ausgeführt. Du wirst den Server in §9§oeiner Minute §r§7wieder betreten können!");
                }

                File file = new File("plugins/butils", "positionen.yml");
                FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
                file.delete();

                World delete = Bukkit.getWorld("world");
                World deleteN = Bukkit.getWorld("world_nether");
                World deleteE = Bukkit.getWorld("world_the_end");
                File deleteFolderN = deleteN.getWorldFolder();
                File deleteFolderE = deleteE.getWorldFolder();
                File deleteFolder = delete.getWorldFolder();
                deleteWorld(deleteFolderN);
                deleteWorld(deleteFolderE);
                deleteWorld(deleteFolder);

                Bukkit.getServer().shutdown();

            } else {
                player.sendMessage(Main.getError() + "Bitte verwende: §c/reset confirm");
            }
        }
        return false;
    }

    public static boolean deleteWorld(File path) {
        if(path.exists()) {
            File files[] = path.listFiles();
            for(int i=0; i<files.length; i++) {
                if(files[i].isDirectory()) {
                    deleteWorld(files[i]);
                } else {
                    files[i].delete();
                }
            }
        }
        return(path.delete());
    }
}
