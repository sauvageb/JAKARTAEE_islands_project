<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Islands Project | Add Island</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body>


<jsp:include page="header.jsp"></jsp:include>

<div class="container mt-4">

    <h1>Add Island</h1>

    <div class="row">

        <form action="${pageContext.request.contextPath}/islands/add" method="POST">
            <div class="mb-3">
                <label for="name" class="form-label">Name</label>
                <input id="name" name="name" type="text" class="form-control">
            </div>

            <div class="mb-3">
                <label for="pictureUrl" class="form-label">Picture Url</label>
                <input id="pictureUrl" type="text" name="pictureUrl" class="form-control" required>
            </div>

            <div class="mb-3">
                <label for="surface" class="form-label">Surface</label>
                <input id="surface" type="number" name="surface" class="form-control" required>
            </div>

            <div class="mb-3">
                <label for="inhabitants" class="form-label">Inhabitants</label>
                <input id="inhabitants" type="number" name="inhabitants" class="form-control" required>
            </div>

            <div class="mb-3">
                <label for="latitude" class="form-label">Latitude</label>
                <input id="latitude" type="number" name="latitude" class="form-control" required>
            </div>

            <div class="mb-3">
                <label for="longitude" class="form-label">Longitude</label>
                <input id="longitude" type="number" name="longitude" class="form-control" required>
            </div>

            <div class="mb-3">
                <label for="country" class="form-label">Country</label>
                <input id="country" type="text" name="country" class="form-control" required>
            </div>

            <div class="d-flex justify-content-end">
                <button type="submit" class="btn btn-primary">Create</button>
            </div>
        </form>

    </div>
</div>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
