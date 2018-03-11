/*
<!----------------------------------------------------------------->
Dieses Plugin wurde von SirSentrix geschrieben.
Alle rechte zu diesem Plugin liegen bei SirSentrix aka. Philipp
(www.youtube.com/c/SirSentrix)

Sollte dieses Plugin ohne entsprechender Berechtigung vom Besitzer
(SirSentrix/Philipp) auf einem Server oder einen Online Platform
erscheinen, wir dies Konsiquenzen haben!

Alle Rechte liegen bei SirSentrix/Philipp!  ©2018,11.03.2018 :: 14:57
<!------------------------------------------------------------------>
*/

package me.sirsentrix.keinleben.teleporter.listeners;

import me.sirsentrix.keinleben.teleporter.Main;
import me.sirsentrix.keinleben.teleporter.managers.Config;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerListener implements Listener {

    private Main pl = Main.getInstance();

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        int id = Config.getInstance().ItemID;
        int subid = Config.getInstance().ItemSUBID;
        int amount = Config.getInstance().ItemAmount;
        String displayname = Config.getInstance().ItemName;
        String lore = Config.getInstance().ItemLore;
        int itemslot = Config.getInstance().ItemSlot;
        ItemStack teleporter = pl.ic.createItem(id, subid, amount, displayname, lore);

        p.getInventory().setItem(itemslot, teleporter);

    }

}
