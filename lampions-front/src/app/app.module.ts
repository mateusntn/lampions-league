import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import {IvyCarouselModule} from 'angular-responsive-carousel';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HeaderComponent } from './components/template/header/header.component';

import {MatToolbarModule} from '@angular/material/toolbar';
import {MatTableModule} from '@angular/material/table';
import { MatButtonModule } from "@angular/material/button";
import { MatInputModule } from "@angular/material/input";
import { MatFormFieldModule } from "@angular/material/form-field";
import { MatSnackBarModule } from "@angular/material/snack-bar";
import { FormsModule } from '@angular/forms';
import { MatSortModule } from "@angular/material/sort"
import { MatDialogModule } from "@angular/material/dialog"
import { MatSelectModule } from '@angular/material/select';

import { FooterComponent } from './components/template/footer/footer.component';
import { HomeComponent } from './components/views/home/home.component';
import { TeamReadComponent } from './components/views/team/team-read/team-read.component';
import { TeamCreateComponent } from './components/views/team/team-create/team-create.component';
import { TeamUpdateComponent } from './components/views/team/team-update/team-update.component';
import { TeamDetailsComponent } from './components/views/team/team-details/team-details.component';
import { TeamDeleteComponent } from './components/views/team/team-delete/team-delete.component';
import { PlayerUpdateComponent } from './components/views/player/player-update/player-update.component';
import { PlayerDeleteComponent } from './components/views/player/player-delete/player-delete.component';
import { PlayerCreateComponent } from './components/views/player/player-create/player-create.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    TeamReadComponent,
    TeamCreateComponent,
    TeamUpdateComponent,
    TeamDetailsComponent,
    TeamDeleteComponent,
    PlayerUpdateComponent,
    PlayerDeleteComponent,
    PlayerCreateComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatTableModule,
    HttpClientModule,
    MatButtonModule,
    MatInputModule,
    MatFormFieldModule,
    MatSnackBarModule,
    FormsModule,
    MatSortModule,
    MatDialogModule,
    MatSelectModule,
    IvyCarouselModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
