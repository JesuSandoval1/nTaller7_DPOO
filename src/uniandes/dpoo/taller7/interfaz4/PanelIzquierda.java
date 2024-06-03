package uniandes.dpoo.taller7.interfaz4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelIzquierda extends JPanel implements MouseListener {
	
	private boolean[][] board;
	
    private int rows = 9;
    private int cellSize;
    private Image image;
    
    private InterfazTablero padre;

    public PanelIzquierda(InterfazTablero papa) {
    	padre = papa;
    	setPreferredSize(new Dimension(350, 350));
		setBackground(new Color(238, 238, 238, 255));
        addMouseListener(this);
        cellSize = 350/rows;
        loadImages();
        iniciarTablero();
        setVisible(true);
    }

    private void iniciarTablero() {
    	board = new boolean[rows][rows];
    	for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                board[i][j] = true;
            }
    	}
    }

    public void setBoard(boolean[][] board) {
		this.board = board;
	}
    
    public void setRows(int i) {
    	rows = i;
    	cellSize = 350/rows;
    }

	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Dibujar el tablero
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {            	
            	int x = j * cellSize;
            	int y = i * cellSize;
                if (board[i][j]) {
                	g2d.setColor(new Color(255,255,0,255));
                    g2d.fillRect(x, y, cellSize, cellSize);
                } else {
                	g2d.setColor(new Color(238, 238, 238, 255));
                    g2d.fillRect(x, y, cellSize, cellSize);
                }
                g2d.drawImage(image, x, y, cellSize, cellSize, this);
                g2d.setColor(Color.GRAY);
                g2d.drawRect(x, y, cellSize, cellSize);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int row = e.getY() / cellSize;
        int col = e.getX() / cellSize;
        if (row >= 0 && row < rows && col >= 0 && col < rows) {
            // Cambiar el valor de la celda clicada
        	padre.jugar(row, col);
            repaint();
        }
    }

    @Override 
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
    
    private void loadImages() {
    	try {
            image = ImageIO.read(new File("data/luz.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}