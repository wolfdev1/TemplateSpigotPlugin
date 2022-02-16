package wolfdev1.com.github.SpigotPluginTemplate.Events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class PlayerChangeWorldLogger implements Listener {
    @EventHandler
    public void onPlayerChangedWorld(PlayerChangedWorldEvent event) {
        String w = event.getPlayer().getWorld().getName();

        if(w.equalsIgnoreCase("world")) {
            Bukkit.broadcast(ChatColor.GOLD
            + "[+] " + ChatColor.DARK_RED + event.getPlayer().getName() + ChatColor.GRAY +
               " has been traveled to " + ChatColor.DARK_RED + "OVERWORLD"
                    , "operatorperm");
        }
        if(w.equalsIgnoreCase("world_nether")) {
            Bukkit.broadcast(ChatColor.GOLD
                            + "[+] " + ChatColor.DARK_RED + event.getPlayer().getName() + ChatColor.GRAY +
                            " has been traveled to " + ChatColor.DARK_RED + "NETHER"
                    , "operatorperm");
        }
        if(w.equalsIgnoreCase("world_the_end")) {
            Bukkit.broadcast(ChatColor.GOLD
                            + "[+] " + ChatColor.DARK_RED + event.getPlayer().getName() + ChatColor.GRAY +
                            " has been traveled to " + ChatColor.DARK_RED + "THE END"
                    , "operatorperm");
        }
    }
}
