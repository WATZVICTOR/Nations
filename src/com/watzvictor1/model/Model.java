package com.watzvictor1.model;

import java.util.ArrayList;
import java.util.List;

import com.watzvictor1.entity.Nation;

public class Model {

	private static List<Nation> NATIONS = new ArrayList<Nation>();
	
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
	
}
