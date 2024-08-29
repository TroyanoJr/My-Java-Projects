package Another_Todo_List;

import javax.swing.SwingUtilities;

public class App {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new Todo_List_Gui().setVisible(true);
				
			}
		});
	}

} 
