<%-- 
    Document   : cabecalho
    Created on : 14/04/2013, 20:39:19
    Author     : Miray
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>    
        <script type="text/javascript" src="js/bootstrap.js"></script>    
        <script type="text/javascript" src="js/bootstrap.min.js"></script>  
        <link href="css/bootstrap-responsive.css" rel="stylesheet" media="screen">
        <link href="css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
        <link href="css/bootstrap.css" rel="stylesheet" media="screen">
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="css/CabecalhoCSS.css" rel="stylesheet" media="screen">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div id="menuPrincipal">

            <div class="navbar">
                <div class="navbar-inner">
                    <ul class="nav">
                        <a class="brand" href="#">Logo Aqui...</a>
                        <li><a href="#">Inicio</a></li>
                        <li class="divider-vertical"></li>
                        <li><a href="#">F.A.Q.</a></li>
                        <li class="divider-vertical"></li>
                        <li><a href="#">Contato</a></li>
                        <li><h5>NOME DA PESSOA</h5></li>
                        <form class="navbar-form pull-left" id="pesquisa">
                            <input type="text" class="search-query" placeholder="Buscar">
                            <a class="btn" href="#"><i class="icon-search"></i></a>
                        </form>
                        <li><button type="submit" class="btn btn-info"> Sair</button></li>
                    </ul>
                </div>
            </div>
        </div>
    </body>
</html>
