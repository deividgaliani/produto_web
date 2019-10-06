<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:principal>
	<jsp:body>
		<div class="col col-12">
			<h2>Categorias</h2>
			<table id="tblCategoria" class="table table-striped table-bordered table-hover" style="text-align: center;">
				<thead class="thead-light">
					<tr>
						<th>ID</th>
						<th>DESCRIÇÃO</th>
						<th>AÇÃO</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
		</div>	
		<script src="./js/categoria/listagemCategoria.js"></script>
    </jsp:body>
</t:principal>