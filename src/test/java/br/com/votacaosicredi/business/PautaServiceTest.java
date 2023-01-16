package br.com.votacaosicredi.business;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.votacaosicredi.business.converters.PautaConverter;
import br.com.votacaosicredi.config.BusinessException;
import br.com.votacaosicredi.infrastructure.repository.PautaRepository;
import br.com.votacaosicredi.testUtils.MockUtils;

@RunWith(MockitoJUnitRunner.class)
public class PautaServiceTest extends MockUtils {

	@InjectMocks
	PautaService service;

	@Mock
	PautaRepository repository;

	@Spy
	PautaConverter converter;

	@Test
	public void deveSalvarPauta() {

		when(repository.save(buildPauta())).thenReturn(buildPauta());

		service.salvarPauta(buildPautaRequestDTO());

		verify(repository, times(1)).save(buildPauta());
	}
	
    @Test(expected = BusinessException.class)
    public void deveRetornarExceptionAoSalvarPauta() {
    	
    	when(repository.save(buildPauta())).thenReturn(null);
       
    	service.salvarPauta(buildPautaRequestDTO());

        verify(repository, times(0)).save(buildPauta());
    }
}
