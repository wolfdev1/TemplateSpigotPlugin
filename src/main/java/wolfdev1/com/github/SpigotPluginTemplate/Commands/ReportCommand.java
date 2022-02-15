package wolfdev1.com.github.SpigotPluginTemplate.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class ReportCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(args.length < 2) {

            sender.sendMessage(ChatColor.RED + "Oops, you need to select a user and a reason, example: /report <user> <reason>");
        }else{
            if(Bukkit.getPlayer(args[0]) == null) {
                sender.sendMessage(ChatColor.RED + args[0] + " is not a valid user, try again");
            }else{
            if(args[0].equalsIgnoreCase(sender.getName())) {
                sender.sendMessage(ChatColor.RED + "Sorry but you can't report yourself");
            }else {
                if(Objects.requireNonNull(Bukkit.getPlayer(args[0])).isOp()) {
                    sender.sendMessage(ChatColor.RED + "Oops... You cannot report staff members");
                }else{
                    StringBuilder sb = new StringBuilder();
                    for(int i = 1; i < args.length; i++)
                    {
                        sb.append(args[i]).append(" ");
                    }
                    sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "[ReportSystem] " + ChatColor.RESET + ""
                            + ChatColor.GRAY + "The report to " + args[0] + " has been successfully sent to the staff");
                    Bukkit.broadcast(ChatColor.GOLD + "" + ChatColor.BOLD + "[ReportSystem]" + ChatColor.RESET + "\n" +
                            ChatColor.WHITE + "" + ChatColor.BOLD + "Time: " + ChatColor.RESET + "" + ChatColor.LIGHT_PURPLE +
                            DateTimeFormatter.ofPattern("HH:ss:mm").
                            format(LocalDateTime.now()) + "\n" +
                            ChatColor.WHITE + "" + ChatColor.BOLD + "User Reported: " + ChatColor.RESET + "" + ChatColor.LIGHT_PURPLE + args[0] + "\n" +
                          ChatColor.WHITE  + "" + ChatColor.BOLD + "Reason: " + ChatColor.LIGHT_PURPLE + sb, "operatorperm");
                    }
                }
            }
        }
        return false;
    }
}
