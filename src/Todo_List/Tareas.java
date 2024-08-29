package Todo_List;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class Tareas extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JCheckBox checkBox;
	private JTextPane textfield;
	private JButton removeButton;
	
	public JTextPane getTextfield() {
		return textfield;
	}

	private JPanel parentPanel;
	
	public Tareas(JPanel panel) {
		
		//checkbox config
		//setBackground(Color.yellow);
		parentPanel=panel;
		
		checkBox = new JCheckBox();
		checkBox.setPreferredSize(new Dimension(20,50));
		checkBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		checkBox.addActionListener(this);
		
		//textfiel config
		textfield = new JTextPane();
		textfield.setFont(new Font("Ink Free",Font.BOLD,25));
		textfield.setPreferredSize(new Dimension(450,40));
		textfield.setContentType("text/html");
		textfield.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				textfield.setBackground(null);
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				textfield.setBackground(Color.white);
				
			}
		});
		
		
		//removeButton confit
		removeButton = new JButton("x");
		removeButton.setPreferredSize(new Dimension(50,35));
		removeButton.setFont(new Font("Ink Free",Font.BOLD,30));
		removeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		removeButton.addActionListener(this);
		
		//add Component to the panel
		add(checkBox);
		add(textfield);
		add(removeButton);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//checkbox event
		if(checkBox.isSelected())
		{
			//raplaces all html tags to empty string to grab the main text
			String taskTExt = textfield.getText().replaceAll("<[^>]*>","");
			
			
			//add StrikeThought text
			textfield.setText("<html><s>"+taskTExt+"</s></html>");
			

		}
		else if(!checkBox.isSelected())
		{
			String taskTExt = textfield.getText().replaceAll("<[^>]*>","");
			
			textfield.setText(taskTExt);
			
		}
		//remove button event
		if(e.getSource()==removeButton)
		{
			parentPanel.remove(this);
			parentPanel.repaint();
			parentPanel.revalidate();
			
		}
		
	}
	

}
