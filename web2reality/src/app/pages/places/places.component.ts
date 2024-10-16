import { Component } from '@angular/core';
import {Recommendation} from "../../entities/recommendation";
import {EventService} from "../../service/event.service";
import {PlaceService} from "../../service/place.service";

@Component({
  selector: 'app-places',
  templateUrl: './places.component.html',
  styleUrls: ['./places.component.css']
})
export class PlacesComponent {

  recommenderResult: Array<Recommendation>;
  title = 'places'

  constructor(private placeService: PlaceService) {
    this.placeService.recommendPlaces().subscribe(response => {
      console.log(response)
      this.recommenderResult = response
    })
  }
}
