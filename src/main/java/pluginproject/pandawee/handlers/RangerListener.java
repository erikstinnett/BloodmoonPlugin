package pluginproject.pandawee.handlers;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import pluginproject.pandawee.Classes.Ranger;

public class RangerListener implements Listener {

    private final Ranger ranger;

    public RangerListener(Ranger ranger) {
        this.ranger = ranger;
    }

    @EventHandler
    public void onPlayerToggleSneak(PlayerToggleSneakEvent event) {
        if (ranger.isRanger(event.getPlayer())) {
            event.getPlayer().setInvisible(event.isSneaking());
            if (event.isSneaking()) {
                event.getPlayer().sendMessage("You are now invisible.");
            } else {
                event.getPlayer().sendMessage("You are now visible.");
            }
        }
    }
}
