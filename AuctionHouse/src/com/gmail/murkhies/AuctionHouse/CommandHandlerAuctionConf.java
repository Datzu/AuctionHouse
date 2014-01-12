package com.gmail.murkhies.AuctionHouse;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHandlerAuctionConf implements CommandExecutor {

	static AuctionHouse plugin;
	Zone zone;
	
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
								System.out.println("ok" + " " + args[2]);
								if (args.length < 3) {
									if (Utils.createConf()) {
										zone = new Zone();
										player.sendMessage(Strings.CREATE_SUCEFULLY);
									} else {
										player.sendMessage(Strings.FAILED_CREATE);
									}
								} else {
									player.sendMessage(Strings.ERROR_COMMAND);
								}
								break;
							default:
								player.sendMessage(Strings.ERROR_COMMAND);
								break;
						}
						break;
					case "set":
						switch (args[1]) {
							case "auctioner":
								try {
									if (args.length < 3) {
										if (zone != null) {
											Position pos = new Position(
													player.getLocation().getBlockX(), 
													player.getLocation().getBlockY(), 
													player.getLocation().getBlockZ());
											zone.addAuctionerPosition(pos);
											player.sendMessage("Adding " + pos.toString());
											break;
										} else {
											player.sendMessage(Strings.NO_ZONE);
										}
									} else {
										player.sendMessage(Strings.ERROR_COMMAND);
									}
								} catch (Exception e) {
									player.sendMessage(Strings.ERROR_COMMAND);
								}
								break;
							case "pos":
								try {
									if (args.length < 3) {
										if (zone != null) {
											Position pos = new Position(
													player.getLocation().getBlockX(), 
													player.getLocation().getBlockY(), 
													player.getLocation().getBlockZ());
											zone.addPosition(pos);
											player.sendMessage("Adding " + pos.toString());
										} else {
											player.sendMessage(Strings.NO_ZONE);
										}
									} else {
										player.sendMessage(Strings.ERROR_COMMAND);
									}
								} catch (Exception e) {
									player.sendMessage(Strings.ERROR_COMMAND);
								}
								break;
							default:
								player.sendMessage(Strings.ERROR_COMMAND);
								break;
						}
						break;
					case "delete":
						switch (args[1]) {
							case "zone":
								zone = new Zone();
								player.sendMessage(Strings.DELETE_SUCEFULLY);
								break;
							default:
								break;
						}
						break;
					case "save":
						try {
							if (Utils.existsFile()) {
								zone.save();
								player.sendMessage(Strings.SAVE_SUCEFULLY);
							} else {
								player.sendMessage(Strings.NO_ZONE);
							}
						} catch (Exception e) {
							player.sendMessage(Strings.ERROR_SAVING);
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
