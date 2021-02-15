package de.asmax.butils.functions;

import de.asmax.butils.main.Main;
import de.asmax.butils.utils.GameStateManager;
import org.bukkit.Bukkit;
import org.bukkit.scoreboard.*;

public class TabHealth {

    public static void showHealthInTab() {



            Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
                @Override
                public void run() {
                    if(GameStateManager.dmgTab) {
                        Bukkit.getOnlinePlayers().forEach(player -> {
                            ScoreboardManager sbm = Bukkit.getScoreboardManager();
                            Scoreboard health = sbm.getNewScoreboard();
                            Objective obj = health.registerNewObjective("health", "health&quot");
                            obj.setDisplaySlot(DisplaySlot.PLAYER_LIST);
                            int h = (int) (player.getHealth());
                            obj.getScore(player).setScore(h);
                            obj.setRenderType(RenderType.HEARTS);
                            player.setScoreboard(health);
                        });
                    }
                }
            }, 0, 3);
    }
}
