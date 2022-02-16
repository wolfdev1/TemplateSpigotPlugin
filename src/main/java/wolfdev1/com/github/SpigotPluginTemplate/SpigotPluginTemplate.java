package wolfdev1.com.github.SpigotPluginTemplate;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import wolfdev1.com.github.SpigotPluginTemplate.Commands.*;
import wolfdev1.com.github.SpigotPluginTemplate.Events.MineLogger;

public class SpigotPluginTemplate extends JavaPlugin

{
    public void onEnable() {
        Bukkit.getLogger().info(ChatColor.AQUA + "The " + this.getName() + "plugin has been successfully started globally");
        getServer().getPluginManager().registerEvents(new MineLogger(), this);
        this.getCommand("report").setExecutor(new ReportCommand());
        this.getCommand("userinfo").setExecutor(new UserInfo());
        this.getCommand("pvp").setExecutor(new PvpCommand());
        this.getCommand("heal").setExecutor(new HealCommand());
        this.getCommand("kick").setExecutor(new KickCommand());
        this.getCommand("invlist").setExecutor(new InvList());
        this.getCommand("staffchat").setExecutor(new StaffChat());
        this.getCommand("advancedsay").setExecutor(new AdvancedSayCommand());
    }
    public void onDisable() {
        Bukkit.getLogger().info(ChatColor.AQUA + "The " + this.getName() + "plugin has been successfully started globally");
    }
}
