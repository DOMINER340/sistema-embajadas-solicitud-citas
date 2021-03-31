package modelo;

import java.io.Serializable;

public class Requisito implements Serializable{
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
	
	/**
	 * 
	 */
	private String descripcion;

	

	// ----------------------------
	//  Relaciones
	// ----------------------------
	
	

	// ----------------------------
	//  Constructores
	// ----------------------------
	/**
	 * @param pDescripcion Descripción concerniente al requisito.
	 */
	public Requisito( String descripcion)
	{
		this.descripcion = descripcion;
	}
	
	/**
	 * @return
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
