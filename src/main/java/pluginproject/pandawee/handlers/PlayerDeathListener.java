package pluginproject.pandawee.handlers;
import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import pluginproject.pandawee.Bloodmoon;
import pluginproject.pandawee.Classes.Scout;
import pluginproject.pandawee.PandaweePlugin;
import org.bukkit.entity.Player;

public class PlayerDeathListener implements Listener {

    private JavaPlugin plugin;
    private Scout scout;

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {

        Bloodmoon bm = new Bloodmoon();
        long time = Bukkit.getWorld("world").getTime();
        scout.removeScoutEffect((Player)event);

        if (bm.checkBloodMoon() && time >= 13000 && time <= 23992) {
            event.getDrops().clear();
        }
    }
}
