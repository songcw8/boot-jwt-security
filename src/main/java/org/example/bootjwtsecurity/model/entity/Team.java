package org.example.bootjwtsecurity.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String location;
    @Column(nullable = false)
    private String coach;
    @Column(nullable = false)
    private String captain;
}
