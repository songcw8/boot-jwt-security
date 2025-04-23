package org.example.bootjwtsecurity.controller;

import org.example.bootjwtsecurity.model.entity.Team;
import org.example.bootjwtsecurity.repository.TeamRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/football")
public class FootBallController {

    private final TeamRepository teamRepository;

    public FootBallController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @GetMapping("/teams")
    public ResponseEntity<List<Team>> findAllTeams() {
        return ResponseEntity.ok().body(teamRepository.findAll());
    }
}
