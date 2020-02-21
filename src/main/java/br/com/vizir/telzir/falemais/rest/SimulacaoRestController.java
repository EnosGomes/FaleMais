package br.com.vizir.telzir.falemais.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vizir.telzir.falemais.model.ResultadoSimulacao;
import br.com.vizir.telzir.falemais.model.Simulacao;
import br.com.vizir.telzir.falemais.service.SimuladorService;

@RestController
@RequestMapping("/api/simulador")
@CrossOrigin
public class SimulacaoRestController {

  private @Autowired SimuladorService simuladorService;

  @PostMapping("/calcular-minutos")
  public ResponseEntity<List<ResultadoSimulacao>> calcularMinutos(@RequestBody Simulacao simulacao) {
    return ResponseEntity.ok(simuladorService.calcularMinutos(simulacao));
  }
}
