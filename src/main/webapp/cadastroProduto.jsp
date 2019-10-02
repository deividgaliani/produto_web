<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:principal>
	<jsp:body>
		<h2>Cadastro produto</h2>
        <form id="formProduto">
        
		  <div class="form-group col col-6">
		    <label for="nome">Nome</label>
		    <input type="text" class="form-control" id="nome" name="nome" placeholder="Nome">
		  </div>
		  
		  <div class="form-group col col-6">
		    <label for="descricao">Descrição</label>
		    <input type="text" class="form-control" id="descricao" name="descricao" placeholder="Descrição">
		  </div>
		  
		  <div class="form-group col col-6">
		    <label for="valor">Valor</label>
		    <input type="text" class="form-control" id="valor" name="valor" placeholder="Valor">
		  </div>
		  
		  <div class="form-group col col-6">
		  	 <label for="categoria">Categoria</label>
		    <select class="form-control" id="categoria" name="categoria">
		    	<option  value="">Selecione</option>
		    	<option  value="1">Limpeza</option>
		    	<option  value="2">Eletronico</option>
		    </select>
		  </div>
		  
		  <div class="col col-6">
			  <button type="button" id="btnInserirProduto" class="btn btn-primary">Cadastrar</button>
			  <button type="button" id="limparFormulario" class="btn btn-danger">Limpar</button>
		  </div>
		</form>
		<script src="./js/jquery.mask.min.js"></script>
		<script src="./js/produto/cadastroProduto.js"></script>
    </jsp:body>
</t:principal>