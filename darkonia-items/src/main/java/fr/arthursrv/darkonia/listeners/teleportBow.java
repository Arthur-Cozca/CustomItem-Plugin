package fr.arthursrv.darkonia.listeners;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.meta.ItemMeta;

import fr.arthursrv.darkonia.Main;

public class teleportBow implements Listener {
	
	private Main main = Main.getInstance();
	private ArrayList<Player> cooldown = new ArrayList<Player>();
	
	
	@SuppressWarnings({ "deprecation" })
    @EventHandler
    public void onProjectileHit(ProjectileHitEvent e) {
        if(e.getEntity() instanceof Arrow) {
            Player player = (Player) e.getEntity().getShooter();
            Location location = e.getEntity().getLocation();
            ItemMeta im = player.getItemInHand().getItemMeta();
            if(player.getInventory().getItemInHand().getType().equals(Material.BOW)&& im.getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("tpbow.name")))) {
                if(cooldown.contains(player)) {
                    player.sendMessage("§cVous devez attendre avant de pouvoir ré-utiliser cet objet");
                    
                } else {
                    player.teleport(location);
                    player.playSound(e.getEntity().getLocation(), Sound.BLOCK_NOTE_PLING, 1.0F, 1.0F);
                    player.sendMessage("§cVous devez attendre désormais pour ré-utiliser l'arc-téléporteur");
                    cooldown.add(player);
                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(main, new Runnable() {
						
						@Override
						public void run() {
							cooldown.remove(player);
							
						}
					}, main.getConfig().getInt("tpbow.cooldown") * 20);
                    }

                }





        }
    }
	

}
