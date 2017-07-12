<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="pl">
    <head>
        <link rel="icon" href="resources/favicon.ico" type="image/x-icon"/>
        <title>Product list</title>
        <!-- Bootstrap -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.2/css/bootstrap-select.min.css">

        <%-- TODO wrzucic wszelkie style do osobnej paczki z css-ami--%>

        <style>

            body {
                padding-top: 0px;
                padding-bottom: 40px;
                font-size: 16px;
                font-weight:200;

            }

            h2 {
                color: #4ba13f !important;
                font-size: 24px;
                font-weight: 500;
            }

            #optionsButton {
                margin-right: 37px;
                margin-left: -110px;
                margin-top: -25px;
                float: right;
            }

            #pdfInput {
                margin-bottom: 8px;
            }

            .options {
                -webkit-transform: scale(0.6);
                -moz-transform: scale(0.6);
                -ms-transform: scale(0.6);
                -o-transform: scale(0.6);
                transform: scale(0.6);
            }

            .options .btn-group:first-child {
                margin-right: 19px;
            }

            .options .btn-group:last-child {
                margin-left: 19px;
            }

            .container-narrow {
                margin: 0 auto;
                max-width: 700px;
            }

            .container-narrow > hr {
                margin: 30px 0;
            }

            /* Main marketing message and sign up button */
            .jumbotron {
                margin: 140px 0;
                text-align: center;
                background:transparent !important;



            }

            .jumbotron h1 {
                line-height: 1;
                padding-bottom: 40px;
                color: #555;
            }

            .jumbotron .input, .center {
                text-align: center;
            }

            .jumbotron .lead {
                margin-top: 21px;
            }

            #searchForm{
                z-index: 999;
                position: relative;
            }
            #searchFormSymbol{
                z-index: 1;
                position: relative;
            }

            @media (min-width: 500px) {
                .jumbotron h1 {
                    font-size: 50px;
                }

                .pdfForm {
                    -webkit-transform: scale(1.2);
                    -moz-transform: scale(1.2);
                    -ms-transform: scale(1.2);
                    -o-transform: scale(1.2);
                    transform: scale(1.2);
                    padding-bottom: 15px;
                    padding-top: 5px;
                    overflow: visible;
                }
            }

            @media (min-width: 700px) {
                .jumbotron h1 {
                    font-size: 72px;
                }

                .pdfForm {
                    -webkit-transform: scale(1.5);
                    -moz-transform: scale(1.5);
                    -ms-transform: scale(1.5);
                    -o-transform: scale(1.5);
                    transform: scale(1.5);
                    padding-bottom: 15px;
                    padding-top: 5px;
                    overflow: visible;
                }


            }

            .contents {
                margin: 0 30px;
            }

            .fb-like {
                width: 52px !important;
                margin: 0 26px 0 0;
                padding: 0;
                position: relative;
                display: inline-block;
                top: -3px;
            }



        </style>


    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">
                        Product content information
                    </a>
                </div>
            </div>
        </nav>
        <div class ="container-narrow">
            <div class="jumbotron">

                <h3>Browse products by country:</h3>

                <form class ="pdfForm" id="searchForm" action="showCountry" method="POST">
                    <select class="selectpicker" data-live-search="true" name="countryCode" data-width="300px" >
                        <option data-content="<img src='http://flagipanstw.pl/wp-content/uploads/2015/05/flaga-polski.png' height='20' width='30'/> Poland"  value="http://www.panasonic.com/pl/consumer/all-products.html"> Poland</option>
                        <option data-content="<img src='http://flagipanstw.pl/wp-content/uploads/2015/05/flaga-czech.png' height='20' width='30'/> Czech" value="http://www.panasonic.com/cz/consumer/all-products.html"> Czech</option>
                        <option data-content="<img src='http://flagipanstw.pl/wp-content/uploads/2015/05/flaga-slowacji.png' height='20' width='30'> Slovakia"value="http://www.panasonic.com/sk/consumer/vsetky-panasonic-produkty.html"> Slovakia</option>
                        <option data-content="<img src='http://flagipanstw.pl/wp-content/uploads/2015/05/flaga-wegier.png' height='20' width='30'> Hungary"value="http://www.panasonic.com/hu/consumer/all-products.html"> Hungary</option>
                        <option data-content="<img src='http://flagipanstw.pl/wp-content/uploads/2015/05/flaga-bulgarii.png' height='20' width='30'> Bulgaria"value="http://www.panasonic.com/bg/consumer/all-products.html"> Bulgaria</option>
                        <option data-content="<img src='http://flagipanstw.pl/wp-content/uploads/2015/05/flaga-chorwacji.png' height='20' width='30'> Croatia"value="http://www.panasonic.com/hr/consumer/all-products.html"> Croatia</option>
                        <option data-content="<img src='http://flagipanstw.pl/wp-content/uploads/2015/05/flaga-rumunii.png' height='20' width='30'> Romania"value="http://www.panasonic.com/ro/consumer/toate-produsele-panasonic.html"> Romania</option>
                        <option data-content="<img src='http://flagipanstw.pl/wp-content/uploads/2015/05/flaga-estonii.png' height='20' width='30'> Estonia"value="http://www.panasonic.com/ee/consumer/all-products.html"> Estonia</option>
                        <option data-content="<img src='http://flagipanstw.pl/wp-content/uploads/2015/05/flaga-lotwy.png' height='20' width='30'> Latvia"value="http://www.panasonic.com/lv/consumer/all-products.html"> Latvia</option>
                        <option data-content="<img src='http://flagipanstw.pl/wp-content/uploads/2015/05/flaga-litwy.png' height='20' width='30'> Lithuania"value="http://www.panasonic.com/lt/consumer/all-products.html"> &Lithuania</option>
                        <option data-content="<img src='http://flagipanstw.pl/wp-content/uploads/2015/05/flaga-niemiec.png' height='20' width='30'> Germany"value="http://www.panasonic.com/de/consumer/alle-produkte.html"> Germany</option>
                        <option data-content="<img src='http://flagipanstw.pl/wp-content/uploads/2015/05/flaga-wielkiej-brytanii.png' height='20' width='30'> United Kingdom"value="http://www.panasonic.com/uk/consumer/all-products.html"> UK </option>
                    </select>
                    <input type="submit" value="OK" class="btn btn-default">

                </form>

                <hr>
                <h3>Search products by symbol:</h3>


                <form class ="pdfForm" id="searchFormSymbol" action="showModel" method="POST">
                    <select class="selectpicker" data-live-search="true" name="modelSymbol" data-width="300px" data-size="10" title="Choose one of ${productSymbols.size()} models">
                        <c:forEach items="${productSymbols}" var="symbol">
                            <option value="${symbol}">${symbol}</option>       
                        </c:forEach>


                    </select>
                    <input type="submit" value="OK" class="btn btn-default">

                </form>


            </div>
        </div>



        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>


        <!-- Latest compiled and minified JavaScript -->
        <!--        https://silviomoreto.github.io/bootstrap-select/examples/-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.2/js/bootstrap-select.min.js"></script>


    </body>
</html>