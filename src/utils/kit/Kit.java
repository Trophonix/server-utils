package utils.kit;

import org.bukkit.inventory.ItemStack;

public class Kit {

	private String name, description;
	private int price;
	private ItemStack icon;
	
	public Kit(String name, int price, String description, ItemStack icon) {
		this.name = name;
		this.price = price;
		this.description = description;
		this.icon = icon;
	}
	
	public String getName() {
		return name;
	}
	
}
