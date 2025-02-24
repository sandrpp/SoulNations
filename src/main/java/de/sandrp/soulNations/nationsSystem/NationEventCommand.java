package de.sandrp.soulNations.nationsSystem;

import de.sandrp.soulNations.Main;
import de.sandrp.soulNations.utils.ErrorMessage;
import de.sandrp.soulNations.utils.Message;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NationEventCommand extends Command {
    protected NationEventCommand(@NotNull String name) {
        super(name);
    }

    public NationEventCommand() {
        super("nationevent");
    }

    TournamentManager tournamentManager = Main.getTournamentManager();

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel, @NotNull String @NotNull [] args) {
        if (!(sender instanceof Player player)){
            ErrorMessage.noPlayer(sender);
            return false;
        }
        if(!player.hasPermission("soulsmp.nationevent") || !player.isOp()){
            ErrorMessage.noPermission(player);
            return false;
        }
        if (args.length == 0) {
            ErrorMessage.usage("/nationevent <start|end|addPlayer|removePlayer|clearPlayers|getPlayers|setEvent>", player);
            return false;
        }
        switch (args[0].toLowerCase()) {
            case "start":
                tournamentManager.startTournament();
                Message.mainPrefix("Turnier gestartet", player);
                break;
            case "end":
                tournamentManager.endTournament();
                Message.mainPrefix("Turnier beendet", player);
                break;
            case "addplayer":
                if (args.length < 2) {
                    ErrorMessage.usage("/nationevent addPlayer <player>", player);
                    return false;
                }
                Player targetAdd = player.getServer().getPlayer(args[1]);
                if (targetAdd == null) {
                    ErrorMessage.standard("dieser Spieler existiert nicht", player);;
                    return false;
                }
                if (tournamentManager.addPlayer(targetAdd)) {
                    Message.mainPrefix("Spieler hinzugefügt", player);
                } else {
                    ErrorMessage.standard("dieser Spieler ist bereits angemeldet", player);
                }
                break;
            case "removeplayer":
                if (args.length < 2) {
                    ErrorMessage.usage("/nationevent removePlayer <player>", player);
                    return false;
                }
                Player targetRemove = player.getServer().getPlayer(args[1]);
                if (targetRemove == null) {
                    ErrorMessage.standard("dieser Spieler existiert nicht", player);
                    return false;
                }
                if(tournamentManager.removePlayer(targetRemove)){
                    Message.mainPrefix("Spieler entfernt", player);
                } else {
                    ErrorMessage.standard("dieser Spieler ist nicht angemeldet", player);
                }
                break;
            case "clearplayers":
                tournamentManager.clearPlayers();
                Message.mainPrefix("Spielerliste geleert", player);
                break;
            case "getplayers":
                List<Player> players = tournamentManager.getPlayers();
                String playerList = "<#FF9BDF>Teilnehmer:</#FF9BDF> <grey>" + players.stream().map(Player::getName).collect(Collectors.joining(", "));
                Message.standard(playerList, player);
                break;
            case "setevent":
                if (args.length < 2) {
                    ErrorMessage.usage("/nationevent setEvent <event>", player);
                    return false;
                }
                switch (args[1]) {
                    case "none":
                        tournamentManager.setCurrentEvent(Events.NONE);
                        break;
                    case "snowball":
                        tournamentManager.setCurrentEvent(Events.SNOWBALL_FIGHT);
                        break;
                    case "general":
                        tournamentManager.setCurrentEvent(Events.GENERAL_FIGHT);
                        break;
                    case "redlightgreenlight":
                        tournamentManager.setCurrentEvent(Events.RED_LIGHT_GREEN_LIGHT);
                        break;
                    default:
                        ErrorMessage.standard("Dieses Event existiert nicht", player);
                        return false;
                }
                break;
            default:
                ErrorMessage.usage("/nationevent <start|end|addPlayer|removePlayer|clearPlayers|getPlayers>|setEvent", player);
                return false;
        }
        return true;
    }

    @Override
    public @NotNull List<String> tabComplete(@NotNull CommandSender sender, @NotNull String alias, @NotNull String @NotNull [] args) throws IllegalArgumentException {
        List<String> defaultArgs = new ArrayList<>();
        defaultArgs.add("start");
        defaultArgs.add("end");
        defaultArgs.add("addPlayer");
        defaultArgs.add("removePlayer");
        defaultArgs.add("clearPlayers");
        defaultArgs.add("getPlayers");
        defaultArgs.add("setEvent");

        List<String> events = new ArrayList<>();
        events.add("snowball");
        events.add("none");

        if(args.length == 1){
            return defaultArgs;
        }
        if(args.length == 2 && args[0].toLowerCase().equals("setevent")){
            return events;
        }
        return null;
    }


}
