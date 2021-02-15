package de.asmax.butils.listener;

import de.asmax.butils.utils.GameStateManager;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class BlockBreak implements Listener {

    @EventHandler
    public void handleBlockBreak(BlockBreakEvent event) {
        if(!GameStateManager.timerIsPaused) {
            if(GameStateManager.timerIsRunning) {

                if(GameStateManager.eRandomizer) {

                    Random r = new Random();
                    int rnd = r.nextInt(992);

                    System.out.println(rnd);

                    Block block = event.getBlock();
                    block.setType(Material.AIR);
                    ItemStack itemStack = new ItemStack(Material.values()[rnd]);
                    block.getWorld().dropItemNaturally(block.getLocation(), itemStack);

                }

            }
        }
    }
}
