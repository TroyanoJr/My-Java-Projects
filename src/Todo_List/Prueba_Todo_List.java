package Todo_List;


import javax.swing.SwingUtilities;

public class Prueba_Todo_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Marco_Tareas tareas = new Marco_Tareas();
		
		//tareas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				new Marco_Tareas().setVisible(true);
				
			}
		});
	}

}
