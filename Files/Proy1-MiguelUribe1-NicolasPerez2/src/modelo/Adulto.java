package modelo;

import java.io.Serializable;
import java.time.LocalDate;

public class Adulto extends Usuario implements Serializable{


	// ----------------------------
	//  Constantes
	// ----------------------------


	// ----------------------------
	//  Atributos
	// ----------------------------


	// ----------------------------
	// Relaciones
	// ----------------------------




	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Costructor del Adulto
	 * @param nombre
	 * @param numPasaporte
	 * @param email
	 * @param fechaNacimiento
	 * @param paisNacimiento
	 * @param ciudadNacimiento
	 */
	public Adulto(String nombre, String numPasaporte, String email, LocalDate fechaNacimiento, String paisNacimiento, String ciudadNacimiento) {
		super(nombre, numPasaporte, email, fechaNacimiento, paisNacimiento, ciudadNacimiento);
		// TODO Auto-generated constructor stub
	}

	// ----------------------------
	//  Métodos
	// ----------------------------

}
