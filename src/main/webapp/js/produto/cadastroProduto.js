$(document).ready(function() {
	recuperarComboCategorias();
	$('#valor').mask('00000.00', {reverse: true});
});

var recuperarComboCategorias = function(){
	$.ajax({
		  url: "/produto_web/categoria", 
		  success: function(result){
			  categorias = $.parseJSON(result);
			  adicionaDadosCombo(categorias);
		  }
	});
};

$('#imagem').change(function (event) {
	var form = new FormData();
    form.append('imagem', event.target.files[0]);
//    var name = event.target.files[0].name;
//    form.append('titulo', name);
    $.ajax({
	    url : '/produto_web/imagem',
	    type : 'POST',
	    data : form,
	    processData: false,
	    contentType: false,
	    success : function(data) {
	        console.log(data);
	    }
    });
});

var adicionaDadosCombo = function(categorias){
	$comboCategoria = $("#categoria");
	$comboCategoria.append("<option value=''>Selecione</option>");

	$.each(categorias, function(index, categoria){
		$comboCategoria.append("<option " +
				"value='" + categoria.id +"' " +
				">" + categoria.descricao + "</option>"	);
	});
}


$("#btnInserirProduto").on("click", function(){
	  $.ajax({
		  url: "/produto_web/produto", 
		  data: getFormData(),
		  type: "POST",
		  success: function(result){
			  var resultado = $.parseJSON(result);
			  if(resultado.sucesso){
				  alert(resultado.mensagem);
				  limparCampos();
			  }else{
				  alert(resultado.mensagem);
			  }
		  }
	  });
});

$("#btnLimparFormulario").on("click", function(){
	limparCampos();
});

getFormData = function(){
	var $inputs = $('.form-control');
	var obj = {};
	$inputs.each(function(i, input){
		var $input = $(input);
		$.extend(obj, {[$input.attr('id')]: $input.val()})
	});
	$.extend(obj, {acao: 'salvar'});
	return obj;
}

limparCampos = function(){
	var $inputs = $('.form-control');
	$inputs.val('');
}
