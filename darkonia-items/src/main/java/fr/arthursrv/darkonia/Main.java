package fr.arthursrv.darkonia;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

import fr.arthursrv.darkonia.commands.citem;
import fr.arthursrv.darkonia.commands.ctime;
import fr.arthursrv.darkonia.listeners.entityAttack;
import fr.arthursrv.darkonia.listeners.epeeDeath;
import fr.arthursrv.darkonia.listeners.epeeHead;
import fr.arthursrv.darkonia.listeners.miningEvent;
import fr.arthursrv.darkonia.listeners.teleportBow;

public class Main extends JavaPlugin {
	public static Main instance;
	
	private static final Logger logger = Logger.getLogger("Minecraft");
	
	@Override
	public void onEnable()  {
		instance = this;
		saveDefaultConfig();
		getServer().getPluginManager().registerEvents(new teleportBow(), this);
		getServer().getPluginManager().registerEvents(new epeeHead(), this);
		getServer().getPluginManager().registerEvents(new epeeDeath(), this);
		getServer().getPluginManager().registerEvents(new entityAttack(), this);
		getServer().getPluginManager().registerEvents(new miningEvent(), this);
		getCommand("citem").setExecutor(new citem());
		getCommand("ctime").setExecutor(new ctime());
	}
	
	@Override
	public void onDisable() {
		
	}
	
	public static Main getInstance() {
		return instance;
	}
}
