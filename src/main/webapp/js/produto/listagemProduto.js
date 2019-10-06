$(document).ready(function() {
	getProdutos();
});

var getProdutos = function(){
	$.ajax({
		  url: "/produto_web/produto", 
		  success: function(result){
			  var resultado = $.parseJSON(result);
			  if(resultado.sucesso){
				  adicionaDadosTabela(resultado.dados);
			  }else{
				  alert(resultado.mensagem);
			  }
		  }
	});
};

var adicionaDadosTabela = function(produtos){
	$tblBody = $("#tblProduto tbody");
	$("#tblProduto tbody tr").remove();
	$.each(produtos, function(index, produto){
		$tblBody.append(
			"<tr>" +
				"<td>" + produto.id +"</td>" +
				"<td>" + produto.nome +"</td>" +
				"<td>" + produto.descricao +"</td>" +
				"<td>" + produto.valor +"</td>" +
				"<td>" + produto.descricaoCategoria +"</td>" +
				"<td><a onclick='excluirProduto(" + produto.id + ")' href='#'>excluir</a></td>" + 
//				" <a onclick='alterarProduto(" + produto.id + ")' href='#'>alterar</a></td>" +
			"</tr>"	);
	});
}

var excluirProduto = function(id){
	$.ajax({
		  url: "/produto_web/produto",
		  data: {acao: 'excluir', idProduto: id},
		  type: "POST",
		  success: function(result){
			  var resultado = $.parseJSON(result);
			  if(resultado.sucesso){
				  getProdutos();
				  alert("Produto excluido com sucesso");
			  }else{
				  alert(resultado.mensagem);
			  }
		  }
	});
}

var alterarProduto = function(id){
	$.ajax({
		  url: "/produto_web/produto",
		  data: {acao: 'alterar', idProduto: id},
		  type: "POST",
	});
}