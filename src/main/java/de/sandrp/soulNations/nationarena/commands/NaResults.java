package de.sandrp.soulNations.nationarena.commands;

import de.sandrp.soulNations.nationarena.system.Arena;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class NaResults {
    public static boolean execute(@NotNull Player player, @NotNull String @NotNull [] args, Arena arena) {
        if (args.length != 1) {
            return false;
        }
        String results = "Ergebnisse: ";

        arena.getFightManager().getResults().forEach((result) -> player.sendMessage("<#FF9BDF>" + result.getTeam().getName() + "</#FF9BDF> <grey>(" + result.getPoints() + ")</grey>, "));
        return true;
    }
}
