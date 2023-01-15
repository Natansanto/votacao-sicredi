package br.com.votacaosicredi.utils;

public class Constantes {

	private Constantes() {
	}

	public static final String BASE_PATH_VOTACAO = "api/v1/votacao";
	public static final String BASE_PATH_PAUTA = "api/v1/pauta";

	public static final String AUTHORIZATION_HEADER = org.springframework.http.HttpHeaders.AUTHORIZATION;
	public static final String AUTHORIZATION_HEADER_DESC = "Token de autorização";

	// HTTP status codes
	public static final String OK = "OK";
	public static final String NO_CONTENT = "No Content, o servidor executou com sucesso o método, mas não há nenhum corpo de entidade para retornar.";
	public static final String CREATED = "Requisição foi bem sucedida e um novo recurso foi criado.";
	public static final String UNPROCESSABLE_ENTITY = "Erro de negócio, não foi possível processar as instruções presentes.";
	public static final String INTERNAL_SERVER_ERROR = "Erro interno, algo inesperado deu errado no servidor.";
	public static final String UNAUTHORIZED = "Acesso não autorizado.";
	public static final String BAD_REQUEST = "Dados da requisição inválida.";
	public static final String NOT_FOUND = "Recurso não está disponível.";

	// PautaService
	public static final String ERRO_AO_SALVAR_PAUTA = "Erro ao salvar pauta. Erro: %s";
	public static final String PAUTA_NAO_EXISTE = "Não existe pauta com esse nome: %s";

	// VotacaoService
	public static final String ERRO_AO_SALVAR_VOTO = "Erro ao salvar voto: %s";
	public static final String VOTO_JA_CADASTRADO = "Existe um voto já cadastrado para esse cpf: %s nessa pauta: %s";
	public static final String ERRO_AO_BUSCAR_VOTOS = "Erro ao buscar votos para a pauta: %s";
	public static final String CPF_INVALIDO = "Cpf bloqueado para votar: %s";
	
	//ApiValidaCpfService
	public static final String ERRO_AO_VALIDAR_CPF = "Erro ao validar cpf: %s";	
}
