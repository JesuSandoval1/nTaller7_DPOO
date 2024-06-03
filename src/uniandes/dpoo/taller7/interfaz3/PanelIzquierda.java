package uniandes.dpoo.taller7.interfaz3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class PanelIzquierda extends JPanel {
	
    private int rows = 3;
    private int cellSize;
    
    private InterfazTablero padre;

    public PanelIzquierda(InterfazTablero papa) {
    	padre = papa;
    	setPreferredSize(new Dimension(350, 350));
		setBackground(new Color(238, 238, 238, 255));
        cellSize = 350/rows;
        setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
            	g2d.setColor(new Color(255,255,0,255));
                int x = j * cellSize;
                int y = i * cellSize;
                g2d.fillRect(x, y, cellSize, cellSize);
                g2d.setColor(Color.GRAY);
                g2d.drawRect(x, y, cellSize, cellSize);
            }
        }
    }
}