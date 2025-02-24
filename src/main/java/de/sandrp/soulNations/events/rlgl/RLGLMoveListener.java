package de.sandrp.soulNations.events.rlgl;

import de.sandrp.soulNations.Main;
import de.sandrp.soulNations.nationsSystem.Events;
import de.sandrp.soulNations.nationsSystem.TournamentManager;
import de.sandrp.soulNations.utils.Message;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class RLGLMoveListener implements Listener {
    RLGLManager rlglManager = Main.getRLGLManager();
    TournamentManager tournamentManager = Main.getTournamentManager();
    @EventHandler
    public void moveEvent(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if(!tournamentManager.isActive()){
            //cancle move Event if RLGL is not active but selected
            if (tournamentManager.getCurrentEvent() != Events.RED_LIGHT_GREEN_LIGHT){
                return;
            }
            if (!tournamentManager.contains(player)){
                return;
            }
            event.setCancelled(true);
        }
        if (tournamentManager.getCurrentEvent() != Events.RED_LIGHT_GREEN_LIGHT){
            return;
        }
        if (!tournamentManager.contains(player)){
            return;
        }
        if (rlglManager.isGreen()){
            return;
        }
        tournamentManager.removePlayer(player);
        Message.standard("<grey>du bist ausgeschieden!", player);
        tournamentManager.broadcastToPlayers("<grey><#FF9BDF>" + player.getName() + "</#FF9BDF> ist ausgeschieden!");
    }
}
