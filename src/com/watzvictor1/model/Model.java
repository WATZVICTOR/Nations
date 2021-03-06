package com.watzvictor1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;

import com.watzvictor1.MainNations;
import com.watzvictor1.entity.Nation;

public class Model {

	private static List<Nation> NATIONS = new ArrayList<Nation>();
	
	private static String METADATA_KEY = "Nation";
	
	public static List<Nation> getNations() {
		return NATIONS;
	}
	
	public static boolean addNation(Nation new_nation) {
		return NATIONS.add(new_nation);
	}
	
	public static Nation getNation(String nation_name) {
		for (Nation nation : NATIONS) {
			if (nation.getName().equalsIgnoreCase(nation_name)) return nation;
		}
		return null;
	}
	
	public static boolean containsNation(String nation_name) {
		return NATIONS.contains(getNation(nation_name));
	}
	
	public static boolean removeNation(String nation_name) {
		return NATIONS.remove(getNation(nation_name));
	}
	
	public static boolean hasPlayerNation(Player player) {
		return player.hasMetadata(METADATA_KEY) ? true : false;
	}
	
	public static boolean setPlayerNation(Player player, Nation nation) {
		// We chech if the player is already a member of a Nation.
		if (hasPlayerNation(player)) return false;
		// We create the metadata, in this case the name of the nation that we want to give to the player.
		MetadataValue nation_metadata = new FixedMetadataValue(MainNations.INSTANCE, nation.getName());
		// We set the metadata inside the player, so we can check the Nation of the player.
		player.setMetadata(METADATA_KEY, nation_metadata);
		return true;
	}
	
	public static boolean removePlayerNation(Player player) {
		// We check if the player is already a member of a Nation.
		if (!hasPlayerNation(player)) return false;
		// Now we remove the nation metadata from the player.
		player.removeMetadata(METADATA_KEY, MainNations.INSTANCE);
		return true;
	}
	
}
