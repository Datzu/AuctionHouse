package com.gmail.murkhies.AuctionHouse;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class AuctionHouse extends JavaPlugin {

	public static Auction currentAuction;

	@Override
	public void onEnable() {
		this.getCommand("auction").setExecutor(new CommandHandlerAuction(this));
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new InventoryAuctionListener(this), this);
		getLogger().info("AuctionHouse loaded sucefully!");
	}

	@Override
	public void onDisable() {
		getLogger().info("AuctionHouse disabled!");
	}

}