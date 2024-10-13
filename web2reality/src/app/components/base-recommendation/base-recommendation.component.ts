import {Component, Input} from '@angular/core';
import {Recommendation} from "../../entities/recommendation";

@Component({
  selector: 'app-base-recommendation',
  templateUrl: './base-recommendation.component.html',
  styleUrls: ['./base-recommendation.component.css']
})
export class BaseRecommendationComponent {

  @Input() recommendations: Array<Recommendation>
  @Input() title: string

}
