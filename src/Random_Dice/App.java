package Random_Dice;

import javax.swing.SwingUtilities;

public class App {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new Rolling_Dice_GUI().setVisible(true);
				
			}
		});
	}

}
