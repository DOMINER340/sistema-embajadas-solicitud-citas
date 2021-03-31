package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class IMostrarReportesVisa extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * 
	 */
	private JTextField txtTitulo;
	private static JScrollPane scrollPane;
	/**
	 * relaciones
	 */
	InterfazGrafica interfaz;
	private JTextField textField;
	private static JTable table;

	/**
	 * Create the panel.
	 */
	public IMostrarReportesVisa(InterfazGrafica interfaz) {
		setBackground(new Color(255, 255, 255));
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
		txtTitulo.setText("Reporte de Solicitudes Embajada.");
		txtTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		txtTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		txtTitulo.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblFecha = new JLabel("Fecha: ");
		lblFecha.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblFecha.setBounds(300, 30, 60, 30);
		panel.add(lblFecha);

		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		textField.setBounds(349, 30, 91, 30);
		panel.add(textField);
		textField.setColumns(10);

		JButton btnGenerarReporte = new JButton("Generar Reporte");
		btnGenerarReporte.setForeground(new Color(255, 255, 255));
		btnGenerarReporte.setBackground(new Color(128, 0, 0));
		btnGenerarReporte.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		btnGenerarReporte.setBounds(440, 30, 160, 30);
		btnGenerarReporte.addActionListener(this);
		panel.add(btnGenerarReporte);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(190, 90, 520, 180);

		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		table.setBackground(new Color(135, 206, 250));
		table.setBorder(new EmptyBorder(1, 2, 1, 2));
		JTableHeader th;
		th = table.getTableHeader();
		Font fuente = new Font("Times New Roman", Font.PLAIN, 19);
		th.setBounds(0, 30, 520, 30);
		th.setFont(fuente);

		table.setModel(new DefaultTableModel(new Object[][] {

		}, new String[] { "NumPass", "Nombre", "Tipo Visa", "NumSolicitud", }) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] { false, false, false, false, };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.getColumnModel().getColumn(0).setMinWidth(80);
		table.getColumnModel().getColumn(0).setMaxWidth(80);
		table.getColumnModel().getColumn(1).setPreferredWidth(160);
		table.getColumnModel().getColumn(1).setMinWidth(160);
		table.getColumnModel().getColumn(1).setMaxWidth(160);
		table.getColumnModel().getColumn(2).setPreferredWidth(120);
		table.getColumnModel().getColumn(2).setMinWidth(120);
		table.getColumnModel().getColumn(2).setMaxWidth(120);
		table.getColumnModel().getColumn(3).setPreferredWidth(160);
		table.getColumnModel().getColumn(3).setMinWidth(160);
		table.getColumnModel().getColumn(3).setMaxWidth(160);
		table.setBounds(0, 0, 1, 1);
		table.setRowHeight(30);
		table.updateUI();
		scrollPane.updateUI();
		panel.updateUI();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setViewportView(table);
		table.setVisible(false);
		scrollPane.setVisible(false);
		panel.add(scrollPane);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String fecha = textField.getText();

		try {
			interfaz.generarReporteVisas(fecha);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * @param listaSolicitudes
	 */
	public static void actualizarReporteVisas(ArrayList<String> listaSolicitudes) {
		// TODO Auto-generated method stub
		table.setVisible(true);
		scrollPane.setVisible(true);
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		while (tableModel.getRowCount() != 0) {
			tableModel.removeRow(0);
		}
		String[] datos = new String[4];
		for (int i = 0; i < listaSolicitudes.size(); i++) {

			datos = listaSolicitudes.get(i).split("@");
			String numPass = datos[0].trim();
			String nombre = datos[1].trim();
			String tipoVisa = datos[2].trim();
			String numSolicitud = datos[3].trim();

			Object[] fila = new Object[] { numPass, nombre, tipoVisa, numSolicitud, };

			tableModel.addRow(fila);
		}
	}
}
