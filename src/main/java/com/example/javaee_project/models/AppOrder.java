package com.example.javaee_project.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double totalCost;
    @ManyToMany
    private Collection<Product> products = new ArrayList<>();
    private Long userId;
}
