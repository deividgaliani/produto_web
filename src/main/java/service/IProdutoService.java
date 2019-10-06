package service;

import java.util.List;

import model.Produto;
import servlet.ProdutoVO;

public interface IProdutoService {

	public void salvar(Produto produto);
	
	public List<ProdutoVO> recuperarTodos();
	
	public void exluir(Integer id);
	
	public ProdutoVO recuperarPorId(Integer id);
	
}
