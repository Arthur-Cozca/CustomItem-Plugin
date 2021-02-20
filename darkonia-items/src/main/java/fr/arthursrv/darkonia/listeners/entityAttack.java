package fr.arthursrv.darkonia.listeners;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.arthursrv.darkonia.Main;
import net.milkbowl.vault.economy.Economy;

public class entityAttack implements Listener {
	private Main main = Main.getInstance();
	private static Economy econ;

	@SuppressWarnings("deprecation")
	@EventHandler
	public void entityDamage(EntityDamageByEntityEvent e) {
		Player damager = (Player) e.getDamager();
		Player damagy = (Player) e.getEntity();
		Random rdm = new Random();
		int chance = rdm.nextInt(100);
		ItemMeta im = damager.getItemInHand().getItemMeta();
		if(damager.getInventory().getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("moneysword.name")))) {
			if(chance <= main.getConfig().getInt("moneysword.chance")) {
			econ.withdrawPlayer(damagy, main.getConfig().getInt("moneysword.montant"));
			econ.depositPlayer(damager, main.getConfig().getInt("moneysword.montant"));
			damager.sendMessage("Vous avez volé " + main.getConfig().getInt("moneysword.montant") + "$ à " + damagy.getName());
			damagy.sendMessage(damager.getName() + " vous a volé " + main.getConfig().getInt("moneysword.montant") + "$");
			}
		}
		if(damager.getInventory().getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("epeeitem.name")))) {
			if(chance <= main.getConfig().getInt("epeeitem.chance")) {
				damagy.getInventory().setItemInHand(new ItemStack(3,10));
				damagy.sendMessage("§c" + damager.getName() + " vous a ensorcelé, il a changé l'item dans votre main");
			}
		}
		
	}

}
