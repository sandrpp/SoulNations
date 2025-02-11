package de.sandrp.soulNations.systemclasses.register;

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

  }

  public static void registerEvents(@NotNull PluginManager pluginManager, @NotNull Plugin plugin){
    EVENTS.forEach(listener -> pluginManager.registerEvents(listener, plugin));
  }

  public static void registerEvents(@NotNull Plugin plugin){
    EVENTS.forEach(listener -> Bukkit.getPluginManager().registerEvents(listener, plugin));
  }

  public static void registerEvent(@NotNull PluginManager pluginManager, @NotNull Listener listener, @NotNull Plugin plugin){
    EVENTS.add(listener);
    pluginManager.registerEvents(listener, plugin);
  }

  public static void registerEvent(@NotNull Listener listener, @NotNull Plugin plugin){
    Bukkit.getPluginManager().registerEvents(listener, plugin);
  }

}
