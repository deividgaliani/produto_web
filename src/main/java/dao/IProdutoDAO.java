package dao;

import java.util.List;

import model.Produto;

public interface IProdutoDAO {

	public List<Produto> recuperarTodos();
	
	public Produto recuperarPorId(Integer id);
	
	public Produto alterar(Produto produto);
	
	public Produto excluir(Produto produto);
	
	public void insere(Produto produto);
	
}
