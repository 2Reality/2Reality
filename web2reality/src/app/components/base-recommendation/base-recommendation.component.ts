import {Component, Input} from '@angular/core';

@Component({
  selector: 'app-base-recommendation',
  templateUrl: './base-recommendation.component.html',
  styleUrls: ['./base-recommendation.component.css']
})
export class BaseRecommendationComponent {

  @Input() recommendations: Array<any>
  @Input() title: string

}
