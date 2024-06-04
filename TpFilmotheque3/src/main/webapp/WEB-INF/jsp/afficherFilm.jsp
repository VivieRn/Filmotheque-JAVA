<%@include file="../template/tags.jsp" %>

<!DOCTYPE>
<html>
<%@include file="../template/head.jsp"%>
<body>

	<%@include file="../template/nav.jsp"%>

	<div class="container">
		<h1 class="bleu">
			<spring:message code="movie"></spring:message>
		</h1>
		<br> <br>
		<div>
			<form:form cssClass="form-horizontal" modelAttribute="film">
				<%@include file="../template/moviesForm.jsp"%>
			</form:form>
		</div>
	</div>
	<%@include file="../template/footer.jsp"%>

</body>
</html>