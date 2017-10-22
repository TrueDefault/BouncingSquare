package echau.gui.bouncingsquare;

import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * The Gui (a JFrame) consists of the {@link Screen} and the window borders.
 * <br>
 * <br>
 * <b>Last modified:</b> 21 October 2017
 * 
 * @author Eugene Chau
 * @version 1.0
 */
public class Gui extends JFrame {
	private static final long serialVersionUID = 1L;
	
	/** How many times the Timer ticks each second */
	private static final int FPS = 60;
	
	/**
	 * Sets up the GUI window and starts the Timer, which ticks every 1000 / FPS seconds.
	 */
	public void initGui() {
		final Screen screen = new Screen();
		this.add(screen);
		this.setResizable(false);
		this.pack();
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setTitle("Bouncing Square");
		this.setVisible(true);
		new Timer((int) 1000 / FPS, screen.getPainter()).start();
	}
}
