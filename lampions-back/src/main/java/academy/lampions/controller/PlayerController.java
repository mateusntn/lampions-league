package academy.lampions.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import academy.lampions.dto.PlayerDTO;
import academy.lampions.entity.Player;
import academy.lampions.service.PlayerService;

@CrossOrigin
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
    public ResponseEntity<PlayerDTO> getById(@PathVariable Integer id) {
        Player player = service.findById(id);
        PlayerDTO playerDTO = new PlayerDTO(player);
        return ResponseEntity.ok().body(playerDTO);
    }

    @GetMapping(value = "/team")
    public ResponseEntity<List<PlayerDTO>> getAllByTeam(@RequestParam(value = "team") Integer teamId) {
      System.out.println(teamId);
      List<PlayerDTO> players = service.findAllByTeam(teamId).stream().map(obj -> new PlayerDTO(obj)).collect(Collectors.toList());
      return ResponseEntity.ok().body(players);
    }

    @PostMapping
    public ResponseEntity<Player> post(@RequestParam(value = "team")Integer teamId, @Valid @RequestBody Player player) {
        Player newPlayer = service.create(teamId, player);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/player/{id}").buildAndExpand(newPlayer.getId()).toUri();
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
