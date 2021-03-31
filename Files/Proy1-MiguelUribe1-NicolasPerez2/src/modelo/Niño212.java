package modelo;

import java.io.Serializable;
import java.time.LocalDate;

public class Niño212 extends Usuario implements Serializable{

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
	
	private String escolaridad;

	// ----------------------------
	// Relaciones
	// ----------------------------
	
	
	
	// ----------------------------
	// Constructores
	// ----------------------------
	
	public  Niño212(String nombre, String numPasaporte, String email, LocalDate fechaNacimiento, String paisNacimiento, String ciudadNacimiento,String escolaridad)
	{
		super( nombre,  numPasaporte,  email,  fechaNacimiento,  paisNacimiento,  ciudadNacimiento);
		this.setEscolaridad(escolaridad);
	}
	
	// ----------------------------
	//  Métodos
	// ----------------------------

	/**
	 * @return
	 */
	public String getEscolaridad() {
		return escolaridad;
	}

	/**
	 * @param escolaridad
	 */
	public void setEscolaridad(String escolaridad) {
		this.escolaridad = escolaridad;
	}
	
	
}
