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
        <script type="text/javascript" src="../js/bootstrap.js"></script>    
        <script type="text/javascript" src="../js/bootstrap.min.js"></script>  
        <script type="text/javascript" src="../js/ajax.js"></script>  
        <script type="text/javascript" src="../js/breadcrumbs.js"></script>  
        <link href="../css/bootstrap-responsive.css" rel="stylesheet" media="screen">
        <link href="../css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
        <link href="../css/bootstrap.css" rel="stylesheet" media="screen">
        <link href="../css/bootstrap.min.css" rel="stylesheet" media="screen">
        
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div id="menuPrincipal">
            <div class="navbar">
                <div class="navbar-inner">
                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                    </a>
                    <a class="brand" href="#"><img src="../img/LogoSLCL.png"></a>
                    <div class="nav-collapse collapse">
                        <ul class="nav">
                            <li id="inicio"><a href="javascript:open('index.jsp')" onclick="alterarTexto('inicio')" >Inicio</a></li>
                            <li id="faq"><a href="javascript:open('faq.jsp')" onclick="alterarTexto('faq')">F.A.Q.</a></li>
                            <li id="contato"><a href="javascript:open('contato.jsp')" onclick="alterarTexto('contato')">Contato</a></li>
                        </ul>
                    </div>
                    <a href="FazerLogout" class="btn pull-right btn-info" style="margin: 5px">Sair</a>
                    <h5 class="pull-right" style="margin-right: 5px">${UsuarioLogado.nome}</h5>
                </div>
            </div>
        </div>
    </body>
</html>