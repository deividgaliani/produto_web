package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.Produto;

public class ProdutoDAO implements IProdutoDAO {

	public List<Produto> recuperarTodos() {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ")
		   .append(" 		prd.ID \"ID\" ")
		   .append(" 		prd.NOME \"NOME\" ")
		   .append(" 		prd.DESCRICAO \"DESCRICAO\" ")
		   .append("		prd.VALOR \"VALOR\" ")
		   .append("		prd.CATEGORIA \"CATEGORIA\" ")
		   .append(" FROM PRODUTO prd ")
		   .append(" INNER JOIN CATEGORIA cat ON cat.id = prd.id_categoria ");
		
		try {
			Connection conn = ConnectionMySQL.getConexaoMySQL();
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Produto recuperarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Produto alterar(Produto produto) {
		// TODO Auto-generated method stub
		return null;
	}

	public Produto excluir(Produto produto) {
		// TODO Auto-generated method stub
		return null;
	}

	public void insere(Produto produto) {		
		try {
			Connection conn = ConnectionMySQL.getConexaoMySQL();
			String sql = " INSERT INTO PRODUTO(NOME, DESCRICAO, VALOR, ID_CATEGORIA) VALUES(?, ?, ?, ?) ";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, produto.getNome());
			statement.setString(2, produto.getDescricao());
			statement.setDouble(3, produto.getValor());
			statement.setInt(4, produto.getCategoria());
			statement.execute(); //atencao
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}	

}