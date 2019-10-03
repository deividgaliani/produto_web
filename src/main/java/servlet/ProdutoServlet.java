package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.Produto;
import service.IProdutoService;
import service.ProdutoService;

@WebServlet("/produto")
public class ProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IProdutoService produtoService;
       
    public ProdutoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Produto> produtos = getListaProdutosFromSession(request.getSession());
		
		Gson gson = new GsonBuilder().create();
        String json = gson.toJson(produtos);
        
        response.getWriter().write(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String nome = request.getParameter("nome");
			String descricao = request.getParameter("descricao");
			Double valor = Double.parseDouble(request.getParameter("valor"));
			Integer categoria = Integer.parseInt(request.getParameter("categoria"));
			Produto produto = new Produto(nome, descricao, valor, categoria);
			getProdutoService().salvar(produto);
//			salvar(produto, request.getSession());
			response.getWriter().write("Produto inserido com sucesso");
		}catch (Exception e) {
			response.getWriter().write(e.getMessage());
		}
		
	}
	
	private void salvar(Produto produto, HttpSession session) {
		List<Produto> listaProdutos = getListaProdutosFromSession(session);
		listaProdutos.add(produto);
		setListaProdutos(listaProdutos, session);
	}
	
	private List<Produto> getListaProdutosFromSession(HttpSession session) {
		List<Produto> listaProdutos = (List<Produto>) session.getAttribute("listaProdutos");
		if(listaProdutos == null) {
			listaProdutos = new ArrayList<Produto>();
			session.setAttribute("listaProdutos", listaProdutos);
		}
		return listaProdutos;
	}
	
	private void setListaProdutos(List<Produto> listaProdutos, HttpSession session) {
		session.setAttribute("listaProdutos", listaProdutos);
	}
	
	public IProdutoService getProdutoService() {
		if (produtoService == null) {
			produtoService = new ProdutoService();
		}
		return produtoService;
	}


}
