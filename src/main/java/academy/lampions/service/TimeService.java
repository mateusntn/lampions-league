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

    public Time findById(int id) {
        Optional<Time> time = repository.findById(id);
        return time.orElse(null);
    }
}
