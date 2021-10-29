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

import academy.lampions.entity.Stadium;
import academy.lampions.service.StadiumService;



@RestController
@RequestMapping(value = "/stadium")
public class StadiumController {
    @Autowired
    private StadiumService service;

    @GetMapping()
    public ResponseEntity<List<Stadium>> getAll() {
        List<Stadium> stadiums = service.findAll();
        return ResponseEntity.ok().body(stadiums);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Stadium> getById(@PathVariable Integer id) {
        Stadium stadium = service.findById(id);
        return ResponseEntity.ok().body(stadium);
    }

    @PostMapping()
    public ResponseEntity<Stadium> post(@Valid @RequestBody Stadium stadium) {
        service.create(stadium);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(stadium.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Stadium> update(@Valid @PathVariable Integer id, @RequestBody Stadium stadium) {
        Stadium newStadium = service.update(id, stadium);
        return ResponseEntity.ok().body(newStadium);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
