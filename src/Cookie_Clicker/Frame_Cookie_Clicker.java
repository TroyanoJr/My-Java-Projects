package Cookie_Clicker;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Frame_Cookie_Clicker extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Frame_Cookie_Clicker() {
		super("Cookie Clicker!");
		setPreferredSize(new Dimension(500,500));
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		
	}

}
