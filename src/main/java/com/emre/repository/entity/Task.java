package com.emre.repository.entity;

import com.emre.repository.entity.enums.EState;
import lombok.*;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "tbltask")
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100)
    private String name;
    @Column(length = 500)
    private String description;
    @Builder.Default
    @Enumerated(EnumType.STRING)
    private EState state = EState.TO_DO;
    private Long userId;

}
