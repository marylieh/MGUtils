package de.asmax.butils.commands;

import de.asmax.butils.functions.TabHealth;
import de.asmax.butils.gamechanger.HealthHandler;
import de.asmax.butils.listener.specialhandler.InventoryHandler;
import de.asmax.butils.main.Main;
import de.asmax.butils.utils.GameStateManager;
import de.asmax.butils.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.GameRule;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class SettingsCommand implements CommandExecutor, Listener {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)) {
            sender.sendMessage(Main.getError() + "Nur spieler können diesen Befehl verwenden.");
            return  true;
        }
        Player player = (Player)sender;

        if(player.hasPermission("butils.settings")) {
            Inventory inv = Bukkit.createInventory(null, 27, "§6Einstellungen §8● §9Übersicht");
            inv.setItem(0, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
            inv.setItem(1, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
            inv.setItem(2, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
            inv.setItem(3, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
            inv.setItem(4, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
            inv.setItem(5, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
            inv.setItem(6, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
            inv.setItem(7, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
            inv.setItem(8, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());

            inv.setItem(9, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
            inv.setItem(10, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());

            inv.setItem(11, new ItemBuilder(Material.DRAGON_HEAD).setName("§cBedingungen").setLore(" ", " §7Lege die §cBedingung", " §7für den §cSieg §7einer", " §cChallenge §7fest", " ", " §c§oKlick§7§o: §r§cÜbersicht").build());
            inv.setItem(12, new ItemBuilder(Material.GRASS_BLOCK).setName("§bSpieländerung").setLore(" ", " §7Spieländerungen §bverändern", " §7das §bSpielgeschehen §7auf", " §7vielen Art und Weisen.", " ", " §b§oKlick §r§bÜbersicht").build());

            inv.setItem(13, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());

            inv.setItem(14, new ItemBuilder(Material.IRON_PICKAXE).setName("§6Funktion").setLore(" ", "§6Funktionen §7sind Modifikationen,", "§7welche §6kosmetisch §7und §6funktionell", "§7sind und das Spielgeschehen", "§6nicht beeinflussen§7.", " ", "§6§oKlick §r§6Übersicht").build());
            inv.setItem(15, new ItemBuilder(Material.MAP).setName("§aSpielregel").setLore("", "§aSpielregeln §7sind die normale", "§a/gamerule§7s und weitere", "§aVeränderungen §7des Spielgeschehens", "§7mit normalen Mitteln von Minecraft.", " ", "§a§oKlick §r§aÜbersicht").build());

            inv.setItem(16, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
            inv.setItem(17, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
            inv.setItem(18, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
            inv.setItem(19, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
            inv.setItem(20, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
            inv.setItem(21, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
            inv.setItem(22, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
            inv.setItem(23, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
            inv.setItem(24, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
            inv.setItem(25, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
            inv.setItem(26, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());

            player.openInventory(inv);
        }
        return false;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if(!(event.getWhoClicked() instanceof Player)) return;
        Player player = (Player) event.getWhoClicked();
        if(event.getView().getTitle().equals("§6Einstellungen §8● §9Übersicht")) {

            switch(event.getCurrentItem().getType()) {
                case DRAGON_HEAD:
                    if(GameStateManager.killEnderdragon) {
                        Inventory b = Bukkit.createInventory(null, 9, "§6Einstellungen §8● §cBedingungen");
                        b.setItem(0, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        b.setItem(1, new ItemBuilder(Material.DRAGON_EGG).setName("§cEnderdrache").setLore(" §cTöte §7den §cEnderdrachen", " §7um die aktuelle", " §cChallenge §7zu §cbeenden", " ", " §9§nStatus:", " §aaktiviert").build());
                        b.setItem(2, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        b.setItem(3, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        b.setItem(4, new ItemBuilder(Material.WITHER_SKELETON_SKULL).setName("§cWither").setLore(" §cTöte §7den §cWither", " §7um die aktuelle", " §cChallenge §7zu beenden", " ", " §9§nStatus:", " §4deaktiviert").build());
                        b.setItem(5, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        b.setItem(6, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        b.setItem(7, new ItemBuilder(Material.PRISMARINE_SHARD).setName("§cGroßer Tempelwächter").setLore(" §cTöte §7den §cWither", " §7um die aktuelle", " §cChallenge §7zu beenden", " ", " §9§nStatus:", " §4deaktiviert").build());
                        b.setItem(8, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        player.openInventory(b);
                        event.setCancelled(true);
                    } else if(GameStateManager.killWither) {
                        Inventory b = Bukkit.createInventory(null, 9, "§6Einstellungen §8● §cBedingungen");
                        b.setItem(0, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        b.setItem(1, new ItemBuilder(Material.DRAGON_EGG).setName("§cEnderdrache").setLore(" §cTöte §7den §cEnderdrachen", " §7um die aktuelle", " §cChallenge §7zu §cbeenden", " ", " §9§nStatus:", " §4deaktiviert").build());
                        b.setItem(2, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        b.setItem(3, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        b.setItem(4, new ItemBuilder(Material.WITHER_SKELETON_SKULL).setName("§cWither").setLore(" §cTöte §7den §cWither", " §7um die aktuelle", " §cChallenge §7zu beenden", " ", " §9§nStatus:", " §aaktiviert").build());
                        b.setItem(5, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        b.setItem(6, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        b.setItem(7, new ItemBuilder(Material.PRISMARINE_SHARD).setName("§cGroßer Tempelwächter").setLore(" §cTöte §7den §cWither", " §7um die aktuelle", " §cChallenge §7zu beenden", " ", " §9§nStatus:", " §4deaktiviert").build());
                        b.setItem(8, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        player.openInventory(b);
                        event.setCancelled(true);
                    } else if(GameStateManager.killElderGuardian) {
                        Inventory b = Bukkit.createInventory(null, 9, "§6Einstellungen §8● §cBedingungen");
                        b.setItem(0, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        b.setItem(1, new ItemBuilder(Material.DRAGON_EGG).setName("§cEnderdrache").setLore(" §cTöte §7den §cEnderdrachen", " §7um die aktuelle", " §cChallenge §7zu §cbeenden", " ", " §9§nStatus:", " §4deaktiviert").build());
                        b.setItem(2, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        b.setItem(3, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        b.setItem(4, new ItemBuilder(Material.WITHER_SKELETON_SKULL).setName("§cWither").setLore(" §cTöte §7den §cWither", " §7um die aktuelle", " §cChallenge §7zu beenden", " ", " §9§nStatus:", " §4deaktiviert").build());
                        b.setItem(5, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        b.setItem(6, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        b.setItem(7, new ItemBuilder(Material.PRISMARINE_SHARD).setName("§cGroßer Tempelwächter").setLore(" §cTöte §7den §cWither", " §7um die aktuelle", " §cChallenge §7zu beenden", " ", " §9§nStatus:", " §aaktiviert").build());
                        b.setItem(8, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        player.openInventory(b);
                        event.setCancelled(true);
                    } else {
                        player.sendMessage(Main.getError() + "Ein interner Fehler ist aufgetreten, bitte §cstarte den Server neu§7.");
                    }

                    break;
                case GRAY_STAINED_GLASS_PANE:
                    event.setCancelled(true);
                    break;
                case GRASS_BLOCK:

                    Inventory cal = Bukkit.createInventory(null, 36, "§6Einstellungen §8● §bSpieländerungen");
                        cal.setItem(0, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        cal.setItem(1, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        cal.setItem(2, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        cal.setItem(3, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        cal.setItem(4, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        cal.setItem(5, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        cal.setItem(6, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        cal.setItem(7, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        cal.setItem(8, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        cal.setItem(9, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        if(GameStateManager.onDamageClear == true) {
                            cal.setItem(10, new ItemBuilder(Material.STONE_SWORD).setName("§cDamageClear").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion leert das", " §9Inventar §7aller §9Spieler", " §7wenn ein §9Spieler Schaden §7erleidet.", " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §2aktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                        } else {
                            cal.setItem(10, new ItemBuilder(Material.STONE_SWORD).setName("§cDamageClear").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion leert das", " §9Inventar §7aller §9Spieler", " §7wenn ein §9Spieler Schaden §7erleidet.", " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §4deaktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                        }

                        if(GameStateManager.noXP == true) {
                            cal.setItem(11, new ItemBuilder(Material.EXPERIENCE_BOTTLE).setName("§cNo XP").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion beendet die Challenge", " §7sobald ein Spieler ", " §9Experience §7erhält.", " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §2aktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                        } else {
                            cal.setItem(11, new ItemBuilder(Material.EXPERIENCE_BOTTLE).setName("§cNo XP").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion beendet die Challenge", " §7sobald ein Spieler ", " §9Experience §7erhält.", " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §4deaktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                        }
                        if(GameStateManager.noAdchievment == true) {
                            cal.setItem(12, new ItemBuilder(Material.APPLE).setName("§cNo Achievments").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion zieht jedesmal wenn", " §7ein Spieler ein §9Achievment §7erhält", " §9ein halbes Herz ab§7.",  " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §2aktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                        } else {
                            cal.setItem(12, new ItemBuilder(Material.APPLE).setName("§cNo Achievments").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion zieht jedesmal wenn", " §7ein Spieler ein §9Achievment §7erhält", " §9ein halbes Herz ab§7.",  " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §4deaktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                        }
                        if(GameStateManager.eRandomizer) {
                            cal.setItem(13, new ItemBuilder(Material.DIAMOND_PICKAXE).setName("§cExtreme Randomizer").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion droppt jedesmal", " §7wenn ein Spieler ein Block abbaut", " §7ein §9zufälliges Item§7.",  " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §2aktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                        } else {
                            cal.setItem(13, new ItemBuilder(Material.DIAMOND_PICKAXE).setName("§cExtreme Randomizer").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion droppt jedesmal", " §7wenn ein Spieler ein Block abbaut", " §7ein §9zufälliges Item§7.",  " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §4deaktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                        }
                        if(GameStateManager.trafficLights) {
                            cal.setItem(14, new ItemBuilder(Material.GREEN_CONCRETE).setName("§cAmpel Rennen").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion schaltet alle 5", " §7Minuten die Ampel", " §7je nach dem muss man §9stehen bleiben§7.",  " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §2aktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                        } else {
                            cal.setItem(14, new ItemBuilder(Material.GREEN_CONCRETE).setName("§cAmpel Rennen").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion schaltet alle 5", " §7Minuten die Ampel", " §7je nach dem muss man §9stehen bleiben§7.",  " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §4deaktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                        }
                        cal.setItem(15, new ItemBuilder(Material.GOLDEN_APPLE).setName("§cMax. Herzen").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion konfiguriert", " §7die Maximale", " §7Anzahl der §9Herzen§7, der §9Spieler§7.",  " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §b" + GameStateManager.maxHealth, " ", "§b§oLinksklick §9Einstellungen").build());
                        if(GameStateManager.zeroKiller) {
                            cal.setItem(16, new ItemBuilder(Material.WOODEN_SHOVEL).setName("§cZero Killer").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion §9tötet alle Spieler", " §7welche einen §9ItemStack aufbrauchen", " §7oder ein Item §9kaputt machen§7.",  " ", "§9§nEigenschaften§r§7:", " §7Typ§8: §bSpieländerung", " §7Status§8: §2aktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                        } else {
                            cal.setItem(16, new ItemBuilder(Material.WOODEN_SHOVEL).setName("§cZero Killer").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion §9tötet alle Spieler", " §7welche einen §9ItemStack aufbrauchen", " §7oder ein Item §9kaputt machen§7.",  " ", "§9§nEigenschaften§r§7:", " §7Typ§8: §bSpieländerung", " §7Status§8: §4deaktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                        }

                        cal.setItem(17, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        cal.setItem(18, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());

                        if(GameStateManager.AirBlock) {
                            cal.setItem(19, new ItemBuilder(Material.STONE).setName("§cAirBlock").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion §9löscht alle Blöcke", " §7welche in einem §9Chunk gesetzt", " §7oder §9abgebaut werden§7.",  " ", "§9§nEigenschaften§r§7:", " §7Typ§8: §bSpieländerung", " §7Status§8: §2aktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                        } else {
                            cal.setItem(19, new ItemBuilder(Material.STONE).setName("§cAirBlock").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion §9löscht alle Blöcke", " §7welche in einem §9Chunk gesetzt", " §7oder §9abgebaut werden§7.",  " ", "§9§nEigenschaften§r§7:", " §7Typ§8: §bSpieländerung", " §7Status§8: §4deaktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                        }
                        cal.setItem(20, new ItemBuilder(Material.BARRIER).setName("§4§lNicht verfügbar").build());
                        cal.setItem(21, new ItemBuilder(Material.BARRIER).setName("§4§lNicht verfügbar").build());
                        cal.setItem(22, new ItemBuilder(Material.BARRIER).setName("§4§lNicht verfügbar").build());
                        cal.setItem(23, new ItemBuilder(Material.BARRIER).setName("§4§lNicht verfügbar").build());
                        cal.setItem(24, new ItemBuilder(Material.BARRIER).setName("§4§lNicht verfügbar").build());
                        cal.setItem(25, new ItemBuilder(Material.BARRIER).setName("§4§lNicht verfügbar").build());
                        cal.setItem(26, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        cal.setItem(27, new ItemBuilder(Material.PLAYER_HEAD).setName("§8● §a1. Seite §2<<").setLore("§7§oKlicke, um die Seite zu wechseln").build());
                        cal.setItem(28, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        cal.setItem(29, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        cal.setItem(30, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        cal.setItem(31, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        cal.setItem(32, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        cal.setItem(33, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        cal.setItem(34, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        cal.setItem(35, new ItemBuilder(Material.PLAYER_HEAD).setName("§8● §a2. Seite §2>>").setLore("§7§oKlicke, um die Seite zu wechseln").build());
                        player.openInventory(cal);
                        event.setCancelled(true);
                        break;
                case IRON_PICKAXE:
                    Inventory f = Bukkit.createInventory(null, 36, "§6Einstellungen §8● §6Funktionen");
                    f.setItem(0, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(1, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(2, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(3, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(4, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(5, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(6, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(7, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(8, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(9, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    if(GameStateManager.printDmg) {
                        f.setItem(10, new ItemBuilder(Material.IRON_SWORD).setName("§6Schaden in den Chat").setLore(" ", "§6§nBeschreibung§r§7:", " §7Diese Funktion schreibt den", " §6Schaden §7in den §6Chat§7.", " ", "§6§nEigenschaften§r§7:", "§7 Typ§8: §6Funktion", " §7Status§8: §2aktiviert", " ", "§6§oLinksklick §r§7Status ändern", "§6§oRechtsklick §r§7Einstellungen", " ").build());
                    } else {
                        f.setItem(10, new ItemBuilder(Material.IRON_SWORD).setName("§6Schaden in den Chat").setLore(" ", "§6§nBeschreibung§r§7:", " §7Diese Funktion schreibt den", " §6Schaden §7in den §6Chat§7.", " ", "§6§nEigenschaften§r§7:", "§7 Typ§8: §6Funktion", " §7Status§8: §4deaktiviert", " ", "§6§oLinksklick §r§7Status ändern", "§6§oRechtsklick §r§7Einstellungen", " ").build());
                    }
                    if(GameStateManager.dmgTab) {
                        f.setItem(11, new ItemBuilder(Material.APPLE).setName("§6Spieler Gesundheit in der Tablist").setLore(" ", "§6§nBeschreibung§r§7:", " §7Diese Funktion zeigt die", " §6Gesundheit der Spieler §7in der §6Tablist§7.", " ", "§6§nEigenschaften§r§7:", "§7 Typ§8: §6Funktion", " §7Status§8: §2aktiviert", " ", "§6§oLinksklick §r§7Status ändern", "§6§oRechtsklick §r§7Einstellungen", " ").build());
                    } else {
                        f.setItem(11, new ItemBuilder(Material.APPLE).setName("§6Spieler Gesundheit in der Tablist").setLore(" ", "§6§nBeschreibung§r§7:", " §7Diese Funktion zeigt die", " §6Gesundheit der Spieler §7in der §6Tablist§7.", " ", "§6§nEigenschaften§r§7:", "§7 Typ§8: §6Funktion", " §7Status§8: §4deaktiviert", " ", "§6§oLinksklick §r§7Status ändern", "§6§oRechtsklick §r§7Einstellungen", " ").build());
                    }
                    f.setItem(12, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(13, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(14, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(15, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(16, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(17, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(18, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(19, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(20, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(21, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(22, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(23, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(24, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(25, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(26, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(27, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(28, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(29, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(30, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(31, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(32, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(33, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(34, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(35, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    player.openInventory(f);
                    event.setCancelled(true);
                    break;
                case MAP:
                    Inventory gm = Bukkit.createInventory(null, 36, "§6Einstellungen §8● §aSpielregeln");
                    gm.setItem(0, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    gm.setItem(1, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    gm.setItem(2, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    gm.setItem(3, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    gm.setItem(4, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    gm.setItem(5, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    gm.setItem(6, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    gm.setItem(7, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    gm.setItem(8, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    gm.setItem(9, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.NATURAL_REGENERATION)) {
                        gm.setItem(10, new ItemBuilder(Material.GOLDEN_APPLE).setName("§aNaturalRegeneration").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7die §anatürliche Regeneration §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                    } else {
                        gm.setItem(10, new ItemBuilder(Material.GOLDEN_APPLE).setName("§aNaturalRegeneration").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7die §anatürliche Regeneration §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                    }
                    if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.KEEP_INVENTORY)) {
                        gm.setItem(11, new ItemBuilder(Material.CHEST).setName("§aKeepInventory").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das §abehalten §7des §aInventars §7nach dem Tod um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                    } else {
                        gm.setItem(11, new ItemBuilder(Material.CHEST).setName("§aKeepInventory").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das §abehalten §7des §aInventars §7nach dem Tod um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                    }
                    if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_WEATHER_CYCLE)) {
                        gm.setItem(12, new ItemBuilder(Material.WATER_BUCKET).setName("§aDoWeatherCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Wetter §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                    } else {
                        gm.setItem(12, new ItemBuilder(Material.WATER_BUCKET).setName("§aDoWeatherCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Wetter §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                    }
                    if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_INSOMNIA)) {
                        gm.setItem(13, new ItemBuilder(Material.PHANTOM_MEMBRANE).setName("§aDoInsomnia").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPhantomen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                    } else {
                        gm.setItem(13, new ItemBuilder(Material.PHANTOM_MEMBRANE).setName("§aDoInsomnia").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPhantomen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                    }
                    if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_DAYLIGHT_CYCLE)) {
                        gm.setItem(14, new ItemBuilder(Material.CLOCK).setName("§aDoDaylightCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Tages §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                    } else {
                        gm.setItem(14, new ItemBuilder(Material.CLOCK).setName("§aDoDaylightCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Tages §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                    }
                    if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_TRADER_SPAWNING)) {
                        gm.setItem(15, new ItemBuilder(Material.LEAD).setName("§aSpawnWanderingTrader").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen vom §awandernden Händler §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                    } else {
                        gm.setItem(15, new ItemBuilder(Material.LEAD).setName("§aSpawnWanderingTrader").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen vom §awandernden Händler §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                    }
                    if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_PATROL_SPAWNING)) {
                        gm.setItem(16, new ItemBuilder(Material.CROSSBOW).setName("§aSpawnPatrolls").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPillager patrollien §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                    } else {
                        gm.setItem(16, new ItemBuilder(Material.CROSSBOW).setName("§aSpawnPatrolls").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPillager patrollien §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                    }
                    gm.setItem(17, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    gm.setItem(18, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.FALL_DAMAGE)) {
                        gm.setItem(19, new ItemBuilder(Material.DIAMOND_BOOTS).setName("§aFallDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aFallschaden §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                    } else {
                        gm.setItem(19, new ItemBuilder(Material.DIAMOND_BOOTS).setName("§aFallDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aFallschaden §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                    }
                    if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_MOB_LOOT)) {
                        gm.setItem(20, new ItemBuilder(Material.ROTTEN_FLESH).setName("§aDoMobLoot").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aMob Drops §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                    } else {
                        gm.setItem(20, new ItemBuilder(Material.ROTTEN_FLESH).setName("§aDoMobLoot").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aMob Drops §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                    }
                    if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_MOB_SPAWNING)) {
                        gm.setItem(21, new ItemBuilder(Material.ZOMBIE_HEAD).setName("§aDoMobSpawning").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von diversen §aMobs §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                    } else {
                        gm.setItem(21, new ItemBuilder(Material.ZOMBIE_HEAD).setName("§aDoMobSpawning").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von diversen §aMobs §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                    }
                    if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DISABLE_RAIDS)) {
                        gm.setItem(22, new ItemBuilder(Material.PILLAGER_SPAWN_EGG).setName("§aDisableRaids").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aüberfällen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                    } else {
                        gm.setItem(22, new ItemBuilder(Material.PILLAGER_SPAWN_EGG).setName("§aDisableRaids").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aüberfällen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                    }
                    if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DROWNING_DAMAGE)) {
                        gm.setItem(23, new ItemBuilder(Material.TRIDENT).setName("§aDrowningDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Schaden beim §aErtrinken §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                    } else {
                        gm.setItem(23, new ItemBuilder(Material.TRIDENT).setName("§aDrowningDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Schaden beim §aErtrinken §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                    }
                    if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.FIRE_DAMAGE)) {
                        gm.setItem(24, new ItemBuilder(Material.FIRE_CHARGE).setName("§aFireDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den §aFeuer §7Schaden um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                    } else {
                        gm.setItem(24, new ItemBuilder(Material.FIRE_CHARGE).setName("§aFireDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den §aFeuer §7Schaden um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                    }
                    if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_FIRE_TICK)) {
                        gm.setItem(25, new ItemBuilder(Material.FLINT_AND_STEEL).setName("§aDoFireTick").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7feuer §aausbreiten §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                    } else {
                        gm.setItem(25, new ItemBuilder(Material.FLINT_AND_STEEL).setName("§aDoFireTick").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7feuer §aausbreiten §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                    }
                    gm.setItem(26, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    gm.setItem(27, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    gm.setItem(28, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    gm.setItem(29, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    gm.setItem(30, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    gm.setItem(31, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    gm.setItem(32, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    gm.setItem(33, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    gm.setItem(34, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    gm.setItem(35, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    player.openInventory(gm);
                    event.setCancelled(true);
                    break;

                default:
                    event.setCancelled(true);
                    break;
            }

        } else if(event.getView().getTitle().equals("§6Einstellungen §8● §bSpieländerungen")) {

            switch (event.getCurrentItem().getType()) {

                case STONE_SWORD:
                    event.setCancelled(true);
                    if(GameStateManager.onDamageClear) {
                        GameStateManager.onDamageClear = false;
                        player.playSound(player.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 2F, 1F);
                        player.sendMessage(Main.getPrefix() + "§7Die Challenge §4Damage Clear §7wurde §cdeaktiviert§7.");
                    } else {
                        GameStateManager.onDamageClear = true;
                        player.playSound(player.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 2F, 1F);
                        player.sendMessage(Main.getPrefix() + "§7Die Challenge §4Damage Clear §7wurde §aaktiviert§7.");
                    }

                    Inventory cal = Bukkit.createInventory(null, 36, "§6Einstellungen §8● §bSpieländerungen");
                    cal.setItem(0, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal.setItem(1, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal.setItem(2, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal.setItem(3, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal.setItem(4, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal.setItem(5, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal.setItem(6, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal.setItem(7, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal.setItem(8, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal.setItem(9, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    if(GameStateManager.onDamageClear == true) {
                        cal.setItem(10, new ItemBuilder(Material.STONE_SWORD).setName("§cDamageClear").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion leert das", " §9Inventar §7aller §9Spieler", " §7wenn ein §9Spieler Schaden §7erleidet.", " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §2aktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    } else {
                        cal.setItem(10, new ItemBuilder(Material.STONE_SWORD).setName("§cDamageClear").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion leert das", " §9Inventar §7aller §9Spieler", " §7wenn ein §9Spieler Schaden §7erleidet.", " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §4deaktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    }

                    if(GameStateManager.noXP == true) {
                        cal.setItem(11, new ItemBuilder(Material.EXPERIENCE_BOTTLE).setName("§cNo XP").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion beendet die Challenge", " §7sobald ein Spieler ", " §9Experience §7erhält.", " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §2aktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    } else {
                        cal.setItem(11, new ItemBuilder(Material.EXPERIENCE_BOTTLE).setName("§cNo XP").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion beendet die Challenge", " §7sobald ein Spieler ", " §9Experience §7erhält.", " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §4deaktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    }
                    if(GameStateManager.noAdchievment == true) {
                        cal.setItem(12, new ItemBuilder(Material.APPLE).setName("§cNo Achievments").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion zieht jedesmal wenn", " §7ein Spieler ein §9Achievment §7erhält", " §9ein halbes Herz ab§7.",  " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §2aktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    } else {
                        cal.setItem(12, new ItemBuilder(Material.APPLE).setName("§cNo Achievments").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion zieht jedesmal wenn", " §7ein Spieler ein §9Achievment §7erhält", " §9ein halbes Herz ab§7.",  " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §4deaktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    }
                    if(GameStateManager.eRandomizer) {
                        cal.setItem(13, new ItemBuilder(Material.DIAMOND_PICKAXE).setName("§cExtreme Randomizer").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion droppt jedesmal", " §7wenn ein Spieler ein Block abbaut", " §7ein §9zufälliges Item§7.",  " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §2aktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    } else {
                        cal.setItem(13, new ItemBuilder(Material.DIAMOND_PICKAXE).setName("§cExtreme Randomizer").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion droppt jedesmal", " §7wenn ein Spieler ein Block abbaut", " §7ein §9zufälliges Item§7.",  " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §4deaktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    }
                    if(GameStateManager.trafficLights) {
                        cal.setItem(14, new ItemBuilder(Material.GREEN_CONCRETE).setName("§cAmpel Rennen").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion schaltet alle 5", " §7Minuten die Ampel", " §7je nach dem muss man §9stehen bleiben§7.",  " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §2aktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    } else {
                        cal.setItem(14, new ItemBuilder(Material.GREEN_CONCRETE).setName("§cAmpel Rennen").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion schaltet alle 5", " §7Minuten die Ampel", " §7je nach dem muss man §9stehen bleiben§7.",  " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §4deaktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    }
                    cal.setItem(15, new ItemBuilder(Material.GOLDEN_APPLE).setName("§cMax. Herzen").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion konfiguriert", " §7die Maximale", " §7Anzahl der §9Herzen§7, der §9Spieler§7.",  " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §b" + GameStateManager.maxHealth, " ", "§b§oLinksklick §9Einstellungen").build());
                    if(GameStateManager.zeroKiller) {
                        cal.setItem(16, new ItemBuilder(Material.WOODEN_SHOVEL).setName("§cZero Killer").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion §9tötet alle Spieler", " §7welche einen §9ItemStack aufbrauchen", " §7oder ein Item §9kaputt machen§7.",  " ", "§9§nEigenschaften§r§7:", " §7Typ§8: §bSpieländerung", " §7Status§8: §2aktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    } else {
                        cal.setItem(16, new ItemBuilder(Material.WOODEN_SHOVEL).setName("§cZero Killer").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion §9tötet alle Spieler", " §7welche einen §9ItemStack aufbrauchen", " §7oder ein Item §9kaputt machen§7.",  " ", "§9§nEigenschaften§r§7:", " §7Typ§8: §bSpieländerung", " §7Status§8: §4deaktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    }
                    cal.setItem(17, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal.setItem(18, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    if(GameStateManager.AirBlock) {
                        cal.setItem(19, new ItemBuilder(Material.STONE).setName("§cAirBlock").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion §9löscht alle Blöcke", " §7welche in einem §9Chunk gesetzt", " §7oder §9abgebaut werden§7.",  " ", "§9§nEigenschaften§r§7:", " §7Typ§8: §bSpieländerung", " §7Status§8: §2aktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    } else {
                        cal.setItem(19, new ItemBuilder(Material.STONE).setName("§cAirBlock").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion §9löscht alle Blöcke", " §7welche in einem §9Chunk gesetzt", " §7oder §9abgebaut werden§7.",  " ", "§9§nEigenschaften§r§7:", " §7Typ§8: §bSpieländerung", " §7Status§8: §4deaktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    }
                    cal.setItem(20, new ItemBuilder(Material.BARRIER).setName("§4§lNicht verfügbar").build());
                    cal.setItem(21, new ItemBuilder(Material.BARRIER).setName("§4§lNicht verfügbar").build());
                    cal.setItem(22, new ItemBuilder(Material.BARRIER).setName("§4§lNicht verfügbar").build());
                    cal.setItem(23, new ItemBuilder(Material.BARRIER).setName("§4§lNicht verfügbar").build());
                    cal.setItem(24, new ItemBuilder(Material.BARRIER).setName("§4§lNicht verfügbar").build());
                    cal.setItem(25, new ItemBuilder(Material.BARRIER).setName("§4§lNicht verfügbar").build());
                    cal.setItem(26, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal.setItem(27, new ItemBuilder(Material.PLAYER_HEAD).setName("§8● §a1. Seite §2<<").setLore("§7§oKlicke, um die Seite zu wechseln").build());
                    cal.setItem(28, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal.setItem(29, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal.setItem(30, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal.setItem(31, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal.setItem(32, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal.setItem(33, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal.setItem(34, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal.setItem(35, new ItemBuilder(Material.PLAYER_HEAD).setName("§8● §a2. Seite §2>>").setLore("§7§oKlicke, um die Seite zu wechseln").build());
                    player.openInventory(cal);
                    event.setCancelled(true);
                    break;
                case GRAY_STAINED_GLASS_PANE:

                    Inventory inv = Bukkit.createInventory(null, 27, "§6Einstellungen §8● §9Übersicht");
                    inv.setItem(0, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                    inv.setItem(1, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                    inv.setItem(2, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                    inv.setItem(3, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                    inv.setItem(4, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                    inv.setItem(5, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                    inv.setItem(6, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                    inv.setItem(7, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                    inv.setItem(8, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());

                    inv.setItem(9, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                    inv.setItem(10, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());

                    inv.setItem(11, new ItemBuilder(Material.DRAGON_HEAD).setName("§cBedingungen").setLore(" ", " §7Lege die §cBedingung", " §7für den §cSieg §7einer", " §cChallenge §7fest", " ", " §c§oKlick§7§o: §r§cÜbersicht").build());
                    inv.setItem(12, new ItemBuilder(Material.GRASS_BLOCK).setName("§bSpieländerung").setLore(" ", "§7Spieländerungen §bverändern", "§7das §bSpielgeschehen §7auf", "§7vielen Art und Weisen.", " ", "§b§oKlick §r§bÜbersicht").build());

                    inv.setItem(13, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());

                    inv.setItem(14, new ItemBuilder(Material.IRON_PICKAXE).setName("§6Funktion").setLore(" ", "§6Funktionen §7sind Modifikationen,", "§7welche §6kosmetisch §7und §6funktionell", "§7sind und das Spielgeschehen", "§6nicht beeinflussen§7.", " ", "§6§oKlick §r§6Übersicht").build());
                    inv.setItem(15, new ItemBuilder(Material.MAP).setName("§aSpielregel").setLore("", "§aSpielregeln §7sind die normale", "§a/gamerule§7s und weitere", "§aVeränderungen §7des Spielgeschehens", "§7mit normalen Mitteln von Minecraft.", " ", "§a§oKlick §r§aÜbersicht").build());

                    inv.setItem(16, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                    inv.setItem(17, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                    inv.setItem(18, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                    inv.setItem(19, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                    inv.setItem(20, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                    inv.setItem(21, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                    inv.setItem(22, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                    inv.setItem(23, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                    inv.setItem(24, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                    inv.setItem(25, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                    inv.setItem(26, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());

                    player.openInventory(inv);
                    event.setCancelled(true);
                    break;
                case EXPERIENCE_BOTTLE:
                    if(GameStateManager.noXP == true) {
                        player.playSound(player.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 2F, 1F);
                        GameStateManager.noXP = false;
                        player.sendMessage(Main.getPrefix() + "§7Die Challenge §4No XP §7wurde §cdeaktiviert§7.");
                        event.setCancelled(true);
                    } else {
                        player.playSound(player.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 2F, 1F);
                        GameStateManager.noXP = true;
                        player.sendMessage(Main.getPrefix() + "§7Die Challenge §4No XP §7wurde §aaktiviert§7.");
                        event.setCancelled(true);
                    }

                    Inventory cal2 = Bukkit.createInventory(null, 36, "§6Einstellungen §8● §bSpieländerungen");
                    cal2.setItem(0, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal2.setItem(1, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal2.setItem(2, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal2.setItem(3, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal2.setItem(4, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal2.setItem(5, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal2.setItem(6, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal2.setItem(7, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal2.setItem(8, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal2.setItem(9, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    if(GameStateManager.onDamageClear == true) {
                        cal2.setItem(10, new ItemBuilder(Material.STONE_SWORD).setName("§cDamageClear").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion leert das", " §9Inventar §7aller §9Spieler", " §7wenn ein §9Spieler Schaden §7erleidet.", " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §2aktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    } else {
                        cal2.setItem(10, new ItemBuilder(Material.STONE_SWORD).setName("§cDamageClear").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion leert das", " §9Inventar §7aller §9Spieler", " §7wenn ein §9Spieler Schaden §7erleidet.", " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §4deaktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    }

                    if(GameStateManager.noXP == true) {
                        cal2.setItem(11, new ItemBuilder(Material.EXPERIENCE_BOTTLE).setName("§cNo XP").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion beendet die Challenge", " §7sobald ein Spieler ", " §9Experience §7erhält.", " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §2aktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    } else {
                        cal2.setItem(11, new ItemBuilder(Material.EXPERIENCE_BOTTLE).setName("§cNo XP").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion beendet die Challenge", " §7sobald ein Spieler ", " §9Experience §7erhält.", " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §4deaktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    }
                    if(GameStateManager.noAdchievment == true) {
                        cal2.setItem(12, new ItemBuilder(Material.APPLE).setName("§cNo Achievments").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion zieht jedesmal wenn", " §7ein Spieler ein §9Achievment §7erhält", " §9ein halbes Herz ab§7.",  " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §2aktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    } else {
                        cal2.setItem(12, new ItemBuilder(Material.APPLE).setName("§cNo Achievments").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion zieht jedesmal wenn", " §7ein Spieler ein §9Achievment §7erhält", " §9ein halbes Herz ab§7.",  " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §4deaktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    }
                    if(GameStateManager.eRandomizer) {
                        cal2.setItem(13, new ItemBuilder(Material.DIAMOND_PICKAXE).setName("§cExtreme Randomizer").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion droppt jedesmal", " §7wenn ein Spieler ein Block abbaut", " §7ein §9zufälliges Item§7.",  " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §2aktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    } else {
                        cal2.setItem(13, new ItemBuilder(Material.DIAMOND_PICKAXE).setName("§cExtreme Randomizer").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion droppt jedesmal", " §7wenn ein Spieler ein Block abbaut", " §7ein §9zufälliges Item§7.",  " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §4deaktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    }
                    if(GameStateManager.trafficLights) {
                        cal2.setItem(14, new ItemBuilder(Material.GREEN_CONCRETE).setName("§cAmpel Rennen").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion schaltet alle 5", " §7Minuten die Ampel", " §7je nach dem muss man §9stehen bleiben§7.",  " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §2aktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    } else {
                        cal2.setItem(14, new ItemBuilder(Material.GREEN_CONCRETE).setName("§cAmpel Rennen").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion schaltet alle 5", " §7Minuten die Ampel", " §7je nach dem muss man §9stehen bleiben§7.",  " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §4deaktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    }
                    cal2.setItem(15, new ItemBuilder(Material.GOLDEN_APPLE).setName("§cMax. Herzen").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion konfiguriert", " §7die Maximale", " §7Anzahl der §9Herzen§7, der §9Spieler§7.",  " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §b" + GameStateManager.maxHealth, " ", "§b§oLinksklick §9Einstellungen").build());
                    if(GameStateManager.zeroKiller) {
                        cal2.setItem(16, new ItemBuilder(Material.WOODEN_SHOVEL).setName("§cZero Killer").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion §9tötet alle Spieler", " §7welche einen §9ItemStack aufbrauchen", " §7oder ein Item §9kaputt machen§7.",  " ", "§9§nEigenschaften§r§7:", " §7Typ§8: §bSpieländerung", " §7Status§8: §2aktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    } else {
                        cal2.setItem(16, new ItemBuilder(Material.WOODEN_SHOVEL).setName("§cZero Killer").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion §9tötet alle Spieler", " §7welche einen §9ItemStack aufbrauchen", " §7oder ein Item §9kaputt machen§7.",  " ", "§9§nEigenschaften§r§7:", " §7Typ§8: §bSpieländerung", " §7Status§8: §4deaktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    }
                    cal2.setItem(17, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal2.setItem(18, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    if(GameStateManager.AirBlock) {
                        cal2.setItem(19, new ItemBuilder(Material.STONE).setName("§cAirBlock").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion §9löscht alle Blöcke", " §7welche in einem §9Chunk gesetzt", " §7oder §9abgebaut werden§7.",  " ", "§9§nEigenschaften§r§7:", " §7Typ§8: §bSpieländerung", " §7Status§8: §2aktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    } else {
                        cal2.setItem(19, new ItemBuilder(Material.STONE).setName("§cAirBlock").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion §9löscht alle Blöcke", " §7welche in einem §9Chunk gesetzt", " §7oder §9abgebaut werden§7.",  " ", "§9§nEigenschaften§r§7:", " §7Typ§8: §bSpieländerung", " §7Status§8: §4deaktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    }
                    cal2.setItem(20, new ItemBuilder(Material.BARRIER).setName("§4§lNicht verfügbar").build());
                    cal2.setItem(21, new ItemBuilder(Material.BARRIER).setName("§4§lNicht verfügbar").build());
                    cal2.setItem(22, new ItemBuilder(Material.BARRIER).setName("§4§lNicht verfügbar").build());
                    cal2.setItem(23, new ItemBuilder(Material.BARRIER).setName("§4§lNicht verfügbar").build());
                    cal2.setItem(24, new ItemBuilder(Material.BARRIER).setName("§4§lNicht verfügbar").build());
                    cal2.setItem(25, new ItemBuilder(Material.BARRIER).setName("§4§lNicht verfügbar").build());
                    cal2.setItem(26, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal2.setItem(27, new ItemBuilder(Material.PLAYER_HEAD).setName("§8● §a1. Seite §2<<").setLore("§7§oKlicke, um die Seite zu wechseln").build());
                    cal2.setItem(28, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal2.setItem(29, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal2.setItem(30, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal2.setItem(31, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal2.setItem(32, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal2.setItem(33, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal2.setItem(34, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal2.setItem(35, new ItemBuilder(Material.PLAYER_HEAD).setName("§8● §a2. Seite §2>>").setLore("§7§oKlicke, um die Seite zu wechseln").build());
                    player.openInventory(cal2);
                    event.setCancelled(true);
                    break;

                case APPLE:
                    if(GameStateManager.noAdchievment == true) {
                        player.playSound(player.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 2F, 1F);
                        GameStateManager.noAdchievment = false;
                        player.sendMessage(Main.getPrefix() + "§7Die Challenge §4No Achievments §7wurde §cdeaktiviert§7.");
                        event.setCancelled(true);
                    } else {
                        player.playSound(player.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 2F, 1F);
                        GameStateManager.noAdchievment = true;
                        player.sendMessage(Main.getPrefix() + "§7Die Challenge §4No Achievments §7wurde §aaktiviert§7.");
                        event.setCancelled(true);
                    }

                    Inventory cal3 = Bukkit.createInventory(null, 36, "§6Einstellungen §8● §bSpieländerungen");
                    cal3.setItem(0, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal3.setItem(1, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal3.setItem(2, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal3.setItem(3, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal3.setItem(4, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal3.setItem(5, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal3.setItem(6, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal3.setItem(7, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal3.setItem(8, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal3.setItem(9, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    if(GameStateManager.onDamageClear == true) {
                        cal3.setItem(10, new ItemBuilder(Material.STONE_SWORD).setName("§cDamageClear").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion leert das", " §9Inventar §7aller §9Spieler", " §7wenn ein §9Spieler Schaden §7erleidet.", " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §2aktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    } else {
                        cal3.setItem(10, new ItemBuilder(Material.STONE_SWORD).setName("§cDamageClear").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion leert das", " §9Inventar §7aller §9Spieler", " §7wenn ein §9Spieler Schaden §7erleidet.", " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §4deaktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    }

                    if(GameStateManager.noXP == true) {
                        cal3.setItem(11, new ItemBuilder(Material.EXPERIENCE_BOTTLE).setName("§cNo XP").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion beendet die Challenge", " §7sobald ein Spieler ", " §9Experience §7erhält.", " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §2aktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    } else {
                        cal3.setItem(11, new ItemBuilder(Material.EXPERIENCE_BOTTLE).setName("§cNo XP").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion beendet die Challenge", " §7sobald ein Spieler ", " §9Experience §7erhält.", " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §4deaktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    }
                    if(GameStateManager.noAdchievment == true) {
                        cal3.setItem(12, new ItemBuilder(Material.APPLE).setName("§cNo Achievments").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion zieht jedesmal wenn", " §7ein Spieler ein §9Achievment §7erhält", " §9ein halbes Herz ab§7.",  " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §2aktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    } else {
                        cal3.setItem(12, new ItemBuilder(Material.APPLE).setName("§cNo Achievments").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion zieht jedesmal wenn", " §7ein Spieler ein §9Achievment §7erhält", " §9ein halbes Herz ab§7.",  " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §4deaktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    }
                    if(GameStateManager.eRandomizer) {
                        cal3.setItem(13, new ItemBuilder(Material.DIAMOND_PICKAXE).setName("§cExtreme Randomizer").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion droppt jedesmal", " §7wenn ein Spieler ein Block abbaut", " §7ein §9zufälliges Item§7.",  " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §2aktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    } else {
                        cal3.setItem(13, new ItemBuilder(Material.DIAMOND_PICKAXE).setName("§cExtreme Randomizer").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion droppt jedesmal", " §7wenn ein Spieler ein Block abbaut", " §7ein §9zufälliges Item§7.",  " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §4deaktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    }
                    if(GameStateManager.trafficLights) {
                        cal3.setItem(14, new ItemBuilder(Material.GREEN_CONCRETE).setName("§cAmpel Rennen").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion schaltet alle 5", " §7Minuten die Ampel", " §7je nach dem muss man §9stehen bleiben§7.",  " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §2aktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    } else {
                        cal3.setItem(14, new ItemBuilder(Material.GREEN_CONCRETE).setName("§cAmpel Rennen").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion schaltet alle 5", " §7Minuten die Ampel", " §7je nach dem muss man §9stehen bleiben§7.",  " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §4deaktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    }
                    cal3.setItem(15, new ItemBuilder(Material.GOLDEN_APPLE).setName("§cMax. Herzen").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion konfiguriert", " §7die Maximale", " §7Anzahl der §9Herzen§7, der §9Spieler§7.",  " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §b" + GameStateManager.maxHealth, " ", "§b§oLinksklick §9Einstellungen").build());
                    if(GameStateManager.zeroKiller) {
                        cal3.setItem(16, new ItemBuilder(Material.WOODEN_SHOVEL).setName("§cZero Killer").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion §9tötet alle Spieler", " §7welche einen §9ItemStack aufbrauchen", " §7oder ein Item §9kaputt machen§7.",  " ", "§9§nEigenschaften§r§7:", " §7Typ§8: §bSpieländerung", " §7Status§8: §2aktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    } else {
                        cal3.setItem(16, new ItemBuilder(Material.WOODEN_SHOVEL).setName("§cZero Killer").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion §9tötet alle Spieler", " §7welche einen §9ItemStack aufbrauchen", " §7oder ein Item §9kaputt machen§7.",  " ", "§9§nEigenschaften§r§7:", " §7Typ§8: §bSpieländerung", " §7Status§8: §4deaktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    }
                    cal3.setItem(17, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal3.setItem(18, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    if(GameStateManager.AirBlock) {
                        cal3.setItem(19, new ItemBuilder(Material.STONE).setName("§cAirBlock").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion §9löscht alle Blöcke", " §7welche in einem §9Chunk gesetzt", " §7oder §9abgebaut werden§7.",  " ", "§9§nEigenschaften§r§7:", " §7Typ§8: §bSpieländerung", " §7Status§8: §2aktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    } else {
                        cal3.setItem(19, new ItemBuilder(Material.STONE).setName("§cAirBlock").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion §9löscht alle Blöcke", " §7welche in einem §9Chunk gesetzt", " §7oder §9abgebaut werden§7.",  " ", "§9§nEigenschaften§r§7:", " §7Typ§8: §bSpieländerung", " §7Status§8: §4deaktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    }
                    cal3.setItem(20, new ItemBuilder(Material.BARRIER).setName("§4§lNicht verfügbar").build());
                    cal3.setItem(21, new ItemBuilder(Material.BARRIER).setName("§4§lNicht verfügbar").build());
                    cal3.setItem(22, new ItemBuilder(Material.BARRIER).setName("§4§lNicht verfügbar").build());
                    cal3.setItem(23, new ItemBuilder(Material.BARRIER).setName("§4§lNicht verfügbar").build());
                    cal3.setItem(24, new ItemBuilder(Material.BARRIER).setName("§4§lNicht verfügbar").build());
                    cal3.setItem(25, new ItemBuilder(Material.BARRIER).setName("§4§lNicht verfügbar").build());
                    cal3.setItem(26, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal3.setItem(27, new ItemBuilder(Material.PLAYER_HEAD).setName("§8● §a1. Seite §2<<").setLore("§7§oKlicke, um die Seite zu wechseln").build());
                    cal3.setItem(28, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal3.setItem(29, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal3.setItem(30, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal3.setItem(31, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal3.setItem(32, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal3.setItem(33, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal3.setItem(34, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal3.setItem(35, new ItemBuilder(Material.PLAYER_HEAD).setName("§8● §a2. Seite §2>>").setLore("§7§oKlicke, um die Seite zu wechseln").build());
                    player.openInventory(cal3);
                    event.setCancelled(true);
                    break;
                case DIAMOND_PICKAXE:
                    if(GameStateManager.eRandomizer) {
                        GameStateManager.eRandomizer = false;
                    } else {
                        GameStateManager.eRandomizer = true;
                    }

                    player.playSound(player.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 2F, 1F);
                    event.setCancelled(true);

                    Inventory cal4 = Bukkit.createInventory(null, 36, "§6Einstellungen §8● §bSpieländerungen");
                    cal4.setItem(0, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal4.setItem(1, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal4.setItem(2, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal4.setItem(3, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal4.setItem(4, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal4.setItem(5, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal4.setItem(6, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal4.setItem(7, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal4.setItem(8, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal4.setItem(9, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    if(GameStateManager.onDamageClear == true) {
                        cal4.setItem(10, new ItemBuilder(Material.STONE_SWORD).setName("§cDamageClear").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion leert das", " §9Inventar §7aller §9Spieler", " §7wenn ein §9Spieler Schaden §7erleidet.", " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §2aktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    } else {
                        cal4.setItem(10, new ItemBuilder(Material.STONE_SWORD).setName("§cDamageClear").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion leert das", " §9Inventar §7aller §9Spieler", " §7wenn ein §9Spieler Schaden §7erleidet.", " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §4deaktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    }

                    if(GameStateManager.noXP == true) {
                        cal4.setItem(11, new ItemBuilder(Material.EXPERIENCE_BOTTLE).setName("§cNo XP").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion beendet die Challenge", " §7sobald ein Spieler ", " §9Experience §7erhält.", " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §2aktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    } else {
                        cal4.setItem(11, new ItemBuilder(Material.EXPERIENCE_BOTTLE).setName("§cNo XP").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion beendet die Challenge", " §7sobald ein Spieler ", " §9Experience §7erhält.", " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §4deaktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    }
                    if(GameStateManager.noAdchievment == true) {
                        cal4.setItem(12, new ItemBuilder(Material.APPLE).setName("§cNo Achievments").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion zieht jedesmal wenn", " §7ein Spieler ein §9Achievment §7erhält", " §9ein halbes Herz ab§7.",  " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §2aktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    } else {
                        cal4.setItem(12, new ItemBuilder(Material.APPLE).setName("§cNo Achievments").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion zieht jedesmal wenn", " §7ein Spieler ein §9Achievment §7erhält", " §9ein halbes Herz ab§7.",  " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §4deaktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    }
                    if(GameStateManager.eRandomizer) {
                        cal4.setItem(13, new ItemBuilder(Material.DIAMOND_PICKAXE).setName("§cExtreme Randomizer").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion droppt jedesmal", " §7wenn ein Spieler ein Block abbaut", " §7ein §9zufälliges Item§7.",  " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §2aktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    } else {
                        cal4.setItem(13, new ItemBuilder(Material.DIAMOND_PICKAXE).setName("§cExtreme Randomizer").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion droppt jedesmal", " §7wenn ein Spieler ein Block abbaut", " §7ein §9zufälliges Item§7.",  " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §4deaktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    }
                    if(GameStateManager.trafficLights) {
                        cal4.setItem(14, new ItemBuilder(Material.GREEN_CONCRETE).setName("§cAmpel Rennen").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion schaltet alle 5", " §7Minuten die Ampel", " §7je nach dem muss man §9stehen bleiben§7.",  " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §2aktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    } else {
                        cal4.setItem(14, new ItemBuilder(Material.GREEN_CONCRETE).setName("§cAmpel Rennen").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion schaltet alle 5", " §7Minuten die Ampel", " §7je nach dem muss man §9stehen bleiben§7.",  " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §4deaktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    }
                    cal4.setItem(15, new ItemBuilder(Material.GOLDEN_APPLE).setName("§cMax. Herzen").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion konfiguriert", " §7die Maximale", " §7Anzahl der §9Herzen§7, der §9Spieler§7.",  " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §b" + GameStateManager.maxHealth, " ", "§b§oLinksklick §9Einstellungen").build());
                    if(GameStateManager.zeroKiller) {
                        cal4.setItem(16, new ItemBuilder(Material.WOODEN_SHOVEL).setName("§cZero Killer").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion §9tötet alle Spieler", " §7welche einen §9ItemStack aufbrauchen", " §7oder ein Item §9kaputt machen§7.",  " ", "§9§nEigenschaften§r§7:", " §7Typ§8: §bSpieländerung", " §7Status§8: §2aktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    } else {
                        cal4.setItem(16, new ItemBuilder(Material.WOODEN_SHOVEL).setName("§cZero Killer").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion §9tötet alle Spieler", " §7welche einen §9ItemStack aufbrauchen", " §7oder ein Item §9kaputt machen§7.",  " ", "§9§nEigenschaften§r§7:", " §7Typ§8: §bSpieländerung", " §7Status§8: §4deaktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    }
                    cal4.setItem(17, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal4.setItem(18, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    if(GameStateManager.AirBlock) {
                        cal4.setItem(19, new ItemBuilder(Material.STONE).setName("§cAirBlock").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion §9löscht alle Blöcke", " §7welche in einem §9Chunk gesetzt", " §7oder §9abgebaut werden§7.",  " ", "§9§nEigenschaften§r§7:", " §7Typ§8: §bSpieländerung", " §7Status§8: §2aktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    } else {
                        cal4.setItem(19, new ItemBuilder(Material.STONE).setName("§cAirBlock").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion §9löscht alle Blöcke", " §7welche in einem §9Chunk gesetzt", " §7oder §9abgebaut werden§7.",  " ", "§9§nEigenschaften§r§7:", " §7Typ§8: §bSpieländerung", " §7Status§8: §4deaktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    }
                    cal4.setItem(20, new ItemBuilder(Material.BARRIER).setName("§4§lNicht verfügbar").build());
                    cal4.setItem(21, new ItemBuilder(Material.BARRIER).setName("§4§lNicht verfügbar").build());
                    cal4.setItem(22, new ItemBuilder(Material.BARRIER).setName("§4§lNicht verfügbar").build());
                    cal4.setItem(23, new ItemBuilder(Material.BARRIER).setName("§4§lNicht verfügbar").build());
                    cal4.setItem(24, new ItemBuilder(Material.BARRIER).setName("§4§lNicht verfügbar").build());
                    cal4.setItem(25, new ItemBuilder(Material.BARRIER).setName("§4§lNicht verfügbar").build());
                    cal4.setItem(26, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal4.setItem(27, new ItemBuilder(Material.PLAYER_HEAD).setName("§8● §a1. Seite §2<<").setLore("§7§oKlicke, um die Seite zu wechseln").build());
                    cal4.setItem(28, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal4.setItem(29, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal4.setItem(30, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal4.setItem(31, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal4.setItem(32, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal4.setItem(33, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal4.setItem(34, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal4.setItem(35, new ItemBuilder(Material.PLAYER_HEAD).setName("§8● §a2. Seite §2>>").setLore("§7§oKlicke, um die Seite zu wechseln").build());
                    player.openInventory(cal4);
                    break;
                case GREEN_CONCRETE:
                    if(GameStateManager.trafficLights) {
                        GameStateManager.trafficLights = false;
                        player.sendMessage(Main.getPrefix() + "§7Die Challenge §4AmpelRennen §7wurde §cdeaktiviert!");
                    } else {
                        GameStateManager.trafficLights = true;
                        GameStateManager.green = true;
                        GameStateManager.yellow = false;
                        GameStateManager.red = false;
                        player.sendMessage(Main.getPrefix() + "§7Die Challenge §4AmpelRennen §7wurde §aaktiviert!");
                    }

                    player.playSound(player.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 2F, 1F);
                    event.setCancelled(true);

                    Inventory cal5 = Bukkit.createInventory(null, 36, "§6Einstellungen §8● §bSpieländerungen");
                    cal5.setItem(0, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal5.setItem(1, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal5.setItem(2, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal5.setItem(3, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal5.setItem(4, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal5.setItem(5, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal5.setItem(6, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal5.setItem(7, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal5.setItem(8, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal5.setItem(9, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    if(GameStateManager.onDamageClear == true) {
                        cal5.setItem(10, new ItemBuilder(Material.STONE_SWORD).setName("§cDamageClear").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion leert das", " §9Inventar §7aller §9Spieler", " §7wenn ein §9Spieler Schaden §7erleidet.", " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §2aktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    } else {
                        cal5.setItem(10, new ItemBuilder(Material.STONE_SWORD).setName("§cDamageClear").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion leert das", " §9Inventar §7aller §9Spieler", " §7wenn ein §9Spieler Schaden §7erleidet.", " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §4deaktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    }

                    if(GameStateManager.noXP == true) {
                        cal5.setItem(11, new ItemBuilder(Material.EXPERIENCE_BOTTLE).setName("§cNo XP").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion beendet die Challenge", " §7sobald ein Spieler ", " §9Experience §7erhält.", " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §2aktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    } else {
                        cal5.setItem(11, new ItemBuilder(Material.EXPERIENCE_BOTTLE).setName("§cNo XP").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion beendet die Challenge", " §7sobald ein Spieler ", " §9Experience §7erhält.", " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §4deaktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    }
                    if(GameStateManager.noAdchievment == true) {
                        cal5.setItem(12, new ItemBuilder(Material.APPLE).setName("§cNo Achievments").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion zieht jedesmal wenn", " §7ein Spieler ein §9Achievment §7erhält", " §9ein halbes Herz ab§7.",  " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §2aktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    } else {
                        cal5.setItem(12, new ItemBuilder(Material.APPLE).setName("§cNo Achievments").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion zieht jedesmal wenn", " §7ein Spieler ein §9Achievment §7erhält", " §9ein halbes Herz ab§7.",  " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §4deaktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    }
                    if(GameStateManager.eRandomizer) {
                        cal5.setItem(13, new ItemBuilder(Material.DIAMOND_PICKAXE).setName("§cExtreme Randomizer").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion droppt jedesmal", " §7wenn ein Spieler ein Block abbaut", " §7ein §9zufälliges Item§7.",  " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §2aktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    } else {
                        cal5.setItem(13, new ItemBuilder(Material.DIAMOND_PICKAXE).setName("§cExtreme Randomizer").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion droppt jedesmal", " §7wenn ein Spieler ein Block abbaut", " §7ein §9zufälliges Item§7.",  " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §4deaktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    }
                    if(GameStateManager.trafficLights) {
                        cal5.setItem(14, new ItemBuilder(Material.GREEN_CONCRETE).setName("§cAmpel Rennen").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion schaltet alle 5", " §7Minuten die Ampel", " §7je nach dem muss man §9stehen bleiben§7.",  " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §2aktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    } else {
                        cal5.setItem(14, new ItemBuilder(Material.GREEN_CONCRETE).setName("§cAmpel Rennen").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion schaltet alle 5", " §7Minuten die Ampel", " §7je nach dem muss man §9stehen bleiben§7.",  " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §4deaktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    }
                    cal5.setItem(15, new ItemBuilder(Material.GOLDEN_APPLE).setName("§cMax. Herzen").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion konfiguriert", " §7die Maximale", " §7Anzahl der §9Herzen§7, der §9Spieler§7.",  " ", "§9§nEigenschaften§r§7:", "§7Typ§8: §bSpieländerung", " §7Status§8: §b" + GameStateManager.maxHealth, " ", "§b§oLinksklick §9Einstellungen").build());
                    if(GameStateManager.zeroKiller) {
                        cal5.setItem(16, new ItemBuilder(Material.WOODEN_SHOVEL).setName("§cZero Killer").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion §9tötet alle Spieler", " §7welche einen §9ItemStack aufbrauchen", " §7oder ein Item §9kaputt machen§7.",  " ", "§9§nEigenschaften§r§7:", " §7Typ§8: §bSpieländerung", " §7Status§8: §2aktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    } else {
                        cal5.setItem(16, new ItemBuilder(Material.WOODEN_SHOVEL).setName("§cZero Killer").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion §9tötet alle Spieler", " §7welche einen §9ItemStack aufbrauchen", " §7oder ein Item §9kaputt machen§7.",  " ", "§9§nEigenschaften§r§7:", " §7Typ§8: §bSpieländerung", " §7Status§8: §4deaktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    }
                    cal5.setItem(17, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal5.setItem(18, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    if(GameStateManager.AirBlock) {
                        cal5.setItem(19, new ItemBuilder(Material.STONE).setName("§cAirBlock").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion §9löscht alle Blöcke", " §7welche in einem §9Chunk gesetzt", " §7oder §9abgebaut werden§7.",  " ", "§9§nEigenschaften§r§7:", " §7Typ§8: §bSpieländerung", " §7Status§8: §2aktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    } else {
                        cal5.setItem(19, new ItemBuilder(Material.STONE).setName("§cAirBlock").setLore(" ", "§9§nBeschreibung§r§7:", "§7 Diese Funktion §9löscht alle Blöcke", " §7welche in einem §9Chunk gesetzt", " §7oder §9abgebaut werden§7.",  " ", "§9§nEigenschaften§r§7:", " §7Typ§8: §bSpieländerung", " §7Status§8: §4deaktiviert", " ", "§b§oLinksklick §9Status ändern", "§b§oRechtsklick §9Einstellungen").build());
                    }
                    cal5.setItem(20, new ItemBuilder(Material.BARRIER).setName("§4§lNicht verfügbar").build());
                    cal5.setItem(21, new ItemBuilder(Material.BARRIER).setName("§4§lNicht verfügbar").build());
                    cal5.setItem(22, new ItemBuilder(Material.BARRIER).setName("§4§lNicht verfügbar").build());
                    cal5.setItem(23, new ItemBuilder(Material.BARRIER).setName("§4§lNicht verfügbar").build());
                    cal5.setItem(24, new ItemBuilder(Material.BARRIER).setName("§4§lNicht verfügbar").build());
                    cal5.setItem(25, new ItemBuilder(Material.BARRIER).setName("§4§lNicht verfügbar").build());
                    cal5.setItem(26, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal5.setItem(27, new ItemBuilder(Material.PLAYER_HEAD).setName("§8● §a1. Seite §2<<").setLore("§7§oKlicke, um die Seite zu wechseln").build());
                    cal5.setItem(28, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal5.setItem(29, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal5.setItem(30, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal5.setItem(31, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal5.setItem(32, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal5.setItem(33, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal5.setItem(34, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    cal5.setItem(35, new ItemBuilder(Material.PLAYER_HEAD).setName("§8● §a2. Seite §2>>").setLore("§7§oKlicke, um die Seite zu wechseln").build());
                    player.openInventory(cal5);
                    break;
                case GOLDEN_APPLE:
                    event.setCancelled(true);
                    HealthHandler.showHealthInv(player.getPlayer());
                    break;
                case WOODEN_SHOVEL:
                    event.setCancelled(true);
                    player.playSound(player.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 2F, 1F);
                    InventoryHandler.ZeroKiller(player.getPlayer());
                    InventoryHandler.updateCalInventory(player.getPlayer());
                    break;
                case STONE:
                    event.setCancelled(true);
                    player.playSound(player.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 2F, 1F);
                    InventoryHandler.AirBlock(player.getPlayer());
                    InventoryHandler.updateCalInventory(player.getPlayer());
                    break;
                default:
                    event.setCancelled(true);
                    break;
            }
        } else if(event.getView().getTitle().equals("§6Einstellungen §8● §cBedingungen")) {

            switch (event.getCurrentItem().getType()) {

                case DRAGON_EGG:
                    GameStateManager.killEnderdragon = true;
                    GameStateManager.killWither = false;
                    GameStateManager.killElderGuardian = false;

                    player.playSound(player.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 2F, 1F);

                    Inventory b = Bukkit.createInventory(null, 9, "§6Einstellungen §8● §cBedingungen");
                    b.setItem(0, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    b.setItem(1, new ItemBuilder(Material.DRAGON_EGG).setName("§cEnderdrache").setLore(" ", " §cTöte §7den §cEnderdrachen", " §7um die aktuelle", " §cChallenge §7zu §cbeenden", " ", " §9§nStatus:", " §aaktiviert").build());
                    b.setItem(2, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    b.setItem(3, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    b.setItem(4, new ItemBuilder(Material.WITHER_SKELETON_SKULL).setName("§cWither").setLore(" ", " §cTöte §7den §cWither", " §7um die aktuelle", " §cChallenge §7zu beenden", " ", " §9§nStatus:", " §4deaktiviert").build());
                    b.setItem(5, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    b.setItem(6, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    b.setItem(7, new ItemBuilder(Material.PRISMARINE_SHARD).setName("§cGroßer Tempelwächter").setLore(" ", " §cTöte §7den §cWither", " §7um die aktuelle", " §cChallenge §7zu beenden", " ", " §9§nStatus:", " §4deaktiviert").build());
                    b.setItem(8, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());

                    player.openInventory(b);
                    event.setCancelled(true);
                    break;
                case GRAY_STAINED_GLASS_PANE:
                    Inventory inv = Bukkit.createInventory(null, 27, "§6Einstellungen §8● §9Übersicht");
                    inv.setItem(0, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                    inv.setItem(1, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                    inv.setItem(2, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                    inv.setItem(3, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                    inv.setItem(4, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                    inv.setItem(5, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                    inv.setItem(6, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                    inv.setItem(7, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                    inv.setItem(8, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());

                    inv.setItem(9, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                    inv.setItem(10, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());

                    inv.setItem(11, new ItemBuilder(Material.DRAGON_HEAD).setName("§cBedingungen").setLore(" ", " §7Lege die §cBedingung", " §7für den §cSieg §7einer", " §cChallenge §7fest", " ", " §c§oKlick§7§o: §r§cÜbersicht").build());
                    inv.setItem(12, new ItemBuilder(Material.GRASS_BLOCK).setName("§bSpieländerung").setLore(" ", "§7Spieländerungen §bverändern", "§7das §bSpielgeschehen §7auf", "§7vielen Art und Weisen.", " ", "§b§oKlick §r§bÜbersicht").build());

                    inv.setItem(13, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());

                    inv.setItem(14, new ItemBuilder(Material.IRON_PICKAXE).setName("§6Funktion").setLore(" ", "§6Funktionen §7sind Modifikationen,", "§7welche §6kosmetisch §7und §6funktionell", "§7sind und das Spielgeschehen", "§6nicht beeinflussen§7.", " ", "§6§oKlick §r§6Übersicht").build());
                    inv.setItem(15, new ItemBuilder(Material.MAP).setName("§aSpielregel").setLore("", "§aSpielregeln §7sind die normale", "§a/gamerule§7s und weitere", "§aVeränderungen §7des Spielgeschehens", "§7mit normalen Mitteln von Minecraft.", " ", "§a§oKlick §r§aÜbersicht").build());

                    inv.setItem(16, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                    inv.setItem(17, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                    inv.setItem(18, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                    inv.setItem(19, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                    inv.setItem(20, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                    inv.setItem(21, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                    inv.setItem(22, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                    inv.setItem(23, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                    inv.setItem(24, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                    inv.setItem(25, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                    inv.setItem(26, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());

                    player.openInventory(inv);
                    event.setCancelled(true);
                    break;
                case WITHER_SKELETON_SKULL:
                    GameStateManager.killWither = true;
                    GameStateManager.killElderGuardian = false;
                    GameStateManager.killEnderdragon = false;

                    Inventory b2 = Bukkit.createInventory(null, 9, "§6Einstellungen §8● §cBedingungen");
                    b2.setItem(0, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    b2.setItem(1, new ItemBuilder(Material.DRAGON_EGG).setName("§cEnderdrache").setLore(" ", " §cTöte §7den §cEnderdrachen", " §7um die aktuelle", " §cChallenge §7zu §cbeenden", " ", " §9§nStatus:", " §4deaktiviert").build());
                    b2.setItem(2, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    b2.setItem(3, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    b2.setItem(4, new ItemBuilder(Material.WITHER_SKELETON_SKULL).setName("§cWither").setLore(" ", " §cTöte §7den §cWither", " §7um die aktuelle", " §cChallenge §7zu beenden", " ", " §9§nStatus:", " §aaktiviert").build());
                    b2.setItem(5, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    b2.setItem(6, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    b2.setItem(7, new ItemBuilder(Material.PRISMARINE_SHARD).setName("§cGroßer Tempelwächter").setLore(" ", " §cTöte §7den §cWither", " §7um die aktuelle", " §cChallenge §7zu beenden", " ", " §9§nStatus:", " §4deaktiviert").build());
                    b2.setItem(8, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());

                    player.playSound(player.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 2F, 1F);

                    player.openInventory(b2);
                    event.setCancelled(true);
                    break;
                case PRISMARINE_SHARD:
                    GameStateManager.killElderGuardian = true;
                    GameStateManager.killEnderdragon = false;
                    GameStateManager.killWither = false;

                    player.playSound(player.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 2F, 1F);

                    Inventory b3 = Bukkit.createInventory(null, 9, "§6Einstellungen §8● §cBedingungen");
                    b3.setItem(0, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    b3.setItem(1, new ItemBuilder(Material.DRAGON_EGG).setName("§cEnderdrache").setLore(" ", " §cTöte §7den §cEnderdrachen", " §7um die aktuelle", " §cChallenge §7zu §cbeenden", " ", " §9§nStatus:", " §4deaktiviert").build());
                    b3.setItem(2, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    b3.setItem(3, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    b3.setItem(4, new ItemBuilder(Material.WITHER_SKELETON_SKULL).setName("§cWither").setLore(" ", " §cTöte §7den §cWither", " §7um die aktuelle", " §cChallenge §7zu beenden", " ", " §9§nStatus:", " §4deaktiviert").build());
                    b3.setItem(5, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    b3.setItem(6, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    b3.setItem(7, new ItemBuilder(Material.PRISMARINE_SHARD).setName("§cGroßer Tempelwächter").setLore(" ", " §cTöte §7den §cWither", " §7um die aktuelle", " §cChallenge §7zu beenden", " ", " §9§nStatus:", " §aaktiviert").build());
                    b3.setItem(8, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());

                    player.openInventory(b3);
                    event.setCancelled(true);
                    break;
            }
        } else if(event.getView().getTitle().equals("§6Einstellungen §8● §6Funktionen")) {
            switch (event.getCurrentItem().getType()) {
                case IRON_SWORD:
                    if(GameStateManager.printDmg) {
                        GameStateManager.printDmg = false;
                        player.playSound(player.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 2F, 1F);
                    } else {
                        GameStateManager.printDmg = true;
                        player.playSound(player.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 2F, 1F);
                    }
                    event.setCancelled(true);
                    Inventory f = Bukkit.createInventory(null, 36, "§6Einstellungen §8● §6Funktionen");
                    f.setItem(0, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(1, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(2, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(3, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(4, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(5, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(6, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(7, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(8, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(9, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    if(GameStateManager.printDmg) {
                        f.setItem(10, new ItemBuilder(Material.IRON_SWORD).setName("§6Schaden in den Chat").setLore(" ", "§6§nBeschreibung§r§7:", " §7Diese Funktion schreibt den", " §6Schaden §7in den §6Chat§7.", " ", "§6§nEigenschaften§r§7:", "§7 Typ§8: §6Funktion", " §7Status§8: §2aktiviert", " ", "§6§oLinksklick §r§7Status ändern", "§6§oRechtsklick §r§7Einstellungen", " ").build());
                    } else {
                        f.setItem(10, new ItemBuilder(Material.IRON_SWORD).setName("§6Schaden in den Chat").setLore(" ", "§6§nBeschreibung§r§7:", " §7Diese Funktion schreibt den", " §6Schaden §7in den §6Chat§7.", " ", "§6§nEigenschaften§r§7:", "§7 Typ§8: §6Funktion", " §7Status§8: §4deaktiviert", " ", "§6§oLinksklick §r§7Status ändern", "§6§oRechtsklick §r§7Einstellungen", " ").build());
                    }
                    if(GameStateManager.dmgTab) {
                        f.setItem(11, new ItemBuilder(Material.APPLE).setName("§6Spieler Gesundheit in der Tablist").setLore(" ", "§6§nBeschreibung§r§7:", " §7Diese Funktion zeigt die", " §6Gesundheit der Spieler §7in der §6Tablist§7.", " ", "§6§nEigenschaften§r§7:", "§7 Typ§8: §6Funktion", " §7Status§8: §2aktiviert", " ", "§6§oLinksklick §r§7Status ändern", "§6§oRechtsklick §r§7Einstellungen", " ").build());
                    } else {
                        f.setItem(11, new ItemBuilder(Material.APPLE).setName("§6Spieler Gesundheit in der Tablist").setLore(" ", "§6§nBeschreibung§r§7:", " §7Diese Funktion zeigt die", " §6Gesundheit der Spieler §7in der §6Tablist§7.", " ", "§6§nEigenschaften§r§7:", "§7 Typ§8: §6Funktion", " §7Status§8: §4deaktiviert", " ", "§6§oLinksklick §r§7Status ändern", "§6§oRechtsklick §r§7Einstellungen", " ").build());
                    }
                    f.setItem(12, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(13, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(14, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(15, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(16, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(17, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(18, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(19, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(20, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(21, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(22, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(23, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(24, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(25, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(26, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(27, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(28, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(29, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(30, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(31, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(32, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(33, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(34, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f.setItem(35, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    player.openInventory(f);
                    break;
                case APPLE:
                    if(GameStateManager.dmgTab) {
                        GameStateManager.dmgTab = false;
                        player.playSound(player.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 2F, 1F);
                    } else {
                        GameStateManager.dmgTab = true;
                        TabHealth.showHealthInTab();
                        player.playSound(player.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 2F, 1F);
                    }
                    event.setCancelled(true);
                    Inventory f2 = Bukkit.createInventory(null, 36, "§6Einstellungen §8● §6Funktionen");
                    f2.setItem(0, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f2.setItem(1, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f2.setItem(2, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f2.setItem(3, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f2.setItem(4, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f2.setItem(5, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f2.setItem(6, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f2.setItem(7, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f2.setItem(8, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f2.setItem(9, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    if(GameStateManager.printDmg) {
                        f2.setItem(10, new ItemBuilder(Material.IRON_SWORD).setName("§6Schaden in den Chat").setLore(" ", "§6§nBeschreibung§r§7:", " §7Diese Funktion schreibt den", " §6Schaden §7in den §6Chat§7.", " ", "§6§nEigenschaften§r§7:", "§7 Typ§8: §6Funktion", " §7Status§8: §2aktiviert", " ", "§6§oLinksklick §r§7Status ändern", "§6§oRechtsklick §r§7Einstellungen", " ").build());
                    } else {
                        f2.setItem(10, new ItemBuilder(Material.IRON_SWORD).setName("§6Schaden in den Chat").setLore(" ", "§6§nBeschreibung§r§7:", " §7Diese Funktion schreibt den", " §6Schaden §7in den §6Chat§7.", " ", "§6§nEigenschaften§r§7:", "§7 Typ§8: §6Funktion", " §7Status§8: §4deaktiviert", " ", "§6§oLinksklick §r§7Status ändern", "§6§oRechtsklick §r§7Einstellungen", " ").build());
                    }
                    if(GameStateManager.dmgTab) {
                        f2.setItem(11, new ItemBuilder(Material.APPLE).setName("§6Spieler Gesundheit in der Tablist").setLore(" ", "§6§nBeschreibung§r§7:", " §7Diese Funktion zeigt die", " §6Gesundheit der Spieler §7in der §6Tablist§7.", " ", "§6§nEigenschaften§r§7:", "§7 Typ§8: §6Funktion", " §7Status§8: §2aktiviert", " ", "§6§oLinksklick §r§7Status ändern", "§6§oRechtsklick §r§7Einstellungen", " ").build());
                    } else {
                        f2.setItem(11, new ItemBuilder(Material.APPLE).setName("§6Spieler Gesundheit in der Tablist").setLore(" ", "§6§nBeschreibung§r§7:", " §7Diese Funktion zeigt die", " §6Gesundheit der Spieler §7in der §6Tablist§7.", " ", "§6§nEigenschaften§r§7:", "§7 Typ§8: §6Funktion", " §7Status§8: §4deaktiviert", " ", "§6§oLinksklick §r§7Status ändern", "§6§oRechtsklick §r§7Einstellungen", " ").build());
                    }
                    f2.setItem(12, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f2.setItem(13, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f2.setItem(14, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f2.setItem(15, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f2.setItem(16, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f2.setItem(17, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f2.setItem(18, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f2.setItem(19, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f2.setItem(20, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f2.setItem(21, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f2.setItem(22, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f2.setItem(23, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f2.setItem(24, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f2.setItem(25, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f2.setItem(26, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f2.setItem(27, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f2.setItem(28, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f2.setItem(29, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f2.setItem(30, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f2.setItem(31, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f2.setItem(32, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f2.setItem(33, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f2.setItem(34, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    f2.setItem(35, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                    player.openInventory(f2);
                    break;
                default:
                    event.setCancelled(true);

                    Inventory inv = Bukkit.createInventory(null, 27, "§6Einstellungen §8● §9Übersicht");
                    inv.setItem(0, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                    inv.setItem(1, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                    inv.setItem(2, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                    inv.setItem(3, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                    inv.setItem(4, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                    inv.setItem(5, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                    inv.setItem(6, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                    inv.setItem(7, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                    inv.setItem(8, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());

                    inv.setItem(9, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                    inv.setItem(10, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());

                    inv.setItem(11, new ItemBuilder(Material.DRAGON_HEAD).setName("§cBedingungen").setLore(" ", " §7Lege die §cBedingung", " §7für den §cSieg §7einer", " §cChallenge §7fest", " ", " §c§oKlick§7§o: §r§cÜbersicht").build());
                    inv.setItem(12, new ItemBuilder(Material.GRASS_BLOCK).setName("§bSpieländerung").setLore(" ", " §7Spieländerungen §bverändern", " §7das §bSpielgeschehen §7auf", " §7vielen Art und Weisen.", " ", " §b§oKlick §r§bÜbersicht").build());

                    inv.setItem(13, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());

                    inv.setItem(14, new ItemBuilder(Material.IRON_PICKAXE).setName("§6Funktion").setLore(" ", "§6Funktionen §7sind Modifikationen,", "§7welche §6kosmetisch §7und §6funktionell", "§7sind und das Spielgeschehen", "§6nicht beeinflussen§7.", " ", "§6§oKlick §r§6Übersicht").build());
                    inv.setItem(15, new ItemBuilder(Material.MAP).setName("§aSpielregel").setLore("", "§aSpielregeln §7sind die normale", "§a/gamerule§7s und weitere", "§aVeränderungen §7des Spielgeschehens", "§7mit normalen Mitteln von Minecraft.", " ", "§a§oKlick §r§aÜbersicht").build());

                    inv.setItem(16, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                    inv.setItem(17, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                    inv.setItem(18, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                    inv.setItem(19, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                    inv.setItem(20, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                    inv.setItem(21, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                    inv.setItem(22, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                    inv.setItem(23, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                    inv.setItem(24, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                    inv.setItem(25, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                    inv.setItem(26, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());

                    player.openInventory(inv);
                    break;
            }
        }

        }
    @EventHandler
    public void handleClick(InventoryClickEvent event) {
        if(!(event.getWhoClicked() instanceof Player)) return;
        Player player = (Player) event.getWhoClicked();
            if(event.getView().getTitle().equals("§6Einstellungen §8● §aSpielregeln")) {

                switch (event.getCurrentItem().getType()) {

                    case GOLDEN_APPLE:
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.NATURAL_REGENERATION)) {
                            Bukkit.getWorld(player.getWorld().getUID()).setGameRuleValue("naturalRegeneration", "false");
                            player.sendMessage(Main.getPrefix() + "§7Die Spielregel §4NaturalRegeneration §7wurde §cdeaktiviert§7.");
                            GameStateManager.naturalRegeneration = false;
                        } else {
                            Bukkit.getWorld(player.getWorld().getUID()).setGameRuleValue("naturalRegeneration", "true");
                            player.sendMessage(Main.getPrefix() + "§7Die Spielregel §4NaturalRegeneration §7wurde §aaktiviert§7.");
                            GameStateManager.naturalRegeneration = true;
                        }
                        player.playSound(player.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 2F, 1F);
                        event.setCancelled(true);

                        Inventory gm = Bukkit.createInventory(null, 36, "§6Einstellungen §8● §aSpielregeln");
                        gm.setItem(0, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm.setItem(1, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm.setItem(2, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm.setItem(3, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm.setItem(4, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm.setItem(5, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm.setItem(6, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm.setItem(7, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm.setItem(8, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm.setItem(9, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.NATURAL_REGENERATION)) {
                            gm.setItem(10, new ItemBuilder(Material.GOLDEN_APPLE).setName("§aNaturalRegeneration").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7die §anatürliche Regeneration §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm.setItem(10, new ItemBuilder(Material.GOLDEN_APPLE).setName("§aNaturalRegeneration").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7die §anatürliche Regeneration §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.KEEP_INVENTORY)) {
                            gm.setItem(11, new ItemBuilder(Material.CHEST).setName("§aKeepInventory").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das §abehalten §7des §aInventars §7nach dem Tod um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm.setItem(11, new ItemBuilder(Material.CHEST).setName("§aKeepInventory").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das §abehalten §7des §aInventars §7nach dem Tod um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_WEATHER_CYCLE)) {
                            gm.setItem(12, new ItemBuilder(Material.WATER_BUCKET).setName("§aDoWeatherCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Wetter §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm.setItem(12, new ItemBuilder(Material.WATER_BUCKET).setName("§aDoWeatherCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Wetter §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_INSOMNIA)) {
                            gm.setItem(13, new ItemBuilder(Material.PHANTOM_MEMBRANE).setName("§aDoInsomnia").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPhantomen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm.setItem(13, new ItemBuilder(Material.PHANTOM_MEMBRANE).setName("§aDoInsomnia").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPhantomen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_DAYLIGHT_CYCLE)) {
                            gm.setItem(14, new ItemBuilder(Material.CLOCK).setName("§aDoDaylightCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Tages §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm.setItem(14, new ItemBuilder(Material.CLOCK).setName("§aDoDaylightCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Tages §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_TRADER_SPAWNING)) {
                            gm.setItem(15, new ItemBuilder(Material.LEAD).setName("§aSpawnWanderingTrader").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen vom §awandernden Händler §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm.setItem(15, new ItemBuilder(Material.LEAD).setName("§aSpawnWanderingTrader").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen vom §awandernden Händler §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_PATROL_SPAWNING)) {
                            gm.setItem(16, new ItemBuilder(Material.CROSSBOW).setName("§aSpawnPatrolls").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPillager patrollien §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm.setItem(16, new ItemBuilder(Material.CROSSBOW).setName("§aSpawnPatrolls").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPillager patrollien §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        gm.setItem(17, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm.setItem(18, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.FALL_DAMAGE)) {
                            gm.setItem(19, new ItemBuilder(Material.DIAMOND_BOOTS).setName("§aFallDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aFallschaden §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm.setItem(19, new ItemBuilder(Material.DIAMOND_BOOTS).setName("§aFallDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aFallschaden §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_MOB_LOOT)) {
                            gm.setItem(20, new ItemBuilder(Material.ROTTEN_FLESH).setName("§aDoMobLoot").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aMob Drops §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm.setItem(20, new ItemBuilder(Material.ROTTEN_FLESH).setName("§aDoMobLoot").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aMob Drops §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_MOB_SPAWNING)) {
                            gm.setItem(21, new ItemBuilder(Material.ZOMBIE_HEAD).setName("§aDoMobSpawning").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von diversen §aMobs §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm.setItem(21, new ItemBuilder(Material.ZOMBIE_HEAD).setName("§aDoMobSpawning").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von diversen §aMobs §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DISABLE_RAIDS)) {
                            gm.setItem(22, new ItemBuilder(Material.PILLAGER_SPAWN_EGG).setName("§aDisableRaids").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aüberfällen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm.setItem(22, new ItemBuilder(Material.PILLAGER_SPAWN_EGG).setName("§aDisableRaids").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aüberfällen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DROWNING_DAMAGE)) {
                            gm.setItem(23, new ItemBuilder(Material.TRIDENT).setName("§aDrowningDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Schaden beim §aErtrinken §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm.setItem(23, new ItemBuilder(Material.TRIDENT).setName("§aDrowningDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Schaden beim §aErtrinken §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.FIRE_DAMAGE)) {
                            gm.setItem(24, new ItemBuilder(Material.FIRE_CHARGE).setName("§aFireDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den §aFeuer §7Schaden um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm.setItem(24, new ItemBuilder(Material.FIRE_CHARGE).setName("§aFireDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den §aFeuer §7Schaden um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_FIRE_TICK)) {
                            gm.setItem(25, new ItemBuilder(Material.FLINT_AND_STEEL).setName("§aDoFireTick").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7feuer §aausbreiten §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm.setItem(25, new ItemBuilder(Material.FLINT_AND_STEEL).setName("§aDoFireTick").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7feuer §aausbreiten §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        gm.setItem(26, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm.setItem(27, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm.setItem(28, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm.setItem(29, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm.setItem(30, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm.setItem(31, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm.setItem(32, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm.setItem(33, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm.setItem(34, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm.setItem(35, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        player.openInventory(gm);
                        break;
                    case CHEST:
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.KEEP_INVENTORY)) {
                            Bukkit.getWorld(player.getWorld().getUID()).setGameRuleValue("keepInventory", "false");
                            player.sendMessage(Main.getPrefix() + "§7Die Spielregel §4KeepInventory §7wurde §cdeaktiviert§7.");
                            GameStateManager.keepInventory = false;
                        } else {
                            Bukkit.getWorld(player.getWorld().getUID()).setGameRuleValue("keepInventory", "true");
                            player.sendMessage(Main.getPrefix() + "§7Die Spielregel §4KeepInventory §7wurde §aaktiviert§7.");
                            GameStateManager.keepInventory = true;
                        }
                        player.playSound(player.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 2F, 1F);
                        event.setCancelled(true);

                        Inventory gm2 = Bukkit.createInventory(null, 36, "§6Einstellungen §8● §aSpielregeln");
                        gm2.setItem(0, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm2.setItem(1, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm2.setItem(2, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm2.setItem(3, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm2.setItem(4, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm2.setItem(5, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm2.setItem(6, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm2.setItem(7, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm2.setItem(8, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm2.setItem(9, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.NATURAL_REGENERATION)) {
                            gm2.setItem(10, new ItemBuilder(Material.GOLDEN_APPLE).setName("§aNaturalRegeneration").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7die §anatürliche Regeneration §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm2.setItem(10, new ItemBuilder(Material.GOLDEN_APPLE).setName("§aNaturalRegeneration").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7die §anatürliche Regeneration §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.KEEP_INVENTORY)) {
                            gm2.setItem(11, new ItemBuilder(Material.CHEST).setName("§aKeepInventory").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das §abehalten §7des §aInventars §7nach dem Tod um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm2.setItem(11, new ItemBuilder(Material.CHEST).setName("§aKeepInventory").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das §abehalten §7des §aInventars §7nach dem Tod um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_WEATHER_CYCLE)) {
                            gm2.setItem(12, new ItemBuilder(Material.WATER_BUCKET).setName("§aDoWeatherCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Wetter §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm2.setItem(12, new ItemBuilder(Material.WATER_BUCKET).setName("§aDoWeatherCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Wetter §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_INSOMNIA)) {
                            gm2.setItem(13, new ItemBuilder(Material.PHANTOM_MEMBRANE).setName("§aDoInsomnia").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPhantomen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm2.setItem(13, new ItemBuilder(Material.PHANTOM_MEMBRANE).setName("§aDoInsomnia").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPhantomen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_DAYLIGHT_CYCLE)) {
                            gm2.setItem(14, new ItemBuilder(Material.CLOCK).setName("§aDoDaylightCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Tages §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm2.setItem(14, new ItemBuilder(Material.CLOCK).setName("§aDoDaylightCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Tages §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_TRADER_SPAWNING)) {
                            gm2.setItem(15, new ItemBuilder(Material.LEAD).setName("§aSpawnWanderingTrader").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen vom §awandernden Händler §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm2.setItem(15, new ItemBuilder(Material.LEAD).setName("§aSpawnWanderingTrader").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen vom §awandernden Händler §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_PATROL_SPAWNING)) {
                            gm2.setItem(16, new ItemBuilder(Material.CROSSBOW).setName("§aSpawnPatrolls").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPillager patrollien §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm2.setItem(16, new ItemBuilder(Material.CROSSBOW).setName("§aSpawnPatrolls").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPillager patrollien §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        gm2.setItem(17, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm2.setItem(18, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.FALL_DAMAGE)) {
                            gm2.setItem(19, new ItemBuilder(Material.DIAMOND_BOOTS).setName("§aFallDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aFallschaden §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm2.setItem(19, new ItemBuilder(Material.DIAMOND_BOOTS).setName("§aFallDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aFallschaden §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_MOB_LOOT)) {
                            gm2.setItem(20, new ItemBuilder(Material.ROTTEN_FLESH).setName("§aDoMobLoot").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aMob Drops §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm2.setItem(20, new ItemBuilder(Material.ROTTEN_FLESH).setName("§aDoMobLoot").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aMob Drops §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_MOB_SPAWNING)) {
                            gm2.setItem(21, new ItemBuilder(Material.ZOMBIE_HEAD).setName("§aDoMobSpawning").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von diversen §aMobs §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm2.setItem(21, new ItemBuilder(Material.ZOMBIE_HEAD).setName("§aDoMobSpawning").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von diversen §aMobs §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DISABLE_RAIDS)) {
                            gm2.setItem(22, new ItemBuilder(Material.PILLAGER_SPAWN_EGG).setName("§aDisableRaids").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aüberfällen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm2.setItem(22, new ItemBuilder(Material.PILLAGER_SPAWN_EGG).setName("§aDisableRaids").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aüberfällen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DROWNING_DAMAGE)) {
                            gm2.setItem(23, new ItemBuilder(Material.TRIDENT).setName("§aDrowningDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Schaden beim §aErtrinken §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm2.setItem(23, new ItemBuilder(Material.TRIDENT).setName("§aDrowningDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Schaden beim §aErtrinken §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.FIRE_DAMAGE)) {
                            gm2.setItem(24, new ItemBuilder(Material.FIRE_CHARGE).setName("§aFireDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den §aFeuer §7Schaden um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm2.setItem(24, new ItemBuilder(Material.FIRE_CHARGE).setName("§aFireDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den §aFeuer §7Schaden um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_FIRE_TICK)) {
                            gm2.setItem(25, new ItemBuilder(Material.FLINT_AND_STEEL).setName("§aDoFireTick").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7feuer §aausbreiten §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm2.setItem(25, new ItemBuilder(Material.FLINT_AND_STEEL).setName("§aDoFireTick").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7feuer §aausbreiten §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        gm2.setItem(26, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm2.setItem(27, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm2.setItem(28, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm2.setItem(29, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm2.setItem(30, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm2.setItem(31, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm2.setItem(32, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm2.setItem(33, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm2.setItem(34, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm2.setItem(35, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        player.openInventory(gm2);
                        break;
                    case WATER_BUCKET:
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_WEATHER_CYCLE)) {
                            Bukkit.getWorld(player.getWorld().getUID()).setGameRuleValue("doWeatherCycle", "false");
                            player.sendMessage(Main.getPrefix() + "§7Die Spielregel §4DoWeatherCycle §7wurde §cdeaktiviert§7.");
                            GameStateManager.doWeatherCycle = false;
                        } else {
                            Bukkit.getWorld(player.getWorld().getUID()).setGameRuleValue("doWeatherCycle", "true");
                            player.sendMessage(Main.getPrefix() + "§7Die Spielregel §4DoWeatherCycle §7wurde §aaktiviert§7.");
                            GameStateManager.doWeatherCycle = true;
                        }
                        player.playSound(player.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 2F, 1F);
                        event.setCancelled(true);

                        Inventory gm3 = Bukkit.createInventory(null, 36, "§6Einstellungen §8● §aSpielregeln");
                        gm3.setItem(0, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm3.setItem(1, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm3.setItem(2, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm3.setItem(3, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm3.setItem(4, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm3.setItem(5, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm3.setItem(6, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm3.setItem(7, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm3.setItem(8, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm3.setItem(9, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.NATURAL_REGENERATION)) {
                            gm3.setItem(10, new ItemBuilder(Material.GOLDEN_APPLE).setName("§aNaturalRegeneration").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7die §anatürliche Regeneration §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm3.setItem(10, new ItemBuilder(Material.GOLDEN_APPLE).setName("§aNaturalRegeneration").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7die §anatürliche Regeneration §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.KEEP_INVENTORY)) {
                            gm3.setItem(11, new ItemBuilder(Material.CHEST).setName("§aKeepInventory").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das §abehalten §7des §aInventars §7nach dem Tod um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm3.setItem(11, new ItemBuilder(Material.CHEST).setName("§aKeepInventory").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das §abehalten §7des §aInventars §7nach dem Tod um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_WEATHER_CYCLE)) {
                            gm3.setItem(12, new ItemBuilder(Material.WATER_BUCKET).setName("§aDoWeatherCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Wetter §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm3.setItem(12, new ItemBuilder(Material.WATER_BUCKET).setName("§aDoWeatherCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Wetter §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_INSOMNIA)) {
                            gm3.setItem(13, new ItemBuilder(Material.PHANTOM_MEMBRANE).setName("§aDoInsomnia").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPhantomen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm3.setItem(13, new ItemBuilder(Material.PHANTOM_MEMBRANE).setName("§aDoInsomnia").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPhantomen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_DAYLIGHT_CYCLE)) {
                            gm3.setItem(14, new ItemBuilder(Material.CLOCK).setName("§aDoDaylightCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Tages §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm3.setItem(14, new ItemBuilder(Material.CLOCK).setName("§aDoDaylightCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Tages §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_TRADER_SPAWNING)) {
                            gm3.setItem(15, new ItemBuilder(Material.LEAD).setName("§aSpawnWanderingTrader").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen vom §awandernden Händler §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm3.setItem(15, new ItemBuilder(Material.LEAD).setName("§aSpawnWanderingTrader").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen vom §awandernden Händler §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_PATROL_SPAWNING)) {
                            gm3.setItem(16, new ItemBuilder(Material.CROSSBOW).setName("§aSpawnPatrolls").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPillager patrollien §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm3.setItem(16, new ItemBuilder(Material.CROSSBOW).setName("§aSpawnPatrolls").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPillager patrollien §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        gm3.setItem(17, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm3.setItem(18, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.FALL_DAMAGE)) {
                            gm3.setItem(19, new ItemBuilder(Material.DIAMOND_BOOTS).setName("§aFallDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aFallschaden §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm3.setItem(19, new ItemBuilder(Material.DIAMOND_BOOTS).setName("§aFallDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aFallschaden §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_MOB_LOOT)) {
                            gm3.setItem(20, new ItemBuilder(Material.ROTTEN_FLESH).setName("§aDoMobLoot").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aMob Drops §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm3.setItem(20, new ItemBuilder(Material.ROTTEN_FLESH).setName("§aDoMobLoot").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aMob Drops §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_MOB_SPAWNING)) {
                            gm3.setItem(21, new ItemBuilder(Material.ZOMBIE_HEAD).setName("§aDoMobSpawning").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von diversen §aMobs §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm3.setItem(21, new ItemBuilder(Material.ZOMBIE_HEAD).setName("§aDoMobSpawning").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von diversen §aMobs §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DISABLE_RAIDS)) {
                            gm3.setItem(22, new ItemBuilder(Material.PILLAGER_SPAWN_EGG).setName("§aDisableRaids").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aüberfällen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm3.setItem(22, new ItemBuilder(Material.PILLAGER_SPAWN_EGG).setName("§aDisableRaids").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aüberfällen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DROWNING_DAMAGE)) {
                            gm3.setItem(23, new ItemBuilder(Material.TRIDENT).setName("§aDrowningDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Schaden beim §aErtrinken §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm3.setItem(23, new ItemBuilder(Material.TRIDENT).setName("§aDrowningDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Schaden beim §aErtrinken §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.FIRE_DAMAGE)) {
                            gm3.setItem(24, new ItemBuilder(Material.FIRE_CHARGE).setName("§aFireDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den §aFeuer §7Schaden um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm3.setItem(24, new ItemBuilder(Material.FIRE_CHARGE).setName("§aFireDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den §aFeuer §7Schaden um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_FIRE_TICK)) {
                            gm3.setItem(25, new ItemBuilder(Material.FLINT_AND_STEEL).setName("§aDoFireTick").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7feuer §aausbreiten §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm3.setItem(25, new ItemBuilder(Material.FLINT_AND_STEEL).setName("§aDoFireTick").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7feuer §aausbreiten §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        gm3.setItem(26, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm3.setItem(27, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm3.setItem(28, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm3.setItem(29, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm3.setItem(30, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm3.setItem(31, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm3.setItem(32, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm3.setItem(33, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm3.setItem(34, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm3.setItem(35, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        player.openInventory(gm3);
                        break;
                    case PHANTOM_MEMBRANE:
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_INSOMNIA)) {
                            Bukkit.getWorld(player.getWorld().getUID()).setGameRuleValue("doInsomnia", "false");
                            player.sendMessage(Main.getPrefix() + "§7Die Spielregel §4DoInsomnia §7wurde §cdeaktiviert§7.");
                            GameStateManager.doInsomnia = false;
                        } else {
                            Bukkit.getWorld(player.getWorld().getUID()).setGameRuleValue("doInsomnia", "true");
                            player.sendMessage(Main.getPrefix() + "§7Die Spielregel §4DoInsomnia §7wurde §aaktiviert§7.");
                            GameStateManager.doInsomnia = true;
                        }
                        player.playSound(player.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 2F, 1F);
                        event.setCancelled(true);

                        Inventory gm4 = Bukkit.createInventory(null, 36, "§6Einstellungen §8● §aSpielregeln");
                        gm4.setItem(0, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm4.setItem(1, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm4.setItem(2, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm4.setItem(3, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm4.setItem(4, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm4.setItem(5, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm4.setItem(6, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm4.setItem(7, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm4.setItem(8, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm4.setItem(9, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.NATURAL_REGENERATION)) {
                            gm4.setItem(10, new ItemBuilder(Material.GOLDEN_APPLE).setName("§aNaturalRegeneration").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7die §anatürliche Regeneration §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm4.setItem(10, new ItemBuilder(Material.GOLDEN_APPLE).setName("§aNaturalRegeneration").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7die §anatürliche Regeneration §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.KEEP_INVENTORY)) {
                            gm4.setItem(11, new ItemBuilder(Material.CHEST).setName("§aKeepInventory").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das §abehalten §7des §aInventars §7nach dem Tod um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm4.setItem(11, new ItemBuilder(Material.CHEST).setName("§aKeepInventory").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das §abehalten §7des §aInventars §7nach dem Tod um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_WEATHER_CYCLE)) {
                            gm4.setItem(12, new ItemBuilder(Material.WATER_BUCKET).setName("§aDoWeatherCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Wetter §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm4.setItem(12, new ItemBuilder(Material.WATER_BUCKET).setName("§aDoWeatherCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Wetter §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_INSOMNIA)) {
                            gm4.setItem(13, new ItemBuilder(Material.PHANTOM_MEMBRANE).setName("§aDoInsomnia").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPhantomen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm4.setItem(13, new ItemBuilder(Material.PHANTOM_MEMBRANE).setName("§aDoInsomnia").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPhantomen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_DAYLIGHT_CYCLE)) {
                            gm4.setItem(14, new ItemBuilder(Material.CLOCK).setName("§aDoDaylightCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Tages §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm4.setItem(14, new ItemBuilder(Material.CLOCK).setName("§aDoDaylightCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Tages §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_TRADER_SPAWNING)) {
                            gm4.setItem(15, new ItemBuilder(Material.LEAD).setName("§aSpawnWanderingTrader").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen vom §awandernden Händler §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm4.setItem(15, new ItemBuilder(Material.LEAD).setName("§aSpawnWanderingTrader").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen vom §awandernden Händler §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_PATROL_SPAWNING)) {
                            gm4.setItem(16, new ItemBuilder(Material.CROSSBOW).setName("§aSpawnPatrolls").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPillager patrollien §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm4.setItem(16, new ItemBuilder(Material.CROSSBOW).setName("§aSpawnPatrolls").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPillager patrollien §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        gm4.setItem(17, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm4.setItem(18, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.FALL_DAMAGE)) {
                            gm4.setItem(19, new ItemBuilder(Material.DIAMOND_BOOTS).setName("§aFallDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aFallschaden §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm4.setItem(19, new ItemBuilder(Material.DIAMOND_BOOTS).setName("§aFallDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aFallschaden §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_MOB_LOOT)) {
                            gm4.setItem(20, new ItemBuilder(Material.ROTTEN_FLESH).setName("§aDoMobLoot").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aMob Drops §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm4.setItem(20, new ItemBuilder(Material.ROTTEN_FLESH).setName("§aDoMobLoot").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aMob Drops §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_MOB_SPAWNING)) {
                            gm4.setItem(21, new ItemBuilder(Material.ZOMBIE_HEAD).setName("§aDoMobSpawning").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von diversen §aMobs §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm4.setItem(21, new ItemBuilder(Material.ZOMBIE_HEAD).setName("§aDoMobSpawning").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von diversen §aMobs §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DISABLE_RAIDS)) {
                            gm4.setItem(22, new ItemBuilder(Material.PILLAGER_SPAWN_EGG).setName("§aDisableRaids").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aüberfällen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm4.setItem(22, new ItemBuilder(Material.PILLAGER_SPAWN_EGG).setName("§aDisableRaids").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aüberfällen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DROWNING_DAMAGE)) {
                            gm4.setItem(23, new ItemBuilder(Material.TRIDENT).setName("§aDrowningDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Schaden beim §aErtrinken §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm4.setItem(23, new ItemBuilder(Material.TRIDENT).setName("§aDrowningDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Schaden beim §aErtrinken §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.FIRE_DAMAGE)) {
                            gm4.setItem(24, new ItemBuilder(Material.FIRE_CHARGE).setName("§aFireDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den §aFeuer §7Schaden um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm4.setItem(24, new ItemBuilder(Material.FIRE_CHARGE).setName("§aFireDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den §aFeuer §7Schaden um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_FIRE_TICK)) {
                            gm4.setItem(25, new ItemBuilder(Material.FLINT_AND_STEEL).setName("§aDoFireTick").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7feuer §aausbreiten §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm4.setItem(25, new ItemBuilder(Material.FLINT_AND_STEEL).setName("§aDoFireTick").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7feuer §aausbreiten §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        gm4.setItem(26, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm4.setItem(27, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm4.setItem(28, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm4.setItem(29, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm4.setItem(30, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm4.setItem(31, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm4.setItem(32, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm4.setItem(33, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm4.setItem(34, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm4.setItem(35, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        player.openInventory(gm4);
                        break;
                    case CLOCK:
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_DAYLIGHT_CYCLE)) {
                            Bukkit.getWorld(player.getWorld().getUID()).setGameRuleValue("doDaylightCycle", "false");
                            player.sendMessage(Main.getPrefix() + "§7Die Spielregel §4DoDaylightCycle §7wurde §cdeaktiviert§7.");
                            GameStateManager.doDailightCycle = false;
                        } else {
                            Bukkit.getWorld(player.getWorld().getUID()).setGameRuleValue("doDaylightCycle", "true");
                            player.sendMessage(Main.getPrefix() + "§7Die Spielregel §4DoDaylightCycle §7wurde §aaktiviert§7.");
                            GameStateManager.doDailightCycle = true;
                        }
                        player.playSound(player.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 2F, 1F);
                        event.setCancelled(true);

                        Inventory gm5 = Bukkit.createInventory(null, 36, "§6Einstellungen §8● §aSpielregeln");
                        gm5.setItem(0, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm5.setItem(1, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm5.setItem(2, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm5.setItem(3, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm5.setItem(4, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm5.setItem(5, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm5.setItem(6, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm5.setItem(7, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm5.setItem(8, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm5.setItem(9, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.NATURAL_REGENERATION)) {
                            gm5.setItem(10, new ItemBuilder(Material.GOLDEN_APPLE).setName("§aNaturalRegeneration").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7die §anatürliche Regeneration §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm5.setItem(10, new ItemBuilder(Material.GOLDEN_APPLE).setName("§aNaturalRegeneration").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7die §anatürliche Regeneration §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.KEEP_INVENTORY)) {
                            gm5.setItem(11, new ItemBuilder(Material.CHEST).setName("§aKeepInventory").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das §abehalten §7des §aInventars §7nach dem Tod um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm5.setItem(11, new ItemBuilder(Material.CHEST).setName("§aKeepInventory").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das §abehalten §7des §aInventars §7nach dem Tod um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_WEATHER_CYCLE)) {
                            gm5.setItem(12, new ItemBuilder(Material.WATER_BUCKET).setName("§aDoWeatherCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Wetter §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm5.setItem(12, new ItemBuilder(Material.WATER_BUCKET).setName("§aDoWeatherCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Wetter §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_INSOMNIA)) {
                            gm5.setItem(13, new ItemBuilder(Material.PHANTOM_MEMBRANE).setName("§aDoInsomnia").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPhantomen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm5.setItem(13, new ItemBuilder(Material.PHANTOM_MEMBRANE).setName("§aDoInsomnia").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPhantomen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_DAYLIGHT_CYCLE)) {
                            gm5.setItem(14, new ItemBuilder(Material.CLOCK).setName("§aDoDaylightCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Tages §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm5.setItem(14, new ItemBuilder(Material.CLOCK).setName("§aDoDaylightCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Tages §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_TRADER_SPAWNING)) {
                            gm5.setItem(15, new ItemBuilder(Material.LEAD).setName("§aSpawnWanderingTrader").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen vom §awandernden Händler §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm5.setItem(15, new ItemBuilder(Material.LEAD).setName("§aSpawnWanderingTrader").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen vom §awandernden Händler §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_PATROL_SPAWNING)) {
                            gm5.setItem(16, new ItemBuilder(Material.CROSSBOW).setName("§aSpawnPatrolls").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPillager patrollien §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm5.setItem(16, new ItemBuilder(Material.CROSSBOW).setName("§aSpawnPatrolls").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPillager patrollien §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        gm5.setItem(17, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm5.setItem(18, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.FALL_DAMAGE)) {
                            gm5.setItem(19, new ItemBuilder(Material.DIAMOND_BOOTS).setName("§aFallDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aFallschaden §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm5.setItem(19, new ItemBuilder(Material.DIAMOND_BOOTS).setName("§aFallDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aFallschaden §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_MOB_LOOT)) {
                            gm5.setItem(20, new ItemBuilder(Material.ROTTEN_FLESH).setName("§aDoMobLoot").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aMob Drops §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm5.setItem(20, new ItemBuilder(Material.ROTTEN_FLESH).setName("§aDoMobLoot").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aMob Drops §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_MOB_SPAWNING)) {
                            gm5.setItem(21, new ItemBuilder(Material.ZOMBIE_HEAD).setName("§aDoMobSpawning").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von diversen §aMobs §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm5.setItem(21, new ItemBuilder(Material.ZOMBIE_HEAD).setName("§aDoMobSpawning").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von diversen §aMobs §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DISABLE_RAIDS)) {
                            gm5.setItem(22, new ItemBuilder(Material.PILLAGER_SPAWN_EGG).setName("§aDisableRaids").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aüberfällen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm5.setItem(22, new ItemBuilder(Material.PILLAGER_SPAWN_EGG).setName("§aDisableRaids").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aüberfällen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DROWNING_DAMAGE)) {
                            gm5.setItem(23, new ItemBuilder(Material.TRIDENT).setName("§aDrowningDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Schaden beim §aErtrinken §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm5.setItem(23, new ItemBuilder(Material.TRIDENT).setName("§aDrowningDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Schaden beim §aErtrinken §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.FIRE_DAMAGE)) {
                            gm5.setItem(24, new ItemBuilder(Material.FIRE_CHARGE).setName("§aFireDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den §aFeuer §7Schaden um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm5.setItem(24, new ItemBuilder(Material.FIRE_CHARGE).setName("§aFireDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den §aFeuer §7Schaden um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_FIRE_TICK)) {
                            gm5.setItem(25, new ItemBuilder(Material.FLINT_AND_STEEL).setName("§aDoFireTick").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7feuer §aausbreiten §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm5.setItem(25, new ItemBuilder(Material.FLINT_AND_STEEL).setName("§aDoFireTick").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7feuer §aausbreiten §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        gm5.setItem(26, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm5.setItem(27, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm5.setItem(28, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm5.setItem(29, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm5.setItem(30, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm5.setItem(31, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm5.setItem(32, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm5.setItem(33, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm5.setItem(34, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm5.setItem(35, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        player.openInventory(gm5);
                        break;
                    case LEAD:
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_TRADER_SPAWNING)) {
                            Bukkit.getWorld(player.getWorld().getUID()).setGameRuleValue("doTraderSpawning", "false");
                            player.sendMessage(Main.getPrefix() + "§7Die Spielregel §4DoTraderSpawning §7wurde §cdeaktiviert§7.");
                            GameStateManager.wanderingTrader = false;
                        } else {
                            Bukkit.getWorld(player.getWorld().getUID()).setGameRuleValue("doTraderSpawning", "true");
                            player.sendMessage(Main.getPrefix() + "§7Die Spielregel §4DoTraderSpawning §7wurde §aaktiviert§7.");
                            GameStateManager.wanderingTrader = true;
                        }
                        player.playSound(player.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 2F, 1F);
                        event.setCancelled(true);

                        Inventory gm6 = Bukkit.createInventory(null, 36, "§6Einstellungen §8● §aSpielregeln");
                        gm6.setItem(0, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm6.setItem(1, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm6.setItem(2, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm6.setItem(3, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm6.setItem(4, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm6.setItem(5, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm6.setItem(6, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm6.setItem(7, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm6.setItem(8, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm6.setItem(9, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.NATURAL_REGENERATION)) {
                            gm6.setItem(10, new ItemBuilder(Material.GOLDEN_APPLE).setName("§aNaturalRegeneration").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7die §anatürliche Regeneration §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm6.setItem(10, new ItemBuilder(Material.GOLDEN_APPLE).setName("§aNaturalRegeneration").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7die §anatürliche Regeneration §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.KEEP_INVENTORY)) {
                            gm6.setItem(11, new ItemBuilder(Material.CHEST).setName("§aKeepInventory").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das §abehalten §7des §aInventars §7nach dem Tod um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm6.setItem(11, new ItemBuilder(Material.CHEST).setName("§aKeepInventory").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das §abehalten §7des §aInventars §7nach dem Tod um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_WEATHER_CYCLE)) {
                            gm6.setItem(12, new ItemBuilder(Material.WATER_BUCKET).setName("§aDoWeatherCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Wetter §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm6.setItem(12, new ItemBuilder(Material.WATER_BUCKET).setName("§aDoWeatherCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Wetter §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_INSOMNIA)) {
                            gm6.setItem(13, new ItemBuilder(Material.PHANTOM_MEMBRANE).setName("§aDoInsomnia").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPhantomen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm6.setItem(13, new ItemBuilder(Material.PHANTOM_MEMBRANE).setName("§aDoInsomnia").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPhantomen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_DAYLIGHT_CYCLE)) {
                            gm6.setItem(14, new ItemBuilder(Material.CLOCK).setName("§aDoDaylightCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Tages §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm6.setItem(14, new ItemBuilder(Material.CLOCK).setName("§aDoDaylightCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Tages §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_TRADER_SPAWNING)) {
                            gm6.setItem(15, new ItemBuilder(Material.LEAD).setName("§aSpawnWanderingTrader").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen vom §awandernden Händler §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm6.setItem(15, new ItemBuilder(Material.LEAD).setName("§aSpawnWanderingTrader").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen vom §awandernden Händler §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_PATROL_SPAWNING)) {
                            gm6.setItem(16, new ItemBuilder(Material.CROSSBOW).setName("§aSpawnPatrolls").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPillager patrollien §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm6.setItem(16, new ItemBuilder(Material.CROSSBOW).setName("§aSpawnPatrolls").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPillager patrollien §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        gm6.setItem(17, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm6.setItem(18, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.FALL_DAMAGE)) {
                            gm6.setItem(19, new ItemBuilder(Material.DIAMOND_BOOTS).setName("§aFallDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aFallschaden §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm6.setItem(19, new ItemBuilder(Material.DIAMOND_BOOTS).setName("§aFallDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aFallschaden §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_MOB_LOOT)) {
                            gm6.setItem(20, new ItemBuilder(Material.ROTTEN_FLESH).setName("§aDoMobLoot").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aMob Drops §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm6.setItem(20, new ItemBuilder(Material.ROTTEN_FLESH).setName("§aDoMobLoot").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aMob Drops §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_MOB_SPAWNING)) {
                            gm6.setItem(21, new ItemBuilder(Material.ZOMBIE_HEAD).setName("§aDoMobSpawning").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von diversen §aMobs §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm6.setItem(21, new ItemBuilder(Material.ZOMBIE_HEAD).setName("§aDoMobSpawning").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von diversen §aMobs §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DISABLE_RAIDS)) {
                            gm6.setItem(22, new ItemBuilder(Material.PILLAGER_SPAWN_EGG).setName("§aDisableRaids").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aüberfällen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm6.setItem(22, new ItemBuilder(Material.PILLAGER_SPAWN_EGG).setName("§aDisableRaids").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aüberfällen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DROWNING_DAMAGE)) {
                            gm6.setItem(23, new ItemBuilder(Material.TRIDENT).setName("§aDrowningDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Schaden beim §aErtrinken §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm6.setItem(23, new ItemBuilder(Material.TRIDENT).setName("§aDrowningDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Schaden beim §aErtrinken §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.FIRE_DAMAGE)) {
                            gm6.setItem(24, new ItemBuilder(Material.FIRE_CHARGE).setName("§aFireDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den §aFeuer §7Schaden um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm6.setItem(24, new ItemBuilder(Material.FIRE_CHARGE).setName("§aFireDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den §aFeuer §7Schaden um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_FIRE_TICK)) {
                            gm6.setItem(25, new ItemBuilder(Material.FLINT_AND_STEEL).setName("§aDoFireTick").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7feuer §aausbreiten §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm6.setItem(25, new ItemBuilder(Material.FLINT_AND_STEEL).setName("§aDoFireTick").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7feuer §aausbreiten §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        gm6.setItem(26, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm6.setItem(27, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm6.setItem(28, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm6.setItem(29, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm6.setItem(30, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm6.setItem(31, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm6.setItem(32, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm6.setItem(33, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm6.setItem(34, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm6.setItem(35, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        player.openInventory(gm6);
                        break;
                    case CROSSBOW:
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_PATROL_SPAWNING)) {
                            Bukkit.getWorld(player.getWorld().getUID()).setGameRuleValue("doPatrolSpawning", "false");
                            player.sendMessage(Main.getPrefix() + "§7Die Spielregel §4DoPatrolSpawning §7wurde §cdeaktiviert§7.");
                            GameStateManager.spawnPatrollie = false;
                        } else {
                            Bukkit.getWorld(player.getWorld().getUID()).setGameRuleValue("doPatrolSpawning", "true");
                            player.sendMessage(Main.getPrefix() + "§7Die Spielregel §4DoPatrolSpawning §7wurde §aaktiviert§7.");
                            GameStateManager.spawnPatrollie = true;
                        }
                        player.playSound(player.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 2F, 1F);
                        event.setCancelled(true);

                        Inventory gm7 = Bukkit.createInventory(null, 36, "§6Einstellungen §8● §aSpielregeln");
                        gm7.setItem(0, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm7.setItem(1, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm7.setItem(2, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm7.setItem(3, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm7.setItem(4, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm7.setItem(5, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm7.setItem(6, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm7.setItem(7, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm7.setItem(8, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm7.setItem(9, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.NATURAL_REGENERATION)) {
                            gm7.setItem(10, new ItemBuilder(Material.GOLDEN_APPLE).setName("§aNaturalRegeneration").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7die §anatürliche Regeneration §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm7.setItem(10, new ItemBuilder(Material.GOLDEN_APPLE).setName("§aNaturalRegeneration").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7die §anatürliche Regeneration §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.KEEP_INVENTORY)) {
                            gm7.setItem(11, new ItemBuilder(Material.CHEST).setName("§aKeepInventory").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das §abehalten §7des §aInventars §7nach dem Tod um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm7.setItem(11, new ItemBuilder(Material.CHEST).setName("§aKeepInventory").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das §abehalten §7des §aInventars §7nach dem Tod um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_WEATHER_CYCLE)) {
                            gm7.setItem(12, new ItemBuilder(Material.WATER_BUCKET).setName("§aDoWeatherCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Wetter §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm7.setItem(12, new ItemBuilder(Material.WATER_BUCKET).setName("§aDoWeatherCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Wetter §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_INSOMNIA)) {
                            gm7.setItem(13, new ItemBuilder(Material.PHANTOM_MEMBRANE).setName("§aDoInsomnia").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPhantomen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm7.setItem(13, new ItemBuilder(Material.PHANTOM_MEMBRANE).setName("§aDoInsomnia").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPhantomen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_DAYLIGHT_CYCLE)) {
                            gm7.setItem(14, new ItemBuilder(Material.CLOCK).setName("§aDoDaylightCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Tages §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm7.setItem(14, new ItemBuilder(Material.CLOCK).setName("§aDoDaylightCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Tages §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_TRADER_SPAWNING)) {
                            gm7.setItem(15, new ItemBuilder(Material.LEAD).setName("§aSpawnWanderingTrader").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen vom §awandernden Händler §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm7.setItem(15, new ItemBuilder(Material.LEAD).setName("§aSpawnWanderingTrader").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen vom §awandernden Händler §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_PATROL_SPAWNING)) {
                            gm7.setItem(16, new ItemBuilder(Material.CROSSBOW).setName("§aSpawnPatrolls").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPillager patrollien §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm7.setItem(16, new ItemBuilder(Material.CROSSBOW).setName("§aSpawnPatrolls").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPillager patrollien §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        gm7.setItem(17, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm7.setItem(18, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.FALL_DAMAGE)) {
                            gm7.setItem(19, new ItemBuilder(Material.DIAMOND_BOOTS).setName("§aFallDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aFallschaden §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm7.setItem(19, new ItemBuilder(Material.DIAMOND_BOOTS).setName("§aFallDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aFallschaden §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_MOB_LOOT)) {
                            gm7.setItem(20, new ItemBuilder(Material.ROTTEN_FLESH).setName("§aDoMobLoot").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aMob Drops §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm7.setItem(20, new ItemBuilder(Material.ROTTEN_FLESH).setName("§aDoMobLoot").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aMob Drops §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_MOB_SPAWNING)) {
                            gm7.setItem(21, new ItemBuilder(Material.ZOMBIE_HEAD).setName("§aDoMobSpawning").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von diversen §aMobs §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm7.setItem(21, new ItemBuilder(Material.ZOMBIE_HEAD).setName("§aDoMobSpawning").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von diversen §aMobs §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DISABLE_RAIDS)) {
                            gm7.setItem(22, new ItemBuilder(Material.PILLAGER_SPAWN_EGG).setName("§aDisableRaids").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aüberfällen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm7.setItem(22, new ItemBuilder(Material.PILLAGER_SPAWN_EGG).setName("§aDisableRaids").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aüberfällen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DROWNING_DAMAGE)) {
                            gm7.setItem(23, new ItemBuilder(Material.TRIDENT).setName("§aDrowningDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Schaden beim §aErtrinken §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm7.setItem(23, new ItemBuilder(Material.TRIDENT).setName("§aDrowningDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Schaden beim §aErtrinken §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.FIRE_DAMAGE)) {
                            gm7.setItem(24, new ItemBuilder(Material.FIRE_CHARGE).setName("§aFireDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den §aFeuer §7Schaden um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm7.setItem(24, new ItemBuilder(Material.FIRE_CHARGE).setName("§aFireDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den §aFeuer §7Schaden um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_FIRE_TICK)) {
                            gm7.setItem(25, new ItemBuilder(Material.FLINT_AND_STEEL).setName("§aDoFireTick").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7feuer §aausbreiten §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm7.setItem(25, new ItemBuilder(Material.FLINT_AND_STEEL).setName("§aDoFireTick").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7feuer §aausbreiten §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        gm7.setItem(26, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm7.setItem(27, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm7.setItem(28, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm7.setItem(29, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm7.setItem(30, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm7.setItem(31, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm7.setItem(32, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm7.setItem(33, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm7.setItem(34, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm7.setItem(35, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        player.openInventory(gm7);
                        break;
                    case DIAMOND_BOOTS:
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.FALL_DAMAGE)) {
                            Bukkit.getWorld(player.getWorld().getUID()).setGameRuleValue("fallDamage", "false");
                            player.sendMessage(Main.getPrefix() + "§7Die Spielregel §4FallDamage §7wurde §cdeaktiviert§7.");
                            GameStateManager.fallDamage = false;
                        } else {
                            Bukkit.getWorld(player.getWorld().getUID()).setGameRuleValue("fallDamage", "true");
                            player.sendMessage(Main.getPrefix() + "§7Die Spielregel §4FallDamage §7wurde §aaktiviert§7.");
                            GameStateManager.fallDamage = true;
                        }
                        player.playSound(player.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 2F, 1F);
                        event.setCancelled(true);

                        Inventory gm8 = Bukkit.createInventory(null, 36, "§6Einstellungen §8● §aSpielregeln");
                        gm8.setItem(0, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm8.setItem(1, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm8.setItem(2, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm8.setItem(3, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm8.setItem(4, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm8.setItem(5, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm8.setItem(6, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm8.setItem(7, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm8.setItem(8, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm8.setItem(9, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.NATURAL_REGENERATION)) {
                            gm8.setItem(10, new ItemBuilder(Material.GOLDEN_APPLE).setName("§aNaturalRegeneration").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7die §anatürliche Regeneration §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm8.setItem(10, new ItemBuilder(Material.GOLDEN_APPLE).setName("§aNaturalRegeneration").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7die §anatürliche Regeneration §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.KEEP_INVENTORY)) {
                            gm8.setItem(11, new ItemBuilder(Material.CHEST).setName("§aKeepInventory").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das §abehalten §7des §aInventars §7nach dem Tod um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm8.setItem(11, new ItemBuilder(Material.CHEST).setName("§aKeepInventory").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das §abehalten §7des §aInventars §7nach dem Tod um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_WEATHER_CYCLE)) {
                            gm8.setItem(12, new ItemBuilder(Material.WATER_BUCKET).setName("§aDoWeatherCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Wetter §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm8.setItem(12, new ItemBuilder(Material.WATER_BUCKET).setName("§aDoWeatherCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Wetter §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_INSOMNIA)) {
                            gm8.setItem(13, new ItemBuilder(Material.PHANTOM_MEMBRANE).setName("§aDoInsomnia").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPhantomen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm8.setItem(13, new ItemBuilder(Material.PHANTOM_MEMBRANE).setName("§aDoInsomnia").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPhantomen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_DAYLIGHT_CYCLE)) {
                            gm8.setItem(14, new ItemBuilder(Material.CLOCK).setName("§aDoDaylightCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Tages §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm8.setItem(14, new ItemBuilder(Material.CLOCK).setName("§aDoDaylightCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Tages §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_TRADER_SPAWNING)) {
                            gm8.setItem(15, new ItemBuilder(Material.LEAD).setName("§aSpawnWanderingTrader").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen vom §awandernden Händler §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm8.setItem(15, new ItemBuilder(Material.LEAD).setName("§aSpawnWanderingTrader").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen vom §awandernden Händler §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_PATROL_SPAWNING)) {
                            gm8.setItem(16, new ItemBuilder(Material.CROSSBOW).setName("§aSpawnPatrolls").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPillager patrollien §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm8.setItem(16, new ItemBuilder(Material.CROSSBOW).setName("§aSpawnPatrolls").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPillager patrollien §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        gm8.setItem(17, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm8.setItem(18, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.FALL_DAMAGE)) {
                            gm8.setItem(19, new ItemBuilder(Material.DIAMOND_BOOTS).setName("§aFallDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aFallschaden §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm8.setItem(19, new ItemBuilder(Material.DIAMOND_BOOTS).setName("§aFallDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aFallschaden §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_MOB_LOOT)) {
                            gm8.setItem(20, new ItemBuilder(Material.ROTTEN_FLESH).setName("§aDoMobLoot").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aMob Drops §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm8.setItem(20, new ItemBuilder(Material.ROTTEN_FLESH).setName("§aDoMobLoot").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aMob Drops §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_MOB_SPAWNING)) {
                            gm8.setItem(21, new ItemBuilder(Material.ZOMBIE_HEAD).setName("§aDoMobSpawning").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von diversen §aMobs §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm8.setItem(21, new ItemBuilder(Material.ZOMBIE_HEAD).setName("§aDoMobSpawning").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von diversen §aMobs §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DISABLE_RAIDS)) {
                            gm8.setItem(22, new ItemBuilder(Material.PILLAGER_SPAWN_EGG).setName("§aDisableRaids").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aüberfällen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm8.setItem(22, new ItemBuilder(Material.PILLAGER_SPAWN_EGG).setName("§aDisableRaids").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aüberfällen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DROWNING_DAMAGE)) {
                            gm8.setItem(23, new ItemBuilder(Material.TRIDENT).setName("§aDrowningDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Schaden beim §aErtrinken §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm8.setItem(23, new ItemBuilder(Material.TRIDENT).setName("§aDrowningDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Schaden beim §aErtrinken §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.FIRE_DAMAGE)) {
                            gm8.setItem(24, new ItemBuilder(Material.FIRE_CHARGE).setName("§aFireDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den §aFeuer §7Schaden um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm8.setItem(24, new ItemBuilder(Material.FIRE_CHARGE).setName("§aFireDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den §aFeuer §7Schaden um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_FIRE_TICK)) {
                            gm8.setItem(25, new ItemBuilder(Material.FLINT_AND_STEEL).setName("§aDoFireTick").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7feuer §aausbreiten §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm8.setItem(25, new ItemBuilder(Material.FLINT_AND_STEEL).setName("§aDoFireTick").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7feuer §aausbreiten §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        gm8.setItem(26, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm8.setItem(27, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm8.setItem(28, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm8.setItem(29, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm8.setItem(30, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm8.setItem(31, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm8.setItem(32, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm8.setItem(33, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm8.setItem(34, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm8.setItem(35, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        player.openInventory(gm8);
                        break;
                    case ROTTEN_FLESH:
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_MOB_LOOT)) {
                            Bukkit.getWorld(player.getWorld().getUID()).setGameRuleValue("doMobLoot", "false");
                            player.sendMessage(Main.getPrefix() + "§7Die Spielregel §4DoMobLoot §7wurde §cdeaktiviert§7.");
                            GameStateManager.mobDrops = false;
                        } else {
                            Bukkit.getWorld(player.getWorld().getUID()).setGameRuleValue("doMobLoot", "true");
                            player.sendMessage(Main.getPrefix() + "§7Die Spielregel §4DoMobLoot §7wurde §aaktiviert§7.");
                            GameStateManager.mobDrops = true;
                        }
                        player.playSound(player.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 2F, 1F);
                        event.setCancelled(true);

                        Inventory gm9 = Bukkit.createInventory(null, 36, "§6Einstellungen §8● §aSpielregeln");
                        gm9.setItem(0, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm9.setItem(1, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm9.setItem(2, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm9.setItem(3, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm9.setItem(4, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm9.setItem(5, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm9.setItem(6, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm9.setItem(7, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm9.setItem(8, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm9.setItem(9, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.NATURAL_REGENERATION)) {
                            gm9.setItem(10, new ItemBuilder(Material.GOLDEN_APPLE).setName("§aNaturalRegeneration").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7die §anatürliche Regeneration §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm9.setItem(10, new ItemBuilder(Material.GOLDEN_APPLE).setName("§aNaturalRegeneration").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7die §anatürliche Regeneration §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.KEEP_INVENTORY)) {
                            gm9.setItem(11, new ItemBuilder(Material.CHEST).setName("§aKeepInventory").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das §abehalten §7des §aInventars §7nach dem Tod um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm9.setItem(11, new ItemBuilder(Material.CHEST).setName("§aKeepInventory").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das §abehalten §7des §aInventars §7nach dem Tod um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_WEATHER_CYCLE)) {
                            gm9.setItem(12, new ItemBuilder(Material.WATER_BUCKET).setName("§aDoWeatherCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Wetter §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm9.setItem(12, new ItemBuilder(Material.WATER_BUCKET).setName("§aDoWeatherCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Wetter §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_INSOMNIA)) {
                            gm9.setItem(13, new ItemBuilder(Material.PHANTOM_MEMBRANE).setName("§aDoInsomnia").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPhantomen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm9.setItem(13, new ItemBuilder(Material.PHANTOM_MEMBRANE).setName("§aDoInsomnia").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPhantomen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_DAYLIGHT_CYCLE)) {
                            gm9.setItem(14, new ItemBuilder(Material.CLOCK).setName("§aDoDaylightCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Tages §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm9.setItem(14, new ItemBuilder(Material.CLOCK).setName("§aDoDaylightCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Tages §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_TRADER_SPAWNING)) {
                            gm9.setItem(15, new ItemBuilder(Material.LEAD).setName("§aSpawnWanderingTrader").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen vom §awandernden Händler §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm9.setItem(15, new ItemBuilder(Material.LEAD).setName("§aSpawnWanderingTrader").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen vom §awandernden Händler §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_PATROL_SPAWNING)) {
                            gm9.setItem(16, new ItemBuilder(Material.CROSSBOW).setName("§aSpawnPatrolls").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPillager patrollien §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm9.setItem(16, new ItemBuilder(Material.CROSSBOW).setName("§aSpawnPatrolls").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPillager patrollien §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        gm9.setItem(17, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm9.setItem(18, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.FALL_DAMAGE)) {
                            gm9.setItem(19, new ItemBuilder(Material.DIAMOND_BOOTS).setName("§aFallDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aFallschaden §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm9.setItem(19, new ItemBuilder(Material.DIAMOND_BOOTS).setName("§aFallDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aFallschaden §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_MOB_LOOT)) {
                            gm9.setItem(20, new ItemBuilder(Material.ROTTEN_FLESH).setName("§aDoMobLoot").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aMob Drops §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm9.setItem(20, new ItemBuilder(Material.ROTTEN_FLESH).setName("§aDoMobLoot").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aMob Drops §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_MOB_SPAWNING)) {
                            gm9.setItem(21, new ItemBuilder(Material.ZOMBIE_HEAD).setName("§aDoMobSpawning").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von diversen §aMobs §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm9.setItem(21, new ItemBuilder(Material.ZOMBIE_HEAD).setName("§aDoMobSpawning").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von diversen §aMobs §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DISABLE_RAIDS)) {
                            gm9.setItem(22, new ItemBuilder(Material.PILLAGER_SPAWN_EGG).setName("§aDisableRaids").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aüberfällen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm9.setItem(22, new ItemBuilder(Material.PILLAGER_SPAWN_EGG).setName("§aDisableRaids").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aüberfällen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DROWNING_DAMAGE)) {
                            gm9.setItem(23, new ItemBuilder(Material.TRIDENT).setName("§aDrowningDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Schaden beim §aErtrinken §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm9.setItem(23, new ItemBuilder(Material.TRIDENT).setName("§aDrowningDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Schaden beim §aErtrinken §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.FIRE_DAMAGE)) {
                            gm9.setItem(24, new ItemBuilder(Material.FIRE_CHARGE).setName("§aFireDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den §aFeuer §7Schaden um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm9.setItem(24, new ItemBuilder(Material.FIRE_CHARGE).setName("§aFireDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den §aFeuer §7Schaden um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_FIRE_TICK)) {
                            gm9.setItem(25, new ItemBuilder(Material.FLINT_AND_STEEL).setName("§aDoFireTick").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7feuer §aausbreiten §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm9.setItem(25, new ItemBuilder(Material.FLINT_AND_STEEL).setName("§aDoFireTick").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7feuer §aausbreiten §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        gm9.setItem(26, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm9.setItem(27, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm9.setItem(28, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm9.setItem(29, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm9.setItem(30, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm9.setItem(31, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm9.setItem(32, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm9.setItem(33, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm9.setItem(34, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm9.setItem(35, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        player.openInventory(gm9);
                        break;
                    case ZOMBIE_HEAD:
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_MOB_SPAWNING)) {
                            Bukkit.getWorld(player.getWorld().getUID()).setGameRuleValue("doMobSpawning", "false");
                            player.sendMessage(Main.getPrefix() + "§7Die Spielregel §4DoMobSpawning §7wurde §cdeaktiviert§7.");
                            GameStateManager.mobSpawning = false;
                        } else {
                            Bukkit.getWorld(player.getWorld().getUID()).setGameRuleValue("doMobSpawning", "true");
                            player.sendMessage(Main.getPrefix() + "§7Die Spielregel §4DoMobSpawning §7wurde §aaktiviert§7.");
                            GameStateManager.mobSpawning = true;
                        }
                        player.playSound(player.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 2F, 1F);
                        event.setCancelled(true);

                        Inventory gm0 = Bukkit.createInventory(null, 36, "§6Einstellungen §8● §aSpielregeln");
                        gm0.setItem(0, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm0.setItem(1, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm0.setItem(2, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm0.setItem(3, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm0.setItem(4, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm0.setItem(5, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm0.setItem(6, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm0.setItem(7, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm0.setItem(8, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm0.setItem(9, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.NATURAL_REGENERATION)) {
                            gm0.setItem(10, new ItemBuilder(Material.GOLDEN_APPLE).setName("§aNaturalRegeneration").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7die §anatürliche Regeneration §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm0.setItem(10, new ItemBuilder(Material.GOLDEN_APPLE).setName("§aNaturalRegeneration").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7die §anatürliche Regeneration §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.KEEP_INVENTORY)) {
                            gm0.setItem(11, new ItemBuilder(Material.CHEST).setName("§aKeepInventory").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das §abehalten §7des §aInventars §7nach dem Tod um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm0.setItem(11, new ItemBuilder(Material.CHEST).setName("§aKeepInventory").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das §abehalten §7des §aInventars §7nach dem Tod um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_WEATHER_CYCLE)) {
                            gm0.setItem(12, new ItemBuilder(Material.WATER_BUCKET).setName("§aDoWeatherCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Wetter §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm0.setItem(12, new ItemBuilder(Material.WATER_BUCKET).setName("§aDoWeatherCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Wetter §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_INSOMNIA)) {
                            gm0.setItem(13, new ItemBuilder(Material.PHANTOM_MEMBRANE).setName("§aDoInsomnia").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPhantomen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm0.setItem(13, new ItemBuilder(Material.PHANTOM_MEMBRANE).setName("§aDoInsomnia").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPhantomen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_DAYLIGHT_CYCLE)) {
                            gm0.setItem(14, new ItemBuilder(Material.CLOCK).setName("§aDoDaylightCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Tages §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm0.setItem(14, new ItemBuilder(Material.CLOCK).setName("§aDoDaylightCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Tages §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_TRADER_SPAWNING)) {
                            gm0.setItem(15, new ItemBuilder(Material.LEAD).setName("§aSpawnWanderingTrader").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen vom §awandernden Händler §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm0.setItem(15, new ItemBuilder(Material.LEAD).setName("§aSpawnWanderingTrader").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen vom §awandernden Händler §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_PATROL_SPAWNING)) {
                            gm0.setItem(16, new ItemBuilder(Material.CROSSBOW).setName("§aSpawnPatrolls").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPillager patrollien §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm0.setItem(16, new ItemBuilder(Material.CROSSBOW).setName("§aSpawnPatrolls").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPillager patrollien §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        gm0.setItem(17, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm0.setItem(18, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.FALL_DAMAGE)) {
                            gm0.setItem(19, new ItemBuilder(Material.DIAMOND_BOOTS).setName("§aFallDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aFallschaden §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm0.setItem(19, new ItemBuilder(Material.DIAMOND_BOOTS).setName("§aFallDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aFallschaden §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_MOB_LOOT)) {
                            gm0.setItem(20, new ItemBuilder(Material.ROTTEN_FLESH).setName("§aDoMobLoot").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aMob Drops §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm0.setItem(20, new ItemBuilder(Material.ROTTEN_FLESH).setName("§aDoMobLoot").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aMob Drops §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_MOB_SPAWNING)) {
                            gm0.setItem(21, new ItemBuilder(Material.ZOMBIE_HEAD).setName("§aDoMobSpawning").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von diversen §aMobs §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm0.setItem(21, new ItemBuilder(Material.ZOMBIE_HEAD).setName("§aDoMobSpawning").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von diversen §aMobs §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DISABLE_RAIDS)) {
                            gm0.setItem(22, new ItemBuilder(Material.PILLAGER_SPAWN_EGG).setName("§aDisableRaids").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aüberfällen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm0.setItem(22, new ItemBuilder(Material.PILLAGER_SPAWN_EGG).setName("§aDisableRaids").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aüberfällen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DROWNING_DAMAGE)) {
                            gm0.setItem(23, new ItemBuilder(Material.TRIDENT).setName("§aDrowningDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Schaden beim §aErtrinken §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm0.setItem(23, new ItemBuilder(Material.TRIDENT).setName("§aDrowningDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Schaden beim §aErtrinken §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.FIRE_DAMAGE)) {
                            gm0.setItem(24, new ItemBuilder(Material.FIRE_CHARGE).setName("§aFireDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den §aFeuer §7Schaden um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm0.setItem(24, new ItemBuilder(Material.FIRE_CHARGE).setName("§aFireDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den §aFeuer §7Schaden um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_FIRE_TICK)) {
                            gm0.setItem(25, new ItemBuilder(Material.FLINT_AND_STEEL).setName("§aDoFireTick").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7feuer §aausbreiten §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gm0.setItem(25, new ItemBuilder(Material.FLINT_AND_STEEL).setName("§aDoFireTick").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7feuer §aausbreiten §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        gm0.setItem(26, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm0.setItem(27, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm0.setItem(28, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm0.setItem(29, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm0.setItem(30, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm0.setItem(31, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm0.setItem(32, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm0.setItem(33, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm0.setItem(34, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gm0.setItem(35, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        player.openInventory(gm0);
                        break;
                    case PILLAGER_SPAWN_EGG:
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DISABLE_RAIDS)) {
                            Bukkit.getWorld(player.getWorld().getUID()).setGameRuleValue("disableRaids", "false");
                            player.sendMessage(Main.getPrefix() + "§7Die Spielregel §4DisableRaids §7wurde §cdeaktiviert§7.");
                            GameStateManager.raids = false;
                        } else {
                            Bukkit.getWorld(player.getWorld().getUID()).setGameRuleValue("disableRaids", "true");
                            player.sendMessage(Main.getPrefix() + "§7Die Spielregel §4DisableRaids §7wurde §aaktiviert§7.");
                            GameStateManager.raids = true;
                        }
                        player.playSound(player.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 2F, 1F);
                        event.setCancelled(true);

                        Inventory gmm = Bukkit.createInventory(null, 36, "§6Einstellungen §8● §aSpielregeln");
                        gmm.setItem(0, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmm.setItem(1, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmm.setItem(2, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmm.setItem(3, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmm.setItem(4, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmm.setItem(5, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmm.setItem(6, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmm.setItem(7, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmm.setItem(8, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmm.setItem(9, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.NATURAL_REGENERATION)) {
                            gmm.setItem(10, new ItemBuilder(Material.GOLDEN_APPLE).setName("§aNaturalRegeneration").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7die §anatürliche Regeneration §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gmm.setItem(10, new ItemBuilder(Material.GOLDEN_APPLE).setName("§aNaturalRegeneration").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7die §anatürliche Regeneration §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.KEEP_INVENTORY)) {
                            gmm.setItem(11, new ItemBuilder(Material.CHEST).setName("§aKeepInventory").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das §abehalten §7des §aInventars §7nach dem Tod um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gmm.setItem(11, new ItemBuilder(Material.CHEST).setName("§aKeepInventory").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das §abehalten §7des §aInventars §7nach dem Tod um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_WEATHER_CYCLE)) {
                            gmm.setItem(12, new ItemBuilder(Material.WATER_BUCKET).setName("§aDoWeatherCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Wetter §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gmm.setItem(12, new ItemBuilder(Material.WATER_BUCKET).setName("§aDoWeatherCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Wetter §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_INSOMNIA)) {
                            gmm.setItem(13, new ItemBuilder(Material.PHANTOM_MEMBRANE).setName("§aDoInsomnia").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPhantomen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gmm.setItem(13, new ItemBuilder(Material.PHANTOM_MEMBRANE).setName("§aDoInsomnia").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPhantomen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_DAYLIGHT_CYCLE)) {
                            gmm.setItem(14, new ItemBuilder(Material.CLOCK).setName("§aDoDaylightCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Tages §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gmm.setItem(14, new ItemBuilder(Material.CLOCK).setName("§aDoDaylightCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Tages §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_TRADER_SPAWNING)) {
                            gmm.setItem(15, new ItemBuilder(Material.LEAD).setName("§aSpawnWanderingTrader").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen vom §awandernden Händler §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gmm.setItem(15, new ItemBuilder(Material.LEAD).setName("§aSpawnWanderingTrader").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen vom §awandernden Händler §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_PATROL_SPAWNING)) {
                            gmm.setItem(16, new ItemBuilder(Material.CROSSBOW).setName("§aSpawnPatrolls").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPillager patrollien §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gmm.setItem(16, new ItemBuilder(Material.CROSSBOW).setName("§aSpawnPatrolls").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPillager patrollien §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        gmm.setItem(17, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmm.setItem(18, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.FALL_DAMAGE)) {
                            gmm.setItem(19, new ItemBuilder(Material.DIAMOND_BOOTS).setName("§aFallDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aFallschaden §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gmm.setItem(19, new ItemBuilder(Material.DIAMOND_BOOTS).setName("§aFallDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aFallschaden §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_MOB_LOOT)) {
                            gmm.setItem(20, new ItemBuilder(Material.ROTTEN_FLESH).setName("§aDoMobLoot").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aMob Drops §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gmm.setItem(20, new ItemBuilder(Material.ROTTEN_FLESH).setName("§aDoMobLoot").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aMob Drops §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_MOB_SPAWNING)) {
                            gmm.setItem(21, new ItemBuilder(Material.ZOMBIE_HEAD).setName("§aDoMobSpawning").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von diversen §aMobs §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gmm.setItem(21, new ItemBuilder(Material.ZOMBIE_HEAD).setName("§aDoMobSpawning").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von diversen §aMobs §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DISABLE_RAIDS)) {
                            gmm.setItem(22, new ItemBuilder(Material.PILLAGER_SPAWN_EGG).setName("§aDisableRaids").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aüberfällen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gmm.setItem(22, new ItemBuilder(Material.PILLAGER_SPAWN_EGG).setName("§aDisableRaids").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aüberfällen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DROWNING_DAMAGE)) {
                            gmm.setItem(23, new ItemBuilder(Material.TRIDENT).setName("§aDrowningDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Schaden beim §aErtrinken §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gmm.setItem(23, new ItemBuilder(Material.TRIDENT).setName("§aDrowningDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Schaden beim §aErtrinken §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.FIRE_DAMAGE)) {
                            gmm.setItem(24, new ItemBuilder(Material.FIRE_CHARGE).setName("§aFireDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den §aFeuer §7Schaden um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gmm.setItem(24, new ItemBuilder(Material.FIRE_CHARGE).setName("§aFireDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den §aFeuer §7Schaden um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_FIRE_TICK)) {
                            gmm.setItem(25, new ItemBuilder(Material.FLINT_AND_STEEL).setName("§aDoFireTick").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7feuer §aausbreiten §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gmm.setItem(25, new ItemBuilder(Material.FLINT_AND_STEEL).setName("§aDoFireTick").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7feuer §aausbreiten §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        gmm.setItem(26, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmm.setItem(27, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmm.setItem(28, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmm.setItem(29, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmm.setItem(30, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmm.setItem(31, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmm.setItem(32, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmm.setItem(33, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmm.setItem(34, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmm.setItem(35, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        player.openInventory(gmm);
                        break;
                    case TRIDENT:
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DROWNING_DAMAGE)) {
                            Bukkit.getWorld(player.getWorld().getUID()).setGameRuleValue("drowningDamage", "false");
                            player.sendMessage(Main.getPrefix() + "§7Die Spielregel §4DrowningDamage §7wurde §cdeaktiviert§7.");
                            GameStateManager.drowning = false;
                        } else {
                            Bukkit.getWorld(player.getWorld().getUID()).setGameRuleValue("drowningDamage", "true");
                            player.sendMessage(Main.getPrefix() + "§7Die Spielregel §4DrowningDamage §7wurde §aaktiviert§7.");
                            GameStateManager.drowning = true;
                        }
                        player.playSound(player.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 2F, 1F);
                        event.setCancelled(true);

                        Inventory gmn = Bukkit.createInventory(null, 36, "§6Einstellungen §8● §aSpielregeln");
                        gmn.setItem(0, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmn.setItem(1, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmn.setItem(2, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmn.setItem(3, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmn.setItem(4, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmn.setItem(5, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmn.setItem(6, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmn.setItem(7, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmn.setItem(8, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmn.setItem(9, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.NATURAL_REGENERATION)) {
                            gmn.setItem(10, new ItemBuilder(Material.GOLDEN_APPLE).setName("§aNaturalRegeneration").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7die §anatürliche Regeneration §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gmn.setItem(10, new ItemBuilder(Material.GOLDEN_APPLE).setName("§aNaturalRegeneration").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7die §anatürliche Regeneration §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.KEEP_INVENTORY)) {
                            gmn.setItem(11, new ItemBuilder(Material.CHEST).setName("§aKeepInventory").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das §abehalten §7des §aInventars §7nach dem Tod um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gmn.setItem(11, new ItemBuilder(Material.CHEST).setName("§aKeepInventory").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das §abehalten §7des §aInventars §7nach dem Tod um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_WEATHER_CYCLE)) {
                            gmn.setItem(12, new ItemBuilder(Material.WATER_BUCKET).setName("§aDoWeatherCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Wetter §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gmn.setItem(12, new ItemBuilder(Material.WATER_BUCKET).setName("§aDoWeatherCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Wetter §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_INSOMNIA)) {
                            gmn.setItem(13, new ItemBuilder(Material.PHANTOM_MEMBRANE).setName("§aDoInsomnia").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPhantomen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gmn.setItem(13, new ItemBuilder(Material.PHANTOM_MEMBRANE).setName("§aDoInsomnia").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPhantomen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_DAYLIGHT_CYCLE)) {
                            gmn.setItem(14, new ItemBuilder(Material.CLOCK).setName("§aDoDaylightCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Tages §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gmn.setItem(14, new ItemBuilder(Material.CLOCK).setName("§aDoDaylightCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Tages §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_TRADER_SPAWNING)) {
                            gmn.setItem(15, new ItemBuilder(Material.LEAD).setName("§aSpawnWanderingTrader").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen vom §awandernden Händler §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gmn.setItem(15, new ItemBuilder(Material.LEAD).setName("§aSpawnWanderingTrader").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen vom §awandernden Händler §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_PATROL_SPAWNING)) {
                            gmn.setItem(16, new ItemBuilder(Material.CROSSBOW).setName("§aSpawnPatrolls").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPillager patrollien §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gmn.setItem(16, new ItemBuilder(Material.CROSSBOW).setName("§aSpawnPatrolls").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPillager patrollien §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        gmn.setItem(17, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmn.setItem(18, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.FALL_DAMAGE)) {
                            gmn.setItem(19, new ItemBuilder(Material.DIAMOND_BOOTS).setName("§aFallDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aFallschaden §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gmn.setItem(19, new ItemBuilder(Material.DIAMOND_BOOTS).setName("§aFallDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aFallschaden §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_MOB_LOOT)) {
                            gmn.setItem(20, new ItemBuilder(Material.ROTTEN_FLESH).setName("§aDoMobLoot").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aMob Drops §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gmn.setItem(20, new ItemBuilder(Material.ROTTEN_FLESH).setName("§aDoMobLoot").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aMob Drops §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_MOB_SPAWNING)) {
                            gmn.setItem(21, new ItemBuilder(Material.ZOMBIE_HEAD).setName("§aDoMobSpawning").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von diversen §aMobs §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gmn.setItem(21, new ItemBuilder(Material.ZOMBIE_HEAD).setName("§aDoMobSpawning").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von diversen §aMobs §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DISABLE_RAIDS)) {
                            gmn.setItem(22, new ItemBuilder(Material.PILLAGER_SPAWN_EGG).setName("§aDisableRaids").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aüberfällen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gmn.setItem(22, new ItemBuilder(Material.PILLAGER_SPAWN_EGG).setName("§aDisableRaids").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aüberfällen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DROWNING_DAMAGE)) {
                            gmn.setItem(23, new ItemBuilder(Material.TRIDENT).setName("§aDrowningDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Schaden beim §aErtrinken §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gmn.setItem(23, new ItemBuilder(Material.TRIDENT).setName("§aDrowningDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Schaden beim §aErtrinken §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.FIRE_DAMAGE)) {
                            gmn.setItem(24, new ItemBuilder(Material.FIRE_CHARGE).setName("§aFireDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den §aFeuer §7Schaden um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gmn.setItem(24, new ItemBuilder(Material.FIRE_CHARGE).setName("§aFireDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den §aFeuer §7Schaden um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_FIRE_TICK)) {
                            gmn.setItem(25, new ItemBuilder(Material.FLINT_AND_STEEL).setName("§aDoFireTick").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7feuer §aausbreiten §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gmn.setItem(25, new ItemBuilder(Material.FLINT_AND_STEEL).setName("§aDoFireTick").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7feuer §aausbreiten §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        gmn.setItem(26, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmn.setItem(27, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmn.setItem(28, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmn.setItem(29, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmn.setItem(30, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmn.setItem(31, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmn.setItem(32, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmn.setItem(33, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmn.setItem(34, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmn.setItem(35, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        player.openInventory(gmn);
                        break;
                    case FIRE_CHARGE:
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.FIRE_DAMAGE)) {
                            Bukkit.getWorld(player.getWorld().getUID()).setGameRuleValue("fireDamage", "false");
                            player.sendMessage(Main.getPrefix() + "§7Die Spielregel §4FireDamage §7wurde §cdeaktiviert§7.");
                            GameStateManager.fireDamage = false;
                        } else {
                            Bukkit.getWorld(player.getWorld().getUID()).setGameRuleValue("fireDamage", "true");
                            player.sendMessage(Main.getPrefix() + "§7Die Spielregel §4FireDamage §7wurde §aaktiviert§7.");
                            GameStateManager.fireDamage = true;
                        }
                        player.playSound(player.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 2F, 1F);
                        event.setCancelled(true);

                        Inventory gmb = Bukkit.createInventory(null, 36, "§6Einstellungen §8● §aSpielregeln");
                        gmb.setItem(0, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmb.setItem(1, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmb.setItem(2, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmb.setItem(3, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmb.setItem(4, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmb.setItem(5, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmb.setItem(6, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmb.setItem(7, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmb.setItem(8, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmb.setItem(9, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.NATURAL_REGENERATION)) {
                            gmb.setItem(10, new ItemBuilder(Material.GOLDEN_APPLE).setName("§aNaturalRegeneration").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7die §anatürliche Regeneration §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gmb.setItem(10, new ItemBuilder(Material.GOLDEN_APPLE).setName("§aNaturalRegeneration").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7die §anatürliche Regeneration §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.KEEP_INVENTORY)) {
                            gmb.setItem(11, new ItemBuilder(Material.CHEST).setName("§aKeepInventory").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das §abehalten §7des §aInventars §7nach dem Tod um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gmb.setItem(11, new ItemBuilder(Material.CHEST).setName("§aKeepInventory").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das §abehalten §7des §aInventars §7nach dem Tod um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_WEATHER_CYCLE)) {
                            gmb.setItem(12, new ItemBuilder(Material.WATER_BUCKET).setName("§aDoWeatherCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Wetter §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gmb.setItem(12, new ItemBuilder(Material.WATER_BUCKET).setName("§aDoWeatherCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Wetter §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_INSOMNIA)) {
                            gmb.setItem(13, new ItemBuilder(Material.PHANTOM_MEMBRANE).setName("§aDoInsomnia").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPhantomen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gmb.setItem(13, new ItemBuilder(Material.PHANTOM_MEMBRANE).setName("§aDoInsomnia").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPhantomen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_DAYLIGHT_CYCLE)) {
                            gmb.setItem(14, new ItemBuilder(Material.CLOCK).setName("§aDoDaylightCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Tages §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gmb.setItem(14, new ItemBuilder(Material.CLOCK).setName("§aDoDaylightCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Tages §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_TRADER_SPAWNING)) {
                            gmb.setItem(15, new ItemBuilder(Material.LEAD).setName("§aSpawnWanderingTrader").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen vom §awandernden Händler §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gmb.setItem(15, new ItemBuilder(Material.LEAD).setName("§aSpawnWanderingTrader").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen vom §awandernden Händler §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_PATROL_SPAWNING)) {
                            gmb.setItem(16, new ItemBuilder(Material.CROSSBOW).setName("§aSpawnPatrolls").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPillager patrollien §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gmb.setItem(16, new ItemBuilder(Material.CROSSBOW).setName("§aSpawnPatrolls").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPillager patrollien §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        gmb.setItem(17, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmb.setItem(18, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.FALL_DAMAGE)) {
                            gmb.setItem(19, new ItemBuilder(Material.DIAMOND_BOOTS).setName("§aFallDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aFallschaden §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gmb.setItem(19, new ItemBuilder(Material.DIAMOND_BOOTS).setName("§aFallDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aFallschaden §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_MOB_LOOT)) {
                            gmb.setItem(20, new ItemBuilder(Material.ROTTEN_FLESH).setName("§aDoMobLoot").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aMob Drops §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gmb.setItem(20, new ItemBuilder(Material.ROTTEN_FLESH).setName("§aDoMobLoot").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aMob Drops §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_MOB_SPAWNING)) {
                            gmb.setItem(21, new ItemBuilder(Material.ZOMBIE_HEAD).setName("§aDoMobSpawning").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von diversen §aMobs §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gmb.setItem(21, new ItemBuilder(Material.ZOMBIE_HEAD).setName("§aDoMobSpawning").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von diversen §aMobs §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DISABLE_RAIDS)) {
                            gmb.setItem(22, new ItemBuilder(Material.PILLAGER_SPAWN_EGG).setName("§aDisableRaids").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aüberfällen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gmb.setItem(22, new ItemBuilder(Material.PILLAGER_SPAWN_EGG).setName("§aDisableRaids").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aüberfällen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DROWNING_DAMAGE)) {
                            gmb.setItem(23, new ItemBuilder(Material.TRIDENT).setName("§aDrowningDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Schaden beim §aErtrinken §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gmb.setItem(23, new ItemBuilder(Material.TRIDENT).setName("§aDrowningDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Schaden beim §aErtrinken §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.FIRE_DAMAGE)) {
                            gmb.setItem(24, new ItemBuilder(Material.FIRE_CHARGE).setName("§aFireDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den §aFeuer §7Schaden um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gmb.setItem(24, new ItemBuilder(Material.FIRE_CHARGE).setName("§aFireDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den §aFeuer §7Schaden um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_FIRE_TICK)) {
                            gmb.setItem(25, new ItemBuilder(Material.FLINT_AND_STEEL).setName("§aDoFireTick").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7feuer §aausbreiten §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gmb.setItem(25, new ItemBuilder(Material.FLINT_AND_STEEL).setName("§aDoFireTick").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7feuer §aausbreiten §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        gmb.setItem(26, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmb.setItem(27, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmb.setItem(28, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmb.setItem(29, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmb.setItem(30, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmb.setItem(31, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmb.setItem(32, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmb.setItem(33, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmb.setItem(34, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmb.setItem(35, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        player.openInventory(gmb);
                        break;
                    case FLINT_AND_STEEL:
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_FIRE_TICK)) {
                            Bukkit.getWorld(player.getWorld().getUID()).setGameRuleValue("doFireTick", "false");
                            player.sendMessage(Main.getPrefix() + "§7Die Spielregel §4DoFireTick §7wurde §cdeaktiviert§7.");
                            GameStateManager.doFireTick = false;
                        } else {
                            Bukkit.getWorld(player.getWorld().getUID()).setGameRuleValue("doFireTick", "true");
                            player.sendMessage(Main.getPrefix() + "§7Die Spielregel §4DoFireTick §7wurde §aaktiviert§7.");
                            GameStateManager.doFireTick = true;
                        }
                        player.playSound(player.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 2F, 1F);
                        event.setCancelled(true);

                        Inventory gmv = Bukkit.createInventory(null, 36, "§6Einstellungen §8● §aSpielregeln");
                        gmv.setItem(0, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmv.setItem(1, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmv.setItem(2, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmv.setItem(3, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmv.setItem(4, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmv.setItem(5, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmv.setItem(6, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmv.setItem(7, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmv.setItem(8, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmv.setItem(9, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.NATURAL_REGENERATION)) {
                            gmv.setItem(10, new ItemBuilder(Material.GOLDEN_APPLE).setName("§aNaturalRegeneration").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7die §anatürliche Regeneration §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gmv.setItem(10, new ItemBuilder(Material.GOLDEN_APPLE).setName("§aNaturalRegeneration").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7die §anatürliche Regeneration §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.KEEP_INVENTORY)) {
                            gmv.setItem(11, new ItemBuilder(Material.CHEST).setName("§aKeepInventory").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das §abehalten §7des §aInventars §7nach dem Tod um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gmv.setItem(11, new ItemBuilder(Material.CHEST).setName("§aKeepInventory").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das §abehalten §7des §aInventars §7nach dem Tod um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_WEATHER_CYCLE)) {
                            gmv.setItem(12, new ItemBuilder(Material.WATER_BUCKET).setName("§aDoWeatherCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Wetter §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gmv.setItem(12, new ItemBuilder(Material.WATER_BUCKET).setName("§aDoWeatherCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Wetter §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_INSOMNIA)) {
                            gmv.setItem(13, new ItemBuilder(Material.PHANTOM_MEMBRANE).setName("§aDoInsomnia").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPhantomen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gmv.setItem(13, new ItemBuilder(Material.PHANTOM_MEMBRANE).setName("§aDoInsomnia").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPhantomen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_DAYLIGHT_CYCLE)) {
                            gmv.setItem(14, new ItemBuilder(Material.CLOCK).setName("§aDoDaylightCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Tages §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gmv.setItem(14, new ItemBuilder(Material.CLOCK).setName("§aDoDaylightCycle").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Tages §aZyklus §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_TRADER_SPAWNING)) {
                            gmv.setItem(15, new ItemBuilder(Material.LEAD).setName("§aSpawnWanderingTrader").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen vom §awandernden Händler §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gmv.setItem(15, new ItemBuilder(Material.LEAD).setName("§aSpawnWanderingTrader").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen vom §awandernden Händler §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_PATROL_SPAWNING)) {
                            gmv.setItem(16, new ItemBuilder(Material.CROSSBOW).setName("§aSpawnPatrolls").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPillager patrollien §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gmv.setItem(16, new ItemBuilder(Material.CROSSBOW).setName("§aSpawnPatrolls").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aPillager patrollien §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        gmv.setItem(17, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmv.setItem(18, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.FALL_DAMAGE)) {
                            gmv.setItem(19, new ItemBuilder(Material.DIAMOND_BOOTS).setName("§aFallDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aFallschaden §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gmv.setItem(19, new ItemBuilder(Material.DIAMOND_BOOTS).setName("§aFallDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aFallschaden §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_MOB_LOOT)) {
                            gmv.setItem(20, new ItemBuilder(Material.ROTTEN_FLESH).setName("§aDoMobLoot").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aMob Drops §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gmv.setItem(20, new ItemBuilder(Material.ROTTEN_FLESH).setName("§aDoMobLoot").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das erhalten von §aMob Drops §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_MOB_SPAWNING)) {
                            gmv.setItem(21, new ItemBuilder(Material.ZOMBIE_HEAD).setName("§aDoMobSpawning").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von diversen §aMobs §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gmv.setItem(21, new ItemBuilder(Material.ZOMBIE_HEAD).setName("§aDoMobSpawning").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von diversen §aMobs §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DISABLE_RAIDS)) {
                            gmv.setItem(22, new ItemBuilder(Material.PILLAGER_SPAWN_EGG).setName("§aDisableRaids").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aüberfällen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gmv.setItem(22, new ItemBuilder(Material.PILLAGER_SPAWN_EGG).setName("§aDisableRaids").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7das spawnen von §aüberfällen §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DROWNING_DAMAGE)) {
                            gmv.setItem(23, new ItemBuilder(Material.TRIDENT).setName("§aDrowningDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Schaden beim §aErtrinken §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gmv.setItem(23, new ItemBuilder(Material.TRIDENT).setName("§aDrowningDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den Schaden beim §aErtrinken §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.FIRE_DAMAGE)) {
                            gmv.setItem(24, new ItemBuilder(Material.FIRE_CHARGE).setName("§aFireDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den §aFeuer §7Schaden um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gmv.setItem(24, new ItemBuilder(Material.FIRE_CHARGE).setName("§aFireDamage").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7den §aFeuer §7Schaden um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        if(Bukkit.getWorld(player.getWorld().getName()).getGameRuleValue(GameRule.DO_FIRE_TICK)) {
                            gmv.setItem(25, new ItemBuilder(Material.FLINT_AND_STEEL).setName("§aDoFireTick").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7feuer §aausbreiten §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §2aktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        } else {
                            gmv.setItem(25, new ItemBuilder(Material.FLINT_AND_STEEL).setName("§aDoFireTick").setLore(" ", "§a§nBeschreibung§r§7:", " §7Diese Spielregel schaltet", " §7feuer §aausbreiten §7um.", " ", "§a§nEigenschaften§r§7:", "§7 Typ§8: §aSpielregel", " §7Status§8: §4deaktiviert", " ", "§a§oLinksklick §r§7Status ändern", "§a§oRechtsklick §r§7Einstellungen", " ").build());
                        }
                        gmv.setItem(26, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmv.setItem(27, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmv.setItem(28, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmv.setItem(29, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmv.setItem(30, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmv.setItem(31, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmv.setItem(32, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmv.setItem(33, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmv.setItem(34, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        gmv.setItem(35, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
                        player.openInventory(gmv);
                        break;

                    case GRAY_STAINED_GLASS_PANE:
                        Inventory inv = Bukkit.createInventory(null, 27, "§6Einstellungen §8● §9Übersicht");
                        inv.setItem(0, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                        inv.setItem(1, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                        inv.setItem(2, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                        inv.setItem(3, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                        inv.setItem(4, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                        inv.setItem(5, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                        inv.setItem(6, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                        inv.setItem(7, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                        inv.setItem(8, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());

                        inv.setItem(9, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                        inv.setItem(10, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());

                        inv.setItem(11, new ItemBuilder(Material.DRAGON_HEAD).setName("§cBedingungen").setLore(" ", " §7Lege die §cBedingung", " §7für den §cSieg §7einer", " §cChallenge §7fest", " ", " §c§oKlick§7§o: §r§cÜbersicht").build());
                        inv.setItem(12, new ItemBuilder(Material.GRASS_BLOCK).setName("§bSpieländerung").setLore(" ", " §7Spieländerungen §bverändern", " §7das §bSpielgeschehen §7auf", " §7vielen Art und Weisen.", " ", " §b§oKlick §r§bÜbersicht").build());

                        inv.setItem(13, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());

                        inv.setItem(14, new ItemBuilder(Material.IRON_PICKAXE).setName("§6Funktion").setLore(" ", "§6Funktionen §7sind Modifikationen,", "§7welche §6kosmetisch §7und §6funktionell", "§7sind und das Spielgeschehen", "§6nicht beeinflussen§7.", " ", "§6§oKlick §r§6Übersicht").build());
                        inv.setItem(15, new ItemBuilder(Material.MAP).setName("§aSpielregel").setLore("", "§aSpielregeln §7sind die normale", "§a/gamerule§7s und weitere", "§aVeränderungen §7des Spielgeschehens", "§7mit normalen Mitteln von Minecraft.", " ", "§a§oKlick §r§aÜbersicht").build());

                        inv.setItem(16, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                        inv.setItem(17, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                        inv.setItem(18, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                        inv.setItem(19, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                        inv.setItem(20, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                        inv.setItem(21, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                        inv.setItem(22, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                        inv.setItem(23, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                        inv.setItem(24, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                        inv.setItem(25, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());
                        inv.setItem(26, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build());

                        event.setCancelled(true);
                        player.openInventory(inv);
                        break;
                }

            }
    }
}
