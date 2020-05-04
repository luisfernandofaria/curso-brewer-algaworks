$(function(){
	
	let modal = $('#modalCadastroRapidoEstilo');
	let botaoSalvar = modal.find('.js-modal-cadastro-estilo-salvar-btn');
	let form = modal.find('form');
	form.on('submit', function(event) {event.preventDefault()});
	let url = form.attr('action');
	let inputNomeEstilo = $('#nomeEstilo');
	let containerMensagemErro = $(".js-mensagem-cadastro-rapido-estilo");
			
	modal.on('shown.bs.modal', onModalShow);
	modal.on('hide.bs.modal', onModalClose);
	botaoSalvar.on('click', onBotaoSalvarClick);
	
	function onModalShow() {
		inputNomeEstilo.focus();
	}
	
	function onModalClose() {
		inputNomeEstilo.val('');
		containerMensagemErro.addClass('hidden');
		form.find('.form-group').removeClass('has-error');
	}
	
	function onBotaoSalvarClick() {
		let nomeEstilo = inputNomeEstilo.val().trim();
		$.ajax({
			url: url,
			method: 'POST',
			contentType: 'application/json',
			data: JSON.stringify({ nome: nomeEstilo }),
			error: onErroSalvandoEstilo,
			success: onEstiloSalvo
		})
	}
	
	function onErroSalvandoEstilo (obj) {
		let mensagemErro = obj.responseText;
		containerMensagemErro.removeClass('hidden');
		containerMensagemErro.html('<span>' +mensagemErro + '</span>');
		form.find('.form-group').addClass('has-error');
	}
	
	function onEstiloSalvo(estilo) {
		var comboEstilo = $('#estilo');
		comboEstilo.append('<option value=' + estilo.codigo + '>' + estilo.nome + '</option>');
		comboEstilo.val(estilo.codigo);
		modal.modal('hide');
	}
	
	
});