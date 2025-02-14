package de.sandrp.soulNations.nationarena;

import de.sandrp.soulNations.Main;
import de.sandrp.soulNations.nationarena.commands.*;
import de.sandrp.soulNations.nationarena.system.Arena;
import de.sandrp.soulNations.utils.ErrorMessage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class NationArenaCommand extends Command
{
    protected NationArenaCommand(@NotNull String name) {
        super(name);
    }

    public NationArenaCommand(){
        this("nationarena");
    }

    Arena arena = Main.getArena();;

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel, @NotNull String @NotNull [] args) {
        if (!(sender instanceof Player player)) {
            ErrorMessage.noPlayer(sender);
            return false;
        }
        if(args.length == 0){
            sendUsage(player);
            return false;
        }
        if (!player.hasPermission("soulsmp.admin") || !player.isOp()){
            ErrorMessage.noPermission(player);
            return false;
        }
        switch (args[0].toLowerCase()){
            case "reset":
                NaReset.execute(player, args, arena);
                break;
            case "results":
                NaResults.execute(player, args, arena);
                break;
            case "addplayer":
                NaAddPlayer.execute(player, args, arena.getPlayerManager());
                break;
            case "removeplayer":
                NaRemovePlayer.execute(player, args, arena.getPlayerManager());
                break;
            case "next":
                NaNext.execute(player, args, arena);
                break;
            default:
                sendUsage(player);
                break;
        }
        return true;
    }
    public void sendUsage(Player player){
        ErrorMessage.usage("/nationarena <reset|addTeam|removeTeam|results|addPlayer|removePlayer|next>", player);
    }

    @Override
    public @NotNull List<String> tabComplete(@NotNull CommandSender sender, @NotNull String alias, @NotNull String[] args) throws IllegalArgumentException {
        if(args.length == 1) {
            List<String> list = new ArrayList<String>();
            list.add("reset");
            list.add("results");
            list.add("addPlayer");
            list.add("removePlayer");
            list.add("next");
            return list;
        }
        return null;
    }
}
