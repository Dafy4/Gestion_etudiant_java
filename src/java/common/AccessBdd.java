/*RAFIERENANA Henintsoa David*/
package common;
import java.sql.Connection;
import java.sql.DriverManager;	//jbc sql connector 
import java.sql.ResultSet;		//Résultat des reqêttes SQL
import java.sql.SQLException; 	//Erreur
import java.sql.Statement; 		//Prend ligne par ligne
import java.util.Collection;

import config.Config;
public class AccessBdd 
{
	private String 		driver 			= null;			//Ex : "oracle.jdbc.OracleDriver"
	private String 		url 			= null; 		//Ex : "jdbc:oracle:thin:@192.168.200.91:1521:DATA10G";
	private String 		user 			= null;
	private String 		password 		= null;
	private Connection 	conn 			= null;
	private ResultSet 	resultSet 		= null;			//Résultat des reqêttes SQL
	
	public AccessBdd()
	{
		Config	config	=	new Config() ;
		this.driver 	= 	config.driver;
		this.url 	= 	config.url;
		this.user 	= 	config.user;
		this.password 	= 	config.password;
	}
	/**
	 * @param args
	 */
	public void loadDriver() 
	{
		try
		{
			//chargement Driver
			Class.forName(driver);
		}
		catch(ClassNotFoundException e) //Dans le cas ou il ne trouve pas le driver
		{
			System.err.println("Driver non trouv�");
		}
		catch(Exception e) //Trouve le driver mais il y une erreur dans user, url,password , etc
		{
			e.printStackTrace();
		}
	}

	public Connection getConnection() //Connection : une classe , la valeur e type de retour est un ogbet
	{
		if (conn == null)
		{
			try
			{
				//Connexion
				conn = DriverManager.getConnection(url, user, password);
			}
			catch(SQLException e)
			{
				System.err.println("Probl�me de connexion  : "+ e.getMessage()); //Quand apache ne fonctionne pas
			}
		}
		else
		{
			try 
			{
				if (conn.isClosed())
					conn = DriverManager.getConnection(url, user, password);
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return conn;
	}
	
	public ResultSet executeSelect(String sql)//ResultSet : tableau 
	{	//executeSelect : code Select SQL
		Statement statement;
		try {
			if (resultSet != null)
				resultSet.close();
			statement = getConnection().createStatement();
			resultSet = statement.executeQuery(sql);
			
			return resultSet ;
		} 
		catch (SQLException e) { //Executer si il y une erreur de syntaxe SQL
			throw new RuntimeException(e);
		}
	}
	
	public void executeUpdate(String sql) //update SQL
	{
		Statement statement;
		try {
			statement = getConnection().createStatement();
			statement.executeUpdate(sql);
		} 
		catch (SQLException e) { //Erreur dans le code SQL
			throw new RuntimeException(e);
		}
	}
	
	public void closeConnection()
	{	//Rompt la connexion et rend null toutes les variables
		try 
		{
			if (resultSet != null)
				resultSet.close();
			if (conn != null)
				conn.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
