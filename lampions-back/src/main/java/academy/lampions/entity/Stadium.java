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
public class Stadium implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    
    @NotEmpty(message = "É obrigatório informar um nome!")
    @Length(min = 3, max = 45, message = "O nome deve ter no mínimo 3 e no máximo 45 caracteres")
    private String name;

    private String local;
    private Integer capacity;
    
    @OneToOne(mappedBy = "estadio")
    private Team team;   
    
    public Stadium(Stadium estadio) {
        super();
        this.id = estadio.getId();
        this.name = estadio.getName();
        this.local = estadio.getLocal();
        this.capacity = estadio.getCapacity();
    }
}