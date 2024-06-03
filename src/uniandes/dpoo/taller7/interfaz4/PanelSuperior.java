package uniandes.dpoo.taller7.interfaz4;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class PanelSuperior extends JPanel implements ActionListener{
	
	@SuppressWarnings("unused")
	private InterfazTablero padre;
	
	private final int FACIL = 5;
	private final int MEDIO = 10;
	private final int DIFICIL = 20;
	
	private JComboBox<String> dimensiones;
	private JRadioButton facil;
	private JRadioButton medio;
	private JRadioButton dificil;
	private ButtonGroup buttonGroup;
	private int dificultad = FACIL;
	
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
		dimensiones.addItem("9x9");
		//dimensiones.addItemListener(this);
		add(dimensiones);

		add(new JLabel("Dificultad"));
		
		facil = new JRadioButton("Fácil");
		facil.addActionListener(this);
		add(facil);
		
		medio = new JRadioButton("Medio");
		medio.addActionListener(this);
		add(medio);
		
		dificil = new JRadioButton("Dificil");
		dificil.addActionListener(this);
		add(dificil);
		
		buttonGroup = new ButtonGroup();
        buttonGroup.add(facil);
        buttonGroup.add(medio);
        buttonGroup.add(dificil);
        
        facil.setSelected(true);
		
		setVisible(true);
	}
	
	public int getDimensionTablero() {
		return Character.getNumericValue(((String) dimensiones.getSelectedItem()).charAt(0));
	}
	
	public int getDificultadTablero() {
		return dificultad;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (facil.isSelected()) {
            dificultad = FACIL;
        }else if(medio.isSelected()) {
            dificultad = MEDIO;
        }else if(dificil.isSelected()) {
            dificultad = DIFICIL;
        }
	}
	
}
