package com.watzvictor1.controller;

import java.util.ResourceBundle;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.watzvictor1.entity.Nation;
import com.watzvictor1.language.Messages;
import com.watzvictor1.model.Model;

public class Controller {

	private static ResourceBundle MSG = Messages.MESSAGES;
	
	public static boolean list(CommandSender cs) {
		// Check if the CommandSender has permissions.
		if (!cs.hasPermission("list")) {
			cs.sendMessage(MSG.getString("NO_PERMISSION"));
			return true;
		}
		// Send to the CommandSender a list with all existing Nations.
		cs.sendMessage(MSG.getString("LIST_NATIONS_HEADER"));
		for (Nation nation : Model.getNations()) {
			cs.sendMessage(nation.getName());
		}
		return true;
		
	}

	public static boolean createNation(CommandSender cs, String nation_name) {
		// Check if the CommandSender has permissions.
				if (!cs.hasPermission("list")) {
					cs.sendMessage(MSG.getString("NO_PERMISSION"));
					return true;
				}
				// Check if the CommandSender is a Player or not.
				if (cs instanceof Player) {
					Player player = (Player) cs;
					// Check if the Player is already a member of a Nation.
					
					// We create the nation.
					Nation new_Nation = new Nation(nation_name, player);
				}
		return false;
	}
	

}
