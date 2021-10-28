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

import academy.lampions.dto.EstadioDTO;
import academy.lampions.entity.Estadio;
import academy.lampions.service.EstadioService;



@RestController
@RequestMapping(value = "/estadio")
public class EstadioController {
    @Autowired
    private EstadioService service;

    @GetMapping()
    public ResponseEntity<List<EstadioDTO>> getAll() {
        List<Estadio> estadios = service.findAll();
        List<EstadioDTO> estadiosDTO = estadios.stream().map(obj -> new EstadioDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(estadiosDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Estadio> getById(@PathVariable Integer id) {
        Estadio estadio = service.findById(id);
        return ResponseEntity.ok().body(estadio);
    }

    @PostMapping()
    public ResponseEntity<Estadio> post(@RequestBody Estadio estadio) {
        service.create(estadio);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(estadio.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<EstadioDTO> update(@PathVariable Integer id, @RequestBody EstadioDTO estadio) {
        Estadio novoEstadio = service.update(id, estadio);
        return ResponseEntity.ok().body(new EstadioDTO(novoEstadio));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
