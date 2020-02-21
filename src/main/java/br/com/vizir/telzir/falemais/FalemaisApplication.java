package br.com.vizir.telzir.falemais;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.vizir.telzir.falemais.model.Ligacao;
import br.com.vizir.telzir.falemais.model.Plano;
import br.com.vizir.telzir.falemais.repository.LigacaoRepository;
import br.com.vizir.telzir.falemais.repository.PlanoRepository;

@SpringBootApplication
public class FalemaisApplication {

  public static void main(String[] args) {
    SpringApplication.run(FalemaisApplication.class, args);
  }

  @Bean
  CommandLineRunner init(LigacaoRepository ligacaoRepository, PlanoRepository planoRepository) {
    return args -> {

      Ligacao ligacao = new Ligacao("011", "016", 1.90);
      ligacaoRepository.save(ligacao);

      ligacao = new Ligacao("016", "011", 2.90);
      ligacaoRepository.save(ligacao);

      ligacao = new Ligacao("011", "017", 1.70);
      ligacaoRepository.save(ligacao);

      ligacao = new Ligacao("017", "011", 2.70);
      ligacaoRepository.save(ligacao);

      ligacao = new Ligacao("011", "018", 0.90);
      ligacaoRepository.save(ligacao);

      ligacao = new Ligacao("018", "011", 1.90);
      ligacaoRepository.save(ligacao);

      Plano plano = new Plano("FaleMais 30", 30L);
      planoRepository.save(plano);

      plano = new Plano("FaleMais 60", 60L);
      planoRepository.save(plano);

      plano = new Plano("FaleMais 120", 120L);
      planoRepository.save(plano);
    };
  }

}
