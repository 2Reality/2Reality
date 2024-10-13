import {Component, Input} from '@angular/core';
import {Recommendation} from "../../entities/recommendation";

@Component({
  selector: 'app-recommend-card',
  templateUrl: './recommend-card.component.html',
  styleUrls: ['./recommend-card.component.css']
})
export class RecommendCardComponent {

  @Input() recommendation: Recommendation

  descriptionPart(): string {
    let description = this.recommendation.description;

    return description.length < 40
      ? description
      : description.substring(0, 40) + "..."
  }

  time(): string {
    if (!this.recommendation.start)
      return ''

    let date = new Date(this.recommendation.start)
    return date.toDateString();
  }
}
