package wolfdev1.com.github.SpigotPluginTemplate.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Objects;

public class UserInfo implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args)
    {
        if(!sender.isOp())
        {
            sender.sendMessage(ChatColor.RED + "Sorry but only staff members can use this command");
        }else
        {
            if(args.length < 1) {
                sender.sendMessage(ChatColor.RED + "Hey! You need to select an user to get their info");
            }else
            {
                if(Bukkit.getPlayer(args[0]) == null) {
                    sender.sendMessage(ChatColor.RED + args[0] + " is not a valid user");
                }else{
                    if(args[0].equalsIgnoreCase(sender.getName())) {
                        sender.sendMessage(ChatColor.RED + "The info is... wait, you know your info");
                    }else{
                        if(Objects.requireNonNull(Bukkit.getPlayer(args[0])).getLocation().getWorld() == null) {
                            sender.sendMessage("The player is dead or disconected");
                        }else{
                            Location p = Objects.requireNonNull(Bukkit.getPlayer(args[0])).getLocation();
                            sender.sendMessage
                                    (ChatColor.BOLD + "" + ChatColor.DARK_GREEN + args[0] + "'s info\n" +
                                    ChatColor.WHITE + ChatColor.BOLD + "Coordinates: " + ChatColor.RESET + "" + ChatColor.GOLD +
                                    p.getBlockX() + " " + p.getBlockY() + " " + p.getBlockZ() + "\n" +
                                     ChatColor.WHITE + ChatColor.BOLD + "" + "World: " + "" +
                                    ChatColor.RESET + ChatColor.GOLD +
                                    Objects.requireNonNull(Objects.requireNonNull(p.getWorld()).getName()) + "\n" +
                                    ChatColor.WHITE + ChatColor.BOLD + "Biome: " + ChatColor.RESET + "" + ChatColor.GOLD +
                                    p.getBlock().getBiome().name() + "\n" +
                                    ChatColor.WHITE + ChatColor.BOLD + "User's ping: " + ChatColor.RESET + ChatColor.GOLD +
                                            Objects.requireNonNull(Bukkit.getPlayer(args[0])).getPing());
                        }
                    }
                }
            }
        }
        return false;
    }
}
