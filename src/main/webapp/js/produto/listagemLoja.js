var cardTemplate = '<div class="card border-primary mb-3" style="max-width: 500px;"><div class="row no-gutters">'+
'<div class="col-md-4"><img src="[IMG_SRC]" class="card-img" alt="[IMG_ALT]"></div><div class="col-md-8">'+
  '<div class="card-body">'+
    '<h5 class="card-title">[CARD_TITLE]</h5>'+
    '<p class="card-text">[CARD_TEXT]</p>'+
    '<p class="card-text"><small class="text-muted">[CARD_PRICE]</small></p>'+
  '</div></div></div></div>';

$(document).ready(function() {
	getProdutos();
});

var getProdutos = function(){
	$.ajax({
		  url: "/produto_web/produto", 
		  success: function(result){
			  var resultado = $.parseJSON(result);
			  if(resultado.sucesso){
				  adicionaDadosContainer(resultado.dados);
			  }else{
				  alert(resultado.mensagem);
			  }
		  }
	});
};

var adicionaDadosContainer = function(produtos){
	$container = $("#containerLoja");
//	$("#tblProduto tbody tr").remove();
	$.each(produtos, function(index, produto){
		$container.append( cardTemplate
			.replace('[IMG_SRC]','data:image/png;base64,' + produto.imgPath)
			.replace('[IMG_ALT]', '')
			.replace('[CARD_TITLE]', produto.nome)
			.replace('[CARD_TEXT]', produto.descricao)
			.replace('[CARD_PRICE]', produto.valor)
		);
//			"<tr>" +
//				"<td>" + produto.id +"</td>" +
//				"<td>" + produto.nome +"</td>" +
//				"<td>" + produto.descricao +"</td>" +
//				"<td>" + produto.valor +"</td>" +
//				"<td>" + produto.descricaoCategoria +"</td>" +
//			"</tr>"	);
	});
}