package echau.gui.bouncingsquare;

import javax.swing.SwingUtilities;

/**
 * The class that program execution starts in.
 * <br>
 * <br>
 * This program runs a GUI of a square bouncing around inside a window and changing colours
 * each time it hits the edge of the window.
 * 
 * @author Eugene Chau
 * @version 1.0
 */
public class Main {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Gui().initGui();
			}
		});
	}
}
