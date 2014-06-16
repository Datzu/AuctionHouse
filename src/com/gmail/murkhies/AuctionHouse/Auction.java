package com.gmail.murkhies.AuctionHouse;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class Auction extends BukkitRunnable {

	private Player creator;
	private HashMap<String, Broker> actualBrokers = new HashMap<String, Broker>();
	private Broker bestBroker;
	public Inventory inventoryAuction = Bukkit.createInventory(null, 54,
			"Auction inventory.");
	private AuctionHandler auctionHandler;
	public Material material;
	private int totalPayments;

	public Auction(Player player, Material tmpMat, int minValue) {
		this.creator = player;
		this.material = tmpMat;
		this.totalPayments = minValue;
		if (this.material == null) {
			creator.sendMessage(Strings.ERROR_CREATE);
			return;
		}
		player.openInventory(inventoryAuction);
	}

	public String getCreatorName() {
		return this.creator.getName();
	}

	public boolean canJoin(Player player) {
		return !actualBrokers.containsKey(player.getName()) ? true : false;
	}

	public boolean canLeave(Player player) {
		return actualBrokers.containsKey(player.getName()) ? true : false;
	}

	public void join(Player player) {
		Broker broker = new Broker(player);
		actualBrokers.put(player.getName(), broker);
	}

	public void leave(Player player) {
		actualBrokers.remove(player.getName());
		if (bestBroker.getPlayer().getName().equals(player.getName())) {
			bestBroker = null;
		}
	}

	public HashMap<String, Broker> getActualBrokers() {
		return actualBrokers;
	}

	public int getMinValue() {
		return totalPayments;
	}

	public boolean upgradeCurrentValue(Player player, int value) {
		if (actualBrokers.containsKey(player.getName())) {
			actualBrokers.get(player.getName()).canSet(value);
		}
		return false;
	}

	public String getBestBroker() {
		if (bestBroker == null) {
			returnItems();
			return Strings.NO_PLAYERS;
		}
		assingWinner();
		return "The winner is: " + bestBroker.getPlayer().getName();
	}

	public void stopAuction() {
		AuctionHouse.currentAuction = null;
		creator.sendMessage(Strings.SUCEFULLY_STOP);
	}

	@Override
	public void run() {
		try {
			Bukkit.broadcastMessage(Strings.NEW_AUCTION);
			auctionHandler = new AuctionHandler();
			auctionHandler.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void assingWinner() {
		ItemStack prize = new ItemStack(material);
		prize.setAmount(totalPayments - (totalPayments / 10));
		creator.getInventory().addItem(prize);
		bestBroker.getPlayer().openInventory(inventoryAuction);
	}

	public void returnItems() {
		creator.openInventory(inventoryAuction);
	}
	
	public Inventory getInventoryAuction() {
		return inventoryAuction;
	}

	public boolean checkLegit() {
		return inventoryAuction.getContents().length != 0 ? true : false;
	}

}
