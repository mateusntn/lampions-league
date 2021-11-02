import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Team } from '../../team/team.model';
import { Player } from '../player.model';
import { PlayerService } from '../player.service';

@Component({
  selector: 'app-player-update',
  templateUrl: './player-update.component.html',
  styleUrls: ['./player-update.component.css']
})
export class PlayerUpdateComponent implements OnInit {

  player: Player = {
    id: 0,
    name: '',
    shirtNumber: 0,
    position: '',
    teamId: 0
  }

  positions: String[] = ['Goleiro', 'Zagueiro', 'Lateral', 'Meia', 'Atacante'];

  constructor(private service: PlayerService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.player.id = Number(this.route.snapshot.paramMap.get("id")!);
    this.findById();
  }

  findById(): void {
    this.service.findById(this.player.id!).subscribe((response) => {
      console.log(response);
      this.player = response;
    });
  }

  update(): void {
    this.service.update(this.player).subscribe((response) => {
      this.router.navigate([`team/details/${this.player.teamId}`]);
      this.service.message("Jogador atualizado com sucesso");
    }, err => {
      this.service.message('Validar se todos os campos estão preenchidos corretamente!')
    });
  }

  changePosition(position: String) {
    console.log(position);
    this.player.position = position;
  }
}
