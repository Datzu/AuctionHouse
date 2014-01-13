package com.gmail.murkhies.AuctionHouse;

import java.io.File;

public class Utils {
	
	private static boolean running;
	
	private static Auction auction;
	
	private static String path;
	
	private static int maxBrokers;
	
	public static File file;

	public static boolean isRunning() {
		return running;
	}

	public static void setRunning(boolean running) {
		Utils.running = running;
	}

	public static Auction getAuction() {
		return auction;
	}

	public static void setAuction(Auction auction) {
		Utils.auction = auction;
	}
	
	public static boolean isCreator(String playerName) {
		if (playerName.equals(auction.getCreatorName())) return true;
		return false;
	}
	
	public static void preLoad(AuctionHouse plugin) {
		Utils.path = plugin.getDataFolder() + File.separator + "auctionhouse" + File.separator + "config.txt";
		file = new File (Utils.path);
		
		// get max brokers rading the config file
		
	}
	
	public static boolean createConf(AuctionHouse plugin) {
		try {
			if (!file.exists()) {
				Utils.preLoad(plugin);
				file.mkdir();
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean existsFile() {
		if (file.exists()) {
			return true;
		} else {
			return false;
		}
	}
}
