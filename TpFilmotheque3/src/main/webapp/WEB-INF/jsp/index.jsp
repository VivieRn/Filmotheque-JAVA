<%@include file="../template/tags.jsp" %>
<!DOCTYPE html>
<html>
<%@include file="../template/head.jsp" %>
<body>

	<%@include file="../template/nav.jsp" %>
	
	<div class="container">
		<div class="jumbotron">
	 			 <h1><spring:message code="home.title"/>  <small><spring:message code="home.subtitle"/></small></h1>
	 			 <p><spring:message code="home.p1"/></p>
	 			 <p><spring:message code="home.p2"/></p>
	 			 <p><a class="btn btn-primary btn-lg" role="button" href="#"><spring:message code="home.more"/></a></p>
		</div>
	</div>
	
	<%@include file="../template/footer.jsp" %>

</body>
</html>