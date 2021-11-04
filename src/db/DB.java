package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {
	//abrindo a conexao
	
	private static Connection conn = null;
	public static Connection getConnection() {
	
		if(conn == null) {
		try {
		Properties props = loadProperties();
		String url = props.getProperty("dburl");
		conn = DriverManager.getConnection(url,props);
		}catch(SQLException e){
			throw new DbException(e.getMessage());
		}
			}
		
		
		return conn;
		
		
	}
	
	//fechando conex�o
	
	
	public static void closeConnection() {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

	}
	
	
	//carrega os arquivos 
	private static Properties loadProperties() {
		
		try(FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(fs);
			return props;
			
		}catch(IOException e) {
			throw new DbException(e.getMessage());
		}
	 }
	//fechar minhas variavel de conex�o de execu��o de comandos sql
	public static void closeStatement(Statement st) {
		if(st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		
	}
	//fechar minhas variavel de conex�o  de comandos recupera��o sql
		public static void closeResultSet(ResultSet rs) {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new DbException(e.getMessage());
				}
			}
			
		}
		
	

	
	
	
}
