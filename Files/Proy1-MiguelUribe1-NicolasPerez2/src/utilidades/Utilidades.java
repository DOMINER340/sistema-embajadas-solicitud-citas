package utilidades;
/*import java.util.ArrayList;*/


import java.time.LocalDate;
import java.util.ArrayList;

import java.util.Map;

import javax.swing.table.DefaultTableModel;

import modelo.Estudiante;
import modelo.Niño02;
import modelo.Niño212;
import modelo.Requisito;
import modelo.Trabajo;
import modelo.Turismo;
import modelo.Usuario;
import modelo.Visa;

public class Utilidades {
	// ----------------------------
	//  Constantes
	// ----------------------------
		

	// ----------------------------
	//  Atributos
	// ----------------------------
	
	
	
	// ----------------------------
	//  Relaciones
	// ----------------------------
	
	
	
	// ----------------------------
	//  Constructores
	// ----------------------------
	
	
	
	// ----------------------------
	//  Métodos
	// ----------------------------
	
	
	/*
	 * 
	 */
	public static void imprimirUsuario( DefaultTableModel table, Usuario usuario)
	{
		
		
		LocalDate fecha = usuario.getFechaNacimiento();
		int edad = Utilidades.edadEnAnnos(fecha, LocalDate.now());
		String acudiente = " 0 ";
		String escolaridad = " 0 ";

		String textNumPassUsuarioAuxiliar = "";
		String textNombreUsuarioAuxiliar = "";
		String textPaisOrigenUsuarioAuxiliar = "";
		String textCiudadNacUsuarioAuxiliar = "";
		String textFechaNacUsuarioAuxiliar = "";
		String textEmailUsuarioAuxiliar = "";
		String textIfnfoAdUsuarioAuxiliar = "";
		if(edad >= 0 && edad < 2  )
		{
			Niño02 niño = (Niño02) usuario;
			acudiente = niño.getAcudiente();
			{
				textNumPassUsuarioAuxiliar = niño.getNumPasaporte();
				textNombreUsuarioAuxiliar = niño.getNombre();
				textPaisOrigenUsuarioAuxiliar = niño.getPaisNacimiento();			
				textCiudadNacUsuarioAuxiliar = niño.getCiudadNacimiento();
				textFechaNacUsuarioAuxiliar = niño.getFechaNacimiento().toString();
				textEmailUsuarioAuxiliar = niño.getEmail();
				textIfnfoAdUsuarioAuxiliar = acudiente;
				System.out.println("Clave: " + usuario.getNumPasaporte() + " -> Valor: " + usuario+ " acudiente: " + acudiente);  
			}

		}
		if(edad >= 2 && edad < 13  )
		{
			Niño212 niño = (Niño212) usuario;
			escolaridad = niño.getEscolaridad();
			{
				textNumPassUsuarioAuxiliar = niño.getNumPasaporte();
				textNombreUsuarioAuxiliar = niño.getNombre();
				textPaisOrigenUsuarioAuxiliar = niño.getPaisNacimiento();		
				textCiudadNacUsuarioAuxiliar = niño.getCiudadNacimiento();
				textFechaNacUsuarioAuxiliar = niño.getFechaNacimiento().toString();
				textEmailUsuarioAuxiliar = niño.getEmail();
				textIfnfoAdUsuarioAuxiliar = escolaridad;
				System.out.println("Clave: " + usuario.getNumPasaporte() + " -> Valor: " + usuario + " acudiente: " + escolaridad);  
			}
		}
		if(edad >=13 && edad <= 65  )
		{	
			{ 
				textNumPassUsuarioAuxiliar = usuario.getNumPasaporte();
				textNombreUsuarioAuxiliar = usuario.getNombre();
				textPaisOrigenUsuarioAuxiliar = usuario.getPaisNacimiento();			
				textCiudadNacUsuarioAuxiliar = usuario.getCiudadNacimiento();
				textFechaNacUsuarioAuxiliar = usuario.getFechaNacimiento().toString();
				textEmailUsuarioAuxiliar = usuario.getEmail();
				System.out.println("Clave: " + usuario.getNumPasaporte() + " -> Valor: " + usuario);
			}
		}
		if(edad >65 )
		{
			{ 
				textNumPassUsuarioAuxiliar = usuario.getNumPasaporte();
				textNombreUsuarioAuxiliar = usuario.getNombre();
				textPaisOrigenUsuarioAuxiliar = usuario.getPaisNacimiento();								
				textCiudadNacUsuarioAuxiliar = usuario.getCiudadNacimiento();
				textFechaNacUsuarioAuxiliar = usuario.getFechaNacimiento().toString();
				textEmailUsuarioAuxiliar = usuario.getEmail();
				System.out.println("Clave: " + usuario.getNumPasaporte() + " -> Valor: " + usuario);
			}
		}
		if(edad < 0 )
		{

		} 
		//panelAuxiliar.updateUI();
		Object[] fila = new Object[]{textNumPassUsuarioAuxiliar,textNombreUsuarioAuxiliar,textPaisOrigenUsuarioAuxiliar,textCiudadNacUsuarioAuxiliar,textFechaNacUsuarioAuxiliar,textEmailUsuarioAuxiliar,textIfnfoAdUsuarioAuxiliar};
		table.addRow(fila);
	}
	
	
	
	
	
	/**
	 * Calcula la edad dada dos fechas
	 * @param f1 Fecha de Nacimiento
	 * @param f2 Fecha actual
	 * @return
	 */
	public static int edadEnAnnos (LocalDate f1, LocalDate f2){
		int annos=0;
		annos = f2.getYear();
		annos = annos - f1.getYear();
		return annos;
	}
	
	/**
	 * Imprime los usuarios en pantalla con sus datos  
	 * @param map Map de los usuarios en el sistema
	 */
	public static void imprimirUsuarios(Map<String, Usuario> map)
	{
		
		// Imprimimos el Map con un Iterador
		java.util.Iterator<String> it =  map.keySet().iterator();
		while(it.hasNext()){
		  String	 key = it.next();
		  LocalDate fecha = map.get(key).getFechaNacimiento();
		  int edad = Utilidades.edadEnAnnos(fecha, LocalDate.now());
		  String acudiente = " 0 ";
		  String escolaridad = " 0 ";
		  
		  if(edad >= 0 && edad < 2  )
		  {
			  Usuario usuario = map.get(key);
			  Niño02 niño = (Niño02) usuario;
			  acudiente = niño.getAcudiente();
			  System.out.println("Clave: " + key + " -> Valor: " + map.get(key) + " acudiente: " + acudiente);
		  }
		  if(edad >= 2 && edad < 13  )
		  {
			  Usuario usuario = map.get(key);
			  Niño212 niño = (Niño212) usuario;
			  escolaridad = niño.getEscolaridad();
			  System.out.println("Clave: " + key + " -> Valor: " + map.get(key) + " escolaridad: " + escolaridad);
		  }
		  if(edad >=13 && edad <= 65  )
		  {	
			  System.out.println("Clave: " + key + " -> Valor: " + map.get(key));
		  }
		  if(edad >65 )
		  {
			  System.out.println("Clave: " + key + " -> Valor: " + map.get(key) );
		  }
		  if(edad < 0 )
		  {
			  
		  }  
		  
		}
	}
	
	/**
	 * Se imprime la visa en cuestión
	 * @param visas
	 */
	public static void visaImprimir(ArrayList<Visa> visas)
	{
		for (int i = 0; i < visas.size(); i++) {
			Visa visa = visas.get(i);
			if(visa.getId() == null)
			{
				continue;
			}
			System.out.println(" ");
			System.out.println("id: "+visa.getId());
			System.out.println("tipo: "+visa.getTipo());
			System.out.println("valor: "+visa.getValor());
			System.out.println("requisitos: ");
			for (int j = 0; j < visa.getRequisitos().size() ; j++) {
				Requisito temp = visa.getRequisitos().get(j);
				System.out.println("- "+ temp.getDescripcion());
			}
			
			if(visa.getTipo().equalsIgnoreCase("turismo"))
			{
				Turismo visaTurismo = (Turismo) visa;
				
				System.out.println("Dia estadia: " + visaTurismo.getDiasEstadia());
			}
			if(visa.getTipo().equalsIgnoreCase("trabajo"))
			{
				Trabajo visaTrabajo = (Trabajo) visa;
				System.out.println("cargo: " + visaTrabajo.getCargo());
				System.out.println("empresa: " + visaTrabajo.getEmpresa());
			}
			if(visa.getTipo().equalsIgnoreCase("estudiante"))
			{
				Estudiante visaEstudiante = (Estudiante) visa;
				System.out.println("escolaridad: " + visaEstudiante.getEscolaridad());
				System.out.println("institucion: " + visaEstudiante.getInstitucio());
			}
		}
		System.out.println(" ");
	}
	
	/**
	 * Convierte una cantidad de dinero con base en la tasa de cambio dada.
	 * @param monto Dinero en COP a convertir
	 * @param tasaCambio Tasa de cambio de la moneda a la cual se va a convertir
	 * @return Monto tras la conversión
	 */
	public static double conversiones (double monto, double tasaCambio){
		return monto/tasaCambio ;
	}
}
