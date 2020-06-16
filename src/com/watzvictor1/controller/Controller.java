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

	/*
	 * 
	 * 
	 *  FUNCTION OF 2 ARGS COMMANDS
	 *  
	 *  
	 */
	
	public static boolean createNation(CommandSender cs, String nation_name) {
		// Check if the CommandSender has permissions.
				if (!cs.hasPermission("list")) {
					cs.sendMessage(MSG.getString("NO_PERMISSION"));
					return true;
				}
				// Check if the CommandSender is a Player or not.
				// TRUE; we create a Nation using the player as Leader and Founder.
				if (cs instanceof Player) { 
					Player player = (Player) cs;
					// Check if the Player is already a member of a Nation.
					if (Model.hasPlayerNation(player)) {
						cs.sendMessage(MSG.getString("INSIDE_NATION"));
						return true;
					}
					// Check if there is already a Nation with that name.
					if (Model.containsNation(nation_name)) {
						cs.sendMessage(MSG.getString("DUPLICATED_NATION"));
						return true;
					}
					// Create the Nation
					Nation new_Nation = new Nation(nation_name, player);
					// A
				// FALSE: we create a Nation using NULL as Leader and Founder.
				} else {
					
					
					/*
					 * IMPLEMENTAR
					 */
					
				}
		return false;
	}
	

}
