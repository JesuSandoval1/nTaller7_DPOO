package uniandes.dpoo.taller7.interfaz3;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import uniandes.dpoo.taller7.modelo.Tablero;

public class InterfazTablero extends JFrame{
	
	private Tablero mundo;
	
	private PanelSuperior arriba;
	private PanelDerecha derecha;
	private PanelInferior abajo;
	private PanelIzquierda izquierda;
	
	public InterfazTablero() {
		
		mundo = new Tablero(5);
		
		setTitle("Juego de LightsOut");
		ImageIcon icon = new ImageIcon("data/java.png");
		setIconImage(icon.getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(530,430);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setBackground(new Color(238,238,238,255));
		
		arriba = new PanelSuperior(this);
		derecha = new PanelDerecha(this);
		abajo = new PanelInferior(this);
		izquierda = new PanelIzquierda(this);
		
		setLayout(new BorderLayout());
		add(arriba,BorderLayout.NORTH);
		add(derecha,BorderLayout.EAST);
		add(abajo,BorderLayout.SOUTH);
		add(izquierda,BorderLayout.WEST);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new InterfazTablero();
	}
}
