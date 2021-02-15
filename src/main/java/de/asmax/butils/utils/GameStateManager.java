package de.asmax.butils.utils;

import org.bukkit.Bukkit;

import java.util.ArrayList;

public class GameStateManager {

    public static boolean onDamageClear = false;

    public static boolean noXP = false;

    public static boolean noAdchievment = false;

    public static boolean eRandomizer = false;

    public static boolean trafficLights = false;

    public static boolean zeroKiller = false;

    public static boolean AirBlock = false;

    public static double maxHealth = 20;

    public static boolean green;

    public static boolean yellow;

    public static boolean red;

    public static boolean killEnderdragon = true;

    public static boolean killWither = false;

    public static boolean killElderGuardian = false;

    public static boolean timerIsRunning = false;

    public static boolean timerIsPaused = false;

    public static int storedTime;

    public static boolean printDmg = true;

    public static boolean dmgTab = false;

    public static boolean raids;

    public static boolean doDailightCycle;

    public static boolean mobDrops;

    public static boolean doFireTick;

    public static boolean doInsomnia;

    public static boolean mobSpawning;

    public static boolean spawnPatrollie;

    public static boolean wanderingTrader;

    public static boolean doWeatherCycle;

    public static boolean drowning;

    public static boolean fallDamage;

    public static boolean fireDamage;

    public static boolean keepInventory;

    public static boolean naturalRegeneration;

    public static boolean antiLag = true;

    public static boolean weakServer = false;

    public static ArrayList<String> hiddenPlayers = new ArrayList<String>();

    public static ArrayList<String> onlinePlayers = new ArrayList<String>();

}
