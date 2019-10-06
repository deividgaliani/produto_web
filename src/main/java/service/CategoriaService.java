package service;

import java.util.List;

import dao.CategoriaDAO;
import dao.ICategoriaDAO;
import model.Categoria;
import servlet.CategoriaVO;

public class CategoriaService implements ICategoriaService {
	
	private ICategoriaDAO categoriaDAO = new CategoriaDAO();

	public List<CategoriaVO> recuperarCategorias() {
		return getCategoriaDAO().recuperarCategorias();
	}

	public void salvar(Categoria categoria) {
		if(categoria.getId() == null) {
			getCategoriaDAO().insere(categoria);
		}else {
			getCategoriaDAO().alterar(categoria);
		}
	}
	
	public ICategoriaDAO getCategoriaDAO() {
		return categoriaDAO;
	}

}
