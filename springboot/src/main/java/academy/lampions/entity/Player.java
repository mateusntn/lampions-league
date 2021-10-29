package academy.lampions.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.validator.constraints.Length;

import academy.lampions.entity.enums.PositionEnum;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Player implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @NotEmpty(message = "É obrigatório informar um nome!")
    @Length(min = 3, max = 45, message = "O nome deve ter no mínimo 3 e no máximo 45 caracteres")    
    private String name;

    private Integer shirtNumber;

    @Enumerated(value = EnumType.STRING)
    private PositionEnum position;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="team_id")
    private Team team;   

    public Player(Player player) {
        super();
        this.id = player.getId();
        this.name = player.getName();
        this.shirtNumber = player.getShirtNumber();
        this.position = player.getPosition();
    }
}