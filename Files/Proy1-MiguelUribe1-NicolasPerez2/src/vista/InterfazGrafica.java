package vista;

import javax.swing.JFrame;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JTabbedPane;
import controlador.Controlador;
import modelo.Usuario;
import modelo.Visa;


public class InterfazGrafica extends JFrame {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * atributos
	 */
	private IMenuDeServicios MenuServicio;
	private IAsociarPaisEmbajada asociarPaisEmbajada;
	private static IIngresarSolicitantes ingresarSolicitante;
	private static IIngresarVisas ingresarVisa;
	private ISolicitarVisaTurismo solicitarVisaTurismo;
	private ISolicitarVisaTrabajo solicitarVisaTrabajo;
	private ISolicitarVisaEstudiante solicitarVisaEstudiante;
	private ICalcularValorVisa CalcularValorVisa;
	private IMostrarReportesVisa mostrarReportesVisa;
	private ImostrarReporteBeneficiarios mostrarReporteBeneficiarios;
	private static JTabbedPane tabPestañas;
	
	/**
	 * Constantes 
	 */
	public static final String CARGAR_ARCHIVO_TARIFAS = "CARGAR_ARCHIVO_TARIFAS";
	public static final String ADICIONAR_USUARIO = "ADICIONAR_USUARIO";
	
	public static final String ASOCIAR_EMBAJADA = "ASOCIAR_EMBAJADA";
	public static final String INGRESAR_SOLICITANTES = "INGRESAR_SOLICITANTES";
	public static final String INGRESAR_VISAS = "INGRESAR_VISAS";
	public static final String SOLICITAR_VISA_TRABAJO = "SOLICITAR_VISA_TRABAJO";
	public static final String SOLICITAR_VISA_TURISMO = "SOLICITAR_VISA_TURISMO";
	public static final String SOLICITAR_VISA_ESTUDIANTE = "SOLICITAR_VISA_ESTUDIANTE";
	public static final String SALVAR_DATOS_SISTEMA = "SALVAR_DATOS_SISTEMA";
	public static final String CARGAR_DATOS_SISTEMA = "CARGAR_DATOS_SISTEMA";
	public static final String CALCULAR_VALOR_VISA = "CALCULAR_VALOR_VISA";
	public static final String MOSTRAR_REPORTE_VISA = "MOSTRAR_REPORTE_VISA";
	public static final String MOSTRAR_REPORTE_BENEFICIARIO = "MOSTRAR_REPORTE_BENEFICIARIO";
		
	
	/**
	 * relaciones.
	 */	
	private Controlador controlador;

	/**
	 * Create the frame.
	 */
	public InterfazGrafica(Controlador pControlador) {
		controlador = pControlador;
		
		setTitle("Sistema Citas Embajada");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 900, 600);
		setResizable(false);
		
		tabPestañas = new JTabbedPane(JTabbedPane.TOP);
		
		//aqui vamos 
		MenuServicio = new IMenuDeServicios(this);
		
		
		asociarPaisEmbajada = new IAsociarPaisEmbajada(this);
		ingresarSolicitante = new IIngresarSolicitantes(this);
		ingresarVisa = new IIngresarVisas(this);
		solicitarVisaTurismo = new ISolicitarVisaTurismo(this);
		solicitarVisaTrabajo = new ISolicitarVisaTrabajo(this);
		solicitarVisaEstudiante = new ISolicitarVisaEstudiante(this);
		CalcularValorVisa = new ICalcularValorVisa(this);
		mostrarReportesVisa = new IMostrarReportesVisa(this);
		mostrarReporteBeneficiarios = new ImostrarReporteBeneficiarios(this);
		mostrarReporteBeneficiarios = new ImostrarReporteBeneficiarios(this);
		
		tabPestañas.add("Menù De Servicios", MenuServicio);
		tabPestañas.add("Asociar Pais Embajada", asociarPaisEmbajada);
		tabPestañas.add("ingresar Solicitantes", ingresarSolicitante);
		tabPestañas.add("ingresar Visas", ingresarVisa);
		tabPestañas.add("solicitar Visa Turismo", solicitarVisaTurismo);
		tabPestañas.add("solicitar Visa Trabajo", solicitarVisaTrabajo);
		tabPestañas.add("solicitar Visa Estudiante", solicitarVisaEstudiante);
		tabPestañas.add("Calcular Valor Visa", CalcularValorVisa);
		tabPestañas.add("MostrarReportesVisa", mostrarReportesVisa);
		tabPestañas.add("Mostrar Reporte Beneficiarios", mostrarReporteBeneficiarios);
		
		getContentPane().add(tabPestañas, BorderLayout.CENTER);
		
		

	}
	
	
	/**
	 * @param index
	 */
	public void CambiarPestaña(int index)
	{
		tabPestañas.setSelectedIndex(index);
	}

	/**
	 * @param pais
	 */
	public void asociarPaisEmbajada(String pais) {
		// TODO Auto-generated method stub
		controlador.asociarPaisEmbajada(pais);
	}

	/**
	 * 
	 */
	public void ingresarSolicitantes() {
		// TODO Auto-generated method stub
		controlador.ingresarSolicitantes();
	}

	/**
	 * @param map
	 */
	public static void actualizarListaUsuarios(Map<String, Usuario> map) {
		// TODO Auto-generated method stub
		ingresarSolicitante.actualizarUsuario(map);
	}

	/**
	 * 
	 */
	public void ingresarVisas() {
		// TODO Auto-generated method stub
		controlador.ingresarVisas();
		
	}

	/**
	 * @param visas
	 */
	public static void actualizarListaVisas(ArrayList<Visa> visas) {
		// TODO Auto-generated method stub
		ingresarVisa.actualizarVisas(visas);
		
	}

	/**
	 * @param numDiasEstadia
	 */
	public void crearSolicicitudTurismo(int numDiasEstadia) {
		// TODO Auto-generated method stub
		controlador.crearSolicicitudTurismo(numDiasEstadia);

	}

	/**
	 * @param codigo
	 * @param map
	 */
	public static void ActualizarNoSolicitudTurismo(int codigo, Map<String, Usuario> map)
	{
		// TODO Auto-generated method stub
		ISolicitarVisaTurismo.actualizarNoSolicitud(codigo,map );
	}

	/**
	 * @param numPassSeleccionado
	 * @param codigo
	 */
	public void adicionarUsuario(String numPassSeleccionado, int codigo) {
		// TODO Auto-generated method stub
		controlador.adicionarUsuario(numPassSeleccionado, codigo);
	}

	
	/**
	 * @param estado
	 */
	public static void CambiarEstadoTabPestaña(boolean estado) {
		// TODO Auto-generated method stub
		tabPestañas.setEnabled(estado);
	}


	/**
	 * @param empresa
	 * @param cargo
	 */
	public void crearSolicicitudTrabajo(String empresa, String cargo) {
		// TODO Auto-generated method stub
		controlador.crearSolicitudTrabajo(empresa,cargo);
	}


	/**
	 * @param codigo
	 * @param map
	 */
	public static void ActualizarNoSolicitudTrabajo(int codigo, Map<String, Usuario> map) {
		// TODO Auto-generated method stub
		ISolicitarVisaTrabajo.actualizarNoSolicitud(codigo,map );
	}


	/**
	 * @param b
	 */
	public static void actualizarBotonTarifasTurismo(boolean b) {
		// TODO Auto-generated method stub
		ISolicitarVisaTurismo.actualizarBotonTarifas(b);
	}
	
	/**
	 * @param b
	 */
	public static void actualizarBotonTarifasTrabajo(boolean b) {
		// TODO Auto-generated method stub
		ISolicitarVisaTrabajo.actualizarBotonTarifas(b);
	}


	/**
	 * @param institucion
	 */
	public void crearSolicicitudEstudiante(String institucion) {
		// TODO Auto-generated method stub
		controlador.crearSolicitudEstudiante(institucion);
	}

	/**
	 * @param b
	 */
	public static void actualizarBotonTarifasEstudiante(boolean b) {
		// TODO Auto-generated method stub
		ISolicitarVisaEstudiante.actualizarBotonTarifas(b);
	}


	/**
	 * @param codigo
	 * @param map
	 */
	public static void ActualizarNoSolicitudEstudiante(int codigo, Map<String, Usuario> map) {
		// TODO Auto-generated method stub
		ISolicitarVisaEstudiante.actualizarNoSolicitud(codigo,map );
	}


	/**
	 * @param cadena
	 */
	public void calcularValorVisa(String cadena) {
		// TODO Auto-generated method stub
		controlador.calcularValorVisa(cadena);
	}


	/**
	 * @param usuario
	 */
	public static void ActualizarInfoUsuarioCalcularValorVisa(Usuario usuario) {
		// TODO Auto-generated method stub
		ICalcularValorVisa.actualizarInfoUsuario(usuario);
	}

	/**
	 * @param infoUsuarios
	 */
	public static void actualizarUsuariosCalcularValorVisa(ArrayList<String> infoUsuarios) {
		// TODO Auto-generated method stub
		ICalcularValorVisa.actualizarUsuarios(infoUsuarios);
	}


	/**
	 * @param info
	 */
	public static void actualizarDatosFinalesCalcularValorVisa(String info) {
		// TODO Auto-generated method stub
		ICalcularValorVisa.actualizarDatosFinales(info);
	}


	/**
	 * @param fecha
	 * @throws Exception
	 */
	public void generarReporteVisas(String fecha) throws Exception {
		// TODO Auto-generated method stub
		controlador.generarReporteVisas(fecha);
	}


	/**
	 * @param listaSolicitudes
	 */
	public static void ActualizarReporteVisas(ArrayList<String> listaSolicitudes) {
		// TODO Auto-generated method stub
		IMostrarReportesVisa.actualizarReporteVisas(listaSolicitudes);
	}


	/**
	 * @throws Exception
	 */
	public void generarReporteBeneficiarios() throws Exception {
		// TODO Auto-generated method stub
		controlador.generarReporteBeneficiarios();
	}


	/**
	 * @param datos
	 */
	public static void actualizarReporteBeneficiarios(List<String> datos) {
		// TODO Auto-generated method stub
		ImostrarReporteBeneficiarios.actualizarReporte(datos);
	}


	public void cargarDatosSistema() {
		// TODO Auto-generated method stub
		controlador.cargarDatosSistema();
	}


	public void salvarDatosSistema() {
		// TODO Auto-generated method stub
		controlador.salvarDatosSistema();
	}

}