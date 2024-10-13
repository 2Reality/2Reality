import { Component } from '@angular/core';
import {Recommendation} from "../../entities/recommendation";

@Component({
  selector: 'app-places',
  templateUrl: './places.component.html',
  styleUrls: ['./places.component.css']
})
export class PlacesComponent {

  recommendations: Array<Recommendation> = this.recommendationMock();
  title = 'places'

  recommendationMock() : Array<Recommendation> {
    return new Array<Recommendation>(
      {id: 1, description: "", finish: undefined, start: undefined, title: "Place mock 1"},
      {id: 2, description: "", finish: undefined, start: undefined, title: "Place mock 2"},
      {id: 3, description: "", finish: undefined, start: undefined, title: "Place mock 3"}
    )
  }
}
