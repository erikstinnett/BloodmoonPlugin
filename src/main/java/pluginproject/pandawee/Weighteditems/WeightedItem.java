package pluginproject.pandawee.Weighteditems;

import org.bukkit.inventory.ItemStack;

public class WeightedItem {
    private final ItemStack item;
    private final double weight;

    public WeightedItem(ItemStack item, double weight) {
        this.item = item;
        this.weight = weight;
    }

    public ItemStack getItem() {
        return item;
    }

    public double getWeight() {
        return weight;
    }
}
