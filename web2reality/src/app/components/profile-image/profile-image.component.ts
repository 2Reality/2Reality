import {Component, Input} from '@angular/core';

@Component({
  selector: 'app-profile-image',
  templateUrl: './profile-image.component.html',
  styleUrls: ['./profile-image.component.css']
})
export class ProfileImageComponent {

  @Input() base64 : any
  @Input() score: any

  imageIsPresent(): boolean {
    return this.base64 && this.base64 != ''
  }

  getImage() {
    return 'data:image/jpeg;base64,' + this.base64
  }

  getScore() {
    return this.score
  }
}
