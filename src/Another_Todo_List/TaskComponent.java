package Another_Todo_List;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class TaskComponent extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JCheckBox checkBox;
	private JTextPane taskField;
	private JButton deleteButton;
	
	public JTextPane getTaskField() {
		return taskField;
	}

	private JPanel parentPanel;
	
	public TaskComponent(JPanel panel)
	{
		parentPanel = panel;
		
		//task Field
		taskField = new JTextPane();
		taskField.setBorder(BorderFactory.createLineBorder(Color.black));
		taskField.setPreferredSize(CommonConstants.TASKFIELD_SIZE);
		taskField.setContentType("text/html");
		taskField.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				taskField.setBackground(null);
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				taskField.setBackground(Color.white);
				
			}
		});
		
		//CheckBox
		checkBox = new JCheckBox();
		checkBox.setPreferredSize(CommonConstants.CHECKBOX_SIZE);
		checkBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		checkBox.addActionListener(this);
		
		//Delete Button
		deleteButton = new JButton("X");
		deleteButton.setPreferredSize(CommonConstants.DELETEBUTTON_SIZE);
		deleteButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		deleteButton.addActionListener(this);
		
		//add to this taskComponent
		add(checkBox);
		add(taskField);
		add(deleteButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(checkBox.isSelected())
		{
			//raplaces all html tags to empty string to grab the main text
			String taskText = taskField.getText().replaceAll("<[^>]*>", "");
			
			//add StrikeThought text
			taskField.setText("<html><s>"+taskText+"</s></html>");
			
		}
		else if(!checkBox.isSelected())
		{
			String taskText = taskField.getText().replaceAll("<[^>]*>", "");
			
			taskField.setText(taskText);
			
		}
		
		
		if(e.getActionCommand().equalsIgnoreCase("X"))
		{
			parentPanel.remove(this);
			parentPanel.repaint();
			parentPanel.revalidate();
			
		}
		
	
	}

}
