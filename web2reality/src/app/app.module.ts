import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {InterceptorService} from "./auth/interceptor.service";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {EventManagerComponent} from "./admin/event-manager/event-manager.component";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {AppRoutingModule} from "./app-routing.module";
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { EventsComponent } from './pages/events/events.component';
import { PeopleComponent } from './pages/people/people.component';
import { PlacesComponent } from './pages/places/places.component';
import { BaseRecommendationComponent } from './components/base-recommendation/base-recommendation.component';
import { MemberComponent } from './components/member/member.component';
import { SignUpComponent } from './pages/sign-up/sign-up.component';
import { LoginComponent } from './pages/login/login.component';
import { RecommendCardComponent } from './components/recommend-card/recommend-card.component';
import { HumanManagerComponent } from './admin/human-manager/human-manager.component';
import { AdminComponent } from './admin/admin/admin.component';
import { PlaceManagerComponent } from './admin/place-manager/place-manager.component';
import { LocationManagerComponent } from './admin/location-manager/location-manager.component';
import { HumanComponent } from './pages/human/human.component';
import { DropdownComponent } from './components/dropdown/dropdown.component';
import { ProfileEditComponent } from './pages/profile-edit/profile-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    EventManagerComponent,
    HomeComponent,
    HeaderComponent,
    FooterComponent,
    EventsComponent,
    PeopleComponent,
    PlacesComponent,
    BaseRecommendationComponent,
    MemberComponent,
    SignUpComponent,
    LoginComponent,
    RecommendCardComponent,
    HumanManagerComponent,
    AdminComponent,
    PlaceManagerComponent,
    LocationManagerComponent,
    HumanComponent,
    DropdownComponent,
    ProfileEditComponent,
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        ReactiveFormsModule,
        FormsModule,
    ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: InterceptorService,
      multi: true
    }],
  bootstrap: [AppComponent]
})
export class AppModule { }
