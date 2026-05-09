package me.spectral8420.tempShelvesFix;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;

public class ConsoleHelper {
    public static void sendMessage(String message) {
        ConsoleCommandSender sender = Bukkit.getConsoleSender();
        sender.sendMessage(message);
    }
}
