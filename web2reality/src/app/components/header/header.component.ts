import {Component, Input} from '@angular/core';
import {AuthenticationService} from "../../auth/authentication.service";
import {DropdownOption} from "../dropdown/dropdown-option";
import {Router} from "@angular/router";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {

  @Input() activePage: string

  authenticated: boolean

  constructor(private authService: AuthenticationService, private router: Router) {
    this.authenticated = this.authService.isAuthenticated()
  }

  getCurrentUser(): string {
    if (this.authService.notChecked()) {
      return '...'
    }

    if (this.authService.isAuthenticated()) {
      let user = this.authService.getAuthenticatedUser()
      return user.fullname ? user.fullname.split(' ')[0] : '...'
    }

    return '...'
  }

  signOut() {
    this.authService.signOut()
    this.authenticated = false
  }

  getStyle(page: string): string | any | null | undefined {
    let base: string = 'nav-link px-2 '
    return page == this.activePage ? base + 'link-secondary' : base + 'link-dark';
  }

  getOptions(): Array<DropdownOption> {
    let editOption: DropdownOption = {name: 'edit', action: () => this.router.navigateByUrl('edit') }
    let signOutOption: DropdownOption = {name: 'sign out', action: () => this.signOut()};

    return new Array<DropdownOption>(
      editOption,
      signOutOption
    );
  }
}
