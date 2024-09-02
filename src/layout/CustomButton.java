package layout;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public class CustomButton extends JButton{

	BufferedImage img;
	String path;
	
    public CustomButton(String path) {
    	this.path = path;
    	
    	setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
    	setBackground(null);
    	setOpaque(false);
    	setBorderPainted(false);
    	setFocusPainted(false);
    	setContentAreaFilled(false);
    }

    @Override
        public void paint(Graphics g) {
    		
    		super.paint(g);
    	
    	try {
			InputStream is = getClass().getResourceAsStream(path);
		    img = ImageIO.read(is);
		    
		    Graphics2D g2 = (Graphics2D) g;
	        
	        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
	        
	        g2.drawImage(img, 6, 6, this);
		   
		  } 
		 catch (Exception ex) {
			 ex.printStackTrace();
		 }
    	
        
    }


}
