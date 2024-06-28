package pluginproject.pandawee.handlers;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import pluginproject.pandawee.PandaweePlugin;
import org.bukkit.event.Listener;
import org.bukkit.Material;

public class PlayerHandler implements Listener {
    public PlayerHandler(PandaweePlugin plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        ItemStack item = new ItemStack(Material.SHORT_GRASS, 10);
        Inventory inv = player.getInventory();
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Weed");
        item.setItemMeta(meta);

        inv.addItem(item);
        inv.setItem(8, item);
    }


}
