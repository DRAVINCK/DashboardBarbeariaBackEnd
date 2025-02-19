package com.dravinck.dashboardbarbearia.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
@Entity
@Table(name = "barbeiro")
public class Barbeiro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "barbeiro", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cliente> clientes;
}
