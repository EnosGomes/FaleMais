package br.com.vizir.telzir.falemais.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.Collection;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.vizir.telzir.falemais.model.Ligacao;

@RunWith(SpringRunner.class)
@DataJpaTest
public class LigacaoRepositoryTest {

  @Autowired
  private LigacaoRepository ligacaoRepository;

  @Test
  public void quandoObterTodosPlanos_entaoRetornarTresPlanos() {
    Iterable<Ligacao> ligacoes = this.ligacaoRepository.findAll();
    Integer expected = 6;

    assertNotNull(ligacoes);
    assertThat(((Collection<Ligacao>) ligacoes).size(), is(expected));
  }

  @Test
  public void quandoBuscarTodasOrigensDistintas_entaoRetornarQuatroOrigens() {
    Iterable<String> origens = this.ligacaoRepository.findAllOrigens();
    Integer expected = 4;

    assertNotNull(origens);
    assertThat(((Collection<String>) origens).size(), is(expected));
  }

  @Test
  public void quandoBuscarTodosDestinosDistintos_entaoRetornarQuatroDestinos() {
    Iterable<String> destinos = this.ligacaoRepository.findAllDestinos();
    Integer expected = 4;

    assertNotNull(destinos);
    assertThat(((Collection<String>) destinos).size(), is(expected));
  }

  @Test
  public void quandoBuscarPorOrigem011EDestino016_entaoRetornarUmaLigacaoDePreco190() {
    Optional<Ligacao> ligacaoOptional = this.ligacaoRepository.findByOrigemAndDestino("011", "016");
    Ligacao ligacao = ligacaoOptional.get();

    assertNotNull(ligacao);
    assertThat(ligacao.getOrigem(), is("011"));
    assertThat(ligacao.getDestino(), is("016"));
    assertThat(ligacao.getPreco(), is(1.90));
  }

  @Test
  public void quandoBuscarPorOrigem017EDestino018_entaoRetornarUmaLigacaoNula() {
    Optional<Ligacao> ligacaoOptional = this.ligacaoRepository.findByOrigemAndDestino("017", "018");

    assertThat(ligacaoOptional.isPresent(), is(Boolean.FALSE));
  }

}
