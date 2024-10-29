import {Component} from '@angular/core';
import {AuthenticationService} from "../../auth/authentication.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  username: string;
  password: string;

  constructor(private authService: AuthenticationService, private router: Router) {
  }

  login() {
    this.authService.login(this.username, this.password).subscribe(response => {
      localStorage.setItem('token', response.token);
      console.log('Login successful, token:', response.token);
      this.authService.checkAuthentication()
      this.router.navigate(['/events']).finally(() => window.location.reload())
    });
  }
}
