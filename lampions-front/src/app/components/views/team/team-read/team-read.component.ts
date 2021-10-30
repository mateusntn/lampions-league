import { Component, OnInit } from '@angular/core';
import { Team } from '../team.model';
import { TeamService } from '../team.service';

@Component({
  selector: 'app-team-read',
  templateUrl: './team-read.component.html',
  styleUrls: ['./team-read.component.css']
})
export class TeamReadComponent implements OnInit {

  displayedColumns: string[] = ['name', 'points', 'victories', 'draws', 'defeats' ];
  teams: Team[] = [];

  constructor(private service: TeamService) { }

  ngOnInit(): void {
    this.findAll();
  }

  findAll() {
    this.service.findAll().subscribe((response) => {
      console.log(response);
      this.teams = response;
    });
  }

  
}
