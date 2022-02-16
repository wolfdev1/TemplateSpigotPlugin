package wolfdev1.com.github.SpigotPluginTemplate.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Objects;

public class PvpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if(!sender.isOp()) {
            sender.sendMessage(ChatColor.RED + "Sorry, but only staff team members can perform this action");
        }else{
            if(args.length < 1) {
                sender.sendMessage(ChatColor.RED + "You need to provide a boolean value, true or false");
            }else{
                if(args[0].equalsIgnoreCase("true") || args[0].equalsIgnoreCase("false")) {
                    Objects.requireNonNull(Bukkit.getPlayer(sender.getName())).getWorld().
                            setPVP(Boolean.parseBoolean(args[0]));
                    Bukkit.broadcast(ChatColor.GOLD + "[+] " + ChatColor.GRAY + "The pvp in the world '" +
                            Objects.requireNonNull(Bukkit.getPlayer(sender.getName())).getWorld().getName()
                                    + "' has been set to " + ChatColor.RED
                            + args[0],
                            "operatorperm");
                }else{
                    sender.sendMessage(ChatColor.RED + "You need to provide a boolean value, true or false");
                }
            }
        }
        return false;
    }
}
