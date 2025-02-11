package de.sandrp.soulNations.nationarena.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class NationArenaCommand extends Command
{
    protected NationArenaCommand(@NotNull String name) {
        super(name);
    }

    public NationArenaCommand(){
        this("nationarena");
    }

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel, @NotNull String @NotNull [] args) {
        return false;
    }
}
