package me.spectral8420.tempShelvesFix;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class TempShelvesFix extends JavaPlugin {
    @Override
    public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents(new MainListener(), this);
        ConsoleHelper.sendMessage(ChatColor.GREEN + "TempShelvesFix has been enabled!");
    }

    @Override
    public void onDisable() {
        ConsoleHelper.sendMessage(ChatColor.RED + "empShelvesFix has been disabled!");
    }
}
