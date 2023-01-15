package br.com.votacaosicredi.ap1.v1;


import static br.com.votacaosicredi.utils.Constantes.*;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.votacaosicredi.ap1.v1.dto.PautaRequestDTO;
import br.com.votacaosicredi.business.PautaService;
import br.com.votacaosicredi.utils.Constantes;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = BASE_PATH_PAUTA)
public class PautaRest {

	private final PautaService service;

	public PautaRest(PautaService service) {
		this.service = service;
	}

    @ApiOperation(value = "Salva uma nova pauta", response = HttpStatus.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = Constantes.AUTHORIZATION_HEADER, required = true, dataType = "string", paramType = "header", value = Constantes.AUTHORIZATION_HEADER_DESC),
    })
    @ApiResponses({
            @ApiResponse(code = 201, message = CREATED),
            @ApiResponse(code = 400, message = BAD_REQUEST),
            @ApiResponse(code = 401, message = UNAUTHORIZED),
            @ApiResponse(code = 500, message = INTERNAL_SERVER_ERROR)

    })
    @PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void salvarPauta(@RequestBody @Valid PautaRequestDTO votacaoRequestDTO) {
		service.salvarPauta(votacaoRequestDTO);
	}
}
