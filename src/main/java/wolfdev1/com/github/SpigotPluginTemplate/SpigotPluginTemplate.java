package wolfdev1.com.github.SpigotPluginTemplate;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import wolfdev1.com.github.SpigotPluginTemplate.Commands.AdvancedSayCommand;
import wolfdev1.com.github.SpigotPluginTemplate.Commands.InvList;
import wolfdev1.com.github.SpigotPluginTemplate.Commands.ReportCommand;
import wolfdev1.com.github.SpigotPluginTemplate.Commands.StaffChat;
import wolfdev1.com.github.SpigotPluginTemplate.Events.MineLogger;

public class SpigotPluginTemplate extends JavaPlugin

{
    public void onEnable() {
        Bukkit.getLogger().info(ChatColor.AQUA + "The " + this.getName() + "plugin has been successfully started globally");
        getServer().getPluginManager().registerEvents(new MineLogger(), this);
        this.getCommand("report").setExecutor(new ReportCommand());
        this.getCommand("invlist").setExecutor(new InvList());
        this.getCommand("staffchat").setExecutor(new StaffChat());
        this.getCommand("advancedsay").setExecutor(new AdvancedSayCommand());
    }
    public void onDisable() {
        Bukkit.getLogger().info(ChatColor.AQUA + "The " + this.getName() + "plugin has been successfully started globally");
    }
}
