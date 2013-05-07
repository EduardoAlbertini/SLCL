
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
        <title>SLCL - Cadastro de Professor</title>
    </head>
    <body>
        <div id="container">
            <div id="header">
                <c:import url="cabecalho.jsp" ></c:import>
                </div>

                <div id="content">
                    <ul class="breadcrumb">
                        <li><a href="indexBibliotecario.jsp">Inicio</a><span class="divider">></span></li>
                        <li class="active">Cadastro de Professor</li>
                    </ul>

                    <div class="navbar">
                        <div class="navbar-inner">
                            <ul class="nav">
                                <li id="professor"><a href="#">Professor</a></li>
                                <li id="coordenador"><a href="crudCoordenador.jsp" >Coordenador</a></li>
                                <li id="curso"><a href="crudCurso.jsp" >Curso</a></li>
                                <li id="disciplina"><a href="ComboBoxCurso" >Disciplina</a></li>
                                <li id="listaPedidos"><a>Lista de Livros Pedidos</a></li>
                            </ul>
                        </div>
                    </div>
                    <div id="conteudo">
                        <form>
                            <fieldset>
                                <legend>Professor</legend>
                                <label for="codigo">Código do Professor</label>
                                <input id="codigo" type="text" placeholder="Código" class="input-medium" style="height: 30px">
                                <a class="btn" href="#" title="Pesquisar Professor" ><i class="icon-search" ></i></a>
                                <label for="nome">Nome</label>
                                <input id="nome" type="text" placeholder="Nome" class="input-xlarge" style="height: 30px">
                                <label for="sobrenome">Sobrenome</label>
                                <input id="sobrenome" type="text" placeholder="Sobrenome" class="input-xxlarge" style="height: 30px">

                            </fieldset>
                            <button type="submit" class="btn btn-info">Inserir</button>
                            <button type="submit" class="btn">Alterar</button>
                            <button type="submit" class="btn btn-danger">Excluir</button>
                            <button type="reset" class="btn">Limpar</button>
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
