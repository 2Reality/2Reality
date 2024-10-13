import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Recommendation} from "../entities/recommendation";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class HumanService {

  url = "http://localhost:8080/human";

  constructor(private httpClient: HttpClient) {
  }

  createHuman(human: Recommendation): Observable<Recommendation> {
    return this.httpClient.post<Recommendation>(this.url + '/create', human)
  }

  recommendHumans(): Observable<Array<any>> {
    return this.httpClient.get<Array<any>>(this.url + '/recommend')
  }

  deleteHuman(id: number): Observable<any> {
    return this.httpClient.delete<any>(this.url + "/delete/" + id)
  }
}
