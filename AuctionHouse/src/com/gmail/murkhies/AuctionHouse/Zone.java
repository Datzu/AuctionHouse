package com.gmail.murkhies.AuctionHouse;

import java.util.HashMap;

public class Zone {
	
	private HashMap<String, Position> zone = new HashMap<String, Position>();
	
	public Zone() {
		
	}

	public HashMap<String, Position> getZone() {
		return zone;
	}

	public void setZone(HashMap<String, Position> zone) {
		this.zone = zone;
	}

}
