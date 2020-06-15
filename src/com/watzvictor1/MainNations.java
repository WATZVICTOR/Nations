package com.watzvictor1;

import org.bukkit.plugin.java.JavaPlugin;

import com.watzvictor1.commands.CommandNations;

public class MainNations extends JavaPlugin {
	
	@Override
	public void onEnable() {
		registrarComandos();
		inicializarAlmacen();
	}

	private void inicializarAlmacen() {
		
	}

	private void registrarComandos() {
		this.getCommand("Nations").setExecutor(new CommandNations());
	}
}
