$("#btnInserirCategoria").on("click", function(){
	  $.ajax({
		  url: "/produto_web/categoria", 
		  data: getFormData(),
		  type: "POST",
		  success: function(result){
			  limparCampos();
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
	return obj;
}

limparCampos = function(){
	var $inputs = $('.form-control');
	$inputs.val('');
}
