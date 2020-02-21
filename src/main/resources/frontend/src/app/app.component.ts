import { MatSnackBar } from '@angular/material';
import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { forkJoin } from 'rxjs';

import { LigacaoService } from './ligacao/service/ligacao.service';
import { PlanoService } from './plano/service/plano.service';
import { SimuladorService } from './simulador/service/simulador.service';

const SNACKBAR_DURATION = 2000;

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {

  @ViewChild('f') f: NgForm;
  displayedColumns: string[] = ['com_fale_mais', 'sem_fale_mais'];
  dataSource;

  /**
   * Titulo do App
   */
  title = 'FaleMais';

  /**
   * Lista de todos os planos FaleMais
   */
  planos: [];

  /**
   * Plano selecionado
   */
  plano: number;

  /**
   * Lista de todos os códigos cadastrados como origem
   */
  origens: [];

  /**
   * Origem selecionada
   */
  origem: String;

  /**
   * Lista de todos os códigos cadastrados como destino
   */
  destinos: [];

  /**
   * Destinos selecionados
   */
  destino: String;

  /**
   * Tempo da ligação em minutos
   */
  tempoLigacao: number;

  /**
   * Exibe o card de resultado com as informações vindas do backend
   */
  resultado = false;

  constructor(
    private planoService: PlanoService,
    private ligacaoService: LigacaoService,
    private simuladorService: SimuladorService,
    private snackBar: MatSnackBar) { }

  ngOnInit() {
    forkJoin(
      this.planoService.obterTodosPlanos(),
      this.ligacaoService.obterTodasOrigens(),
      this.ligacaoService.obterTodosDestinos()
    ).subscribe(([planos, origens, destinos]) => {
      this.planos = planos;
      this.origens = origens;
      this.destinos = destinos;
    });
  }

  calcularMinutos() {
    if (this.f.valid) {
      this.simuladorService.calcularMinutos({
        origem: this.origem,
        destino: this.destino,
        plano: this.plano,
        tempoLigacao: this.tempoLigacao
      }).subscribe(
        retorno => {
          this.snackBar.open('Cálculo realizado com sucesso', null, {
            duration: SNACKBAR_DURATION,
            panelClass: ['app-snackbar-ok']
          });
          this.resultado = true;
          this.dataSource = retorno;
        },
        error => {
          this.snackBar.open(error.message, null, {
            duration: SNACKBAR_DURATION,
            panelClass: ['app-snackbar-erro']
          });
        }
      );
    }
  }

  limparFormulario() {
    this.f.resetForm();

    this.plano = undefined;
    this.origem = undefined;
    this.destino = undefined;
    this.tempoLigacao = undefined;
    this.resultado = false;
  }

}
