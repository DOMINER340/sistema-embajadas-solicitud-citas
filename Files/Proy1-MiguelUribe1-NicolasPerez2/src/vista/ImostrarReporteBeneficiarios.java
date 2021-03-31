package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ImostrarReporteBeneficiarios extends JPanel implements ActionListener{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * 
	 */
	JTextField txtTitulo;
	private static JTable tableUsuarios;
	private static JScrollPane scrollPane;

	/**
	 * relaciones
	 */
	InterfazGrafica interfaz;
	private JButton btnGenerarReporte;
	private JLabel lblNewLabel;
	private static JTextField textField;

	/**
	 * Create the panel.
	 */
	public ImostrarReporteBeneficiarios(InterfazGrafica interfaz) {
		this.interfaz = interfaz;


		setLayout(new BorderLayout(0, 0));

		JPanel panelTitulo = new JPanel();
		panelTitulo.setBorder(null);
		panelTitulo.setBackground(new Color(255, 255, 255));
		add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(new GridLayout(0, 1, 0, 0));

		txtTitulo = new JTextField();
		panelTitulo.add(txtTitulo);
		txtTitulo.setEditable(false);
		txtTitulo.setForeground(new Color(255, 0, 0));
		txtTitulo.setText("Reporte de Beneficiarios.");
		txtTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		txtTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		txtTitulo.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(250, 50, 400, 240);

		tableUsuarios = new JTable();
		tableUsuarios.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		tableUsuarios.setBackground(Color.WHITE);
		tableUsuarios.setBorder(new EmptyBorder(1, 2, 1, 2));
		JTableHeader th; 
		th = tableUsuarios.getTableHeader();
		Font fuente = new Font("Times New Roman", Font.PLAIN, 19);
		th.setBounds(0, 140, 400, 240);
		th.setFont(fuente); 

		tableUsuarios.setModel(new DefaultTableModel(
				new Object[][] {

				},
				new String[] {
						"NumPass", "Nombre", "Valor Total"
				}
				) {
			/**
					 * 
					 */
					private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
					false, false, false,
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableUsuarios.getColumnModel().getColumn(0).setPreferredWidth(100);
		tableUsuarios.getColumnModel().getColumn(0).setMinWidth(100);
		tableUsuarios.getColumnModel().getColumn(0).setMaxWidth(100);
		tableUsuarios.getColumnModel().getColumn(1).setPreferredWidth(200);
		tableUsuarios.getColumnModel().getColumn(1).setMinWidth(200);
		tableUsuarios.getColumnModel().getColumn(1).setMaxWidth(200);
		tableUsuarios.getColumnModel().getColumn(2).setPreferredWidth(100);
		tableUsuarios.getColumnModel().getColumn(2).setMinWidth(100);
		tableUsuarios.getColumnModel().getColumn(2).setMaxWidth(100);
		tableUsuarios.setBounds(0, 0, 400, 240);
		tableUsuarios.setRowHeight(30);

		tableUsuarios.updateUI();
		tableUsuarios.setBackground(Color.WHITE);
		scrollPane.updateUI();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setViewportView(tableUsuarios);

		panel.add(scrollPane);

		btnGenerarReporte = new JButton("Generar Reporte");
		btnGenerarReporte.setBackground(new Color(128, 0, 0));
		btnGenerarReporte.setForeground(new Color(255, 255, 255));
		btnGenerarReporte.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		btnGenerarReporte.setBounds(370, 400, 160, 30);
		btnGenerarReporte.addActionListener(this);
		panel.add(btnGenerarReporte);

		lblNewLabel = new JLabel("Valor que se dejo de recaudar: ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblNewLabel.setBounds(275, 350, 250, 30);
		panel.add(lblNewLabel);

		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		textField.setBounds(525, 350, 100, 30);
		panel.add(textField);
		textField.setColumns(10);
		scrollPane.setVisible(true);
		tableUsuarios.setVisible(true);
		textField.setEditable(false);

	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		try {
			interfaz.generarReporteBeneficiarios();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * @param datos
	 */
	public static void actualizarReporte(List<String> datos) {
		tableUsuarios.setVisible(true);
		DefaultTableModel tableModel = (DefaultTableModel) tableUsuarios.getModel();
		if(tableModel.getRowCount() != 0)
		{
			tableModel.removeRow(0);
		}
		tableUsuarios.setModel(tableModel);
		tableUsuarios.updateUI();

		String []datosN = new String[3];
		for(int i=0 ;i<datos.size()-1 ; i++)
		{
			datosN = datos.get(i).split("@");
			String numPass = datosN[0].trim();
			String nombre = datosN[1].trim();
			String valorTotal = datosN[2].trim();
			Object[] fila = new Object[]{numPass,nombre,valorTotal};
			tableModel.addRow(fila);
		}
		textField.setText(datos.get(  (datos.size()-(1)  ) ) );
	}

}
