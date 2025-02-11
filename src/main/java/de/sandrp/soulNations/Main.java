package de.sandrp.soulNations;

import de.sandrp.soulNations.systemclasses.register.CommandRegister;
import de.sandrp.soulNations.systemclasses.register.EventRegister;
import org.bukkit.Server;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class Main extends JavaPlugin {

    private static Main instance;

    @Override
    public void onEnable() {

        //set instance
        instance = this;

        //register all commands & events
        CommandRegister.registerCommands(this.getServer());
        EventRegister.registerEvents(this);

    }

    @Override
    public void onDisable() {
        //unregister all commands
        CommandRegister.unregisterCommands(this.getServer());
    }

    public static Main getInstance() {

        return instance;
    }
}
