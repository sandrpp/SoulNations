package de.sandrp.soulNations.nationarena.commands;

import de.sandrp.soulNations.nationarena.system.Arena;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class NaNext {

    public static boolean execute(@NotNull Player player, @NotNull String @NotNull [] args, Arena arena) {
        arena.next(player);
        return true;
    }
}
