package modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Trabajo extends Visa implements Serializable {
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

	private String empresa;
	private String cargo;

	// ----------------------------
	// Relaciones
	// ----------------------------



	// ----------------------------
	// Constructores
	// ----------------------------

	/**
	 * @param pTipo
	 * @param requisitos
	 */
	public Trabajo(String pTipo, ArrayList<Requisito> requisitos) {
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
	public String getEmpresa() {
		return empresa;
	}

	/**
	 * @param empresa
	 */
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	/**
	 * @return
	 */
	public String getCargo() {
		return cargo;
	}

	/**
	 * @param cargo
	 */
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

}
