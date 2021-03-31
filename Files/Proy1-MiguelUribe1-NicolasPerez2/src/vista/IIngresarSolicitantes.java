package vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import javax.swing.SwingConstants;
import modelo.Usuario;
import utilidades.Utilidades;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.border.EmptyBorder;

public class IIngresarSolicitantes extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * atributos
	 */
	InterfazGrafica interfaz;
	private JTextField txtIngresarSolicitantes;
	private JTextField txtUsuarios;
	private JPanel panelUsuario;
	private JScrollPane scrollPane;
	private JTable tableUsuarios;

	/**
	 * Create the panel.
	 */
	public IIngresarSolicitantes(InterfazGrafica interfaz) {
		this.interfaz = interfaz;
		setLayout(new BorderLayout(0, 0));

		JPanel panelTitulo = new JPanel();
		panelTitulo.setBorder(null);
		panelTitulo.setBackground(new Color(255, 255, 255));
		add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(new GridLayout(0, 1, 0, 0));

		txtIngresarSolicitantes = new JTextField();
		panelTitulo.add(txtIngresarSolicitantes);
		txtIngresarSolicitantes.setEditable(false);
		txtIngresarSolicitantes.setForeground(new Color(255, 0, 0));
		txtIngresarSolicitantes.setText("Ingresar Solicitantes");
		txtIngresarSolicitantes.setHorizontalAlignment(SwingConstants.CENTER);
		txtIngresarSolicitantes.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		txtIngresarSolicitantes.setColumns(10);

		JPanel panelBoton = new JPanel();
		panelBoton.setBorder(null);
		panelBoton.setBackground(new Color(255, 255, 255));
		panelTitulo.add(panelBoton);
		GridBagLayout gbl_panelBoton = new GridBagLayout();
		gbl_panelBoton.columnWidths = new int[] {1};
		gbl_panelBoton.rowHeights = new int[] {1};
		gbl_panelBoton.columnWeights = new double[]{0.0};
		gbl_panelBoton.rowWeights = new double[]{0.0};
		panelBoton.setLayout(gbl_panelBoton);

		JButton btnSeleccionarArchivoUsuario = new JButton("Seleccionar  archivo de usuarios");
		btnSeleccionarArchivoUsuario.setBackground(new Color(128, 0, 0));
		btnSeleccionarArchivoUsuario.setForeground(new Color(255, 255, 255));
		btnSeleccionarArchivoUsuario.addActionListener(this);
		GridBagConstraints gbc_btnSeleccionarArchivoUsuario = new GridBagConstraints();
		gbc_btnSeleccionarArchivoUsuario.anchor = GridBagConstraints.NORTH;
		gbc_btnSeleccionarArchivoUsuario.gridx = 0;
		gbc_btnSeleccionarArchivoUsuario.gridy = 0;
		panelBoton.add(btnSeleccionarArchivoUsuario, gbc_btnSeleccionarArchivoUsuario);
		btnSeleccionarArchivoUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 22));

		JPanel panelInformacion = new JPanel();
		panelInformacion.setBorder(null);
		panelInformacion.setBackground(new Color(255, 255, 255));
		add(panelInformacion, BorderLayout.CENTER);
		panelInformacion.setLayout(new BorderLayout(0, 0));

		txtUsuarios = new JTextField();
		txtUsuarios.setBackground(new Color(255, 255, 255));
		txtUsuarios.setEditable(false);
		txtUsuarios.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		txtUsuarios.setText("Usuarios");
		txtUsuarios.setHorizontalAlignment(SwingConstants.LEFT);
		panelInformacion.add(txtUsuarios, BorderLayout.NORTH);
		txtUsuarios.setColumns(10);

		JPanel panelInfoUsuarios = new JPanel();
		panelInfoUsuarios.setBorder(null);
		panelInfoUsuarios.setBackground(new Color(255, 255, 255));
		panelInformacion.add(panelInfoUsuarios, BorderLayout.CENTER);
		panelInfoUsuarios.setLayout(null);


		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 890, 180);



		panelInfoUsuarios.add(scrollPane);

		tableUsuarios = new JTable();
		tableUsuarios.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		tableUsuarios.setBackground(Color.WHITE);
		tableUsuarios.setBorder(new EmptyBorder(1, 2, 1, 2));
		JTableHeader th; 
		th = tableUsuarios.getTableHeader();
		Font fuente = new Font("Times New Roman", Font.PLAIN, 19);
		th.setBounds(0, 30, 890, 30);
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
		tableUsuarios.getColumnModel().getColumn(6).setMaxWidth(145);
		tableUsuarios.setBounds(0, 100, 890, 180);
		tableUsuarios.setRowHeight(30);

		tableUsuarios.updateUI();
		scrollPane.updateUI();
		panelInfoUsuarios.updateUI();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setViewportView(tableUsuarios);

		panelUsuario = new JPanel();
		panelUsuario.setSize(890,150);

		GridBagLayout gbl_panelUsuario = new GridBagLayout();
		gbl_panelUsuario.columnWidths = new int[]{0};
		gbl_panelUsuario.rowHeights = new int[]{0};
		gbl_panelUsuario.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panelUsuario.rowWeights = new double[]{Double.MIN_VALUE};
		panelUsuario.setLayout(gbl_panelUsuario);

		scrollPane.setVisible(false);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		interfaz.ingresarSolicitantes();
	}

	/**
	 * @param map
	 */
	public void actualizarUsuario(Map<String, Usuario> map) {
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

			panelUsuario.updateUI();
		}
		tableUsuarios.setModel(tableModel);
		scrollPane.setViewportView(tableUsuarios);

		scrollPane.updateUI();
	}
}
