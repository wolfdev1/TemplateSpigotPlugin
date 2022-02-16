package wolfdev1.com.github.SpigotPluginTemplate.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Objects;

public class HealCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
            if(args.length < 1) {
                GameMode gm = Objects.requireNonNull(Bukkit.getPlayer(sender.getName())).getGameMode();
                if(gm == GameMode.CREATIVE  || gm == GameMode.SPECTATOR) {
                    sender.sendMessage
                            (ChatColor.RED + "Sorry but you need to select an user or stay in gamemode survival, try again");
                }else{
                    sender.sendMessage(ChatColor.GOLD + "[+] " + ChatColor.GRAY + "Your health has been regenerated");
                    Objects.requireNonNull(Bukkit.getPlayer(sender.getName())).setHealth(20);
                }
            }else{
                if(Bukkit.getPlayer(args[0]) == null) {
                    sender.sendMessage(ChatColor.RED + "Sorry but " + args[0] + " is not a valid user, try again");
                }else{
                    sender.sendMessage("The health of " + args[0] + " has been regenerated");
                    Objects.requireNonNull(Bukkit.getPlayer(sender.getName())).setHealth(20);
                    }
            }
        return false;
    }
}

