package pluginproject.pandawee.Mobs;

import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Zombie extends Mob{
    public Zombie(LivingEntity entity, String name, int strength, int health, int moveSpeed) {
        super(entity, name, strength, health, moveSpeed);
    }
}
