package wolfdev1.com.github.SpigotPluginTemplate.Commands;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class PunishCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
            if(args.length < 1) {
                sender.sendMessage(ChatColor.RED + "Hmm, it seems that you need to select an user, try again");
            }else{
                if(Bukkit.getPlayer(args[0]) == null) {
                    sender.sendMessage(ChatColor.RED + "Oops... " + args[0] + " is not a valid user, try again");
                }else{
                    if(args[0].equalsIgnoreCase(sender.getName())) {
                        sender.sendMessage(ChatColor.RED + "User has been punish- wait, wtf bro no");
                    }else{
                        if(Objects.requireNonNull(
                                Bukkit.getPlayer(args[0])).isOp()) {
                            sender.sendMessage("Why you are trying to punish a staff member .-.");
                        }else{
                            StringBuilder sb = new StringBuilder();
                            for(int i = 1; i < args.length; i++)
                            {
                                sb.append(args[i]).append(" ");
                            }

                            Objects.requireNonNull
                                    (Bukkit.getPlayer(args[0])).kickPlayer(ChatColor.DARK_GRAY + "" +  ChatColor.BOLD +
                                    "Survival 1.17.1\n" +
                                    ChatColor.DARK_RED + "Your are been banned from the server\n" +
                                    " \n" +
                                    ChatColor.DARK_PURPLE + ChatColor.BOLD + "Moderator: \n" + ChatColor.RESET + ChatColor.GRAY + sender.getName() + "\n" +
                                    ChatColor.DARK_PURPLE + ChatColor.BOLD + "Reason: \n" +
                                    ChatColor.RESET + ChatColor.GRAY + ChatColor.ITALIC
                                    +(args.length < 2 ? "No reason provided" : ChatColor.RESET + "" + ChatColor.GRAY + sb) + "\n" +
                                    ChatColor.DARK_PURPLE + ChatColor.BOLD + "Date: " + ChatColor.RESET + ChatColor.GRAY + "\n" +
                                    DateTimeFormatter.ofPattern("yy/MM/dd HH:mm:ss ").format(LocalDateTime.now()));

                            Bukkit.getBanList(BanList.Type.NAME).addBan(args[0],
                                            ChatColor.DARK_GRAY + "" +  ChatColor.BOLD +
                                                    "Survival 1.17.1\n" +
                                                    ChatColor.DARK_RED + "Your are been banned from the server\n" +
                                                    " \n" +
                                                    ChatColor.DARK_PURPLE + ChatColor.BOLD + "Moderator: \n" + ChatColor.RESET + ChatColor.GRAY + sender.getName() + "\n" +
                                                    ChatColor.DARK_PURPLE + ChatColor.BOLD + "Reason: \n" +
                                                    ChatColor.RESET + ChatColor.GRAY + ChatColor.ITALIC
                                                    +(args.length < 2 ? "No reason provided." : ChatColor.RESET + "" + ChatColor.GRAY + sb) + "\n" +
                                                    ChatColor.DARK_PURPLE + ChatColor.BOLD + "Date: " + ChatColor.RESET + ChatColor.GRAY + "\n" +
                                                    DateTimeFormatter.ofPattern("yy/MM/dd HH:mm:ss ").format(LocalDateTime.now()),
                                    null, null);
                        }
                    }
            }
        }
        return false;
    }
}
