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
public class Time implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    
    @NotEmpty(message = "É obrigatório informar um nome!")
    @Length(min = 3, max = 45, message = "O nome deve ter no mínimo 3 e no máximo 45 caracteres")
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
