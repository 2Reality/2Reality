import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {InterceptorService} from "./interceptor.service";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {EventManagerComponent} from "./event-manager/event-manager.component";
import {ReactiveFormsModule} from "@angular/forms";
import {AppRoutingModule} from "./app-routing.module";

@NgModule({
  declarations: [
    AppComponent,
    EventManagerComponent
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
