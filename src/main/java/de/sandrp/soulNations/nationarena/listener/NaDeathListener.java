package de.sandrp.soulNations.nationarena.listener;

import de.sandrp.soulNations.Main;
import de.sandrp.soulNations.nationarena.system.Arena;
import de.sandrp.soulNations.nationarena.system.FightManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class NaDeathListener implements Listener {
    Arena arena = Main.getArena();
    FightManager fightManager = arena.getFightManager();

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        if(!arena.isActive()) {
            return;
        }
        if(!fightManager.hasFight()){
            return;
        }
        if(fightManager.getAkt().isRunning()) {
            Player player = event.getEntity();
            if(player.equals(fightManager.getAkt().getPlayerBlue())) {
                //set Red as winner
                fightManager.getAkt().setWinner(fightManager.getAkt().getPlayerRed());
            } else if (player.equals(fightManager.getAkt().getPlayerRed())) {
                //set Blue as winner
                fightManager.getAkt().setWinner(fightManager.getAkt().getPlayerBlue());
            }
            fightManager.getAkt().setRunning(false);
        }
    }
}
