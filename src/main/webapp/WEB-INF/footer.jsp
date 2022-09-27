<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<footer class="text-muted py-5 mt-4 bg-dark">
    <div class="container">
        <p class="float-end mb-1">
            <a href="#" class="btn btn-secondary">
                <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor"
                     class="bi bi-arrow-up" viewBox="0 0 16 16">
                    <path fill-rule="evenodd"
                          d="M8 15a.5.5 0 0 0 .5-.5V2.707l3.146 3.147a.5.5 0 0 0 .708-.708l-4-4a.5.5 0 0 0-.708 0l-4 4a.5.5 0 1 0 .708.708L7.5 2.707V14.5a.5.5 0 0 0 .5.5z"/>
                </svg>
            </a>
        </p>
        <jsp:useBean id="now" class="java.util.Date" scope="request"/>
        <p class="mb-1 text-white">&copy; JakartaEE9 - Island Project <fmt:formatDate value="${now}"
                                                                                      pattern="yyyy"/></p>

    </div>
</footer>
