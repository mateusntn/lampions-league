import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/views/home/home.component';
import { TeamCreateComponent } from './components/views/team/team-create/team-create.component';
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
    path: "team/create",
    component: TeamCreateComponent
  },
  {
    path: 'team/update/:id',
    component: TeamUpdateComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
