<%--
  Created by IntelliJ IDEA.
  User: o18025131
  Date: 15/09/2022
  Time: 09:33
  To change this template use File | Settings | File Templates.
--%>
<<%@ include file="/WEB-INF/jsp/header.jsp"%>

<div class="container">
    <h1>Liste des films</h1>

    <c:url var="movieAction" value="/oldmovie" />

    <table class="table">
        <tr>
            <th>Nom</th>
            <th>Annee</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="movie" items="${OldMovies}">
            <tr>
                <td>${movie.name}</td>
                <td>${movie.year}</td>
                <td><a class="btn btn-primary btn-sm"
                       href="${movieAction}/${movie.id}">Montrer</a></td>
            </tr>
        </c:forEach>
    </table>

</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>

