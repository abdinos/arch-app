<%@ include file="/WEB-INF/jsp/header.jsp"%>

<div class="container">
	<h1>Liste des films</h1>

	<c:url var="movieAction" value="/movie" />
	<c:url var="delAction" value="/remove-movie" />


	<table class="table">
		<tr>
			<th>Nom</th>
			<th>Ann�e</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="movie" items="${movies}">
			<tr>
				<td>${movie.name}</td>
				<td>${movie.year}</td>
				<td><a class="btn btn-primary btn-sm"
					href="${movieAction}/${movie.id}">Montrer</a></td>
				<td><a href="${delAction}/${movie.id}">Supprimer</a></td>
			</tr>
		</c:forEach>
	</table>

	<td><a class="btn btn-primary btn-sm" href="/oldmovie"> Anciens Films</a></td>

</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>
