package wolfdev1.com.github.SpigotPluginTemplate.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class StaffChat implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
            if(args.length < 1) {
                sender.sendMessage(ChatColor.RED + "Oops! You need to provide a message to send, example: /staffchat Hello Staff :)");
            }else{
                StringBuilder sb = new StringBuilder();
                for (String arg : args) {
                    sb.append(arg).append(" ");
                }
                Bukkit.broadcast(
                         ChatColor.GOLD + "[" + ChatColor.DARK_PURPLE +
                                 "" + ChatColor.BOLD + "Staff" + ChatColor.DARK_BLUE + "Chat" + ChatColor.GOLD + "] " +
                        ChatColor.DARK_RED + "[" + ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD +  "Staff" + ChatColor.DARK_RED + "] "
                                 + sender.getName() + " " + ChatColor.YELLOW +    sb
                        , "operatorperm");
            }
        return false;
    }
}
