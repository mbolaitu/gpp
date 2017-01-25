package affichage;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Fenetrage extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JFrame window;
	private Image PathToIcon(String path)
	{
		ImageIcon icon=new ImageIcon(path);
		Image img=icon.getImage();
		return img;
	}
	public Fenetrage(String titre,String icon,int largeur,int hauteur,boolean menu,boolean ontop,boolean taille,boolean exit)
	{

		this.setSize(largeur,hauteur);
		this.setTitle(titre);
		this.setIconImage(this.PathToIcon(icon));
		if(menu == true)
		{
			new BarDeMenu(this);
		}
		if(exit == true)
		{
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		if(exit == false)
		{
			this.setDefaultCloseOperation(0);
		}
		this.revalidate();
		this.setAlwaysOnTop(ontop);
		this.setLocationRelativeTo(null);
		this.setResizable(taille);
		this.setVisible(true);
		Fenetrage.window = this;
	}

}
