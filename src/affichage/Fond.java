package affichage;

import java.awt.Panel;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.io.*;


public class Fond extends Panel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage mon_image=null;

	public Fond(String chemin_image)
	{
		try
		{
			mon_image=ImageIO.read(new File(chemin_image));
		}
		catch (IOException e)
		{
			System.out.println("erreur lors de la lecture du fichier");
		}
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		g.drawImage(mon_image,0,0, null);
	}
	
	
	
}