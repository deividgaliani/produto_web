package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
	
	private IProdutoService produtoService = new ProdutoService();
       
    public ProdutoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResultadoOperacao<ProdutoVO> resultado = new ResultadoOperacao<ProdutoVO>();
		Gson gson = new GsonBuilder().create();
		try {
			List<ProdutoVO> produtos = getProdutoService().recuperarTodos();
			resultado.setDados(produtos);
			resultado.setSucesso(Boolean.TRUE);
		}catch (Exception e) {
			resultado.setSucesso(Boolean.FALSE);
			resultado.setMensagem(e.getMessage());
		}
		String json = gson.toJson(resultado);
		response.getWriter().write(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResultadoOperacao<ProdutoVO> resultado = new ResultadoOperacao<ProdutoVO>();
		Gson gson = new GsonBuilder().create();
		try {
			String acao = request.getParameter("acao");
			if(acao.equals("salvar")) {
				salvarProduto(request, resultado);
			}else if(acao.equals("excluir")) {
				excluirProduto(request, resultado);
			}else if(acao.equals("buscar")) {
				Integer idProduto = request.getParameter("idProduto") != null ? Integer.parseInt(request.getParameter("idProduto")) : null;
				ProdutoVO vo = getProdutoService().recuperarPorId(idProduto);
				resultado.setDados(Arrays.asList(vo));
				resultado.setSucesso(Boolean.TRUE);
			}
		}catch (NumberFormatException nfe) {
			resultado.setSucesso(Boolean.FALSE);
			resultado.setMensagem("Campo valor inválido");
		}catch (Exception e) {
			resultado.setSucesso(Boolean.FALSE);
			resultado.setMensagem(e.getMessage());
		}
		String json = gson.toJson(resultado);
		response.getWriter().write(json);
	}

	private void excluirProduto(HttpServletRequest request, ResultadoOperacao<ProdutoVO> resultado) {
		Integer idProduto = Integer.parseInt(request.getParameter("idProduto"));
		getProdutoService().exluir(idProduto);
		resultado.setMensagem("Produto excluido com sucesso");
		resultado.setSucesso(Boolean.TRUE);
	}

	private void salvarProduto(HttpServletRequest request, ResultadoOperacao<ProdutoVO> resultado) {
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		Double valor = request.getParameter("valor") != null ? Double.parseDouble(request.getParameter("valor")) : null;
		Integer categoria = !request.getParameter("categoria").isEmpty() ? Integer.parseInt(request.getParameter("categoria")) : null;
		Integer idProduto = request.getParameter("idProduto") != null ? Integer.parseInt(request.getParameter("idProduto")) : null;
		Produto produto = new Produto(idProduto, nome, descricao, valor, categoria);
		getProdutoService().salvar(produto);
		resultado.setMensagem("Produto persistido com sucesso");
		resultado.setSucesso(Boolean.TRUE);
	}
	
//	private void salvar(Produto produto, HttpSession session) {
//		List<Produto> listaProdutos = getListaProdutosFromSession(session);
//		listaProdutos.add(produto);
//		setListaProdutos(listaProdutos, session);
//	}
//	
//	private List<Produto> getListaProdutosFromSession(HttpSession session) {
//		List<Produto> listaProdutos = (List<Produto>) session.getAttribute("listaProdutos");
//		if(listaProdutos == null) {
//			listaProdutos = new ArrayList<Produto>();
//			session.setAttribute("listaProdutos", listaProdutos);
//		}
//		return listaProdutos;
//	}
	
//	private void setListaProdutos(List<Produto> listaProdutos, HttpSession session) {
//		session.setAttribute("listaProdutos", listaProdutos);
//	}
	
	public IProdutoService getProdutoService() {
		return produtoService;
	}

}
