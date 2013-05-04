
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>

<form action="CadastroPedidos" method="GET">
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
</form>