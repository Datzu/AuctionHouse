package com.gmail.murkhies.AuctionHouse;

import org.bukkit.plugin.java.JavaPlugin;

public class AuctionHouse extends JavaPlugin {

	@Override
	public void onEnable() {
		this.getCommand("auction").setExecutor(new CommandHandlerAuction(this));
		this.getCommand("auctionset").setExecutor(new CommandHandlerAuctionConf(this));
		Utils.preLoad();
		getLogger().info("AuctionHouse loaded sucefully!");
	}

	@Override
	public void onDisable() {
		getLogger().info("AuctionHouse disabled!");
	}

}