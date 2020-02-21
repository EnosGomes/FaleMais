package br.com.vizir.telzir.falemais.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Plano {

  @Id
  @GeneratedValue
  private Long id;

  private String descricao;

  private Long minutos;

  public Plano() {
  }

  public Plano(String descricao, Long minutos) {
    this.descricao = descricao;
    this.minutos = minutos;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public Long getMinutos() {
    return minutos;
  }

  public void setMinutos(Long minutos) {
    this.minutos = minutos;
  }
  
  @Override
  public String toString() {
    return descricao;
  }

}
