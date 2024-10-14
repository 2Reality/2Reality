import { Component } from '@angular/core';
import {Recommendation} from "../../entities/recommendation";
import {HumanService} from "../../service/human.service";

@Component({
  selector: 'app-people',
  templateUrl: './people.component.html',
  styleUrls: ['./people.component.css']
})
export class PeopleComponent {

  recommenderResult: Array<Recommendation>;
  title = 'people'

  constructor(private humanService: HumanService) {
    this.humanService.recommendHumans().subscribe(response => {
      console.log(response)
      this.recommenderResult = response
    })
  }
}
