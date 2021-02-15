package de.asmax.butils.commands;

import de.asmax.butils.utils.AntiLag;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InstantLag implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        for(Player all : Bukkit.getOnlinePlayers()) {
            all.kickPlayer("Das AntiLag System hat einen Schwerwiegenden Einbruch in der Server Leistung festgestellt. Der Server wird nun vom AntiLag System bereinigt. Bitte habe einen Moment Geduld.");
            AntiLag.instantLag();
        }
        return false;
    }
}
