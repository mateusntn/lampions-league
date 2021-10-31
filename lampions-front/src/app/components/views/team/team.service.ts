import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Team } from './team.model';
import { MatSnackBar } from '@angular/material/snack-bar';

@Injectable({
  providedIn: 'root'
})
export class TeamService {

  baseUrl: String = environment.baseUrl;

  constructor(private http: HttpClient, private _snack: MatSnackBar) { }

  findAll():Observable<Team[]> {
    const url = `${this.baseUrl}/team`
    return this.http.get<Team[]>(url)
  }

  findById(id: Number): Observable<Team> {
    const url = `${this.baseUrl}/team/${id}`
    return this.http.get<Team>(url)
  }

  create(team: Team): Observable<Team>{
    const url = `${this.baseUrl}/team`
    return this.http.post<Team>(url, team);
  }

  update(team: Team):Observable<void> {
    const url = `${this.baseUrl}/team/${team.id}`
    return this.http.put<void>(url, team)
  }

  message(str: String): void {
    this._snack.open(`${str}`, 'OK', {
      horizontalPosition: 'end',
      verticalPosition: 'top',
      duration: 3000
    })
  }
}
