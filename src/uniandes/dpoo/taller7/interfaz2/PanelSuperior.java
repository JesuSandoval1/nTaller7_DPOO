package uniandes.dpoo.taller7.interfaz2;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PanelSuperior extends JPanel{
	
	private InterfazTablero padre;
	
	private JComboBox<String> dimensiones;
	private JRadioButton facil;
	private JRadioButton medio;
	private JRadioButton dificil;
	
	public PanelSuperior(InterfazTablero papa) {
		super();
		setLayout(new GridLayout (1,6));
		setBackground(new Color(238,238,238,255));
		
		padre = papa;
		
		add(new JLabel("Tamaño"));
		
		dimensiones = new JComboBox<String>();
		dimensiones.addItem("3x3");
		dimensiones.addItem("5x5");
		dimensiones.addItem("7x7");
		//dimensiones.addItemListener(this);
		add(dimensiones);

		add(new JLabel("Dificultad"));
		
		facil = new JRadioButton("Fácil");
		add(facil);
		
		medio = new JRadioButton("Medio");
		add(medio);
		
		dificil = new JRadioButton("Dificil");
		add(dificil);
		
		setVisible(true);
	}
	
}
