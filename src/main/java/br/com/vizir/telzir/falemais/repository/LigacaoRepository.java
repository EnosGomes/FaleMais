package br.com.vizir.telzir.falemais.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.vizir.telzir.falemais.model.Ligacao;

@Repository
public interface LigacaoRepository extends CrudRepository<Ligacao, Long> {

  @Query("select distinct l.origem from Ligacao l")
  public Iterable<String> findAllOrigens();

  @Query("select distinct l.destino from Ligacao l")
  public Iterable<String> findAllDestinos();

  public Optional<Ligacao> findByOrigemAndDestino(@Param("origem") String origem, @Param("destino") String destino);
}
