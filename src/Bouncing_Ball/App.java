package Bouncing_Ball;


import javax.swing.SwingUtilities;

public class App{	

	public static void main(String[] args) {
		
	SwingUtilities.invokeLater(new Runnable() {
		
		@Override
		public void run() {
			new Frame_Ball();
			
		}
	});
		
	}

}
