package pluginproject.pandawee.handlers;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import pluginproject.pandawee.PandaweePlugin;

import static org.bukkit.Bukkit.getServer;

public class MoonHandler implements Listener {
    String world = "world";

    public MoonHandler(PandaweePlugin plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    public boolean isNight(){
        long time = getServer().getWorld(world).getTime();
        return time == 12000;
    }

    public void printStringIfDusk(){
        boolean isDusk = isNight();
        if(isDusk){
            Bukkit.getLogger().info("A torch was placed");
        }
    }

}
