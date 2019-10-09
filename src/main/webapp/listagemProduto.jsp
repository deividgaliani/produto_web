<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:principal>
	<jsp:body>
		<div class="col col-12">
			<h2>Produtos</h2>
			<table id="tblProduto" class="table table-striped table-bordered table-hover" style="text-align: center;">
				<thead class="thead-light">
					<tr>
						<th>ID</th>
						<th>NOME</th>
						<th>DESCRIÇÃO</th>
						<th>VALOR</th>
						<th>CATEGORIA</th>
						<th>AÇÃO</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
		</div>	
		<script src="./js/produto/listagemProduto.js"></script>
		<%@ include file = "./modalAlterarProduto.jsp" %>
    </jsp:body>
</t:principal>