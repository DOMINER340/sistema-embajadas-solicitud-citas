package controlador;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Estudiante;
import modelo.SistemaCitasEmbajada;
import modelo.Solicitud;
import modelo.Trabajo;
import modelo.Turismo;
import modelo.Usuario;
import modelo.Visa;
import persistencia.ManejoArchivos;
import utilidades.Utilidades;
import vista.InterfazGrafica;
public class Controlador {

	/**
	 * Modelo
	 */
	public SistemaCitasEmbajada modelo;

	/**
	 * Vista
	 */
	public InterfazGrafica vista;

	/**
	 * Manejador de Archivos
	 */
	private ManejoArchivos manejadorArchivos;	

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		new Controlador();
	}

	/**
	 * 
	 */
	public Controlador() 
	{	
		modelo = new SistemaCitasEmbajada(null, null, null, 0, 0);
		manejadorArchivos = new ManejoArchivos();
		InterfazGrafica vista = new InterfazGrafica (this);
		vista.setVisible(true);
	}

	/**
	 * @param pais
	 */
	public void asociarPaisEmbajada(String pais) {
		// TODO Auto-generated method stub
		try {
			modelo = manejadorArchivos.asociarEmbajada(modelo, pais);
			if(modelo.getPaisEmbajada() == null)
			{
				JOptionPane.showMessageDialog(null, "no se pudo asociar el pais a la embajada");
			}
			if(modelo.getPaisEmbajada() != null)
			{
				JOptionPane.showMessageDialog(null, "El pais " + modelo.getPaisEmbajada() + " fue asociado a la embajada exitosamente.");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 
	 */
	public void ingresarSolicitantes() {
		try {
			if(modelo.getPaisEmbajada() == null)
			{
				Exception e = new Exception("debe asociar una embajada antes de ingresar solicitantes.");
				throw e;
			}
			if(modelo.getPaisEmbajada() != null)
			{
				manejadorArchivos.ingresarSolicitantes(modelo);
				//Utilidades.imprimirUsuarios(modelo.getMap());

				InterfazGrafica.actualizarListaUsuarios(modelo.getMap());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	public void ingresarVisas() {
		// TODO Auto-generated method stub
		try 
		{
			if(modelo.getPaisEmbajada() == null)
			{
				JOptionPane.showMessageDialog(null, "debe asociar una embajada antes de ingresar visas.");
			}
			if(modelo.getPaisEmbajada() != null)
			{
				manejadorArchivos.ingresarVisas(modelo);
				JOptionPane.showConfirmDialog(null, "la cantidad de "  + modelo.getVisas().size() + " estan asociadas a la embajada actualmente.", "Advertencia", JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
				vista.actualizarListaVisas(modelo.getVisas());
			}

		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * @param numDiasEstadia
	 */
	public void crearSolicicitudTurismo(int numDiasEstadia) {
		// TODO Auto-generated method stub
		try 
		{
			String tipo ="turismo";
			int codigo=-1;
			String[] datos = new String[3]; 
			if( (modelo.getVisas().size() != 0)  &&  (modelo.getMap().size() != 0) && numDiasEstadia !=0)
			{
				datos = manejadorArchivos.consultarTarifas(tipo); 
				Visa visa = modelo.buscarVisa(tipo);
				if(visa == null )
				{
					Exception e = new Exception("Tipo de visa " + tipo + " no encuentra registrada");
					throw e;	
				}
				visa = gestionarVisa(visa,datos,tipo,numDiasEstadia,null,null,null,null);
				double valorOriginal = Double.valueOf(datos[2].trim());
				codigo = modelo.crearSolicitud(visa, valorOriginal);				
			}
			if(codigo == (-1))
			{
				JOptionPane.showConfirmDialog(null, "la Solicitud no pudo ser creada", "Advertencia", JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
			}
			if(codigo != (-1))
			{
				vista.actualizarBotonTarifasTurismo(false);
				vista.ActualizarNoSolicitudTurismo(codigo,modelo.getMap());
				InterfazGrafica.CambiarEstadoTabPestaña(false);
				JOptionPane.showConfirmDialog(null, "la Solicitud fue creada", "Advertencia", JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
			}	
			Utilidades.visaImprimir(modelo.getVisas());
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Advertencia", JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}
	}

	/**
	 * Actualiza las visas, enlaza las solicitudes, y recibe los datos específicos de las instancias de los usuarios
	 * @param visa
	 * @param datos
	 * @param tipo
	 * @return
	 */
	public Visa gestionarVisa(Visa visa, String[] datos,String tipo, int diasEstadiaN, String cargoN, String empresaN, String escolaridadN , String instuticionN)
	{
		if(visa.getId() != null)
		{
			if(tipo.equalsIgnoreCase("turismo"))
			{
				Turismo nuevaVisa = new Turismo(visa.getTipo(),visa.getRequisitos());	
				nuevaVisa.setValor(Double.valueOf(datos[2].trim()));
				nuevaVisa.setId(datos[0].trim());
				int diasEstadia = diasEstadiaN;
				nuevaVisa.setValor(Double.valueOf(datos[2].trim()));
				nuevaVisa.setId(datos[0].trim());
				Turismo visaTurismo = (Turismo) nuevaVisa;
				visaTurismo.setDiasEstadia(diasEstadia);
				modelo.agregarVisa(nuevaVisa);
				return visaTurismo;
			}
			if(tipo.equalsIgnoreCase("trabajo"))
			{
				Trabajo nuevaVisa = new Trabajo(visa.getTipo(),visa.getRequisitos());
				nuevaVisa.setValor(Double.valueOf(datos[2].trim()));
				nuevaVisa.setId(datos[0].trim());
				String cargo  = cargoN;
				String empresa  = empresaN;
				Trabajo visaTrabajo = (Trabajo) nuevaVisa;
				visaTrabajo.setCargo(cargo);
				visaTrabajo.setEmpresa(empresa);
				modelo.agregarVisa(nuevaVisa);
				return visaTrabajo;
			}
			if(tipo.equalsIgnoreCase("estudiante"))
			{
				Estudiante nuevaVisa = new Estudiante(visa.getTipo(),visa.getRequisitos());
				nuevaVisa.setValor(Double.valueOf(datos[2].trim()));
				nuevaVisa.setId(datos[0].trim());
				String escolaridad  = escolaridadN;
				String institucion  = instuticionN;
				Estudiante visaEstudiante = (Estudiante) nuevaVisa;
				visaEstudiante.setEscolaridad(escolaridad);
				visaEstudiante.setInstitucio(institucion);
				modelo.agregarVisa(nuevaVisa);
				return visaEstudiante;
			}	
		}
		if(visa.getId() == null)
		{
			visa.setValor(Double.valueOf(datos[2].trim()));
			visa.setId(datos[0].trim());
			if(tipo.equalsIgnoreCase("turismo"))
			{
				int diasEstadia = diasEstadiaN;
				visa.setValor(Double.valueOf(datos[2].trim()));
				visa.setId(datos[0].trim());
				Turismo visaTurismo = (Turismo) visa;
				visaTurismo.setDiasEstadia(diasEstadia);
				return visaTurismo;

			}
			if(tipo.equalsIgnoreCase("trabajo"))
			{
				String cargo  = cargoN;
				String empresa  = empresaN;
				Trabajo visaTrabajo = (Trabajo) visa;
				visaTrabajo.setCargo(cargo);
				visaTrabajo.setEmpresa(empresa);
				return visaTrabajo;
			}
			if(tipo.equalsIgnoreCase("estudiante"))
			{
				String escolaridad  = escolaridadN;
				String institucion  = instuticionN;
				Estudiante visaEstudiante = (Estudiante) visa;
				visaEstudiante.setEscolaridad(escolaridad);
				visaEstudiante.setInstitucio(institucion);
				return visaEstudiante;
			}	
		}
		return null;
	}

	/**
	 * @param numPassSeleccionado
	 * @param codigo
	 */
	public void adicionarUsuario(String numPassSeleccionado, int codigo) {
		// TODO Auto-generated method stub
		try
		{
			modelo.AñadirUsuarioSolicitud(numPassSeleccionado,codigo);
			Solicitud solicitud = modelo.buscarSolicitud(codigo);
			Usuario usuario = modelo.buscarUsuario(numPassSeleccionado);
			if(solicitud.getUsuarios().get( (solicitud.getUsuarios().size()-1) ).getNumPasaporte().equalsIgnoreCase(usuario.getNumPasaporte()))
			{				
				JOptionPane.showConfirmDialog(null, "El usuario " + usuario.getNumPasaporte() + " fue añadido a la solicitud " + codigo + " con exito.", "Advertencia", JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
				vista.CambiarEstadoTabPestaña(true);
				if(solicitud.getVisa().getTipo().equalsIgnoreCase("turismo"))
				{
					vista.actualizarBotonTarifasTurismo(true);
				}
				if(solicitud.getVisa().getTipo().equalsIgnoreCase("trabajo"))
				{
					vista.actualizarBotonTarifasTrabajo(true);
				}
				if(solicitud.getVisa().getTipo().equalsIgnoreCase("estudiante"))
				{
					InterfazGrafica.actualizarBotonTarifasEstudiante(true);
				}
			};
		}
		catch (Exception e) 
		{
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Advertencia", JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
			// TODO: handle exception

		}
	}

	/**
	 * @param empresa
	 * @param cargo
	 */
	public void crearSolicitudTrabajo(String empresa, String cargo) {
		// TODO Auto-generated method stub
		try
		{
			int codigo=-1;
			String[] datos = new String[3];
			String tipo = "trabajo";
			System.out.println("cargo: "+cargo+" empresa: "+empresa);
			if( (modelo.getVisas().size() != 0)  &&  (modelo.getMap().size() != 0) && !(cargo.equalsIgnoreCase("")) && !(empresa.equalsIgnoreCase("")) )
			{
				datos = manejadorArchivos.consultarTarifas(tipo); 
				Visa visa = modelo.buscarVisa(tipo);
				if(visa == null )
				{
					Exception e = new Exception("Tipo de visa " + tipo + " no encuentra registrada");
					throw e;	
				}
				visa = gestionarVisa(visa,datos,tipo,0,cargo,empresa,null,null);		
				double valorOriginal = Double.valueOf(datos[2].trim());
				codigo = modelo.crearSolicitud(visa,valorOriginal);
			}
			if(codigo == (-1))
			{
				JOptionPane.showConfirmDialog(null, "la Solicitud no pudo ser creada", "Advertencia", JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
			}
			if(codigo != (-1))
			{
				vista.actualizarBotonTarifasTrabajo(false);
				vista.ActualizarNoSolicitudTrabajo(codigo,modelo.getMap());
				InterfazGrafica.CambiarEstadoTabPestaña(false);
				JOptionPane.showConfirmDialog(null, "la Solicitud fue creada", "Advertencia", JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
			}	
			Utilidades.visaImprimir(modelo.getVisas());
		}
		catch(Exception e) 
		{
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Advertencia", JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	/**
	 * @param institucion
	 */
	public void crearSolicitudEstudiante(String institucion) {
		// TODO Auto-generated method stub
		try
		{
			int codigo=-1;
			String[] datos = new String[3];
			String tipo = "estudiante";
			if( (modelo.getVisas().size() != 0)  &&  (modelo.getMap().size() != 0) && !(institucion.equalsIgnoreCase("")) )
			{
				datos = manejadorArchivos.consultarTarifas(tipo); 
				Visa visa = modelo.buscarVisa(tipo);
				if(visa == null )
				{
					Exception e = new Exception("Tipo de visa " + tipo + " no encuentra registrada");
					throw e;	
				}
				visa = gestionarVisa(visa,datos,tipo,0,null,null,null,institucion);		
				double valorOriginal = Double.valueOf(datos[2].trim());
				codigo = modelo.crearSolicitud(visa,valorOriginal);
			}
			if(codigo == (-1))
			{
				JOptionPane.showConfirmDialog(null, "la Solicitud no pudo ser creada", "Advertencia", JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
			}
			if(codigo != (-1))
			{
				vista.actualizarBotonTarifasEstudiante(false);
				vista.ActualizarNoSolicitudEstudiante(codigo,modelo.getMap());
				InterfazGrafica.CambiarEstadoTabPestaña(false);
				JOptionPane.showConfirmDialog(null, "la Solicitud fue creada", "Advertencia", JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
			}	
			Utilidades.visaImprimir(modelo.getVisas());
		}
		catch(Exception e) 
		{
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Advertencia", JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
			// TODO: handle exception
		}
	}



	/**
	 * @param cadena
	 */
	public void calcularValorVisa(String cadena) {
		// TODO Auto-generated method stub
		try
		{
			String identificador = null;
			String enunciado = null;
			enunciado = cadena;
			identificador = enunciado.substring(0,2);
			enunciado = enunciado.substring(2);
			System.out.println("identificador: "+ identificador);
			System.out.println("enunciado: "+ enunciado);
			if(enunciado.equalsIgnoreCase("-1"))
			{
				Exception e = new Exception("Ingrese un dato antes de realizar la operacion.");
				throw e;
			}
			if(identificador.equalsIgnoreCase("np"))
			{
				Usuario usuario = modelo.buscarUsuario(enunciado);
				if(usuario == null)
				{
					Exception e = new Exception("numero de pasaporte no registrado.");
					throw e;
				}
				if(usuario.getSolicitud() == null)
				{
					Exception e = new Exception("el usuario no tiene solicitudes registradas.");
					throw e;
				}
				InterfazGrafica.ActualizarInfoUsuarioCalcularValorVisa(usuario);

				Solicitud solicitud = usuario.getSolicitud();
				mostarInfo(solicitud,solicitud.getValorVisaOriginal());

			}
			if (identificador.equalsIgnoreCase("cp"))
			{
				int codigo = Integer.parseInt(enunciado);
				Solicitud solicitud = modelo.buscarSolicitud(codigo);
				if(solicitud == null)
				{
					Exception e = new Exception("Solicitud no registrada.");
					throw e;
				}
				
				mostarInfo(solicitud,solicitud.getValorVisaOriginal());

			}	

		}
		catch (Exception e) 
		{
			// TODO: handle exception
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Advertencia", JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}
	}	

	/**
	 * @param solicitud
	 * @param valor
	 */
	public void mostarInfo(Solicitud solicitud,double valor)
	{
		double valorTotal = solicitud.getVisa().getValor(); 
		ArrayList<String> InfoUsuarios = new ArrayList<>();

		for (int i=0; i<solicitud.getUsuarios().size(); i++)
		{
			String asociado = solicitud.getUsuarios().get(i).infoAsociado(modelo.getImpuesto(),solicitud.getVisa(),valor);
			InfoUsuarios.add(asociado);
		}
		vista.actualizarUsuariosCalcularValorVisa(InfoUsuarios);

		solicitud.getVisa().setValor(valorTotal);
		valorTotal = modelo.darValorAcumuladoVisa(solicitud,valor);
		String moneda = modelo.getMoneda();
		String info = "";
		info = info.concat( String.valueOf(valorTotal));
		info = info.concat("@" + modelo.getCambioOficial());
		info = info.concat("@" +moneda);
		info = info.concat("@"+ String.valueOf(Utilidades.conversiones(valorTotal, modelo.getCambioOficial())));
		solicitud.getVisa().setValor(valorTotal);
		vista.actualizarDatosFinalesCalcularValorVisa(info);
	}

	/**
	 * @param fecha
	 * @throws Exception
	 */
	public void generarReporteVisas(String fecha) throws Exception {
		// TODO Auto-generated method stub

		ArrayList<String> listaSolicitudes = modelo.darSolicitudesString(fecha);
		String pais = modelo.getPaisEmbajada();
		manejadorArchivos.generarReporte(listaSolicitudes,fecha, pais);

		vista.ActualizarReporteVisas(listaSolicitudes);

	}

	/**
	 * 
	 */
	public void generarReporteBeneficiarios() 
	{
		try 
		{
			// 	TODO Auto-generated method stub
			List <String> datos= new ArrayList<String>();
			datos = modelo.consultarBeneficiarios();
			manejadorArchivos.generarBeneficiarios(datos);
			vista.actualizarReporteBeneficiarios(datos);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Advertencia", JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	public void cargarDatosSistema() {
		// TODO Auto-generated method stub
		this.modelo = manejadorArchivos.cargarRespaldo();
	}

	/**
	 * 
	 */
	public void salvarDatosSistema() {
		// TODO Auto-generated method stub
		manejadorArchivos.crearRespaldo(modelo);
	}
}