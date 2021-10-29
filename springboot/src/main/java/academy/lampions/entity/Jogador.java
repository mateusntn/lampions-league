package academy.lampions.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class Jogador implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @NotEmpty(message = "É obrigatório informar um nome!")
    @Length(min = 3, max = 45, message = "O nome deve ter no mínimo 3 e no máximo 45 caracteres")    
    private String nome;

    private Integer numeroCamisa;

    private String posicao;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="time_id")
    private Time time;   

    public Jogador(Jogador jogador) {
        super();
        this.id = jogador.getId();
        this.nome = jogador.getNome();
        this.numeroCamisa = jogador.getNumeroCamisa();
        this.posicao = jogador.getPosicao();
    }
}