package de.asmax.butils.listener;

import de.asmax.butils.utils.GameStateManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class HandleEntityDamage implements Listener {

    @EventHandler
    public void handleDamageEvent(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player) {

            Player player = (Player) event.getEntity();

                if (GameStateManager.timerIsRunning) {
                    if (!GameStateManager.timerIsPaused) {

                        if(GameStateManager.printDmg) {
                            Bukkit.broadcastMessage("§8[§6Schaden§8] §9" + player.getName() + " §7hat durch §9§l" + event.getDamager().getName() + "§r§9 " + event.getDamage() + " §9Herzen §7Schaden bekommen.");
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
