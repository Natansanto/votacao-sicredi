package br.com.votacaosicredi.ap1.v1;


import static br.com.votacaosicredi.utils.Constantes.*;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.votacaosicredi.ap1.v1.dto.VotacaoRequestDTO;
import br.com.votacaosicredi.ap1.v1.dto.VotacaoResponseDTO;
import br.com.votacaosicredi.business.VotacaoService;
import br.com.votacaosicredi.utils.Constantes;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = BASE_PATH_VOTACAO)
public class VotacaoRest {

    private final VotacaoService service;

    public VotacaoRest(VotacaoService service) {
        this.service = service;
    }
    
    @ApiOperation(value = "Salva um novo voto do associado", response = HttpStatus.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = Constantes.AUTHORIZATION_HEADER, required = true, dataType = "string", paramType = "header", value = Constantes.AUTHORIZATION_HEADER_DESC),
    })
    @ApiResponses({
            @ApiResponse(code = 201, message = CREATED),
            @ApiResponse(code = 400, message = BAD_REQUEST),
            @ApiResponse(code = 401, message = UNAUTHORIZED),
            @ApiResponse(code = 500, message = INTERNAL_SERVER_ERROR)

    })
    @PostMapping("/voto")
    @ResponseStatus(HttpStatus.CREATED)
    public void salvarVotacao(@RequestBody @Valid VotacaoRequestDTO votacaoRequestDTO) {
        service.salvarVotacao(votacaoRequestDTO);
    }
    
    @ApiOperation(value = "Busca votos por pauta", response = VotacaoResponseDTO.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = Constantes.AUTHORIZATION_HEADER, required = true, dataType = "string", paramType = "header", value = Constantes.AUTHORIZATION_HEADER_DESC),
  
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = OK),
            @ApiResponse(code = 400, message = BAD_REQUEST),
            @ApiResponse(code = 401, message = UNAUTHORIZED),
            @ApiResponse(code = 500, message = INTERNAL_SERVER_ERROR)
    })
    @GetMapping("/votos")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<VotacaoResponseDTO> buscarTodos(
    		 @RequestParam(value = "nome") String nome		
    ){
        return ResponseEntity.ok(service.buscarVotos(nome));
    }

}
