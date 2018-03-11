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

import me.sirsentrix.keinleben.teleporter.managers.Config;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        if(!getDataFolder().exists()) {
            getDataFolder().mkdirs();
        }
        Config.load(getDataFolder()+"/config.json");
        Config.getInstance().toFile(getDataFolder()+"/config.json");
    }

    @Override
    public void onDisable() {

    }


    public static Main getInstance() {
        return instance;
    }
}
