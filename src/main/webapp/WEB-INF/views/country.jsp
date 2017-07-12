<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="resources/favicon.ico" type="image/x-icon"/>
        <title>Categories</title>
        <!-- Bootstrap -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    </head>
    <body>
        <div class="container">
            <h2>Categories: ${categories.size()}</h2>


            <c:forEach items="${categories}" var="category">
                <c:forEach items="${category}" var="mapItem">
                    <a href="category?url=${mapItem.key}" >${mapItem.value}</a> <br>            
                </c:forEach>
            </c:forEach>

        </div> <!--  end of container-->

    </body>
</html>
