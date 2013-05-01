<%-- 
    Document   : históricoPedidos
    Created on : 19/04/2013, 13:32:44
    Author     : Miray
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>    
        <script type="text/javascript" src="js/bootstrap.js"></script>    
        <script type="text/javascript" src="js/bootstrap.min.js"></script>  
        <script type="text/javascript" src="js/ajax.js"></script>  
        <link href="css/bootstrap-responsive.css" rel="stylesheet" media="screen">
        <link href="css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
        <link href="css/bootstrap.css" rel="stylesheet" media="screen">
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Histórico de Pedidos</title>
    </head>
    <body>
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
    </body>
</html>
