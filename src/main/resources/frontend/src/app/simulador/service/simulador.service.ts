import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BaseService } from 'src/app/service/base.service';

@Injectable({
  providedIn: 'root'
})
export class SimuladorService extends BaseService {

  constructor(protected http: HttpClient) {
    super('/api/simulador');
  }

  public calcularMinutos(entity: any): Observable<any> {
    return this.http.post(this.getApiLocation() + '/calcular-minutos', entity);
  }

}
