package academy.lampions.dto;

import java.io.Serializable;
import java.time.LocalDate;

import academy.lampions.entity.Time;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(access=AccessLevel.PRIVATE)
public class TimeDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
    private LocalDate dataFundacao;
    private Integer titulos;
    private String escudo;
    private Integer pontos;
    private Integer vitorias;
    private Integer empates;
    private Integer derrotas;

    public TimeDTO(Time time) {
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
