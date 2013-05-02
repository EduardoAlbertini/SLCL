function open(url) {

    var mreq;
    if (window.XMLHttpRequest) {
        mreq = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        mreq = new ActiveXObject("Microsoft.XMLHTTP");
    } else {
        alert("Seu navegador não tem suporte a AJAX.");
    }

    mreq.onreadystatechange = function() {
        if (mreq.readyState == 1) {
            document.getElementById('ajax').innerHTML = 'carregando';
        } else if (mreq.readyState == 4) {
            document.getElementById('ajax').innerHTML = mreq.responseText;
        }
    };
    mreq.open("GET", url, true);
    mreq.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=iso-8859-1")
    mreq.send(null);
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

            document.getElementById("tituloOriginal").value = texto_quebrado[0];
            document.getElementById("titulo").value = texto_quebrado[1];
            document.getElementById("autor").value = texto_quebrado[2];
            document.getElementById("editora").value = texto_quebrado[4];
            document.getElementById("edicao").value = texto_quebrado[5];
            document.getElementById("assunto").value = texto_quebrado[6];
        }
    }

    xmlhttp.open("GET", url, true);
    xmlhttp.send();

}

function ajaxPesquisaCursoFunction() {
    var xmlhttp;
    var isIE;
    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        isIE = true;
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    var url = "CadastroCurso?codigo=" + document.getElementById("codigo").value;

    xmlhttp.onreadystatechange = function()
    {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
        {
            texto = xmlhttp.responseText;
            texto_quebrado = texto.split(":")

            document.getElementById("codigo").value = texto_quebrado[0];
            document.getElementById("nome").value = texto_quebrado[1];
        }
    }

    xmlhttp.open("GET", url, true);
    xmlhttp.send();

}

