package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
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
import javax.swing.JButton;

public class ISolicitarVisaTrabajo extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * atributos
	 */
	private JTextField textMensaje;

	/**
	 * atributos
	 */
	InterfazGrafica interfaz;
	private JTextField textEmpresa;
	private JTextField textCargo;
	private static JTextField textNoSolicitud;
	private static JButton btnCargarArchivo;
	private static JScrollPane scrollPane;
	private static JTable tableUsuarios;
	private static JButton btnAsociarUsuario;

	/**
	 * Create the panel.
	 */
	public ISolicitarVisaTrabajo(InterfazGrafica interfaz) {
		this.interfaz = interfaz;
		setLayout(new BorderLayout(0, 0));

		textMensaje = new JTextField();
		textMensaje.setEditable(false);
		textMensaje.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		textMensaje.setForeground(Color.RED);
		textMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		textMensaje.setText("Hacer solicitud visa Trabajo ");
		add(textMensaje, BorderLayout.NORTH);
		textMensaje.setColumns(10);

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);

		JLabel lblEmpresa = new JLabel("Empresa");
		lblEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmpresa.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblEmpresa.setBounds(250, 20, 80, 30);
		panel.add(lblEmpresa);

		JLabel lblCargo = new JLabel("Cargo");
		lblCargo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCargo.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblCargo.setBounds(450, 20, 80, 30);
		panel.add(lblCargo);

		textEmpresa = new JTextField();
		textEmpresa.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		textEmpresa.setBounds(330, 20, 120, 30);
		panel.add(textEmpresa);
		textEmpresa.setColumns(10);

		textCargo = new JTextField();
		textCargo.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		textCargo.setBounds(530, 20, 120, 30);
		panel.add(textCargo);
		textCargo.setColumns(10);

		btnCargarArchivo = new JButton("Cargar archivo de Tarifas");
		btnCargarArchivo.setBackground(new Color(128, 0, 0));
		btnCargarArchivo.setForeground(new Color(255, 255, 255));
		btnCargarArchivo.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnCargarArchivo.setBounds(310, 61, 280, 30);
		btnCargarArchivo.addActionListener(this);
		btnCargarArchivo.setActionCommand(InterfazGrafica.CARGAR_ARCHIVO_TARIFAS);
		panel.add(btnCargarArchivo);

		JLabel lblNoSolicitud = new JLabel("No Solicitud");
		lblNoSolicitud.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		lblNoSolicitud.setBounds(330, 102, 120, 30);
		panel.add(lblNoSolicitud);

		textNoSolicitud = new JTextField();

		textNoSolicitud.setBounds(450, 102, 120, 30);
		textNoSolicitud.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		textNoSolicitud.setBackground(Color.WHITE);
		textNoSolicitud.setEditable(false);
		panel.add(textNoSolicitud);
		textNoSolicitud.setColumns(10);

		btnAsociarUsuario = new JButton("Asociar Usuario");
		btnAsociarUsuario.setForeground(new Color(255, 255, 255));
		btnAsociarUsuario.setBackground(new Color(128, 0, 0));
		btnAsociarUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnAsociarUsuario.setBounds(310, 395, 280, 30);
		btnAsociarUsuario.addActionListener(this);
		btnAsociarUsuario.setActionCommand(InterfazGrafica.ADICIONAR_USUARIO);
		panel.add(btnAsociarUsuario);

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

		panel.add(scrollPane);
		tableUsuarios.setVisible(false);
		scrollPane.setVisible(true);
		btnAsociarUsuario.setVisible(false);	

	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String accion = e.getActionCommand();
		if(accion.equals(InterfazGrafica.CARGAR_ARCHIVO_TARIFAS))
		{
			String empresa = textEmpresa.getText();
			String cargo = textCargo.getText();
			if(empresa == null || cargo == null )
			{
				empresa = "";
				cargo = "";
			}
			interfaz.crearSolicicitudTrabajo(empresa,cargo);
		}
		if(accion.equals(InterfazGrafica.ADICIONAR_USUARIO))
		{
			int filaSeleccionada = tableUsuarios.getSelectedRow();
			if( filaSeleccionada != (-1))
			{
				DefaultTableModel tableModel = (DefaultTableModel) tableUsuarios.getModel();
				String NumPassSeleccionado = String.valueOf(tableModel.getValueAt(filaSeleccionada, 0));
				int codigo = Integer.valueOf(textNoSolicitud.getText());
				interfaz.adicionarUsuario(NumPassSeleccionado,codigo);
			}
		}	
	}

	/**
	 * @param codigo
	 * @param map
	 */
	public static void actualizarNoSolicitud(int codigo, Map<String, Usuario> map) {
		// TODO Auto-generated method stub
		textNoSolicitud.setText(String.valueOf(codigo));
		btnAsociarUsuario.setVisible(true);
		tableUsuarios.setVisible(true);
		scrollPane.setVisible(true);
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
	}

	/**
	 * @param b
	 */
	public static void actualizarBotonTarifas(boolean b) {
		// TODO Auto-generated method stub
		btnCargarArchivo.setEnabled(b);
	}
}
