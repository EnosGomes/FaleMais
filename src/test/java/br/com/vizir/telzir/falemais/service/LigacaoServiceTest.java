package br.com.vizir.telzir.falemais.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.Collection;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.vizir.telzir.falemais.model.Ligacao;
import br.com.vizir.telzir.falemais.repository.LigacaoRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class LigacaoServiceTest {

  private LigacaoService ligacaoService;

  @Autowired
  private LigacaoRepository ligacaoRepository;

  @Before
  public void setUp() {
    ligacaoService = new LigacaoService(ligacaoRepository);
  }

  @Test
  public void quandoBuscarTodasOrigensDistintas_entaoRetornarQuatroOrigens() {
    Iterable<String> origens = this.ligacaoService.obterTodasOrigens();
    Integer esperado = 4;

    assertNotNull(origens);
    assertThat(((Collection<String>) origens).size(), is(esperado));
  }

  @Test
  public void quandoBuscarTodosDestinosDistintos_entaoRetornarQuatroDestinos() {
    Iterable<String> destinos = this.ligacaoService.obterTodosDestinos();
    Integer esperado = 4;

    assertNotNull(destinos);
    assertThat(((Collection<String>) destinos).size(), is(esperado));
  }

  @Test
  public void quandoBuscarPorOrigem011EDestino016_entaoRetornarUmaLigacaoDePreco190() {
    Optional<Ligacao> ligacaoOptional = this.ligacaoService.obterPorOrigemDestino("011", "016");

    testarLigacao(ligacaoOptional, Boolean.TRUE, "011", "016", 1.90);
  }

  @Test
  public void quandoBuscarPorOrigem017EDestino018_entaoRetornarUmaLigacaoNula() {
    Optional<Ligacao> ligacaoOptional = this.ligacaoService.obterPorOrigemDestino("017", "018");

    assertThat(ligacaoOptional.isPresent(), is(Boolean.FALSE));
  }

  @Test
  public void quandoCalcularCustoLigacaoDe30MinutosDeOrigem011EDestino016_entaoRetornarCusto57() {
    Optional<Ligacao> ligacaoOptional = this.ligacaoService.obterPorOrigemDestino("011", "016");
    Ligacao ligacao = ligacaoOptional.get();

    testarLigacao(ligacaoOptional, Boolean.TRUE, "011", "016", 1.90);

    Double custo = this.ligacaoService.calculaCusto(30L, ligacao);

    assertThat(custo, is(57.0));
  }

  public static void testarLigacao(Optional<Ligacao> ligacao, Boolean esperado, String origemEsperada,
      String destinoEsperado, Double precoEsperado) {

    assertThat(ligacao.isPresent(), is(esperado));

    if (esperado) {
      assertThat(ligacao.get().getOrigem(), is(origemEsperada));
      assertThat(ligacao.get().getDestino(), is(destinoEsperado));
      assertThat(ligacao.get().getPreco(), is(precoEsperado));
    }
  }
}
