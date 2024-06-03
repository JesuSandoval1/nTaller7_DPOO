package uniandes.dpoo.taller7.interfaz2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PanelDerecha extends JPanel {

	private InterfazTablero padre;

	private JButton bNuevo;
	private JButton bReiniciar;
	private JButton bTop10;
	private JButton bJugador;

	public PanelDerecha(InterfazTablero papa) {
		super();
		setBackground(new Color(238, 238, 238, 255));
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0; // Columna 0
		gbc.gridy = 0; // Fila 0
		gbc.fill = GridBagConstraints.HORIZONTAL; // Expansión horizontal
		gbc.insets = new Insets(5, 5, 5, 5); // Margen de 5 píxeles en todos los lados

		padre = papa;

		bNuevo = new JButton("NUEVO");
		bNuevo.setPreferredSize(new Dimension(155, 20));
		add(bNuevo, gbc);
		gbc.gridy++;

		bReiniciar = new JButton("REINICIAR");
		bReiniciar.setPreferredSize(new Dimension(155, 20));
		add(bReiniciar, gbc);
		gbc.gridy++;

		bTop10 = new JButton("TOP-10");
		bTop10.setPreferredSize(new Dimension(155, 20));
		add(bTop10, gbc);
		gbc.gridy++;

		bJugador = new JButton("CAMBIAR JUGADOR");
		bJugador.setPreferredSize(new Dimension(155, 20));
		add(bJugador, gbc);

		setVisible(true);
	}

}