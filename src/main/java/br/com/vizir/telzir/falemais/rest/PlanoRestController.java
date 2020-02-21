package br.com.vizir.telzir.falemais.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vizir.telzir.falemais.model.Plano;
import br.com.vizir.telzir.falemais.service.PlanoService;

@RestController
@RequestMapping("/api/planos")
@CrossOrigin
public class PlanoRestController {

  private @Autowired PlanoService planoService;

  @GetMapping
  public ResponseEntity<Iterable<Plano>> obterTodosPlanos() {
    return ResponseEntity.ok(planoService.obterTodosPlanos());
  }

}
