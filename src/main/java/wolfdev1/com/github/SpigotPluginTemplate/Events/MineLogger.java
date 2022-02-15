package wolfdev1.com.github.SpigotPluginTemplate.Events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class MineLogger implements Listener {
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Block b = event.getBlock();
        Player p = event.getPlayer();

        if(b.getType() == Material.REDSTONE_ORE || b.getType() == Material.DEEPSLATE_REDSTONE_ORE) {

            Bukkit.broadcast(ChatColor.GOLD +
                    "[+] " + p.getName() + " has been mined " + ChatColor.BOLD + ChatColor.RED + b.getType(),
                    "operatorperm");
            }else{
            if(b.getType() == Material.GOLD_ORE || b.getType() == Material.DEEPSLATE_GOLD_ORE) {
                Bukkit.broadcast(ChatColor.GOLD +
                        "[+] " + ChatColor.GRAY + p.getName() + " has been mined " + ChatColor.BOLD +ChatColor.GOLD + b.getType(),
                        "operatorperm");
            }else{
                if(b.getType() == Material.IRON_ORE || b.getType() == Material.DEEPSLATE_IRON_ORE) {
                    Bukkit.broadcast(ChatColor.GOLD +
                            "[+] " + ChatColor.GRAY + p.getName() + " has been mined " + ChatColor.BOLD + ChatColor.WHITE + b.getType(),
                            "operatorperm");
                }else{
                    if(b.getType() == Material.EMERALD_ORE || b.getType() == Material.DEEPSLATE_EMERALD_ORE) {
                        Bukkit.broadcast(ChatColor.GOLD +
                                "[+] " + ChatColor.GRAY + p.getName() + " has been mined " + ChatColor.BOLD + ChatColor.GREEN + b.getType(),
                                "operatorperm") ;
                    }else{
                        if(b.getType() == Material.DIAMOND_ORE || b.getType() == Material.DEEPSLATE_DIAMOND_ORE) {
                            Bukkit.broadcast(ChatColor.GOLD +
                                    "[+] " + ChatColor.GRAY + p.getName() + " has been mined " + ChatColor.BOLD + ChatColor.AQUA + b.getType(),
                                    "operatorperm");
                        }else{
                            if(b.getType() == Material.ANCIENT_DEBRIS) {

                                Bukkit.broadcast(ChatColor.GOLD +
                                        "[+] " + ChatColor.GRAY + p.getName() + " has been mined " + ChatColor.BOLD + ChatColor.DARK_RED + b.getType(),
                                        "operatorperm");
                            }

                    }
                }
            }
        }
        }

    }
}
