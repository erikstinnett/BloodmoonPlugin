package commands;
import pluginproject.pandawee.PandaweePlugin;

import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can run this command");
            return true;
        }
        Player player = (Player) sender;
        if (player.getAllowFlight()) {
            player.setAllowFlight(false);
            player.sendMessage("Flying disabled");
        } else {
            player.setAllowFlight(true);
            player.sendMessage("Flying!");
        }
        return true;
    }

}

