package de.sandrp.soulNations.systemClasses.register;

import de.sandrp.soulNations.events.rlgl.RLGLMoveListener;
import de.sandrp.soulNations.events.snowballFight.SnowballListener;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

//This class load all Events
public class EventRegister {

  private static final @NotNull Set<Listener> EVENTS =  new HashSet<>();

  static {
    EVENTS.add(new SnowballListener());
    EVENTS.add(new RLGLMoveListener());
  }

  public static void registerEvents(@NotNull Plugin plugin){
    EVENTS.forEach(listener -> Bukkit.getPluginManager().registerEvents(listener, plugin));
  }

}
