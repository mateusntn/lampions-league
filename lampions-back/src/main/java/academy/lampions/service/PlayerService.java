package academy.lampions.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academy.lampions.entity.Player;
import academy.lampions.repository.PlayerRepository;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository repository;

    public List<Player> findAll(){
        return repository.findAll();
    }

    public Player findById(Integer id) {
        Optional<Player> player = repository.findById(id);
        return player.orElse(null);
    }

    public Player create(Player player) {
        player.setId(null);
        return repository.save(player);
    }

    public Player update(Integer id, Player newPlayer) {
        Player jogador = findById(id);

        jogador.setName(newPlayer.getName() != null ? newPlayer.getName() : jogador.getName());
        jogador.setShirtNumber(newPlayer.getShirtNumber() != null ? newPlayer.getShirtNumber() : jogador.getShirtNumber());
        jogador.setPosition(newPlayer.getPosition() != null ? newPlayer.getPosition() : jogador.getPosition());


        return repository.save(jogador);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}