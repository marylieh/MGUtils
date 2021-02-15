package de.asmax.butils.listener.specialhandler;

import de.asmax.butils.utils.GameStateManager;
import de.asmax.butils.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;

public class InventoryHandler implements Listener {

    public static void ZeroKiller(Player player) {
        player.playSound(player.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 2F, 1F);
        if(GameStateManager.zeroKiller) {
            GameStateManager.zeroKiller = false;
        } else {
            GameStateManager.zeroKiller = true;
        }
    }

    public static void AirBlock(Player player) {
        player.playSound(player.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 2F, 1F);
        if(GameStateManager.AirBlock) {
            GameStateManager.AirBlock = false;
        } else {
            GameStateManager.AirBlock = true;
        }
    }

    public static void updateCalInventory(Player player) {

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

    }

}
