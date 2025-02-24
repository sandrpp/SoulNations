package de.sandrp.soulNations.nationsSystem;

import de.sandrp.soulNations.utils.Message;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class TournamentManager {
    private boolean active = false;
    private List<Player> players = new ArrayList<>();
    private Events currentEvent = Events.NONE;

    public boolean addPlayer(Player player){
        if(contains(player)){
            return false;
        }
        players.add(player);
        return true;
    }

    public boolean removePlayer(Player player){
        if (!contains(player)){
            return false;
        }
        players.remove(player);
        return true;
    }

    public List<Player> getPlayers(){
        return players;
    }

    public void clearPlayers(){
        players.clear();
    }

    public int getPlayersCount(){
        return players.size();
    }

    public boolean contains(Player player){
        return players.contains(player);
    }

    public void startTournament(){
        active = true;
    }

    public void endTournament(){
        active = false;
    }

    public boolean isActive(){
        return active;
    }

    public void setCurrentEvent(Events event){
        currentEvent = event;
    }

    public Events getCurrentEvent() {
        return currentEvent;
    }

    public void broadcastToPlayers(String message) {
        players.stream()
                .filter(Player::isOnline)
                .forEach(player -> Message.standard(message, player));
    }
}
