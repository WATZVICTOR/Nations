package com.watzvictor1.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Nation {
	
	String Name;
	Player Founder;
	Player Leader;
	List<Player> Members;
	Location Capital;
	List<Nation> Enemies;
	List<Nation> Allies;
	
	public Nation(String name, Player founder) {
		this.Name = name;
		this.Founder = founder;
		this.Leader = founder;
		this.Members = new ArrayList<Player>();
		this.Members.add(founder);
		this.Capital = null;
		this.Enemies = new ArrayList<Nation>();
		this.Allies = new ArrayList<Nation>();
	}

	public Player getMember(String name) {
		for (Player member : Members) {
			if (member.getName().equalsIgnoreCase(name)) return member; 
		}
		return null;
	}
	
	public Player getMember(UUID uuid) {
		for (Player member : Members) {
			if (member.getUniqueId().compareTo(uuid) == 0) return member; 
		}
		return null;
	}
	
	public boolean addMember(Player new_member) {
		return Members.add(new_member)
	}
	
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Player getFounder() {
		return Founder;
	}

	public void setFounder(Player founder) {
		Founder = founder;
	}

	public Player getLeader() {
		return Leader;
	}

	public void setLeader(Player leader) {
		Leader = leader;
	}

	public List<Player> getMembers() {
		return Members;
	}

	public void setMembers(List<Player> members) {
		Members = members;
	}

	public Location getCapital() {
		return Capital;
	}

	public void setCapital(Location capital) {
		Capital = capital;
	}

	public List<Nation> getEnemies() {
		return Enemies;
	}

	public void setEnemies(List<Nation> enemies) {
		Enemies = enemies;
	}

	public List<Nation> getAllies() {
		return Allies;
	}

	public void setAllies(List<Nation> allies) {
		Allies = allies;
	}

	@Override
	public String toString() {
		return "\nNation: " + this.Name
				+ "\nFounder: " + this.Founder.getName()
				+ "\nLeader: " + this.Leader.getName()
				+ "\nCapital: " + this.Capital.toString()
				+ "\nEnemies: " + this.Enemies.toString()
				+ "\nAllies: " + this.Allies.toString();
	}
	
}
