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
import com.sun.org.apache.xpath.internal.operations.Bool;
import me.sirsentrix.keinleben.teleporter.Main;

import java.io.*;
import java.util.HashMap;

public class Config {

    private static Main pl = Main.getInstance();

    public String Prefix;
    public int InventorySize;
    public String InventoryTitle;
    public String ItemName;
    public int ItemSlot;
    public int ItemID;
    public int ItemSUBID;
    public int ItemAmount;
    public String ItemLore;
    public int placeholderID;
    public int placeholderSUBID;
    public int placeholderAmount;
    public String placeholderName;
    public String placeholderLore;


    public HashMap<Integer, String> itemID;
    public HashMap<Integer, String> itemSUBID;
    public HashMap<Integer, String> itemSlot;
    public HashMap<Integer, String> itemname;
    public HashMap<Integer, String> itemlore;
    public HashMap<Integer, String> itemenabled;
    public HashMap<Integer, String> itemamount;
    public HashMap<Integer, String> itemwarppoint;


    public Config() {
        this.Prefix = "§5TP §8> §r";
        this.InventoryTitle = "§eKL§8_§5TP";
        this.InventorySize = 54;
        this.ItemName = "§cTeleporter";
        this.ItemSlot = 8;
        this.ItemID = 345;
        this.ItemSUBID = 0;
        this.ItemAmount = 1;
        this.ItemLore = " ";
        this.placeholderID = 160;
        this.placeholderSUBID = 10;
        this.placeholderAmount = 1;
        this.placeholderName = " ";
        this.placeholderLore = " ";

        this.itemID = new HashMap<Integer, String>();
        this.itemSUBID = new HashMap<Integer, String>();
        this.itemSlot = new HashMap<Integer, String>();
        this.itemname = new HashMap<Integer, String>();
        this.itemlore = new HashMap<Integer, String>();
        this.itemenabled = new HashMap<Integer, String>();
        this.itemamount = new HashMap<Integer, String>();
        this.itemwarppoint = new HashMap<Integer, String>();



        if(itemID.containsKey(0)) {
            itemID.remove(0);
        }
        if(itemSUBID.containsKey(0)) {
            itemSUBID.remove(0);
        }
        if(itemSlot.containsKey(0)) {
            itemSlot.remove(0);
        }
        if(itemname.containsKey(0)) {
            itemname.remove(0);
        }
        if(itemlore.containsKey(0)) {
            itemlore.remove(0);
        }
        if(itemenabled.containsKey(0)) {
            itemenabled.remove(0);
        }

        itemID.put(0, "19");
        itemSUBID.put(0, "1");
        itemSlot.put(0, "5");
        itemname.put(0, "§6Template");
        itemlore.put(0, "§5Hi");
        itemamount.put(0, "1");
        itemenabled.put(0, "true");
        itemwarppoint.put(0, "none");

        for(int i = 1; i < InventorySize; i++) {
            if(itemID.containsKey(i)) {
                itemID.remove(i);
            }
            if(itemSUBID.containsKey(i)) {
                itemSUBID.remove(i);
            }
            if(itemSlot.containsKey(i)) {
                itemSlot.remove(i);
            }
            if(itemname.containsKey(i)) {
                itemname.remove(i);
            }
            if(itemlore.containsKey(i)) {
                itemlore.remove(i);
            }
            if(itemenabled.containsKey(i)) {
                itemenabled.remove(i);
            }

            itemID.put(i, "19");
            itemSUBID.put(i, "1");
            itemSlot.put(i, "5");
            itemname.put(i, "§6Template");
            itemlore.put(i, "§5Hi");
            itemamount.put(i, "1");
            itemenabled.put(i, "false");
            itemwarppoint.put(i, "none");
        }
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
