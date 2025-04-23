package org.example.bootjwtsecurity.controller;

import lombok.RequiredArgsConstructor;
import org.example.bootjwtsecurity.model.dto.TeamRequestDTO;
import org.example.bootjwtsecurity.model.entity.Team;
import org.example.bootjwtsecurity.repository.TeamRepository;
import org.example.bootjwtsecurity.service.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/football/teams")
@RequiredArgsConstructor
public class TeamController {

    private final TeamRepository teamRepository;
    private final TeamService teamService;

    @GetMapping
    public ResponseEntity<List<Team>> findAllTeams() {
        return ResponseEntity.ok().body(teamService.findAllTeams());
    }

    @PostMapping
    public ResponseEntity<Team> saveTeam(TeamRequestDTO dto) {
        Team team = teamService.saveTeam(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(team);
    }

}
