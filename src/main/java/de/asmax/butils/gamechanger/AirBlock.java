package de.asmax.butils.gamechanger;

import de.asmax.butils.main.Main;
import de.asmax.butils.utils.AntiLag;
import de.asmax.butils.utils.GameStateManager;
import de.asmax.butils.utils.Lag;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

public class AirBlock implements Listener {

    @EventHandler
    public static void breakBlock(BlockBreakEvent event) {
        if(GameStateManager.timerIsRunning) {
            if(GameStateManager.AirBlock) {

                Player player = event.getPlayer();
                Block normalBlock = event.getBlock();
                Material targetBlock = event.getBlock().getType();
                ItemStack drop = new ItemStack(targetBlock);
                Chunk c = player.getLocation().getChunk();
                ItemStack defaultDrops = null;
                for(ItemStack im : normalBlock.getDrops()) {
                    defaultDrops = im;
                }

                for(int x = 0; x < 16; x++) {
                    for(int z = 0; z < 16; z++) {
                        for(int y = 0; y <256; y++) {
                            Block block = c.getBlock(x,y,z);

                            if(!(block.getType().equals(targetBlock)))continue;

                            block.setType(Material.AIR);
                            if(GameStateManager.weakServer) {
                                if(targetBlock == Material.STONE) {

                                } else if(targetBlock == Material.NETHERRACK) {

                                } else {
                                    player.getLocation().getWorld().dropItemNaturally(player.getLocation(), defaultDrops);
                                }
                            } else {
                                player.getLocation().getWorld().dropItemNaturally(player.getLocation(), defaultDrops);
                                if(player.getWorld().getEntities().size() > 8000) {
                                    for(Player all : Bukkit.getOnlinePlayers()) {
                                        all.kickPlayer("Das AntiLag System hat einen Schwerwiegenden Einbruch in der Server Leistung festgestellt. Der Server wird nun vom AntiLag System bereinigt. Bitte habe einen Moment Geduld.");
                                        AntiLag.instantLag();
                                    }
                                }
                            }
                        }
                    }
                }

            } else {
                return;
            }
        } else {
            return;
        }
    }

    @EventHandler
    public static void handlePlace(BlockPlaceEvent event) {
        if(GameStateManager.timerIsRunning) {
            if(GameStateManager.AirBlock) {

                Player player = event.getPlayer();
                Block normalBlock = event.getBlockAgainst();
                Chunk c = player.getLocation().getChunk();
                Material targetBlock = event.getBlockAgainst().getType();
                ItemStack defaultDrops = null;
                for(ItemStack im : normalBlock.getDrops()) {
                    defaultDrops = im;
                }

                for(int x = 0; x < 16; x++) {
                    for(int z = 0; z < 16; z++) {
                        for(int y = 0; y <256; y++) {
                            Block block = c.getBlock(x,y,z);

                            if(!(block.getType().equals(targetBlock)))continue;

                            block.setType(Material.AIR);
                            if(GameStateManager.weakServer) {
                                if(targetBlock == Material.STONE) {

                                } else if(targetBlock == Material.NETHERRACK) {

                                } else {
                                    player.getLocation().getWorld().dropItemNaturally(player.getLocation(), defaultDrops);
                                }
                            } else {
                                player.getLocation().getWorld().dropItemNaturally(player.getLocation(), defaultDrops);
                                if(player.getWorld().getEntities().size() > 8000) {
                                    for(Player all : Bukkit.getOnlinePlayers()) {
                                        all.kickPlayer("Das AntiLag System hat einen Schwerwiegenden Einbruch in der Server Leistung festgestellt. Der Server wird nun vom AntiLag System bereinigt. Bitte habe einen Moment Geduld.");
                                        AntiLag.instantLag();
                                    }
                                }
                            }

                            if(player.getWorld().getEntities().size() > 8000) {
                                for(Player all : Bukkit.getOnlinePlayers()) {
                                    all.kickPlayer("Das AntiLag System hat einen Schwerwiegenden Einbruch in der Server Leistung festgestellt. Der Server wird nun vom AntiLag System bereinigt. Bitte habe einen Moment Geduld.");
                                    AntiLag.instantLag();
                                }
                            }
                        }
                    }
                }

            } else {
                return;
            }
        } else {
            return;
        }
    }

}
//player.getLocation().getWorld().dropItemNaturally(player.getLocation(), defaultDrops);