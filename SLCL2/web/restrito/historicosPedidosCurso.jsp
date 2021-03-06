<%-- 
    Document   : históricoPedidos
    Created on : 19/04/2013, 13:32:44
    Author     : Miray
--%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>    
        <script type="text/javascript" src="../js/bootstrap.js"></script>    
        <script type="text/javascript" src="../js/bootstrap.min.js"></script>  
        <script type="text/javascript" src="../js/ajax.js"></script>  
        <script type="text/javascript" src="../js/breadcrumbs.js"></script>  
        <link href="../css/bootstrap-responsive.css" rel="stylesheet" media="screen">
        <link href="../css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
        <link href="../css/bootstrap.css" rel="stylesheet" media="screen">
        <link href="../css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="../css/PageCSS.css" rel="stylesheet" media="screen">
        <link rel="icon" type="image/png" href="../img/LogoSLCL.png" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>SLCL -Pedidos do Curso</title>
    </head>
    <body>
        <div id="container">
            <div id="header">
                <c:import url="cabecalho.jsp" ></c:import>
                </div>

                <div id="content">
                    <ul class="breadcrumb">
                        <li><a href="indexCoordenador.jsp">Inicio</a><span class="divider">></span></li>
                        <li class="active"><div id="migalhas">Lista de Livros Pedidos</div></li>
                    </ul>

                    <div class="navbar">
                        <div class="navbar-inner">
                            <ul class="nav">
                                <li id="pedirLivro"><a href="pedidoLivroCoordenador.jsp">Pedir Livro</a></li>
                                <li id="historicoPedidos"><a href="historicoPedidosCoordenador.jsp" onclick="chamarServlet('HistoricoPedidosLivro')">Histórico de Pedidos</a></li>
                                <li id="pedidosCurso"><a href="#">Pedidos do Curso</a></li>
                            </ul>
                        </div>
                    </div>
                    <div id="ajax">
                        <div id="conteudo">  
                            <form action="" method="" accept-charset="ISO-8859-1">
                                <fieldset>
                                    <legend>Histórico de Pedidos de Livros do Curso</legend>
                                    <div class="accordion" id="accordion2">
                                    <c:set var="count" value="${0}" />
                                    <c:forEach items="${listaPedidosCurso}" var="item">
                                        <div class="accordion-group">
                                            <div class="accordion-heading">
                                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapse${count}">
                                                    ${item.livro.titulo} (${item.disciplina.nome})
                                                </a>
                                            </div>
                                            <div id="collapse${count}" class="accordion-body collapse">
                                                <div class="accordion-inner">
                                                    <input type="hidden" name="pedido${count}" value="${item.id}" />
                                                    <p><b>ISBN:</b> ${item.livro.isbn}</p>
                                                    <p><b>Titulo Original:</b> ${item.livro.tituloOriginal}</p>
                                                    <p><b>Editora:</b> ${item.livro.editora}</p>
                                                    <p><b>Edição:</b> ${item.livro.edicao}</p>
                                                    <p><b>Quantidade:</b> ${item.qtde}</p>
                                                    <p><b>Tipo de Bibliografia:</b> ${item.bibliografia}</p>
                                                    <a href="../AutorizarPedidosCurso?pedido=${item.id}&botao=autorizar" name ="botao" class="btn btn-success" value="autorizar">Autorizar</a>
                                                    <a href="../AutorizarPedidosCurso?pedido=${item.id}&botao=cancelar" name ="botao" class="btn btn-danger" value="cancelar">Cancelar</a>
                                                </div>
                                            </div>
                                        </div>
                                        <c:set var="count" value="${count +1}" />    
                                    </c:forEach>
                                </div>
                            </fieldset>
                        </form>
                    </div>
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
