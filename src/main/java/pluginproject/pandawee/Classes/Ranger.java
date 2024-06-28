package pluginproject.pandawee.Classes;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import pluginproject.pandawee.Utils.Utils;

import java.util.HashSet;
import java.util.Set;

public class Ranger implements CommandExecutor {

    private final JavaPlugin plugin;
    private final Set<Player> rangers = new HashSet<>();

    public Ranger(JavaPlugin plugin) {
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
                rangers.add(player);
                player.sendMessage(ChatColor.GREEN + "You are now a Ranger. Crouch to become invisible.");

            } else {
                rangers.remove(player);
                player.sendMessage(ChatColor.RED + "You can only become a Ranger on a full moon!");
                player.setInvisible(false); // Ensure the player is visible when they leave Ranger mode
            }
            return true;
        } else {
            sender.sendMessage("This command can only be run by a player.");
            return false;
        }
    }

    public boolean isRanger(Player player) {
        return rangers.contains(player);
    }

    public void removeRanger(Player player) {
        rangers.remove(player);
        player.setInvisible(false);
        player.sendMessage(ChatColor.RED + "You are no longer a Ranger bro.");
    }

    public void checkDawn() {
        for (Player player : rangers) {
            if (player.getWorld().getTime() >= 0 && player.getWorld().getTime() <= 140) {
                removeRanger(player);
            }
        }
    }
}
