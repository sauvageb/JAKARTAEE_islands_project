<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Islands Project | Add Country</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body>


<jsp:include page="header.jsp"></jsp:include>

<div class="container mt-4">

    <h1>Add Country</h1>

    <div class="row">
        <form action="${pageContext.request.contextPath}/countries/add" method="POST">
            <div class="mb-3">
                <label for="name" class="form-label">Name</label>
                <input id="name" name="name" type="text" class="form-control">
                <p class="text-muted">Pays disponibles sur <a
                        href="https://www.countryflagsapi.com/">countryflagsapi</a></p>
            </div>

            <div class="mb-3 mt-5 d-flex justify-content-center">
                <img id="pictureOverview" src="" height="150">
            </div>

            <div class="d-flex justify-content-end">
                <button type="submit" class="btn btn-primary">Create</button>
            </div>
        </form>
    </div>
</div>

<script src="${pageContext.request.contextPath}/js/create-countries-form.js"></script>
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
