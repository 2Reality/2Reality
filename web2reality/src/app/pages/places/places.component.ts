import { Component } from '@angular/core';

@Component({
  selector: 'app-places',
  templateUrl: './places.component.html',
  styleUrls: ['./places.component.css']
})
export class PlacesComponent {

  recommendations: Array<any> = new Array<any>(1, 2, 3, 4, 5, 6, 7, 8, 9)
  title = 'places'
}
