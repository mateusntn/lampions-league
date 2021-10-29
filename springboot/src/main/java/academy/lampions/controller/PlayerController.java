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

import academy.lampions.entity.Player;
import academy.lampions.service.PlayerService;

@RestController
@RequestMapping(value = "/player")
public class PlayerController {
    @Autowired
    private PlayerService service;

    @GetMapping
    public ResponseEntity<List<Player>> getAll() {
        List<Player> players = service.findAll();
        return ResponseEntity.ok().body(players);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Player> getById(@PathVariable Integer id) {
        Player player = service.findById(id);
        return ResponseEntity.ok().body(player);
    }

    @PostMapping
    public ResponseEntity<Player> post(@Valid @RequestBody Player player) {
        service.create(player);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(player.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Player> update(@Valid @PathVariable Integer id, @RequestBody Player player) {
        Player newPlayer = service.update(id, player);
        return ResponseEntity.ok().body(newPlayer);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
