package br.com.vizir.telzir.falemais.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Ligacao {

  @Id
  @GeneratedValue
  private Long id;

  private String origem;

  private String destino;

  private Double preco;

  public Ligacao() {

  }

  public Ligacao(String origem, String destino, Double preco) {
    this.origem = origem;
    this.destino = destino;
    this.preco = preco;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getOrigem() {
    return origem;
  }

  public void setOrigem(String origem) {
    this.origem = origem;
  }

  public String getDestino() {
    return destino;
  }

  public void setDestino(String destino) {
    this.destino = destino;
  }

  public Double getPreco() {
    return preco;
  }

  public void setPreco(Double preco) {
    this.preco = preco;
  }
  
  @Override
  public String toString() {
    return origem + " - " + destino + " = " + preco + "/min"; 
  }

}
