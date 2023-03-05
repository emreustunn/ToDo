package com.emre.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "tbluser")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 20)
    private String name;
    @Column(length = 20)
    private String surname;
    @Column(length = 20)
    private String username;
    @Column(length = 20)
    private String password;
    private Long age;
    private String address;
    @ElementCollection
    private List<Long> tasksId;
}
