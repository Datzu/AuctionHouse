package com.gmail.murkhies.AuctionHouse;

import org.bukkit.plugin.java.JavaPlugin;

public class AuctionHouse extends JavaPlugin {

	@Override
	public void onEnable() {
		this.getCommand("auction").setExecutor(new CommandHandler(this));
		this.getCommand("auction_configuration").setExecutor(new CommandHandler(this));
		getLogger().info("AuctionHouse loaded sucefully!");
	}

	@Override
	public void onDisable() {
		getLogger().info("AuctionHouse disabled!");
	}

}
