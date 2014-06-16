package com.gmail.murkhies.AuctionHouse;

import org.bukkit.entity.Player;

public class Broker  {

	private int id;
	private int maxValue;
	private int currentValue;
	private Player player;

	public Broker() {

	}

	public Broker(Player player) {
		this.player = player;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(int maxValue) {
		this.maxValue = maxValue;
	}

	public boolean canSet(int value) {
		return value + this.currentValue <= this.maxValue ? true : false;
	}

	public int getCurrentValue() {
		return this.currentValue;
	}

	public void setCurrentValue(int currentValue) {
		this.currentValue = currentValue;
	}
	
	public void sendMessage(String cad) {
		this.player.sendMessage(cad);
	}

}
