package de.sandrp.soulNations;

import de.sandrp.soulNations.events.rlgl.RLGLManager;
import de.sandrp.soulNations.nationsSystem.TournamentManager;
import de.sandrp.soulNations.systemClasses.register.CommandRegister;
import de.sandrp.soulNations.systemClasses.register.EventRegister;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class Main extends JavaPlugin {

    private static Main instance;
    private static TournamentManager tournamentManager;
    private static RLGLManager rlglManager;

    @Override
    public void onEnable() {

        //set instance
        instance = this;

        //set event manager
        tournamentManager = new TournamentManager();

        //set other managers
        rlglManager = new RLGLManager();

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

    @NotNull
    public static TournamentManager getTournamentManager() {
        return tournamentManager;
    }

    @NotNull
    public static RLGLManager getRLGLManager() {
        return rlglManager;
    }
}
