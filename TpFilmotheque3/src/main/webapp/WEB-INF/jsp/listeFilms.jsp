<%@include file="../template/tags.jsp" %>

<!DOCTYPE>
<html>
<%@include file="../template/head.jsp" %>
<body>

	<%@include file="../template/nav.jsp" %>
	<div class="container">
		<h1 class="bleu"><spring:message code="nav.movies"/></h1>
		<br>
		<br>
		<table class="table table-hover table-striped">
			<tr>
				<th><spring:message code="movie.title"/></th>
				<th><spring:message code="movie.year"/></th>
				<th><spring:message code="movie.genre"/></th>
				<th><spring:message code="movie.director"/></th>
				<th><spring:message code="movie.duration"/></th>
				<th><spring:message code="movie.seen"/></th>
				<th></th>
				<th></th>
			</tr>
			<c:forEach items="${listeF}" var="f" varStatus="bStatus">
				<tr>
					<td><a href="afficher?index=${f.id}">${f.titre}</a></td>
					<td>${f.annee}</td>
					<td>${f.style.libelle}</td>
					<td>${f.real.prenom}${f.real.nom}</td>
					<td>${f.duree}</td>
					<td><spring:message code="${f.vu?'movie.yes':'movie.no'}"/></td>
					<td class="centre"><span
						class="modif glyphicon glyphicon-edit vert" id="m${f.id}"></span>
					</td>
					<td class="centre"><span
						class="glyphicon glyphicon-remove rouge supp" id="s${f.id}"></span>
					</td>
				</tr>
			</c:forEach>
		</table>


	</div>
	<%@include file="../template/footer.jsp" %>

</body>
</html>