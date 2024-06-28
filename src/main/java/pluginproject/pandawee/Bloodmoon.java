package pluginproject.pandawee;
import pluginproject.pandawee.SpawnMobs;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import java.util.Random;

import static org.bukkit.Bukkit.getWorld;

public class Bloodmoon {

    private int nextBloodmoon = 16;
    boolean isDay = true;
    public void checkDusk() {
        long time = Bukkit.getWorld("world").getTime();
        if (time >= 13000 && time <= 13300 && isDay) {
            announceBloodMoon();
            isDay = false;
        }
        else if (time < 13000 && time >= 0){
            isDay = true;
            System.out.println("adad");
        }
    }

    public boolean checkBloodMoon() {
        boolean bloodMoon;
        long dayLength = getWorld("world").getFullTime() / 24000;
        long moonPhase = dayLength % 8;
        bloodMoon = moonPhase == 0;
        return bloodMoon;
    }

    public boolean checkBloodMoonHard() {
        Random rand = new Random();
        boolean bloodMoonHard;
        int randomBM = rand.nextInt(nextBloodmoon);
        bloodMoonHard = randomBM == 0;

        if(!bloodMoonHard && nextBloodmoon > 2) {
            nextBloodmoon -= 2;
        }
        else if (bloodMoonHard) {
            nextBloodmoon = 16;
        }
        return bloodMoonHard;
    }

    public void announceBloodMoon() {

        //HARDEST BLOOD MOON
        // plays different sound cue
        if(checkBloodMoonHard()) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                SpawnMobs sm = new SpawnMobs();
                for (int i = 0; i < 50; i++) {
                    sm.spawnZombie(player, true);
                    sm.spawnSkeleton(player, true);
                    sm.spawnSpider(player, true);
                    sm.spawnCreeper(player, true);
                }
            }
        }
        else if (checkBloodMoon()) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.playSound(player.getLocation(), Sound.ENTITY_WITHER_SPAWN, 1.0f, 1.0f);
                player.playSound(player.getLocation(), Sound.ENTITY_ELDER_GUARDIAN_CURSE, 1.0f, 1.0f);
                player.playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 1.0f, 1.0f);

                player.sendMessage("The Blood Moon rises");
                SpawnMobs sm = new SpawnMobs();
                for(int i = 0; i < 50; i++) {
                    sm.spawnZombie(player, false);
                    sm.spawnSkeleton(player, false);
                    sm.spawnSpider(player, false);
                    sm.spawnCreeper(player, false);
                }
                player.sendMessage("ZOMBIE SPAWNED");
            }
        }
        //Harder than normal blood moon
        // plays different sound cue
        else if (checkBloodMoonHard()) {

        }
        else {
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.sendMessage("You are safe tonight...");
            }
        }
    }

    public void spawnWaves() {
        long time = Bukkit.getWorld("world").getTime();
        SpawnMobs sm = new SpawnMobs();

        if (checkBloodMoon() && time >= 13000 && time <= 23992) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                for(int i = 0; i < 50; i++) {
                    sm.spawnZombie(player, false);
                    sm.spawnSkeleton(player, false);
                    sm.spawnSpider(player, false);
                    sm.spawnCreeper(player, false);
                }
            }
        }
    }
}
