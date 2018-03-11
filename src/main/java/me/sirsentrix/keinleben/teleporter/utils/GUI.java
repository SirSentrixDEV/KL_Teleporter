/*
<!----------------------------------------------------------------->
Dieses Plugin wurde von SirSentrix geschrieben.
Alle rechte zu diesem Plugin liegen bei SirSentrix aka. Philipp
(www.youtube.com/c/SirSentrix)

Sollte dieses Plugin ohne entsprechender Berechtigung vom Besitzer
(SirSentrix/Philipp) auf einem Server oder einen Online Platform
erscheinen, wir dies Konsiquenzen haben!

Alle Rechte liegen bei SirSentrix/Philipp!  ©2018,11.03.2018 :: 14:06
<!------------------------------------------------------------------>
*/

package me.sirsentrix.keinleben.teleporter.utils;

import me.sirsentrix.keinleben.teleporter.Main;
import me.sirsentrix.keinleben.teleporter.managers.Config;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GUI {

    private static Main pl = Main.getInstance();


    public static void openTPinv(Player player) {
        int size = Config.getInstance().InventorySize;
        String title = Config.getInstance().InventoryTitle;
        if(title.contains("&")) {
            title.replace("&","§");
        }

        Inventory inv = Bukkit.createInventory(null, size, title);



        player.openInventory(inv);
    }


    private static void fillInv(Inventory inv, ItemStack toFill) {
        int size = inv.getSize();
        for(int i = 0; i < size; i++) {
            inv.setItem(i, toFill);
        }
    }

}
