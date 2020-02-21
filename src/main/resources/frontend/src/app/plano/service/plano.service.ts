import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BaseService } from 'src/app/service/base.service';

@Injectable({
  providedIn: 'root'
})
export class PlanoService extends BaseService {

  constructor(protected http: HttpClient) {
    super('/api/planos');
  }

  obterTodosPlanos(): Observable<any> {
    return this.http.get(this.getApiLocation());
  }

}
