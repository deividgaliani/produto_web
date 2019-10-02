$(document).ready(function() {
	getProdutos();
});

var getProdutos = function(){
	$.ajax({
		  url: "/produto_web/produto", 
		  success: function(result){
			  produtos = $.parseJSON(result);
			  adicionaDadosTabela(produtos);
		  }
	});
};

var adicionaDadosTabela = function(produtos){
	$tbl = $("#tblProduto tbody");
	
	$.each(produtos, function(index, produto){
		$tbl.append("<tr>" +
				"<td>" + 1 +"</td>" +
				"<td>" + produto.nome +"</td>" +
				"<td>" + produto.descricao +"</td>" +
				"<td>" + produto.valor +"</td></tr>"	);
	});
}