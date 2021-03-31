package modelo;
import java.io.Serializable;
import java.util.ArrayList;

import modelo.Requisito;
public abstract class Visa implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// ----------------------------
	// Constantes
	// ----------------------------

	// ----------------------------
	// Atributos
	// ----------------------------

	/**
	 * 
	 */
	protected String id;
	protected String tipo;
	protected double valor;
	
	// ----------------------------
	// Relaciones
	// ----------------------------
	
	protected ArrayList<Requisito> requisitos;
	protected Solicitud solicitudes;
	
	// ----------------------------
	// Constructores
	// ----------------------------
	
	/**
	 * Este es el contructor de la variable de la Visa
	 * @param id
	 * @param pTipo
	 * @param valor
	 */
	protected Visa (String pTipo, ArrayList<Requisito> requisitos){
		this.tipo = pTipo;
		this.requisitos = requisitos;
		//valor = /*EL VALOR DE LA VISA DEPENDIENDO DEL TIPO*/;
 	}
		
	// ----------------------------
	//  Métodos
	// ----------------------------
	
	/**
	 *  Método con distintas implementaciones dependiendo de la instancia que lo llame.
	 */
	protected void agregarSolicitud(Solicitud solicitud){
		this.solicitudes = solicitud;
	}
	
	/**
	 * @return
	 */
	protected Solicitud getSolicitud(){
		return this.solicitudes; 
	}
	
	
	/**
	 * @return
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return
	 */
	public double getValor() {
		return valor;
	}

	/**
	 * @param valor
	 */
	public void setValor(double valor) {
		this.valor = valor;
	}

	/**
	 * @return
	 */
	public ArrayList<Requisito> getRequisitos() {
		return requisitos;
	}

	/**
	 * @param requisitos
	 */
	public void setRequisitos(ArrayList<Requisito> requisitos) {
		this.requisitos = requisitos;
	}
	
	/**
	 * @param requisito
	 */
	public void agregarRequisito(Requisito requisito)
	{
		this.requisitos.add(requisito);
	}
	
	/**
	 * @return
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}
	
}
