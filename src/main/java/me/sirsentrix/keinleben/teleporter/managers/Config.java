/*
<!----------------------------------------------------------------->
Dieses Plugin wurde von SirSentrix geschrieben.
Alle rechte zu diesem Plugin liegen bei SirSentrix aka. Philipp
(www.youtube.com/c/SirSentrix)

Sollte dieses Plugin ohne entsprechender Berechtigung vom Besitzer
(SirSentrix/Philipp) auf einem Server oder einen Online Platform
erscheinen, wir dies Konsiquenzen haben!

Alle Rechte liegen bei SirSentrix/Philipp!  ©2018,11.03.2018 :: 13:41
<!------------------------------------------------------------------>
*/

package me.sirsentrix.keinleben.teleporter.managers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import me.sirsentrix.keinleben.teleporter.Main;

import java.io.*;

public class Config {

    private static Main pl = Main.getInstance();

    public int InventorySize;
    public String InventoryTitle;
    public String ItemName;
    public int ItemSlot;
    public int placeholderID;
    public int placeholderSUBID;



    public Config() {
        this.InventoryTitle = "§eKL§8_§5TP";
        this.InventorySize = 54;
        this.ItemName = "§cTeleporter";
        this.ItemSlot = 8;
        this.placeholderID = 345;
        this.placeholderSUBID = 0;
    }





    private static Config instance;

    public static Config getInstance() {
        if (instance == null) {
            instance = fromDefaults();
        }
        return instance;
    }

    public static void load(File file) {
        instance = fromFile(file);

        if (instance == null) {
            instance = fromDefaults();
        }
    }

    public static void load(String file) {
        load(new File(file));
    }

    private static Config fromDefaults() {
        Config config = new Config();
        return config;
    }

    public void toFile(String file) {
        toFile(new File(file));
    }

    public void toFile(File file) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonConfig = gson.toJson(this);
        FileWriter writer;
        try {
            writer = new FileWriter(file);
            writer.write(jsonConfig);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Config fromFile(File configFile) {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(configFile)));
            return gson.fromJson(reader, Config.class);
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    @Override
    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }

}
