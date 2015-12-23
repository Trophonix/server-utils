package main;

import org.bukkit.plugin.java.JavaPlugin;

import utils.command.CommandManager;
import utils.kit.KitManager;

public abstract class Server extends JavaPlugin {
	
	private static Server instance;
	
	private static KitManager kitManager;
	private static CommandManager commandManager;
	
	public Server() {
		instance = this;
		
		kitManager = new KitManager();
		commandManager = new CommandManager(this);
	}
	
	@Override
	public abstract void onEnable();
	
	@Override
	public abstract void onDisable();
	
	public static Server getInstance() {
		return instance;
	}
	
	public static KitManager getKitManager() {
		return kitManager;
	}
	
	public static CommandManager getCommandManager() {
		return commandManager;
	}
	
}
