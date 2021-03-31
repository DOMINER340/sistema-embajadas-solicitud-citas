package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import modelo.Usuario;
import utilidades.Utilidades;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class ICalcularValorVisa extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * atributos
	 */
	private JTextField textMensaje;
	private JButton btnCalcularValorVisa;
	private static JTable tableUsuarios;
	private static JTable tableUsuarios2;
	private static JPanel panel;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	private static JScrollPane scrollPane;
	private static JScrollPane scrollPane2;
	private static JLabel lblInfoValorModenaLocal;
	private static JLabel lblInfoMonedaLocal;
	private static JLabel lblInfoTasaCambio;
	private static JLabel lblInfoPSC;

	/**
	 * relaciones
	 */
	InterfazGrafica interfaz;
	private JTextField textNumero;

	/**
	 * Create the panel.
	 */
	public ICalcularValorVisa(InterfazGrafica interfaz) {
		this.interfaz = interfaz;
		setLayout(new BorderLayout(0, 0));

		textMensaje = new JTextField();
		textMensaje.setEditable(false);
		textMensaje.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		textMensaje.setForeground(Color.RED);
		textMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		textMensaje.setText("Calcular Valor de Visa");
		add(textMensaje, BorderLayout.NORTH);
		textMensaje.setColumns(10);

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblBusqueda = new JLabel("Busqueda por");
		lblBusqueda.setHorizontalAlignment(SwingConstants.CENTER);
		lblBusqueda.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblBusqueda.setBounds(270, 20, 120, 30);
		panel.add(lblBusqueda);

		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumero.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblNumero.setBounds(370, 60, 80, 30);
		panel.add(lblNumero);

		btnCalcularValorVisa = new JButton("Calcular Valor Visa");
		btnCalcularValorVisa.setBackground(new Color(128, 0, 0));
		btnCalcularValorVisa.setForeground(Color.WHITE);
		btnCalcularValorVisa.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		btnCalcularValorVisa.setBounds(340, 100, 220, 30);
		btnCalcularValorVisa.addActionListener(this);
		btnCalcularValorVisa.setActionCommand(InterfazGrafica.CALCULAR_VALOR_VISA);
		panel.add(btnCalcularValorVisa);

		comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"NP - Numero de pasaporte", "CP - Codigo solicitud"}));
		comboBox.setBounds(390, 20, 240, 30);
		panel.add(comboBox);

		JLabel lblPSC = new JLabel("PSC");
		lblPSC.setHorizontalAlignment(SwingConstants.LEFT);
		lblPSC.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblPSC.setBounds(310, 400, 40, 30);
		panel.add(lblPSC);

		JLabel lblTasaCambio = new JLabel("Tasa de Cambio");
		lblTasaCambio.setHorizontalAlignment(SwingConstants.CENTER);
		lblTasaCambio.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblTasaCambio.setBounds(220, 440, 160, 30);
		panel.add(lblTasaCambio);

		JLabel lblMonedaLocal = new JLabel("Moneda Local");
		lblMonedaLocal.setHorizontalAlignment(SwingConstants.LEFT);
		lblMonedaLocal.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblMonedaLocal.setBounds(450, 400, 120, 30);
		panel.add(lblMonedaLocal);

		JLabel lblValorMonedaLocal = new JLabel("Valor Moneda Local");
		lblValorMonedaLocal.setHorizontalAlignment(SwingConstants.LEFT);
		lblValorMonedaLocal.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblValorMonedaLocal.setBounds(450, 440, 160, 30);
		panel.add(lblValorMonedaLocal);

		textNumero = new JTextField();
		textNumero.setHorizontalAlignment(SwingConstants.CENTER);
		textNumero.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		textNumero.setBounds(450, 60, 80, 30);
		panel.add(textNumero);
		textNumero.setColumns(10);

		lblInfoPSC = new JLabel("");
		lblInfoPSC.setBackground(new Color(192, 192, 192));
		lblInfoPSC.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoPSC.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblInfoPSC.setBounds(350, 400, 80, 30);
		panel.add(lblInfoPSC);

		lblInfoTasaCambio = new JLabel("");
		lblInfoTasaCambio.setBackground(Color.RED);
		lblInfoTasaCambio.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoTasaCambio.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblInfoTasaCambio.setBounds(370, 440, 80, 30);
		panel.add(lblInfoTasaCambio);

		lblInfoMonedaLocal = new JLabel("");
		lblInfoMonedaLocal.setBackground(new Color(192, 192, 192));
		lblInfoMonedaLocal.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoMonedaLocal.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblInfoMonedaLocal.setBounds(570, 400, 80, 30);
		panel.add(lblInfoMonedaLocal);

		lblInfoValorModenaLocal = new JLabel("");
		lblInfoValorModenaLocal.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoValorModenaLocal.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblInfoValorModenaLocal.setBounds(610, 440, 80, 30);
		panel.add(lblInfoValorModenaLocal);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 140, 890, 60);

		tableUsuarios = new JTable();
		tableUsuarios.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		tableUsuarios.setBackground(Color.WHITE);
		tableUsuarios.setBorder(new EmptyBorder(1, 2, 1, 2));
		JTableHeader th; 
		th = tableUsuarios.getTableHeader();
		Font fuente = new Font("Times New Roman", Font.PLAIN, 19);
		th.setBounds(0, 140, 900, 30);
		th.setFont(fuente); 

		tableUsuarios.setModel(new DefaultTableModel(
				new Object[][] {

				},
				new String[] {
						"NumPass", "Nombre", "Pais Origen", "CiudadNac", "FechaNac", "Email", "InfoAd"
				}
				) {
			/**
					 * 
					 */
					private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableUsuarios.getColumnModel().getColumn(0).setPreferredWidth(85);
		tableUsuarios.getColumnModel().getColumn(0).setMinWidth(85);
		tableUsuarios.getColumnModel().getColumn(0).setMaxWidth(85);
		tableUsuarios.getColumnModel().getColumn(1).setPreferredWidth(175);
		tableUsuarios.getColumnModel().getColumn(1).setMinWidth(175);
		tableUsuarios.getColumnModel().getColumn(1).setMaxWidth(175);
		tableUsuarios.getColumnModel().getColumn(2).setPreferredWidth(100);
		tableUsuarios.getColumnModel().getColumn(2).setMinWidth(100);
		tableUsuarios.getColumnModel().getColumn(2).setMaxWidth(100);
		tableUsuarios.getColumnModel().getColumn(3).setPreferredWidth(120);
		tableUsuarios.getColumnModel().getColumn(3).setMinWidth(120);
		tableUsuarios.getColumnModel().getColumn(3).setMaxWidth(120);
		tableUsuarios.getColumnModel().getColumn(4).setPreferredWidth(100);
		tableUsuarios.getColumnModel().getColumn(4).setMinWidth(100);
		tableUsuarios.getColumnModel().getColumn(4).setMaxWidth(100);
		tableUsuarios.getColumnModel().getColumn(5).setPreferredWidth(170);
		tableUsuarios.getColumnModel().getColumn(5).setMinWidth(170);
		tableUsuarios.getColumnModel().getColumn(5).setMaxWidth(170);
		tableUsuarios.getColumnModel().getColumn(6).setPreferredWidth(145);
		tableUsuarios.getColumnModel().getColumn(6).setMinWidth(145);
		tableUsuarios.setBounds(0, 0, 890, 60);
		tableUsuarios.setRowHeight(30);

		tableUsuarios.updateUI();
		scrollPane.updateUI();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setViewportView(tableUsuarios);

		panel.add(scrollPane);
		scrollPane.setVisible(true);
		tableUsuarios.setVisible(true);

		scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(75, 230, 750, 120);

		tableUsuarios2 = new JTable();
		tableUsuarios2.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		tableUsuarios2.setBackground(Color.WHITE);
		tableUsuarios2.setBorder(new EmptyBorder(1, 2, 1, 2));
		JTableHeader th2; 
		th2 = tableUsuarios2.getTableHeader();
		Font fuente2 = new Font("Times New Roman", Font.PLAIN, 19);
		th2.setBounds(75, 230, 750, 30);
		th2.setFont(fuente2); 

		tableUsuarios2.setModel(new DefaultTableModel(
				new Object[][] {

				},
				new String[] {
						"NumPass", "Nombre", "FechaNac", "ValorVisa", "Impuesto", "ValorTotal"
				}
				) {
			/**
					 * 
					 */
					private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableUsuarios2.getColumnModel().getColumn(0).setPreferredWidth(85);
		tableUsuarios2.getColumnModel().getColumn(0).setMinWidth(85);
		tableUsuarios2.getColumnModel().getColumn(0).setMaxWidth(85);
		tableUsuarios2.getColumnModel().getColumn(1).setPreferredWidth(175);
		tableUsuarios2.getColumnModel().getColumn(1).setMinWidth(175);
		tableUsuarios2.getColumnModel().getColumn(1).setMaxWidth(175);
		tableUsuarios2.getColumnModel().getColumn(2).setPreferredWidth(100);
		tableUsuarios2.getColumnModel().getColumn(2).setMinWidth(100);
		tableUsuarios2.getColumnModel().getColumn(2).setMaxWidth(100);
		tableUsuarios2.getColumnModel().getColumn(3).setPreferredWidth(120);
		tableUsuarios2.getColumnModel().getColumn(3).setMinWidth(120);
		tableUsuarios2.getColumnModel().getColumn(3).setMaxWidth(120);
		tableUsuarios2.getColumnModel().getColumn(4).setPreferredWidth(100);
		tableUsuarios2.getColumnModel().getColumn(4).setMinWidth(100);
		tableUsuarios2.getColumnModel().getColumn(4).setMaxWidth(100);
		tableUsuarios2.getColumnModel().getColumn(5).setPreferredWidth(170);
		tableUsuarios2.getColumnModel().getColumn(5).setMinWidth(170);
		tableUsuarios2.getColumnModel().getColumn(5).setMaxWidth(170);

		tableUsuarios2.setBounds(75, 230, 750, 60);
		tableUsuarios2.setRowHeight(30);

		tableUsuarios.updateUI();
		scrollPane2.updateUI();
		scrollPane2.setBackground(Color.WHITE);
		scrollPane2.setViewportView(tableUsuarios2);

		panel.add(scrollPane2);
		scrollPane2.setVisible(true);
		tableUsuarios2.setVisible(true);

	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String accion = e.getActionCommand();
		if(accion.equals(InterfazGrafica.CALCULAR_VALOR_VISA))
		{
			String cadena = "";
			int index = comboBox.getSelectedIndex();
			if(index == 0)
			{
				cadena = cadena.concat("np");
			}
			if(index == 1)
			{
				cadena = cadena.concat("cp");
			}
			String numero = textNumero.getText();
			if(numero == null )
			{
				numero = "-1";
			}

			cadena = cadena.concat(numero).trim();
			cadena = cadena.trim();

			interfaz.calcularValorVisa(cadena);
		}
	}

	/**
	 * @param usuario
	 */
	public static void actualizarInfoUsuario(Usuario usuario) {
		tableUsuarios.setVisible(true);
		DefaultTableModel tableModel = (DefaultTableModel) tableUsuarios.getModel();
		if(tableModel.getRowCount() != 0)
		{
			tableModel.removeRow(0);
		}
		Utilidades.imprimirUsuario(tableModel, usuario);
		tableUsuarios.setModel(tableModel);
		tableUsuarios.updateUI();
		panel.updateUI();
	}

	/**
	 * @param infoUsuarios
	 */
	public static void actualizarUsuarios(ArrayList<String> infoUsuarios) 
	{
		tableUsuarios2.setVisible(true);
		DefaultTableModel tableModel = (DefaultTableModel) tableUsuarios2.getModel();
		while(tableModel.getRowCount() != 0)
		{
			tableModel.removeRow(0);
		}
		String []datos = new String[6];
		for(int i=0 ;i<infoUsuarios.size() ; i++)
		{
			datos = infoUsuarios.get(i).split("@");
			String numPass = datos[0].trim();
			String nombre = datos[1].trim();
			String fechaNac = datos[2].trim();
			String valorVisa = datos[3].trim();
			String impuesto	 = datos[4].trim();
			String valorTotal = datos[5].trim();

			Object[] fila = new Object[]{numPass,nombre,fechaNac,valorVisa,impuesto,valorTotal,};
			tableModel.addRow(fila);
		}

	}

	/**
	 * @param info
	 */
	public static void actualizarDatosFinales(String info) {
		String []datos = new String[4];
		datos = info.split("@");
		String PSC = datos[0].trim();
		String tasaCambio = datos[1].trim();
		String monedaLocal	 = datos[2].trim();
		String valorMoneda = datos[3].trim();

		lblInfoPSC.setText(PSC);
		lblInfoTasaCambio.setText(tasaCambio);
		lblInfoMonedaLocal.setText(monedaLocal);
		lblInfoValorModenaLocal.setText(valorMoneda);

		panel.updateUI();
	}
}
