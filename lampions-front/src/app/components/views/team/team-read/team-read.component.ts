import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-team-read',
  templateUrl: './team-read.component.html',
  styleUrls: ['./team-read.component.css']
})
export class TeamReadComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  displayedColumns: string[] = ['team', 'points', 'victories', 'draws', 'defeats' ];
}
