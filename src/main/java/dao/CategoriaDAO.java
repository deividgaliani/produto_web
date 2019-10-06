package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Categoria;
import servlet.CategoriaVO;

public class CategoriaDAO implements ICategoriaDAO {

	public List<CategoriaVO> recuperarCategorias() {
		List<CategoriaVO> categoriasVO = new ArrayList<CategoriaVO>();
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ")
		   .append(" 		cat.ID \"ID\", ")
		   .append(" 		cat.DESCRICAO \"DESCRICAO\" ")
		   .append(" FROM CATEGORIA cat ");
		
		try {
			Connection conn = ConnectionMySQL.getConexaoMySQL();
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Integer id = rs.getInt("ID");
				String descricao = rs.getString("DESCRICAO");
				CategoriaVO vo = new CategoriaVO(id, descricao);
				categoriasVO.add(vo);		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categoriasVO;
	}

	public void insere(Categoria categoria) {
		try {
			Connection conn = ConnectionMySQL.getConexaoMySQL();
			String sql = " INSERT INTO CATEGORIA(DESCRICAO) VALUES(?) ";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, categoria.getDescricao());
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	

	}

	public void alterar(Categoria categoria) {
		// TODO Auto-generated method stub
		
	}

}
