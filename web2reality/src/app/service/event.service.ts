import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {TREvent} from "../entities/event";

@Injectable({
  providedIn: 'root'
})
export class EventService {

  url = "http://localhost:8080/event";

  constructor(private httpClient: HttpClient) {
  }

  createEvent(event: TREvent): Observable<TREvent> {
    return this.httpClient.post<TREvent>(this.url + '/create', event)
  }

  recommendEvents(): Observable<Array<any>> {
    return this.httpClient.get<Array<any>>(this.url + '/recommend')
  }

  deleteEvent(id: number): Observable<any> {
    return this.httpClient.delete<any>(this.url + "/delete/" + id)
  }
}
