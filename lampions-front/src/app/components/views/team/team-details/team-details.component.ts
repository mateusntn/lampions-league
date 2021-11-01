import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Team } from '../team.model';
import { TeamService } from '../team.service';

@Component({
  selector: 'app-team-details',
  templateUrl: './team-details.component.html',
  styleUrls: ['./team-details.component.css']
})
export class TeamDetailsComponent implements OnInit {

  team: Team = {
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

  edit(): void {
    this.router.navigate([`team/update/${this.team.id}`])
  }
}
