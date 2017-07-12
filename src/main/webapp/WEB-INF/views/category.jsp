<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="resources/favicon.ico" type="image/x-icon"/>
        <title>Category</title>
        <!-- Bootstrap -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    </head>
    <body>
        <h1>Products in category</h1>
        <div class="container">

        <c:forEach items="${links}" var="link">
            <c:forEach items="${link.link}" var="mapItem">
            <a href="product?url=${mapItem.value}" >${mapItem.key}</a> <br>            
        </c:forEach>     
        </c:forEach>
            </div> <!--        end of container-->

    </body>
</html>
