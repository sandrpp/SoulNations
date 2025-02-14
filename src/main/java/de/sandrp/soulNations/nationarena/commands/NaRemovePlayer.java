package de.sandrp.soulNations.nationarena.commands;

import com.booksaw.betterTeams.Team;
import de.sandrp.soulNations.nationarena.system.PlayerManager;
import de.sandrp.soulNations.utils.ErrorMessage;
import de.sandrp.soulNations.utils.Message;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class NaRemovePlayer {
    public static boolean execute(@NotNull Player player, @NotNull String @NotNull [] args, PlayerManager playerManager) {
        if (args.length != 2) {
            ErrorMessage.usage("/nationarena addTeam <teamName>", player);
            return false;
        }
        String playerName = args[1];
        if (!playerManager.containsPlayer(playerName)) {
            ErrorMessage.standard("dieser Spieler ist noch nicht eingetragen", player);
            return false;
        }
        Player targetPlayer = Bukkit.getPlayerExact(playerName);
        if (targetPlayer == null) {
            ErrorMessage.standard("Spieler nicht gefunden", player);
            return false;
        }
        playerManager.removePlayer(targetPlayer);
        Message.mainPrefix("<grey>Spieler <#FF9BDF>" + playerName + "</#FF9BDF> vom Team <#FF9BDF>" + Team.getTeam(player) + "</#FF9BDF> wurde vom aktuellen Event entfernt", player);
        return true;
    }
}
