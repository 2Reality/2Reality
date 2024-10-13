import {NgModule} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {EventManagerComponent} from "./admin/event-manager/event-manager.component";
import {HomeComponent} from "./home/home.component";
import {EventsComponent} from "./pages/events/events.component";
import {PeopleComponent} from "./pages/people/people.component";
import {PlacesComponent} from "./pages/places/places.component";
import {SignUpComponent} from "./pages/sign-up/sign-up.component";
import {LoginComponent} from "./pages/login/login.component";
import {AdminComponent} from "./admin/admin/admin.component";
import {HumanManagerComponent} from "./admin/human-manager/human-manager.component";


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'events', component: EventsComponent},
  {path: 'people', component: PeopleComponent},
  {path: 'places', component: PlacesComponent},
  {path: 'sign-up', component: SignUpComponent},
  {path: 'login', component: LoginComponent},
  {path: 'admin', component: AdminComponent},
  {path: 'event-manager', component: EventManagerComponent},
  {path: 'human-manager', component: HumanManagerComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
