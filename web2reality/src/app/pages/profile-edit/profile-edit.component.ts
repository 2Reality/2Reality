import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {ImageService} from "../../service/image.service";
import {HumanService} from "../../service/human.service";
import {Recommendation} from "../../entities/recommendation";
import {AuthenticationService} from "../../auth/authentication.service";

@Component({
  selector: 'app-profile-edit',
  templateUrl: './profile-edit.component.html',
  styleUrls: ['./profile-edit.component.css']
})
export class ProfileEditComponent implements OnInit {

  imageMessage: any
  image: File
  form: FormGroup
  human: Recommendation

  constructor(
    private humanService: HumanService,
    private authService: AuthenticationService,
    private imageService: ImageService,
    private formBuilder: FormBuilder,
    private router: Router)
  {
    this.initForm()
  }

  ngOnInit(): void {
    this.getHuman()
  }


  getHuman() {
    let nickname = this.authService.getAuthenticatedUser().nickname
    if (nickname) {
      this.humanService.getHuman(nickname).subscribe(response => {
        console.log(response)
        this.human = response
        this.updateHuman()
      })
    }
  }

  initForm() {
    this.form = this.formBuilder.group({
      image: [null],
      fullname: new FormControl('', Validators.required),
      nickname: new FormControl('', [Validators.required, Validators.minLength(3)]),
      password: [''],
      email: [''],
      birthDate: [''],
      sex: [''],
      geo: [''],
      latitude: [''],
      longitude: [''],
      description: [''],
    })
  }

  updateHuman() {
    this.form.patchValue({
      fullname: this.human.fullname,
      nickname: this.human.nickname,
      // password: this.settings.account.password,
      // email: this.settings.profile.email,
      birthDate: this.human.birthDate,
      description: this.human.description,
      sex: this.human.sex,
      geo: this.human.geo,
      latitude: this.human.latitude,
      longitude: this.human.longitude
    })
  }

  saveUpdates() {
    this.saveProfileFields()

    this.humanService.updateHuman(this.human).subscribe(() => {
      if (this.human.nickname) {
        this.authService.updateNickname(this.human.nickname)
      }
      this.router.navigate(['/' + this.human.nickname])
        .then(() => console.log("redirect to profile page"))
    })
  }

  saveProfileFields() {
    let formValues = this.form.value;

    this.human.fullname = formValues.fullname
    this.human.nickname = formValues.nickname
    // this.human.password = formValues.password
    // this.human.email = formValues.email
    this.human.birthDate = formValues.birthDate
    this.human.description = formValues.description
    this.human.sex = formValues.sex
    this.human.geo = formValues.geo
    this.human.longitude = formValues.longitude
    this.human.latitude = formValues.latitude
  }

  onImageUpload(event: any) {
    this.image = event.target.files[0]
    this.saveImage()
  }

  saveImage() {
    let imageData = new FormData();
    imageData.append('image', this.image, this.image.name)
    this.imageService.saveImage(imageData).subscribe(response => {
      this.imageMessage = response.answer
    })
  }

  get nickname() {
    return this.form.controls.nickname as FormControl
  }
}
