package fr.arthursrv.darkonia.listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.arthursrv.darkonia.Main;
import net.milkbowl.vault.economy.Economy;

public class miningEvent implements Listener {
	private Main main = Main.getInstance();
	private static Economy eco;
	
	@SuppressWarnings('deprecation')
	@EventHandler
	public void onMining(BlockBreakEvent e) {
		Player p = e.getPlayer();
		if(p.getInventory().getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("piochecuit.name")))) {
			if(e.getBlock().equals(Material.GOLD_ORE)) {
				e.getBlock().getDrops().clear();
				ItemStack is = new ItemStack(Material.GOLD_INGOT);
				p.getInventory().addItem(is);
				e.getBlock().getDrops().clear();
			}
			if(e.getBlock().equals(Material.IRON_ORE)) {
				e.getBlock().getDrops().clear();
				ItemStack is = new ItemStack(Material.IRON_INGOT);
				p.getInventory().addItem(is);
				
			}
		}
		
		if(p.getInventory().getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("piochemoney.name")))) {
			Random rdm = new Random();
			int chance = rdm.nextInt(100);
			if(chance <= main.getConfig().getInt("piochemoney.chance")) {
				eco.depositPlayer(p, main.getConfig().getInt("piochemoney.montant"));
			}
		}
		
		if(p.getInventory().getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("piochexp.name")))) {
			Random rdm = new Random();
			int chance = rdm.nextInt(100);
			if(chance <= main.getConfig().getInt("piochemoney.chance")) {
				p.giveExp(main.getConfig().getInt("xppioche.xp"));
			}
		}
		
		if(p.getInventory().getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("piochekey.name")))) {
			
			Random rdm = new Random();
			int chance = rdm.nextInt(3);
				ItemStack is = new ItemStack(Material.PRISMARINE_SHARD, chance);
				ItemMeta im = is.getItemMeta();
				im.setDisplayName(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("shard.name")));
				List<String> lore = new ArrayList<String>();
				lore.add(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("shard.lore")));
				im.setLore(lore);
				is.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
				im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				is.setItemMeta(im);
				p.getInventory().addItem(is);
				
			
		}
		
	}
		
}
