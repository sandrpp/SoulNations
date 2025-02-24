package de.sandrp.soulNations.events.snowballFight;

import de.sandrp.soulNations.Main;
import de.sandrp.soulNations.nationsSystem.Events;
import de.sandrp.soulNations.nationsSystem.TournamentManager;
import de.sandrp.soulNations.utils.Message;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.jetbrains.annotations.NotNull;

public class SnowballListener implements Listener {

    TournamentManager tournamentManager = Main.getTournamentManager();

    @EventHandler
    public void snowBallEvent(@NotNull EntityDamageByEntityEvent event) {
        if (!tournamentManager.isActive() && tournamentManager.getCurrentEvent() != Events.SNOWBALL_FIGHT) {
            return;
        }
        if(!(event.getDamager() instanceof Snowball snowball)){
            return;
        }
        if(!(snowball.getShooter() instanceof Player player) || !(event.getEntity() instanceof Player target)){
            return;
        }
        if (player == target){
            return;
        }
        if(!tournamentManager.contains(target) || !tournamentManager.contains(player)){
            return;
        }

        event.setDamage(0);
        tournamentManager.removePlayer(target);
        Message.standard("<grey>du bist ausgeschieden!", target);
        tournamentManager.broadcastToPlayers("<grey><#FF9BDF>" + target.getName() + "</#FF9BDF> ist ausgeschieden!");
    }
}
