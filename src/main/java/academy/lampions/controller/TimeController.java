package academy.lampions.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import academy.lampions.entity.Time;
import academy.lampions.service.TimeService;

@RestController
@RequestMapping(value = "/time")
public class TimeController {
    @Autowired
    private TimeService service;

    @GetMapping(value = "/")
    public ResponseEntity<List<Time>> getAll() {
        List<Time> time = service.findAll();
        return ResponseEntity.ok().body(time);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Time> getById(@PathVariable int id) {
        Time time = service.findById(id);
        return ResponseEntity.ok().body(time);
    }
}
