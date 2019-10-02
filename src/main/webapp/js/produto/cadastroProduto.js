$(document).ready(function() {
	$('#valor').mask('00000.00', {reverse: true});
});


$("#btnInserirProduto").on("click", function(){
	  $.ajax({
		  url: "/produto_web/produto", 
		  data: getFormData(),
		  type: "POST",
		  success: function(result){
			  alert(result);
		  }
	  });
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
