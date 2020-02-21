package br.com.vizir.telzir.falemais.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vizir.telzir.falemais.service.LigacaoService;

@RestController
@RequestMapping("/api/ligacoes")
@CrossOrigin
public class LigacaoRestController {

  private @Autowired LigacaoService ligacaoService;

  @GetMapping("/origens")
  public ResponseEntity<Iterable<String>> obterTodasOrigens() {
    return ResponseEntity.ok(ligacaoService.obterTodasOrigens());
  }

  @GetMapping("/destinos")
  public ResponseEntity<Iterable<String>> obterTodosDestinos() {
    return ResponseEntity.ok(ligacaoService.obterTodosDestinos());
  }

}
