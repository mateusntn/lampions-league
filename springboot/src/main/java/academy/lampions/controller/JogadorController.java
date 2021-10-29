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

import academy.lampions.entity.Jogador;
import academy.lampions.service.JogadorService;

@RestController
@RequestMapping(value = "/jogador")
public class JogadorController {
    @Autowired
    private JogadorService service;

    @GetMapping
    public ResponseEntity<List<Jogador>> getAll() {
        List<Jogador> jogadores = service.findAll();
        return ResponseEntity.ok().body(jogadores);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Jogador> getById(@PathVariable Integer id) {
        Jogador jogador = service.findById(id);
        return ResponseEntity.ok().body(jogador);
    }

    @PostMapping
    public ResponseEntity<Jogador> post(@Valid @RequestBody Jogador jogador) {
        service.create(jogador);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(jogador.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Jogador> update(@Valid @PathVariable Integer id, @RequestBody Jogador jogador) {
        Jogador novoJogador = service.update(id, jogador);
        return ResponseEntity.ok().body(novoJogador);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
