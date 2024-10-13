import { Component } from '@angular/core';
import {Recommendation} from "../../entities/recommendation";

@Component({
  selector: 'app-people',
  templateUrl: './people.component.html',
  styleUrls: ['./people.component.css']
})
export class PeopleComponent {

  recommendations: Array<Recommendation> = this.recommendationMock();
  title = 'people'

  recommendationMock() : Array<Recommendation> {
    return new Array<Recommendation>(
      {id: 1, description: "", finish: undefined, start: undefined, title: "Human mock 1"},
      {id: 2, description: "", finish: undefined, start: undefined, title: "Human mock 2"},
      {id: 3, description: "", finish: undefined, start: undefined, title: "Human mock 3"}
    )
  }
}
