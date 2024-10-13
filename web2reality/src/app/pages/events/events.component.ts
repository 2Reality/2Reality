import {Component, Input} from '@angular/core';
import {EventService} from "../../service/event.service";
import {Recommendation} from "../../entities/recommendation";

@Component({
  selector: 'app-events',
  templateUrl: './events.component.html',
  styleUrls: ['./events.component.css']
})
export class EventsComponent {

  title = 'events'
  recommenderResult: Array<Recommendation>
  constructor(private eventService: EventService) {
    this.eventService.recommendEvents().subscribe(response => {
      console.log(response)
      this.recommenderResult = response
    })
  }
}
