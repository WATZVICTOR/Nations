package com.watzvictor1.model;

import java.util.List;

public class Model {

	private static List<Nation> NATIONS = new ArrayList<Nation>();
	
	private static String METADATA_KEY = "Nation";
	
	public static List<Nation> getReinos() {
		return NATIONS;
	}
	
	public static boolean addReino(Nation nation) {
		return NATIONS.add(nation);
	}
	
	/**
	 * Elimina el reino del modelo de datos.
	 * @param reino
	 * @return
	 */
	public static boolean removeReino(Nation nation) {
		return NATIONS.remove(nation);
	}
	
	/**
	 * Elimina el reino del modelo de datos.
	 * @param reino
	 * @return
	 */
	public static boolean removeReino(String nation_name) {
		return removeReino(getReino(nation_name));
	}
	
	/**
	 * Devuele el reino con el nombre dado.
	 * @param nombre_reino
	 * @return El objecto reino si existe, null si no existe.
	 */
	public static Reino getReino(String nation_name) {
		for (Nation nation: NATIONS) {
			if (reino.getNombre().equalsIgnoreCase(nation_name)) {
				return reino;
			}
		}
		return null;
	}
	
	/**
	 * Comprueba si ya existe el reino con el nombre dado.
	 * @param nombre_reino
	 * @return true si ya existe, falso si no existe.
	 */
	public static boolean containsReino(String nombre_reino) {
		for (Reino reino: NATIONS) {
			if (reino.getNombre().equalsIgnoreCase(nombre_reino)) {
				return true;
			}
		}
		return false;
	}
		
	/**
	 * Comprueba si el jugador se encuentra unido a algun reino.
	 * @param jugador
	 * @return
	 */
	public static boolean hasPlayerReino(Player jugador) {
		return jugador.hasMetadata(METADATA_KEY) ? true : false;
	}
	
	/**
	 * Devuelve el reino al que pertenece el jugador.
	 * @param jugador
	 * @return el reino al que pertenece o null si no pertence a ninguno
	 */
	public static Reino getReinoPlayer(Player jugador) {
		// Sacamos el metadato "Reino"
		List<MetadataValue> data = jugador.getMetadata(METADATA_KEY);
		// Sacamos el metadato.
		String nombre_reino = data.get(0).asString();
		// Devolvemos el reino ayudandonos de las funciones ya creadas.
		return Modelo.getReino(nombre_reino);
	}
	
	/**
	 * Asigna un reino a un jugador. Insertamos en los metadatos del jugador el reino al que pertenece.
	 * @param reino
	 * @param jugador
	 * @return true siempre
	 */
	public static boolean addReinoPlayer(Reino reino, Player jugador) {
		// Creamos el metadato a meter, en este caso es el nombre del reino al que se va a unir.
		MetadataValue dato = new FixedMetadataValue(MainClass.INSTANCIA,reino.getNombre());
		// Asignamos el metadato al jugador, para indicar que pertenece al reino dado.
		jugador.setMetadata(METADATA_KEY, dato);
		return true;
	}
	
	/**
	 * Elimina un jugador de un reino. Eliminamos el metadato reino del jugador.
	 * @param reino
	 * @param jugador
	 * @return true siempre
	 */
	public static boolean removeReinoPlayer(Reino reino, Player jugador) {
		// Eliminamos el metadato Reino del jugador, para indicar que ya no pertenece a ningun reino.
		jugador.removeMetadata(METADATA_KEY, MainClass.INSTANCIA);
		return true;
	}

	/**
	 * Comprueba si el juegador es lider del reino en el que está.
	 * @param jugador
	 * @return
	 */
	public static boolean isPlayerLeader(Player jugador) {
		// Sacamos el UUID del jugador.
		UUID uuid_jugador = jugador.getUniqueId();
		// Sacamos el reino del jugador.
		Reino reino = Modelo.getReinoPlayer(jugador);
		// Sacamos el UUID del lider del reino del jugador.
		UUID uuid_lider_reino = reino.getLider().getUniqueId();
		// Comparamos si son el mismo.
		return uuid_lider_reino.equals(uuid_jugador);
	}

	/**
	 * Elimina a todos los jugadores de un reino.
	 * @param reino
	 */
	public static void removeReinoPlayerAll(Reino reino) {
		for (Player miembro : reino.getMiembros()) {
			Modelo.removeReinoPlayer(reino, miembro);
		}
		return;
	}

	/**
	 * Comprueba si el chunk esta reclamado por un reino.
	 * @param chunk
	 * @return
	 */
	public static boolean isClaimed(Chunk chunk) {
		return false;
	}
}
