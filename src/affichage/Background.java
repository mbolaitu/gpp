package affichage;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Background extends JPanel
 {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage image = null;
	private int positionX;
	private int positionY;
	private int largeur;
	private int hauteur;
	
	public Background(JFrame f,String chemin,int x,int y,int l,int h) 
	{
		try 
		{
			image=ImageIO.read(new File(chemin));
			positionX = x;
			positionY = y;
			largeur = l;
			hauteur = h;
			this.setOpaque(true);
			this.setLayout(null);
			f.setContentPane(this);
			this.revalidate();
			
		} catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		g.drawImage(image,positionX,positionY,largeur,hauteur,null);
	}
	

}
