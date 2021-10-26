package academy.lampions.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Time {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column(nullable=false)
    private String nome;

    private LocalDate dataFundacao;
    private int titulos;
    private String escudo;
    private int pontos;
    private int vitorias;
    private int empates;
    private int derrotas;

    @OneToOne
    @JoinColumn(name="estadio_id")
    private Estadio estadio;

    @OneToMany(mappedBy = "time")
    private List<Jogador> jogador = new ArrayList<>();   
}
