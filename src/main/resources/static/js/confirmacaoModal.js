$('#modalConfirmacaoModal').on('show.bs.modal', function(e){
	var button = $(e.relatedTarget);
	var idAluno = button.data('id');
	
	var nomeAluno = button.data('nome');
	
	var modal = $(this);
	var form = modal.find('form');
	var action = form.data('url-base');
	
	if(!action.endsWith('/')){
		action += '/';
	}
	form.attr('action', action + idAluno);
	
	modal.find('.modal-body span').html('Tem certeza que deseja excluir o Aluno <strong>'+ nomeAluno +'</strong> ?');
});