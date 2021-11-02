package academy.lampions.dto;

import java.io.Serializable;

import academy.lampions.entity.Player;
import academy.lampions.entity.enums.PositionEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PlayerDTO implements Serializable {
  private static final long serialVersionUID = 1L;

  private Integer id;
  private String name;
  private Integer shirtNumber;
  private PositionEnum position;
  private Integer teamId;

  public PlayerDTO(Player player) {
    this.id = player.getId();
    this.name = player.getName();
    this.shirtNumber = player.getShirtNumber();
    this.position = player.getPosition();
    this.teamId = player.getTeam().getId();
  }
}
