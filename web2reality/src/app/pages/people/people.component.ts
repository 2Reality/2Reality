import { Component } from '@angular/core';

@Component({
  selector: 'app-people',
  templateUrl: './people.component.html',
  styleUrls: ['./people.component.css']
})
export class PeopleComponent {

  recommendations: Array<any> = new Array<any>(1, 2, 3, 4, 5, 6, 7, 8, 9)
  title = 'people'
}
