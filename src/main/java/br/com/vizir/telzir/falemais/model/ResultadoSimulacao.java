package br.com.vizir.telzir.falemais.model;

public class ResultadoSimulacao {

  private Simulacao simulacao;

  private Double semPlano;

  private Double comPlano;

  public Simulacao getSimulacao() {
    return simulacao;
  }

  public void setSimulacao(Simulacao simulacao) {
    this.simulacao = simulacao;
  }

  public Double getSemPlano() {
    return semPlano;
  }

  public void setSemPlano(Double semPlano) {
    this.semPlano = semPlano;
  }

  public Double getComPlano() {
    return comPlano;
  }

  public void setComPlano(Double comPlano) {
    this.comPlano = comPlano;
  }

}
