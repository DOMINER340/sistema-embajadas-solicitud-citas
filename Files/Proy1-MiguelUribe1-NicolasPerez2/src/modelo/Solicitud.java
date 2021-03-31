package modelo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Solicitud implements Serializable{
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
	private int codigo;
	private static int CONSECUTIVO = 1;
	private String estado;
	private LocalDateTime fecha;
	private double ValorVisaOriginal = -1;
	// ----------------------------
	// Relaciones
	// ----------------------------

	private ArrayList <Usuario> usuarios;
	private Visa visa;

	// ----------------------------
	// Constructores
	// ----------------------------

	/**
	 * @param codigo 
	 * @param CONSECUTIVO
	 * @param estado
	 * @param fecha
	 */
	public Solicitud(LocalDateTime fecha,Visa visa, double valorOriginal) {
		this.codigo = CONSECUTIVO++ ;
		this.estado = "Pendiente";
		this.fecha = fecha;

		this.visa = visa;
		visa.agregarSolicitud(this);
		this.setValorVisaOriginal(valorOriginal);
		this.usuarios =new ArrayList<Usuario>();
	}


	// ----------------------------
	// Métodos
	// ----------------------------

	/**
	 * @param usuario
	 * @return
	 */
	public void agregarUsuarioSolicitud (Usuario usuario){
		this.usuarios.add(usuario);
	}
	/**
	 * @return
	 */
	public double calcularValor(){
		double a=0;
		return a;
	}

	/**
	 * @return
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return
	 */
	public LocalDateTime getFecha() {
		return fecha;
	}

	/**
	 * @param fecha
	 */
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return
	 */
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	/**
	 * @param acompañantes
	 */
	public void setUsuarios(List<Usuario> acompañantes) {
		this.usuarios = (ArrayList<Usuario>) acompañantes;
	}

	/**
	 * @return
	 */
	public Visa getVisa() {
		return visa;
	}

	/**
	 * @param visa
	 */
	public void setVisa(Visa visa) {
		this.visa = visa;
	}

	public void agregarAcompañantes(ArrayList<Usuario> acompañantes) 
	{
		usuarios.addAll(acompañantes);
	}

	public double getValorVisaOriginal() {
		return ValorVisaOriginal;
	}

	public void setValorVisaOriginal(double valorVisaOriginal) {
		ValorVisaOriginal = valorVisaOriginal;
	}



}
