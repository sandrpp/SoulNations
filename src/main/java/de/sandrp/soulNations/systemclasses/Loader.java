package de.sandrp.soulNations.systemclasses;

import io.papermc.paper.plugin.loader.PluginClasspathBuilder;
import io.papermc.paper.plugin.loader.PluginLoader;
import io.papermc.paper.plugin.loader.library.impl.JarLibrary;

import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;

//This class load all libraries
public class Loader implements PluginLoader {
  @Override
  public void classloader(@NotNull PluginClasspathBuilder classpathBuilder) {
    String projectPath = System.getProperty("user.dir");
    String libraryPath = projectPath + "/plugins/";
    String libraryPathGeo = projectPath + "/plugins/geoip2/";
    classpathBuilder.addLibrary(new JarLibrary(Path.of(libraryPath + "SoulLibrary-5.0.0.jar")));
    classpathBuilder.addLibrary(new JarLibrary(Path.of(libraryPathGeo + "geoip2-4.2.1.jar")));

  }
}
