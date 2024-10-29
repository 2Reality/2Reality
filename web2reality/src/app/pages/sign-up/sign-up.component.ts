import { Component } from '@angular/core';
import {AuthenticationService} from "../../auth/authentication.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent {

  username: string;
  password: string;

  constructor(private authService: AuthenticationService, private router: Router) {}

  register() {
    this.authService.register(this.username, this.password).subscribe(response => {
      console.log('Registration successful:', response);
      this.router.navigate(['/login'])
    });
  }
}
