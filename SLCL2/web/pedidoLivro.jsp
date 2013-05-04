<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fieldset>
    <legend>Pedido de Livro</legend>
    <label for="ISBN">ISBN</label>
    <input id="ISBN" name="ISBN" type="text" placeholder="ISBN" onblur="ajaxFunction()" class="input-medium" style="height: 30px">
    <label for="titulo">T�tulo</label>
    <input id="titulo" name="titulo" type="text" placeholder="T�tulo do Livro" class="input-xxlarge" style="height: 30px">
    <label for="tituloOriginal">T�tulo Original</label>
    <input id="tituloOriginal" name="tituloOriginal" type="text" placeholder="T�tulo Original do Livro" class="input-xxlarge" style="height: 30px">
    <label for="autor">Autor(es)</label>
    <input id="autor" name="autor" type="text" placeholder="Autor" class="input-xlarge" style="height: 30px">
    <label for="editora">Editora</label>
    <input id="editora" name="editora" type="text" placeholder="Editora" style="height: 30px">
    <label for="edicao">Edi��o</label>
    <input id="edicao" name="edicao" type="text" placeholder="Edi��o" class="input-small" style="height: 30px">
    <label for="assunto">Assunto</label>
    <textarea id="assunto" name="assunto" rows="3" placeholder="Assunto do Livro" class="input-xlarge"></textarea>
    <label for="quantidade">Quantidade</label>
    <input id="quantidade" name="quantidade" type="text" placeholder="Quantidade" class="input-small" style="height: 30px">
    <label for="curso">Curso</label>
    <select id="curso" name="curso">
        <option>Selecione...</option>
        <c:forEach items="${cursos}" var="item">
            <option>${item.nome}</option>
        </c:forEach>
    </select>
    <label for="disciplina">Disciplina</label>
    <select id="disciplina" name="disciplina">
        <option>Selecione...</option>
        <option>op��es</option>
    </select>
    <label for="referencia">Refer�ncia</label>
    <select id="referencia" name="referencia">
        <option>Selecione...</option>
        <option>B�sica</option>
        <option>Complementar</option>
    </select>
</fieldset>
<button type="submit" name="submit" class="btn btn-info">Pedir</button>
<button type="reset" class="btn">Limpar</button>
