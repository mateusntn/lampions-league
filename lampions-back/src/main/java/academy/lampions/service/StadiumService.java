package academy.lampions.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academy.lampions.entity.Stadium;
import academy.lampions.repository.StadiumRepository;

@Service
public class StadiumService {
    @Autowired
    private StadiumRepository repository;

    public List<Stadium> findAll() {
        return repository.findAll();
    }

    public Stadium findById(Integer id) {
        Optional<Stadium> estadio = repository.findById(id);
        return estadio.orElse(null);
    }

    public Stadium create(Stadium estadio) {
        estadio.setId(null);
        return repository.save(estadio);
    }

    public Stadium update(Integer id, Stadium novoEstadio) {
        Stadium estadio = findById(id);

        estadio.setName(novoEstadio.getName() != null ? novoEstadio.getName() : estadio.getName());
        estadio.setLocal(novoEstadio.getLocal() != null ? novoEstadio.getLocal() : estadio.getLocal());
        estadio.setCapacity(novoEstadio.getCapacity() != null ? novoEstadio.getCapacity() : estadio.getCapacity());


        return repository.save(estadio);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}