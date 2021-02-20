package fr.arthursrv.darkonia.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import fr.arthursrv.darkonia.Main;
import fr.arthursrv.darkonia.core.message;

public class ctime implements CommandExecutor {
	private Main main = Main.getInstance();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("ctime")) {
			if(!sender.isOp()) {
				sender.sendMessage(message.NOT_PERMISSION);
			} else {
				if(args.length == 0) {
					sender.sendMessage("Mettez l'argument reload si vous voulez reload le plugin");
				}
				if(args.length == 1) {
					if(args[0].equalsIgnoreCase("reload")) {
						Bukkit.getServer().getPluginManager().disablePlugin(main);	
						Bukkit.getServer().getPluginManager().enablePlugin(main);
						} else {
						sender.sendMessage("Argument inconnu");
					}
				}
			}
		}
		return false;
	}

}
