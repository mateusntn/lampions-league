package academy.lampions.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academy.lampions.entity.Estadio;
import academy.lampions.repository.EstadioRepository;

@Service
public class EstadioService {
    @Autowired
    private EstadioRepository repository;

    public List<Estadio> findAll() {
        return repository.findAll();
    }

    public Estadio findById(Integer id) {
        Optional<Estadio> estadio = repository.findById(id);
        return estadio.orElse(null);
    }

    public Estadio create(Estadio estadio) {
        estadio.setId(null);
        return repository.save(estadio);
    }

    public Estadio update(Integer id, Estadio novoEstadio) {
        Estadio estadio = findById(id);

        estadio.setNome(novoEstadio.getNome() != null ? novoEstadio.getNome() : estadio.getNome());
        estadio.setLocal(novoEstadio.getLocal() != null ? novoEstadio.getLocal() : estadio.getLocal());
        estadio.setCapacidade(novoEstadio.getCapacidade() != null ? novoEstadio.getCapacidade() : estadio.getCapacidade());


        return repository.save(estadio);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}