package de.sandrp.soulNations.nationarena.system;

import com.booksaw.betterTeams.Team;
import de.sandrp.soulNations.Main;
import de.sandrp.soulNations.utils.ErrorMessage;
import de.sandrp.soulNations.utils.Message;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Arena {

    //set runnable
    private static BukkitRunnable runnable;

    //set spawn locations
    private final static Location spawnRed = new Location(Bukkit.getWorld("world"), 136.5, 71, -212.5, 180, 0);
    private final static Location spawnBlue = new Location(Bukkit.getWorld("world"), 176.5, 71, -212.5, 0, 0);
    private final static Location spawnAfterGame = new Location(Bukkit.getWorld("world"), 156.5, 71, -197.5, 180, 0);

    //set managers
    FightManager fightManager = new FightManager();
    PlayerManager playerManager = new PlayerManager();

    private int cooldown = 10;
    private boolean active = false;

    public void next(Player sender) {
        if (fightManager.getAkt().isRunning()){
            ErrorMessage.standard("aktuell läuft noch ein Kampf", sender);
            return;
        }

        //set activity (Listener needs to know if Arena is active)
        active = true;

        //create new fight
        fightManager.addFight(new Fight(null, null, null, true));

        //set Blue player as Random player
        Player playerBlue = playerManager.getRandomPlayer();
        fightManager.getAkt().setPlayerBlue(playerBlue);
        playerManager.removePlayer(playerBlue);
        Message.mainPrefix("mach dich bereit für den nächsten Kampf! Du tritts als blaues Team an", playerBlue);

        //set found as false
        boolean found = false;
        //search for Red Blue player
        for (Player playerRed : playerManager.getPlayers()) {
            if (!Team.getTeam(playerRed).equals(Team.getTeam(playerBlue))) {
                //set Red player
                fightManager.getAkt().setPlayerRed(playerRed);
                playerManager.removePlayer(playerRed);
                Message.mainPrefix("mach dich bereit für den nächsten Kampf! Du tritts als rotes Team an", playerRed);
                //set found
                found = true;
                break;
            }
        }
        //if no Red player found
        if(!found){
            for (Player broadcastPlayer : Bukkit.getOnlinePlayers()) {
                ErrorMessage.standard("Es konnte kein passender Gegner gefunden werden", playerBlue);
            }
            playerManager.addPlayer(playerBlue);
            return;
        }
        //announce fight
        for (Player broadcastPlayer : Bukkit.getOnlinePlayers()) {
            Message.mainPrefix("Im nächsten Kampf treten an: <#FF9BDF>" + fightManager.getAkt().getPlayerBlue().getName() + "</#FF9BDF> vs. <#FF9BDF>" + fightManager.getAkt().getPlayerRed().getName() + "</#FF9BDF>", broadcastPlayer);
        }

        runnable = new BukkitRunnable() {
            @Override
            public void run() {
                if(cooldown == 0) {
                    //beginn fight
                    fightManager.getAkt().getPlayerBlue().teleport(spawnBlue);
                    fightManager.getAkt().getPlayerRed().teleport(spawnRed);
                    Message.mainPrefix("Der Kampf beginnt! Viel Erfolg!", fightManager.getAkt().getPlayerBlue());
                    Message.mainPrefix("Der Kampf beginnt! Viel Erfolg!", fightManager.getAkt().getPlayerRed());
                    fightManager.getAkt().setRunning(true);
                    cancel();
                } else {
                    //countdown for fight
                    if(cooldown == 10){
                        sendCooldown(cooldown);
                    }
                    if(cooldown == 3){
                        sendCooldown(cooldown);
                    }
                    if(cooldown == 2){
                        sendCooldown(cooldown);
                    }
                    if(cooldown == 1){
                        sendCooldown(cooldown);
                    }
                    cooldown--;
                }
            }
        };
        runnable.runTaskTimer(Main.getInstance(), 0, 20);
    }

    public void sendCooldown(int pCooldown){
        for (Player broadcastPlayer : Bukkit.getOnlinePlayers()) {
            Message.mainPrefix("Der Kampf beginnt in <#FF9BDF>" + pCooldown + "</#FF9BDF> Sekunden", broadcastPlayer);
        }
    }

    public void reset() {
        fightManager.reset();
        playerManager.reset();
    }

    public PlayerManager getPlayerManager() {
        return playerManager;
    }

    public FightManager getFightManager() {
        return fightManager;
    }

    public boolean isActive() {
        return active;
    }
}
