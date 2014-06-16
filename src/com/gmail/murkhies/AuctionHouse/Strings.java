package com.gmail.murkhies.AuctionHouse;

public final class Strings {

	public final static String
		ERROR_RUNNING = "There is an auction running at this moment.",
		ERROR_CREATE = "Bad syntax: try /ah create <material> <min value>",
		ERROR_SET = "Bad syntax: try /ah set <value>.",
		ERROR_JOIN = "Bad syntax: try /ah join <max value>.",
		ERROR_SECOND = "The second parameter must be a number.",
		ERROR_THIRD = "The third parameter must be a number.",
		ERROR_INVENTORY = "You must provide at least one item to bid.";

	public final static String
		NO_EXIST = "Firts you need to create an auction",
		NO_PLAYER = "You need to be a player.";

	public final static String
		SUCEFULLY_JOIN = "You joined the auction sucefully.",
		SUCEFULLY_STOP = "The actual auction has stopped.",
		SUCEFULLY_CREATE = "Auction created sucefully.",
		SUCEFULLY_LEAVE = "You left the actual auction.";

	public final static String
		NO_COMMAND = "This command need at least one parameter (info, create, join, leave, stop or set).",
		NOT_IN = "You are not in an auction.",
		NO_AUCTION = "There are no current auctions running at this momment.",
		NO_PLAYERS = "Auction ended, no one has joined this auction.";

	public final static String
		PERMISSION_ERROR = "You dont have permissions.",
		NEW_AUCTION = "A new Auction has started",
		SEP = "====================================",
		ALREADY_IN = "You already are in an auction.",
		CANT_JOIN = "You canno't join this auction.",
		NEGATIVE_VALUE = "You canno't put a negative value.",
		CANT_AFFORD = "You can't afford this. Please enter a little value.",
		ARE_CREATOR = "You canno't set a value for your own auction.";

}