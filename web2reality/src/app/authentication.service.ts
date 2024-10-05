import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {map, Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  url: string = 'http://localhost:8080'
  LOCAL_STORAGE_ATTRIBUTE_NAME = 'authenticatedUser'
  LOCAL_STORAGE_ATTRIBUTE_PASSWORD = 'authenticatedPassword'

  public username: any = null;
  public password: any = null;

  constructor(private httpClient: HttpClient) {
    this.username = this.getLoggedInUserName();
    this.password = this.getLoggedInUserPassword();
  }

  // register(account: Account): Observable<any> {
  //   return this.httpClient.post(this.url + "/registration", account)
  // }

  authenticate(username: any, password: any) {
    return this.httpClient.get(this.url + '/auth',
      {headers: {authorization: this.createBasicAuthToken(username, password)}})
      .pipe(
        map((res) => {
          this.username = username
          this.password = password
          this.registerSuccessfulLogin(username, password);
        }));
  }

  getHeaders() {
    return {authorization: this.createBasicAuthToken(this.username, this.password)}
  }

  createBasicAuthToken(username: String, password: String) {
    return 'Basic ' + window.btoa(username + ":" + password)
  }

  registerSuccessfulLogin(username: any, password: any) {
    localStorage.setItem(this.LOCAL_STORAGE_ATTRIBUTE_NAME, username)
    localStorage.setItem(this.LOCAL_STORAGE_ATTRIBUTE_PASSWORD, password)
  }

  logout() {
    localStorage.removeItem(this.LOCAL_STORAGE_ATTRIBUTE_NAME);
    localStorage.removeItem(this.LOCAL_STORAGE_ATTRIBUTE_PASSWORD)

    this.username = null
    this.password = null
  }

  isUserLoggedIn() {
    let user = localStorage.getItem(this.LOCAL_STORAGE_ATTRIBUTE_NAME)
    return user !== null
  }

  isUserLoggedInMock() {
    return true;
  }

  getLoggedInUserName() {
    return localStorage.getItem(this.LOCAL_STORAGE_ATTRIBUTE_NAME);
  }

  getLoggedInUserPassword() {
    return localStorage.getItem(this.LOCAL_STORAGE_ATTRIBUTE_PASSWORD)
  }
}
