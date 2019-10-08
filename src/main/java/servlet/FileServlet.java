package servlet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
public class FileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part file = request.getPart("imagem");
		String fileName = Paths.get(file.getSubmittedFileName()).getFileName().toString();
		
	    int dot = fileName.lastIndexOf(".");
	    String fileNameExt = fileName.substring(dot);
	    fileName = fileName.substring(0, dot);            
	    fileName = fileName.replaceAll("\\W","_");                        
	    
	    Date fecha = new Date();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");	
	    String fechaStr = (String)sdf.format((fecha));
	    
	    String savePath = System.getenv("USERPROFILE") + "\\uploads_produtoweb";
	    File uploadDir = new File(savePath);
	    if (!uploadDir.exists()) {
	    	uploadDir.mkdir();
	    }
	    String filePathName = savePath + File.separator + fechaStr +"_"+ fileName + fileNameExt;
	    file.write(filePathName);
		
	    request.getSession().setAttribute("filePath", filePathName);
	    
	    
	}

}
