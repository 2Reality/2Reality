import { Component } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {Recommendation} from "../../entities/recommendation";
import {PlaceService} from "../../service/place.service";

@Component({
  selector: 'app-place-manager',
  templateUrl: './place-manager.component.html',
  styleUrls: ['./place-manager.component.css']
})
export class PlaceManagerComponent {

  placeForm: FormGroup
  recommenderResult: Array<Recommendation>

  constructor(private placeService: PlaceService, public formBuilder: FormBuilder) {
    this.initForm()
  }

  initForm() {
    this.placeForm = this.formBuilder.group({
      title: [''],
      description: [''],
      geo: ['']
    });
  }

  createPlace() {
    let values = this.placeForm.value;
    let placeItem: Recommendation = {
      title: values.title,
      description: values.description,
      geo: values.geo
    }

    this.placeService.createPlace(placeItem).subscribe(response => {
      console.log(response)
      this.recommendPlaces()
    })
  }

  recommendPlaces() {
    this.placeService.recommendPlaces().subscribe(response => {
      console.log(response)
      this.recommenderResult = response
    })
  }

  deletePlace(id: number) {
    this.placeService.deletePlace(id).subscribe(response => {
      console.log(response)
      this.recommendPlaces()
    })
  }
}
