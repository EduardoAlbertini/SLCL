function alterarTexto(id) {
    if (id == 'inicio') {
        document.getElementById("migalhas").innerHTML = "";
    } else {
        var novoTexto = document.getElementById(id).innerHTML;
        document.getElementById("migalhas").innerHTML = novoTexto;
    }

}

function adicionarTexto(id) {

    var novoTexto = document.getElementById(id).innerHTML;
    document.getElementById("migalhas").innerHTML += novoTexto;

}


