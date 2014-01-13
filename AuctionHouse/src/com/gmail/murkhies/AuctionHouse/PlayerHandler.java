package com.gmail.murkhies.AuctionHouse;

public class PlayerHandler {

	private int MAX_VALUE;
	private int CURRENT_VALUE;
	
	public PlayerHandler(int maxValue, int currentValue) {
		MAX_VALUE = maxValue;
		CURRENT_VALUE = currentValue;
	}

	public int getMAX_VALUE() {
		return MAX_VALUE;
	}

	public void setMAX_VALUE(int mAX_VALUE) {
		MAX_VALUE = mAX_VALUE;
	}

	public int getCURRENT_VALUE() {
		return CURRENT_VALUE;
	}

	public void setCURRENT_VALUE(int cURRENT_VALUE) {
		CURRENT_VALUE = cURRENT_VALUE;
	}

}
