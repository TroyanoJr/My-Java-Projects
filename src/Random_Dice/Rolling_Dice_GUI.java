package Random_Dice;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Rolling_Dice_GUI extends JFrame{
	
	/****/
	private static final long serialVersionUID = 1L;

	Rolling_Dice_GUI()
	{
		super("Rolling Dice App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(750,700));
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		
		addComponents();
		
	}
	
	public void addComponents()
	{
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		//Banner 
		JLabel banner = new JLabel("Random Dice");
		banner.setBounds(200,40,300,70);
		banner.setFont(new Font("Ink Free",Font.BOLD,50));
		banner.setForeground(Color.blue);
		panel.add(banner);
		
		
		//Dice one
		JLabel diceOneImg = Img_Service.loadImages("Dice-1.png");
		diceOneImg.setBounds(100, 200, 200,200);
		panel.add(diceOneImg);
		
		//Dice one
		JLabel diceTwoImg = Img_Service.loadImages("Dice-1.png");
		diceTwoImg.setBounds(400, 200, 200,200);
		panel.add(diceTwoImg);
		
		//Random button
		Random random = new Random();
		
		
		JButton rollButton = new JButton("Roll!");
		rollButton.setBounds(300,500,150,50);
		rollButton.setFont(new Font("Ink Free",Font.BOLD,35));
		rollButton.setForeground(Color.blue);
		rollButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				long startTime = System.currentTimeMillis();

				rollButton.setRolloverEnabled(false);
				
				
				Thread rollThread = new Thread(new Runnable() {
					
					@Override
					public void run() {
						long endTime = System.currentTimeMillis();
						
						try {
							while((endTime - startTime)/1000F < 3)
							{
								//roll Dice
								int diceOne = 1+random.nextInt(7);
								int diceTwo = 1+random.nextInt(7);
								
								//update dice images
								Img_Service.updateDice(diceOneImg,"Dice-"+diceOne+".png");
								Img_Service.updateDice(diceTwoImg,"Dice-"+diceTwo+".png");
								
								repaint();
								revalidate();
								
								Thread.sleep(6);
								
								endTime = System.currentTimeMillis();
								
							}
							rollButton.setEnabled(true);
							
						} catch (InterruptedException e2) {
							System.out.println("Threading Error "+e);
							
						}
						
					}
				});
				rollThread.start();
				
			}
		});
		panel.add(rollButton);
		
		
		//add component to frame
		
		add(panel);
		
	}

}
