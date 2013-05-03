<%-- 
    Document   : históricoPedidos
    Created on : 19/04/2013, 13:32:44
    Author     : Miray
--%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
        <title>SLCL - Histórico de Pedidos</title>
    </head>
    <body>
        <div id="container">
            <div id="header">
                <c:import url="cabecalho.jsp" ></c:import>
                </div>

                <div id="content">
                    <ul class="breadcrumb">
                        <li><a href="indexProfessor.jsp">Inicio</a><span class="divider">></span></li>
                        <li class="active">HistóricoPedidos</li>
                    </ul>

                    <div class="navbar">
                        <div class="navbar-inner">
                            <ul class="nav">
                                <li id="pedirLivro"><a href="pedidoLivro.jsp" >Pedir Livro</a></li>
                                <li id="historicoPedidos"><a href="#">Histórico de Pedidos</a></li>
                            </ul>
                        </div>
                    </div>
                    <div id="conteudo">
                        <form action="HistoricoPedidosLivro" method="POST">
                            <fieldset>
                                <legend>Histórico de Pedidos de Livros</legend>
                                <div class="accordion" id="accordion2">
                                <c:set var="count" value="${0}" />
                                <c:forEach items="${pedidosLivro}" var="item">
                                    <div class="accordion-group">
                                        <div class="accordion-heading">
                                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapse${count}">
                                                ${item.livro.titulo}
                                            </a>
                                        </div>
                                        <div id="collapse${count}" class="accordion-body collapse">
                                            <div class="accordion-inner">
                                                <p><b>ISBN:</b> ${item.livro.isbn}</p>
                                                <p><b>Titulo Original:</b> ${item.livro.tituloOriginal}</p>
                                                <p><b>Editora:</b> ${item.livro.editora}</p>
                                                <p><b>Edição:</b> ${item.livro.edicao}</p>
                                                <p><b>Quantidade:</b> ${item.qtde}</p>
                                                <p><b>Curso:</b> ${item.curso.nome}</p>
                                                <p><b>Disciplina:</b> ${item.curso.disciplina.nome}</p>
                                                <p><b>Tipo de Bibliografia:</b> ${item.bibliografia}</p>
                                            </div>
                                        </div>
                                    </div>
                                    <c:set var="count" value="${count +1}" />    
                                </c:forEach>
                            </div>
                        </fieldset>
                        <button type="submit" name="submit" class="btn btn-info">Atualizar Lista</button>
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
