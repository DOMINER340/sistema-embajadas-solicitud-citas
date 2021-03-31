package persistencia;

import java.io.BufferedReader;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import modelo.Escolaridad;
import modelo.Requisito;
import modelo.SistemaCitasEmbajada;


public class ManejoArchivos {
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
	
	/**
	 * Constructor de la clase
	 */
	public ManejoArchivos() {

	}

	// ----------------------------
	//  Métodos
	// ----------------------------
	
	
	
	public void crearRespaldo( SistemaCitasEmbajada modelo)
	{
		javax.swing.JFileChooser jF1= new javax.swing.JFileChooser("."); 
		String ruta = ""; 		 
		try
		{
			if(jF1.showSaveDialog(null)==JFileChooser.APPROVE_OPTION){ 
				ruta = jF1.getSelectedFile().getAbsolutePath();  
			}
			FileOutputStream fs = new FileOutputStream(ruta);
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(modelo);
			os.close();
			System.out.println("gg");
		}
		catch(FileNotFoundException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
		catch(IOException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}

		catch (Exception ex){ 
			ex.printStackTrace(); 
		} 
	}
	
	
	public SistemaCitasEmbajada cargarRespaldo()
	{
		JFileChooser file=new JFileChooser(".");
		file.showOpenDialog(null);
		File abre=file.getSelectedFile();
		if(abre!=null)
		{  
			try{
				FileInputStream fis = new FileInputStream(abre);
				ObjectInputStream ois = new ObjectInputStream(fis);
				SistemaCitasEmbajada modelo  = (SistemaCitasEmbajada) ois.readObject();//El método readObject() recupera el objeto
				
				ois.close(); 
				fis.close();
				return modelo;
			}
			catch(FileNotFoundException e)
			{
				e.printStackTrace();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			catch(ClassNotFoundException e)
			{
				e.printStackTrace();
			}	
		}
		return null;
		
	}

	public SistemaCitasEmbajada asociarEmbajada(SistemaCitasEmbajada embajada, String pais) 
	{  
		try
		{
			JFileChooser file=new JFileChooser(".");
			file.showOpenDialog(null);
			File abre=file.getSelectedFile();
			if(abre!=null)
			{  
				String []datos = new String[5];
				FileReader archivos=new FileReader(abre);
				BufferedReader br=new BufferedReader(archivos);	
				String linea = br.readLine();
				while(linea != null){
					while (!(linea.startsWith("#"))){		
						datos = linea.split("\\*");			
						String id =  datos [0].trim();
						String paisEmbajada = datos [1].trim();
						String moneda = datos[2].trim();

						String impuestoS = datos[3].trim();
						impuestoS = impuestoS.substring(0, impuestoS.length() - 1);
						float impuesto = Integer.parseInt(impuestoS);

						String tasaCambioS = datos[4].trim();
						double tasaCambio = Double.parseDouble(tasaCambioS);

						if(paisEmbajada.equalsIgnoreCase(pais)){
							embajada = new SistemaCitasEmbajada(id, paisEmbajada, moneda, tasaCambio, impuesto);
						}
						linea = br.readLine();
					}
					linea = br.readLine();
				}
				br.close();
				return embajada;


			}    
		}
		catch(IOException ex)
		{
			JOptionPane.showMessageDialog(null,ex+"" +
					"\nNo se ha encontrado el archivo",
					"ADVERTENCIA!!!",JOptionPane.WARNING_MESSAGE);
		}
		return embajada;
	}
	
	public void ingresarSolicitantes(SistemaCitasEmbajada modelo) {
		try
		{
			JFileChooser file=new JFileChooser(".");
			file.showOpenDialog(null);
			File abre=file.getSelectedFile();
			if(abre!=null)
			{    
				String[] datos = new String[7];
				FileReader archivos=new FileReader(abre);
				BufferedReader br=new BufferedReader(archivos);
				String linea = br.readLine();
				while (linea != null) {
					while (!(linea.startsWith("#"))) 
					{	
						datos = linea.split("\\*");
						String numPasaporte = datos[0].trim();
						String nombre = datos[1].trim();
						String paisNacimiento = datos[2].trim();
						String ciudadNacimiento = datos[3].trim();
						LocalDate fechaNacimiento = LocalDate.parse(datos[4].trim());
						String email = datos[5].trim();
						int edadAnnos = utilidades.Utilidades.edadEnAnnos(fechaNacimiento, LocalDate.now() );
						
						if(modelo.buscarUsuario(numPasaporte) == null)
						{
							if(edadAnnos >= 0 && edadAnnos < 2  )
							{
								
								//niño 0-1
								String informacionAdicional = datos[6].trim();
								modelo.agregarNiño02(nombre, numPasaporte, email, fechaNacimiento, paisNacimiento, ciudadNacimiento,informacionAdicional);
							}
							if(edadAnnos >= 2 && edadAnnos < 13  )
							{
								//niño 2-12
								String informacionAdicional = datos[6].trim();
								boolean bandera = false;
								for ( Escolaridad escolaridad : Escolaridad.values())
								{
									if(escolaridad.toString().equalsIgnoreCase(informacionAdicional))
									{
										modelo.agregarNiño212(nombre, numPasaporte, email, fechaNacimiento, paisNacimiento, ciudadNacimiento,informacionAdicional);
										bandera = true;
									}
									
								}	
								if(bandera == false)
								{
									JOptionPane.showConfirmDialog(null, "Escolaridad del usuario " + numPasaporte + " no contemplada en el sistema, el usuario no pudo ser agredado", "Advertencia", JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
								}
							}
							if(edadAnnos >=13 && edadAnnos <= 65  )
							{
								//adulto 13-65
								
								modelo.agregarAdulto(nombre, numPasaporte, email, fechaNacimiento, paisNacimiento, ciudadNacimiento);
								
							}
							if(edadAnnos >65 )
							{
								modelo.agregarAdultoMayor(nombre, numPasaporte, email, fechaNacimiento, paisNacimiento, ciudadNacimiento);
								//adulto >=65
							}
							if(edadAnnos < 0 )
							{
								//fecha incorrecta
								//excepcion 
							}
						}
						else
						{
							JOptionPane.showConfirmDialog(null, "El pasaporte numero: " + numPasaporte + " ya se ecuentra registrado. Usuario "+ nombre + " no pudo ser agregado", "Advertencia", JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
						}
						linea = br.readLine();
					}
					linea = br.readLine();
				}
				//Utilidades.imprimirUsuarios(modelo.getMap());
				br.close();
			}    
		}
		catch(IOException ex)
		{
			JOptionPane.showMessageDialog(null,ex+"" +
					"\nNo se ha encontrado el archivo",
					"ADVERTENCIA!!!",JOptionPane.WARNING_MESSAGE);
		}
		
	}
	

	public void ingresarVisas(SistemaCitasEmbajada modelo) {
		try
		{			
			JFileChooser file=new JFileChooser(".");
			file.showOpenDialog(null);
			File abre=file.getSelectedFile();

			if(abre!=null)
			{    
				String[] datos = new String[1];
				FileReader archivos=new FileReader(abre);
				BufferedReader br=new BufferedReader(archivos);
				String linea = br.readLine();
				while (linea != null) 
				{
					while (!(linea.startsWith("#")))
					{
						datos = linea.split("\\*");
						String tipo = datos[0].trim();	
						ArrayList<Requisito> requisitos = new ArrayList<Requisito>();
						linea = br.readLine();
						linea = br.readLine();
						while (!(linea.startsWith("#")))
						{	
							String descripcion = linea.trim();
							Requisito requisito = new Requisito(descripcion);
							requisitos.add(requisito);
							linea = br.readLine();
						}
						boolean bandera = false;
						if( tipo.equalsIgnoreCase("turismo") && modelo.buscarVisa("turismo")==null)
						{
							modelo.agregarVisaTurismo(tipo, requisitos);
							bandera = true;
						}
						if(tipo.equalsIgnoreCase("trabajo") && modelo.buscarVisa("trabajo")==null)
						{
							modelo.agregarVisaTrabajo(tipo, requisitos);
							bandera = true;
						}
						if(tipo.equalsIgnoreCase("estudiante") && modelo.buscarVisa("estudiante")==null)
						{
							modelo.agregarVisaEstudiante(tipo, requisitos);
							bandera = true;
						}
						if (bandera == false)
						{
							// excepcion visa no valida
							JOptionPane.showConfirmDialog(null, "El tipo de visa" +  tipo +" no se puede registrar en el sistema", "Advertencia", JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
						}
						if(linea.equalsIgnoreCase("#FIN")) continue;
						linea = br.readLine();
					}
					linea = br.readLine();
				}
				//Utilidades.imprimirUsuarios(modelo.getMap());
				br.close();
			}    
		}
		catch(IOException ex)
		{
			JOptionPane.showMessageDialog(null,ex+"" +
					"\nNo se ha encontrado el archivo",
					"ADVERTENCIA!!!",JOptionPane.WARNING_MESSAGE);
		}
		
	}
	
	
	/**
	 * Se consultan las tarifas de las visas
	 * @param tipo
	 * @return
	 * @throws Exception 
	 */
	public String[] consultarTarifas(String tipo) throws Exception
	{
		String []datos = new String[3];
		BufferedReader br = new BufferedReader(new FileReader("tarifas.txt"));
		String linea = br.readLine();
		while(linea != null){
			while (!(linea.startsWith("#"))){
				
				datos = linea.split("\\*");			
				String tipoTemp = datos[1].trim();
				
				if(tipoTemp.equalsIgnoreCase(tipo))
				{
					br.close();
					
					return datos;
				}
				
				linea = br.readLine();
			}
			linea = br.readLine();
		}
		
		br.close();
		
		Exception e = new Exception("Tipo de visa " + tipo + " no encontrado en el archivo de tarifas.");
        throw e;
	}
	
	/**
	 * Se genra el reporte
	 * @param filas
	 * @param fecha
	 * @param pais
	 * @throws Exception
	 */
	public  void generarReporte(List<String> filas, String fecha, String pais) throws Exception
	{
		String ruta = "";
		ruta = ruta.concat("Cita-"+fecha+".txt");
		PrintWriter pw = new PrintWriter(ruta);
		pw.println("--REPORTE DE SOLICITUDES EMBAJADA DE " + pais);
		pw.println("Fecha: " + fecha );
		pw.println();
		pw.println("#numPass—-----nombre-----------tipoVisa----numSolicitud");
		// Imprimir el arraylist
		for (int i = 0; i < filas.size(); i++) 
		{
			String resultadoActual = filas.get(i);
			pw.println(resultadoActual);
		}
		pw.close();
	}
	
	/**
	 * Se genera el archivo de texto con los datos de los beneficiarios
	 * @param lineas
	 * @throws IOException
	 */
	public void generarBeneficiarios(List <String> lineas) throws IOException{
		String ruta = "";
		ruta = ruta.concat("Beneficiarios.txt");
		PrintWriter pw = new PrintWriter(ruta);
		pw.println("--REPORTE DE BENEFICIARIOS ");
		pw.println();
		pw.println("#numPass—-----nombre-----------valorVisa");
		// Imprimir el arraylist
		for(int i=0 ; i<(lineas.size())-(1) ; i++)
		{
			pw.println(lineas.get(i));
		}
		pw.println("El valor total en pesos que se dejó de recaudar por visas de beneficiados");
		pw.println("es: " + lineas.get(  (lineas.size()-(1)  ) ) );
		pw.close();
	}
}
