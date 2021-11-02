import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Observable } from 'rxjs/internal/Observable';
import { environment } from 'src/environments/environment';
import { Player } from './player.model';

@Injectable({
  providedIn: 'root'
})
export class PlayerService {

  baseUrl: String = environment.baseUrl;

  constructor(private http: HttpClient, private _snack: MatSnackBar) { }

  findAllByTeam(id: Number):Observable<Player[]> {
    const url = `${this.baseUrl}/player/team?team=${id}`
    return this.http.get<Player[]>(url)
  }
}