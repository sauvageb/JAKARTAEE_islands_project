<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Islands Project | Edit Island</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body>


<div class="container">

    <h1>Edit Island</h1>

    <div class="row">

        <form action="${pageContext.request.contextPath}/edit" method="POST">
            <input hidden name="idIsland" value="${island.id}">
            <label for="name">Name</label>
            <input id="name" type="text" name="name" value="${island.name}">

            <label for="pictureUrl">Picture Url</label>
            <input id="pictureUrl" type="text" name="pictureUrl" value="${island.pictureUrl}">

            <button type="submit">Edit</button>
        </form>

    </div>

</div>


</body>
</html>
