package academy.lampions.entity;

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
public class Jogador {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int Id;

    @Column(nullable=false)
    private String Nome;

    @Column(nullable=false)
    private int NumeroCamisa;

    private String Posicao;
}
