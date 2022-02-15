package wolfdev1.com.github.SpigotPluginTemplate.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class AdvancedSayCommand implements CommandExecutor {

    @Override

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!sender.isOp()) {
            sender.sendMessage(ChatColor.RED + "Oops! Only staff members can perform this action");
        }else{
            if(args.length < 1) {
                sender.sendMessage(ChatColor.RED + "Oops! You need to provide a message to send");
            }else{
                StringBuilder sb = new StringBuilder();
                for (String arg : args) {
                    sb.append(arg).append(" ");
                }

                Bukkit.broadcastMessage(ChatColor.DARK_RED +
                        "[" + ChatColor.LIGHT_PURPLE + "STAFF" + ChatColor.DARK_RED +"] " + ChatColor.AQUA + sb);
            }
    }
        return false;
    }
}
