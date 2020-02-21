import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BaseService } from 'src/app/service/base.service';

@Injectable({
  providedIn: 'root'
})
export class LigacaoService extends BaseService {

  constructor(protected http: HttpClient) {
    super('/api/ligacoes');
  }

  obterTodosDestinos(): Observable<any> {
    return this.http.get(this.getApiLocation() + '/origens');
  }
  obterTodasOrigens(): Observable<any> {
    return this.http.get(this.getApiLocation() + '/destinos');
  }

}
