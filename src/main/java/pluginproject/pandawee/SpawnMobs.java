package pluginproject.pandawee;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Creeper;
import pluginproject.pandawee.Mobs.*;
import pluginproject.pandawee.Utils.Utils;

import java.util.Random;

public class SpawnMobs {

    private final Random rand = new Random();
    Bloodmoon bm = new Bloodmoon();
    public void spawnZombie(Player player, boolean bmFlag) {
        Location spawnLocation = findValidSpawnLocation(player.getLocation(), 24, 128);
        if (spawnLocation != null) {
            World world = spawnLocation.getWorld();
            LivingEntity entity = (LivingEntity) world.spawnEntity(spawnLocation, EntityType.ZOMBIE);

            if(bmFlag){
                Zombie zombie = new Zombie(entity, "KEVIN", 20, 20, 10);

            }
            else {
                Zombie zombie = new Zombie(entity, "Kevin", 10, 10, 5);
                zombie.givehearts();
                zombie.giveDamage();
                zombie.applyMoveSpeed(2);
                zombie.equipArmour(entity);
                zombie.equipWeapon(entity);
            }

        }
    }

    public void spawnSkeleton(Player player, boolean bmFlag) {
        Location spawnLocation = findValidSpawnLocation(player.getLocation(), 24, 128);
        if (spawnLocation != null) {
            World world = spawnLocation.getWorld();
            LivingEntity entity = (LivingEntity) world.spawnEntity(spawnLocation, EntityType.SKELETON);
            if(bmFlag){
                Skeleton skeleton = new Skeleton(entity, "RIK", 20, 20, 10);
                skeleton.givehearts();
                skeleton.equipArmour(entity);
                skeleton.equipWeapon(entity);
            }
            else {
                Skeleton skeleton = new Skeleton(entity, "Rik", 10, 10, 5);
                skeleton.givehearts();
                skeleton.equipArmour(entity);
                skeleton.equipWeapon(entity);
            }

        }
    }

    public void spawnSpider(Player player, boolean bmFlag) {
        Location spawnLocation = findValidSpawnLocation(player.getLocation(), 24, 128);
        if (spawnLocation != null) {
            World world = spawnLocation.getWorld();
            LivingEntity entity = (LivingEntity) world.spawnEntity(spawnLocation, EntityType.SPIDER);
            if(bmFlag){
                Spider spider = new Spider(entity, "SPIDIGGA", 20, 20, 10);
                spider.applyMoveSpeed(null);
            }
            else {
                Spider spider = new Spider(entity, "Spidigga", 10, 10, 5);
                spider.applyMoveSpeed(null);
            }

        }
    }

    public void spawnCreeper(Player player, boolean bmFlag) {
        Location spawnLocation = findValidSpawnLocation(player.getLocation(), 24, 128);
        if (spawnLocation != null) {
            World world = spawnLocation.getWorld();
            if (rand.nextInt(10) == 2) {
                Creeper chargedCreeper = (Creeper) world.spawnEntity(spawnLocation, EntityType.CREEPER);
                chargedCreeper.setPowered(true);
                chargedCreeper.setCustomName("Charged Crepussy");
            } else {
                LivingEntity entity = (LivingEntity) world.spawnEntity(spawnLocation, EntityType.CREEPER);
                CustomCreeper creeper = new CustomCreeper(entity, "Crepussy", 10, 10, 6);
                creeper.applyMoveSpeed(null);
            }
        }
    }

    private Location findValidSpawnLocation(Location center, int minDistance, int maxDistance) {
        World world = center.getWorld();
        if (world == null) return null;

        Location spawnLocation = null;
        for (int i = 0; i < 100; i++) { // Try up to 100 times to find a valid location
            double angle = rand.nextDouble() * 2 * Math.PI;
            double distance = minDistance + rand.nextDouble() * (maxDistance - minDistance);
            double x = center.getX() + distance * Math.cos(angle);
            double z = center.getZ() + distance * Math.sin(angle);
            int y = world.getHighestBlockYAt((int) x, (int) z);
            spawnLocation = new Location(world, x, (y + 1), z);
            Block block = world.getBlockAt(spawnLocation);

            if (!Utils.isLeaves(block) &&world.getBlockAt(spawnLocation).getLightLevel() < 7) {
                System.out.println("LIGHT LEVEL: "+ world.getBlockAt(spawnLocation).getLightLevel());
                return spawnLocation;
            }
        }
        return null; // No valid location found
    }
}
