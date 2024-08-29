package Todo_List;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Prueba_BoxLayout extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JPanel panel,panel2;
	private List<JButton>botones;
	private JButton addButton;
	
	Prueba_BoxLayout()
	{
		
		
		panel = new JPanel();
		panel2 = new JPanel();
		
		botones = new ArrayList<>();
		addButton = new JButton("pulsame!");
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton boton = new JButton("hola");
				botones.add(boton);
				panel.add(boton);
				add(panel,BorderLayout.SOUTH);
				
				panel.updateUI();
				
			}
		});
		
		//add(panel);
		//add(panel2);
		add(addButton,BorderLayout.NORTH);
		
		setSize(500,500);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		Prueba_BoxLayout app = new Prueba_BoxLayout();
		
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
