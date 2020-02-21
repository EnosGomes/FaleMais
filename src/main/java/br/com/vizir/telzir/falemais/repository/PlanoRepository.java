package br.com.vizir.telzir.falemais.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.vizir.telzir.falemais.model.Plano;

@Repository
public interface PlanoRepository extends CrudRepository<Plano, Long> {

  public Optional<Plano> findByMinutos(@Param("minutos") Long minutos);

}
