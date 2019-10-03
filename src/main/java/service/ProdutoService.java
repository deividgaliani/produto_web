package service;

import java.util.List;

import dao.IProdutoDAO;
import dao.ProdutoDAO;
import model.Produto;
import servlet.ProdutoVO;

public class ProdutoService implements IProdutoService {
	
	private IProdutoDAO produtoDAO;

	public void salvar(Produto produto) {
		if(produto.getId() == null) {
			getProdutoDAO().insere(produto);
		}else {
			getProdutoDAO().alterar(produto);
		}
	}

	public List<ProdutoVO> recuperarTodos() {
		return getProdutoDAO().recuperarTodos();
	}
	
	public IProdutoDAO getProdutoDAO() {
		if (produtoDAO == null) {
			produtoDAO = new ProdutoDAO();
		}
		return produtoDAO;
	}

}
