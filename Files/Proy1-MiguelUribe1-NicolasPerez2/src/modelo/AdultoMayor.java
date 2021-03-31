package modelo;

import java.io.Serializable;
import java.time.LocalDate;

public class AdultoMayor extends Usuario implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ----------------------------
	//  Constantes
	// ----------------------------


	// ----------------------------
	//  Atributos
	// ----------------------------


	// ----------------------------
	// Relaciones
	// ----------------------------



	// ----------------------------
	// Constructores
	// ----------------------------

	/**
	 * Constructor del Adulto Mayor
	 * @param nombre
	 * @param numPasaporte
	 * @param email
	 * @param fechaNacimiento
	 * @param paisNacimiento
	 * @param ciudadNacimiento
	 */
	public AdultoMayor(String nombre, String numPasaporte, String email, LocalDate fechaNacimiento, String paisNacimiento, String ciudadNacimiento) {
		super(nombre, numPasaporte, email, fechaNacimiento, paisNacimiento, ciudadNacimiento);
	}


	// ----------------------------
	//  Métodos
	// ----------------------------




}
