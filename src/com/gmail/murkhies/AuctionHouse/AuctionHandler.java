package com.gmail.murkhies.AuctionHouse;

import org.bukkit.Bukkit;

public class AuctionHandler extends Thread {

	@Override
	public void run() {
		super.run();
		try {
			sleep(20000);
			Bukkit.broadcastMessage(AuctionHouse.currentAuction.getBestBroker());
			AuctionHouse.currentAuction.stopAuction();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}