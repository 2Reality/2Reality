import { Injectable } from '@angular/core';
import {HttpEvent, HttpHandler, HttpHeaders, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {Observable} from "rxjs";
import {AuthenticationService} from "./authentication.service";

@Injectable()
export class InterceptorService implements HttpInterceptor {

  constructor(private authenticationService: AuthenticationService) { }
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    if (this.authenticationService.isUserLoggedInMock()) {
      const authReq = req.clone({
        headers: new HttpHeaders({
          // 'Content-Type': contentType,
          'Authorization': `Basic ${window.btoa(this.authenticationService.username + ":" + this.authenticationService.password)}`,
          'X-Requested-With': 'XMLHttpRequest',
          'Access-Control-Allow-Origin' : "*",
          'Access-Control-Allow-Methods' : 'GET,HEAD,OPTIONS,POST,PUT',
          'Access-Control-Allow-Headers': 'Origin, X-Requested-With, Content-Type, Accept, x-client-key, x-client-token, x-client-secret, Authorization'
        })
      });
      return next.handle(authReq);
    } else {
      return next.handle(req);
    }
  }
}
