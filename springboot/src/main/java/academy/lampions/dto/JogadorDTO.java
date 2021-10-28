package academy.lampions.dto;

import java.io.Serializable;

import academy.lampions.entity.Jogador;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JogadorDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
    private Integer numeroCamisa;
    private String posicao;

    public JogadorDTO(Jogador jogador) {
        super();
        this.id = jogador.getId();
        this.nome = jogador.getNome();
        this.numeroCamisa = jogador.getNumeroCamisa();
        this.posicao = jogador.getPosicao();
    }
}
