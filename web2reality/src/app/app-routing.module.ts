import {NgModule} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {EventManagerComponent} from "./event-manager/event-manager.component";
import {HomeComponent} from "./home/home.component";
import {EventsComponent} from "./pages/events/events.component";
import {PeopleComponent} from "./pages/people/people.component";
import {PlacesComponent} from "./pages/places/places.component";
import {SignUpComponent} from "./pages/sign-up/sign-up.component";
import {LoginComponent} from "./pages/login/login.component";


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'events', component: EventsComponent},
  {path: 'people', component: PeopleComponent},
  {path: 'places', component: PlacesComponent},
  {path: 'event-manager', component: EventManagerComponent},
  {path: 'sign-up', component: SignUpComponent},
  {path: 'login', component: LoginComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
