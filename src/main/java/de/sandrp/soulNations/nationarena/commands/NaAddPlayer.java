package de.sandrp.soulNations.nationarena.commands;

import com.booksaw.betterTeams.Team;
import de.sandrp.soulNations.nationarena.system.PlayerManager;
import de.sandrp.soulNations.utils.ErrorMessage;
import de.sandrp.soulNations.utils.Message;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class NaAddPlayer {
    public static boolean execute(@NotNull Player player, @NotNull String @NotNull [] args, PlayerManager playerManager) {
        if (args.length != 2) {
            ErrorMessage.usage("/nationarena addPlayer <player>", player);
            return false;
        }
        String playerName = args[1];
        if (playerManager.containsPlayer(playerName)) {
            ErrorMessage.standard("dieser Spieler ist bereits eingetragen", player);
            return false;
        }
        player.sendMessage("test1");
        Player targetPlayer = Bukkit.getPlayerExact(playerName);
        if (targetPlayer == null) {
            ErrorMessage.standard("Spieler nichdddddddddt gefunden", player);
            return false;
        }
        player.sendMessage("test2");
        playerManager.addPlayer(targetPlayer);
        Message.mainPrefix("<grey>Spieler <#FF9BDF>" + playerName + "</#FF9BDF> vom Team <#FF9BDF>" + Team.getTeam(player) + "</#FF9BDF> wurde zum aktuellen Event hinzugefügt", player);
        return true;
    }
}
