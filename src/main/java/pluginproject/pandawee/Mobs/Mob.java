package pluginproject.pandawee.Mobs;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Zombie;
import org.bukkit.entity.Skeleton;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.enchantments.Enchantment;

import java.util.Random;

public class Mob {
    //Properties for mob
    public LivingEntity entity;
    private String name;
    private int strength;
    private int health;
    private int moveSpeed;

    //Constructor
    public Mob(LivingEntity entity, String name, int strength, int health, int moveSpeed) {
        this.entity = entity;
        this.name = name;
        this.strength = strength;
        this.health = health;
        this.moveSpeed = moveSpeed;
    }

    public LivingEntity getEntity() {
        return entity;
    }
    public String getName() {
        return name;
    }
    public int getStrength() {
        return strength;
    }
    public int getHealth() {
        return health;
    }
    public int getMoveSpeed() {
        return moveSpeed;
    }

    //Setters
    public void setEntity(LivingEntity entity) {
        this.entity = entity;
    }

    public void setName(String name) {
        this.name = name;
        entity.setCustomName(name);
        entity.setCustomNameVisible(false);
    }

    public void setStrength(int strength) {

        this.strength = strength;
        giveDamage();
    }

    public void setHealth(int health) {

        this.health = health;
        givehearts();
    }
    public void setMoveSpeed(int moveSpeed) {
        this.moveSpeed = moveSpeed;
        applyMoveSpeed(null);
    }


    //Returns modifier for movement speed
    public void applyMoveSpeed(Object multiplier) {
        Random rand = new Random();
        int randomSpeed = 2 + rand.nextInt(6);  //Randint 2 <= x <= 5
        if(multiplier != null){
            randomSpeed = (int)multiplier;
        }
        //Speed, max duration, randomspeed (2 - 6)
        entity.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, randomSpeed));
    }

    public void givehearts() {
        Random rand = new Random();
        double randomHealth = 20 + rand.nextInt(40);
        entity.setMaxHealth(60);
        entity.setHealth(randomHealth);
    }

    public void giveDamage() {
        Random rand = new Random();
        double randomDamage = 6 + rand.nextInt(30);
        AttributeInstance attribute = entity.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE);
        attribute.setBaseValue(randomDamage);
    }

    public void equipArmour(LivingEntity mobType) {
        String material = "";
        System.out.println("EQUIP ARNMS");
        Random rand = new Random();
        System.out.println("Mob: " + mobType);
        if(mobType instanceof Skeleton){
            if ((rand.nextInt(3)) == 2) {
                material = "GOLDEN";
                System.out.println("EQUIP D");

            }
        }
        if(mobType instanceof Zombie){
            if ((rand.nextInt(3)) == 2) {
                material = "IRON";
                System.out.println("EQUIP GOLD");

            }
        }
        if (!material.isEmpty()) {
            Material helmetMaterial = Material.valueOf(material + "_HELMET");
            Material chestPlateMaterial = Material.valueOf(material + "_CHESTPLATE");
            Material leggingsMaterial = Material.valueOf(material + "_LEGGINGS");
            Material bootsMaterial = Material.valueOf(material + "_BOOTS");

            System.out.println("Equipped");

            ItemStack helmet = new ItemStack(helmetMaterial);
            ItemStack chestplate = new ItemStack(chestPlateMaterial);
            ItemStack leggings = new ItemStack(leggingsMaterial);
            ItemStack boots = new ItemStack(bootsMaterial);

            if (rand.nextInt(10) < 3) {
                int protLevel = rand.nextInt(4) + 1;
                helmet.addUnsafeEnchantment(Enchantment.PROTECTION, protLevel);
                chestplate.addUnsafeEnchantment(Enchantment.PROTECTION, protLevel);
                leggings.addUnsafeEnchantment(Enchantment.PROTECTION, protLevel);
                boots.addUnsafeEnchantment(Enchantment.PROTECTION, protLevel);
            }

            Random random = new Random();

            if (random.nextBoolean()) {
                mobType.getEquipment().setHelmet(helmet);
            }
            if (random.nextBoolean()) {
                mobType.getEquipment().setChestplate(chestplate);
            }
            if (random.nextBoolean()) {
                mobType.getEquipment().setLeggings(leggings);
            }
            if (random.nextBoolean()) {
                mobType.getEquipment().setBoots(boots);
            }

            mobType.getEquipment().setHelmetDropChance(0.05f);
            mobType.getEquipment().setChestplateDropChance(.05f);
            mobType.getEquipment().setLeggingsDropChance(0.05f);
            mobType.getEquipment().setBootsDropChance(0.10f);
        }
    }

    public void equipWeapon(LivingEntity mobType) {
        Random rand = new Random();

        if (mobType instanceof Zombie) {
            if (rand.nextInt(5) < 2) {
                ItemStack sword = new ItemStack(Material.IRON_SWORD);
                entity.getEquipment().setItemInMainHand(sword);

            }

        } else if (mobType instanceof Skeleton) {
            ItemStack bow = new ItemStack(Material.BOW);

            int powerLevel = rand.nextInt(5) + 1;
            if (rand.nextBoolean()) {
                bow.addEnchantment(Enchantment.FLAME, 1);
            }
            bow.addEnchantment(Enchantment.POWER, powerLevel);
            entity.getEquipment().setItemInMainHand(bow);
            mobType.getEquipment().setItemInMainHandDropChance(0.5f);
        }
    }
}
