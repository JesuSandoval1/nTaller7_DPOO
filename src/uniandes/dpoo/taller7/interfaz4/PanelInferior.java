package uniandes.dpoo.taller7.interfaz4;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PanelInferior extends JPanel{
	
	@SuppressWarnings("unused")
	private InterfazTablero padre;
	
	private JTextField jugadas;
	private JTextField jugador;
	
	public PanelInferior(InterfazTablero papa) {
		super();
		setLayout(new GridLayout (1,4));
		setBackground(new Color(238,238,238,255));
		
		padre = papa;
		
		add(new JLabel("Jugadas:"));
		
		jugadas = new JTextField();
		jugadas.setText("0");
		add(jugadas);
		
		add(new JLabel("Jugador:"));
		
		jugador = new JTextField();
		add(jugador);
		
		setVisible(true);
	}
	
	public String recogerTexto() {
		String rta = jugador.getText();
		return rta;
	}

	public void setJugador(String input) {
		jugador.setText(input);
	}
	
	public void setJugadas(String input) {
		jugadas.setText(input);
	}
}