import {Component} from '@angular/core';
import {LocationService} from "../../service/location.service";
import {FormBuilder, FormGroup} from "@angular/forms";

@Component({
    selector: 'app-location-manager',
    templateUrl: './location-manager.component.html',
    styleUrls: ['./location-manager.component.css']
})
export class LocationManagerComponent {

    locationSearchForm: FormGroup
    locationCreationForm: FormGroup
    result: any

    constructor(private locationService: LocationService, public formBuilder: FormBuilder) {
        this.initForm()
    }

    initForm() {
        this.locationSearchForm = this.formBuilder.group({
            searchLongitude: [''],
            searchLatitude: [''],
            searchDistance: ['']
        })
        this.locationCreationForm = this.formBuilder.group({
            title: [''],
            longitude: [''],
            latitude: [''],
        });
    }

    near() {
        let values = this.locationSearchForm.value;
        this.locationService.getLocation(
            values.searchLongitude,
            values.searchLatitude,
            values.searchDistance
        )
            .subscribe(response => {
                console.log(response)
                this.result = response;
            })
    }

    create() {
        let values = this.locationCreationForm.value;
        this.locationService.create(
            values.longitude,
            values.latitude,
            values.title
        )
            .subscribe(response => {
                console.log(response);
            })
    }
}
