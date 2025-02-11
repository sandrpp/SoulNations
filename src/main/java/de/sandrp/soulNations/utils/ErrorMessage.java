package de.sandrp.soulNations.utils;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

//This class sends error messages.
//Coded by Gemmerr -> Edited by Elia (Edit MessageBuilder)
public class ErrorMessage {

  public static void noPermission(Player player) {
      Message.errorPrefix("<red>hierzu hast du keine Rechte", player);
  }
  public static void noPermission(CommandSender sender) {
    Message.errorPrefix("<red>hierzu hast du keine Rechte", sender);
  }
    public static void noPlayer(CommandSender commandSender) {
      Message.errorPrefix("<red>hierzu musst du ein Spieler sein", commandSender);
    }
    public static void usage(String message, Player player) {
      Message.errorPrefix("<red>Usage: " + message + "</red>", player);
    }
    public static void usage(String message, CommandSender sender) {
    Message.errorPrefix("<red>Usage: " + message + "</red>", sender);
  }
    public static void standard(String message, Player player) {
      Message.errorPrefix("<red>" + message, player);
    }
  public static void standard(String message, CommandSender sender) {
    Message.errorPrefix("<red>" + message, sender);
  }
}
