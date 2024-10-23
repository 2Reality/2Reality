import {Component} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {Recommendation} from "../../entities/recommendation";
import {EventService} from "../../service/event.service";

@Component({
  selector: 'app-event-manager',
  templateUrl: './event-manager.component.html',
  styleUrls: ['./event-manager.component.css']
})
export class EventManagerComponent {

  eventForm: FormGroup
  recommenderResult: Array<Recommendation>

  constructor(private eventService: EventService, public formBuilder: FormBuilder) {
    this.initForm()
  }

  initForm() {
    this.eventForm = this.formBuilder.group({
      title: [''],
      description: [''],
      start: [''],
      finish: [''],
      geo: [''],
      longitude: [''],
      latitude: ['']
    });
  }

  createEvent() {
    let values = this.eventForm.value;
    let eventItem: Recommendation = {
      title: values.title,
      description: values.description,
      start: values.start,
      finish: values.finish,
      geo: values.geo,
      longitude: values.longitude,
      latitude: values.latitude
    }

    this.eventService.createEvent(eventItem).subscribe(response => {
      console.log(response)
      this.recommendEvents()
    })
  }

  recommendEvents() {
    this.eventService.recommendEvents().subscribe(response => {
      console.log(response)
      this.recommenderResult = response
    })
  }

  deleteEvent(id: number) {
    this.eventService.deleteEvent(id).subscribe(response => {
      console.log(response)
      this.recommendEvents()
    })
  }
}
