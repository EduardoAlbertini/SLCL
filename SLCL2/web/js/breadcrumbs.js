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
    var req;
    var isIE;
    if (window.XMLHttpRequest) {
        req = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        isIE = true;
        req = new ActiveXObject("Microsoft.XMLHTTP");
    }
    var url = "PesquisaFormLivro?ISBN=" + document.getElementById("ISBN").value;
    req.onreadystatechange = processRequest;
    req.open("GET", url, true);
    req.send(null);

    if (req.readyState == 4) {
        if (req.status == 200) {
            texto = req.responseText;

        }
    }

    document.formulario.saida.value = texto;

}

function processRequest() {
    if (req.readyState == 4) {
        if (req.status == 200) {
            texto = req.responseText;



        }
    }
}



