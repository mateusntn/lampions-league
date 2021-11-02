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

  findById(id: Number): Observable<Player> {
    const url = `${this.baseUrl}/player/${id}`
    return this.http.get<Player>(url)
  }

  update(player: Player):Observable<void> {
    const url = `${this.baseUrl}/player/${player.id}`
    return this.http.put<void>(url, player)
  }

  message(str: String): void {
    this._snack.open(`${str}`, 'OK', {
      horizontalPosition: 'end',
      verticalPosition: 'top',
      duration: 3000
    })
  }
}
