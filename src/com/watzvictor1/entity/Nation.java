package com.watzvictor1.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Nation {
	String nombre;
	Player fundador;
	Player lider;
	ArrayList<Player> miembros;
	Location nexo;
	ArrayList<Nation> enemigos;
	ArrayList<Nation> aliados;
	
	public Nation(String nombre, Player fundador) {
		
		this.nombre = nombre;
		this.fundador = fundador;
		this.lider = fundador;
		this.miembros = new ArrayList<Player>();
		this.nexo = new Location(null,0, 0, 0);
		this.enemigos = new ArrayList<Nation>();
		this.aliados = new ArrayList<Nation>();
		miembros.add(fundador);
		
	}
	
	
	/**
	 * 
	 * @param nombre
	 * @return Player con el nombre $nombre y Null si no se encuentra el jugador en la lista de miembros.
	 */
	public Player getMiembro(String nombre) {
		Player miembro = null;
		Iterator<Player> itr = miembros.iterator();
		while (itr.hasNext()) {
			Player aux = itr.next();
			if (aux.getName().equalsIgnoreCase(nombre)) miembro = aux;
		}
		return miembro;
	}
	
	/**
	 * @param uuid
	 * @return
	 */
	public Player getMiembro(UUID uuid) {
		Player miembro = null;
		Iterator<Player> itr = miembros.iterator();
		while (itr.hasNext()) {
			Player aux = itr.next();
			if (aux.getUniqueId().equals(uuid)) miembro = aux;
		}
		return miembro;
	}

	@Override
	public String toString() {
		return "\nReino: " + nombre
				+ "\nFundador: " + fundador.getName()
				+ "\nLider: " + lider.getName()
				+ "\nNexo: " + nexo.toString()
				+ "\nEnemigos: " + enemigos.toString()
				+ "\nAliados: " + aliados.toString();
	}
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Player getFundador() {
		return fundador;
	}

	public void setFundador(Player fundador) {
		this.fundador = fundador;
	}

	public Player getLider() {
		return lider;
	}

	public void setLider(Player lider) {
		this.lider = lider;
	}

	public ArrayList<Player> getMiembros() {
		return miembros;
	}

	public void setMiembros(ArrayList<Player> miembros) {
		this.miembros = miembros;
	}

	public Location getNexo() {
		return nexo;
	}

	public void setNexo(Location nexo) {
		this.nexo = nexo;
	}

	public ArrayList<Nation> getEnemigos() {
		return enemigos;
	}

	public void setEnemigos(ArrayList<Nation> enemigos) {
		this.enemigos = enemigos;
	}

	public ArrayList<Nation> getAliados() {
		return aliados;
	}

	public void setAliados(ArrayList<Nation> aliados) {
		this.aliados = aliados;
	}
}
