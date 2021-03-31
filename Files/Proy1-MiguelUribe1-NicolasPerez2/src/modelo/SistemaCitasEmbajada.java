package modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import utilidades.Utilidades;


/**
 * 
 */
public  class SistemaCitasEmbajada  implements InterfaceSistemaCitasEmbajada , Serializable
{
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
	/**
	 * 
	 */
	private String id;
	private String paisEmbajada;
	private String moneda;
	private double cambioOficial;
	private float impuesto;

	// ----------------------------
	//  Relaciones
	// ----------------------------

	Map<String, Usuario> usuarios;
	private ArrayList <Visa> visas;
	private ArrayList<Solicitud> solicitudes;
	public Escolaridad escolaridad;



	// ----------------------------
	//  Constructores
	// ----------------------------
	public SistemaCitasEmbajada(String id, String paisEmbajada, String moneda, double cambioOficial, float impuesto){
		this.id = id;
		this.paisEmbajada = paisEmbajada; 
		this.moneda = moneda;
		this.cambioOficial = cambioOficial;
		this.impuesto = impuesto;
		this.usuarios = new HashMap<String, Usuario>();
		this.visas = new ArrayList<>();
		this.solicitudes = new ArrayList<>();
	}

	// ----------------------------
	//  Métodos
	// ----------------------------

	/**
	 * @return
	 */
	public Map<String, Usuario> getMap()
	{
		return this.usuarios;
	}

	/**
	 * @param nombre
	 * @param numPasaporte
	 * @param email
	 * @param fechaNacimiento
	 * @param paisNacimiento
	 * @param ciudadNacimiento
	 * @param acudiente
	 */
	public void agregarNiño02(String nombre, String numPasaporte, String email, LocalDate fechaNacimiento, String paisNacimiento, String ciudadNacimiento,String acudiente)
	{
		Niño02 niño02 = new Niño02(nombre, numPasaporte, email, fechaNacimiento, paisNacimiento, ciudadNacimiento, acudiente);
		usuarios.put(numPasaporte, niño02 );	
	}

	/**
	 * @param nombre
	 * @param numPasaporte
	 * @param email
	 * @param fechaNacimiento
	 * @param paisNacimiento
	 * @param ciudadNacimiento
	 * @param acudiente
	 */
	public void agregarNiño212(String nombre, String numPasaporte, String email, LocalDate fechaNacimiento, String paisNacimiento, String ciudadNacimiento,String acudiente)
	{
		Niño212 niño212 = new Niño212(nombre, numPasaporte, email, fechaNacimiento, paisNacimiento, ciudadNacimiento, acudiente);
		usuarios.put(numPasaporte, niño212);	
	}

	/**
	 * @param nombre
	 * @param numPasaporte
	 * @param email
	 * @param fechaNacimiento
	 * @param paisNacimiento
	 * @param ciudadNacimiento
	 */
	public void agregarAdulto(String nombre, String numPasaporte, String email, LocalDate fechaNacimiento, String paisNacimiento, String ciudadNacimiento)
	{		
		Adulto adulto = new Adulto(nombre, numPasaporte, email, fechaNacimiento, paisNacimiento, ciudadNacimiento);
		usuarios.put(numPasaporte, adulto );	
	}

	/**
	 * @param nombre
	 * @param numPasaporte
	 * @param email
	 * @param fechaNacimiento
	 * @param paisNacimiento
	 * @param ciudadNacimiento
	 */
	public void agregarAdultoMayor(String nombre, String numPasaporte, String email, LocalDate fechaNacimiento, String paisNacimiento, String ciudadNacimiento)
	{
		AdultoMayor adultoMayor = new AdultoMayor(nombre, numPasaporte, email, fechaNacimiento, paisNacimiento, ciudadNacimiento);
		usuarios.put(numPasaporte, adultoMayor );
	}

	public int crearSolicitud(Visa visa,double valor){

		LocalDateTime fecha = null;
		int consecutivo = solicitudes.size();
		fecha = asignarFechaHora(consecutivo);
		Solicitud nueva = new Solicitud(fecha, visa, valor);
		solicitudes.add(nueva);	
		return nueva.getCodigo();
	}

	/**
	 * Acumula los suntotales de los costos de la visa, y los retorna el total
	 * @param solicitud
	 * @param valor
	 * @return
	 */
	public double darValorAcumuladoVisa( Solicitud solicitud ,double valor)
	{

		double valorTotal = 0 ;
		float impuesto = (getImpuesto());
		//	double visa = 0;
		for (int i=0; i<solicitud.getUsuarios().size(); i++){
			Usuario usuario = solicitud.getUsuarios().get(i);
			//visa = visa + solicitud.getVisa().getValor();

			double valorImpuesto = usuario.calcularValorVisa(impuesto,solicitud.getVisa(),valor);
			valorImpuesto = (valorImpuesto/100)*(100+impuesto);
			valorTotal = valorTotal + valorImpuesto;
		}
		return valorTotal;
	}

	/**
	 * Asigna la fecha para la cita
	 * @param consecutivo
	 * @return
	 */
	public  LocalDateTime asignarFechaHora(int consecutivo)
	{
		LocalDateTime fechaAsignada = LocalDateTime.now();
		fechaAsignada = fechaAsignada.plusDays(1);
		fechaAsignada = fechaAsignada.withHour(8);
		fechaAsignada = fechaAsignada.withMinute(0);
		fechaAsignada = fechaAsignada.withSecond(0);
		fechaAsignada = fechaAsignada.withNano(0);
		if(consecutivo >= 1)
		{
			for (int i = 0; i < consecutivo; i++) {
				fechaAsignada = fechaAsignada.plusHours(1);
				if(fechaAsignada.getHour() > 16 )
				{
					fechaAsignada = fechaAsignada.plusDays(1);
					fechaAsignada = fechaAsignada.withHour(8);
				}
			}

		}
		return fechaAsignada;
	}

	/**
	 * Analizadora que retorna el objeto del usuario buscado
	 * @param numPasaporte
	 * @return
	 */
	public Usuario buscarUsuario(String numPasaporte)
	{
		Usuario usuario;
		usuario = usuarios.get(numPasaporte);
		if(usuario == null)
		{
			//genera error en caso de no haber usuarios con el numero de pasaporte dado.
			//vista.imprimir("Numerod de pasaporte no registrado.");
			//System.out.println("no se encontro el usuario: " + numPasaporte);
		}
		return usuario;
	}

	/**
	 * Busca un objeto de tipo Visa dado su tipo.
	 * @param tipo Tipo de visa que se busca
	 * @return El objeto de tipo visa buscada si se encuentra, o null en el caso opuesto.
	 * @throws Exception 
	 */
	public Visa buscarVisa(String tipo)
	{
		Visa visa = null;
		for (int i=0; i<visas.size() ;i++)
		{
			if(visas.get(i).getTipo().equalsIgnoreCase(tipo))
			{
				visa = visas.get(i);
			}
		}
		return visa;


	}

	//@SuppressWarnings("static-access")
	/**
	 * Retorna la lista de solicitudes
	 * @param Fecha
	 * @return
	 */
	public ArrayList<String> darSolicitudesString(String Fecha)
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate fecha = LocalDate.parse(Fecha, formatter);
		LocalDateTime fechaTime = LocalDateTime.of(fecha, LocalDateTime.now().toLocalTime());
		ArrayList<String> solicitudes = new ArrayList<String>() ;

		String fila = "";

		for (int i = 0; i < visas.size() ; i++) 
		{
			Visa visa = visas.get(i);
			if(visa.getId() == null)
			{
				continue;
			}
			else
			{
				Solicitud solicitud = visas.get(i).getSolicitud();
				for (int j = 0; j <solicitud.getUsuarios().size(); j++) {

					Usuario usuario = solicitud.getUsuarios().get(j);
					LocalDateTime temp = (LocalDateTime) solicitud.getFecha();				
					if(temp.isBefore(fechaTime))
					{
						fila = "";
						fila = fila.concat(usuario.getNumPasaporte());
						fila = fila.concat( "       @" + usuario.getNombre());
						fila = fila.concat( "     @" + visa.getTipo() + "     @" + solicitud.getCodigo() );
						solicitudes.add(fila);
					}	
				}
			}

		}
		return solicitudes;
	}

	/**
	 * Muestra los usuarios que disfrutan de un descuento en el valor de la visa
	 * @param Fecha
	 * @return
	 * @throws Exception 
	 */
	public ArrayList<String> consultarBeneficiarios() throws Exception
	{
		String informacionLinea = "";
		ArrayList<String> lineas = new ArrayList<>();
		// Imprimimos el Map con un Iterador
		java.util.Iterator<String> it =  usuarios.keySet().iterator();
		double acumulado = 0;
		while(it.hasNext())
		{
			String	 key = it.next();
			Usuario usuario = usuarios.get(key);
			Solicitud solicitud = usuario.getSolicitud();

			int edad = Utilidades.edadEnAnnos(usuario.getFechaNacimiento(), LocalDate.now());
			if(edad < 12 || edad > 65)
			{
				if(solicitud != null)
				{
					double valorVisaUsuario = usuario.calcularValorVisa(this.getImpuesto(), solicitud.getVisa(),solicitud.getValorVisaOriginal());
					double impuesto = (double) this.getImpuesto();
					valorVisaUsuario = (valorVisaUsuario/100)*(100+impuesto);

					double ValorVisaImpuesto = ((solicitud.getValorVisaOriginal()/100) * impuesto) + solicitud.getValorVisaOriginal();
					acumulado = acumulado + ( ValorVisaImpuesto - valorVisaUsuario);
					informacionLinea = informacionLinea.concat(usuario.getNumPasaporte()+ "   @");
					informacionLinea = informacionLinea.concat(usuario.getNombre() + "     @");
					informacionLinea = informacionLinea.concat(String.valueOf(valorVisaUsuario));
					lineas.add(informacionLinea);
				}
				else
				{
					JOptionPane.showConfirmDialog(null, "el usuario " + usuario.getNumPasaporte() + " no tiene solicitudes pendientes.", "Advertencia", JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
				}

			}
			informacionLinea = "";


			
		}
		lineas.add(String.valueOf(acumulado));
		return lineas;
	}

	/**
	 * @return
	 */
	public String getPaisEmbajada() {
		return paisEmbajada;
	}

	/**
	 * @param paisEmbajada
	 */
	public void setPaisEmbajada(String paisEmbajada) {
		this.paisEmbajada = paisEmbajada;
	}

	/**
	 * @return
	 */
	public String getMoneda() {
		return moneda;
	}

	/**
	 * @param moneda
	 */
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	/**
	 * @return
	 */
	public double getCambioOficial() {
		return cambioOficial;
	}

	/**
	 * @param cambioOficial
	 */
	public void setCambioOficial(double cambioOficial) {
		this.cambioOficial = cambioOficial;
	}

	/**
	 * @return
	 */
	public float getImpuesto() {
		return impuesto;
	}

	/**
	 * @param impuesto
	 */
	public void setImpuesto(float impuesto) {
		this.impuesto = impuesto;
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


	/**
	 * @return
	 */
	public ArrayList <Visa> getVisas() {
		return visas;
	}


	/**
	 * @param visas
	 */
	public void setVisas(ArrayList <Visa> visas) {
		this.visas = visas;
	}

	/**
	 * Retorna la lista de requisitos de una visa dado el tipo de la misma
	 * @param tipo
	 * @return
	 */
	public ArrayList<Requisito> BuscarRequisitosVisa(String tipo) {

		for (int i=0; i<visas.size(); i++){
			if(visas.get(i).getTipo().equalsIgnoreCase(tipo)){
				return visas.get(i).getRequisitos();
			}
		}
		return null;
	}

	/**
	 * Retorna la instacia de la soliccitud buscada dado el código de la misma
	 * @param codigo
	 * @return
	 */
	public Solicitud buscarSolicitud (int codigo){
		for (int i=0; i<solicitudes.size(); i++){
			if (solicitudes.get(i).getCodigo() == codigo){
				return solicitudes.get(i);
			}
		}
		return null;
	}

	/**
	 * @return
	 */
	public ArrayList<Solicitud> getSolicitudes() {
		return solicitudes;
	}

	/**
	 * @param solicitudes
	 */
	public void setSolicitudes(ArrayList<Solicitud> solicitudes) {
		this.solicitudes = solicitudes;
	}

	/**Adiciona una cualquier visa a la lista de visas
	 * @param visa
	 */
	public void agregarVisa(Visa visa)
	{
		visas.add(visa);
	}

	/**
	 * Adiciona específicamente la visa de Turismo
	 * @param tipo
	 * @param requisitos
	 */
	public void agregarVisaTurismo(String tipo ,ArrayList<Requisito> requisitos)
	{
		Turismo visaTurismo = new Turismo(tipo,requisitos);
		visas.add(visaTurismo);
	}

	/**
	 * Adiciona específicamente la visa de Trabajo
	 * @param tipo
	 * @param requisitos
	 */
	public void agregarVisaTrabajo(String tipo ,ArrayList<Requisito> requisitos)
	{
		Trabajo visaTrabajo = new Trabajo(tipo,requisitos);
		visas.add(visaTrabajo);
	}

	/**
	 * Adiciona específicamente la visa de estudiante
	 * @param tipo
	 * @param requisitos
	 */
	public void agregarVisaEstudiante(String tipo ,ArrayList<Requisito> requisitos)
	{
		Estudiante visaEstudiante = new Estudiante(tipo,requisitos);
		visas.add(visaEstudiante);
	}

	/**
	 * @return
	 */
	public Map<String, Usuario> getUsuarios() {
		return usuarios;
	}

	/**
	 * @param usuarios
	 */
	public void setUsuarios(Map<String, Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public void AñadirUsuarioSolicitud(String numPassSeleccionado, int codigo) throws Exception
	{
		// TODO Auto-generated method stub
		Solicitud solicitud = buscarSolicitud(codigo);
		Usuario usuario = buscarUsuario(numPassSeleccionado);
		//System.out.println("numero de usuarios en la solicutud: " + solicitud.getUsuarios().size());
		if(usuario.getSolicitud() == null )
		{

			if(solicitud.getVisa().getTipo().equalsIgnoreCase("turismo"))
			{
				solicitud.agregarUsuarioSolicitud(usuario);
				usuario.setSolicitud(solicitud);
			}
			if(solicitud.getVisa().getTipo().equalsIgnoreCase("trabajo"))
			{
				if(solicitud.getUsuarios().isEmpty())
				{
					solicitud.agregarUsuarioSolicitud(usuario);
					usuario.setSolicitud(solicitud);
				}
				else
				{
					Exception e = new Exception("No se pueden añadir mas usuarios a la Solicitud.");
					throw e;
				}
			}
			if(solicitud.getVisa().getTipo().equalsIgnoreCase("estudiante"))
			{
				if(solicitud.getUsuarios().isEmpty())
				{

					if( (Utilidades.edadEnAnnos(usuario.fechaNacimiento, LocalDate.now() ) >= 2) && (Utilidades.edadEnAnnos(usuario.fechaNacimiento, LocalDate.now() ) < 13))
					{
						solicitud.agregarUsuarioSolicitud(usuario);
						usuario.setSolicitud(solicitud);
						Niño212 niño = (Niño212) usuario;
						Visa visa = solicitud.getVisa();
						Estudiante visaEstudiante = (Estudiante) visa;
						visaEstudiante.setEscolaridad(niño.getEscolaridad());	
					}
					else
					{
						Exception e = new Exception("El usuario seleccionado no puede solicitar este tipo de visa.");
						throw e;
					}
				}
				else
				{
					Exception e = new Exception("No se pueden añadir mas usuarios a la Solicitud.");
					throw e;
				}
			}			
		}
		else
		{
			Exception e = new Exception("El usuario no puede ser añadido debido a que tiene una solicitud pendiente.");
			throw e;
		}	



	}
}