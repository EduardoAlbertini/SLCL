<%-- 
    Document   : contato
    Created on : 19/04/2013, 13:14:57
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
        <title>Contato</title>
    </head>
</head>
<body>
    <form>
        <fieldset>
            <legend>Contato</legend>
            <label for="nome">Nome</label>
            <input id="nome" type="text" placeholder="Nome" class="input-xlarge" style="height: 30px">
            <label for="email">E-mail</label>
            <input id="email" type="email" placeholder="email@email.com" class="input-xlarge" style="height: 30px">
            <label for="assunto">Assunto</label>
            <input id="assunto" type="text" placeholder="Assunto" class="input-xlarge" style="height: 30px">
            <label for="mensagem">Assunto</label>
            <textarea id="mensagem" rows="5" placeholder="Mensagem" class="input-xlarge"></textarea>
        </fieldset>
        <button type="submit" class="btn btn-info">Enviar</button>
        <button type="reset" class="btn">Limpar</button>
    </form>
</body>
</html>
