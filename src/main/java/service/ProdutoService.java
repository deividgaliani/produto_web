package service;

import java.util.List;

import dao.IProdutoDAO;
import dao.ProdutoDAO;
import model.Produto;
import servlet.ProdutoVO;

public class ProdutoService implements IProdutoService {
	
	private IProdutoDAO produtoDAO = new ProdutoDAO();

	public void salvar(Produto produto) throws RuntimeException{
		if(produto.getId() == null) {
			getProdutoDAO().insere(produto);
		}else {
			getProdutoDAO().alterar(produto);
		}
	}
	
	public List<ProdutoVO> recuperarTodos() throws RuntimeException{
		return getProdutoDAO().recuperarTodos();
	}
	
	public void exluir(Integer id) {
		getProdutoDAO().excluir(id);
	}
	
	public ProdutoVO recuperarPorId(Integer id) {
		return getProdutoDAO().recuperarPorId(id);
	}
	
	public IProdutoDAO getProdutoDAO() {
		return produtoDAO;
	}

	
}
