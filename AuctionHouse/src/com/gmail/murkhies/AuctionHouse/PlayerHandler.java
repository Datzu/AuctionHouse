package com.gmail.murkhies.AuctionHouse;

public class PlayerHandler {

	private int MAX_VALUE;
	private int CURRENT_VALUE;
	
	public PlayerHandler(int maxValue, int currentValue) {
		MAX_VALUE = maxValue;
		CURRENT_VALUE = currentValue;
	}

	public int getMaxValue() {
		return MAX_VALUE;
	}

	public void setMaxValue(int maxValue) {
		MAX_VALUE = maxValue;
	}

	public int getCurrentValue() {
		return CURRENT_VALUE;
	}

	public void setCurrentValue(int currentValue) {
		CURRENT_VALUE = currentValue;
	}

}
