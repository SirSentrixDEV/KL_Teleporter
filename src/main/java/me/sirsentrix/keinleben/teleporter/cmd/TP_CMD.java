/*
<!----------------------------------------------------------------->
Dieses Plugin wurde von SirSentrix geschrieben.
Alle rechte zu diesem Plugin liegen bei SirSentrix aka. Philipp
(www.youtube.com/c/SirSentrix)

Sollte dieses Plugin ohne entsprechender Berechtigung vom Besitzer
(SirSentrix/Philipp) auf einem Server oder einen Online Platform
erscheinen, wir dies Konsiquenzen haben!

Alle Rechte liegen bei SirSentrix/Philipp!  ©2018,11.03.2018 :: 15:01
<!------------------------------------------------------------------>
*/

package me.sirsentrix.keinleben.teleporter.cmd;

import me.sirsentrix.keinleben.teleporter.Main;
import me.sirsentrix.keinleben.teleporter.managers.Config;
import me.sirsentrix.keinleben.teleporter.utils.GUI;
import me.sirsentrix.keinleben.teleporter.utils.Warp;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TP_CMD implements CommandExecutor {

    private Main pl = Main.getInstance();

    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {

        if(s instanceof Player) {
            Player p = (Player)s;
            if (args.length == 0) {

                pl.sendMSG(p, true, " ");
                pl.sendMSG(p, true, "&7/tp reload  &8-- &6Reloaded die Config");
                pl.sendMSG(p, true, "&7/tp open  &8-- &6Öffnet das GUI");
                pl.sendMSG(p, true, "&7/tp setWarp <name>  &8-- &6Setzt einen Warp");
                pl.sendMSG(p, true, " ");

            } else if(args.length == 1) {
                if(args[0].equalsIgnoreCase("reload") || args[0].equalsIgnoreCase("rl")) {
                    pl.sendMSG(p, true, "&7Die Config wird nun neugeladen!");
                    Config.load(pl.getDataFolder()+"/config.json");
                    pl.sendMSG(p, true, "&7Die Config wurde neugeladen!");
                }

                if(args[0].equalsIgnoreCase("open")) {
                    GUI.openTPinv(p);
                }

            } else if(args.length == 2) {
                if(args[0].equalsIgnoreCase("setWarp")) {
                    String warpname = args[1];

                    if(!Warp.isWarpExists(warpname)) {
                        Warp.setWarp(p.getLocation(), warpname);
                        pl.sendMSG(p, true, "&7Du hast einen Warp gesetzt! ->"+warpname);
                    } else {
                        pl.sendMSG(p, true, "&cDieser Warp existiert bereits!");
                    }
                }
            }

        }
        return false;
    }
}
