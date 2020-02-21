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

import br.com.vizir.telzir.falemais.model.Plano;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PlanoRepositoryTest {

  @Autowired
  private PlanoRepository planoRepository;

  @Test
  public void quandoObterTodosPlanos_entaoRetornarTresPlanos() {
    Iterable<Plano> planos = this.planoRepository.findAll();
    Integer expected = 3;

    assertNotNull(planos);
    assertThat(((Collection<Plano>) planos).size(), is(expected));
  }

  @Test
  public void quandoPesquisarPorPlanoDe30Minutos_entaoRetornarPlanoFaleMais30() {
    Optional<Plano> plano = this.planoRepository.findByMinutos(30L);

    assertThat(plano.isPresent(), is(Boolean.TRUE));
    assertThat(plano.get().getDescricao(), is("FaleMais 30"));
    assertThat(plano.get().getMinutos(), is(30L));
  }

  @Test
  public void quandoPesquisarPorPlanoDe60Minutos_entaoRetornarPlanoFaleMais60() {
    Optional<Plano> plano = this.planoRepository.findByMinutos(60L);

    assertThat(plano.isPresent(), is(Boolean.TRUE));
    assertThat(plano.get().getDescricao(), is("FaleMais 60"));
    assertThat(plano.get().getMinutos(), is(60L));
  }

  @Test
  public void quandoPesquisarPorPlanoDe120Minutos_entaoRetornarPlanoFaleMais120() {
    Optional<Plano> plano = this.planoRepository.findByMinutos(120L);

    assertThat(plano.isPresent(), is(Boolean.TRUE));
    assertThat(plano.get().getDescricao(), is("FaleMais 120"));
    assertThat(plano.get().getMinutos(), is(120L));
  }

}
