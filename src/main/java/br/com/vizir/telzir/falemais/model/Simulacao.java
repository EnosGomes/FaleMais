package br.com.vizir.telzir.falemais.model;

public class Simulacao {

  private String origem;

  private String destino;

  private Long tempoLigacao;

  private Plano plano;

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

  public Long getTempoLigacao() {
    return tempoLigacao;
  }

  public void setTempoLigacao(Long tempoLigacao) {
    this.tempoLigacao = tempoLigacao;
  }

  public Plano getPlano() {
    return plano;
  }

  public void setPlano(Plano plano) {
    this.plano = plano;
  }

}
