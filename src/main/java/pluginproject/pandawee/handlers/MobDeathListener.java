package pluginproject.pandawee.handlers;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;
import pluginproject.pandawee.Weighteditems.WeightedItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MobDeathListener implements Listener {

    private final List<WeightedItem> possibleDrops = new ArrayList<>(Arrays.asList(
            new WeightedItem(new ItemStack(Material.DIAMOND, 1), 15.0),
            new WeightedItem(new ItemStack(Material.EMERALD, 1), 40.0),
            new WeightedItem(new ItemStack(Material.IRON_INGOT, 1), 50.0),
            new WeightedItem(new ItemStack(Material.GOLD_INGOT, 1), 40.0),
            new WeightedItem(new ItemStack(Material.GOLD_NUGGET, 1), 30),
            new WeightedItem(new ItemStack(Material.DIAMOND_BLOCK, 1), 5),
            new WeightedItem(new ItemStack(Material.NETHERITE_INGOT, 1), 1.0),
            createEnchantedBook(), // 1% any enchanted book
            createEnchantedBookPower3(), // 1% Power 3
            createEnchantedBookPunch(), // 1% Punch
            createEnchantedBookFlame(), // 1% Flame
            createEnchantedBookUnbreaking2(), // 1% Unbreaking 2
            createEnchantedBookProtection2(), // 1% Protection 2
            createEnchantedBookFeatherFalling3(), // 1% Feather Falling 3
            createEnchantedBookFireProtection3(), // 1% Fire Protection 3
            createEnchantedBookBlastProtection3(), // 1% Blast Protection 3
            createEnchantedBookEfficiency2(), // 1% Efficiency 2
            createEnchantedBookBaneOfArthropods2(), // 1% Bane of Arthropods 2
            createEnchantedBookSmite2(), // 1% Smite 2
            createEnchantedBookLooting2(), // 1% Looting 2
            createEnchantedBookFireAspect1(), // 1% Fire Aspect 1
            createEnchantedBookFortune2(), // 1% Fortune 2
            createEnchantedBookInfinity(), // 1% Infinity
            createEnchantedBookSilkTouch(), // 1% Silk Touch
            createEnchantedBookMending(), // 1% Mending            new WeightedItem(new ItemStack(Material.GOLDEN_APPLE, 1), 25.0),
            new WeightedItem(new ItemStack(Material.GOLD_INGOT, 1), 50.0),
            createChainmailArmor(), // 2% any chainmail armor piece with protection 4
            new WeightedItem(new ItemStack(Material.NETHER_STAR, 1), 0.1),
            createEnchantedItem(Material.DIAMOND_SWORD, Enchantment.SHARPNESS, 6, 0.05),
            createEnchantedItem(Material.BOW, Enchantment.POWER, 6, 0.05),
            createEnchantedItem(Material.DIAMOND_PICKAXE, Enchantment.EFFICIENCY, 6, 0.05),
            createPotion(), // 10% any splash potion
            createMusicDisc13(),
            createMusicDiscCat(),
            createMusicDiscBlocks(),
            createMusicDiscChirp(),
            createMusicDiscFar(),
            createMusicDiscMall(),
            createMusicDiscMellohi(),
            createMusicDiscStal(),
            createMusicDiscStrad(),
            createMusicDiscWard(),
            createMusicDisc11(),
            createMusicDiscWait(),
            createMusicDiscPigstep(),
            createMusicDiscOtherside(),
            createMusicDiscRelic(),
            createMusicDisc5(),
            new WeightedItem(new ItemStack(Material.HORSE_SPAWN_EGG, 1), 1.0), // Example mob spawn egg
            new WeightedItem(new ItemStack(Material.EXPERIENCE_BOTTLE, 1), 10.0),
            new WeightedItem(new ItemStack(Material.CARROT, 1), 12.0)
    ));

    public static int randomGenerator(int bounds) {
        Random rand = new Random();
        return rand.nextInt(bounds);
    }

    private static WeightedItem createMusicDisc13() {
        ItemStack musicDisc = new ItemStack(Material.MUSIC_DISC_13);
        return new WeightedItem(musicDisc, 1);
    }

    private static WeightedItem createMusicDiscCat() {
        ItemStack musicDisc = new ItemStack(Material.MUSIC_DISC_CAT);
        return new WeightedItem(musicDisc, 1);
    }

    private static WeightedItem createMusicDiscBlocks() {
        ItemStack musicDisc = new ItemStack(Material.MUSIC_DISC_BLOCKS);
        return new WeightedItem(musicDisc, 1);
    }

    private static WeightedItem createMusicDiscChirp() {
        ItemStack musicDisc = new ItemStack(Material.MUSIC_DISC_CHIRP);
        return new WeightedItem(musicDisc, 1);
    }

    private static WeightedItem createMusicDiscFar() {
        ItemStack musicDisc = new ItemStack(Material.MUSIC_DISC_FAR);
        return new WeightedItem(musicDisc, 1);
    }

    private static WeightedItem createMusicDiscMall() {
        ItemStack musicDisc = new ItemStack(Material.MUSIC_DISC_MALL);
        return new WeightedItem(musicDisc, 1);
    }

    private static WeightedItem createMusicDiscMellohi() {
        ItemStack musicDisc = new ItemStack(Material.MUSIC_DISC_MELLOHI);
        return new WeightedItem(musicDisc, 1);
    }

    private static WeightedItem createMusicDiscStal() {
        ItemStack musicDisc = new ItemStack(Material.MUSIC_DISC_STAL);
        return new WeightedItem(musicDisc, 1);
    }

    private static WeightedItem createMusicDiscStrad() {
        ItemStack musicDisc = new ItemStack(Material.MUSIC_DISC_STRAD);
        return new WeightedItem(musicDisc, 1);
    }

    private static WeightedItem createMusicDiscWard() {
        ItemStack musicDisc = new ItemStack(Material.MUSIC_DISC_WARD);
        return new WeightedItem(musicDisc, 1);
    }

    private static WeightedItem createMusicDisc11() {
        ItemStack musicDisc = new ItemStack(Material.MUSIC_DISC_11);
        return new WeightedItem(musicDisc, 1);
    }

    private static WeightedItem createMusicDiscWait() {
        ItemStack musicDisc = new ItemStack(Material.MUSIC_DISC_WAIT);
        return new WeightedItem(musicDisc, 1);
    }

    private static WeightedItem createMusicDiscPigstep() {
        ItemStack musicDisc = new ItemStack(Material.MUSIC_DISC_PIGSTEP);
        return new WeightedItem(musicDisc, 1);
    }

    private static WeightedItem createMusicDiscOtherside() {
        ItemStack musicDisc = new ItemStack(Material.MUSIC_DISC_OTHERSIDE);
        return new WeightedItem(musicDisc, 1);
    }

    private static WeightedItem createMusicDiscRelic() {
        ItemStack musicDisc = new ItemStack(Material.MUSIC_DISC_RELIC);
        return new WeightedItem(musicDisc, 1);
    }

    private static WeightedItem createMusicDisc5() {
        ItemStack musicDisc = new ItemStack(Material.MUSIC_DISC_5);
        return new WeightedItem(musicDisc, 1);
    }


    private static WeightedItem createEnchantedBook() {
        ItemStack enchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) enchantedBook.getItemMeta();
        if (meta != null) {
            meta.addStoredEnchant(Enchantment.SHARPNESS, 3, true); // Example enchantment
            enchantedBook.setItemMeta(meta);
        }
        return new WeightedItem(enchantedBook, 0.5);
    }
    private static WeightedItem createEnchantedBookPower3() {
        ItemStack enchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) enchantedBook.getItemMeta();
        if (meta != null) {
            meta.addStoredEnchant(Enchantment.POWER, 3, true); // Power 3
            enchantedBook.setItemMeta(meta);
        }
        return new WeightedItem(enchantedBook, 0.5);
    }

    private static WeightedItem createEnchantedBookPunch() {
        ItemStack enchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) enchantedBook.getItemMeta();
        if (meta != null) {
            meta.addStoredEnchant(Enchantment.PUNCH, 2, true); // Punch
            enchantedBook.setItemMeta(meta);
        }
        return new WeightedItem(enchantedBook, 0.5);
    }

    private static WeightedItem createEnchantedBookFlame() {
        ItemStack enchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) enchantedBook.getItemMeta();
        if (meta != null) {
            meta.addStoredEnchant(Enchantment.FLAME, 1, true); // Flame
            enchantedBook.setItemMeta(meta);
        }
        return new WeightedItem(enchantedBook, 0.5);
    }

    private static WeightedItem createEnchantedBookUnbreaking2() {
        ItemStack enchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) enchantedBook.getItemMeta();
        if (meta != null) {
            meta.addStoredEnchant(Enchantment.UNBREAKING, 2, true); // Unbreaking 2
            enchantedBook.setItemMeta(meta);
        }
        return new WeightedItem(enchantedBook, 0.5);
    }

    private static WeightedItem createEnchantedBookProtection2() {
        ItemStack enchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) enchantedBook.getItemMeta();
        if (meta != null) {
            meta.addStoredEnchant(Enchantment.PROTECTION, 2, true); // Protection 2
            enchantedBook.setItemMeta(meta);
        }
        return new WeightedItem(enchantedBook, 0.5);
    }

    private static WeightedItem createEnchantedBookFeatherFalling3() {
        ItemStack enchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) enchantedBook.getItemMeta();
        if (meta != null) {
            meta.addStoredEnchant(Enchantment.FEATHER_FALLING, 3, true); // Feather Falling 3
            enchantedBook.setItemMeta(meta);
        }
        return new WeightedItem(enchantedBook, 0.5);
    }

    private static WeightedItem createEnchantedBookFireProtection3() {
        ItemStack enchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) enchantedBook.getItemMeta();
        if (meta != null) {
            meta.addStoredEnchant(Enchantment.FIRE_PROTECTION, 3, true); // Fire Protection 3
            enchantedBook.setItemMeta(meta);
        }
        return new WeightedItem(enchantedBook, 0.5);
    }

    private static WeightedItem createEnchantedBookBlastProtection3() {
        ItemStack enchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) enchantedBook.getItemMeta();
        if (meta != null) {
            meta.addStoredEnchant(Enchantment.BLAST_PROTECTION, 3, true); // Blast Protection 3
            enchantedBook.setItemMeta(meta);
        }
        return new WeightedItem(enchantedBook, 0.5);
    }

    private static WeightedItem createEnchantedBookEfficiency2() {
        ItemStack enchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) enchantedBook.getItemMeta();
        if (meta != null) {
            meta.addStoredEnchant(Enchantment.EFFICIENCY, 2, true); // Efficiency 2
            enchantedBook.setItemMeta(meta);
        }
        return new WeightedItem(enchantedBook, 0.5);
    }

    private static WeightedItem createEnchantedBookBaneOfArthropods2() {
        ItemStack enchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) enchantedBook.getItemMeta();
        if (meta != null) {
            meta.addStoredEnchant(Enchantment.BANE_OF_ARTHROPODS, 2, true); // Bane of Arthropods 2
            enchantedBook.setItemMeta(meta);
        }
        return new WeightedItem(enchantedBook, 0.5);
    }

    private static WeightedItem createEnchantedBookSmite2() {
        ItemStack enchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) enchantedBook.getItemMeta();
        if (meta != null) {
            meta.addStoredEnchant(Enchantment.SMITE, 2, true); // Smite 2
            enchantedBook.setItemMeta(meta);
        }
        return new WeightedItem(enchantedBook, 0.5);
    }

    private static WeightedItem createEnchantedBookLooting2() {
        ItemStack enchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) enchantedBook.getItemMeta();
        if (meta != null) {
            meta.addStoredEnchant(Enchantment.LOOTING, 2, true); // Looting 2
            enchantedBook.setItemMeta(meta);
        }
        return new WeightedItem(enchantedBook, 0.5);
    }

    private static WeightedItem createEnchantedBookFireAspect1() {
        ItemStack enchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) enchantedBook.getItemMeta();
        if (meta != null) {
            meta.addStoredEnchant(Enchantment.FIRE_ASPECT, 1, true); // Fire Aspect 1
            enchantedBook.setItemMeta(meta);
        }
        return new WeightedItem(enchantedBook, 0.5);
    }

    private static WeightedItem createEnchantedBookFortune2() {
        ItemStack enchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) enchantedBook.getItemMeta();
        if (meta != null) {
            meta.addStoredEnchant(Enchantment.FORTUNE, 2, true); // Fortune 2
            enchantedBook.setItemMeta(meta);
        }
        return new WeightedItem(enchantedBook, 0.5);
    }

    private static WeightedItem createEnchantedBookInfinity() {
        ItemStack enchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) enchantedBook.getItemMeta();
        if (meta != null) {
            meta.addStoredEnchant(Enchantment.INFINITY, 1, true); // Infinity
            enchantedBook.setItemMeta(meta);
        }
        return new WeightedItem(enchantedBook, 0.05);
    }

    private static WeightedItem createEnchantedBookSilkTouch() {
        ItemStack enchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) enchantedBook.getItemMeta();
        if (meta != null) {
            meta.addStoredEnchant(Enchantment.SILK_TOUCH, 1, true); // Silk Touch
            enchantedBook.setItemMeta(meta);
        }
        return new WeightedItem(enchantedBook, 0.05);
    }

    private static WeightedItem createEnchantedBookMending() {
        ItemStack enchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) enchantedBook.getItemMeta();
        if (meta != null) {
            meta.addStoredEnchant(Enchantment.MENDING, 1, true); // Mending
            enchantedBook.setItemMeta(meta);
        }
        return new WeightedItem(enchantedBook, 0.01);
    }


    private static WeightedItem createChainmailArmor() {
        ItemStack[] chainmailPieces = {
                new ItemStack(Material.CHAINMAIL_HELMET),
                new ItemStack(Material.CHAINMAIL_CHESTPLATE),
                new ItemStack(Material.CHAINMAIL_LEGGINGS),
                new ItemStack(Material.CHAINMAIL_BOOTS)
        };
        Random rand = new Random();
        ItemStack selectedPiece = chainmailPieces[rand.nextInt(chainmailPieces.length)];
        selectedPiece.addEnchantment(Enchantment.PROTECTION, 3);
        return new WeightedItem(selectedPiece, 2.0);
    }

    private static WeightedItem createEnchantedItem(Material material, Enchantment enchantment, int level, double weight) {
        ItemStack item = new ItemStack(material);
        item.addUnsafeEnchantment(enchantment, level);
        return new WeightedItem(item, weight);
    }

    private static WeightedItem createPotion() {
        ItemStack splashPotion = new ItemStack(Material.SPLASH_POTION);
        PotionMeta meta = (PotionMeta) splashPotion.getItemMeta();
        if (meta != null) {
            int rand = randomGenerator(2); // Generate once for potion type
            if (rand == 0) {
                meta.setBasePotionType(PotionType.HEALING);
            } else {
                meta.setBasePotionType(PotionType.HARMING);
            }
            splashPotion.setItemMeta(meta);
        }
        return new WeightedItem(splashPotion, 5);
    }

    private ItemStack getRandomDrop() {
        double totalWeight = possibleDrops.stream().mapToDouble(WeightedItem::getWeight).sum();
        double randomIndex = new Random().nextDouble() * totalWeight;

        double currentWeight = 0;
        for (WeightedItem weightedItem : possibleDrops) {
            currentWeight += weightedItem.getWeight();
            if (randomIndex < currentWeight) {
                return weightedItem.getItem();
            }
        }
        return null; // This should never happen
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        LivingEntity entity = event.getEntity();
        randomGenerator(10);
        // Check if the entity is an instance of one of the custom classes
        if (entity.getName().equals("Rik") || entity.getName().equals("Kevin") ||
                entity.getName().equals("Spidigga") || entity.getName().equals("Charged Crepussy")
                || entity.getName().equals("Crepussy")) {
            ItemStack randomDrop = getRandomDrop();
            if (randomDrop != null) {
                event.getDrops().add(randomDrop);
            }
        }
    }
}

