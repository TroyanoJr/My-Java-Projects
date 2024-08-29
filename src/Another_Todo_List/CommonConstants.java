package Another_Todo_List;

import java.awt.Dimension;

public class CommonConstants {
	//Frame config
	public static final Dimension  GUI_SIZE = new Dimension(540,578);
	
	//Banner config
	public static final Dimension BANNER_SIZE = new Dimension(GUI_SIZE.width,50);
	
	//TaskConfig
	public static final Dimension TASKPANEL_SIZE= new Dimension(GUI_SIZE.width-30,GUI_SIZE.height-175);

	//add task button config
	public static final Dimension ADDTASKBUTTON_SIZE = new Dimension(GUI_SIZE.width,50); 
	
	//taskComponent Config
	public static final Dimension TASKFIELD_SIZE = new Dimension((int)(408),50);
	public static final Dimension CHECKBOX_SIZE = new Dimension((int)(TASKFIELD_SIZE.width*0.05),50);
	public static final Dimension DELETEBUTTON_SIZE = new Dimension((int)(TASKFIELD_SIZE.width*0.12),50);
	
}
