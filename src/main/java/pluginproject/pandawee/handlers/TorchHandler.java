package pluginproject.pandawee.handlers;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import pluginproject.pandawee.PandaweePlugin;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.EventPriority;

/** Priority
 * Lowest
 * Low
 * Normal
 * High
 * Highest
 * ---
 * Monitor
 */

public class TorchHandler implements Listener {
    public TorchHandler(PandaweePlugin plugin) {
        Bukkit.getPluginManager().registerEvents(this,plugin);
    }
    @EventHandler(priority = EventPriority.LOW)
    public void onTorchPlace_Low(BlockPlaceEvent e){
        if(e.getBlock().getType() == Material.TORCH){
//            Entity tnt = e.getPlayer().getWorld().spawn(e.getBlock().getLocation(), TNTPrimed.class);
//            ((TNTPrimed)tnt).setFuseTicks(0);
            e.getBlock().setType(Material.DIAMOND_BLOCK);
        }
    }
    @EventHandler
    public void onTorchPlace_Normal(BlockPlaceEvent e) {
        Block block = e.getBlock();

        if(block.getType() != Material.TORCH) {
            return;
        }
        Bukkit.getLogger().info("A torch was placed");

    }
}
