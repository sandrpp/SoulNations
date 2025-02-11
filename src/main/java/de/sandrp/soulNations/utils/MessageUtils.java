package de.sandrp.soulNations.utils;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class MessageUtils {

  @NotNull
  public static String shortInteger(@NotNull int duration) {
    String string = "";
    int hours = 0;
    int minutes = 0;
    int seconds = 0;
    if(duration / 60 / 60 >=1) {
      hours = duration / 60 /60;
      duration = duration - ((duration / 60 / 60) * 60 * 60);
    }
    if(duration / 60 >= 1) {
      minutes = duration / 60;
      duration = duration - ((duration /60)*60);
    }
    if(duration >=1) {
      seconds = duration;
    }
    if(hours!=0) {
      if (hours <= 9) {
        string = string + "0" + hours + "h ";
      } else {
        string = string + hours + "h ";
      }
    }
    if(minutes!=0) {
      if (minutes <= 9) {
        string = string + "0" + minutes + "m ";
      } else {
        string = string + minutes + "m ";
      }
    }
    if(seconds <=9) {
      string= string+"0"+seconds+"s";
    }else{
      string= string+seconds+"s";
    }
    return string;
  }

  public static String shortInteger(@NotNull long duration) {
    StringBuilder string = new StringBuilder(); // Use StringBuilder for efficiency
    long hours = 0;
    long minutes = 0;
    long seconds = 0;

    if (duration / 60 / 60 >= 1) {
      hours = duration / 60 / 60;
      duration -= hours * 60 * 60; // More efficient subtraction
    }
    if (duration / 60 >= 1) {
      minutes = duration / 60;
      duration -= minutes * 60; // More efficient subtraction
    }
    seconds = duration; // No need for if (duration >= 1) as it's the remainder

    if (hours != 0) {
      string.append(String.format("%02d", hours)).append("h "); // Formatted output
    }
    if (minutes != 0) {
      string.append(String.format("%02d", minutes)).append("m "); // Formatted output
    }
    string.append(String.format("%02d", seconds)).append("s"); // Formatted output
    return string.toString();
  }
  public static String shortDate(long number) {
    Date date = new Date(number);
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy, HH:mm:ss"); // Format nach Wunsch anpassen
    sdf.setTimeZone(TimeZone.getTimeZone("Europe/Berlin"));
    return sdf.format(date);
  }
}
