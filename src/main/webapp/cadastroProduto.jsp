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
		<h2 class="col">Cadastro produto</h2>
        
		  <div class="form-group col col-12">
		    <label for="nome">Nome</label>
		    <input type="text" class="form-control" id="nome" name="nome" placeholder="Nome">
		  </div>
		  
		  <div class="form-group col col-12">
		    <label for="descricao">Descrição</label>
		    <input type="text" class="form-control" id="descricao" name="descricao" placeholder="Descrição">
		  </div>
		  
		  <div class="form-group col col-12">
		    <label for="valor">Valor</label>
		    <input type="text" class="form-control" id="valor" name="valor" placeholder="Valor">
		  </div>
		  
		  <div class="form-group col col-12">
		  	 <label for="categoria">Categoria</label>
		    <select class="form-control" id="categoria" name="categoria"></select>
		  </div>
		  
		  <div class="form-group col col-12">
		    <label for="imagem">Imagem</label>
		    <input type="file" class="form-control-file" id="imagem" name="imagem">
		  </div>
		  
		  <div class="col col-12" style="text-align: right;">
			  <button type="button" id="btnInserirProduto" class="btn btn-primary">Cadastrar</button>
			  <button type="button" id="btnLimparFormulario" class="btn btn-warning">Limpar</button>
		  </div>
		</form>
		<script src="./js/jquery.mask.min.js"></script>
		<script src="./js/produto/cadastroProduto.js"></script>
    </jsp:body>
</t:principal>