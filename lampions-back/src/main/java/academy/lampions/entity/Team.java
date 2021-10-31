package academy.lampions.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Team implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    
    @NotEmpty(message = "É obrigatório informar um nome!")
    @Length(min = 3, max = 45, message = "O nome deve ter no mínimo 3 e no máximo 45 caracteres")
    private String name;

    private LocalDate foundationDate;
    private Integer titles;
    private String emblem;
    private Integer points;
    private Integer Victories;
    private Integer draws;
    private Integer defeats;

    @OneToOne
    @JoinColumn(name="estadio_id")
    private Stadium estadio;

    @OneToMany(mappedBy = "team")
    private List<Player> player = new ArrayList<>();   

    public Team(Team team) {
        super();
        this.id = team.getId();
        this.name = team.getName();
        this.foundationDate = team.getFoundationDate();
        this.titles = team.getTitles();
        this.emblem = team.getEmblem();
        this.points = team.getPoints();
        this.Victories = team.getVictories();
        this.draws = team.getDraws();
        this.defeats = team.getDefeats();        
    }
}
