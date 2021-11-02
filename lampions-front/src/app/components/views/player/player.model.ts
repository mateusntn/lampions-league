import { Team } from "../team/team.model";

export interface Player {
  id?: number;
  name: String;
  shirtNumber: number;
  position: String;
  teamId: number;
}