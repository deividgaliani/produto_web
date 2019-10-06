package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.Categoria;
import service.CategoriaService;
import service.ICategoriaService;

@WebServlet("/categoria")
public class CategoriaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private ICategoriaService categoriaService = new CategoriaService();
       
    public CategoriaServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<CategoriaVO> categorias = getCategoriaService().recuperarCategorias();
		
		Gson gson = new GsonBuilder().create();
        String json = gson.toJson(categorias);
        
        response.getWriter().write(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String descricao = request.getParameter("descricao");
			Categoria categoria = new Categoria(descricao);
			getCategoriaService().salvar(categoria);
			response.getWriter().write("Categoria inserida com sucesso");
		}catch (Exception e) {
			response.getWriter().write(e.getMessage());
		}
	}
	
	public ICategoriaService getCategoriaService() {
		return categoriaService;
	}

}
