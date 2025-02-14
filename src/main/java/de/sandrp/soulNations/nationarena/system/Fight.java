package de.sandrp.soulNations.nationarena.system;

import org.bukkit.entity.Player;

public class Fight {
    private Player playerBlue;
    private Player playerRed;
    private Player winner;
    private boolean running;

    public Fight(Player playerBlue, Player playerRed, Player winner, boolean running) {
        this.playerBlue = playerBlue;
        this.playerRed = playerRed;
        this.winner = winner;
        this.running = running;
    }

    public Player getPlayerBlue() {
        return playerBlue;
    }

    public Player getPlayerRed() {
        return playerRed;
    }

    public Player getWinner() {
        return winner;
    }

    public boolean isRunning() {
        return running;
    }

    public void setPlayerBlue(Player playerBlue) {
        this.playerBlue = playerBlue;
    }

    public void setPlayerRed(Player playerRed) {
        this.playerRed = playerRed;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
