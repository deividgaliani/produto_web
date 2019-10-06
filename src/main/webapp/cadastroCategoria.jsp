<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:principal>
	<jsp:body>
		<style>
			label{
			    font-weight: bold;
			}
		</style>
        <form id="formProduto" class="col col-6">
		<h2 class="col">Cadastro Categoria</h2>
        
		  <div class="form-group col col-12">
		    <label for="descricao">Descrição</label>
		    <input type="text" class="form-control" id="descricao" name="descricao" placeholder="Descrição">
		  </div>
		  
		  <div class="col col-12" style="text-align: right;">
			  <button type="button" id="btnInserirCategoria" class="btn btn-primary">Cadastrar</button>
		  </div>
		</form>
		<script src="./js/categoria/cadastroCategoria.js"></script>
    </jsp:body>
</t:principal>