<%--
  Created by IntelliJ IDEA.
  User: o18025131
  Date: 06/10/2022
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/WEB-INF/jsp/header.jsp"%>

<c:url var="home" value="/aaa" />
<c:url var="app" value="/app.js" />

<div id="myApp">
    <div class="container">
        <h1>My application</h1>
        <p>{{ message }}</p>
        <p>counter = {{counter}}</p>
        <p>list = <span v-for="element in list">{{element}} - </span></p>
        <button v-on:click="incCounter(1)">Plus un</button>
        <button v-on:click="incCounter(2)">Plus deux</button><br/>
        <span v-on:mouseover="incCounter(1)">Il faut me survoler</span>
        <table class="table">
            <tr>
                <th>Nom</th>
                <th>Annee</th>
                <th>Actions</th>
            </tr>
            <tr v-for="element in movies">
                <td>{{element.name}}</td>
                <td>{{element.year}}</td>
                <td> <button v-on:click="showMovie(element.id)">Montrer</button>
                    <button v-on:click="deleteMovie(element.id)">Supprimer</button></td>

            </tr>

        </table>
        <div v-if="movie != null">
            <p>{{movie.name}}</p>
            <p>{{movie.year}}</p>
            <p>{{movie.description}}</p>

        </div>
    </div>
</div>
.
<script src="${app}"></script>
<%@ include file="/WEB-INF/jsp/footer.jsp"%>
