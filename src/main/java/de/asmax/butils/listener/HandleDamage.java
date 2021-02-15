package de.asmax.butils.listener;

import de.asmax.butils.utils.GameStateManager;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class HandleDamage implements Listener {

    @EventHandler
    public void handleDamageEvent(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {

            Player player = (Player) event.getEntity();

                if (GameStateManager.timerIsRunning) {
                    if (!GameStateManager.timerIsPaused) {
                        if (GameStateManager.onDamageClear) {

                            for (Player all : Bukkit.getOnlinePlayers()) {

                                all.getInventory().clear();
                                Bukkit.broadcastMessage("§8[§4§lDamageClear§r§8] §6Der Spieler §c" + player.getName() + "§6 hat §4Schaden §6erlitten, das Inventar aller Spieler wurde §cgeleert§6!");
                                all.playSound(all.getLocation(), Sound.BLOCK_ANVIL_LAND, 2F, 1F);

                            }
                        }
                    } else {
                        event.setCancelled(true);
                    }
                } else {
                    event.setCancelled(true);
                }
        }
    }
}
