package com.gmail.murkhies.AuctionHouse;

import java.io.File;

public class Utils {
	
	private static boolean running;
	private static Auction auction;

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
	
	public static boolean isConfigured() {
		File file = new File ("." + File.separator);
		return false;
	}
}
