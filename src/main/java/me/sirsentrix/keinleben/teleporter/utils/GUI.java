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
        //<!--------Placeholder--------->
        int id = Config.getInstance().placeholderID;
        int subid = Config.getInstance().placeholderSUBID;
        int amount = Config.getInstance().placeholderAmount;
        String displayname = Config.getInstance().placeholderName;
        String lore = Config.getInstance().placeholderLore;
        ItemStack placeholder = pl.ic.createItem(id, subid, amount, displayname, lore);
        //<!---------------------------->

        Inventory inv = Bukkit.createInventory(null, size, title);
        fillInv(inv, placeholder);


        for(int i = 0; i < Config.getInstance().InventorySize; i++) {

            boolean enabled = Boolean.valueOf(Config.getInstance().itemenabled.get(i));

            if(enabled) {
                String name = Config.getInstance().itemname.get(i);
                String lore2 = Config.getInstance().itemlore.get(i);
                String slot2 = Config.getInstance().itemSlot.get(i);
                String id2 = Config.getInstance().itemID.get(i);
                String subid2 = Config.getInstance().itemSUBID.get(i);
                String amount2 = Config.getInstance().itemamount.get(i);

                ItemStack item = pl.ic.createItem(Integer.valueOf(id2), Integer.valueOf(subid2), Integer.valueOf(amount2), name, lore2);
                inv.setItem(Integer.valueOf(slot2), item);
            }


        }




        player.openInventory(inv);
    }


    private static void fillInv(Inventory inv, ItemStack toFill) {
        int size = inv.getSize();
        for(int i = 0; i < size; i++) {
            inv.setItem(i, toFill);
        }
    }

}
