package com.rosa.serverplugin;

import Item.CreateAndStorage.Armor.CustomArmor;
import Item.CreateAndStorage.Armor.CustomArmorManager;
import Item.CreateAndStorage.Offense.CustomOffenseManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.ServicePriority;

public class API {

    private CustomOffenseManager offenseManager;
    private CustomArmorManager armorManager;

    public API(Plugin main)   {

        offenseManager = new CustomOffenseManager();
        armorManager = new CustomArmorManager();
        Bukkit.getServicesManager().register(API.class, this, main, ServicePriority.Normal);

    }

    public CustomOffenseManager getOffenseManager()   { return offenseManager; }
    public CustomArmorManager getArmorManager()   { return armorManager; }


}
