function alterarTexto(id) {
    if (id == 'inicio') {
        document.getElementById("migalhas").innerHTML = "";
    }
    var novoTexto = document.getElementById(id).innerHTML;
    document.getElementById("migalhas").innerHTML = novoTexto;

}

function adicionarTexto(id) {

    var novoTexto = document.getElementById(id).innerHTML;
    document.getElementById("migalhas").innerHTML += novoTexto;

}

function ajaxFunction() {
    var xmlhttp;
    var isIE;
    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        isIE = true;
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    var url = "PesquisaFormLivro?ISBN=" + document.getElementById("ISBN").value;

    xmlhttp.onreadystatechange = function()
    {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
        {
            texto = xmlhttp.responseText;
            texto_quebrado = texto.split(";")
            
            document.getElementById("ISBN").value = texto_quebrado[3];
            document.getElementById("titulo").value = texto_quebrado[0];
            document.getElementById("tituloOriginal").value = texto_quebrado[1];
            document.getElementById("autor").value = texto_quebrado[2];
            document.getElementById("editora").value = texto_quebrado[4];
            document.getElementById("edicao").value = texto_quebrado[5];
            document.getElementById("assunto").value = texto_quebrado[6];
        }
    }
    
    xmlhttp.open("GET",url,true);
    xmlhttp.send();

    alert("Texto" + req.responseText);
    document.getElementById("assunto").value = req.responseText;
//    document.formulario.saida.value = texto;

}
