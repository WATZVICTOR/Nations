package com.watzvictor1.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandNations implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String alias, String[] arg) {
		switch (arg.length) {
		case 0: // Comando: Reinos
			cs.sendMessage(
					"Aqui se supone que se habrirá una interfaz gráfica para que el usuario pueda administrarlo todo de manera mas sencilla.");
			break;
		case 1: // Comando: Reinos <create|remove|join>
			return Comando_1_args(cs, cmd, alias, arg[0]);
		case 2:
			return Comando_2_args(cs, cmd, alias, arg[0], arg[1]);
		case 3:
			return Comando_3_args(cs, cmd, alias, arg[0], arg[1], arg[2]);
		case 4:
			return Comando_4_args(cs, cmd, alias, arg[0], arg[1], arg[2], arg[3]);
		case 5:
			return Comando_5_args(cs, cmd, alias, arg[0], arg[1], arg[2], arg[3], arg[4]);
		case 6:
			return Comando_6_args(cs, cmd, alias, arg[0], arg[1], arg[2], arg[3], arg[4], arg[5]);
		case 7:
			return Comando_7_args(cs, cmd, alias, arg[0], arg[1], arg[2], arg[3], arg[4], arg[5], arg[6]);
		default:
			cs.sendMessage("Se ha ejecutado el metodo por defecto.");

		}
		return false;

	}

	private boolean Comando_1_args(CommandSender cs, Command cmd, String alias, String arg0) {
		// TODO Auto-generated method stub
		switch(arg0) {
		case "disband":
			return Controlador.disband(cs);
		case "list":
			return Controlador.list(cs);
		case "info":
			return Controlador.info(cs);
		case "help":
			return Controlador.help(cs);
		case "claim":
			return Controlador.claim(cs);
		case "debug":
			return Controlador.debug(cs);
		}
		return false;
	}

	private boolean Comando_2_args(CommandSender cs, Command cmd, String alias, String arg0, String arg1) {
		switch(arg0) {
		case "create":
			return Controlador.createReino(cs, arg1);
		case "info":
			return Controlador.infoReino(cs, arg1);
		}
		return false;
	}

	private boolean Comando_3_args(CommandSender cs, Command cmd, String alias, String string, String string2,
			String string3) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean Comando_4_args(CommandSender cs, Command cmd, String alias, String string, String string2,
			String string3, String string4) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean Comando_5_args(CommandSender cs, Command cmd, String alias, String string, String string2,
			String string3, String string4, String string5) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean Comando_6_args(CommandSender cs, Command cmd, String alias, String string, String string2,
			String string3, String string4, String string5, String string6) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean Comando_7_args(CommandSender cs, Command cmd, String alias, String string, String string2,
			String string3, String string4, String string5, String string6, String string7) {
		// TODO Auto-generated method stub
		return false;
	}
}