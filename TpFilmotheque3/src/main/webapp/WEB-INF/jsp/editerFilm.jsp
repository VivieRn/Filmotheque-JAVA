<%@include file="../template/tags.jsp" %>

<!DOCTYPE>
<html>
<%@include file="../template/head.jsp"%>
<body>

	<%@include file="../template/nav.jsp"%>
	<div class="container">
		<h1 class="bleu">
			<spring:message code="movie.edit.title" />
		</h1>
		<br> <br>
		<div>
			<form:form action="editerValid" method="POST"
				cssClass="form-horizontal" modelAttribute="film">
				<form:hidden path="id" />

				<%@include file="../template/moviesForm.jsp"%>

			</form:form>
		</div>
	</div>
	<%@include file="../template/footer.jsp"%>

</body>
</html>