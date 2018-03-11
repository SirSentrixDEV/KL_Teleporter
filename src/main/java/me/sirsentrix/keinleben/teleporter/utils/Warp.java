/*
<!----------------------------------------------------------------->
Dieses Plugin wurde von SirSentrix geschrieben.
Alle rechte zu diesem Plugin liegen bei SirSentrix aka. Philipp
(www.youtube.com/c/SirSentrix)

Sollte dieses Plugin ohne entsprechender Berechtigung vom Besitzer
(SirSentrix/Philipp) auf einem Server oder einen Online Platform
erscheinen, wir dies Konsiquenzen haben!

Alle Rechte liegen bei SirSentrix/Philipp!  ©2018,11.03.2018 :: 15:50
<!------------------------------------------------------------------>
*/

package me.sirsentrix.keinleben.teleporter.utils;

import me.sirsentrix.keinleben.teleporter.Main;
import me.sirsentrix.keinleben.teleporter.managers.Config;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Warp {

    private static Main pl = Main.getInstance();
    private static File warpsFile = new File(pl.getDataFolder(), "warps.yml");
    private static FileConfiguration warpsCFG = YamlConfiguration.loadConfiguration(warpsFile);

    public static void setWarp(Location loc, String name) {
        if(!warpsFile.exists()) {
            try {
                warpsFile.createNewFile();
            } catch (IOException e) {}
        }
        if(name.contains(" ")) {
            name = name.replace(" ", "%");
        }

        warpsCFG.set(name+".World", loc.getWorld().getName());
        warpsCFG.set(name+".X", loc.getBlock().getX());
        warpsCFG.set(name+".Y", loc.getBlock().getY());
        warpsCFG.set(name+".Z", loc.getBlock().getZ());
        warpsCFG.set(name+".Yaw", loc.getYaw());
        warpsCFG.set(name+".Pitch", loc.getPitch());

        try {
            warpsCFG.save(warpsFile);
        } catch (IOException e) {
        }

    }

    public static Location getWarp(String name) {
        if(name.contains(" ")) {
            name = name.replace(" ", "%");
        }

        String world = warpsCFG.getString(name+".World");
        double x = warpsCFG.getDouble(name+".X");
        double y = warpsCFG.getDouble(name+".Y");
        double z = warpsCFG.getDouble(name+".Z");
        int yaw = warpsCFG.getInt(name+".Yaw");
        int pitch = warpsCFG.getInt(name+".Pitch");

        World w = Bukkit.getWorld(world);
        Location l = new Location(w, x, y, z);
        l.setPitch((float) pitch);
        l.setYaw((float) yaw);

        return l;
    }

    public static boolean isWarpExists(String name) {
        if(warpsCFG.contains(name)) {
            return true;
        }
        return false;
    }


    public static String getWarpFromItem(int slot) {
        for(int i = 0; i < Config.getInstance().InventorySize; i++) {
            if(Config.getInstance().itemSlot.get(i).equalsIgnoreCase(String.valueOf(slot))) {
                return Config.getInstance().itemwarppoint.get(i);
            }
        }
        return null;
    }

}
