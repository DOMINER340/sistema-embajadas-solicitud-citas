package modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Turismo extends Visa implements Serializable{
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

	private int diasEstadia;

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
	public Turismo(String pTipo, ArrayList<Requisito> requisitos) {
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
	 * Llena los daros de la visa de turismo
	 * @param id
	 * @param valor
	 * @param diaEstadia
	 */
	public void TurismoSolicitud(String id, double valor, int diaEstadia)
	{
		super.setId(id);
		super.setValor(valor);
		this.setDiasEstadia(diaEstadia);
	}

	/**
	 * @return
	 */
	public int getDiasEstadia() {
		return diasEstadia;
	}

	/**
	 * @param diasEstadia
	 */
	public void setDiasEstadia(int diasEstadia) {
		this.diasEstadia = diasEstadia;
	}
}
