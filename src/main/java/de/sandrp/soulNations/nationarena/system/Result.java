package de.sandrp.soulNations.nationarena.system;

import com.booksaw.betterTeams.Team;

public class Result {
    private Team team;
    private int points;

    public Result(Team team, int points) {
        this.team = team;
        this.points = points;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public Team getTeam() {
        return team;
    }

    public int getPoints() {
        return points;
    }
}
