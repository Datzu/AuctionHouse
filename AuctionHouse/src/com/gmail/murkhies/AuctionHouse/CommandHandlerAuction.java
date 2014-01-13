package com.gmail.murkhies.AuctionHouse;

import java.util.HashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHandlerAuction implements CommandExecutor {

	AuctionHouse plugin;
	
	HashMap<String, PlayerHandler> playerHashMap = new HashMap<String, PlayerHandler>();

	public CommandHandlerAuction(AuctionHouse instance) {
		plugin = instance;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command,	String label, String[] args) {
		
		if (command.getName().equalsIgnoreCase("auction")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				
				if (CommandHandlerAuctionConf.zone != null) {
					
					
					
					
				} else {
					sender.sendMessage(Strings.NO_ZONE);
				}
			} else {
				sender.sendMessage(Strings.NO_PLAYER);
			}
		}
		
		return true;

	}
	
}
