package modelo;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author ASUS
 *Clase abstracta
 */

public abstract class Usuario implements Serializable
{
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
	protected String ciudadNacimiento;
	protected String email;
	protected LocalDate fechaNacimiento;
	protected String nombre;
	protected String numPasaporte;
	protected String paisNacimiento;
	
	// ----------------------------
	//  Relaciones
	// ----------------------------
	
	protected Solicitud solicitud;
	//protected double valorVisaIndividual;

	// ----------------------------
	//  Constructores
	// ----------------------------
	
	/**
	 * @param nombre
	 * @param numPasaporte
	 * @param email
	 * @param cambioOficial
	 * @param impuesto
	 * @param fechaNacimiento
	 * @param paisNacimiento
	 * @param ciudadNacimiento
	 */
	protected Usuario(String nombre, String numPasaporte, String email, LocalDate fechaNacimiento, String paisNacimiento, String ciudadNacimiento) {

		this.nombre = nombre;
		this.numPasaporte = numPasaporte;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.paisNacimiento = paisNacimiento;
		this.ciudadNacimiento = ciudadNacimiento;
		this.solicitud = null;
	}
	
	// ----------------------------
	//  Métodos
	// ----------------------------

	
	/**
	 * calcula el valor de la visa del prsente usuario
	 * @param impuesto
	 * @return
	 */
	public double calcularValorVisa(float impuesto, Visa visa,double valorVisaOriginal){
		int annos = utilidades.Utilidades.edadEnAnnos(this.getFechaNacimiento(), LocalDate.now());
		//arreglar lo de las edades ahora es por tipo de usuario
		double valorTemp = visa.getValor();
		if (annos < 2 && annos >= 0)
		{
			valorVisaOriginal = valorVisaOriginal/100;
			valorVisaOriginal = valorVisaOriginal*10;
		}
		if (annos < 13 && annos >= 2)
		{
			int edadFaltante = 18 - annos;
			edadFaltante = edadFaltante * 5;
			valorVisaOriginal = valorVisaOriginal/100;
			valorVisaOriginal = valorVisaOriginal*(100-edadFaltante);
			
			//en nuestro caso, es la embajada quien asume el impuesto pleno y el cliente paga el descuento
			if(visa.getTipo().equalsIgnoreCase("turismo"))
			{
				valorTemp = valorTemp/100;
				valorTemp = valorTemp*20;
				valorVisaOriginal = valorVisaOriginal+valorTemp;
			}
			if(visa.getTipo().equalsIgnoreCase("trabajo"))
			{
				valorTemp = valorTemp/100;
				valorTemp = valorTemp*30;
				valorVisaOriginal = valorVisaOriginal-valorTemp;
			}			
		}
		//aqui no hace nada
		if (annos <=65 && annos >= 13)
		{
			valorVisaOriginal = valorVisaOriginal/100;
			valorVisaOriginal = valorVisaOriginal*100;
		}
		if (annos > 65)
		{
			valorVisaOriginal = valorVisaOriginal/100;
			valorVisaOriginal = valorVisaOriginal*80;
			if(visa.getTipo().equalsIgnoreCase("turismo"))
			{
				valorTemp = valorTemp/100;
				valorTemp = valorTemp*10;
				valorVisaOriginal = valorVisaOriginal+valorTemp;
			}
		}
		visa.setValor(valorVisaOriginal);
		return valorVisaOriginal;
	}

	/**
	 * Calcula el valor de las visas de los asociados a la solicitud del presente usuario
	 * @return
	 */
	public String infoAsociado (float impuesto,Visa visa,double valor){
		String info = this.getNumPasaporte();
		
		info = info.concat("@" + this.getNombre());
		info = info.concat("@" + this.getFechaNacimiento().toString());
		
		double impu = (double) impuesto;
		
		double valorVisa = calcularValorVisa(impuesto,visa,valor);
		impu = (valorVisa/100)*(impu);
		String impuT = String.valueOf(impu);
		String strValor = String.valueOf(valorVisa);
		info = info.concat("@");
		info = info.concat(strValor);
		strValor = String.valueOf(impuT);
		info = info.concat("@");
		info = info.concat(strValor);
		
		info = info.concat("@");
		strValor = String.valueOf(valorVisa+impu);
		info = info.concat(strValor);	
		return info;
	}
	
	/**
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return
	 */
	public String getNumPasaporte() {
		return numPasaporte;
	}

	/**
	 * @param numPasaporte
	 */
	public void setNumPasaporte(String numPasaporte) {
		this.numPasaporte = numPasaporte;
	}

	/**
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return
	 */
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * @param fechaNacimiento
	 */
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * @return
	 */
	public String getPaisNacimiento() {
		return paisNacimiento;
	}

	/**
	 * @param paisNacimiento
	 */
	public void setPaisNacimiento(String paisNacimiento) {
		this.paisNacimiento = paisNacimiento;
	}

	/**
	 * @return
	 */
	public String getCiudadNacimiento() {
		return ciudadNacimiento;
	}

	/**
	 * @param ciudadNacimiento
	 */
	public void setCiudadNacimiento(String ciudadNacimiento) {
		this.ciudadNacimiento = ciudadNacimiento;
	}
	
	/**
	 * @return
	 */
	public Solicitud getSolicitud() {
		return solicitud;
	}
	
	/**
	 * @param solicitud
	 */
	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return nombre + "  " + numPasaporte + "  " + email
				+ "   " + fechaNacimiento + "   " + paisNacimiento + "   "
				+ ciudadNacimiento + "   ";
	}
	
	/**
	 * Vincula el presente usuario a una solictud
	 * @param fecha
	 * @param visa
	 * @param acompañantes
	 * @return
	 */
//	public Solicitud agregarUsuarioSolicitud(LocalDateTime fecha, Visa visa, ArrayList<Usuario> acompañantes,double valorOriginal)
//	{
//		
//		if(solicitud != null)
//		{
//			//TODO Generar excepción
//		}
//		
//		solicitud = new Solicitud(fecha, visa,valorOriginal);
//		
//		this.setSolicitud(solicitud);
//		return solicitud;
//	}
}
