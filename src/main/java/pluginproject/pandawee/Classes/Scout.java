package pluginproject.pandawee.Classes;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashSet;
import java.util.Set;

public class Scout implements CommandExecutor {

    private final JavaPlugin plugin;
    private final Set<Player> scouts = new HashSet<>();
    public Scout(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            World world = player.getWorld();
            long time = world.getFullTime();

            // Check if it’s a full moon
            boolean isFullMoon = (time >= 13000 && time <= 23999) && (world.getFullTime() / 24000) % 8 == 0;

            if (isFullMoon) {
                if (!isScout(player)) {
                    // Apply the movement speed buff
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1, true, false));
                    AttributeInstance attribute = player.getAttribute(Attribute.GENERIC_MAX_HEALTH);
                    attribute.setBaseValue(10);
                    scouts.add(player);
                    player.sendMessage(ChatColor.GREEN + "You have been given the scout movement speed buff!");
                } else {
                    player.sendMessage(ChatColor.RED +"You are already a scout or ranger.");
                }
            } else {
                player.sendMessage(ChatColor.RED + "You can only become a scout on a full Yeehaw!");
                AttributeInstance attribute = player.getAttribute(Attribute.GENERIC_MAX_HEALTH);
                attribute.setBaseValue(20);            }
            return true;
        } else {
            sender.sendMessage("This command can only be run by a player.");
            return false;
        }
    }
    public boolean isScout(Player player) {
        return scouts.contains(player);
    }
    public void removeScoutEffect(Player player) {
        if (scouts.contains(player)) {
            player.removePotionEffect(PotionEffectType.SPEED);
            AttributeInstance attribute = player.getAttribute(Attribute.GENERIC_MAX_HEALTH);
            attribute.setBaseValue(20);
            scouts.remove(player);
            player.sendMessage(ChatColor.RED + "Your scout movement speed buff has worn off!");
        }
    }

    public void checkDawn() {
        for (Player player : scouts) {
            if (player.getWorld().getTime() >= 0 && player.getWorld().getTime() <= 140) {
                removeScoutEffect(player);
            }
        }
    }
}
