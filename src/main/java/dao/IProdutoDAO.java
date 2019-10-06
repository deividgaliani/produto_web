package dao;

import java.util.List;

import model.Produto;
import servlet.ProdutoVO;

public interface IProdutoDAO {

	public List<ProdutoVO> recuperarTodos() throws RuntimeException;
	
	public Produto recuperarPorId(Integer id) throws RuntimeException;
	
	public Produto alterar(Produto produto) throws RuntimeException;
	
	public void excluir(Integer id) throws RuntimeException;
	
	public void insere(Produto produto) throws RuntimeException;
	
}
