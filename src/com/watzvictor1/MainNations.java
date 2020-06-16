package com.watzvictor1;

import java.util.Locale;
import java.util.ResourceBundle;

import org.bukkit.plugin.java.JavaPlugin;

import com.watzvictor1.commands.CommandNations;
import com.watzvictor1.language.Messages;

public class MainNations extends JavaPlugin {
	
	public static JavaPlugin INSTANCE;
	
	@Override
	public void onEnable() {
		INSTANCE = this;
		initLanguage();
		registerCommands();
	}

	private void registerCommands() {
		this.getCommand("Nations").setExecutor(new CommandNations());
	}
	
	private void initLanguage() {
		Messages.MESSAGES = ResourceBundle.getBundle("MessageBundle", new Locale("es"));
	}
}
