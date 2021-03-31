package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import modelo.Usuario;
import utilidades.Utilidades;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ISolicitarVisaTurismo extends JPanel implements ActionListener {

	/*
	 * constantes
	 */

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * atributos
	 */
	private static InterfazGrafica interfaz;
	private JTextField textMensaje;
	private JTextField textInfoDiasEstadia;
	private static  JTextField textInfoNoSolicitud;
	private static  JPanel panelPrincipal;
	private static JScrollPane scrollPane;
	private static JButton btnCargarArchivoTarifa;
	private static JButton btnAdicionarUsuario;
	static JPanel panelEncabezadoUsuarios;
	private static JTable tableUsuarios;
	
	/**
	 * Create the panel.
	 */
	public ISolicitarVisaTurismo (InterfazGrafica interfaz) {
		this.interfaz = interfaz;
		setLayout(new BorderLayout(0, 0));

		textMensaje = new JTextField();
		textMensaje.setEditable(false);
		textMensaje.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		textMensaje.setForeground(Color.RED);
		textMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		textMensaje.setText("Hacer solicitud visa Turismo ");
		add(textMensaje, BorderLayout.NORTH);
		textMensaje.setColumns(10);

		panelPrincipal = new JPanel();
		add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setBackground(Color.WHITE);
		panelPrincipal.setLayout(null);

		JLabel lblDiasEstadia = new JLabel("D\u00EDas estad\u00EDa");
		lblDiasEstadia.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblDiasEstadia.setBounds(330, 20, 120, 30);
		panelPrincipal.add(lblDiasEstadia);

		JLabel lblNoSolicitud = new JLabel("No Solicitud");
		lblNoSolicitud.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblNoSolicitud.setBounds(330, 100, 120, 30);
		panelPrincipal.add(lblNoSolicitud);

		btnCargarArchivoTarifa = new JButton("Cargar archivo de Tarifas");
		btnCargarArchivoTarifa.setBackground(new Color(128, 0, 0));
		btnCargarArchivoTarifa.setForeground(new Color(255, 255, 255));
		btnCargarArchivoTarifa.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnCargarArchivoTarifa.setBounds(310, 61, 280, 30);
		btnCargarArchivoTarifa.addActionListener(this);
		btnCargarArchivoTarifa.setActionCommand(InterfazGrafica.CARGAR_ARCHIVO_TARIFAS);
		panelPrincipal.add(btnCargarArchivoTarifa);


		textInfoDiasEstadia = new JTextField();
		textInfoDiasEstadia.setHorizontalAlignment(SwingConstants.CENTER);
		textInfoDiasEstadia.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		textInfoDiasEstadia.setBounds(450, 20, 120, 30);
		panelPrincipal.add(textInfoDiasEstadia);
		textInfoDiasEstadia.setColumns(10);

		textInfoNoSolicitud = new JTextField();
		textInfoNoSolicitud.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		textInfoNoSolicitud.setHorizontalAlignment(SwingConstants.CENTER);
		textInfoNoSolicitud.setBounds(450, 100, 120, 30);
		textInfoNoSolicitud.setBackground(Color.WHITE);
		textInfoNoSolicitud.setEditable(false);
		panelPrincipal.add(textInfoNoSolicitud);
		textInfoNoSolicitud.setColumns(10);

		btnAdicionarUsuario = new JButton("Adicionar usuario");
		btnAdicionarUsuario.setBackground(new Color(128, 0, 0));
		btnAdicionarUsuario.setForeground(new Color(255, 255, 255));
		btnAdicionarUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnAdicionarUsuario.setBounds(310, 395, 280, 30);
		btnAdicionarUsuario.addActionListener(this);
		btnAdicionarUsuario.setActionCommand(InterfazGrafica.ADICIONAR_USUARIO);
		panelPrincipal.add(btnAdicionarUsuario);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 170, 890, 180);

		tableUsuarios = new JTable();
		tableUsuarios.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		tableUsuarios.setBackground(Color.WHITE);
		tableUsuarios.setBorder(new EmptyBorder(1, 2, 1, 2));
		JTableHeader th; 
		th = tableUsuarios.getTableHeader();
		Font fuente = new Font("Times New Roman", Font.PLAIN, 19);
		th.setBounds(0, 0, 890, 30);
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
		tableUsuarios.setBounds(0, 100, 890, 180);
		tableUsuarios.setRowHeight(30);

		tableUsuarios.updateUI();
		scrollPane.updateUI();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setViewportView(tableUsuarios);

		panelPrincipal.add(scrollPane);
		scrollPane.setVisible(false);
		tableUsuarios.setVisible(false);
		btnAdicionarUsuario.setVisible(false);	
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override 
	public void actionPerformed(ActionEvent e)
	{

		// TODO Auto-generated method stub
		String accion = e.getActionCommand();
		if(accion.equals(InterfazGrafica.CARGAR_ARCHIVO_TARIFAS))
		{
			String diasEstadia = textInfoDiasEstadia.getText();
			if(diasEstadia == null || diasEstadia.equalsIgnoreCase(""))
			{
				diasEstadia = "0" ;
			}
			int numDiasEstadia;
			numDiasEstadia = Integer.parseInt(diasEstadia);
			interfaz.crearSolicicitudTurismo(numDiasEstadia);
		}
		if(accion.equals(InterfazGrafica.ADICIONAR_USUARIO))
		{
			int filaSeleccionada = tableUsuarios.getSelectedRow();
			if( filaSeleccionada != (-1))
			{

				DefaultTableModel tableModel = (DefaultTableModel) tableUsuarios.getModel();
				String NumPassSeleccionado = String.valueOf(tableModel.getValueAt(filaSeleccionada, 0));
				int codigo = Integer.valueOf(textInfoNoSolicitud.getText());
				interfaz.adicionarUsuario(NumPassSeleccionado,codigo);
			}


		}	
	}
	
	/**
	 * @param codigo
	 * @param map
	 */
	public static void actualizarNoSolicitud(int codigo , Map<String, Usuario> map) {
		textInfoNoSolicitud.setText(String.valueOf(codigo));
		btnAdicionarUsuario.setVisible(true);
		scrollPane.setVisible(true);
		tableUsuarios.setVisible(true);
		scrollPane.getViewport().removeAll();
		DefaultTableModel tableModel = (DefaultTableModel) tableUsuarios.getModel();
		if(tableModel.getRowCount() != 0)
		{
			for(int i=0 ;i <map.size() ; i++)
			{
				int x = 0;
				tableModel.removeRow(x);
			}
		}
		tableUsuarios.updateUI();
		java.util.Iterator<String> it =  map.keySet().iterator();
		while(it.hasNext()){
			String	 key = it.next();

			Usuario usuario= map.get(key);

			Utilidades.imprimirUsuario(tableModel, usuario);


		}
		tableUsuarios.setModel(tableModel);
		scrollPane.setViewportView(tableUsuarios);
		scrollPane.updateUI();
		panelPrincipal.updateUI();
	}
	
	/**
	 * @param b
	 */
	public static void actualizarBotonTarifas(boolean b) {
		// TODO Auto-generated method stub
		btnCargarArchivoTarifa.setEnabled(b);
	}
}
