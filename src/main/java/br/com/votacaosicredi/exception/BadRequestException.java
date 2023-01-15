package br.com.votacaosicredi.exception;

import br.com.votacaosicredi.config.BusinessException;

public class BadRequestException extends BusinessException {

	private static final long serialVersionUID = 1L;

	public BadRequestException(String mensagem) {
		super(mensagem);
	}

}
