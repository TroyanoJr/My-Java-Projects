package Loading_Bar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class Loading_Bar_GUI extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//folder path of the files that we are going to delete
	public static final String FOLDER_PATH = "files";
	
	
	Loading_Bar_GUI()
	{
		super("Deletes Files");
		
		setSize(563,392);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLocationRelativeTo(null);
		
		addGuiComponents();
	}
	
	private void addGuiComponents()
	{
		 JButton deleteButton = new JButton("Delete Files");
		 
		 deleteButton.setFont(new Font("Dialog",Font.BOLD,48));
		 deleteButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		 //perform action when button is clicked
		 deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//store Folder reference
				File folderFile = new File(FOLDER_PATH);
				
				//check to see if the Folder var actually holds reference to a folder
				if(folderFile.isDirectory())
				{
					System.out.println("Entro");
					//store all the files an array
					File[] files = folderFile.listFiles();
					
					//only delete files if there are files in the folder
					if(files.length > 0)
					{
						System.out.println("Entro");
						deleteFiles(files);
						
					}
					else {
						showResultDialog("No Files to deleted");
					}
				}
				
			}
		});
		 add(deleteButton,BorderLayout.CENTER);
		
	}
	
	private void showResultDialog(String message)
	{
		JDialog resultDialog = new JDialog(this,"Result",true);
		resultDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		resultDialog.setSize(306,150);
		resultDialog.setLocationRelativeTo(this);
		
		//Message Label
		JLabel messageJLabel = new JLabel(message);
		messageJLabel.setFont(new Font("Dialog",Font.BOLD,26));
		messageJLabel.setHorizontalAlignment(SwingUtilities.CENTER);
		resultDialog.add(messageJLabel,BorderLayout.CENTER);
		
		//Confirm Button
		JButton confirmButton = new JButton("Confirm");
		confirmButton.setFont(new Font("Dialog",Font.BOLD,18));
		confirmButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				resultDialog.dispose();
				
			}
		});
		
		resultDialog.add(confirmButton,BorderLayout.SOUTH);
		resultDialog.setVisible(true);
		
		
	}
	
	private void deleteFiles(File[] files)
	{
		//Create a dialog where the progress bas still be stored in
		JDialog loadingDialog = new JDialog(this,"Deleting files",true); 
		loadingDialog.setSize(300,100);
		loadingDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		loadingDialog.setLocationRelativeTo(this);
		
		//Progress Bar
		JProgressBar progressBar = new JProgressBar();
		progressBar.setFont(new Font("Dialog",Font.BOLD,18));
		
		//Change the color of the progress bar to Green
		progressBar.setForeground(Color.decode("#2c8558"));
		
		//initialize the progress bar value to 0%
		progressBar.setValue(0);
		
		//delete files Thread
		Thread deleleFilesTrThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				//calculate the run of files in the 'files' directory
				int totalFiles = files.length;
				
				//keep cont of the nnum of files thar are deleted
				int filesDeleted = 0;
				
				//keep track of the progress
				int progress;
				
				for(File file:files)
				{
					//delete files
					
					if(file.delete())
					{
						filesDeleted++;
						
						//calculate the progress
						progress = (int )(((double) filesDeleted/totalFiles)*100);
						
						try {
							Thread.sleep(60);
						} catch ( InterruptedException e) {
							e.printStackTrace();
							
						}
						
						//update progress bar
						progressBar.setValue(progress);
					}
				}
				
				//dispose the loading dialog when the progress is complete
				if(loadingDialog.isVisible())
					loadingDialog.dispose();
				
				//show result dialog
				showResultDialog("Files Deleted");
				
			}
		});
		
		//Start the delete files thread
		deleleFilesTrThread.start();
		
		//display the porcentage text not only the symbol
		progressBar.setStringPainted(true);
		
		loadingDialog.add(progressBar,BorderLayout.CENTER);
		loadingDialog.setVisible(true);
		
	}

}
