package fr.arthursrv.darkonia.listeners;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.ChatColor;

import fr.arthursrv.darkonia.Main;


public class epeeHead implements Listener {
	private Main main = Main.getInstance();
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		if(e.getEntity() instanceof Player && e.getEntity().getKiller() instanceof Player) {
			if(e.getEntity().getKiller().getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("epeehead.name")))) {
				Player killer = e.getEntity().getKiller();
				Player killed = e.getEntity();
				ItemStack is = new ItemStack(Material.SKULL);
				SkullMeta sm = (SkullMeta) is.getItemMeta();
				sm.setOwningPlayer(killed);
				is.setItemMeta(sm);
				Random rdm = new Random();
				int chance = rdm.nextInt(100);
				if(chance <= main.getConfig().getInt("epeehead.chance")) {
					killed.getWorld().dropItem(killed.getLocation(), is);
				}	
		}
		}
	}

}
