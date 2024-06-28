package pluginproject.pandawee;

import commands.Fly;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Sound;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import pluginproject.pandawee.Classes.Ranger;
import pluginproject.pandawee.Classes.Scout;
import pluginproject.pandawee.handlers.*;

import java.util.Set;

import static org.bukkit.Bukkit.getServer;
import static org.bukkit.Bukkit.getWorld;

public final class PandaweePlugin extends JavaPlugin implements Listener {
    private Scout scoutCommand;
    private Ranger ranger;


    @Override
    public void onEnable() {

        getLogger().info("NightTimeAnnouncer has been enabled");
        Bloodmoon bm = new Bloodmoon();
        getServer().getPluginManager().registerEvents(new MobDeathListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerDeathListener(), this);

        scoutCommand = new Scout(this);
        this.getCommand("scout").setExecutor(scoutCommand);
        getServer().getPluginManager().registerEvents(this, this);

        ranger = new Ranger(this);
        this.getCommand("ranger").setExecutor(ranger);
        getServer().getPluginManager().registerEvents(new RangerListener(ranger), this);

        // Schedule a task to check for dawn every 5 seconds (100 ticks)
        Bukkit.getScheduler().runTaskTimer(this, () -> scoutCommand.checkDawn(), 0L, 100L);
        Bukkit.getScheduler().runTaskTimer(this, () -> ranger.checkDawn(), 0L, 100L);

        // Schedule a repeating task to check the time every 5 seconds (100 ticks)
        new BukkitRunnable() {
            @Override
            public void run() {
                bm.checkDusk();

            }
        }.runTaskTimer(this, 0L, 60L);
        new BukkitRunnable() {
            @Override
            public void run() {
                bm.spawnWaves();

            }
        }.runTaskTimer(this, 0L, 1200L);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("Goodnight moon");

    }
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("gettime")) {
            if (sender instanceof Player) {

                Player player = (Player) sender;
                long time = player.getWorld().getTime();
                player.sendMessage("Current in-game time: " + time);

                return true;
            } else {
                sender.sendMessage("This command can only be run by a player.");
                return false;
            }
        }
        return false;
    }
}
