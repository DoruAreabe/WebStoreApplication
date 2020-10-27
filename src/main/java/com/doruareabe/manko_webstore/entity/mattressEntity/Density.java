package com.doruareabe.manko_webstore.entity.mattressEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Density {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(unique = true)
    @NotBlank(message = "Nie może być puste")
    String densit;
    @OneToMany(mappedBy = "density", targetEntity = Mattress.class)
    Set<Mattress> mattresses = new LinkedHashSet<>();
}
