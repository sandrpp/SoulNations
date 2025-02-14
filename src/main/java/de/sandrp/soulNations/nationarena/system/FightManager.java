package de.sandrp.soulNations.nationarena.system;

import com.booksaw.betterTeams.Team;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FightManager {
    private List<Fight> fights = new ArrayList<>();

    public void addFight(Fight fight) {
        fights.add(fight);
    }

    public List<Result> getResults() {
        List<Result> results = new ArrayList<>();
        for (Fight fight : fights){
            if (results.stream().anyMatch(result -> result.getTeam().equals(Team.getTeam(fight.getWinner())))) {
                results.add(new Result(Team.getTeam(fight.getWinner()), 1));
            }
            results.stream().filter(result -> result.getTeam().equals(Team.getTeam(fight.getWinner()))).forEach(result -> result.addPoints(1));
        }
        return results;
    }

    public boolean containsFight(Fight fight) {
        return fights.contains(fight);
    }

    public boolean containsFight(Player playerBlue, Player playerRed) {
        for (Fight fight : fights) {
            if (fight.getPlayerBlue().equals(playerBlue) && fight.getPlayerRed().equals(playerRed)) {
                return true;
            }
        }
        return false;
    }

    public Fight getAkt(){
        return fights.getLast();
    }

    public void reset() {
        fights.clear();
    }

    public boolean hasFight(){
        return !fights.isEmpty();
    }
}
