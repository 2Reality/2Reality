import {Component} from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  stub: Array<any> = new Array<any>(1, 2, 3, 4, 5, 6, 7, 8, 9)
}
