import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {ToResponse} from "../entities/response";

@Injectable({
  providedIn: 'root'
})
export class ImageService {

  url = "http://localhost:8080/image"

  constructor(private httpClient: HttpClient) { }

  saveImage(imageData: any) : Observable<ToResponse> {
    return this.httpClient.post<ToResponse>(this.url + '/add', imageData)
  }
}
