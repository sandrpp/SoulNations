package de.sandrp.soulNations.systemclasses.register;


import de.sandrp.soulNations.nationarena.commands.NationArenaCommand;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.Command;

import org.jetbrains.annotations.NotNull;

import java.lang.String;
import java.util.HashMap;
import java.util.Map;

//This class register all commands
public class CommandRegister {

  private static final @NotNull Map<String, Command> COMMANDS = new HashMap<>();

  static {
    COMMANDS.put("nationarena", new NationArenaCommand());
  }

  public static void registerCommand(@NotNull String name, @NotNull Command command, @NotNull Server server){
    COMMANDS.put(name, command);
    CommandRegister.registerCommands(server);
  }

  public static void registerCommand(@NotNull String name, @NotNull Command command){
    COMMANDS.put(name, command);
    CommandRegister.registerCommands();
  }

  public static void registerCommands(@NotNull Server server){
    COMMANDS.forEach(((s, command) -> server.getCommandMap().register(s, "SoulNations", command)));
  }

  public static void registerCommands(){
    CommandRegister.registerCommands(Bukkit.getServer());
  }

  public static void unregisterCommands(@NotNull Server server){
    server.getCommandMap().clearCommands();
  }

  public static void unregisterCommands(){
    CommandRegister.unregisterCommands(Bukkit.getServer());
  }


}
