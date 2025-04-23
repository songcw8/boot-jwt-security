package org.example.bootjwtsecurity.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
}
