package vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import modelo.Visa;

public class IIngresarVisas extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	* atributos
	*/
	private JTextField txtIngresarVisas;
	private JPanel panelInfoVisas;
	JLabel lblTinfoVisas;
	/**
	 *Relaciones 
	 */
		
	InterfazGrafica interfaz;

	/**
	 * Create the panel.
	 */
	public IIngresarVisas(InterfazGrafica interfaz) 
	{
		this.interfaz = interfaz;
		
		setLayout(new BorderLayout(0, 0));

		JPanel panelTitulo = new JPanel();
		panelTitulo.setBorder(null);
		panelTitulo.setBackground(new Color(255, 255, 255));
		add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(new GridLayout(0, 1, 0, 0));

		txtIngresarVisas = new JTextField();
		panelTitulo.add(txtIngresarVisas);
		txtIngresarVisas.setEditable(false);
		txtIngresarVisas.setForeground(new Color(255, 0, 0));
		txtIngresarVisas.setText("Ingresar Visas");
		txtIngresarVisas.setHorizontalAlignment(SwingConstants.CENTER);
		txtIngresarVisas.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		txtIngresarVisas.setColumns(10);

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

		JButton btnSeleccionarArchivoVisas = new JButton("Seleccionar  archivo de Visas");
		btnSeleccionarArchivoVisas.setBackground(new Color(128, 0, 0));
		btnSeleccionarArchivoVisas.setForeground(new Color(255, 255, 255));
		btnSeleccionarArchivoVisas.addActionListener(this);
		GridBagConstraints gbc_btnSeleccionarArchivoVisas = new GridBagConstraints();
		gbc_btnSeleccionarArchivoVisas.anchor = GridBagConstraints.NORTH;
		gbc_btnSeleccionarArchivoVisas.gridx = 0;
		gbc_btnSeleccionarArchivoVisas.gridy = 0;
		panelBoton.add(btnSeleccionarArchivoVisas, gbc_btnSeleccionarArchivoVisas);
		btnSeleccionarArchivoVisas.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		panelInfoVisas = new JPanel();
		panelInfoVisas.setBackground(Color.WHITE);
		add(panelInfoVisas, BorderLayout.CENTER);
		panelInfoVisas.setLayout(null);
		
		lblTinfoVisas = new JLabel("Tipos de visas registradas:");
		lblTinfoVisas.setBackground(Color.WHITE);
		lblTinfoVisas.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblTinfoVisas.setBounds(0, 0, 900, 30);
		lblTinfoVisas.setVisible(false);
		panelInfoVisas.add(lblTinfoVisas);

	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		interfaz.ingresarVisas();
	}

	/**
	 * @param visas
	 */
	public void actualizarVisas(ArrayList<Visa> visas) 
	{
		lblTinfoVisas.setVisible(true);
		// TODO Auto-generated method stub
		boolean banderaTurismo = false;
		boolean banderaTrabajo = false;
		boolean banderaestudiante = false;
		int coordenada = 30;
		for (int i = 0; i < visas.size(); i++) 
		{
			
			JLabel lblVisaInformacion = new JLabel("");
			lblVisaInformacion.setBackground(Color.WHITE);
			lblVisaInformacion.setFont(new Font("Times New Roman", Font.PLAIN, 19));
			
			Visa visa = visas.get(i);
			if( visa.getTipo().equalsIgnoreCase("turismo") && banderaTurismo==false)
			{
				banderaTurismo = true;
				lblVisaInformacion.setText(visa.getTipo());
				lblVisaInformacion.setBounds(0, coordenada, 900, 30);
				panelInfoVisas.add(lblVisaInformacion);
				coordenada += 30;
			}
			if( visa.getTipo().equalsIgnoreCase("trabajo") && banderaTrabajo==false)
			{
				banderaTrabajo = true;
				lblVisaInformacion.setText(visa.getTipo());
				lblVisaInformacion.setBounds(0, coordenada, 900, 30);
				panelInfoVisas.add(lblVisaInformacion);
				coordenada += 30;
			}
			if( visa.getTipo().equalsIgnoreCase("estudiante") && banderaestudiante==false)
			{
				banderaestudiante = true;
				lblVisaInformacion.setText(visa.getTipo());
				lblVisaInformacion.setBounds(0, coordenada, 900, 30);
				panelInfoVisas.add(lblVisaInformacion);
				coordenada += 30;
			}
		}
		panelInfoVisas.updateUI();
	}
}



