package academy.lampions.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

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

import academy.lampions.entity.Estadio;
import academy.lampions.service.EstadioService;



@RestController
@RequestMapping(value = "/estadio")
public class EstadioController {
    @Autowired
    private EstadioService service;

    @GetMapping()
    public ResponseEntity<List<Estadio>> getAll() {
        List<Estadio> estadios = service.findAll();
        return ResponseEntity.ok().body(estadios);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Estadio> getById(@PathVariable Integer id) {
        Estadio estadio = service.findById(id);
        return ResponseEntity.ok().body(estadio);
    }

    @PostMapping()
    public ResponseEntity<Estadio> post(@Valid @RequestBody Estadio estadio) {
        service.create(estadio);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(estadio.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Estadio> update(@Valid @PathVariable Integer id, @RequestBody Estadio estadio) {
        Estadio novoEstadio = service.update(id, estadio);
        return ResponseEntity.ok().body(novoEstadio);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
