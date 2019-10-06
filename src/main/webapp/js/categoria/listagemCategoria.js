$(document).ready(function() {
	getCategorias();
});

var getCategorias = function(){
	$.ajax({
		  url: "/produto_web/categoria", 
		  success: function(result){
			  categorias = $.parseJSON(result);
			  adicionaDadosTabela(categorias);
		  }
	});
};

var adicionaDadosTabela = function(categorias){
	$tbl = $("#tblCategoria");
	$.each(categorias, function(index, categoria){
		$tbl.append(
			"<tr>" +
				"<td>" + categoria.id +"</td>" +
				"<td>" + categoria.descricao +"</td>" +
				"<td>AÇÃO</td>" +
			"</tr>"	);
	});
}