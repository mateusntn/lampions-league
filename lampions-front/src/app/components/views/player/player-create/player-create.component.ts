import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Player } from '../player.model';
import { PlayerService } from '../player.service';

@Component({
  selector: 'app-player-create',
  templateUrl: './player-create.component.html',
  styleUrls: ['./player-create.component.css']
})
export class PlayerCreateComponent implements OnInit {

  player: Player = {
    id: 0,
    name: '',
    shirtNumber: 0,
    position: '',
    teamId: 0
  }

  positions: String[] = ['Goleiro', 'Zagueiro', 'Lateral', 'Meia', 'Atacante'];

  constructor(private service: PlayerService, private router: Router, private route: ActivatedRoute, private location: Location) { }

  ngOnInit(): void {
    this.player.teamId = Number(this.route.snapshot.paramMap.get("id")!);
  }

  create(): void {
    this.service.create(this.player).subscribe((response) => {
      this.location.back();
      this.service.message('Jogador cadastrado com sucesso!');
    }, err => {
      for(let i = 0; i < err.error.errors.length; i++) {
        this.service.message(err.error.errors[i].message)
      }
    })
  }

  changePosition(position: String) {
    this.player.position = position;
  }

  goBack() {
    this.location.back();
  }
}
