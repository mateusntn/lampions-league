import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Team } from '../team.model';
import { TeamService } from '../team.service';

@Component({
  selector: 'app-team-update',
  templateUrl: './team-update.component.html',
  styleUrls: ['./team-update.component.css']
})
export class TeamUpdateComponent implements OnInit {

  team: Team = {
    id: 0,
    name: '',
    titles: 0,
    emblem: '',
    points: 0,
    victories: 0,
    draws: 0,
    defeats: 0
  }

  constructor(private service: TeamService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.team.id = Number(this.route.snapshot.paramMap.get("id")!);
    this.findById();
  }

  findById(): void {
    this.service.findById(this.team.id!).subscribe((response) => {
      this.team = response;
    });
  }

  update(): void {
    this.team.points = (this.team.victories * 3) + this.team.draws;
    this.service.update(this.team).subscribe((response) => {
      this.router.navigate(["team"]);
      this.service.message("Time atualizado com sucesso");
    }, err => {
      this.service.message('Validar se todos os campos estão preenchidos corretamente!')
    });
  }

}
