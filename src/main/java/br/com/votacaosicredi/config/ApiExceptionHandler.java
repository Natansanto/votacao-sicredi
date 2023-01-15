package br.com.votacaosicredi.config;

import java.time.OffsetDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.votacaosicredi.exception.BadRequestException;
import br.com.votacaosicredi.exception.InternalServerException;
import br.com.votacaosicredi.exception.NotFoundException;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<Object> handleVotoDuplicado(Exception ex, WebRequest request) {
		String votoErro = "Dados da requisição inválida.";

		HttpStatus status = HttpStatus.BAD_REQUEST;

		String detail = ex.getMessage();

		ex.printStackTrace();

		Problem problem = createProblemBuilder(status, votoErro, detail).userMessage(detail).build();

		return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
	}
	
	@ExceptionHandler(InternalServerException.class)
	public ResponseEntity<Object> Exception(Exception ex, WebRequest request) {
		String votoErro = "Erro interno, algo inesperado deu errado no servidor.";

		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

		String detail = ex.getMessage();

		ex.printStackTrace();

		Problem problem = createProblemBuilder(status, votoErro, detail).userMessage(detail).build();

		return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
	}
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<Object> VotosException(Exception ex, WebRequest request) {
		String votoErro = "Recurso não está disponível.";

		HttpStatus status = HttpStatus.NOT_FOUND;

		String detail = ex.getMessage();

		ex.printStackTrace();

		Problem problem = createProblemBuilder(status, votoErro, detail).userMessage(detail).build();

		return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
	}

	private Problem.ProblemBuilder createProblemBuilder(HttpStatus status, String problemType, String detail) {
		return Problem.builder()
				.status(status.value())
				.timestamp(OffsetDateTime.now())
				.title(problemType)
				.detail(detail);
	}
}
