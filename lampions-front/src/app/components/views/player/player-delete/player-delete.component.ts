import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { PlayerService } from '../player.service';

@Component({
  selector: 'app-player-delete',
  templateUrl: './player-delete.component.html',
  styleUrls: ['./player-delete.component.css']
})
export class PlayerDeleteComponent implements OnInit {

  teamId: Number = 0;

  constructor(
    public dialogRef: MatDialogRef<PlayerDeleteComponent>,
    @Inject(MAT_DIALOG_DATA) public data: Number,
    private service: PlayerService,
    private router: Router) { }

  ngOnInit(): void {
    this.findById();
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

  findById(): void {
    this.service.findById(this.data).subscribe((response) => {
      this.teamId = response.teamId;
    });
  }

  delete(): void {
    this.service.delete(this.data).subscribe((response) => {
      this.router.navigate([`team/details/${this.teamId}`]);
      this.onNoClick();
      this.service.message("Jogador deletado com sucesso!");
    }, err => {
      console.log(err);
      this.service.message('Não é possível deletar o jogador.')
    });
  }
}
