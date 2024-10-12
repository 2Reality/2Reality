import {Component, Input} from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {

  @Input() activePage: string

  getStyle(page: string): string | any | null | undefined {
    let base: string = 'nav-link px-2 '
    return page == this.activePage ? base + 'link-secondary' : base + 'link-dark';
  }
}
