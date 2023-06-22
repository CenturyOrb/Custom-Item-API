package com.rosa.serverplugin;

import Commands.CommandTest;
import Commands.SellCommand;
import Item.CreateAndStorage.Spells.FireballSpell;
import Item.SpecialEffects.SpecialArmorEffects.SpecialArmorSetEffects.ArtemisSetEffects;
import Item.SpecialEffects.SpecialArmorEffects.CorinthianEffect;
import Item.SpecialEffects.SpecialArmorEffects.SpecialArmorSetEffects.GuardianSetEffects;
import Item.SpecialEffects.SpecialArmorEffects.SpecialArmorSetEffects.RogueSetEffects;
import Item.SpecialEffects.SpecialDefenseEffects.AnciliaEffect;
import Item.SpecialEffects.SpecialOffenseEffects.*;
import Item.Systems.*;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener{

    private static Plugin plugin;

    API api;

    @Override
    public void onEnable() {

        plugin = this;

        api = new API(this);

        // registering events
        Bukkit.getPluginManager().registerEvents(new SpellSouls(), this);
        Bukkit.getPluginManager().registerEvents(new FireballSpell(), this);

        Bukkit.getPluginManager().registerEvents(new CustomOffenseEffects(), this);
        Bukkit.getPluginManager().registerEvents(new CustomBowEffects(), this);

        Bukkit.getPluginManager().registerEvents(new CustomArmorDurability(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerKillCountSystem(), this);

        Bukkit.getPluginManager().registerEvents(new ElysiumEffect(), this);
        Bukkit.getPluginManager().registerEvents(new ShadowStepEffect(), this);
        Bukkit.getPluginManager().registerEvents(new TetheriusEffect(), this);
        Bukkit.getPluginManager().registerEvents(new SorrowBladeEffect(), this);
        Bukkit.getPluginManager().registerEvents(new MagnarEffect(), this);
        Bukkit.getPluginManager().registerEvents(new TrishulaEffect(), this);
        Bukkit.getPluginManager().registerEvents(new AnciliaEffect(), this);
        Bukkit.getPluginManager().registerEvents(new RapierEffect(), this);

        Bukkit.getPluginManager().registerEvents(new CorinthianEffect(), this);

        Bukkit.getPluginManager().registerEvents(new GuardianSetEffects(), this);
        Bukkit.getPluginManager().registerEvents(new RogueSetEffects(), this);
        Bukkit.getPluginManager().registerEvents(new ArtemisSetEffects(), this);

        // set up /pdc command
        getCommand("pdc").setExecutor(new CommandTest());
        getCommand("sell").setExecutor(new SellCommand());

        CustomArmorEffects start = new CustomArmorEffects();
    }

    public static Plugin getPlugin() {
        return plugin;
    }
}

