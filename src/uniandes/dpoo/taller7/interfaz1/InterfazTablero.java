package uniandes.dpoo.taller7.interfaz1;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import uniandes.dpoo.taller7.modelo.Tablero;

public class InterfazTablero extends JFrame{
	
	private Tablero mundo;
	
	public InterfazTablero() {
		
		mundo = new Tablero(5);
		
		setTitle("Juego de LightsOut");
		ImageIcon icon = new ImageIcon("data/java.png");
		setIconImage(icon.getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600,650);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new InterfazTablero();
	}
}
