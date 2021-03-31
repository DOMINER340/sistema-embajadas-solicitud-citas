package vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.border.EtchedBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IMenuDeServicios extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField txtMensaje;
	
	/**
	 *Relaciones 
	 */
		InterfazGrafica interfaz;
		
	
	
	/**
	 * Create the panel.
	 */
	public IMenuDeServicios(InterfazGrafica interfaz) {
		this.interfaz = interfaz;
		setBackground(Color.WHITE);
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setLayout(new BorderLayout(0, 0));
		
		txtMensaje = new JTextField();
		txtMensaje.setEditable(false);
		txtMensaje.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		txtMensaje.setForeground(Color.RED);
		txtMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		txtMensaje.setText("Servicios del Sistema");
		add(txtMensaje, BorderLayout.NORTH);
		txtMensaje.setColumns(10);
		
		JPanel panel_Menu = new JPanel();
		panel_Menu.setBackground(Color.WHITE);
		add(panel_Menu, BorderLayout.CENTER);
		panel_Menu.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panelColumnaIzquierda = new JPanel();
		panel_Menu.add(panelColumnaIzquierda);
		panelColumnaIzquierda.setBackground(Color.WHITE);
		GridBagLayout gbl_panelColumnaIzquierda = new GridBagLayout();
		gbl_panelColumnaIzquierda.columnWidths = new int[]{290, 0};
		gbl_panelColumnaIzquierda.rowHeights = new int[] {63, 63, 63, 63, 63, 0};
		gbl_panelColumnaIzquierda.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelColumnaIzquierda.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelColumnaIzquierda.setLayout(gbl_panelColumnaIzquierda);
		
		JButton btnAsociarPaisEmbajada = new JButton("Asociar Pais Embajada");
		GridBagConstraints gbc_btnAsociarPaisEmbajada = new GridBagConstraints();
		gbc_btnAsociarPaisEmbajada.fill = GridBagConstraints.BOTH;
		gbc_btnAsociarPaisEmbajada.insets = new Insets(0, 0, 5, 0);
		gbc_btnAsociarPaisEmbajada.gridx = 0;
		gbc_btnAsociarPaisEmbajada.gridy = 0;
		btnAsociarPaisEmbajada.addActionListener(this);
		btnAsociarPaisEmbajada.setActionCommand(InterfazGrafica.ASOCIAR_EMBAJADA);
		panelColumnaIzquierda.add(btnAsociarPaisEmbajada, gbc_btnAsociarPaisEmbajada);
		
		JButton btnIngresarSolicitantes = new JButton("ingresar Solicitantes");
		GridBagConstraints gbc_btnIngresarSolicitantes = new GridBagConstraints();
		gbc_btnIngresarSolicitantes.fill = GridBagConstraints.BOTH;
		gbc_btnIngresarSolicitantes.insets = new Insets(0, 0, 5, 0);
		gbc_btnIngresarSolicitantes.gridx = 0;
		gbc_btnIngresarSolicitantes.gridy = 1;
		btnIngresarSolicitantes.addActionListener(this);
		btnIngresarSolicitantes.setActionCommand(InterfazGrafica.INGRESAR_SOLICITANTES);
		panelColumnaIzquierda.add(btnIngresarSolicitantes, gbc_btnIngresarSolicitantes);
		
		JButton btnSolicitarVisaTrabajo = new JButton("solicitar Visa Trabajo");
		GridBagConstraints gbc_btnSolicitarVisaTrabajo = new GridBagConstraints();
		gbc_btnSolicitarVisaTrabajo.fill = GridBagConstraints.BOTH;
		gbc_btnSolicitarVisaTrabajo.insets = new Insets(0, 0, 5, 0);
		gbc_btnSolicitarVisaTrabajo.gridx = 0;
		gbc_btnSolicitarVisaTrabajo.gridy = 2;
		btnSolicitarVisaTrabajo.addActionListener(this);
		btnSolicitarVisaTrabajo.setActionCommand(InterfazGrafica.SOLICITAR_VISA_TRABAJO);
		panelColumnaIzquierda.add(btnSolicitarVisaTrabajo, gbc_btnSolicitarVisaTrabajo);
		
		JButton btnSolicitarVisaTurismo = new JButton("solicitar Visa Turismo");
		GridBagConstraints gbc_btnSolicitarVisaTurismo = new GridBagConstraints();
		gbc_btnSolicitarVisaTurismo.insets = new Insets(0, 0, 5, 0);
		gbc_btnSolicitarVisaTurismo.fill = GridBagConstraints.BOTH;
		gbc_btnSolicitarVisaTurismo.gridx = 0;
		gbc_btnSolicitarVisaTurismo.gridy = 3;
		btnSolicitarVisaTurismo.addActionListener(this);
		btnSolicitarVisaTurismo.setActionCommand(InterfazGrafica.SOLICITAR_VISA_TURISMO);
		panelColumnaIzquierda.add(btnSolicitarVisaTurismo, gbc_btnSolicitarVisaTurismo);
		
		JButton btnSolicitarVisaEstudiante = new JButton("solicitar Visa Estudiante");
		btnSolicitarVisaEstudiante.setActionCommand("SOLICITAR_VISA_TURISMO");
		GridBagConstraints gbc_btnSolicitarVisaEstudiante = new GridBagConstraints();
		gbc_btnSolicitarVisaEstudiante.fill = GridBagConstraints.BOTH;
		gbc_btnSolicitarVisaEstudiante.gridx = 0;
		gbc_btnSolicitarVisaEstudiante.gridy = 4;
		btnSolicitarVisaEstudiante.addActionListener(this);
		btnSolicitarVisaEstudiante.setActionCommand(InterfazGrafica.SOLICITAR_VISA_ESTUDIANTE);
		panelColumnaIzquierda.add(btnSolicitarVisaEstudiante, gbc_btnSolicitarVisaEstudiante);
		
		
		
		JPanel panelColumnaCentro = new JPanel();
		panel_Menu.add(panelColumnaCentro);
		panelColumnaCentro.setBackground(Color.WHITE);
		GridBagLayout gbl_panelColumnaCentro = new GridBagLayout();
		gbl_panelColumnaCentro.columnWidths = new int[]{290, 0};
		gbl_panelColumnaCentro.rowHeights = new int[] {126, 63, 63, 63, 63};
		gbl_panelColumnaCentro.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelColumnaCentro.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelColumnaCentro.setLayout(gbl_panelColumnaCentro);
		
		JButton btnSalvarDatosSistema = new JButton("Salvar los datos al sistema");
		GridBagConstraints gbc_btnSalvarDatosSistema = new GridBagConstraints();
		gbc_btnSalvarDatosSistema.fill = GridBagConstraints.BOTH;
		gbc_btnSalvarDatosSistema.insets = new Insets(0, 0, 5, 0);
		gbc_btnSalvarDatosSistema.gridx = 0;
		gbc_btnSalvarDatosSistema.gridy = 2;
		btnSalvarDatosSistema.addActionListener(this);
		btnSalvarDatosSistema.setActionCommand(InterfazGrafica.SALVAR_DATOS_SISTEMA);
		panelColumnaCentro.add(btnSalvarDatosSistema, gbc_btnSalvarDatosSistema);
		
		JButton btnCargarDatosSistema = new JButton("Cargar los datos al sistema");
		GridBagConstraints gbc_btnCargarDatosSIstema = new GridBagConstraints();
		gbc_btnCargarDatosSIstema.fill = GridBagConstraints.BOTH;
		gbc_btnCargarDatosSIstema.gridx = 0;
		gbc_btnCargarDatosSIstema.gridy = 3;
		btnCargarDatosSistema.addActionListener(this);
		btnCargarDatosSistema.setActionCommand(InterfazGrafica.CARGAR_DATOS_SISTEMA);
		panelColumnaCentro.add(btnCargarDatosSistema, gbc_btnCargarDatosSIstema);
		
		JPanel panelColumnaDerecha = new JPanel();
		panel_Menu.add(panelColumnaDerecha);
		panelColumnaDerecha.setBackground(Color.WHITE);
		GridBagLayout gbl_panelColumnaDerecha = new GridBagLayout();
		gbl_panelColumnaDerecha.columnWidths = new int[]{290, 0};
		gbl_panelColumnaDerecha.rowHeights = new int[]{63, 63, 63, 63, 0, 0};
		gbl_panelColumnaDerecha.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelColumnaDerecha.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelColumnaDerecha.setLayout(gbl_panelColumnaDerecha);
		
		JButton btnCalcularValorVisa = new JButton("Calcular Valor Visa");
		GridBagConstraints gbc_btnCalcularValorVisa = new GridBagConstraints();
		gbc_btnCalcularValorVisa.fill = GridBagConstraints.BOTH;
		gbc_btnCalcularValorVisa.insets = new Insets(0, 0, 5, 0);
		gbc_btnCalcularValorVisa.gridx = 0;
		gbc_btnCalcularValorVisa.gridy = 1;
		btnCalcularValorVisa.addActionListener(this);
		btnCalcularValorVisa.setActionCommand(InterfazGrafica.CALCULAR_VALOR_VISA);
		panelColumnaDerecha.add(btnCalcularValorVisa, gbc_btnCalcularValorVisa);
		
		JButton btnMostrarReportesVisa = new JButton("MostrarReportesVisa");
		GridBagConstraints gbc_btnMostrarReportesVisa = new GridBagConstraints();
		gbc_btnMostrarReportesVisa.fill = GridBagConstraints.BOTH;
		gbc_btnMostrarReportesVisa.insets = new Insets(0, 0, 5, 0);
		gbc_btnMostrarReportesVisa.gridx = 0;
		gbc_btnMostrarReportesVisa.gridy = 2;
		btnMostrarReportesVisa.addActionListener(this);
		btnMostrarReportesVisa.setActionCommand(InterfazGrafica.MOSTRAR_REPORTE_VISA);
		panelColumnaDerecha.add(btnMostrarReportesVisa, gbc_btnMostrarReportesVisa);
		
		JButton btnMostrarReportesBeneficiarios = new JButton("Mostrar Reporte Beneficiarios");
		GridBagConstraints gbc_btnMostrarReportesBeneficiarios = new GridBagConstraints();
		gbc_btnMostrarReportesBeneficiarios.fill = GridBagConstraints.BOTH;
		gbc_btnMostrarReportesBeneficiarios.insets = new Insets(0, 0, 5, 0);
		gbc_btnMostrarReportesBeneficiarios.gridx = 0;
		gbc_btnMostrarReportesBeneficiarios.gridy = 3;
		btnMostrarReportesBeneficiarios.addActionListener(this);
		btnMostrarReportesBeneficiarios.setActionCommand(InterfazGrafica.MOSTRAR_REPORTE_BENEFICIARIO);
		panelColumnaDerecha.add(btnMostrarReportesBeneficiarios, gbc_btnMostrarReportesBeneficiarios);
		
		JButton btnIngresarVisas = new JButton("Ingresar Visas");
		btnIngresarVisas.setActionCommand("CALCULAR_VALOR_VISA");
		GridBagConstraints gbc_btnIngresarVisas = new GridBagConstraints();
		gbc_btnIngresarVisas.insets = new Insets(0, 0, 5, 0);
		gbc_btnIngresarVisas.fill = GridBagConstraints.BOTH;
		gbc_btnIngresarVisas.gridx = 0;
		gbc_btnIngresarVisas.gridy = 0;
		btnIngresarVisas.addActionListener(this);
		btnIngresarVisas.setActionCommand(InterfazGrafica.INGRESAR_VISAS);
		panelColumnaDerecha.add(btnIngresarVisas, gbc_btnIngresarVisas);
		

	}


	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String accion = e.getActionCommand();
		if(accion.equals(InterfazGrafica.ASOCIAR_EMBAJADA))
		{
			interfaz.CambiarPestaña(1);
		}
		if(accion.equals(InterfazGrafica.INGRESAR_SOLICITANTES))
		{
			interfaz.CambiarPestaña(2);
		}
		if(accion.equals(InterfazGrafica.INGRESAR_VISAS))
		{
			interfaz.CambiarPestaña(3);
		}
		if(accion.equals(InterfazGrafica.SOLICITAR_VISA_TURISMO))
		{
			interfaz.CambiarPestaña(4);
		}
		if(accion.equals(InterfazGrafica.SOLICITAR_VISA_TRABAJO))
		{
			interfaz.CambiarPestaña(5);
		}
		if(accion.equals(InterfazGrafica.SOLICITAR_VISA_ESTUDIANTE))
		{
			interfaz.CambiarPestaña(6);
		}
		if(accion.equals(InterfazGrafica.CALCULAR_VALOR_VISA))
		{
			interfaz.CambiarPestaña(7);
		}
		if(accion.equals(InterfazGrafica.MOSTRAR_REPORTE_VISA))
		{
			interfaz.CambiarPestaña(8);
		}
		if(accion.equals(InterfazGrafica.MOSTRAR_REPORTE_BENEFICIARIO))
		{
			interfaz.CambiarPestaña(9);
		}
		if(accion.equals(InterfazGrafica.CARGAR_DATOS_SISTEMA))
		{
			interfaz.cargarDatosSistema();
		}	
		if(accion.equals(InterfazGrafica.SALVAR_DATOS_SISTEMA))
		{
			interfaz.salvarDatosSistema();
		}	
	}
}