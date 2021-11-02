import { Team } from "../team/team.model";

export interface Player {
  id?: Number;
  name: String;
  shirtNumber: Number;
  position: String;
  team: Team;
}