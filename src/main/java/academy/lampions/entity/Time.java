package academy.lampions.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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
public class Time {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int Id;

    @Column(nullable=false)
    private String Nome;
    private LocalDate DataFundacao;
    private int Titulos;
    private String Escudo;
    private int Pontos;
    private int Vitorias;
    private int Empates;
    private int Derrotas;

}
