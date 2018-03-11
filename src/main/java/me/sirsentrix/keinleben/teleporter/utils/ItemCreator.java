/*
<!----------------------------------------------------------------->
Dieses Plugin wurde von SirSentrix geschrieben.
Alle rechte zu diesem Plugin liegen bei SirSentrix aka. Philipp
(www.youtube.com/c/SirSentrix)

Sollte dieses Plugin ohne entsprechender Berechtigung vom Besitzer
(SirSentrix/Philipp) auf einem Server oder einen Online Platform
erscheinen, wir dies Konsiquenzen haben!

Alle Rechte liegen bei SirSentrix/Philipp!  ©2018,11.03.2018 :: 14:10
<!------------------------------------------------------------------>
*/

package me.sirsentrix.keinleben.teleporter.utils;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ItemCreator {

    public ItemStack createItem(int id, int subid, int amount, String displayname, String lore) {
        ItemStack is = new ItemStack(id,amount,(short)subid);
        ItemMeta im = is.getItemMeta();
        im.setDisplayName(displayname);
        ArrayList<String> lore2 = new ArrayList<String>();
        lore2.add(lore);
        im.setLore(lore2);
        is.setItemMeta(im);
        return is;
    }

}
