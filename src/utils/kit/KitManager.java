package utils.kit;

import java.util.ArrayList;
import java.util.List;

public class KitManager {

	private List<Kit> kits;
	
	public KitManager() {
		kits = new ArrayList<Kit>();
	}
	
	public void addKit(Kit kit) {
		kits.add(kit);
	}
	
	public Kit getKit(String name) {
		if (kits.size() == 0)
			return null;
		for (Kit kit : kits) {
			if (kit.getName().equalsIgnoreCase(name))
				return kit;
		}
		return null;
	}
	
}
