package de.asmax.butils.main;

import de.asmax.butils.commands.*;
import de.asmax.butils.gamechanger.AirBlock;
import de.asmax.butils.gamechanger.HealthHandler;
import de.asmax.butils.gamechanger.TrafficLights;
import de.asmax.butils.listener.*;
import de.asmax.butils.utils.AntiLag;
import de.asmax.butils.utils.Lag;
import de.asmax.butils.utils.TimerPaused;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Main instance;
    private Main plugin;
    private static String prefix = ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + "BUtils" + ChatColor.DARK_GRAY + "] ";
    private static String error = "§8§l[§4§lERROR§8§l] §8";
    private static String debug = "§e§l[DEBUG] §r§7";

    //TODO: English Translation missing

    @Override
    public void onEnable() {
        plugin = this;
        instance = this;

        System.out.println(getPrefix() + "§aDas Plugin wurde gestartet.");
        CommandRegistration();
        ListenerRegistration();

        TimerPaused.pauseTimer();

        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Lag(), 20L, 1L);
        AntiLag();
    }

    @Override
    public void onDisable() {
        System.out.println(getPrefix() + "§aDas Plugin wurde beendet.");
    }

    private void CommandRegistration() {
        getCommand("settings").setExecutor(new SettingsCommand());
        getCommand("timer").setExecutor(new TimerCommand());
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("feed").setExecutor(new FeedCommand());
        getCommand("reset").setExecutor(new ResetCommand());
        getCommand("position").setExecutor(new PositionCommand());
        getCommand("debug").setExecutor(new DebugCommand());
        getCommand("hide").setExecutor(new HideCommand());
        getCommand("gm").setExecutor(new GamemodeCommand());
        getCommand("lag").setExecutor(new InstantLag());
        getCommand("antilag").setExecutor(new DeactivateAntiLagCommand());
        getCommand("weak").setExecutor(new WeakCommand());
    }

    private void ListenerRegistration() {
        PluginManager pluginManager = Bukkit.getPluginManager();

        pluginManager.registerEvents(new JoinListener(), this);
        pluginManager.registerEvents(new SettingsCommand(), this);
        pluginManager.registerEvents(new HandleEntityDamage(), this);
        pluginManager.registerEvents(new HandleDamage(), this);
        pluginManager.registerEvents(new HandleOtherDamage(), this);
        pluginManager.registerEvents(new HandleLeave(), this);
        pluginManager.registerEvents(new BlockBreakEvent(), this);
        pluginManager.registerEvents(new HandleBlockSetEvent(), this);
        pluginManager.registerEvents(new EnderDragonKillEvent(), this);
        pluginManager.registerEvents(new WitherKillEvent(), this);
        pluginManager.registerEvents(new ElderGuardianKillEvent(), this);
        pluginManager.registerEvents(new PlayerDeath(), this);
        pluginManager.registerEvents(new OnXP(), this);
        pluginManager.registerEvents(new AchievmentListener(), this);
        pluginManager.registerEvents(new BlockBreak(), this);
        pluginManager.registerEvents(new TrafficLights(), this);
        pluginManager.registerEvents(new HealthHandler(), this);
        pluginManager.registerEvents(new ItemBreak(), this);
        pluginManager.registerEvents(new ZeroItemStack(), this);
        pluginManager.registerEvents(new AirBlock(), this);
    }

    public Main getPlugin() {
        return plugin;
    }

    public static Main getInstance() {
        return instance;
    }

    public static String getPrefix() {
        return prefix;
    }

    public static String getError() {
        return error;
    }

    public static String getDebug() {
        return debug;
    }

    private static void AntiLag() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(getInstance(), new Runnable() {
            @Override
            public void run() {

                AntiLag.antiLag();

            }
        }, 0L, 1L);
    }

}
