package com.gmail.murkhies.AuctionHouse;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class Zone {
	
	private ArrayList<Position> zone = new ArrayList<Position>();
	
	public Zone() {
		
	}
	
	public ArrayList<Position> getZone() {
		return zone;
	}

	public void setZone(ArrayList<Position> zone) {
		this.zone = zone;
	}

	public String toString(int i) {
		return "Zone [zone=" + zone.toString() + "]";
	}

	public boolean addAuctionerPosition(Position pos) {
		try {
			this.zone.add(0, pos);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean addBrokerPosition(Position pos) {
		try {
			this.zone.add(1, pos);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public int getNumZones() {
		return this.zone.size();
	}
	
	public boolean save() {
		String cad = "";
		if (Utils.file.exists()) {
			for (Position pos : zone) {
				cad = cad + pos.getX() + " " + pos.getY() + " " + pos.getZ() + "\n";
			}
			try {
				BufferedWriter output = new BufferedWriter(new FileWriter(Utils.file));
				output.write(cad);
				output.close();
			} catch (Exception e) {
				return false;
			}
		} else {
			return false;
		}
		return true;
	}
	
	public void load() {
		
	}

}
