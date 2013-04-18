<%-- 
    Document   : pedidoLivro
    Created on : 18/04/2013, 19:31:53
    Author     : Miray
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>    
        <script type="text/javascript" src="js/bootstrap.js"></script>    
        <script type="text/javascript" src="js/bootstrap.min.js"></script>  
        <link href="css/bootstrap-responsive.css" rel="stylesheet" media="screen">
        <link href="css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
        <link href="css/bootstrap.css" rel="stylesheet" media="screen">
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Pedido de Livro</title>
    </head>
    <body>
        <form>
            <fieldset>
                <legend>Pedido de Livro</legend>
                <label for="ISBN">ISBN</label>
                <input id="ISBN" type="text" placeholder="ISBN" class="input-medium">
                <label for="titulo">Título</label>
                <input id="titulo" type="text" placeholder="Ttulo do Livro" class="input-xxlarge">
                <label for="tituloOriginal">Título Original</label>
                <input id="tituloOriginal" type="text" placeholder="Título Original do Livro" class="input-xxlarge">
                <label for="autor">Autor(es)</label>
                <input id="autor" type="text" placeholder="Autor" class="input-xlarge">
                <label for="editora">Editora</label>
                <input id="editora" type="text" placeholder="Editora">
                <label for="edicao">Edição</label>
                <input id="edicao" type="text" placeholder="Edição" class="input-small">
                <label for="assunto">Assunto</label>
                <textarea id="assunto" rows="3" placeholder="Assunto do Livro" class="input-xlarge"></textarea>
                <label for="curso">Curso</label>
                <select id="curso">
                    <option>Selecione...</option>
                    <option>opções</option>
                </select>
                <label for="disciplina">Disciplina</label>
                <select id="disciplina">
                    <option>Selecione...</option>
                    <option>opções</option>
                </select>
                <label for="referencia">Referência</label>
                <select id="referencia">
                    <option>Selecione...</option>
                    <option>opções</option>
                </select>
            </fieldset>
            <button type="submit" class="btn btn-info">Pedir</button>
            <button type="reset" class="btn">Limpar</button>
        </form>

    </body>
</html>
