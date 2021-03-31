package modelo;


import java.util.ArrayList;

public interface InterfaceSistemaCitasEmbajada {

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



	// ----------------------------
	//  Métodos
	// ----------------------------

	/**
	 * Crea una solicitud
	 * @return
	 */
	public default int  crearSolicitud(){
		return 0;
	}

	/**
	 * Da el valor final de la visa
	 * @return
	 */
	public default double darValorAcumuladoVisa(){
		return 0;

	}

	/**
	 * Consulta la lista de las los bebneficiarios de un descuento en el precio de la visa
	 * @return
	 * @throws Exception 
	 */
	public default ArrayList<String> consultarBeneficiarios () throws Exception{
		return null;
	}

}
