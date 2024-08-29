package Todo_List;



import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;


public class Marco_Tareas extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel bannerJLabel;
	private JButton addTaskButton;
	private JPanel taskPanel,taskComponentPanel;

	
	
	
	 public Marco_Tareas() {
		 super("Todo List app");
		 
		 //Windows config
		 //setSize(600,600);
		 setPreferredSize(new Dimension(600,600));
		 pack();
		 setLocationRelativeTo(null);
		 //setVisible(true);
		 setLayout(null);
		 setResizable(false);
		
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		 //pack();
		 
		 //add component to the panel
		taskPanel = new JPanel();
		//taskPanel.setBackground(Color.yellow);
		
		taskComponentPanel = new JPanel();
		taskComponentPanel.setLayout(new BoxLayout(taskComponentPanel, BoxLayout.Y_AXIS));
			
		taskPanel.add(taskComponentPanel); 
		 
		 //Banner of app
		 //bannerDimension = new Dimension(100,30);
		 bannerJLabel = new JLabel("Todo List app");
		 bannerJLabel.setBounds(180,10,200,50);
		 bannerJLabel.setFont(new Font("Ink Free",Font.BOLD,30));
		 
		//add scrolling to the task panel
		JScrollPane scrollPane = new JScrollPane(taskPanel);
		scrollPane.setBorder(BorderFactory.createLoweredBevelBorder());
		scrollPane.setBounds(10,50,565,450);
		scrollPane.setMaximumSize(new Dimension(580,480));
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		//add a Vertical ScrollBar
		JScrollBar VerticalScrollbar = scrollPane.getVerticalScrollBar();
		VerticalScrollbar.setUnitIncrement(20);
		
		
		
		 
		 //Add task Button config
		 addTaskButton = new JButton("add Task");
		 addTaskButton.setBounds(180,510,120,40);
		 addTaskButton.setFont(new Font("Ink Free",Font.BOLD,20));
		 addTaskButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		 addTaskButton.addActionListener(this);
		 
		
		 
		 //Add Component to the windows
		 add(bannerJLabel);
		 add(scrollPane);
		 add(addTaskButton);
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==addTaskButton)
		{
			
			//Add a task to taskFrame
			Tareas tareasComponnets = new Tareas(taskComponentPanel);
			taskComponentPanel.add(tareasComponnets);
			
			//make the task field request focus after creation
			tareasComponnets.getTextfield().requestFocus();
			
			repaint();
			revalidate();
		}
		
		
		if(taskComponentPanel.getComponentCount()>1)
		{
			Tareas previousTask = (Tareas) taskComponentPanel.getComponent(taskComponentPanel.getComponentCount()-2);
			
			previousTask.getTextfield().setBackground(null);
					
		}
		
		
	}
	

}
