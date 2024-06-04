<div class="form-group">
	<form:label path="titre" cssClass="col-xs-2 control-label">
		<spring:message code="movie.title"></spring:message>
	</form:label>
	<div class="col-xs-10">
		<spring:message code="movie.title.placeholder" var="titlePlaceholder" />
		<form:input path="titre" placeholder="${titlePlaceholder}"
			cssClass="form-control" required="required"
			readonly="${empty enLecture?false:true}" />
	</div>
</div>

<div class="form-group">
	<form:label path="annee" cssClass="col-xs-2 control-label">
		<spring:message code="movie.year"></spring:message> :
		</form:label>
	<div class="col-xs-10">
		<spring:message code="movie.year.placeholder" var="yearPlaceholder" />
		<form:input pattern="[0-9]{4}" path="annee"
			placeholder="${yearPlaceholder}" cssClass="form-control"
			readonly="${empty enLecture?false:true}" />
	</div>
</div>

<div class="form-group">
	<form:label path="style.id" cssClass="col-xs-2 control-label">
		<spring:message code="movie.genre"></spring:message> :
		</form:label>
	<div class="col-xs-10">
		<c:choose>
			<c:when test='${empty enLecture}'>
				<form:select path="style.id" cssClass="form-control">
					<form:options items="${listeStyles}" itemValue="id"
						itemLabel="libelle" />
				</form:select>
			</c:when>
			<c:otherwise>
				<form:input path="style.libelle" readonly="true"
					cssClass="form-control" />
			</c:otherwise>
		</c:choose>
	</div>
</div>
<div class="form-group">
	<form:label path="real.prenom" cssClass="col-xs-2 control-label">
		<spring:message code="movie.director"></spring:message> :
		</form:label>
	<div class="col-xs-5">
		<spring:message code="movie.placeholder.firstName" var="fnPlaceholder" />
		<form:input path="real.prenom" placeholder="${fnPlaceholder}"
			cssClass="form-control" readonly="${empty enLecture?false:true}" />
	</div>
	<div class="col-xs-5">
		<spring:message code="movie.placeholder.lastName" var="lnPlaceholder" />
		<form:input path="real.nom" placeholder="${lnPlaceholder}"
			cssClass="form-control" readonly="${empty enLecture?false:true}" />
	</div>
</div>

<div class="form-group">
	<form:label path="duree" cssClass="col-xs-2 control-label">
		<spring:message code="movie.duration" /> :
		</form:label>
	<div class="col-xs-10">
		<form:input path="duree" placeholder="Minutes" cssClass="form-control"
			readonly="${empty enLecture?false:true}" />
	</div>
</div>


<div class="form-group">
	<form:label path="vu" cssClass="col-xs-2 control-label">
		<spring:message code="movie.seen" /> :
		</form:label>
	<div class="col-xs-10">
		<c:choose>
			<c:when test='${empty enLecture}'>
				<form:select path="vu" cssClass="form-control">
					<form:option value="true">
						<spring:message code="movie.yes" />
					</form:option>
					<form:option value="false">
						<spring:message code="movie.no" />
					</form:option>
				</form:select>
			</c:when>
			<c:otherwise>
				<input id="vu"
					value="<spring:message code="${film.vu?'movie.yes':'movie.no'}"></spring:message>"
					readonly class="form-control" />
			</c:otherwise>
		</c:choose>
	</div>
</div>

<c:forEach begin="0" end="4" var="ind">
	<div class="form-group">
		<form:label path="duree" cssClass="col-xs-2 control-label">
			<spring:message code="movie.actor" />  ${ind + 1}</form:label>
		<c:choose>
			<c:when test='${empty enLecture}'>

				<div class="col-xs-5">
					<input name="acteurs[${ind}].prenom"
						value="${film.acteurs[ind].prenom}" placeholder="${fnPlaceholder}"
						class="form-control" />
				</div>
				<div class="col-xs-5">
					<input name="acteurs[${ind}].nom" value="${film.acteurs[ind].nom}"
						placeholder="${lnPlaceholder}" class="form-control" />
				</div>
			</c:when>
			<c:otherwise>
				<div class="col-xs-5">
					<input name="acteurs[${status.index}].prenom" readonly
						value="${film.acteurs[ind].prenom}" class="form-control" />
				</div>
				<div class="col-xs-5">
					<input name="acteurs[${status.index}].nom" readonly
						value="${film.acteurs[ind].nom}" class="form-control" />
				</div>
			</c:otherwise>
		</c:choose>
	</div>
</c:forEach>

<div class="form-group">
	<form:label path="synopsis" cssClass="col-xs-2 control-label">
			Synopsis :
		</form:label>
	<div class="col-xs-10">
		<spring:message code="movie.synopsis.placeholder"
			var="synopsisPlaceholder" />
		<form:textarea path="synopsis" rows="5"
			placeholder="${synopsisPlaceholder}" cssClass="form-control"
			readonly="${empty enLecture?false:true}" />
	</div>
</div>

<c:if test='${empty enLecture}'>
	<div class="form-group">
		<div class="col-xs-offset-2 col-xs-10">
			<button type="submit" class="btn btn-primary">
				<spring:message code="movie.add.button" />
			</button>
		</div>
	</div>
</c:if>
