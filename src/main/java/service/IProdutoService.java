package service;

import java.util.List;

import model.Produto;

public interface IProdutoService {

	public void salvar(Produto produto);
	
	public List<Produto> recuperarTodos();
	
}
