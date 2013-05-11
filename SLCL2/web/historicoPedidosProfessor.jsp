<%-- 
    Document   : pedidoLivro
    Created on : 18/04/2013, 19:31:53
    Author     : Miray
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>    
        <script type="text/javascript" src="js/bootstrap.js"></script>    
        <script type="text/javascript" src="js/bootstrap.min.js"></script>  
        <script type="text/javascript" src="js/ajax.js"></script>  
        <script type="text/javascript" src="js/breadcrumbs.js"></script>
        <link href="css/bootstrap-responsive.css" rel="stylesheet" media="screen">
        <link href="css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
        <link href="css/bootstrap.css" rel="stylesheet" media="screen">
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="css/PageCSS.css" rel="stylesheet" media="screen">
        <link rel="icon" type="image/png" href="img/LogoSLCL.png" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>SLCL - Pedir Livro</title>
    </head>
    <body>
        <div id="container">
            <div id="header">
                <c:import url="cabecalho.jsp" ></c:import>
                </div>

                <div id="content">
                    <ul class="breadcrumb">
                        <li><a href="indexProfessor.jsp">Inicio</a><span class="divider">></span></li>
                        <li class="active">Pedir Livro</li>
                    </ul>

                    <div class="navbar">
                        <div class="navbar-inner">
                            <ul class="nav">
                                <li id="pedirLivro"><a href="pedidoLivroProfessor.jsp" >Pedir Livro</a></li>
                                <li id="historicoPedidos"><a href="#">Histórico de Pedidos</a></li>
                            </ul>
                        </div>
                    </div>
                    <div id="conteudo">
                        <form action="CadastroPedidos" method="POST" accept-charset="ISO-8859-1">
                        <c:import url="historicoPedidos.jsp"></c:import>
                        </form>
                    </div>
                </div>

                <div id="sidebar">
                </div>

                <div id="footer">
                    <p style="text-align: center"><c:import url="rodape.jsp"></c:import></p>
            </div>
        </div>

    </body>
</html>

