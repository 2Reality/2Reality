import {Component, Input} from '@angular/core';
import {Recommendation} from "../../entities/recommendation";

@Component({
  selector: 'app-recommend-card',
  templateUrl: './recommend-card.component.html',
  styleUrls: ['./recommend-card.component.css']
})
export class RecommendCardComponent {

  @Input() recommendation: Recommendation

  title(): string {
    if (this.recommendation.fullname)
      return this.recommendation.fullname
    else if (this.recommendation.title)
      return this.recommendation.title

    return "no title"
  }

  getLink() {
    return '/' + this.recommendation.nickname
  }

  descriptionPart(): string {
    let description = this.recommendation.description;

    if (!description)
      return ''

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
