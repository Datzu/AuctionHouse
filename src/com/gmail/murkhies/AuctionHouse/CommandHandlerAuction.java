package com.gmail.murkhies.AuctionHouse;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHandlerAuction implements CommandExecutor {

	AuctionHouse plugin;

	public CommandHandlerAuction(AuctionHouse instance) {
		plugin = instance;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (args.length == 0) {
			sender.sendMessage(Strings.NO_COMMAND);
			return true;
		}

		if (command.getName().equalsIgnoreCase("auction")) {
			if (sender instanceof Player) {

				Player player = (Player) sender;

				if (args[0].equals("create")) {
					if (args.length == 3) {
						try {
							Integer.parseInt(args[2]);
						} catch (Exception e) {
							player.sendMessage(Strings.ERROR_THIRD);
							return true;
						}
						if (AuctionHouse.currentAuction == null) {
							Material tmpMat = Material.getMaterial(args[1].toUpperCase());
							if (tmpMat != null) {
								AuctionHouse.currentAuction = new Auction(player, tmpMat, Integer.valueOf(args[2]));
								player.sendMessage(Strings.SUCEFULLY_CREATE);
							} else {
								player.sendMessage(Strings.ERROR_CREATE);
							}
						} else {
							player.sendMessage(Strings.ERROR_RUNNING);
						}
					} else {
						player.sendMessage(Strings.ERROR_CREATE);
					}
				} else if (args[0].equals("info") && args.length < 2) {
					if (AuctionHouse.currentAuction != null) {
						player.sendMessage(AuctionHouse.currentAuction.toString());
					} else {
						player.sendMessage(Strings.NO_AUCTION);
					}
				} else if (args[0].equals("join")) {
					if (AuctionHouse.currentAuction != null) {
						try {
							Integer.parseInt(args[1]);
						} catch (Exception e) {
							player.sendMessage(Strings.ERROR_SECOND);
							return true;
						}
						if (args.length == 2) {
							if (AuctionHouse.currentAuction.canJoin(player) && AuctionHouse.currentAuction != null) {
								AuctionHouse.currentAuction.join(player);
								player.sendMessage(Strings.SUCEFULLY_JOIN);
							} else {
								player.sendMessage(Strings.CANT_JOIN);
							}
						} else {
							player.sendMessage(Strings.ERROR_JOIN);
						}
					} else {
						player.sendMessage(Strings.NO_AUCTION);
					}
				} else if (args[0].equals("leave") && args.length < 2) {
					if (AuctionHouse.currentAuction != null) {
						if (AuctionHouse.currentAuction.canLeave(player)) {
							AuctionHouse.currentAuction.leave(player);
							player.sendMessage(Strings.SUCEFULLY_LEAVE);
						} else {
							player.sendMessage(Strings.NOT_IN);
						}
					} else {
						player.sendMessage(Strings.NO_AUCTION);
					}
				} else if (args[0].equals("stop") && args.length < 2) {
					if (AuctionHouse.currentAuction != null) {
						if (AuctionHouse.currentAuction != null
								&& AuctionHouse.currentAuction.getCreatorName().equals(player.getName())) {
							try {
								AuctionHouse.currentAuction.stopAuction();
							} catch (Exception e) {
								e.printStackTrace();
							}
						} else {
							sender.sendMessage(Strings.NO_COMMAND);
						}
					} else {
						player.sendMessage(Strings.NO_AUCTION);
					}
				} else if (args[0].equals("set")) {
					if (AuctionHouse.currentAuction != null) {
						if (args.length < 2) {

							if (AuctionHouse.currentAuction.getCreatorName().equals(player.getName())) {
								player.sendMessage(Strings.ARE_CREATOR);
								return true;
							}

							if (Integer.valueOf(args[1]) > plugin.currentAuction.getMinValue()) {
								if (Integer.valueOf(args[1]) <= AuctionHouse.currentAuction.getActualBrokers()
										.get(player.getName()).getMaxValue()) {
									if (AuctionHouse.currentAuction.getActualBrokers().get(player.getName()).getPlayer().getInventory().contains(AuctionHouse.currentAuction.material, Integer.valueOf(args[1]))) {
										AuctionHouse.currentAuction.getActualBrokers().get(player.getName())
										.setCurrentValue(Integer.valueOf(args[1]));
									} else {
										player.sendMessage(Strings.CANT_AFFORD);
									}
								} else {
									player.sendMessage(Strings.CANT_AFFORD);
								}
							} else {
								player.sendMessage(Strings.NEGATIVE_VALUE);
							}
						} else {
							player.sendMessage(Strings.ERROR_SET);
						}
					} else {
						player.sendMessage(Strings.NO_AUCTION);
					}
				} else {
					player.sendMessage(Strings.NO_COMMAND);
				}
			} else {
				sender.sendMessage(Strings.NO_PLAYER);
			}
		}

		return true;

	}
}
