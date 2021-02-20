package fr.arthursrv.darkonia.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;


import fr.arthursrv.darkonia.Main;
import fr.arthursrv.darkonia.core.message;
import org.bukkit.ChatColor;

public class citem implements CommandExecutor {
	
	private Main main = Main.getInstance();

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		
		if(cmd.getName().equalsIgnoreCase("citem")) {
			if(!sender.isOp()) {
				sender.sendMessage(message.NOT_PERMISSION);
			} else {
				if(args.length == 0) {
					sender.sendMessage(message.ERROR_ITEM);
					sender.sendMessage("== §cItems Disponibles§f ==");
					sender.sendMessage("== §aarc_teleporteur§f ==");
					sender.sendMessage("== §aarc_indestructible§f ==");
					sender.sendMessage("== §aepee_indestructible§f==");
					sender.sendMessage("== §apioche_xp§f ==");
					sender.sendMessage("== §apioche_key§f ==");
					sender.sendMessage("== §aepee_changeitem§f ==");
					sender.sendMessage("== §aepee_head§f ==");
					sender.sendMessage("== §apioche_moneyblock§f ==");
					sender.sendMessage("== §apioche_cuit§f ==");
					sender.sendMessage("== §aepee_voleuse§f ==");
					sender.sendMessage("§c=======================");
					
				}
				
				if(args.length == 1) {
					sender.sendMessage(message.ERROR_PLAYER);
				}
				if(args.length == 2) {
					Player target =  Bukkit.getPlayer(args[1]);
					PlayerInventory inv = target.getInventory();
					if(args[0].equalsIgnoreCase("arc_teleporteur")) {
						ItemStack is = new ItemStack(Material.BOW);
						ItemMeta im = is.getItemMeta();
						
						im.setDisplayName(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("tpbow.name")));
						List<String> lore = new ArrayList<String>();
						lore.add(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("tpbow.lore")));
						im.setLore(lore);
						if(main.getConfig().getBoolean("tpbow.glow")) {
							is.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
							im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
							is.setItemMeta(im);
						}
						inv.addItem(is);
					}
					if(args[0].equalsIgnoreCase("epee_head")) {
						Material type = toMaterial(main.getConfig().getString("epeehead.type"), "_SWORD");
						if(type == null) {
							sender.sendMessage("Merci de renseigner un type dans le config.yml pour epeehead.type");
							return false;
						}
						ItemStack is = new ItemStack(type);
						ItemMeta im = is.getItemMeta();
						im.setDisplayName(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("epeehead.name")));
						List<String> lore = new ArrayList<String>();
						lore.add(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("epeehead.lore")));
						im.setLore(lore);
						if(main.getConfig().getBoolean("epeehead.glow")) {
							is.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
							im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
							is.setItemMeta(im);
						}
						inv.addItem(is);

					}
					
					if(args[0].equalsIgnoreCase("epee_indestructible")) {
						Material type = toMaterial(main.getConfig().getString("epeedeath.type"), "_SWORD");
						if(type == null) {
							sender.sendMessage("Merci de renseigner un type dans le config.yml pour epeedeath.type");
							return false;
						}
						ItemStack is = new ItemStack(type);
						ItemMeta im = is.getItemMeta();
						im.setDisplayName(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("epeedeath.name")));
						List<String> lore = new ArrayList<String>();
						lore.add(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("epeedeath.lore")));
						im.setLore(lore);
						if(main.getConfig().getBoolean("epeedeath.glow")) {
							is.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
							im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
							is.setItemMeta(im);
						}
						inv.addItem(is);
					}
					
					if(args[0].equalsIgnoreCase("pioche_xp")) {
						Material type = toMaterial(main.getConfig().getString("xppioche.type"), "_PICKAXE");
						if(type == null) {
							sender.sendMessage("Merci de renseigner un type dans le config.yml pour xppioche.type");
							return false;
						}
						ItemStack is = new ItemStack(Material.DIAMOND_PICKAXE);
						ItemMeta im = is.getItemMeta();
						im.setDisplayName(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("xppioche.name")));
						List<String> lore = new ArrayList<String>();
						lore.add(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("xppioche.lore")));
						im.setLore(lore);
						if(main.getConfig().getBoolean("xppioche.glow")) {
							is.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
							im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
							is.setItemMeta(im);
						}
						inv.addItem(is);
					}
					
					if(args[0].equalsIgnoreCase("arc_indestructible")) {
						ItemStack is = new ItemStack(Material.BOW);
						ItemMeta im = is.getItemMeta();
						im.setDisplayName(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("arcdeath.name")));
						List<String> lore = new ArrayList<String>();
						lore.add(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("arcdeath.lore")));
						im.setLore(lore);
						if(main.getConfig().getBoolean("arcdeath.glow")) {
							is.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
							im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
							is.setItemMeta(im);
						}
						inv.addItem(is);
					}
					
					 if(args[0].equalsIgnoreCase("epee_voleuse")) {
						Material type = toMaterial(main.getConfig().getString("moneysword.type"), "_SWORD");
						if(type == null) {
							sender.sendMessage("Merci de renseigner un type dans le config.yml pour moneysword.type");
							return false;
						}
							ItemStack is = new ItemStack(type);
							ItemMeta im = is.getItemMeta();
							im.setDisplayName(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("moneysword.name")));
							List<String> lore = new ArrayList<String>();
							lore.add(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("moneysword.lore")));
							im.setLore(lore);
							if(main.getConfig().getBoolean("moneysword.glow")) {
								is.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
								im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
								is.setItemMeta(im);
							}
							inv.addItem(is);
						}
					 
					 if(args[0].equalsIgnoreCase("pioche_moneyblock")) {
						 Material type = toMaterial(main.getConfig().getString("piochemoney.type"), "_PICKAXE");
						 if(type == null) {
							 sender.sendMessage("Merci de renseigner un type dans le config.yml pour piochemoney.type");
						 }
						 ItemStack is = new ItemStack(type);
						 ItemMeta im = is.getItemMeta();
						 im.setDisplayName(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("piochemoney.name")));
						 List<String> lore = new ArrayList<String>();
						 lore.add(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("moneysword.lore")));
						 im.setLore(lore);
					     if(main.getConfig().getBoolean("moneysword.glow")) {
							is.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
							im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
							is.setItemMeta(im);
							}
						inv.addItem(is);	 
						 
					 }
					 if(args[0].equalsIgnoreCase("epee_changeitem")) {
						 Material type = toMaterial(main.getConfig().getString("epeeitem.type"), "_SWORD");
						 if(type == null) {
							 sender.sendMessage("Merci de renseigner un type dans le config.yml pour epeeitem.type");
						 }
						 ItemStack is = new ItemStack(type);
						 ItemMeta im = is.getItemMeta();
						 im.setDisplayName(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("epeeitem.name")));
						 List<String> lore = new ArrayList<String>();
						 lore.add(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("epeeitem.lore")));
						 im.setLore(lore);
					     if(main.getConfig().getBoolean("epeeitem.glow")) {
							is.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
							im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
							is.setItemMeta(im);
							}
						inv.addItem(is);	 
					 }
					 if(args[0].equalsIgnoreCase("pioche_key")) {
						 Material type = toMaterial(main.getConfig().getString("piochekey.type"), "_PICKAXE");
						 if(type == null) {
							 sender.sendMessage("Merci de renseigner un type dans le config.yml pour piochekey.type");
						 }
						 ItemStack is = new ItemStack(type);
						 ItemMeta im = is.getItemMeta();
						 im.setDisplayName(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("piochekey.name")));
						 List<String> lore = new ArrayList<String>();
						 lore.add(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("piochekey.lore")));
						 im.setLore(lore);
					     if(main.getConfig().getBoolean("piochekey.glow")) {
							is.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
							im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
							is.setItemMeta(im);
							}
						inv.addItem(is);	 
					 }
					 if(args[0].equalsIgnoreCase("pioche_cuit")) {
						 Material type = toMaterial(main.getConfig().getString("piochecuit.type"), "_PICKAXE");
						 if(type == null) {
							 sender.sendMessage("Merci de renseigner un type dans le config.yml pour piochecuit.type");
						 }
						 ItemStack is = new ItemStack(type);
						 ItemMeta im = is.getItemMeta();
						 im.setDisplayName(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("piochecuit.name")));
						 List<String> lore = new ArrayList<String>();
						 lore.add(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("piochecuit.lore")));
						 im.setLore(lore);
					     if(main.getConfig().getBoolean("piochecuit.glow")) {
							is.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
							im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
							is.setItemMeta(im);
							}
						inv.addItem(is);	 
					 }
					}
				
				
				}
			}
		
		
		
		return false;
		
}
	private Material toMaterial(String type, String suffix) {
		if(type == null || suffix == null) return null;
		switch(type) {
		case "diamant": return Material.valueOf("DIAMOND" + suffix);
		case "bois": return Material.valueOf("WOOD" + suffix);
		case "fer": return Material.valueOf("IRON" + suffix);
		case "pierre": return Material.valueOf("STONE" + suffix);
		default: break;
		}
		return null;
	}
}
