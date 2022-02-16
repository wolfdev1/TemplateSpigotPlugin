package wolfdev1.com.github.SpigotPluginTemplate.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Objects;

public class KickCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if(!sender.isOp()) {
            sender.sendMessage(ChatColor.RED + "Sorry but only staff team members can perform this action");
        }else{
            if(args.length < 1) {
                sender.sendMessage(ChatColor.RED + "Sorry but you need to select an user to kick");
            }else{
                if(Bukkit.getPlayer(args[0]) == null) {
                    sender.sendMessage(ChatColor.RED + args[0] + " is not a valid user, try again");
                }else{
                    if(args[0].equalsIgnoreCase(sender.getName())) {
                        sender.sendMessage(ChatColor.RED + "User has been kic-.. wait.. no no");
                    }else{
                        if(Objects.requireNonNull(Bukkit.getPlayer(args[0])).isOp()) {
                            sender.sendMessage(ChatColor.RED + "Why you are trying to kick a staff?");
                        }else{
                            StringBuilder sb = new StringBuilder();
                            for(int i = 1; i < args.length; i++)
                            {
                                sb.append(args[i]).append(" ");
                            }
                            Bukkit.broadcast(ChatColor.RED + args[0] + ChatColor.GRAY
                                    + " has been kicked from the server\n" +
                                    ChatColor.RED + "Reason: " + ChatColor.GRAY + ChatColor.ITALIC +
                                            (args.length < 2 ? "No reason provided" : sb.toString())
                                    , "operatorperm");
                            Objects.requireNonNull(Bukkit.getPlayer(args[0])).
                                    kickPlayer(args.length < 2 ? null : sb.toString());
                        }
                    }
                }
            }
        }
        return false;
    }
}
