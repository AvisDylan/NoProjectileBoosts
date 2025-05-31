package com.emeraldnetwork.noBowBoosts;

import com.emeraldnetwork.noBowBoosts.listeners.EntityDamageByEntityListener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class NoBowBoosts extends JavaPlugin{
    
    private static Plugin plugin;
    
    @Override
    public void onEnable(){
        plugin = this;
        
        saveDefaultConfig();
        
        getLogger().fine("Launching!");
        getServer().getPluginManager().registerEvents(new EntityDamageByEntityListener(), this);
    }
    
    @Override
    public void onDisable(){
        getLogger().fine("Shutting down!");
    }
    
    public static Plugin getPlugin(){
        return plugin;
    }
}
