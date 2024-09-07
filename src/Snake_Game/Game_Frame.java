package Snake_Game;

import javax.swing.JFrame;

public class Game_Frame extends JFrame {
	
	/****/
	private static final long serialVersionUID = 1L;

	public Game_Frame() {
		super("Snake Game!");
		this.add(new Game_Panel());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
		
		
		
	}
	

}
