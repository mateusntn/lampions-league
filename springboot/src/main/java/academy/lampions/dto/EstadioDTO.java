package academy.lampions.dto;

import java.io.Serializable;

import academy.lampions.entity.Estadio;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(access=AccessLevel.PRIVATE)
public class EstadioDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
    private String local;
    private Integer capacidade;

    public EstadioDTO(Estadio estadio) {
        super();
        this.id = estadio.getId();
        this.nome = estadio.getNome();
        this.local = estadio.getLocal();
        this.capacidade = estadio.getCapacidade();
    }
}
