package de.asmax.butils.listener;

import de.asmax.butils.utils.GameStateManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class HandleOtherDamage implements Listener {

    @EventHandler
    public void handleOtherDamage(EntityDamageEvent event) {

        if(GameStateManager.timerIsRunning) {
            if(!GameStateManager.timerIsPaused) {
                if(GameStateManager.printDmg) {

                    if(!(event.getEntity() instanceof Player)) {

                    }

                    Player player = (Player)event.getEntity();

                    if(event.getCause().equals(EntityDamageEvent.DamageCause.ENTITY_ATTACK)) {

                    } else if(event.getCause().equals(EntityDamageEvent.DamageCause.ENTITY_EXPLOSION)) {

                    } else if(event.getCause().equals(EntityDamageEvent.DamageCause.ENTITY_SWEEP_ATTACK)) {

                    } else if(event.getCause().equals(EntityDamageEvent.DamageCause.WITHER)) {

                    } else {

                        Bukkit.getOnlinePlayers().forEach(all -> {

                            Bukkit.broadcastMessage("§8[§6Schaden§8] §9" + player.getName() + " §7hat durch §9§l" + event.getCause() + "§r§9 " + event.getDamage() + " §9Herzen §7Schaden bekommen.");

                        });

                    }

                }
            }
        }
    }
}
