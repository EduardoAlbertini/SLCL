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
        <title>SLCL -Pedidos Aprovados</title>
    </head>
    <body>
        <div id="container">
            <div id="header">
                <c:import url="cabecalho.jsp" ></c:import>
                </div>

                <div id="content">
                    <ul class="breadcrumb">
                        <li><a href="indexBibliotecario.jsp">Inicio</a><span class="divider">></span></li>
                        <li class="active"><div id="migalhas">Lista de Livros Pedidos</div></li>
                    </ul>

                    <div class="navbar">
                        <div class="navbar-inner">
                            <ul class="nav">
                                <li id="coordenador"><a href="crudCoordenador.jsp" >Coordenador</a></li>
                                <li id="curso"><a href="../ComboBoxCoordenador" >Curso</a></li>
                                <li id="disciplina"><a href="../ComboBoxCurso" >Disciplina</a></li>
                                <li id="listaPedidos"><a href="#">Lista de Livros Pedidos</a></li>
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
                                    <c:forEach items="${pedidosAutorizados}" var="item">
                                        <div class="accordion-group">
                                            <div class="accordion-heading">
                                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapse${count}">
                                                    ${item.livro.titulo} (${item.curso.codigo}) - ${item.evento.estado}
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
                                                    <p><b>Curso:</b> ${item.curso.nome}</p>
                                                    <p><b>Disciplina:</b> ${item.disciplina.nome}</p>
                                                    <p><b>Tipo de Bibliografia:</b> ${item.bibliografia}</p>

                                                    <c:if test="${item.evento.estado eq 'AUTORIZADO'}">
                                                        <a href="LicitacaoPedidoLivro?pedido=${item.id}&botao=licitar" name ="botao" class="btn btn-info" value="licitar">Licitar</a>
                                                        <a href="LicitacaoPedidoLivro?pedido=${item.id}&botao=recusar" name ="botao" class="btn btn-danger" value="recusar">Recusado</a>
                                                    </c:if>
                                                    <c:if test="${item.evento.estado eq 'LICITADO'}">
                                                        <a href="LicitacaoPedidoLivro?pedido=${item.id}&botao=adquirir" name ="botao" class="btn btn-inverse" value="adquirir">Adquirir</a>
                                                        <a href="LicitacaoPedidoLivro?pedido=${item.id}&botao=cancelar" name ="botao" class="btn btn-warning" value="cancelar">Cancelar</a>
                                                    </c:if>
                                                    <c:if test="${item.evento.estado eq 'ADQUIRIDO'}">
                                                        <a href="LicitacaoPedidoLivro?pedido=${item.id}&botao=disponivel" name ="botao" class="btn btn-success" value="disponivel">Disponível</a>
                                                    </c:if>
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
