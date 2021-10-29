package academy.lampions.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Estadio implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    
    @NotEmpty(message = "É obrigatório informar um nome!")
    @Length(min = 3, max = 45, message = "O nome deve ter no mínimo 3 e no máximo 45 caracteres")
    private String nome;

    private String local;
    private Integer capacidade;
    
    @OneToOne(mappedBy = "estadio")
    private Time time;   
    
    public Estadio(Estadio estadio) {
        super();
        this.id = estadio.getId();
        this.nome = estadio.getNome();
        this.local = estadio.getLocal();
        this.capacidade = estadio.getCapacidade();
    }
}