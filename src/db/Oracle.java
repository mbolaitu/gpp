package db;
import java.sql.*;

public class Oracle
{
	public static Connection con = null;
	private static String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static String user = "gpp";
	private static String passwd = "gpp";
	private Oracle ()
	{
	}
	public static Connection getConnection()
	{
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println ("driver etablie");
		}
		catch(Exception e)
		{
			System.out.println ("erreur:Driver int"+"rouvable");
		}
		try
		{
			con =DriverManager.getConnection(url,user,passwd);
			System.out.println ("connexion base pfe etablie");
		}
		catch(Exception e)
		{
			System.out.println ("erreur: base introuvable");	
		}
		return con;
	}
}