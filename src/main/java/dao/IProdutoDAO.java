package dao;

import java.util.List;

import model.Produto;
import servlet.ProdutoVO;

public interface IProdutoDAO {

	public List<ProdutoVO> recuperarTodos();
	
	public ProdutoVO recuperarPorId(Integer id);
	
	public void alterar(Produto produto);
	
	public void excluir(Integer id);
	
	public void insere(Produto produto);
	
}
