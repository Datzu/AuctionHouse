package com.gmail.murkhies.AuctionHouse;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHandler implements CommandExecutor {

	AuctionHouse plugin;

	public CommandHandler(AuctionHouse instance) {
		plugin = instance;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {

		// check if is a player
		if (sender instanceof Player) {
			Player player = (Player) sender;
			// args[0] handler
			switch (args[0]) {
				case "create":
					if (Utils.isRunning()) {
						player.sendMessage(Strings.AUCTION_RUNNING);
					} else {
						if (player.hasPermission("auctioner.start")) {
							// auction created
						} else {
							player.sendMessage(Strings.PERMISSION_ERROR);
						}
					}
					break;
				case "stop":
					if (Utils.isRunning()) {
						if (player.hasPermission("auctioner.stop")
								|| Utils.isCreator(player.getName())) {
	
						} else {
							player.sendMessage(Strings.PERMISSION_ERROR);
						}
					} else {
						player.sendMessage(Strings.NO_EXIST);
					}
					break;
				case "conf":
					if (player.hasPermission("auctioner.conf")) {
	
					} else {
						player.sendMessage(Strings.PERMISSION_ERROR);
					}
					break;
				default:
					break;
			}
		} else {
			sender.sendMessage("You must be a player!");
			return false;
		}

		return false;

	}
	
}