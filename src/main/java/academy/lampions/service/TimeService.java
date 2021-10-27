package academy.lampions.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academy.lampions.entity.Time;
import academy.lampions.repository.TimeRepository;

@Service
public class TimeService {
    @Autowired
    private TimeRepository repository;

    public List<Time> findAll() {
        return repository.findAll();
    }

    public Time findById(Integer id) {
        Optional<Time> time = repository.findById(id);
        return time.orElse(null);
    }

    public Time create(Time time) {
        time.setId(null);
        return repository.save(time);
    }

    public Time update(Integer id, Time novoTime) {
        Time time = findById(id);

        time.setNome(novoTime.getNome() != null ? novoTime.getNome() : time.getNome());
        time.setDataFundacao(novoTime.getDataFundacao() != null ? novoTime.getDataFundacao() : time.getDataFundacao());
        time.setTitulos(novoTime.getTitulos() != null ? novoTime.getTitulos() : time.getTitulos());
        time.setEscudo(novoTime.getEscudo() != null ? novoTime.getEscudo() : time.getEscudo());
        time.setPontos(novoTime.getPontos() != null ? novoTime.getPontos() : time.getPontos());
        time.setVitorias(novoTime.getVitorias() != null ? novoTime.getVitorias() : time.getVitorias());
        time.setEmpates(novoTime.getEmpates() != null ? novoTime.getEmpates() : time.getEmpates());
        time.setDerrotas(novoTime.getDerrotas() != null ? novoTime.getDerrotas() : time.getDerrotas());

        return repository.save(time);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
