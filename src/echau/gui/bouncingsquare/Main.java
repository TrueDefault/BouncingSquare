package echau.gui.bouncingsquare;

import javax.swing.SwingUtilities;

/**
 * The class that program execution starts in.
 * <br>
 * <br>
 * <b>Last modified:</b> 21 October 2017
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
