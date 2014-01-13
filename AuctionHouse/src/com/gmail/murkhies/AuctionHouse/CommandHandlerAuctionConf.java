package com.gmail.murkhies.AuctionHouse;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHandlerAuctionConf implements CommandExecutor {

	AuctionHouse plugin;
	static Zone zone;

	public CommandHandlerAuctionConf(AuctionHouse instance) {
		plugin = instance;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {

		if (command.getName().equalsIgnoreCase("auctionset")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;

				switch (args[0]) {
					case "create":
						switch (args[1]) {
							case "zone":
								if (args.length < 3) {
									if (Utils.createConf(plugin)) {
										zone = new Zone();
										player.sendMessage(Strings.CREATE_SUCEFULLY);
									} else {
										player.sendMessage(Strings.FAILED_CREATE);
									}
								} else {
									player.sendMessage(Strings.ERROR_CREATE);
								}
								break;
							default:
								player.sendMessage(Strings.ERROR_COMMAND);
								break;
						}
						break;
					case "set":
						if (zone != null) {
							switch (args[1]) {
								case "auctioner":
									if (args.length < 3) {
										Position pos = new Position(player
												.getLocation().getBlockX(), player
												.getLocation().getBlockY(), player
												.getLocation().getBlockZ());
										zone.addAuctionerPosition(pos);
										player.sendMessage("Setting the auctioner position in: " + pos.toString());
										break;
									} else {
										player.sendMessage(Strings.ERROR_COMMAND);
									}
									break;
								case "pos":
									try {
										if (args.length < 3) {
											if (zone != null) {
												Position pos = new Position(player
														.getLocation().getBlockX(),
														player.getLocation()
																.getBlockY(), player
																.getLocation()
																.getBlockZ());
												zone.addPosition(pos);
												player.sendMessage("Setting the zone number " + zone.getNumZones() + " in the position: "
														+ pos.toString());
											} else {
												player.sendMessage(Strings.NO_ZONE);
											}
										} else {
											player.sendMessage(Strings.ERROR_CREATE);
										}
									} catch (Exception e) {
										player.sendMessage(Strings.ERROR_COMMAND);
									}
									break;
								default:
									player.sendMessage(Strings.ERROR_COMMAND);
									break;
							}
						} else {
							player.sendMessage(Strings.NO_ZONE);
						}
						break;
					case "delete":
						if (zone != null) {
							if (args.length < 3) {
								switch (args[1]) {
									case "zone":
										zone = new Zone();
										player.sendMessage(Strings.DELETE_SUCEFULLY);
										break;
									default:
										break;
								}
							} else {
								player.sendMessage(Strings.ERROR_DELETE);
							}
						} else {
							player.sendMessage(Strings.NO_ZONE);
						}
						break;
					case "save":
						if (zone != null) {
							if (args.length < 2) {
								if (Utils.existsFile()) {
									zone.save();
									player.sendMessage(Strings.SAVE_SUCEFULLY);
								} else {
									player.sendMessage(Strings.ERROR_SAVING);
								}
								break;
							} else {
								player.sendMessage(Strings.ERROR_SAVE);
							}
						}
						break;
					default:
						player.sendMessage(Strings.ERROR_COMMAND);
						break;
				}
			} else {
				sender.sendMessage(Strings.NO_PLAYER);
			}
		}
		return true;
	}

}
