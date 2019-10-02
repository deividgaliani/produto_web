<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:principal>
	<jsp:body>
		<h2>Produtos</h2>
		<table id="tblProduto" class="table table-striped table-bordered table-hover" style="text-align: center;">
			<thead class="thead-light">
				<tr>
					<th>ID</th>
					<th>NOME</th>
					<th>DESCRIÇÃO</th>
					<th>VALOR</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
	
		<script src="./js/produto/listagemProduto.js"></script>
    </jsp:body>
</t:principal>