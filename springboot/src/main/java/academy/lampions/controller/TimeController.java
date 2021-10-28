package academy.lampions.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import academy.lampions.dto.TimeDTO;
import academy.lampions.entity.Time;
import academy.lampions.service.TimeService;

@RestController
@RequestMapping(value = "/time")
public class TimeController {
    @Autowired
    private TimeService service;

    @GetMapping()
    public ResponseEntity<List<TimeDTO>> getAll() {
        List<Time> times = service.findAll();
        List<TimeDTO> timesDTO = times.stream().map(obj -> new TimeDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(timesDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Time> getById(@PathVariable Integer id) {
        Time time = service.findById(id);
        return ResponseEntity.ok().body(time);
    }

    @PostMapping()
    public ResponseEntity<Time> post(@RequestBody Time time) {
        service.create(time);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(time.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TimeDTO> update(@PathVariable Integer id, @RequestBody TimeDTO time) {
        Time novoTime = service.update(id, time);
        return ResponseEntity.ok().body(new TimeDTO(novoTime));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
