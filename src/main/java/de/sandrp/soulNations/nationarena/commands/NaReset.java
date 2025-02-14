package de.sandrp.soulNations.nationarena.commands;

import de.sandrp.soulNations.nationarena.system.Arena;
import de.sandrp.soulNations.utils.ErrorMessage;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class NaReset {
    public static boolean execute(@NotNull Player player, @NotNull String @NotNull [] args, Arena arena) {
        if (args.length != 1) {
            ErrorMessage.usage("/nationarena reset", player);
            return false;
        }
        arena.reset();
        return true;

        //TODO bestätigungsnachricht
    }
}
