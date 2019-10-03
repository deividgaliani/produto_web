package dao;

import java.util.List;

import model.Produto;
import servlet.ProdutoVO;

public interface IProdutoDAO {

	public List<ProdutoVO> recuperarTodos();
	
	public Produto recuperarPorId(Integer id);
	
	public Produto alterar(Produto produto);
	
	public Produto excluir(Produto produto);
	
	public void insere(Produto produto);
	
}
