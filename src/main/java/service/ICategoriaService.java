package service;

import java.util.List;

import model.Categoria;
import servlet.CategoriaVO;

public interface ICategoriaService {

	public List<CategoriaVO> recuperarCategorias();
	
	public void salvar(Categoria categoria);
	
}
