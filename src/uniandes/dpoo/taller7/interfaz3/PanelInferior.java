package uniandes.dpoo.taller7.interfaz3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelInferior extends JPanel{
	
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
		add(jugadas);
		
		add(new JLabel("Jugador:"));
		
		jugador = new JTextField();
		add(jugador);
		
		setVisible(true);
	}
	
}