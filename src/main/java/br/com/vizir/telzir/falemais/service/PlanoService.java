package br.com.vizir.telzir.falemais.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.vizir.telzir.falemais.model.Ligacao;
import br.com.vizir.telzir.falemais.model.Plano;
import br.com.vizir.telzir.falemais.repository.PlanoRepository;

@Service
public class PlanoService {

  private final PlanoRepository planoRepository;

  public PlanoService(PlanoRepository planoRepository) {
    this.planoRepository = planoRepository;
  }

  public Iterable<Plano> obterTodosPlanos() {
    return planoRepository.findAll();
  }

  public Optional<Plano> obterPorId(Long id) {
    return planoRepository.findById(id);
  }

  public Optional<Plano> obterPorMinutos(Long minutos) {
    return planoRepository.findByMinutos(minutos);
  }

  public Double calculaCusto(Long tempoLigacao, Plano plano, Ligacao ligacao) {
    Double custoComPlano = 0.0;

    // Se o tempo de ligacao for maior que o plano, calcula o excedente e adiciona
    // mais 10% do valor excedente
    if (tempoLigacao > plano.getMinutos()) {
      Double custoExcedente = (double) (tempoLigacao - plano.getMinutos()) * ligacao.getPreco();
      custoComPlano = custoExcedente + 0.1 * custoExcedente;
    }

    return custoComPlano;
  }

}
