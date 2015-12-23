package utils.command;

import java.util.List;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public abstract class Command {

	public String name;
	public String permissionNode;
	public List<String> aliases;
	
	public Command(String name, String permissionNode) {
		this.name = name;
		this.permissionNode = permissionNode;
	}
	
	public Command(String name, String permissionNode, List<String> aliases) {
		this.name = name;
		this.permissionNode = permissionNode;
		this.aliases = aliases;
	}
	
	public void fire(CommandSender sender, List<String> args) {
		if (sender instanceof Player)
			this.firePlayer((Player)sender, args);
		else
			this.fireOther(sender, args);
	}
	
	public abstract void firePlayer(Player player, List<String> args);
	
	public abstract void fireOther(CommandSender sender, List<String> args);
	
}
