package modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Estudiante extends Visa implements Serializable{
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
	private String institucio;
	
	// ----------------------------
	// Relaciones
	// ----------------------------
	

	
	// ----------------------------
	// Constructores
	// ----------------------------
	
	/**
	 * Costructor del Estudiante
	 * @param id
	 * @param pTipo
	 * @param valor
	 */
	public Estudiante(String pTipo, ArrayList<Requisito> requisitos) {
		super( pTipo, requisitos);
	}
	
	// ----------------------------
	//  Métodos
	// ----------------------------
	
	/* (non-Javadoc)
	 * @see modelo.Visa#agregarSolicitud()
	 */
	public void agregarSolicitud(){
		
	}

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

	/**
	 * @return
	 */
	public String getInstitucio() {
		return institucio;
	}

	/**
	 * @param institucio
	 */
	public void setInstitucio(String institucio) {
		this.institucio = institucio;
	}
}
