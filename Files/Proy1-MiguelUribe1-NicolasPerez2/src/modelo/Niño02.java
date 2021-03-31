package modelo;

import java.io.Serializable;
import java.time.LocalDate;


public class Niño02 extends Usuario implements Serializable{
	
	// ----------------------------
	//  Constantes
	// ----------------------------


	// ----------------------------
	//  Atributos
	// ----------------------------
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String acudiente;

	// ----------------------------
	// Relaciones
	// ----------------------------
	
	
	
	// ----------------------------
	// Constructores
	// ----------------------------
	
	public  Niño02(String nombre, String numPasaporte, String email, LocalDate fechaNacimiento, String paisNacimiento, String ciudadNacimiento,String acudiente)
	{
		super( nombre,  numPasaporte,  email,  fechaNacimiento,  paisNacimiento,  ciudadNacimiento);
		this.setAcudiente(acudiente);
	}
	
	// ----------------------------
	//  Métodos
	// ----------------------------

	/**
	 * @return
	 */
	public String getAcudiente() {
		return acudiente;
	}

	/**
	 * @param acudiente
	 */
	public void setAcudiente(String acudiente) {
		this.acudiente = acudiente;
	}
	
}
