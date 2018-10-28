package bahti.gui;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class Gui extends JComponent{
	
	public JFrame gui;
	public int width;
	public int height;
	public String title;
	
	public Gui(int width, int height, String title){
        this.width = width;
        this.height = height;
        this.title = title;
    }
	
	public void createGui() {
            gui = new JFrame(this.title);
            gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gui.setPreferredSize(new Dimension(width,height));
            gui.getContentPane().add(this);
            gui.setResizable(false);
	}
	
	public void finishGui() {
		gui.pack();
		gui.setLocationRelativeTo(null);
		repaint();
	}
	
	public void reveal() {
		gui.setVisible(true);
	}
	
	public void conceal() {
		gui.setVisible(false);
	}
	
	public void onTick() {
		
	}
	
	public BufferedImage loadImage(String path){
        try{
        	System.out.println(getClass().getClassLoader().getResource(path));
            return ImageIO.read(getClass().getResource(path));
        }catch (IOException e) {
            return null;
        }
    }
}
