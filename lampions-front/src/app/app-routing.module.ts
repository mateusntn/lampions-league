import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/views/home/home.component';
import { PlayerCreateComponent } from './components/views/player/player-create/player-create.component';
import { PlayerUpdateComponent } from './components/views/player/player-update/player-update.component';
import { TeamCreateComponent } from './components/views/team/team-create/team-create.component';
import { TeamDetailsComponent } from './components/views/team/team-details/team-details.component';
import { TeamReadComponent } from './components/views/team/team-read/team-read.component';
import { TeamUpdateComponent } from './components/views/team/team-update/team-update.component';

const routes: Routes = [
  {
    path: "",
    component: HomeComponent
  },
  {
    path: "team",
    component: TeamReadComponent
  },
  {
    path: "team/details/:id",
    component: TeamDetailsComponent
  },
  {
    path: "team/create",
    component: TeamCreateComponent
  },
  {
    path: 'team/update/:id',
    component: TeamUpdateComponent
  },
  {
    path: 'player/update/:id',
    component: PlayerUpdateComponent
  },
  {
    path: 'player/create/:id',
    component: PlayerCreateComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
