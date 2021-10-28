package academy.lampions.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.AccessLevel;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@NoArgsConstructor
@AllArgsConstructor(access=AccessLevel.PRIVATE)
@Entity
public class Estadio {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Column(nullable=false)
    private String nome;

    private String local;
    private Integer capacidade;
    
    @OneToOne(mappedBy = "estadio")
    private Time time;

    public Estadio(Estadio estadio){
    super();
    this.id = estadio.getId();
    this.nome = estadio.getNome();
    this.local = estadio.getLocal();
    this.capacidade = estadio.getCapacidade();      
    }    
}