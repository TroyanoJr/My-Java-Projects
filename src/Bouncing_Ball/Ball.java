package Bouncing_Ball;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Timer;
import javax.swing.JComponent;
//import javax.swing.JPanel;

public class Ball extends JComponent implements ActionListener{
	/**
	 * 
	 */
	int x=0,y=0;
	int X,Y,Z;
	int velocityX=2,velocityY=2;
	Timer timer;
	private Color color;
	private Random azar;
	
	public Color getColor() {
		return color;
	}

	private static final long serialVersionUID = 1L;

	public Ball() {
		
		//setBackground(Color.white);
		timer = new Timer(10, this);
		timer.start();
		
		azar = new Random();
		
		X= azar.nextInt(256);
		Y=azar.nextInt(256);
		Z=azar.nextInt(256);
		
		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		color = new Color(X,Y,Z);
		
		g.setColor(getColor());
		g.fillArc(x, y, 50, 50, 0, 360);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(x>=550 || x<0)
		{
			velocityX *=-1;
		}
		x = x+velocityX;
		
		if(y>=500 || y<0)
		{
			velocityY *=-1;
		}
		y = y+velocityY;
		repaint();
	}
}
