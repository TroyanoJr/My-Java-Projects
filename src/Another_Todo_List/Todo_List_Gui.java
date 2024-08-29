package Another_Todo_List;

import java.awt.Cursor;
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

public class Todo_List_Gui extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel taskPanel,taskComponentPanel;

	public Todo_List_Gui()
	{ 
		super("Todo list Aplication");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setPreferredSize(CommonConstants.GUI_SIZE);
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);
		
		addGuiComponents();
	}
	
	private void addGuiComponents() {
		JLabel bannerLabel = new JLabel("Todo List");
		bannerLabel.setBounds(
				(CommonConstants.GUI_SIZE.width - bannerLabel.getPreferredSize().width)/2,
				15,
				CommonConstants.BANNER_SIZE.width,
				CommonConstants.BANNER_SIZE.height
				);
		
		//taskPanel
		taskPanel = new JPanel();
		
		//taskComponentPanel
		taskComponentPanel = new JPanel();
		taskComponentPanel.setLayout(new BoxLayout(taskComponentPanel, BoxLayout.Y_AXIS));
		taskPanel.add(taskComponentPanel);
		
		
		//add scrolling to the task panel
		JScrollPane scrollPane = new JScrollPane(taskPanel);
		scrollPane.setBorder(BorderFactory.createLoweredBevelBorder());
		scrollPane.setBounds(8,70,CommonConstants.TASKPANEL_SIZE.width,CommonConstants.TASKPANEL_SIZE.height);
		scrollPane.setMaximumSize(CommonConstants.TASKPANEL_SIZE);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		//scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		 
		//Change the speed of the scrollBar
		JScrollBar VerticalScrollbar = scrollPane.getVerticalScrollBar();
		VerticalScrollbar.setUnitIncrement(20);
		
		//add Button
		JButton addTaskButton = new JButton("Add Task");
		addTaskButton.setBounds(-5,CommonConstants.GUI_SIZE.height-88,CommonConstants.ADDTASKBUTTON_SIZE.width,CommonConstants.ADDTASKBUTTON_SIZE.height );
		addTaskButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addTaskButton.addActionListener(this);
		
		
		//add to frame
		this.getContentPane().add(bannerLabel);
		this.getContentPane().add(scrollPane);
		this.getContentPane().add(addTaskButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		if(command.equalsIgnoreCase("Add Task"))
		{
			//create a task Component
			TaskComponent taskComponent = new TaskComponent(taskComponentPanel);
			taskComponentPanel.add(taskComponent);
			
			//make the task field request focus after creation
			taskComponent.getTaskField().requestFocus();
			repaint();
			revalidate();
			
		}
		
		if(taskComponentPanel.getComponentCount()>1)
		{
			TaskComponent previousTask = (TaskComponent) taskComponentPanel.getComponent(taskComponentPanel.getComponentCount()-2);
			
			previousTask.getTaskField().setBackground(null);
					
		}
		
	}

}
