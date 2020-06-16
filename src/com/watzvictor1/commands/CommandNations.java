package com.watzvictor1.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.watzvictor1.controller.Controller;
import com.watzvictor1.language.Messages;

public class CommandNations implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String alias, String[] arg) {
		switch (arg.length) {
		case 0:
			cs.sendMessage(Messages.MESSAGES.getString("NO_PERMISSION"));
			return true;
		case 1:
			return Command_1_args(cs, cmd, alias, arg[0]);
		case 2:
			return Command_2_args(cs, cmd, alias, arg[0], arg[1]);
		default:
			cs.sendMessage("Se ha ejecutado el metodo por defecto.");
		}
		return false;

	}

	private boolean Command_1_args(CommandSender cs, Command cmd, String alias, String arg0) {
		switch(arg0) {
		case "list":
			return Controller.list(cs);
		}
		return false;
	}
	
	private boolean Command_2_args(CommandSender cs, Command cmd, String alias, String arg0, String arg1) {
		switch(arg0) {
		case "create":
			return Controller.createNation(cs, arg1);
		}
		return false;
	}

}