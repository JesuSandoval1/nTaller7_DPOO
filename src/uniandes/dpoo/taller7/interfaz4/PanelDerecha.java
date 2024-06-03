package uniandes.dpoo.taller7.interfaz4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelDerecha extends JPanel implements ActionListener {

	private InterfazTablero padre;

	private JButton bNuevo;
	private JButton bReiniciar;
	private JButton bTop10;
	private JButton bJugador;
	private PanelTop10 panelTop;
	public static final String BOTON_1 = "B1";
	public static final String BOTON_2 = "B2";
	public static final String BOTON_3 = "B3";
	public static final String BOTON_4 = "B4";

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
		bNuevo.setActionCommand(BOTON_1);
		bNuevo.setPreferredSize(new Dimension(155, 20));
		bNuevo.addActionListener(this);
		add(bNuevo, gbc);
		gbc.gridy++;

		bReiniciar = new JButton("REINICIAR");
		bReiniciar.setActionCommand(BOTON_2);
		bReiniciar.setPreferredSize(new Dimension(155, 20));
		bReiniciar.addActionListener(this);
		add(bReiniciar, gbc);
		gbc.gridy++;

		bTop10 = new JButton("TOP-10");
		bTop10.setActionCommand(BOTON_3);
		bTop10.setPreferredSize(new Dimension(155, 20));
		bTop10.addActionListener(this);
		add(bTop10, gbc);
		gbc.gridy++;

		bJugador = new JButton("CAMBIAR JUGADOR");
		bJugador.setActionCommand(BOTON_4);
		bJugador.setPreferredSize(new Dimension(155, 20));
		bJugador.addActionListener(this);
		add(bJugador, gbc);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();

		if (BOTON_1.equals(comando)) {
			padre.nuevoJuego();
		} else if (BOTON_2.equals(comando)) {
			padre.reiniciarTablero();
		} else if (BOTON_3.equals(comando)) {
			String[] data = padre.getTop10();
			panelTop = new PanelTop10(padre, data);
			panelTop.setVisible(true);
		} else if (BOTON_4.equals(comando)) {
			String input = JOptionPane.showInputDialog(padre, "Ingrese un valor:");
			if (input.equals("")) {
				JOptionPane.showMessageDialog(padre, "El nombre no puede ser ''", "Error: Nombre Invalido",
						JOptionPane.ERROR_MESSAGE);
			}
			padre.definirJugador(input);
		}
	}

}