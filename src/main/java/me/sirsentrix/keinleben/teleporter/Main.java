/*
<!----------------------------------------------------------------->
Dieses Plugin wurde von SirSentrix geschrieben.
Alle rechte zu diesem Plugin liegen bei SirSentrix aka. Philipp
(www.youtube.com/c/SirSentrix)

Sollte dieses Plugin ohne entsprechender Berechtigung vom Besitzer
(SirSentrix/Philipp) auf einem Server oder einen Online Platform
erscheinen, wir dies Konsiquenzen haben!

Alle Rechte liegen bei SirSentrix/Philipp!  ©2018,11.03.2018 :: 13:35
<!------------------------------------------------------------------>
*/

package me.sirsentrix.keinleben.teleporter;

import me.sirsentrix.keinleben.teleporter.cmd.TP_CMD;
import me.sirsentrix.keinleben.teleporter.listeners.PlayerListener;
import me.sirsentrix.keinleben.teleporter.listeners.TP_Listener;
import me.sirsentrix.keinleben.teleporter.managers.Config;
import me.sirsentrix.keinleben.teleporter.utils.ItemCreator;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;
    public static ItemCreator ic;

    @Override
    public void onEnable() {
        instance = this;
        ic = new ItemCreator();
        if(!getDataFolder().exists()) {
            getDataFolder().mkdirs();
        }
        Config.load(getDataFolder()+"/config.json");
        Config.getInstance().toFile(getDataFolder()+"/config.json");


        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerListener(), this);
        pm.registerEvents(new TP_Listener(), this);
        getCommand("tp").setExecutor(new TP_CMD());
    }

    @Override
    public void onDisable() {

    }


    public void sendMSG(Player p, boolean b, String s) {
        if(b) {
            s = Config.getInstance().Prefix + s;
        }
        p.sendMessage(s.replace("&","§"));
    }

    public static Main getInstance() {
        return instance;
    }
}
