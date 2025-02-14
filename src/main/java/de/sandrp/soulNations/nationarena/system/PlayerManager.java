package de.sandrp.soulNations.nationarena.system;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlayerManager {
    List<Player> players = new ArrayList<>();

    public void addPlayer(Player player) {
        player.sendMessage("test3");
        players.add(player);
    }

    public void removePlayer(Player player) {
        players.remove(player);
    }

    public boolean containsPlayer(String playerName) {
        for (Player player : players) {
            if (player.getName().equals(playerName)) {
                return true;
            }
        }
        return false;
    }

    public void reset() {
        players.clear();
    }

    public Player getRandomPlayer() {
        Random random = new Random();
        int index = random.nextInt(players.size());
        return players.get(index);
    }

    public List<Player> getPlayers() {
        return players;
    }
}
