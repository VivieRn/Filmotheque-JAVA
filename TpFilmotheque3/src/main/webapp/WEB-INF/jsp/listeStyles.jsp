<%@include file="../template/tags.jsp"%>

<!DOCTYPE>
<html>
<%@include file="../template/head.jsp"%>
<body>

	<%@include file="../template/nav.jsp"%>
	<div class="container">
		<h1 class="bleu">
			<spring:message code="genre.title" />
		</h1>
		<br> <br>
		<table class="table table-hover table-striped">
			<tr>
				<th><a href="trierStyle?par=iA"><span class="glyphicon glyphicon-menu-down"></span></a>
				id
				<a href="trierStyle?par=iD"><span class="glyphicon glyphicon-menu-up"></span></a></th>
				<th><a href="trierStyle?par=lA"><span class="glyphicon glyphicon-menu-down"></span></a>
				<spring:message code="genre.label" />
				<a href="trierStyle?par=lD"><span class="glyphicon glyphicon-menu-up"></span></a></th>
				<th></th>
				<th></th>
			</tr>
			<c:forEach items="${listeS}" var="s" varStatus="bStatus">
				<form action="modifStyle" method="Post">
					<tr>
						<input type="hidden" name="id" value="${s.id}" />
						<td>${s.id}</td>
						<td><input type="text" name="libelle" value="${s.libelle}" /></td>
						<td class="centre">
							<button type="submit" class="glyphicon glyphicon-edit vert"></button>

						</td>
						<td class="centre"><a href="supprimerStyle?index=${s.id}">
								<span class="glyphicon glyphicon-remove rouge"></span>
						</a></td>
					</tr>
				</form>
			</c:forEach>
		</table>

		<br> <br> <br>
		<h2 class="bleu">
			<spring:message code="genre.new" />
		</h2>
		<div>
			<form:form action="ajouterStyle" method="POST" class="form-horizontal" modelAttribute="style">
				<div class="form-group">
					<div class="col-xs-10">
						<spring:message code="genre.label.placeholder" var="labelPlaceholder"/>
						<div class="col-sm-7">
						<form:input path="libelle" placeholder="${labelPlaceholder}"
							class="form-control" />
						</div>
						<div class="col-sm-3">
							<form:errors path="libelle" cssClass="rouge"></form:errors>
						</div>
					</div>					
					<div class="col-xs-2">
						<button type="submit" class="btn btn-primary pull-right">
							<spring:message code="movie.add.button" />
						</button>
					</div>
				</div>

			</form:form>
		</div>
	</div>
	<%@include file="../template/footer.jsp"%>

</body>
</html>