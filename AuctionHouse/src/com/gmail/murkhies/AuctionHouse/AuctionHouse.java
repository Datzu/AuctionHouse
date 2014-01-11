package com.gmail.murkhies.AuctionHouse;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class AuctionHouse extends JavaPlugin {

	@Override
	public void onEnable() {
		getLogger().info("AuctionHouse is loading...");
	}

	@Override
	public void onDisable() {
		getLogger().info("AuctionHouse is disabling...");
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("ah")) {
			
			return true;
		}
		return false;
	}

}
