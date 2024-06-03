package uniandes.dpoo.taller7.interfaz4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import uniandes.dpoo.taller7.modelo.RegistroTop10;
import uniandes.dpoo.taller7.modelo.Tablero;
import uniandes.dpoo.taller7.modelo.Top10;

@SuppressWarnings("serial")
public class InterfazTablero extends JFrame {

	private Tablero mundo;
	private Top10 top;

	private PanelSuperior arriba;
	private PanelDerecha derecha;
	private PanelInferior abajo;
	private PanelIzquierda izquierda;

	public InterfazTablero() {

		top = new Top10();
		top.cargarRecords(new File("data/top10.csv"));

		setTitle("Juego de LightsOut");
		ImageIcon icon = new ImageIcon("data/java.png");
		setIconImage(icon.getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(530, 430);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setBackground(new Color(238, 238, 238, 255));

		arriba = new PanelSuperior(this);
		derecha = new PanelDerecha(this);
		abajo = new PanelInferior(this);
		izquierda = new PanelIzquierda(this);

		setLayout(new BorderLayout());
		add(arriba, BorderLayout.NORTH);
		add(derecha, BorderLayout.EAST);
		add(abajo, BorderLayout.SOUTH);
		add(izquierda, BorderLayout.WEST);

		setVisible(true);
	}

	public static void main(String[] args) {
		new InterfazTablero();
	}

	public void jugar(int row, int col) {
		if (mundo == null) {
			JOptionPane.showMessageDialog(this, "Debe de haber iniciado una partida primero",
					"Error: Partida Sin Iniciar", JOptionPane.ERROR_MESSAGE);
		} else if (abajo.recogerTexto().equals("")) {
			JOptionPane.showMessageDialog(this, "Debe de haber definido un jugador primero",
					"Error: No Se Ha Definido Jugador", JOptionPane.ERROR_MESSAGE);
		} else {
			mundo.jugar(row, col);
			abajo.setJugadas(mundo.darJugadas() + "");
			repaint();
			if (mundo.tableroIluminado()) {
				JOptionPane.showMessageDialog(this, "Ganaste la partida con " + mundo.darJugadas() + " jugadas y "
						+ mundo.calcularPuntaje() + " puntos.", "¡Ganaste!", JOptionPane.INFORMATION_MESSAGE);
				if (top.esTop10(mundo.calcularPuntaje())) {
					JOptionPane.showMessageDialog(this, "Felicidades, entraste al top 10.", "¡Top 10!",
							JOptionPane.INFORMATION_MESSAGE);
					top.agregarRegistro(abajo.recogerTexto(), mundo.calcularPuntaje());
					guardar();
				}
			}
		}
	}

	public void iniciarTablero(int i) {
		mundo = new Tablero(i);
		izquierda.setBoard(mundo.darTablero());
		izquierda.setRows(i);
	}

	public void reiniciarTablero() {
		mundo.reiniciar();
		izquierda.setBoard(mundo.darTablero());
		repaint();
	}

	public void nuevoJuego() {
		iniciarTablero(arriba.getDimensionTablero());
		mundo.desordenar(arriba.getDificultadTablero());
		repaint();
	}

	public String[] getTop10() {
		String[] registroTop10Strings = new String[top.darRegistros().size()];
		int i = 0;
		for (RegistroTop10 registroTop10 : top.darRegistros()) {
			String registroTop10String = registroTop10.toString();
			registroTop10Strings[i] = registroTop10String;
			i++;
		}
		return registroTop10Strings;
	}

	public void definirJugador(String input) {
		abajo.setJugador(input);
	}

	public void guardar() {
		try {
			top.salvarRecords(new File("data/top10.csv"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
