import { Component } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {Recommendation} from "../../entities/recommendation";
import {HumanService} from "../../service/human.service";
import {ImageService} from "../../service/image.service";

@Component({
  selector: 'app-human-manager',
  templateUrl: './human-manager.component.html',
  styleUrls: ['./human-manager.component.css']
})
export class HumanManagerComponent {

  humanForm: FormGroup
  image: any
  imageMessage: string
  recommenderResult: Array<Recommendation>

  constructor(
    private humanService: HumanService,
    private imageService: ImageService,
    private formBuilder: FormBuilder)
  {
    this.initForm()
  }

  initForm() {
    this.humanForm = this.formBuilder.group({
      fullname: [''],
      nickname: [''],
      description: [''],
      birthDate: [''],
      sex: [''],
      geo: [''],
      longitude: [''],
      latitude: [''],
      image: [null]
    });
  }

  createHuman() {
    let values = this.humanForm.value;
    let humanItem: Recommendation = {
      fullname: values.fullname,
      nickname: values.nickname,
      description: values.description,
      birthDate: values.birthDate,
      sex: values.sex,
      geo: values.geo,
      longitude: values.longitude,
      latitude: values.latitude
    }

    this.humanService.createHuman(humanItem).subscribe(response => {
      console.log(response)
      this.recommendHumans()
    })
  }

  recommendHumans() {
    this.humanService.recommendHumans().subscribe(response => {
      console.log(response)
      this.recommenderResult = response
    })
  }

  deleteHuman(id: number) {
    this.humanService.deleteHuman(id).subscribe(response => {
      console.log(response)
      this.recommendHumans()
    })
  }

  onImageUpload(event : any) {
    this.image = event.target.files[0]
    this.addImage()
  }

  addImage() {
    let imageData = new FormData();
    imageData.append('image', this.image, this.image.name)
    this.imageService.saveImage(imageData).subscribe(response => {
      this.imageMessage = response.answer
    })
  }
}
