package academy.lampions.entity;

import java.io.Serializable;
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
public class Time implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable=false)
    private String nome;

    private LocalDate dataFundacao;
    private Integer titulos;
    private String escudo;
    private Integer pontos;
    private Integer vitorias;
    private Integer empates;
    private Integer derrotas;

    @OneToOne
    @JoinColumn(name="estadio_id")
    private Estadio estadio;

    @OneToMany(mappedBy = "time")
    private List<Jogador> jogador = new ArrayList<>();   

    public Time(Time time) {
        super();
        this.id = time.getId();
        this.nome = time.getNome();
        this.dataFundacao = time.getDataFundacao();
        this.titulos = time.getTitulos();
        this.escudo = time.getEscudo();
        this.pontos = time.getPontos();
        this.vitorias = time.getVitorias();
        this.empates = time.getEmpates();
        this.derrotas = time.getDerrotas();        
    }
}
