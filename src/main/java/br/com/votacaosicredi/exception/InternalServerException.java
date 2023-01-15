package br.com.votacaosicredi.exception;

import br.com.votacaosicredi.config.BusinessException;

public class InternalServerException extends BusinessException {
	
	private static final long serialVersionUID = 1L;

	public InternalServerException(String mensagem) {
		super(mensagem);
	}
}
