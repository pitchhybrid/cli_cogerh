$(document).ready(function () {
	populate();
    //Initialize tooltips
    $('.nav-tabs > li a[title]').tooltip();
    
    //Wizard
    $('a[data-toggle="tab"]').on('show.bs.tab', function (e) {

        var $target = $(e.target);
    
        if ($target.parent().hasClass('disabled')) {
            return false;
        }
    });

    /*$(".next-step").click(function (e) {

        var $active = $('.wizard .nav-tabs li.active');
        $active.next().removeClass('disabled');
        nextTab($active); 

    });*/
    $(".prev-step").click(function (e) {

        var $active = $('.wizard .nav-tabs li.active');
        prevTab($active);

    });

    masks();

    $("#step1 .form-control").change(function(e){
    	progressBar();
    });
    
    $("#cnpj").ready(function(){
    	populate();
    });
    $("#cpf").ready(function(){
    	populate();
    });
    
    $("#cep").keyup(function(e){
    	resetEndereco.prototype.constructor();
    	
    }).change(function(){    	
    	preencherEndereco(this);
    });
    
    $("li[role=presentation]").click(function(e){
    	armazenar();
    	$("#atualizar").click();
    });
});

function progressBar(){
	var current = 0;
	var arr = $("#step1 .form-control");
    var bar = 0;
    var porcentagem = "";
    var len = arr.length;
    for(var i=0 ;i < arr.length;i++){
    	if(arr[i].value != "" || null || 0){
    		current++;
    	}
    }
    bar = (current / len) * 100;
	porcentagem = String(bar.toFixed(0)).concat("%");
	$("#bar").css("width",porcentagem);
	$("#porcentagem").text(porcentagem);
	// progress-bar-success
    // progress-bar-yellow
    // progress-bar-primary
	if(bar > 0 && bar < 25){
		$("#bar").addClass(["progress-bar","progress-bar-danger"]);
	}
	if(bar > 25 && bar < 50){
		$("#bar").removeClass().addClass(["progress-bar","progress-bar-yellow"]);
	}
	if(bar > 50 && bar < 75){
		
		$("#bar").removeClass().addClass(["progress-bar","progress-bar-primary"]);
	}
	if(bar > 75 && bar<=100){
		$("#bar").removeClass().addClass(["progress-bar","progress-bar-success"]);
	}
}


function masks(){
	$("#cpf").mask('000.000.000-00',{
		placeholder: "000.000.000-00",
		'translation': {
			0: { pattern: /[0-9*]/}
	}});
	
	$("#cnpj").mask('000.000.000/0000-00',{
		placeholder: "000.000.000/0000-00",
		'translation': {
			0: { pattern: /[0-9*]/}
	}});
	
    $("#numero").mask("00000000",{
    	'translation': {
    		0: {pattern: /[0-9*]/}
    }});
    
    $("#cep").mask('00.000-000',{
    	placeholder: "00.000-000",
    	'translation': {
    		0: {pattern: /[0-9*]/}
    }});
    
    $("#telefone").mask('(00) 0000-0000',{
    	placeholder: "(00) 1234-5678",
    	'translation': {
    		0: {pattern: /[0-9*]/}
    }});
    
    $("#celular").mask('(00) 0 0000-0000',{
    	placeholder: "(00) 9 1234-5678",
    	'translation': {
    		0: {pattern: /[0-9*]/}
    }});
    
    $("#rg").mask('0000000000000',{
    	placeholder:"RG",
    	'translation': {
    		0: {pattern: /[0-9*]/}
    }});
}
function proximo(elem) {
	
	var arr = $("#step1 .form-control");
    var $active = $('.wizard .nav-tabs li.active');
    $active.next().removeClass('disabled');
    checkUntdForm();
    if(checkFormAll().length > 0){
    	if(checkFormAll().length == arr.length){    		
    		nextTab($active);
    		checkUntdForm();
    	}
    }
    progressBar();
}

function nextTab(elem) {
    $(elem).next().find('a[data-toggle="tab"]').click();
    masks();
}

function prevTab(elem) {
    $(elem).prev().find('a[data-toggle="tab"]').click();
    masks();
}

function checkFields(elem){
	if(elem.target.value.length > 0)
		return true;
	else
		return false;
}

function hasValue(elem){
	if(elem.value){
		return true;
	}else{
		return false;
	}
}

function checkFormAll(){
	var ch = [];
	var arr = $("#step1 .form-control");
	for(var i=0;i<arr.length;i++){
		if(hasValue(arr[i])){
			ch.push(true);
		}
	}
	return ch;
}

function checkUntdForm(){
	var ch = [];
	var arr = $("#step1 .form-control");
	for(var i =0;i<arr.length;i++){
		if(!hasValue(arr[i])){
			ch.push(true);
			$(arr[i]).parent().addClass("has-error");
			if($(arr[i]).find(".help-block").length == 0)
			$(arr[i]).parent().find('.help-block').css("display","block");
			
		}else{
			$(arr[i]).parent().removeClass("has-error");
			$(arr[i]).parent().find(".help-block").css("display","none");
		}
	}
	return ch;
}

function populate(){
	var cookie = getCookie("dados");
	if(cookie != null){
		var json   = JSON.parse(cookie);
		var keys   = Object.keys(json);
		var values = Object.values(json);
		if(keys.includes("cnpj")){
			$("input[value=JURIDICA]").click();
		}
		if(keys.includes("cpf")){
			$("input[value=FISICA]").click();
		}
		
		for(var i=0;i<keys.length;i++){
			$("#"+keys[i]).val(values[i]).click();
		}
		
	}
	progressBar();
}

function armazenar(name,values){
	limparCookie();
	if(name && values){
		document.cookie = name+"=" + values + ";";
		return;
	}
	document.cookie = "dados=" + createJson() + ";" ;
}

function getCookie(name){
	var cookie = document.cookie;
	var arr = cookie.split(";");
	var found = "";
	for(var i=0;i<arr.length;i++){
		if(arr[i].includes(name+"=")){
			found = arr[i].replace(name+"=","");
		}
	}
	return found == "" ? null:found;
}

function limparCookie(name){
	if(name){
		document.cookie = name+"=";
		return;
	}
	document.cookie = "dados=";
}

function createJson(){
	var arr = $("#step1 .form-control");
	var dados = {};
	for( var i=0;i<arr.length;i++){
		dados[arr[i].name] = arr[i].value;
	}
	return JSON.stringify(dados);
}

function confirmarDados(){
	
}

function getEndereco(cep,callback){
	
	if(cep.match(/(\d\d)\.(\d\d\d)-(\d\d\d)/g)){
		var c = cep.replace(".","").replace("-","");
		makeRequest("https://viacep.com.br/ws/"+ c +"/json/","GET").then(function(e){
			var json = JSON.parse(e.response);
			callback(json);
		});
	}
}

function preencherEndereco(e) {
	getEndereco(e.value,function(json_data){
		$('#endereco').val(json_data.logradouro);
		$('#bairro').val(json_data.bairro);
		$('#municipio').val(json_data.localidade);
		$('#complemento').val(json_data.complemento);

	});
}

function resetEndereco() {
	$('#endereco').val("");
	$('#bairro').val("");
	$('#municipio').val("");
	$('#complemento').val("");
}

function makeRequest(url, method) {

	// Create the XHR request
	var request = new XMLHttpRequest();

	// Return it as a Promise
	return new Promise(function (resolve, reject) {

		// Setup our listener to process compeleted requests
		request.onreadystatechange = function () {

			// Only run if the request is complete
			if (request.readyState !== 4) return;

			// Process the response
			if (request.status >= 200 && request.status < 300) {
				// If successful
				resolve(request);
			} else {
				// If failed
				reject({
					status: request.status,
					statusText: request.statusText
				});
			}

		};

		// Setup our HTTP request
		request.open(method || 'GET', url, true);

		// Send the request
		request.send();

	});
};