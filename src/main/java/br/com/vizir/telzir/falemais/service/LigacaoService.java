package br.com.vizir.telzir.falemais.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.vizir.telzir.falemais.model.Ligacao;
import br.com.vizir.telzir.falemais.repository.LigacaoRepository;

@Service
public class LigacaoService {

  private final LigacaoRepository ligacaoRepository;

  public LigacaoService(LigacaoRepository ligacaoRepository) {
    this.ligacaoRepository = ligacaoRepository;
  }

  public Iterable<String> obterTodasOrigens() {
    return ligacaoRepository.findAllOrigens();
  }

  public Iterable<String> obterTodosDestinos() {
    return ligacaoRepository.findAllDestinos();
  }

  public Optional<Ligacao> obterPorOrigemDestino(String origem, String destino) {
    return ligacaoRepository.findByOrigemAndDestino(origem, destino);
  }

  public Double calculaCusto(Long tempoLigacao, Ligacao ligacao) {
    return ligacao.getPreco() * tempoLigacao;
  }

}
