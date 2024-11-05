import {Component, Input} from '@angular/core';
import {DropdownOption} from "./dropdown-option";

@Component({
  selector: 'app-dropdown',
  templateUrl: './dropdown.component.html',
  styleUrls: ['./dropdown.component.css']
})
export class DropdownComponent {

  @Input() title: String
  @Input() options: Array<DropdownOption>

  isDropdownOpen = false;

  toggleDropdown() {
    this.isDropdownOpen = !this.isDropdownOpen;
  }
}
