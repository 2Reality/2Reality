import { Component } from '@angular/core';

@Component({
  selector: 'app-events',
  templateUrl: './events.component.html',
  styleUrls: ['./events.component.css']
})
export class EventsComponent {

  recommendations: Array<any> = new Array<any>(1, 2, 3, 4, 5, 6, 7, 8, 9)
  title = 'events'
}
