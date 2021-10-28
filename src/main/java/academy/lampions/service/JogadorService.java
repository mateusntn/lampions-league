package academy.lampions.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academy.lampions.entity.Jogador;
import academy.lampions.repository.JogadorRepository;

@Service
public class JogadorService {
    @Autowired
    private JogadorRepository repository;

    public List<Jogador> findAll(){
        return repository.findAll();
    }

    public Jogador findById(Integer id) {
        Optional<Jogador> jogador = repository.findById(id);
        return jogador.orElse(null);
    }

    public Jogador create(Jogador jogador) {
        jogador.setId(null);
        return repository.save(jogador);
    }

    public Jogador update(Integer id, Jogador novoJogador) {
        Jogador jogador = findById(id);

        jogador.setNome(novoJogador.getNome() != null ? novoJogador.getNome() : jogador.getNome());
        jogador.setNumeroCamisa(novoJogador.getNumeroCamisa() != null ? novoJogador.getNumeroCamisa() : jogador.getNumeroCamisa());
        jogador.setPosicao(novoJogador.getPosicao() != null ? novoJogador.getPosicao() : jogador.getPosicao());


        return repository.save(jogador);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}