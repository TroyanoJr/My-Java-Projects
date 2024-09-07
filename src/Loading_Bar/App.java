package Loading_Bar;

import javax.swing.SwingUtilities;

public class App {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new Loading_Bar_GUI().setVisible(true);
				
			}
		});

	}

}
