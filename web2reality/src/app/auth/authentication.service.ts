import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Injectable} from "@angular/core";
import {AuthState} from "./auth-state";
import {User} from "./user";
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  private baseUrl = 'http://localhost:8080/auth';

  private authState: AuthState = AuthState.NOT_CHECKED

  private authenticatedUser: User

  constructor(private http: HttpClient, private router: Router) {
    this.checkAuthentication()
  }

  register(username: string, password: string): Observable<any> {
    return this.http.post(`${this.baseUrl}/sign-up`, {username, password});
  }

  login(username: string, password: string): Observable<any> {
    return this.http.post(`${this.baseUrl}/sign-in`, {username, password});
  }

  signOut() {
    console.log('sign out...');
    localStorage.removeItem('token');

    this.authenticatedUser = {}
    this.authState = AuthState.NOT_AUTHENTICATED
  }

  checkAuthentication() {
    this.http.get(`${this.baseUrl}/me`).subscribe(response => {
        this.authState = AuthState.AUTHENTICATED
        this.authenticatedUser = <User>response
        console.log('auth state check result: ' + AuthState[this.authState])
      },
      error => {
        this.authState = AuthState.NOT_AUTHENTICATED
        console.log('auth state check result: ' + AuthState[this.authState])
      })
  }

  isAuthenticated(): boolean {
    console.log('current auth status: ' + AuthState[this.authState])
    return this.authState in [AuthState.NOT_CHECKED, AuthState.NOT_AUTHENTICATED]
  }

  notChecked(): boolean {
    return this.authState == AuthState.NOT_CHECKED
  }

  getAuthenticatedUser(): User {
    return this.authenticatedUser;
  }
}
