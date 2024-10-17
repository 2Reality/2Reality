import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Recommendation} from "../entities/recommendation";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class PlaceService {

  url = "http://localhost:8080/place";

  constructor(private httpClient: HttpClient) {
  }

  createPlace(place: Recommendation): Observable<Recommendation> {
    return this.httpClient.post<Recommendation>(this.url + '/create', place)
  }

  recommendPlaces(): Observable<Array<any>> {
    return this.httpClient.get<Array<any>>(this.url + '/recommend')
  }

  deletePlace(id: number): Observable<any> {
    return this.httpClient.delete<any>(this.url + "/delete/" + id)
  }
}
