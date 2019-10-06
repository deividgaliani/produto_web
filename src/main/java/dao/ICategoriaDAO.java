package dao;

import java.util.List;

import model.Categoria;
import servlet.CategoriaVO;

public interface ICategoriaDAO {

	public List<CategoriaVO> recuperarCategorias();
	
	public void insere(Categoria categoria);
	
	public void alterar(Categoria categoria);
}
