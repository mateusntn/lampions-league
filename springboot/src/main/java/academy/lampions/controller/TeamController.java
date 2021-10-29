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

import academy.lampions.entity.Team;
import academy.lampions.service.TeamService;

@RestController
@RequestMapping(value = "/team")
public class TeamController {
    @Autowired
    private TeamService service;

    @GetMapping()
    public ResponseEntity<List<Team>> getAll() {
        List<Team> teams = service.findAll();
        return ResponseEntity.ok().body(teams);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Team> getById(@PathVariable Integer id) {
        Team team = service.findById(id);
        return ResponseEntity.ok().body(team);
    }

    @PostMapping()
    public ResponseEntity<Team> post(@Valid @RequestBody Team team) {
        service.create(team);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(team.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Team> update(@Valid @PathVariable Integer id, @RequestBody Team team) {
        Team newTeam = service.update(id, team);
        return ResponseEntity.ok().body(newTeam);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
