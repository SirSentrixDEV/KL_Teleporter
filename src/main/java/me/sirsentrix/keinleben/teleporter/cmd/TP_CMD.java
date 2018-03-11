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
import me.sirsentrix.keinleben.teleporter.utils.GUI;
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
                pl.sendMSG(p, true, "&7Die Config wird nun neugeladen!");
                Bukkit.getServer().getPluginManager().disablePlugin(pl);
                Bukkit.getServer().getPluginManager().enablePlugin(pl);
                pl.sendMSG(p, true, "&7Die Config wurde neugeladen!");
                GUI.openTPinv(p);
            }

        }
        return false;
    }
}
