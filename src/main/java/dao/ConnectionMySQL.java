package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMySQL {
	public static String status = "Não conectado!";
	
	public static java.sql.Connection getConexaoMySQL(){
		Connection conexao = null;
		
		try {
			String driverName = "com.mysql.jdbc.Driver";
			Class.forName(driverName);
			
			String serverName = "localhost";
			String databaseName = "produtoweb";
			String urlConection = "jdbc:mysql://" + serverName + "/" + databaseName;
			String username = "root"; 
			String password = "123456";
			conexao = DriverManager.getConnection(urlConection, username, password);
			
			if(conexao != null) {
				status = "Conectado com sucesso!";
			}
			else {
				status = "Não foi possível realizar a conexão";
			}
			return conexao;
		} catch (ClassNotFoundException e) {
			System.err.println("O Driver especificado não foi encontrado. -->" + e.getMessage());
			return null;
		}catch(SQLException ex) {
			System.err.println("Não foi possível conectar ao Banco de Dados. -->" + ex.getMessage());
			return null;
		}catch (Exception exc) {
			System.err.println("Erro não especificado. -->" + exc.getMessage());
			return null;
		}
	}
	
	public static String statusConexao() {
		return status;
	}
	
	public static boolean fechaConexao() {
		try {
			ConnectionMySQL.getConexaoMySQL().close();
			return true;
		} catch (SQLException e) {
			System.err.println("Erro ao fechar conexão. --> " + e.getMessage());
			return false;
		}catch (Exception ex) {
			System.err.println("Erro não especificado. --> " + ex.getMessage());
			return false;
		}
	}

	public static java.sql.Connection reiniciaConexao(){
		fechaConexao();
		return getConexaoMySQL();
	}
}
