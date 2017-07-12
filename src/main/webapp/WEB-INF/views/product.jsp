<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>

<html lang="pl">
    <head>
        <title>${product.symbol} webcontent</title>
        <link rel="icon" href="resources/favicon.ico" type="image/x-icon"/>
        <!-- Bootstrap -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <br>
            <c:if test="${!isExport}"> 
                <div class="btn-group">
                    <button type="button" class="btn btn-primary">Download xls</button>
                    <a href="http://www.html2pdf.it/?url=https://panamodels.herokuapp.com/product?url=${productUrl}%26export2pdf%3Dtrue&download=true" class="btn btn-primary" role="button">Download pdf</a>
                    <button type="button" class="btn btn-primary">Send e-mail</button>
                    <button type="button" class="btn btn-primary">Share</button>
                </div>
            </c:if>



            <h1>${product.symbol}</h1>
            <h3>${product.heading}</h3>
            <h4>${product.subHeading}</h4>
            <img src="${product.heroImage}" width="800px" />

            <hr>

            <c:forEach var = "i" items="${product.features}">
                <b>${i.name}</b> 
                <p> ${i.copy} </p>
                <img src="${i.image}" width="600px"/>
                <hr>
            </c:forEach>


            <h4>Icons</h4>
            <c:forEach var = "icon" items="${product.icons}">
                <img src="${icon}"/>  &nbsp; &nbsp; &nbsp;
            </c:forEach>
            <hr>

            <h4>Specs</h4>
            Link to specification page of this model: <a target="_blank" href="${product.specUrl}">click</a>
            <hr>
            <h4>Videos</h4>
            <c:forEach var = "video" items="${product.videos}">
                <a href="${video}"/>${video}</a>  &nbsp; &nbsp; &nbsp;
            </c:forEach>
        <hr>
        <h4>Product images</h4>

        <div class="container">
            <div class="row">
            </div>
            <div class="row">
                <c:forEach var = "image" items="${product.images360}">
                    <span class="col-lg-3 col-sm-12 picture">
                        <a href="${image}" download>  <img class="img-thumbnail" src="${image}"> </a>   
                    </span>

                </c:forEach>



            </div>
        </div>



    </div>



</body>
</html>