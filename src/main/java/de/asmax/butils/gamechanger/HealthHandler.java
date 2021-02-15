package de.asmax.butils.gamechanger;

import de.asmax.butils.utils.GameStateManager;
import de.asmax.butils.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

public class HealthHandler implements Listener {

    public static void showHealthInv(Player player) {
        Inventory health = Bukkit.createInventory(null, InventoryType.WORKBENCH, "§6Einstellungen §8● §bMax. Herzen");

        health.setItem(1, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
        health.setItem(2, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
        health.setItem(3, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
        health.setItem(5, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
        health.setItem(7, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
        health.setItem(8, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());
        health.setItem(9, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setLore("§7§oKlicke, um zurückzugehen").build());

        health.setItem(4, new ItemBuilder(Material.PAPER).setName("§a§l+").build());
        health.setItem(6, new ItemBuilder(Material.PAPER).setName("§c§l-").build());
        health.setItem(0, new ItemBuilder(Material.PAPER).setName("§a§l" + GameStateManager.maxHealth).build());
        player.openInventory(health);
    }

    @EventHandler
    public void handleClicked(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if(event.getView().getTitle().equals("§6Einstellungen §8● §bMax. Herzen")) {
            switch (event.getCurrentItem().getItemMeta().getDisplayName()) {
                case "§a§l+":
                    event.setCancelled(true);
                    GameStateManager.maxHealth++;
                    Bukkit.getOnlinePlayers().forEach(all -> {
                        all.setMaxHealth(GameStateManager.maxHealth);
                    });
                    showHealthInv(player);
                    break;
                case "§c§l-":
                    event.setCancelled(true);
                    GameStateManager.maxHealth--;
                    Bukkit.getOnlinePlayers().forEach(all -> {
                        all.setMaxHealth(GameStateManager.maxHealth);
                    });
                    showHealthInv(player);
                    break;
                case " ":
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
                default:
                    event.setCancelled(true);
                    break;
            }
        }
    }
}
