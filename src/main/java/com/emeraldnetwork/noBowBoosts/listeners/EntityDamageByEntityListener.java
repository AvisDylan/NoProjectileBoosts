package com.emeraldnetwork.noBowBoosts.listeners;

import com.emeraldnetwork.noBowBoosts.NoBowBoosts;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EntityDamageByEntityListener implements Listener{
    
    private final FileConfiguration config = NoBowBoosts.getPlugin().getConfig();
    
    @EventHandler
    public void onEntityDamageByEntity(final EntityDamageByEntityEvent event){
        if(event.getDamager() instanceof final Arrow arrow
                && arrow.getShooter() instanceof final Player shooter
                && config.getBoolean("projectiles.arrow")
                && shooter.equals(event.getEntity())){
            
            event.setCancelled(true);
            sendProjectileMsg(event.getEntity());
        }else if(event.getDamager() instanceof final FishHook fishHook
                && fishHook.getShooter() instanceof final Player shooter
                && config.getBoolean("projectiles.rod")
                && shooter.equals(event.getEntity())){
            
            event.setCancelled(true);
            sendProjectileMsg(event.getEntity());
        }else if(event.getDamager() instanceof final Snowball snowball
                && snowball.getShooter() instanceof final Player shooter
                && config.getBoolean("projectiles.snow-ball")
                && shooter.equals(event.getEntity())){
            
            event.setCancelled(true);
            sendProjectileMsg(event.getEntity());
        }
    }
    
    public void sendProjectileMsg(final Entity entity){
        if(config.getBoolean("projectile-boosting-message.enabled")){
            String message = config.getString("projectile-boosting-message.message").replace("%player%", entity.getName());
            
            entity.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
        }
    }
}
