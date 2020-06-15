package com.watzvictor1.controller;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class Controller {

	private static final String PREFIJO = "[Reinos] - ";
	private static final String NO_PERMISO = ChatColor.RED + PREFIJO
			+ "No tienes permisos suficientes para realizar esta acción.";
	private static final String SOLO_JUGADORES = ChatColor.RED + PREFIJO
			+ "Esta accion solo la puede realizar un jugador online.";
	private static final String SOLO_LIDER = ChatColor.RED + PREFIJO
			+ "Esta accion solo la puede realizar el lider del reino.";
	private static final String NECESITAS_REINO = ChatColor.RED + PREFIJO
			+ "Necesitas estar dentro de un reino y ser el lider para poder realizar esta accion.";
	private static final String REINO_DUPLICADO = ChatColor.RED + PREFIJO + "Ya existe un reino con el nombre dado.";
	private static final String DENTRO_DE_REINO = ChatColor.RED + PREFIJO + "Ya estas dentro de un reino.";
	private static final String REINO_CREADO = ChatColor.BOLD + PREFIJO + "Reino creado.";
	private static final String REINO_DISBAND = ChatColor.BOLD + PREFIJO + "Reino disuelto.";
	private static final String REINO_NO_EXISTE = ChatColor.BOLD + PREFIJO + "Reino inexistente.";

	/*
	 * Funciones de la VISTA de 1 ARG
	 */

	/**
	 * Envia al CommandSender una lista con todos los reinos existentes.
	 * 
	 * @param cs
	 * @return true siempre
	 */
	public static boolean list(CommandSender cs) {
		// Comprobamos que antes de nada, si el CommandSender tiene permisos.
		if (!cs.hasPermission("list"))
			return true;
		// Imprimimos en el chat todos los reinos existentes del momento.
		cs.sendMessage(ChatColor.BOLD + "======= Lista de Reinos =======");
		for (Reino reino : Modelo.getReinos())
			cs.sendMessage(" - " + reino.getNombre());
		return true;
	}

	/**
	 * 
	 * @param cs
	 * @return
	 */
	public static boolean disband(CommandSender cs) {
		// Comprobamos si el CommandSender tiene permisos.
		if (!cs.hasPermission("disband")) {
			cs.sendMessage(NO_PERMISO);
			return true;
		}
		// Comprobamos si el CommandSender es un Jugador. (Es inutil ejecutar este
		// comando si no eres un jugador.)
		Player jugador;
		if (!(cs instanceof Player)) {
			cs.sendMessage(SOLO_JUGADORES);
			return true;
		}
		jugador = (Player) cs;
		// Comprobamos si el jugador esta unido a algun reino.
		if (!Modelo.hasPlayerReino(jugador)) {
			cs.sendMessage(NECESITAS_REINO);
			return true;
		}
		// Comprobamos si el CommandSender es el lider del reino al que pertenece.
		if (!Modelo.isPlayerLeader(jugador)) {
			cs.sendMessage(SOLO_LIDER);
			return true;
		}
		// Obtenemos el reino al que pertenece el jugador.
		Reino reino = Modelo.getReinoPlayer(jugador);
		// Expulsamos todos los miembros del reino.
		Modelo.removeReinoPlayerAll(reino);
		// Eliminamos el reino del modelo.
		Modelo.removeReino(reino);
		cs.sendMessage(REINO_DISBAND);
		return true;
	}

	/**
	 * Muestra al jugador la informacion relativa del reino en el que esta.
	 * 
	 * @param cs
	 * @return
	 */
	public static boolean info(CommandSender cs) {
		// Comprobamos que antes de nada, si el CommandSender tiene permisos.
		if (!cs.hasPermission("info")) {
			cs.sendMessage(NO_PERMISO);
			return true;
		}
		// Comprobamos si el CommandSender es un Jugador. (Es inutil ejecutar este
		// comando si no eres un jugador.)
		Player jugador;
		if (!(cs instanceof Player)) {
			cs.sendMessage(SOLO_JUGADORES);
			return true;
		}
		jugador = (Player) cs;
		// Comprobamos si el jugador esta unido a algun reino.
		if (Modelo.hasPlayerReino(jugador)) {
			// Si esta dentro de un reino, obtenemos el reino al que esta unido.
			String nombre_reino = Modelo.getReinoPlayer(jugador).getNombre();
			// Reciclamos infoReino que se enecarga de mostrar en pantalla la informacion de
			// un reino, en este caso la del suyo propio.
			infoReino((CommandSender) jugador, nombre_reino);
			return true;
			// FIN FLUJO
		} else {
			// Si no esta unido a ningun reino le decimos que ha de estar unido a uno para
			// ejecutar ese comando.
			cs.sendMessage(NECESITAS_REINO);
			return true;
			// FIN FLUJO
		}

	}

	public static boolean debug(CommandSender cs) {
		Player p = (Player) cs;
		p.getMetadata("Reino").forEach(

				a -> {
					cs.sendMessage(a.getOwningPlugin().getName());
					cs.sendMessage(a.asString());
				});
		cs.sendMessage(Modelo.getReinoPlayer(p).getLider().getName());
		return true;
	}

	public static boolean claim(CommandSender cs) {
		// Comprobamos que antes de nada, si el CommandSender tiene permisos.
		if (!cs.hasPermission("claim")) {
			cs.sendMessage(NO_PERMISO);
			return true;
		}
		// Comprobamos si el CommandSender es un Jugador. (Es inutil ejecutar este
		// comando si no eres un jugador.)
		Player jugador;
		if (!(cs instanceof Player)) {
			cs.sendMessage(SOLO_JUGADORES);
			return true;
		}
		jugador = (Player) cs;
		// Comprobamos si el jugador esta unido a algun reino.
		if (!Modelo.hasPlayerReino(jugador)) {
			cs.sendMessage(NECESITAS_REINO);
			return true;
		}
		// Comprobamos si el CommandSender es el lider.
		if (!Modelo.isPlayerLeader(jugador)) {
			cs.sendMessage(SOLO_LIDER);
			return true;
		}
		// Comprobamos si se encuentra un chunk/bloque/bioma ya claimeado.
		Chunk chunk = jugador.getChunk();
		if (Modelo.isClaimed(chunk)) {
			
		}
		// Claimeamos el terreno sobre el que esta el jugador.

	}

	/*
	 * Funciones de la VISTA de 2 ARG
	 */

	public static boolean createReino(CommandSender cs, String nombre_reino) {
		// Comprobamos que antes de nada, si el CommandSender tiene permisos.
		if (!cs.hasPermission("create")) {
			cs.sendMessage(NO_PERMISO);
			return true;
		}
		// Comprobamos si el CommandServer es un jugador, si no lo es, el reino a crear
		// tendra un fundador nulo.
		Player jugador;
		if (cs instanceof Player) {
			jugador = (Player) cs;
			// Comprobamos si el jugador esta unido a algun reino.
			if (Modelo.hasPlayerReino(jugador)) {
				jugador.sendMessage(DENTRO_DE_REINO);
				return true;
			}
			// Comprobamos si ya existe algun reino con el nombre dado.
			if (Modelo.containsReino(nombre_reino)) {
				jugador.sendMessage(REINO_DUPLICADO);
				return true;
			}
			// Creamos el reino, siendo el jugador el fundador del reino.
			Reino reino = new Reino(nombre_reino, jugador);
			Modelo.addReino(reino);
			// Añadimos al jugador el metadato del reino al que pertenece.
			Modelo.addReinoPlayer(reino, jugador);
			cs.sendMessage(REINO_CREADO);
			// FIN FLUJO
			// Si el CommandServer no es un jugador, se crea un reino sin fundador. (null)
		} else {
			// Comprobamos si ya existe algun reino con el nombre dado.
			if (Modelo.containsReino(nombre_reino)) {
				cs.sendMessage(REINO_DUPLICADO);
				return true;
			}
			// Creamos el reino
			Reino reino = new Reino(nombre_reino, null);
			Modelo.addReino(reino);
			cs.sendMessage(REINO_CREADO);
			// FIN FLUJO
		}
		return true;

	}

	/**
	 * Muestra al jugador la informacion relativa del reino que indique.
	 * 
	 * @param cs
	 * @param nombre_reino
	 * @return
	 */
	public static boolean infoReino(CommandSender cs, String nombre_reino) {
		// Comprobamos que antes de nada, si el CommandSender tiene permisos.
		if (!cs.hasPermission("info")) {
			cs.sendMessage(NO_PERMISO);
			return true;
		}
		// Miramos si existe el reino.
		if (!Modelo.containsReino(nombre_reino)) {
			cs.sendMessage(REINO_NO_EXISTE);
			return true;
		}
		// Sacamos toda la informacion del reino.
		Reino reino = Modelo.getReino(nombre_reino);
		cs.sendMessage(reino.toString());
		return true;
	}

	public static boolean help(CommandSender cs) {
		// Comprobamos que antes de nada, si el CommandSender tiene permisos.
		if (!cs.hasPermission("help")) {
			cs.sendMessage(NO_PERMISO);
			return true;
		}
		// Enviamos al CommandServer los diferentes

		/*
		 * IMPLEMENTAR
		 */
		return false;
	}
}
