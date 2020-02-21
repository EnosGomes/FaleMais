package br.com.vizir.telzir.falemais.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vizir.telzir.falemais.model.Ligacao;
import br.com.vizir.telzir.falemais.model.Plano;
import br.com.vizir.telzir.falemais.model.ResultadoSimulacao;
import br.com.vizir.telzir.falemais.model.Simulacao;

@Service
public class SimuladorService {

  private @Autowired LigacaoService ligacaoService;

  private @Autowired PlanoService planoService;

  public List<ResultadoSimulacao> calcularMinutos(Simulacao simulacao) {
    ResultadoSimulacao resultadoSimulacao = new ResultadoSimulacao();

    resultadoSimulacao.setSimulacao(simulacao);

    // Pegar o plano atualizado
    Optional<Plano> planoAtual = planoService.obterPorId(simulacao.getPlano().getId());

    // Se ele ainda existir
    if (planoAtual.isPresent()) {

      // Atualiza as informações
      resultadoSimulacao.getSimulacao().setPlano(planoAtual.get());

      // Recupera a ligacao
      Optional<Ligacao> ligacaoOptional = ligacaoService.obterPorOrigemDestino(simulacao.getOrigem(),
          simulacao.getDestino());

      // Se ela existir
      if (ligacaoOptional.isPresent()) {
        Ligacao ligacao = ligacaoOptional.get();

        // Analisa custo com plano
        resultadoSimulacao
            .setComPlano(this.planoService.calculaCusto(simulacao.getTempoLigacao(), simulacao.getPlano(), ligacao));

        // Analisa custo sem plano
        resultadoSimulacao.setSemPlano(this.ligacaoService.calculaCusto(simulacao.getTempoLigacao(), ligacao));
      }
    }

    return Arrays.asList(resultadoSimulacao);
  }
}
