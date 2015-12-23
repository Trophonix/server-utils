package utils.command;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.server.ServerCommandEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandManager implements Listener {

	private List<Command> commands;

	public CommandManager(JavaPlugin plugin) {
		commands = new ArrayList<Command>();

		Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void consoleCommand(ServerCommandEvent e) {
		List<String> args = new ArrayList<String>();

		for (String arg : e.getCommand().split(" ")) {
			args.add(arg);
		}

		String cmd = args.get(0);
		args.remove(0);

		Command command = getCommand(cmd.toLowerCase());
		if (command != null) {
			e.setCancelled(true);
			command.fire(e.getSender(), args);
		} 
	}

	@EventHandler
	public void playerCommand(PlayerCommandPreprocessEvent e) {
		List<String> args = new ArrayList<String>();

		for (String arg : e.getMessage().split(" ")) {
			args.add(arg);
		}

		String cmd = args.get(0);
		args.remove(0);

		Command command = getCommand(cmd.toLowerCase());
		if (command != null) {
			e.setCancelled(true);
			command.fire(e.getPlayer(), args);
		}
	}

	public void add(Command command) {
		commands.add(command);
	}

	public Command getCommand(String name) {
		for (Command command : commands) {
			if (command.name.equalsIgnoreCase(name)
					|| (command.aliases.size() > 0 && command.aliases.contains(name.toLowerCase())))
				return command;
		}
		return null;
	}

}
