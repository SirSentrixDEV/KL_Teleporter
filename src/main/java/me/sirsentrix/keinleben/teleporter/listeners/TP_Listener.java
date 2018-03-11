/*
<!----------------------------------------------------------------->
Dieses Plugin wurde von SirSentrix geschrieben.
Alle rechte zu diesem Plugin liegen bei SirSentrix aka. Philipp
(www.youtube.com/c/SirSentrix)

Sollte dieses Plugin ohne entsprechender Berechtigung vom Besitzer
(SirSentrix/Philipp) auf einem Server oder einen Online Platform
erscheinen, wir dies Konsiquenzen haben!

Alle Rechte liegen bei SirSentrix/Philipp!  ©2018,11.03.2018 :: 16:30
<!------------------------------------------------------------------>
*/

package me.sirsentrix.keinleben.teleporter.listeners;

import me.sirsentrix.keinleben.teleporter.Main;
import me.sirsentrix.keinleben.teleporter.managers.Config;
import me.sirsentrix.keinleben.teleporter.utils.GUI;
import me.sirsentrix.keinleben.teleporter.utils.Warp;
import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class TP_Listener implements Listener {

    private Main pl = Main.getInstance();

    @EventHandler
    public void onHotbarInteract(PlayerInteractEvent e) {
        if(e.getItem() != null) {
            if(e.getItem().getItemMeta() != null) {
                if(e.getItem().getItemMeta().getDisplayName() != null) {

                    if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(Config.getInstance().ItemName)) {
                        GUI.openTPinv(e.getPlayer());
                    }

                }
            }
        }
    }



    @EventHandler
    public void onTPinvClick(InventoryClickEvent e) {
        if(e.getInventory() != null) {
            if(e.getInventory().getTitle() != null) {
                if(e.getCurrentItem() != null) {
                    if(e.getCurrentItem().getItemMeta() != null) {
                        if(e.getCurrentItem().getItemMeta().getDisplayName() != null) {

                            if(e.getInventory().getTitle().equals(Config.getInstance().InventoryTitle.replace("&","§"))) {
                                e.setCancelled(true);
                                Player p = (Player) e.getWhoClicked();

                                if(Warp.getWarpFromItem(e.getSlot()) != null) {
                                    p.teleport(Warp.getWarp(Warp.getWarpFromItem(e.getSlot())));
                                    p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 4.0F);

                                    p.playEffect(Warp.getWarp(Warp.getWarpFromItem(e.getSlot())), Effect.ENDER_SIGNAL, 1);
                                    p.playEffect(Warp.getWarp(Warp.getWarpFromItem(e.getSlot())), Effect.ENDER_SIGNAL, 3);
                                    p.playEffect(Warp.getWarp(Warp.getWarpFromItem(e.getSlot())), Effect.ENDER_SIGNAL, 2);
                                    p.playEffect(Warp.getWarp(Warp.getWarpFromItem(e.getSlot())), Effect.ENDER_SIGNAL, 4);
                                    p.playEffect(Warp.getWarp(Warp.getWarpFromItem(e.getSlot())), Effect.ENDER_SIGNAL, 5);
                                    p.playEffect(Warp.getWarp(Warp.getWarpFromItem(e.getSlot())), Effect.ENDER_SIGNAL, 1);
                                }

                                if(Warp.getWarpFromItem(e.getSlot()) == "none") {
                                    pl.sendMSG(p, true, "&cDer Warp wurde noch nicht gesetzt!");
                                    if(p.isOp()) {
                                        pl.sendMSG(p, true, "&7/tp setWarp <name>");
                                    }
                                }

                            }

                        }
                    }
                }
            }
        }
    }

}
