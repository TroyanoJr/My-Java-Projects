package Random_Dice;

import java.awt.image.BufferedImage;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Img_Service {
	
	public static JLabel loadImages(String filepath) {
		BufferedImage image;
		JLabel imageContainer;
		
		try {
			InputStream inputStream = Img_Service.class.getResourceAsStream(filepath);
			image = ImageIO.read(inputStream);
			imageContainer = new JLabel(new ImageIcon(image));
			
			return imageContainer;
			
		} catch (Exception e) {
			System.out.println("Error "+e);
			return null;
		}
	}
	
	public static void updateDice(JLabel imageContainer,String filPath)
	{
		BufferedImage image;
		
		try {
			InputStream inputStream = Img_Service.class.getResourceAsStream(filPath);
			image = ImageIO.read(inputStream);
			
			imageContainer.setIcon(new ImageIcon(image));
			
			
		} catch (Exception e) {
				System.out.println("Error "+e);
		}
	}

}
