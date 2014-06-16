package com.gmail.murkhies.AuctionHouse;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryAuctionListener implements Listener {
	
	AuctionHouse plugin;

	public InventoryAuctionListener(AuctionHouse plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	private void  onInventoryClose(InventoryCloseEvent c) {
		if (plugin.currentAuction != null) {
			if (c.getInventory().getTitle().equals(AuctionHouse.currentAuction.getInventoryAuction().getTitle())) {
				ItemStack[] tmpIS = c.getInventory().getContents();
				for (ItemStack item : tmpIS) {
					System.out.println(Material.getMaterial(item.getType().getId()).name());
				}
			}
		}
	}

}