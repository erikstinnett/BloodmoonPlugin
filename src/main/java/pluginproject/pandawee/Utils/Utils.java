package pluginproject.pandawee.Utils;

import org.bukkit.Material;
import org.bukkit.block.Block;
import pluginproject.pandawee.Classes.Ranger;
import pluginproject.pandawee.Classes.Scout;

public class Utils {
    private static Scout scoutCommand;
    private static Ranger ranger;

    public static boolean isLeaves(Block block) {
        Material material = block.getType();
        return material == Material.OAK_LEAVES || material == Material.SPRUCE_LEAVES ||
                material == Material.BIRCH_LEAVES || material == Material.JUNGLE_LEAVES ||
                material == Material.ACACIA_LEAVES || material == Material.DARK_OAK_LEAVES ||
                material == Material.MANGROVE_LEAVES || material == Material.AZALEA_LEAVES ||
                material == Material.FLOWERING_AZALEA_LEAVES;
    }

}
