
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="resources/favicon.ico" type="image/x-icon"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <title>${links.get(0).modelSymbol}</title>
    </head>
    <body>
        <div class ="container">
        <h2>${links.get(0).modelSymbol}</h2>
        <table class="table table-striped">
    <thead>
      <tr>
       
        <th>Country</th>
        <th>Show data</th>
        <th>Export</th>
      </tr>
    </thead>
    <tbody>
         <c:forEach items="${links}" var="link">
           <tr>
      
        <td><button type="button" class="btn btn-default disabled">${link.countryId.toUpperCase()}</button></td>
        <td> <a href="product?url=${link.productUrl}" class="btn btn-success">Show data</a></td>
        <td><div class="btn-group">
  <button type="button" class="btn btn-primary disabled">Download xls</button>
  <a href="http://www.html2pdf.it/?url=https://panamodels.herokuapp.com/product?url=${link.productUrl}%26export2pdf%3Dtrue&download=true" class="btn btn-primary" role="button">Download pdf</a>
  <button type="button" class="btn btn-primary disabled">Send e-mail</button>
   <button type="button" class="btn btn-primary disabled">Share</button>
</div></td>
      </tr> 
         </c:forEach>
   
    </tbody>
  </table>

        </div> <!--        end of main container-->

        
    </body>
</html>
