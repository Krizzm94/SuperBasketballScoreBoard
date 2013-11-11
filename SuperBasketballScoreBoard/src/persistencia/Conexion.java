package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;

public class Conexion {
	

	private Connection conexion;
	private final String DRIVER ="com.mysql.jdbc.Driver";
	private final String URL ="jdbc:mysql://localhost:3306/*****";
	private final String USER = "root";
	private final String PASSWORD= "";
	
	
	
	public Conexion(){
	}
	
	
		public boolean conectarBD(){
			boolean resp = false;
			try{
				Class.forName(DRIVER).newInstance();
				conexion=DriverManager.getConnection(URL, USER, PASSWORD);
	
			}catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			catch (InstantiationException e) {
				System.out.println(e.getMessage());
			}
			catch (IllegalAccessException e) {
				System.out.println(e.getMessage());
			}
			catch (ClassNotFoundException e) {
				System.out.println(e.getMessage());
			}
			resp=true;
			return resp;
			
		}
		
		public void close(){
			try {
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public Connection getConexion() {
			return conexion;
		}


		public Statement createStatement() {
			// TODO Auto-generated method stub
			return null;
		
		}


	
	}

