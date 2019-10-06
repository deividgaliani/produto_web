<div id="modalAlterarProduto" class="modal" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Alterar produto</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <style>
			label{
			    font-weight: bold;
			}
		</style>
        <form id="formProduto" class="col col-12">
          <input type="hidden" class="form-control" id="idProduto" name="idProduto" placeholder="Nome">
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
		</form>
      </div>
      <div class="modal-footer">
        <div class="col col-12" style="text-align: right;">
			  <button type="button" id="btnInserirProduto" class="btn btn-primary">Alterar</button>
		  </div>
      </div>
    </div>
  </div>
</div>
<script src="./js/jquery.mask.min.js"></script>
<script src="./js/produto/cadastroProduto.js"></script>