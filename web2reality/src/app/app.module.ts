import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {InterceptorService} from "./interceptor.service";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {EventManagerComponent} from "./event-manager/event-manager.component";
import {ReactiveFormsModule} from "@angular/forms";
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
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
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
