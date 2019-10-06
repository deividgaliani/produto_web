package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Produto;
import servlet.ProdutoVO;

public class ProdutoDAO implements IProdutoDAO {

	public List<ProdutoVO> recuperarTodos(){
		List<ProdutoVO> produtosVO = new ArrayList<ProdutoVO>();
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ")
		   .append(" 		prd.ID \"ID\", ")
		   .append(" 		prd.NOME \"NOME\", ")
		   .append(" 		prd.DESCRICAO \"DESCRICAO\", ")
		   .append("		prd.VALOR \"VALOR\", ")
		   .append("		cat.DESCRICAO \"CATEGORIA\" ")
		   .append(" FROM PRODUTO prd ")
		   .append(" INNER JOIN CATEGORIA cat ON cat.id = prd.id_categoria ");
		
		try {
			Connection conn = ConnectionMySQL.getConexaoMySQL();
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Integer id = rs.getInt("ID");
				String nome = rs.getString("NOME");
				String descricao = rs.getString("DESCRICAO");
				Double valor = rs.getDouble("VALOR");
				String descricaoCategoria = rs.getString("CATEGORIA");
				ProdutoVO vo = new ProdutoVO(id, nome, descricao, valor, descricaoCategoria);
				produtosVO.add(vo);		
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao tentar buscar produtos");
		}
		return produtosVO;
	}

	public ProdutoVO recuperarPorId(Integer id){
		ProdutoVO produto = new ProdutoVO();
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ")
		   .append(" 		prd.ID \"ID\", ")
		   .append(" 		prd.NOME \"NOME\", ")
		   .append(" 		prd.DESCRICAO \"DESCRICAO\", ")
		   .append("		prd.VALOR \"VALOR\", ")
		   .append("		prd.ID_CATEGORIA \"CATEGORIA\" ")
		   .append(" FROM PRODUTO prd ")
		   .append(" WHERE prd.ID = ? ");
		
		try {
			Connection conn = ConnectionMySQL.getConexaoMySQL();
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				produto.setId(rs.getInt("ID"));
				produto.setNome(rs.getString("NOME"));
				produto.setDescricao(rs.getString("DESCRICAO"));
				produto.setValor(rs.getDouble("VALOR"));
				produto.setCategoria(rs.getInt("CATEGORIA"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao tentar buscar produtos");
		}
		return produto;
	}

	public void alterar(Produto produto){
		try {
			Connection conn = ConnectionMySQL.getConexaoMySQL();
			String sql = " UPDATE PRODUTO SET NOME = ?, DESCRICAO = ?, VALOR = ?, ID_CATEGORIA = ? WHERE ID = ? ";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, produto.getNome());
			statement.setString(2, produto.getDescricao());
			statement.setDouble(3, produto.getValor());
			statement.setInt(4, produto.getCategoria());
			statement.setInt(5, produto.getId());
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao tentar alterar produto");
		}		
	}

	public void excluir(Integer id){
		String sql = " DELETE FROM PRODUTO WHERE ID = ? ";
		try {
			Connection conn = ConnectionMySQL.getConexaoMySQL();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao tentar excluir produto");
		}
	}

	public void insere(Produto produto){		
		try {
			Connection conn = ConnectionMySQL.getConexaoMySQL();
			String sql = " INSERT INTO PRODUTO(NOME, DESCRICAO, VALOR, ID_CATEGORIA) VALUES(?, ?, ?, ?) ";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, produto.getNome());
			statement.setString(2, produto.getDescricao());
			statement.setDouble(3, produto.getValor());
			statement.setInt(4, produto.getCategoria());
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao tentar inserir produto");
		}		
	}	

}