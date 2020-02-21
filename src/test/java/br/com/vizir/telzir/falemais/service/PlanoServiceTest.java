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
import br.com.vizir.telzir.falemais.model.Plano;
import br.com.vizir.telzir.falemais.repository.LigacaoRepository;
import br.com.vizir.telzir.falemais.repository.PlanoRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PlanoServiceTest {

  private PlanoService planoService;

  private LigacaoService ligacaoService;

  @Autowired
  private LigacaoRepository ligacaoRepository;

  @Autowired
  private PlanoRepository planoRepository;

  @Before
  public void setUp() {
    planoService = new PlanoService(planoRepository);
    ligacaoService = new LigacaoService(ligacaoRepository);
  }

  @Test
  public void quandoObterTodosPlanos_entaoRetornarTresPlanos() {
    Iterable<Plano> planos = this.planoService.obterTodosPlanos();
    Integer expected = 3;

    assertNotNull(planos);
    assertThat(((Collection<Plano>) planos).size(), is(expected));
  }

  @Test
  public void quandoPesquisarPorPlanoDe30Minutos_entaoRetornarPlanoFaleMais30() {
    Optional<Plano> plano = this.planoService.obterPorMinutos(30L);

    testarPlano(plano, Boolean.TRUE, "FaleMais 30", 30L);
  }

  @Test
  public void quandoPesquisarPorPlanoDe60Minutos_entaoRetornarPlanoFaleMais60() {
    Optional<Plano> plano = this.planoService.obterPorMinutos(60L);

    testarPlano(plano, Boolean.TRUE, "FaleMais 60", 60L);
  }

  @Test
  public void quandoPesquisarPorPlanoDe120Minutos_entaoRetornarPlanoFaleMais120() {
    Optional<Plano> plano = this.planoService.obterPorMinutos(120L);

    testarPlano(plano, Boolean.TRUE, "FaleMais 120", 120L);
  }

  @Test
  public void quandoCalcularCustoLigacaoDe30MinutosDeOrigem011EDestino016NoPlano30_entaoRetornarCusto0() {
    Optional<Ligacao> ligacaoOptional = this.ligacaoService.obterPorOrigemDestino("011", "016");
    Ligacao ligacao = ligacaoOptional.get();

    Optional<Plano> planoOptional = this.planoService.obterPorMinutos(30L);
    Plano plano = planoOptional.get();

    testarPlano(planoOptional, Boolean.TRUE, "FaleMais 30", 30L);

    Double custo = this.planoService.calculaCusto(30L, plano, ligacao);

    assertThat(custo, is(0.0));
  }

  @Test
  public void quandoCalcularCustoLigacaoDe200MinutosDeOrigem018EDestino011NoPlano120_entaoRetornarCusto167E20() {
    Optional<Ligacao> ligacaoOptional = this.ligacaoService.obterPorOrigemDestino("018", "011");
    Ligacao ligacao = ligacaoOptional.get();

    Optional<Plano> planoOptional = this.planoService.obterPorMinutos(120L);
    Plano plano = planoOptional.get();

    testarPlano(planoOptional, Boolean.TRUE, "FaleMais 120", 120L);

    Double custo = this.planoService.calculaCusto(200L, plano, ligacao);

    assertThat(custo, is(167.20));
  }

  public static void testarPlano(Optional<Plano> plano, Boolean esperado, String descricaoEsperada,
      Long minutosEsperados) {
    assertThat(plano.isPresent(), is(esperado));
    assertThat(plano.get().getDescricao(), is(descricaoEsperada));
    assertThat(plano.get().getMinutos(), is(minutosEsperados));
  }

}
