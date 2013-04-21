<%@ taglib uri = "http://java.sun.com/jstl/core" prefix = "c"%>

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
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Inicio</title>
    </head>
    <body>
        <div id="container">
            <div id="header">
                <c:import url="cabecalho.jsp" ></c:import>
                </div>

                <div id="content">
                    <ul class="breadcrumb">
                        <li><a href="javascript:open('index.jsp')" onclick="alterarTexto('inicio')">Inicio</a><span class="divider">></span></li>
                        <li class="active"><div id="migalhas"></div></li>
                    </ul>

                    <div class="navbar">
                        <div class="navbar-inner">
                            <ul class="nav">
                                <li id="pedirLivro"><a href="javascript:open('crudProfessor.jsp')" onclick="alterarTexto('pedirLivro')">Pedir Livro</a></li>
                                <li id="historicoPedidos"><a href="javascript:open('crudProfessor.jsp')" onclick="alterarTexto('historicoPedidos')">Histórico de Pedidos</a></li>
                            </ul>
                        </div>
                    </div>
                    <div id="ajax">
                    <c:import url="index.jsp"></c:import>
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
