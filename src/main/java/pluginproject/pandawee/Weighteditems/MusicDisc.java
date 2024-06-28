package pluginproject.pandawee.Weighteditems;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import static pluginproject.pandawee.handlers.MobDeathListener.randomGenerator;

public class MusicDisc {
    static String[] musicDiscTypes = {
            "MUSIC_DISC_13",
            "MUSIC_DISC_CAT",
            "MUSIC_DISC_BLOCKS",
            "MUSIC_DISC_CHIRP",
            "MUSIC_DISC_FAR",
            "MUSIC_DISC_MALL",
            "MUSIC_DISC_MELLOHI",
            "MUSIC_DISC_STAL",
            "MUSIC_DISC_STRAD",
            "MUSIC_DISC_WARD",
            "MUSIC_DISC_11",
            "MUSIC_DISC_WAIT",
            "MUSIC_DISC_PIGSTEP",
            "MUSIC_DISC_OTHERSIDE",
            "MUSIC_DISC_RELIC",
            "MUSIC_DISC_5",
            "MUSIC_DISC_RELIC"
    };
    private static WeightedItem createMusicDisc() {
        ItemStack musicDisc = new ItemStack(Material.valueOf(musicDiscTypes[randomGenerator(musicDiscTypes.length)]));
        return new WeightedItem(musicDisc, 25.0); // Example weight
    }

}
