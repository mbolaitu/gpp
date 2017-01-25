package ecouteur;
import affichage.*;
import java.awt.event.*;
import java.awt.*;

public class EcouteurMessage implements ActionListener,WindowListener
{
	private Message window;

	public EcouteurMessage(Message f)
	{
		this.window=f;
	}
	
	public void actionPerformed(ActionEvent act)
	{
		if(act.getSource()==window.getok())
		{
			window.dispose();
		}
	}

	public void windowActivated(WindowEvent e)
	{}
	public void windowClosed(WindowEvent e)
	{}
	public void windowClosing(WindowEvent e)
	{
		window.dispose();
	}
	public void windowDeactivated(WindowEvent e)
	{}
	public void windowDeiconified(WindowEvent e)
	{}
	public void windowIconified(WindowEvent e)
	{}
	public void windowOpened(WindowEvent e)
	{}
}