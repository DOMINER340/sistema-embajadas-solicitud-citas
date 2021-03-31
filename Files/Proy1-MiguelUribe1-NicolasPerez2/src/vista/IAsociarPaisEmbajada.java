package vista;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import modelo.Pais;
import javax.swing.JButton;
import java.awt.Insets;

public class IAsociarPaisEmbajada extends JPanel implements ActionListener  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textMensaje;
	private JTextField textTexto;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;

	/**
	 * Relacion
	 */
	InterfazGrafica interfaz;
	private JPanel panelAuxiliar;


	/**
	 * Create the panel.
	 */
	public IAsociarPaisEmbajada(InterfazGrafica interfaz) {
		this.interfaz = interfaz;
		setLayout(new BorderLayout(0, 0));

		textMensaje = new JTextField();
		textMensaje.setEditable(false);
		textMensaje.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		textMensaje.setForeground(Color.RED);
		textMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		textMensaje.setText("Asociar Pais Embajada");
		add(textMensaje, BorderLayout.NORTH);
		textMensaje.setColumns(10);


		//panel auxiliar de formato... hace que el panel principal quede centrado
		panelAuxiliar = new JPanel();
		panelAuxiliar.setBackground(new Color(255, 255, 255));
		add(panelAuxiliar, BorderLayout.WEST);
		GridBagLayout gbl_panelAuxiliar = new GridBagLayout();
		gbl_panelAuxiliar.columnWidths = new int[]{225};
		gbl_panelAuxiliar.rowHeights = new int[]{0};
		gbl_panelAuxiliar.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panelAuxiliar.rowWeights = new double[]{Double.MIN_VALUE};
		panelAuxiliar.setLayout(gbl_panelAuxiliar);

		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBackground(new Color(255, 255, 255));
		add(panelPrincipal);
		GridBagLayout gbl_panelPrincipal = new GridBagLayout();
		gbl_panelPrincipal.columnWidths = new int[] {451, 225};
		gbl_panelPrincipal.rowHeights = new int[]{65, 66, 0};
		gbl_panelPrincipal.columnWeights = new double[]{8.0, Double.MIN_VALUE};
		gbl_panelPrincipal.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelPrincipal.setLayout(gbl_panelPrincipal);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 0, 0));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		panelPrincipal.add(panel, gbc_panel);
		panel.setLayout(new GridLayout(1, 2, 0, 0));

		textTexto = new JTextField();
		textTexto.setBackground(new Color(255, 255, 255));
		textTexto.setEditable(false);
		textTexto.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		textTexto.setText("Pais:");
		textTexto.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(textTexto);
		textTexto.setColumns(10);

		comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setModel(new DefaultComboBoxModel(Pais.values()));
		panel.add(comboBox);

		JButton btnBuscarArchivoEmbajadas = new JButton("Buscar Archivo Embajadas");
		btnBuscarArchivoEmbajadas.setForeground(new Color(255, 255, 255));
		btnBuscarArchivoEmbajadas.setBackground(new Color(128, 0, 0));
		btnBuscarArchivoEmbajadas.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnBuscarArchivoEmbajadas.addActionListener(this);
		btnBuscarArchivoEmbajadas.setActionCommand(InterfazGrafica.INGRESAR_SOLICITANTES);
		GridBagConstraints gbc_btnBuscarArchivoEmbajadas = new GridBagConstraints();
		gbc_btnBuscarArchivoEmbajadas.fill = GridBagConstraints.BOTH;
		gbc_btnBuscarArchivoEmbajadas.gridx = 0;
		gbc_btnBuscarArchivoEmbajadas.gridy = 1;
		panelPrincipal.add(btnBuscarArchivoEmbajadas, gbc_btnBuscarArchivoEmbajadas);

	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String pais = comboBox.getSelectedItem().toString();
		interfaz.asociarPaisEmbajada(pais);

	}


}
