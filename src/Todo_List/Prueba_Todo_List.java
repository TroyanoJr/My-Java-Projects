package Todo_List;


import java.util.Vector;

import javax.swing.SwingUtilities;

public class Prueba_Todo_List {

	public static void main(String[] args) {
	    Vector<Integer>v = new Vector<>();
		
	    
		//tareas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				new Marco_Tareas().setVisible(true);
				
			}
		});
	}

}
