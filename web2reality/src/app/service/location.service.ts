import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
    providedIn: 'root'
})
export class LocationService {

    url = "http://localhost:8080/location";

    constructor(private httpClient: HttpClient) {
    }

    getLocation(longitude: number, latitude: number, distance: number): Observable<Array<any>> {
        const params = new HttpParams()
            .set('longitude', longitude)
            .set('latitude', latitude)
            .set('distance', distance);

        return this.httpClient.get<Array<any>>(this.url + '/near', {params: params})
    }

    create(longitude: number, latitude: number, title: string): Observable<any> {
        let location = {
            longitude: longitude,
            latitude: latitude,
            title: title
        }
        return this.httpClient.post<any>(this.url + '/create', location)
    }
}
