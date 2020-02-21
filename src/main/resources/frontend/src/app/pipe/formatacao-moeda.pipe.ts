import { Pipe, PipeTransform } from '@angular/core';
import { CurrencyPipe } from '@angular/common';

const currencyPipe = new CurrencyPipe('pt');

@Pipe({ name: 'moeda' })
export class FormatacaoMoedaPipe implements PipeTransform {

  transform(value: any, decimais: number = 2, ...args: any[]): any {
    if (value != null) {
      let formato = `1.${decimais}-${decimais}`;
      return currencyPipe.transform(value, 'BRL', 'symbol', formato);
    }
    return '-';
  }

}
