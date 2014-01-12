package com.gmail.murkhies.AuctionHouse;

import java.io.File;

public class Utils {
	
	private static boolean running;
	
	private static Auction auction;
	
	private static String path;
	
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
	
	public static boolean isConfigured(AuctionHouse plugin) {
		if (file.exists()) {
			return true;
		}
		return false;
	}
	
	public static void preLoad() {
		Utils.path = CommandHandlerAuctionConf.plugin.getDataFolder() + File.separator + "auctionhouse" + File.separator + "config.txt";
		file = new File (Utils.path);
	}
	
	public static boolean createConf() {
		try {
			if (!file.exists()) {
				file.mkdir();
				return true;
			} else {
				return false;
			}
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
