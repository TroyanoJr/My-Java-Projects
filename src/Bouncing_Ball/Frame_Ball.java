package Bouncing_Ball;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class Frame_Ball extends JFrame{

	
	private static final long serialVersionUID = 1L;
	private JButton addButton;
	//private JPanel panel;
	
	Frame_Ball()
	{
		
		
		//Frame congig
		super("Bouncing Ball");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,600);
		setVisible(true);
		setLocationRelativeTo(null);
		setBackground(Color.white);
		
		//panel ball config
		
		//add Button config
		addButton = new JButton("Add Ball");
		addButton.setFont(new Font("Ink Free", Font.BOLD,25));
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//panel.add(new Ball());
				
				add(new Ball());
				repaint();
				revalidate();
				//add(panel);
				
			}
		});
		
		
		
		//add Component 
		add(addButton,BorderLayout.SOUTH);
		
		//add(new Ball());
		
	}
	

}
