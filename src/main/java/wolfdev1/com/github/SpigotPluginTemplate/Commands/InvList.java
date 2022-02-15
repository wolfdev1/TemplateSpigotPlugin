package wolfdev1.com.github.SpigotPluginTemplate.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Arrays;
import java.util.Objects;

public class InvList implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(!sender.isOp()) {
            sender.sendMessage(ChatColor.RED +
                    "Sorry, but only staff members can perform this action");
        }else{
            if(args.length < 1) {
                sender.sendMessage(ChatColor.RED +
                        "Sorry, you need to select a user to see their inventory");
            }else{
                if(args.length > 1) {
                    sender.sendMessage(ChatColor.RED +
                            "Oops! So much arguments provided, try again, example: /invlist <player>");
                }else{
                    if(args[0].equalsIgnoreCase(sender.getName())) {
                        sender.sendMessage(ChatColor.RED + "Their inventory is... wait but you know your inventory");
                    }else{
                        sender.sendMessage("The inventory of " + args[0] + "list is: [" + Arrays.stream(Objects.requireNonNull
                                        (Bukkit.getPlayer(args[0])).
                                getInventory().getContents()).count() + "]\n" +
                                Arrays.toString(Objects.requireNonNull(Bukkit.getPlayer(args[0])).getInventory().getContents()));
                    }
                }
            }
        }
        return false;
    }
}
