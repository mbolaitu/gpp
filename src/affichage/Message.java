package affichage;
import java.awt.*;
import ecouteur.*;
import affichage.*;
public class Message extends Frame
{
	private Label lb=new Label("",Label.CENTER);
	private Button ok=new Button("OK");
	private Frame fenetre=new Frame();
	Fond image;
	public Label getlb()
	{
		return lb;
	}
	public Button getok()
	{
		return ok;
	}
	public Message(boolean success,String message,String chemin)
	{
		image=new Fond(chemin);
		setTitle("Resultat");
		setSize(400,100);
		image.setBounds(75,25,50,50);
		image.setLayout(null);
		lb.setBounds(65,10,325,25);
		ok.setBounds(200,40,50,25);
                if(success) {
                    ok.setBackground(Color.green);
                }else {
                    ok.setBackground(Color.red);
                }
		lb.setFont(new Font("Arial Black",Font.BOLD,14));
		lb.setText(message);
		image.add(lb);
		image.add(ok);
		ok.addActionListener(new EcouteurMessage(this));
		add(image);
		setResizable(false);
		setAlwaysOnTop(true);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}