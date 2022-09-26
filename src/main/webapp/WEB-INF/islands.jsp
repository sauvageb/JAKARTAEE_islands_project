<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Islands Project | Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body>


<div class="container">

    <h1>Islands :</h1>

    <a href="${pageContext.request.contextPath}/islands/add">Add Island</a>

    <div class="row">
        <c:forEach items="${islands}" var="island">

            <div class="col-lg-4 mb-3 d-flex align-items-stretch">
                <div class="card">
                    <img src="${island.pictureUrl}" class="card-img-top embed-responsive-item" alt="${island.name}">
                    <div class="card-body d-flex flex-column">
                        <h5 class="card-title">${island.name}</h5>
                            <%--                        <p class="card-text mb-4">xx</p>--%>
                    </div>
                    <div class="card-footer d-flex justify-content-end">

                        <a href="${pageContext.request.contextPath}/edit?id=${island.id}" class="btn btn-primary me-2">Edit</a>

                        <form action="${pageContext.request.contextPath}/delete-island" method="post" class="m-0">
                            <input hidden name="idIsland" value="${island.id}">
                            <button class="btn btn-secondary" type="submit">Delete</button>
                        </form>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>


</div>


</body>
</html>
