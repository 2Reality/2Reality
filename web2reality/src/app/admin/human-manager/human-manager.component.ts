import { Component } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {Recommendation} from "../../entities/recommendation";
import {HumanService} from "../../service/human.service";

@Component({
  selector: 'app-human-manager',
  templateUrl: './human-manager.component.html',
  styleUrls: ['./human-manager.component.css']
})
export class HumanManagerComponent {

  message: string
  humanForm: FormGroup
  recommenderResult: Array<Recommendation>

  constructor(private humanService: HumanService, public formBuilder: FormBuilder) {
    this.initForm()
  }

  initForm() {
    this.humanForm = this.formBuilder.group({
      fullname: [''],
      nickname: [''],
      description: [''],
      age: [''],
      sex: [''],
      geo: ['']
    });
  }

  createHuman() {
    let values = this.humanForm.value;
    let humanItem: Recommendation = {
      fullname: values.fullname,
      nickname: values.nickname,
      description: values.description,
      age: values.age,
      sex: values.sex,
      geo: values.geo
    }

    this.humanService.createHuman(humanItem).subscribe(response => {
      console.log(response)
      this.recommendHumans()
      this.message = "event " + response.title + " added";
    })
  }

  recommendHumans() {
    this.humanService.recommendHumans().subscribe(response => {
      console.log(response)
      this.recommenderResult = response
      this.message = ''
    })
  }

  deleteHuman(id: number) {
    this.humanService.deleteHuman(id).subscribe(response => {
      console.log(response)
      this.recommendHumans()
    })
  }
}
