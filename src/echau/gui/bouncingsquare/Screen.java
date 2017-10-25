package echau.gui.bouncingsquare;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**
 * The Screen (a JPanel) is the part of the window that the square bounces around in.
 * <br>
 * <br>
 * <b>Last modified:</b> 21 October 2017
 * 
 * @author Eugene Chau
 * @version 1.0
 */
public class Screen extends JPanel {
	/* Constants */
	
	/** Default serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	/** Width of the Screen */
	private static final int WIDTH = 800;
	
	/** Height of the Screen */
	private static final int HEIGHT = 600;
	
	/** Side length of the square */
	private static final int SIDE_LENGTH = 50;
	
	/** The space character: ' ' */
	private static final char SPACE = ' ';
	
	/** The colours that can be applied to the square */
	private static final Color[] SQUARE_COLOURS;
	
	static {
		SQUARE_COLOURS = new Color[] {Color.WHITE, Color.RED, Color.GREEN, Color.BLUE};
	}
	
	/* Variables */
	
	/** The ActionListener that handles Timer ticks */
	private final ActionListener painter;
	
	/** The index of the SQUARE_COLOURS array corresponding to the current colour of the square */
	private int colourIndex = (int) Math.round(Math.random() * (SQUARE_COLOURS.length - 1));
	
	/** How many pixels the square travels horizontally each second */
	private int velocity_x = 2 * (Math.random() < 0.5 ? 1 : -1);
	
	/** How many pixels the square travels vertically each second */
	private int velocity_y = 2 * (Math.random() < 0.5 ? 1 : -1);
	
	/** x-coordinate of the pixel in the top-left corner of the square */
	private int xPos = (int) Math.round(Math.random() * (WIDTH - SIDE_LENGTH));
	
	/** y-coordinate of the pixel in the top-left corner of the square */
	private int yPos = (int) Math.round(Math.random() * (HEIGHT - SIDE_LENGTH));
	
	public Screen() {
		this.setBackground(Color.BLACK);
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		this.painter = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();
			}
		};
		
		this.getInputMap().put(KeyStroke.getKeyStroke(SPACE), "changeColour");
		this.getActionMap().put("changeColour", new AbstractAction() {
			/** Default serialVersionUID */
			private static final long serialVersionUID = 1L;
			
			@Override
			public void actionPerformed(ActionEvent e) {
				changeColourIndex();
			}
		});
	}
	
	/**
	 * Draws and paints the square, and updates its position.
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(SQUARE_COLOURS[colourIndex]);
		g.fillRect(xPos, yPos, SIDE_LENGTH, SIDE_LENGTH);
		
		// Updates the square's position
		xPos += velocity_x;
		yPos += velocity_y;
				
		// If square hits the left or right edges of the screen
		if (xPos <= 0) {
			xPos = 0;
			velocity_x *= -1;
			changeColourIndex();
		} else if (xPos >= WIDTH - SIDE_LENGTH + 1) {
			xPos = WIDTH - SIDE_LENGTH + 1;
			velocity_x *= -1;
			changeColourIndex();
		}
		
		// If square hits the top or bottom edges of the screen
		if (yPos <= 0) {
			yPos = 0;
			velocity_y *= -1;
			changeColourIndex();
		} else if (yPos >= HEIGHT - SIDE_LENGTH + 1) {
			yPos = HEIGHT - SIDE_LENGTH + 1;
			velocity_y *= -1;
			changeColourIndex();
		}
	}
	
	/**
	 * If the {@link #colourIndex} variable currently represents the index of the last element in the
	 * {@link #SQUARE_COLOURS} array, resets colourIndex to 0. Otherwise, increments colourIndex by 1.
	 */
	public void changeColourIndex() {
		if (colourIndex == SQUARE_COLOURS.length - 1) {
			colourIndex = 0;
		} else {
			colourIndex++;
		}
	}
	
	/**
	 * @return The ActionListener that paints the square.
	 */
	public ActionListener getPainter() {
		return this.painter;
	}
}
