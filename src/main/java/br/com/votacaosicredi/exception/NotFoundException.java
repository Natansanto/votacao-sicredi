package br.com.votacaosicredi.exception;

import br.com.votacaosicredi.config.BusinessException;

public class NotFoundException extends BusinessException {

	private static final long serialVersionUID = 1L;

	public NotFoundException(String mensagem) {
		super(mensagem);
	}

}
