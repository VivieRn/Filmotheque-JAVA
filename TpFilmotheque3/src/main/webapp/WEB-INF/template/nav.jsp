
<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<a href="${pageContext.request.contextPath}/"
				class="navbar-brand active"> <span
				class="glyphicon glyphicon-film"></span> <span
				class="glyphicon glyphicon-film"></span>
			</a>
			<button class="navbar-toggle" type="button" data-toggle="collapse"
				data-target="#navbar-main">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>
		<div class="navbar-collapse collapse" id="navbar-main">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="${pageContext.request.contextPath}/"><spring:message code="nav.home"/></a></li>
				<li><a href="${pageContext.request.contextPath}/app/lister"><spring:message code="nav.movies"/></a></li>
				<li><a href="${pageContext.request.contextPath}/app/ajouter"><spring:message code="nav.movie.add"/></a></li>
				<li><a
					href="${pageContext.request.contextPath}/app/listerStyle"><spring:message code="nav.genre"/></a></li>
				<li><a href="${pageContext.request.contextPath}/app/i18n?lg=fr">
						<img src="${pageContext.request.contextPath}/img/French.png"
						alt="Français" style="width: 50%">
				</a></li>
				<li><a href="${pageContext.request.contextPath}/app/i18n?lg=en"><img
						src="${pageContext.request.contextPath}/img/English.png"
						alt="English" style="width: 50%"></a></li>
			</ul>
		</div>
	</div>
</nav>
