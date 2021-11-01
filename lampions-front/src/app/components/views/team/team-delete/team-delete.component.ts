import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import { Router } from '@angular/router';
import { TeamService } from '../team.service';

@Component({
  selector: 'app-team-delete',
  templateUrl: './team-delete.component.html',
  styleUrls: ['./team-delete.component.css']
})
export class TeamDeleteComponent implements OnInit {

  constructor(
    public dialogRef: MatDialogRef<TeamDeleteComponent>,
    @Inject(MAT_DIALOG_DATA) public data: Number,
    private service: TeamService,
    private router: Router) {}

  ngOnInit(): void {
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

  delete(): void {
    this.service.delete(this.data).subscribe((response) => {
      this.router.navigate(["team"]);
      this.onNoClick();
      this.service.message("Time deletado com sucesso!");
    }, err => {
      this.service.message('Não é possível deletar o time.')
    });
  }
}
