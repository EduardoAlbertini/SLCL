function open(url){

/*Essa função Carrega uma página HTML "dentro" de uma div da página HTML. Ela utiliza recursos AJAX para isso.
  Para altera-la, basta substituir o parâmetro na chamada da função
  getElementById('ID DA DIV QUE DEVE RECEBER O CONTEÚDO')*/

	var mreq;
	// Procura o componente nativo do Mozilla/Safari para rodar o AJAX 
	if(window.XMLHttpRequest){
		// Inicializa o Componente XMLHTTP do Mozilla
		mreq = new XMLHttpRequest();
	// Caso ele não encontre, procura por uma versão ActiveX do IE 
	}else if(window.ActiveXObject){ 
		// Inicializa o Componente ActiveX para o AJAX
		mreq = new ActiveXObject("Microsoft.XMLHTTP");
	}else{ 
		// Caso n�o consiga inicializar nenhum dos componentes, exibe um erro
		alert("Seu navegador não tem suporte a AJAX.");
	}

	// Carrega a fun��o de execu��o do AJAX
	mreq.onreadystatechange = function() {
		if(mreq.readyState == 1){
			// Quando estiver "Carregando a página", exibe a mensagem
			document.getElementById('ajax').innerHTML = 'carregando';			
		}else if(mreq.readyState == 4){ 
			// Quando estiver completado o Carregamento
			// Procura pela DIV com o id="ajax" e insere as informações 
			document.getElementById('ajax').innerHTML = mreq.responseText;
		}
	};
    // Envia via método GET as informações
    mreq.open("GET",url,true);
    mreq.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=iso-8859-1") 
    mreq.send(null);
}

