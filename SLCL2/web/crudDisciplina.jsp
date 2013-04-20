<%-- 
    Document   : cadProfessor
    Created on : 20/04/2013, 16:06:32
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
        <title>CRUD Disciplina</title>
    </head>
    <body>
        <form>
            <fieldset>
                <legend>Disciplina</legend>
                <label for="codigo">Código da Disciplina</label>
                <input id="codigo" type="text" placeholder="Código" class="input-medium" style="height: 30px">
                <a class="btn" href="#" title="Pesquisar Disciplina" ><i class="icon-search" ></i></a>
                <label for="nome">Nome</label>
                <input id="nome" type="text" placeholder="Nome da Disciplina" class="input-xxlarge" style="height: 30px">
                <label for="curso">Curso</label>
                <select id="curso">
                    <option>Selecione...</option>
                    <option>opções</option>
                </select>

            </fieldset>
            <button type="submit" class="btn btn-info ">Inserir</button>
            <button type="submit" class="btn btn-danger">Excluir</button>
            <button type="reset" class="btn">Limpar</button>
        </fieldset>
    </form>
</body>
</html>
