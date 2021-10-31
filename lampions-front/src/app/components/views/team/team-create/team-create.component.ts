import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Team } from '../team.model';
import { TeamService } from '../team.service';

@Component({
  selector: 'app-team-create',
  templateUrl: './team-create.component.html',
  styleUrls: ['./team-create.component.css']
})
export class TeamCreateComponent implements OnInit {

  team: Team = {
    name: '',
    titles: 0,
    emblem: '',
    points: 0,
    victories: 0,
    draws: 0,
    defeats: 0
  }

  constructor(private service: TeamService, private router: Router) { }

  ngOnInit(): void {
  }

  create(): void {
    this.service.create(this.team).subscribe((response) => {
      this.router.navigate(['team'])
      this.service.message('Time cadastrado com sucesso!');
    }, err => {
      for(let i = 0; i < err.error.errors.length; i++) {
        this.service.message(err.error.errors[i].message)
      }
    })
  }

}
