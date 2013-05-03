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
        
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div id="menuPrincipal">
            <div class="navbar">
                <div class="navbar-inner">
                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                    </a>
                    <a class="brand" href="#"><img src="img/LogoSLCL.png"></a>
                    <div class="nav-collapse collapse">
                        <ul class="nav">
                            <li><a href="javascript:open('index.jsp')">Inicio</a></li>
                            <li id="faq"><a href="#">F.A.Q.</a></li>
                            <li id="contato"><a href="javascript:open('contato.jsp')">Contato</a></li>
                        </ul>
                    </div>
                    <a class="btn pull-right btn-info" style="margin: 5px">Sair</a>
                    <form class="navbar-search pull-right" id="pesquisa" style="margin: 5px">
                        <input type="text" class="search-query" placeholder="Buscar" style="height: 30px">
                    </form>
                    <h5 class="pull-right" style="margin-right: 5px">NOME DA PESSOA</h5>
                </div>
            </div>
        </div>
    </body>
</html>
